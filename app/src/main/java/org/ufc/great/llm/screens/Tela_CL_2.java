package org.ufc.great.llm.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.cadastrollmtest.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tela_CL_2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cl2);

        recyclerView = findViewById(R.id.recycler_view_tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TaskAdapter(getTasks());
        recyclerView.setAdapter(adapter);
    }

    private List<Task_CL_2> getTasks() {
        // Aqui você pode carregar suas tarefas de onde você as armazena
        // Vou criar algumas tarefas fictícias para exemplo
        List<Task_CL_2> tasks = new ArrayList<>();
        tasks.add(new Task_CL_2("Tarefa 1", "2024-04-05"));
        tasks.add(new Task_CL_2("Tarefa 2", "2024-04-03"));
        tasks.add(new Task_CL_2("Tarefa 3", "2024-04-07"));
        // Ordenando as tarefas por data em ordem decrescente
        Collections.sort(tasks, new Comparator<Task_CL_2>() {
            @Override
            public int compare(Task_CL_2 t1, Task_CL_2 t2) {
                return t2.getDate().compareTo(t1.getDate());
            }
        });
        return tasks;
    }

    private static class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

        private List<Task_CL_2> tasks;

        TaskAdapter(List<Task_CL_2> tasks) {
            this.tasks = tasks;
        }

        @NonNull
        @Override
        public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tela_cl2_list_item_task, parent, false);
            return new TaskViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
            Task_CL_2 task = tasks.get(position);
            holder.checkbox.setChecked(task.isChecked());
            holder.textTask.setText(task.getName());
            holder.textDate.setText(task.getDate());
        }

        @Override
        public int getItemCount() {
            return tasks.size();
        }

        static class TaskViewHolder extends RecyclerView.ViewHolder {
            CheckBox checkbox;
            TextView textTask;
            TextView textDate;

            TaskViewHolder(@NonNull View itemView) {
                super(itemView);
                checkbox = itemView.findViewById(R.id.checkbox_task);
                textTask = itemView.findViewById(R.id.text_task);
                textDate = itemView.findViewById(R.id.text_date);
            }
        }
    }
}