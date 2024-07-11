package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.listadetarefasllmtest.R;

import org.ufc.great.llm.screens.Adapters.TaskAdapter_Tela_CL_Access_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tela_CL_Access_2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter_Tela_CL_Access_2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cl_access_2);

        recyclerView = findViewById(R.id.recycler_view_tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TaskAdapter_Tela_CL_Access_2(getTasks(), this);
        recyclerView.setAdapter(adapter);
    }

    private List<Task_CL_2> getTasks() {
        // Aqui você pode carregar suas tarefas de onde você as armazena
        // Vou criar algumas tarefas fictícias para exemplo
        List<Task_CL_2> tasks = new ArrayList<>();
        tasks.add(new Task_CL_2("Tarefa 1", "2024-04-05"));
        tasks.add(new Task_CL_2("Tarefa 2", "2024-04-03"));
        tasks.add(new Task_CL_2("Tarefa 3", "2024-04-07"));
        return tasks;
    }
}