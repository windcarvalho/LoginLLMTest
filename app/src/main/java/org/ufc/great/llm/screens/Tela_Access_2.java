package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.cadastrollmtest.R;

public class Tela_Access_2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_access_2);

        EditText editTextFirstName = findViewById(R.id.editTextFirstName);
        EditText editTextLastName = findViewById(R.id.editTextLastName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        EditText editTextDOB = findViewById(R.id.editTextDOB);
        RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        Button buttonCancel = findViewById(R.id.buttonCancel);

        buttonSubmit.setOnClickListener(v -> {
            String firstName = editTextFirstName.getText().toString().trim();
            String lastName = editTextLastName.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            String dob = editTextDOB.getText().toString().trim();

            int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
            RadioButton selectedGender = findViewById(selectedGenderId);
            String gender = selectedGender != null ? selectedGender.getText().toString().trim() : "";

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || dob.isEmpty() || gender.isEmpty()) {
                Toast.makeText(Tela_Access_2.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {
                // Aqui você pode fazer o que quiser com os dados, como enviá-los para um servidor
                Toast.makeText(Tela_Access_2.this, "Cadastro enviado!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonCancel.setOnClickListener(v -> finish());
    }
}