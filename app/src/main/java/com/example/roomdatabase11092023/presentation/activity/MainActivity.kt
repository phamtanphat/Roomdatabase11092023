package com.example.roomdatabase11092023.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase11092023.R
import com.example.roomdatabase11092023.data.database.AppDatabase
import com.example.roomdatabase11092023.data.database.enity.Status
import com.example.roomdatabase11092023.data.database.enity.StatusEnum
import com.example.roomdatabase11092023.data.database.enity.Task
import com.example.roomdatabase11092023.data.repository.TaskRepository
import com.example.roomdatabase11092023.presentation.adapter.TaskAdapter
import com.example.roomdatabase11092023.presentation.dialog.AppDialog
import com.example.roomdatabase11092023.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private lateinit var recycleViewTask: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private var listTask: MutableList<Task> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.setTaskRepository(TaskRepository(this))
        recycleViewTask = findViewById(R.id.recycler_view_task)
        taskAdapter = TaskAdapter(listTask)
        recycleViewTask.adapter = taskAdapter

        observerData()
        event()


    }

    private fun event() {
        mainViewModel.queryTasks()
    }

    private fun observerData() {
        mainViewModel.getListTask().observe(this) {
            listTask.clear()
            listTask.addAll(it)
            taskAdapter.notifyDataSetChanged()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_add_task -> AppDialog.makeDialogCreateTask(this, onClickButtonSaveTask)
        }
        return true
    }

    private val onClickButtonSaveTask = fun(input: String) {
        mainViewModel.insertTask(input)
    }

    fun addStatusToDB() {
        CoroutineScope(Dispatchers.IO).launch {
            val db = AppDatabase.getInStance(this@MainActivity)

            db.appDao().addStatus(
                listOf(
                    Status(null, StatusEnum.START),
                    Status(null, StatusEnum.PROGRESS),
                    Status(null, StatusEnum.DONE),
                )
            )
        }
    }
}