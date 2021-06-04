package com.example.practice1.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice1.Adapters.UserAdapter
import com.example.practice1.MainViewModel
import com.example.practice1.MainViewModelFactory
import com.example.practice1.R
import com.example.practice1.Repository.Repository
import kotlinx.android.synthetic.main.fragment_home_user_list.*

class HomeUserListFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private lateinit var viewModel: MainViewModel
    private var userAdapter = UserAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvUserList.adapter = userAdapter
        rvUserList.layoutManager = LinearLayoutManager(requireActivity())
        rvUserList.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.HORIZONTAL
            )
        )
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getUsers()

        viewModel.myUsers.observe(requireActivity(), Observer { response->
            if (response.isSuccessful) {
                response.body()?.let { userAdapter.setData(it) }

            }else{
                Toast.makeText(requireContext(), response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_user_list, container, false)

    }

}