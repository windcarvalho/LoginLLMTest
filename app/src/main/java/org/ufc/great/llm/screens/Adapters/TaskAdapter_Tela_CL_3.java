package org.ufc.great.llm.screens.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listadetarefasllmtest.R;

import org.ufc.great.llm.screens.Task_CL_3;

import java.util.List;

public class TaskAdapter_Tela_CL_3 extends RecyclerView.Adapter<TaskAdapter_Tela_CL_3.ViewHolder> {

    private List<Task_CL_3> taskList;
    private Context context;

    public TaskAdapter_Tela_CL_3(List<Task_CL_3> taskList, Context context) {
        this.taskList = taskList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_tela_cl3_list_item_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task_CL_3 task = taskList.get(position);
        holder.textTask.setText(task.getTask());
        holder.textDate.setText(task.getDate());
        holder.checkboxTask.setChecked(task.isChecked());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTask, textDate;
        CheckBox checkboxTask;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTask = itemView.findViewById(R.id.text_task);
            textDate = itemView.findViewById(R.id.text_date);
            checkboxTask = itemView.findViewById(R.id.checkbox_task);
        }
    }
}