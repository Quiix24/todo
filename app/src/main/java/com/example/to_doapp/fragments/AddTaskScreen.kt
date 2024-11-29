package com.example.to_doapp.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.to_doapp.R
import com.example.to_doapp.fragments.SignInFragment
import com.google.android.material.datepicker.MaterialDatePicker

class AddTaskScreen : AppCompatActivity() {

    private lateinit var taskNameEditText: EditText
    private lateinit var chooseDateButton: Button
    private lateinit var taskDescriptionEditText: EditText
    private lateinit var addTaskButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add_task_screen)

        // Initialize views
        taskNameEditText = findViewById(R.id.taskName)
        chooseDateButton = findViewById(R.id.chooseDateButton)
        taskDescriptionEditText = findViewById(R.id.taskDescription)
        addTaskButton = findViewById(R.id.addTaskButton)

        // Set up date picker for the "Choose Date" button
        chooseDateButton.setOnClickListener {
            showDatePicker()
        }

        // Set up the "Add Task" button
        addTaskButton.setOnClickListener {
            val taskName = taskNameEditText.text.toString()
            val taskDescription = taskDescriptionEditText.text.toString()

            if (taskName.isNotEmpty() && taskDescription.isNotEmpty()) {
                // Add task logic here, e.g., saving to a database or shared preferences
                // Display confirmation, toast, etc.
                showConfirmation("Task added successfully")

                // Navigate back to the home screen
                val intent = Intent(this, SignInFragment::class.java) // Replace with your home screen activity class
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Optional: clear the back stack
                startActivity(intent)
                finish() // Optional: finish the current activity to remove it from the stack
            } else {
                showConfirmation("Please fill in all fields")
            }
        }
    }

    private fun showDatePicker() {
        val datePicker = MaterialDatePicker.Builder.datePicker().build()
        datePicker.addOnPositiveButtonClickListener { date ->
            // Convert date to a readable format and display it (or use it as needed)
            val formattedDate = datePicker.headerText
            chooseDateButton.text = formattedDate
        }
        datePicker.show(supportFragmentManager, "DATE_PICKER")
    }

    private fun showConfirmation(message: String) {
        // Show a confirmation message (could be a Toast or Snackbar)
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }
}