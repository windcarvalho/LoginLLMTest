package org.ufc.great.llm.screens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginllmtest.R;

public class Tela_Login_Access_1 extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_access_1);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        editTextUsername.setContentDescription(getString(R.string.username_edit_text_description));
        editTextPassword.setContentDescription(getString(R.string.password_edit_text_description));

        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        // Implemente a lógica de autenticação aqui
        // Por exemplo, você pode validar as credenciais com um serviço de autenticação

        // Exemplo de mensagem de login bem-sucedida
        Toast.makeText(this, "Login bem-sucedido para " + username, Toast.LENGTH_SHORT).show();
    }

    // Método para lidar com a recuperação de senha
    public void forgotPassword(View view) {
        // Implemente a lógica para lidar com a recuperação de senha aqui
        Toast.makeText(this, "Recuperação de senha", Toast.LENGTH_SHORT).show();
    }
}