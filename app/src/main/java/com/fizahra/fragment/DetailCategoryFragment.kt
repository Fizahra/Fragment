package com.fizahra.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class DetailCategoryFragment : Fragment() {

    private lateinit var tvNameCate : TextView
    private lateinit var tvDescCate : TextView
    private lateinit var btnProf : Button
    private lateinit var btnDia : Button

    var desc: String?=null

    companion object{
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESC = "extra_desc"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvNameCate = view.findViewById(R.id.tv_cate_name)
        tvDescCate = view.findViewById(R.id.tv_cate_desc)
        btnProf = view.findViewById(R.id.btn_profile)
        btnDia = view.findViewById(R.id.btn_show_dialog)

        if(savedInstanceState != null){
            var descFromBundle = savedInstanceState.getString(EXTRA_DESC)
            desc = descFromBundle
        }
        if(arguments != null){
            val cateName = arguments?.getString(EXTRA_NAME)
            tvNameCate.text = cateName
            tvDescCate.text = desc
        }

        btnDia.setOnClickListener {
            val optionDialogFragment = OptionDialogFragment()
            val fragMana = childFragmentManager

            optionDialogFragment.show(fragMana, OptionDialogFragment::class.java.simpleName)
        }

        btnProf.setOnClickListener {
            val intent = Intent(requireActivity(), ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener = object : OptionDialogFragment.OnOptionDialogListener {
        override fun onOptionChosen(text: String?) {
            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
        }
    }
    }