package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cadastrollmtest.R;

import org.ufc.great.llm.screens.Adapters.TaskAdapterAccess_Tela_3;

import java.util.ArrayList;
import java.util.Collections;

public class Tela_Access_3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_access_3);

        ListView listViewTasks = findViewById(R.id.list_view_tasks);
        TextView emptyView = findViewById(R.id.empty_view);

        ArrayList<Task_Tela_3> tasks = new ArrayList<>();
        tasks.add(new Task_Tela_3(false, "Tarefa 1", "2024-04-05"));
        tasks.add(new Task_Tela_3(false, "Tarefa 2", "2024-04-04"));
        tasks.add(new Task_Tela_3(false, "Tarefa 3", "2024-04-03"));

        // Ordenando as tarefas por data (decrescente)
        Collections.sort(tasks, (task1, task2) -> task2.getDate().compareTo(task1.getDate()));

        TaskAdapterAccess_Tela_3 adapter = new TaskAdapterAccess_Tela_3(this, tasks);
        listViewTasks.setAdapter(adapter);

        // Exibindo a empty view se não houver tarefas
        if (tasks.isEmpty()) {
            listViewTasks.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            listViewTasks.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
    }
}