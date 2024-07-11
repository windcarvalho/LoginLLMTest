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

import org.ufc.great.llm.screens.Task_CL_2;

import java.util.List;

public class TaskAdapter_Tela_CL_Access_2 extends RecyclerView.Adapter<TaskAdapter_Tela_CL_Access_2.ViewHolder> {

    private List<Task_CL_2> taskList;
    private Context context;

    public TaskAdapter_Tela_CL_Access_2(List<Task_CL_2> taskList, Context context) {
        this.taskList = taskList;
        this.context = context;
    }

    @NonNull
    @Override
    public TaskAdapter_Tela_CL_Access_2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_tela_cl_access_2_list_item_task, parent, false);
        return new TaskAdapter_Tela_CL_Access_2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter_Tela_CL_Access_2.ViewHolder holder, int position) {
        Task_CL_2 task = taskList.get(position);
        holder.textTask.setText(task.getName());
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

            // Tornar os elementos acessíveis por teclado
            itemView.setFocusable(true);
            itemView.setClickable(true);
        }
    }
}
