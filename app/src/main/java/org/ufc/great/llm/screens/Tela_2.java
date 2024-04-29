package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.cadastrollmtest.R;

public class Tela_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_2);

        EditText editTextFirstName = findViewById(R.id.editTextFirstName);
        EditText editTextLastName = findViewById(R.id.editTextLastName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        EditText editTextDOB = findViewById(R.id.editTextDOB);
        RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        Button buttonCancel = findViewById(R.id.buttonCancel);

        buttonSubmit.setOnClickListener(v -> {
            String firstName = editTextFirstName.getText().toString();
            String lastName = editTextLastName.getText().toString();
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            String dob = editTextDOB.getText().toString();

            int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
            RadioButton selectedGender = findViewById(selectedGenderId);
            String gender = selectedGender.getText().toString();

            // Você pode fazer o que quiser com os dados aqui, como enviá-los para um servidor

            Toast.makeText(Tela_2.this, "Cadastro enviado!", Toast.LENGTH_SHORT).show();
        });

        buttonCancel.setOnClickListener(v -> finish());
    }
}