package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

import com.example.menulateralllmtest.R;

public class Tela_CL_1 extends AppCompatActivity {

    private Button buttonSubmit;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cl1);

        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonCancel = findViewById(R.id.buttonCancel);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para enviar o formulário
                Toast.makeText(Tela_CL_1.this, "Formulário enviado!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para cancelar
                finish();
            }
        });
    }
}