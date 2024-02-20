package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.entity.Task
import com.example.todoapp.databinding.FragmentMainPageBinding
import com.example.todoapp.ui.adapter.TaskAdapter


class MainPageFragment : Fragment() {
    private lateinit var binding : FragmentMainPageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)
        binding.toolbarMain.title = " ToDo "

        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        val taskList = ArrayList<Task>()
        val t1 = Task(1,"Ödevler","Matematik Ödevini Yap")
        val t2 = Task(2,"Market Alışverişi","Süt alınacak")
        val t3 = Task(3,"ToDo App","Kart Tasarımı Yapılacak")
        val t4 = Task(4,"Dersler","Pazartesi dersine gidilecek")
        val t5 = Task(5,"Lastik","Kışlık lastik değişimi yapılacak")
        val t6 = Task(6,"Mail","Mail kontrol edilecek")
        val t7 = Task(7,"Task","Tasklar kontrol edilecek")
        taskList.add(t1)
        taskList.add(t2)
        taskList.add(t3)
        taskList.add(t4)
        taskList.add(t5)
        taskList.add(t6)
        taskList.add(t7)

        val taskAdapter = TaskAdapter(requireContext(),taskList)
        binding.rv.adapter = taskAdapter

        binding.searchView.setOnQueryTextListener(object  : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }
        })

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.taskRegisterPass)
        }
        return binding.root
    }

    fun search(searchingWord : String){
        Log.e("Task search",searchingWord)
    }
}

/*
binding.buttonDetay.setOnClickListener {
            val task = Task(1,"Ahmet","Ahmeti Ara")
            val gecis = MainPageFragmentDirections.taskDetailPass(task = task)
            Navigation.findNavController(it).navigate(gecis)
        }
 */