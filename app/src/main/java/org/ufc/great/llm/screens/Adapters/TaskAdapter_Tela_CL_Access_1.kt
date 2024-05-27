package org.ufc.great.llm.screens.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetarefasllmtest.R


data class Task_CL_Access(val task: String, val date: String, var isChecked: Boolean)

class TaskAdapter_Tela_CL_Access_1(private val tasks: List<Task_CL_Access>) : RecyclerView.Adapter<TaskAdapter_Tela_CL_Access_1.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_tela_cl_access_1_list_item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentItem = tasks[position]
        holder.taskText.text = currentItem.task
        holder.dateText.text = currentItem.date
        holder.checkbox.isChecked = currentItem.isChecked

        // Adicionando descrição para a checkbox indicando o estado da tarefa
        val checkBoxDescription = if (currentItem.isChecked) {
            holder.itemView.context.getString(R.string.task_completed)
        } else {
            holder.itemView.context.getString(R.string.task_not_completed)
        }
        holder.checkbox.contentDescription = checkBoxDescription
    }

    override fun getItemCount() = tasks.size

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskText: TextView = itemView.findViewById(R.id.task_text)
        val dateText: TextView = itemView.findViewById(R.id.date_text)
        val checkbox: CheckBox = itemView.findViewById(R.id.checkbox)
    }
}