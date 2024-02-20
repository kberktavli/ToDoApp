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
import android.widget.DatePicker
import androidx.databinding.DataBindingUtil


class RegisterPageFragment : Fragment()  {
    private lateinit var binding : FragmentRegisterPageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_register_page,container,false)
        binding.registerPageFragment = this
        binding.taskRegisterToolbarTitle = "ToDo Register(Create)"
        return binding.root
    }
    fun buttonSave(task_title : String, task_describe : String) {
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