package com.example.m20210712_mubasharkhan_nycschools.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.m20210712_mubasharkhan_nycschools.databinding.FragmentMainBinding
import com.example.m20210712_mubasharkhan_nycschools.model.School
import com.example.m20210712_mubasharkhan_nycschools.network.ApiResponse
import com.example.m20210712_mubasharkhan_nycschools.ui.activities.MainActivity
import com.example.m20210712_mubasharkhan_nycschools.viewmodel.MainViewModel
import javax.inject.Inject

class MainFragment : Fragment() {
    @Inject
    lateinit var mainViewModel: MainViewModel
    var binding: FragmentMainBinding? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity != null) (activity as MainActivity?)!!.component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.tvRefresh.setOnClickListener(v -> getAllSchoolsList());
        mainViewModel.getAllSchools().observe(viewLifecycleOwner, Observer {
            println(it.data)
        })
        //getAllSchoolsList();
    }
}