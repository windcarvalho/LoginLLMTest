package org.ufc.great.llm.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetarefasllmtest.R
import org.ufc.great.llm.screens.Adapters.TaskAdapter_Tela_CL_1
import org.ufc.great.llm.screens.Adapters.Task_CL_1

class Tela_CL_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cl1)

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)

        val tasks = listOf(
            Task_CL_1("Fazer compras", "03/04/2024", false),
            Task_CL_1("Estudar para o exame", "05/04/2024", false),
            Task_CL_1("Enviar relatório", "10/04/2024", false)
        )

        val adapter = TaskAdapter_Tela_CL_1(tasks.sortedByDescending { it.date })
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }
}