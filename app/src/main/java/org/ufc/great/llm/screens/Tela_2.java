package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.cadastrollmtest.R;

import org.ufc.great.llm.screens.Adapters.TaskAdapter_Tela_2;

import java.util.ArrayList;
import java.util.Collections;

public class Tela_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_2);

        ArrayList<Task_Tela_2> tasks = new ArrayList<>();
        tasks.add(new Task_Tela_2("Tarefa 1", "2024-04-03", false));
        tasks.add(new Task_Tela_2("Tarefa 2", "2024-04-05", false));
        tasks.add(new Task_Tela_2("Tarefa 3", "2024-04-04", false));

        Collections.sort(tasks, (task1, task2) -> task2.getDate().compareTo(task1.getDate()));

        TaskAdapter_Tela_2 adapter = new TaskAdapter_Tela_2(this, tasks);

        ListView taskListView = findViewById(R.id.taskListView);
        taskListView.setAdapter(adapter);
    }

}