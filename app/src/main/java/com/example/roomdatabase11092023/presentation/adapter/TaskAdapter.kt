package com.example.roomdatabase11092023.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase11092023.R
import com.example.roomdatabase11092023.data.database.enity.StatusEnum
import com.example.roomdatabase11092023.data.database.enity.Task
import com.example.roomdatabase11092023.util.StatusUtil

class TaskAdapter(
    private var listTask: List<Task>
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvIndex: TextView
        private var tvDescription: TextView
        private var tvStatus: TextView

        init {
            tvIndex = itemView.findViewById(R.id.text_view_index)
            tvDescription = itemView.findViewById(R.id.text_view_description)
            tvStatus = itemView.findViewById(R.id.text_view_status)
        }

        fun bind(task: Task?) {
            tvIndex.text = (task?.id ?: 1).toString()
            tvDescription.text = task?.description ?: ""
            tvStatus.apply {
                task?.idStatus?.let {
                    text = StatusUtil.getNameStatus(it)
                    background = when (it - 1) {
                        StatusEnum.START.ordinal -> context.getDrawable(R.drawable.background_border_blue_status)
                        StatusEnum.PROGRESS.ordinal -> context.getDrawable(R.drawable.background_border_yellow_status)
                        else -> context.getDrawable(R.drawable.background_border_red_status)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(listTask.getOrNull(position))
    }

    override fun getItemCount(): Int {
        return listTask.size
    }
}