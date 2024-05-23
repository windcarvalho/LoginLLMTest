package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.cadastrollmtest.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Tela_1 extends AppCompatActivity {

    private ListView taskListView;
    private ArrayList<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_1);

        taskListView = findViewById(R.id.taskListView);
        taskList = new ArrayList<>();

        // Adicionando algumas tarefas de exemplo
        taskList.add(new Task("Comprar leite", "2024-04-10"));
        taskList.add(new Task("Ir ao médico", "2024-04-05"));
        taskList.add(new Task("Estudar para o exame", "2024-04-15"));

        // Ordenando a lista de tarefas com base na data (ordem decrescente)
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t2.getDate().compareTo(t1.getDate());
            }
        });

        TaskAdapter adapter = new TaskAdapter(this, taskList);
        taskListView.setAdapter(adapter);
    }
}


