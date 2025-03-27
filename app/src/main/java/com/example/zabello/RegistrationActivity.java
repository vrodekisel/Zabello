package com.example.zabello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private MyObject myObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Получаем объект MyObject из Intent
        myObject = (MyObject) getIntent().getSerializableExtra("myObject");

        // Заполняем поля данными из объекта
        if (myObject != null) {
            EditText loginField = findViewById(R.id.registrationLoginField);
            EditText passwordField = findViewById(R.id.registrationPasswordField);

            loginField.setText(myObject.getLogin());
            passwordField.setText(myObject.getPassword());
        }
    }

    // Обработка нажатия кнопки "Назад"
    public void onBackClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Очистка стека до MainActivity
        startActivity(intent);
    }

    // Обработка нажатия кнопки "Далее"
    public void onNextClick(View view) {
        // Получаем данные из полей ввода
        EditText emailField = findViewById(R.id.registrationEmailField);

        String email = emailField.getText().toString();

        // Обновляем объект MyObject
        myObject.setEmail(email);

        // Передаем объект в AgeInputActivity
        Intent intent = new Intent(this, AgeInputActivity.class);
        intent.putExtra("myObject", myObject);
        startActivity(intent);
    }
}