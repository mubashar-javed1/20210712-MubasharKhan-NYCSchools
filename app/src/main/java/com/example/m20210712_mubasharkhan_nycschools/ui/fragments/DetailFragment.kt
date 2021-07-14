package com.example.m20210712_mubasharkhan_nycschools.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.m20210712_mubasharkhan_nycschools.databinding.FragmentDetailBinding
import com.example.m20210712_mubasharkhan_nycschools.ui.activities.MainActivity
import com.example.m20210712_mubasharkhan_nycschools.viewmodel.MainViewModel

class DetailFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()

    private var detailBinding: FragmentDetailBinding? = null
    private val binding get() = detailBinding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity?)!!.component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.selectedSchool.observe(viewLifecycleOwner, Observer {
            println(it.schoolName)
        })
    }
}