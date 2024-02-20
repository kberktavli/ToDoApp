package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentDetailPageBinding


class DetailPageFragment : Fragment() {
    private lateinit var binding: FragmentDetailPageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_page, container, false)
        binding.detailPageFragment = this
        binding.taskDetailToolbarTitle = " Task Detail "

        val bundle: DetailPageFragmentArgs by navArgs()
        val receivedTask = bundle.task
        binding.taskObject = receivedTask //coding that sends our object


        return binding.root

    }
    fun buttonUpdate(task_id: Int, task_title: String, task_describe: String) {
        Log.e("Note", "Update $task_id - $task_title - $task_describe")
    }
}


/*
binding.editTextTitle.setText(receivedTask.task_title)
        binding.editTextDescribe.setText(receivedTask.task_describe)

        binding.buttonUpdateNote.setOnClickListener {
            val task_title = binding.editTextTitle.text.toString()
            val task_describe = binding.editTextDescribe.text.toString()
            buttonUpdate(receivedTask.task_id, task_title, task_describe)
        }
 */
