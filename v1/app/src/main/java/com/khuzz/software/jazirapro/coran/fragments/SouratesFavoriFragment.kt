package com.khuzz.software.jazirapro.coran.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khuzz.software.jazirapro.R
import com.khuzz.software.jazirapro.coran.SouratesHelper
import com.khuzz.software.jazirapro.coran.adapter.JuzzAdapter


class SouratesFavoriFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_juzz, container, false)

        val juzzRecyclerView = view.findViewById<RecyclerView>(R.id.juzz_recycler)

        juzzRecyclerView.setHasFixedSize(true)
        juzzRecyclerView.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false))

        val juzzList = arrayListOf<SouratesHelper>()

        juzzList.add(SouratesHelper("Juzz 01","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 02","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 03","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 04","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 05","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 06","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 07","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 08","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 09","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 10","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 11","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 12","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 13","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 14","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 15","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 16","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 17","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 18","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 19","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 20","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 21","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 22","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 23","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 24","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 25","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 26","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 27","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 28","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 29","mequoise",R.drawable.ic_coran))
        juzzList.add(SouratesHelper("Juzz 30","mequoise",R.drawable.ic_coran))

        juzzRecyclerView.adapter = JuzzAdapter(juzzList)
        juzzRecyclerView.setAdapter(juzzRecyclerView.adapter)
        return view
    }
}