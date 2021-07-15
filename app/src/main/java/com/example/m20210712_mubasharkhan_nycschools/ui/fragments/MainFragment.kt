package com.example.m20210712_mubasharkhan_nycschools.ui.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.navOptions
import com.example.m20210712_mubasharkhan_nycschools.R
import com.example.m20210712_mubasharkhan_nycschools.databinding.FragmentMainBinding
import com.example.m20210712_mubasharkhan_nycschools.model.School
import com.example.m20210712_mubasharkhan_nycschools.network.ApiResponse
import com.example.m20210712_mubasharkhan_nycschools.network.Status
import com.example.m20210712_mubasharkhan_nycschools.network.Status.*
import com.example.m20210712_mubasharkhan_nycschools.ui.activities.MainActivity
import com.example.m20210712_mubasharkhan_nycschools.ui.adapter.SchoolAdapter
import com.example.m20210712_mubasharkhan_nycschools.utils.ItemClickListener
import com.example.m20210712_mubasharkhan_nycschools.viewmodel.MainViewModel
import javax.inject.Inject

@Suppress("DEPRECATION")
class MainFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mainViewModel: MainViewModel by activityViewModels { viewModelFactory }

    @Inject
    lateinit var adapter: SchoolAdapter

    private var mainBinding: FragmentMainBinding? = null
    private val binding get() = mainBinding!!

    private val searchHandler = Handler()
    private var searchRunnable = Runnable{}

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
        observerSchoolList()
        initRecyclerView()
        binding.tvRefresh.setOnClickListener { mainViewModel.loadSchoolData() }
        mainViewModel.loadSchoolData()
        initSearchView()
    }

    private fun initRecyclerView() {
        adapter.setItemClickListener(object : ItemClickListener {
            override fun onItemClick(school: School) {
                mainViewModel.setSchool(school)
                openDetailFragment()
            }
        })
        binding.rvSchools.adapter = adapter
    }

    private fun observerSchoolList() {
        mainViewModel.getAllSchools().observe(viewLifecycleOwner, Observer {
            consumeResponse(it)
        })
    }

    private fun openDetailFragment() {
        findNavController(this).navigate(R.id.action_mainFragment_to_detailFragment,
                null,
                navOptions {
                    anim {
                        enter = android.R.animator.fade_in
                        exit = android.R.animator.fade_out
                    }
                }
        )
    }

    private fun consumeResponse(response: ApiResponse<List<School>>) {
        updateViewsVisibility(response.status)
        when (response.status) {
            SUCCESS -> response.data?.let { adapter.addSchools(it) }
            ERROR -> response.message?.let { binding.tvError.text = it }
            else -> {
                println("Unknown Error")
            }
        }
    }

    private fun updateViewsVisibility(status: Status) {
        binding.progressBar.visibility = if (status === LOADING) View.VISIBLE else View.GONE
        binding.rvSchools.visibility = if (status === SUCCESS) View.VISIBLE else View.GONE
        binding.tvError.visibility = if (status === ERROR) View.VISIBLE else View.GONE
        binding.tvRefresh.visibility = if (status === ERROR) View.VISIBLE else View.GONE
    }

    private fun initSearchView() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchHandler.removeCallbacks(searchRunnable)
                searchRunnable = Runnable {
                    adapter.filter.filter(newText)
                }
                searchHandler.postDelayed(searchRunnable, 500)
                return false
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        mainBinding = null
    }
}