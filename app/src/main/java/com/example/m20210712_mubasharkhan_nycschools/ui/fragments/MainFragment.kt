package com.example.m20210712_mubasharkhan_nycschools.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.m20210712_mubasharkhan_nycschools.databinding.FragmentMainBinding
import com.example.m20210712_mubasharkhan_nycschools.model.School
import com.example.m20210712_mubasharkhan_nycschools.network.ApiResponse
import com.example.m20210712_mubasharkhan_nycschools.network.Status
import com.example.m20210712_mubasharkhan_nycschools.network.Status.*
import com.example.m20210712_mubasharkhan_nycschools.ui.activities.MainActivity
import com.example.m20210712_mubasharkhan_nycschools.ui.adapter.SchoolAdapter
import com.example.m20210712_mubasharkhan_nycschools.viewmodel.MainViewModel
import javax.inject.Inject

class MainFragment : Fragment() {
    @Inject
    lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var adapter : SchoolAdapter

    private var mainBinding: FragmentMainBinding? = null
    private val binding get() = mainBinding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity?)!!.component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mainBinding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvRefresh.setOnClickListener { getAllSchoolsList() }
        getAllSchoolsList()
        binding.rvSchools.adapter = adapter
    }
    private fun getAllSchoolsList() {
        mainViewModel.getAllSchools().observe(viewLifecycleOwner, Observer {
            consumeResponse(it)
        })
    }

    private fun consumeResponse(response: ApiResponse<List<School>>) {
        updateViewsVisibility(response.status)
        when (response.status) {
            SUCCESS -> response.data?.let { adapter.addSchools(it) }
            ERROR -> response.message?.let { binding.tvError.text = it }
            else -> {
                println("Unknown Error")}
        }
    }

    private fun updateViewsVisibility(status: Status) {
        binding.progressBar.visibility = if (status === LOADING) View.VISIBLE else View.GONE
        binding.rvSchools.visibility = if (status === SUCCESS) View.VISIBLE else View.GONE
        binding.tvError.visibility = if (status === ERROR) View.VISIBLE else View.GONE
        binding.tvRefresh.visibility = if (status === ERROR) View.VISIBLE else View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        mainBinding = null
    }
}