// HomeFragment.kt
package com.example.to_doapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
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

        val addButton: ImageButton = view.findViewById(R.id.addTaskButton)
        addButton.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.main, AddTaskFragment())
                addToBackStack(null)
            }
        }

        return view
    }

    private fun getTaskList(): List<Task> {
        return listOf(
            Task("sport", "description"),
            Task("food", "description"),
            Task("study", "description"),
            Task("sport", "description"),
            Task("food", "description"),
            Task("study", "description"),
            Task("sport", "description"),
            Task("food", "description"),
            Task("study", "description"),
            Task("sport", "description"),
            Task("food", "description"),
            Task("study", "description"),
        )
    }
}