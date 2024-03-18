package org.ufc.great.llm.screens;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginllmtest.R;

public class Tela_Login1 extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;
    private TextView textViewForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login1);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Implemente a lógica de autenticação aqui
                // Por exemplo, você pode validar as credenciais com um serviço de autenticação

                // Exemplo de mensagem de login bem-sucedida
                Toast.makeText(Tela_Login1.this, "Login bem-sucedido para " + username, Toast.LENGTH_SHORT).show();
            }
        });

        textViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implemente a lógica para lidar com a recuperação de senha aqui
                Toast.makeText(Tela_Login1.this, "Recuperação de senha", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
