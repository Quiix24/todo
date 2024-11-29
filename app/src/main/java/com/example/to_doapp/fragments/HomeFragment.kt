package com.example.to_doapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.to_doapp.R
import com.example.to_doapp.adapters.TaskAdapter
import com.example.to_doapp.models.Task

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TaskAdapter(getTaskList())

        return view
    }

    private fun getTaskList(): List<Task> {
        return listOf(
            Task("sport", "sex"),
            Task("food", "sex"),
            Task("study", "sex"),
            Task("sport", "sex"),
            Task("food", "sex"),
            Task("study", "sex"),
            Task("sport", "sex"),
            Task("food", "sex"),
            Task("study", "sex"),
            Task("sport", "sex"),
            Task("food", "sex"),
            Task("study", "sex"),
        )
    }
}