package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.cadastrollmtest.R

class Tela_Access_1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_access_1)

        val editTextFirstName = findViewById<EditText>(R.id.editTextFirstName)
        val editTextLastName = findViewById<EditText>(R.id.editTextLastName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val editTextDateOfBirth = findViewById<EditText>(R.id.editTextDateOfBirth)
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        val buttonCancel = findViewById<Button>(R.id.buttonCancel)

        buttonSubmit.setOnClickListener {
            val firstName = editTextFirstName.text.toString()
            val lastName = editTextLastName.text.toString()
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val dateOfBirth = editTextDateOfBirth.text.toString()
            val selectedGenderId = radioGroupGender.checkedRadioButtonId
            val selectedGender = findViewById<RadioButton>(selectedGenderId).text.toString()

            // Aqui você pode fazer o que quiser com os dados, como enviá-los para um servidor

            // Por enquanto, só exibiremos os dados na tela
            val userData = "Nome: $firstName $lastName\n" +
                    "E-mail: $email\n" +
                    "Senha: $password\n" +
                    "Data de Nascimento: $dateOfBirth\n" +
                    "Gênero: $selectedGender"
            showToast(userData)
        }

        buttonCancel.setOnClickListener {
            // Aqui você pode adicionar a lógica para cancelar o cadastro
            finish()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}