package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cadastrollmtest.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tela_Access_1 extends AppCompatActivity {
    private ListView taskListView;
    private ArrayList<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_access_1);

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

        TaskAdapterAccess adapter = new TaskAdapterAccess(this, taskList);
        taskListView.setAdapter(adapter);

        // Configurando um listener para lidar com cliques nos itens da lista
        taskListView.setOnItemClickListener((adapterView, view, position, id) -> {
            // Aqui você pode adicionar a lógica para lidar com o clique do item da lista
            Task clickedTask = taskList.get(position);
            Toast.makeText(Tela_Access_1.this, "Tarefa: " + clickedTask.getTaskName(), Toast.LENGTH_SHORT).show();
        });
    }
}