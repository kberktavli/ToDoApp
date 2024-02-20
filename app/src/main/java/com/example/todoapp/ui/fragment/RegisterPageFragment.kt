package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentRegisterPageBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Locale


class RegisterPageFragment : Fragment()  {
    private lateinit var binding : FragmentRegisterPageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = FragmentRegisterPageBinding.inflate(inflater,container,false)
        binding.toolbarRegister.title = "ToDo Register(Create)"

        binding.buttonSaveNote.setOnClickListener {
            val task_title = binding.editTextTitle.text.toString()
            val task_describe = binding.editTextDescribe.text.toString()
            save(task_title,task_describe)

        }
        return binding.root
    }

    fun save(task_title : String, task_describe : String) {
        Log.e("Note Register","$task_title - $task_describe")
    }
}


/* binding.buttonDatePicker.setOnClickListener {
     val dp = MaterialDatePicker.Builder.datePicker()
         .setTitleText("Pick Date")
         .build()
     dp.show(supportFragmentManager,"date")
     dp.addOnPositiveButtonClickListener {
         val df = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
         val date = df.format(it)
         binding.editTextDate.setText(date)
     }
 }

 */