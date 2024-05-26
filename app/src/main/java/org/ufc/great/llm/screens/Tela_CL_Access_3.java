package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cadastrollmtest.R;

import org.ufc.great.llm.screens.Adapters.TaskAdapter_Tela_CL_3;
import org.ufc.great.llm.screens.Adapters.TaskAdapter_Tela_CL_Access_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tela_CL_Access_3 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter_Tela_CL_Access_3 taskAdapter;
    private List<Task_CL_3> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cl_access_3);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskList = new ArrayList<>();
        populateTaskList(); // Método para adicionar tarefas à lista
        sortTaskList(); // Método para ordenar as tarefas por data
        taskAdapter = new TaskAdapter_Tela_CL_Access_3(taskList, this);
        recyclerView.setAdapter(taskAdapter);
    }

    private void populateTaskList() {
        // Adicione suas tarefas aqui
        taskList.add(new Task_CL_3("Fazer compras", "2024-04-05", false));
        taskList.add(new Task_CL_3("Estudar para o exame", "2024-04-07", false));
        taskList.add(new Task_CL_3("Ir ao médico", "2024-04-03", true));
    }

    private void sortTaskList() {
        // Ordena a lista de tarefas por data (do mais recente para o mais antigo)
        Collections.sort(taskList, (task1, task2) -> task2.getDate().compareTo(task1.getDate()));
    }
}