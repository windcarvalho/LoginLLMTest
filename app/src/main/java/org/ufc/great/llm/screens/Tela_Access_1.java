package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listadetarefasllmtest.R;

import org.ufc.great.llm.screens.Adapters.TaskAdapterAccess_Tela_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tela_Access_1 extends AppCompatActivity {
    private ListView taskListView;
    private ArrayList<Task_Tela_1> taskTela1List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_access_1);

        taskListView = findViewById(R.id.taskListView);
        taskTela1List = new ArrayList<>();

        // Adicionando algumas tarefas de exemplo
        taskTela1List.add(new Task_Tela_1("Comprar leite", "2024-04-10"));
        taskTela1List.add(new Task_Tela_1("Ir ao médico", "2024-04-05"));
        taskTela1List.add(new Task_Tela_1("Estudar para o exame", "2024-04-15"));

        // Ordenando a lista de tarefas com base na data (ordem decrescente)
        Collections.sort(taskTela1List, new Comparator<Task_Tela_1>() {
            @Override
            public int compare(Task_Tela_1 t1, Task_Tela_1 t2) {
                return t2.getDate().compareTo(t1.getDate());
            }
        });

        TaskAdapterAccess_Tela_1 adapter = new TaskAdapterAccess_Tela_1(this, taskTela1List);
        taskListView.setAdapter(adapter);

        // Configurando um listener para lidar com cliques nos itens da lista
        taskListView.setOnItemClickListener((adapterView, view, position, id) -> {
            // Aqui você pode adicionar a lógica para lidar com o clique do item da lista
            Task_Tela_1 clickedTaskTela1 = taskTela1List.get(position);
            Toast.makeText(Tela_Access_1.this, "Tarefa: " + clickedTaskTela1.getTaskName(), Toast.LENGTH_SHORT).show();
        });
    }
}