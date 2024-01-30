package com.example.roomdatabase11092023.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase11092023.data.database.enity.StatusEnum
import com.example.roomdatabase11092023.data.database.enity.Task
import com.example.roomdatabase11092023.data.repository.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private var taskRepository: TaskRepository? = null
    private var listTaskLiveData = MutableLiveData<List<Task>>()

    fun setTaskRepository(taskRepository: TaskRepository) {
        this.taskRepository = taskRepository
    }

    fun getListTask(): LiveData<List<Task>> {
        return listTaskLiveData
    }

    fun queryTasks() {
        CoroutineScope(Dispatchers.IO).launch {
            taskRepository?.getListTask()?.let {
                listTaskLiveData.postValue(it)
            }
        }
    }

    fun insertTask(description: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val task = Task(
                id = null,
                idStatus = StatusEnum.START.getIndex(),
                description = description,
                startDate = System.currentTimeMillis(),
                endDate = System.currentTimeMillis()
            )

            Log.d("pphat", task.toString())
//            taskRepository?.insertTask()?.let {
//                listTaskLiveData.postValue(it)
//            }
        }
    }
}