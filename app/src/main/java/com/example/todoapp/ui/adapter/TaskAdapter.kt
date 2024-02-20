package com.example.todoapp.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.entity.Task
import com.example.todoapp.databinding.FragmentMainPageBinding
import com.example.todoapp.databinding.TaskItemCellBinding
import com.example.todoapp.ui.fragment.MainPageFragmentDirections
import com.google.android.material.snackbar.Snackbar

class TaskAdapter(var mContext: Context, var taskList: List<Task>) :
    RecyclerView.Adapter<TaskAdapter.CardViewHolder>() {
    inner class CardViewHolder(var VH: TaskItemCellBinding) : RecyclerView.ViewHolder(VH.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding : TaskItemCellBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.task_item_cell, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val task = taskList.get(position)
        val vh = holder.VH

        /*
        vh.title.text = task.task_title
        vh.describe.text = task.task_describe
         */

        vh.taskObject = task

        vh.taskCellView.setOnClickListener {
            val pass = MainPageFragmentDirections.taskDetailPass(task = task)
            Navigation.findNavController(it).navigate(pass)
        }

        vh.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (vh.checkBox.isChecked()) {
                vh.checkBox.setButtonDrawable(R.drawable.checked_24)
                vh.title.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                vh.describe.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

            } else {
                vh.checkBox.setButtonDrawable(R.drawable.uncheck_24)
                vh.title.paintFlags = Paint.ANTI_ALIAS_FLAG
                vh.describe.paintFlags = Paint.ANTI_ALIAS_FLAG
            }
        }

        vh.delete.setOnClickListener {
            Snackbar.make(it,"Delete task ${task.task_title} ?",Snackbar.LENGTH_LONG)
                .setAction("Yes"){
                    deleteTask(task.task_id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun taskChecked(task_id: Int) {
        Log.e("Check", task_id.toString())
    }

    fun deleteTask(task_id: Int){
        Log.e("Delete", task_id.toString())
    }
}