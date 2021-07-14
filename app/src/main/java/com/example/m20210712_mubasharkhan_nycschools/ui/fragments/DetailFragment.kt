package com.example.m20210712_mubasharkhan_nycschools.ui.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.m20210712_mubasharkhan_nycschools.databinding.FragmentDetailBinding
import com.example.m20210712_mubasharkhan_nycschools.model.SatScore
import com.example.m20210712_mubasharkhan_nycschools.model.School
import com.example.m20210712_mubasharkhan_nycschools.ui.activities.MainActivity
import com.example.m20210712_mubasharkhan_nycschools.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.contect_layout.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_school.tv_schoolName

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
            updateViews(it)
            loadSatScore(it.dbn)
        })
    }

    private fun loadSatScore(dbn: String) {
        mainViewModel.getSatScore(dbn).observe(viewLifecycleOwner, Observer {
            it.data?.let { it1-> updateSatScore(it1[0]) }
            println(it)
        })
    }

    private fun updateViews(school: School) {
        tv_schoolName.text = school.schoolName
        tv_phone.text = school.phoneNumber
        tv_email.text = school.schoolEmail
        tv_address.text = school.location.split("(")[0]
        tv_website.text = school.website
        tv_overview.text = school.schoolOverview
        tv_extra_activities.text = school.extracurricularActivities
    }

    @SuppressLint("SetTextI18n")
    private fun updateSatScore(satScore: SatScore) {
        println(satScore)
        tv_num_of_sat_test_takers.text= "No. Of Test Takers: ${satScore.numOfSatTestTakers ?: "N/A"}"
        tv_sat_critical_reading_avg_score.text= "Critical Reading Average Score: ${satScore.numOfSatTestTakers ?: "N/A"}"
        tv_sat_math_avg_score.text= "Math Average Score: ${satScore.numOfSatTestTakers ?: "N/A"}"
        tv_sat_writing_avg_score.text= "Writing Average Score: ${satScore.numOfSatTestTakers ?: "N/A"}"
    }
}