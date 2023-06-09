package com.fizahra.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class CategoryFragment : Fragment(), View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetCate : Button = view.findViewById(R.id.btn_detail_cate)
        btnDetCate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_detail_cate){
            val detailCategoryFragment = DetailCategoryFragment()

            val bundle = Bundle()
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "Life Style")
            val desc = "Kategori ini berhubungan dengan life style"

            detailCategoryFragment.arguments = bundle
            detailCategoryFragment.desc = desc

            val fragMana = parentFragmentManager
            fragMana?.beginTransaction()?.apply {
                replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

}