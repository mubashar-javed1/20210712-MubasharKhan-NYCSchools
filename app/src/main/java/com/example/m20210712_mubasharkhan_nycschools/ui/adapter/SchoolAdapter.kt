package com.example.m20210712_mubasharkhan_nycschools.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.m20210712_mubasharkhan_nycschools.R
import com.example.m20210712_mubasharkhan_nycschools.di.scope.MainActivityScope
import com.example.m20210712_mubasharkhan_nycschools.model.School
import com.example.m20210712_mubasharkhan_nycschools.utils.ItemClickListener
import kotlinx.android.synthetic.main.item_school.view.*
import kotlinx.android.synthetic.main.contect_layout.view.*
import javax.inject.Inject

@MainActivityScope
class SchoolAdapter @Inject constructor() : RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder>() {
    private var schools : ArrayList<School> = arrayListOf()
    private var itemClickListener: ItemClickListener? = null

    class SchoolViewHolder(schoolView: View) : RecyclerView.ViewHolder(schoolView) {
        fun bind(school: School) {
            itemView.apply {
                tv_schoolName.text = school.schoolName
                tv_address.text = school.location.split("(")[0]
                tv_phone.text = school.phoneNumber
                tv_email.text = school.schoolEmail
                tv_website.text = school.website
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder =
            SchoolViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_school, parent, false))

    override fun getItemCount() : Int = schools.size

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        holder.bind(schools[position])
        holder.itemView.setOnClickListener { itemClickListener?.onItemClick(schools[position]) }
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun addSchools(schools: List<School>) {
        this.schools.apply {
            clear()
            addAll(schools)
        }
        notifyDataSetChanged()
    }
}