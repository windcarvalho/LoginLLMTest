package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.cadastrollmtest.R;

public class Tela_3 extends AppCompatActivity {
    private EditText editTextName, editTextLastName; // Adicione outros campos conforme necessário
    private Button buttonSubmit, buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_3);

        // Inicialização dos componentes da interface
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        // Inicialize outros campos e botões conforme necessário

        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonCancel = findViewById(R.id.buttonCancel);

        // Define os ouvintes de clique para os botões
        buttonSubmit.setOnClickListener(view -> {
            // Lógica para enviar o formulário
        });

        buttonCancel.setOnClickListener(view -> {
            // Lógica para cancelar o cadastro
        });
    }
}