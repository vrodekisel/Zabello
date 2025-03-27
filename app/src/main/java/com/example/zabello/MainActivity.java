package com.example.zabello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onLoginClick(View view) {
        // Переход на активность "Отслеживание состояния здоровья"
        Intent intent = new Intent(this, HealthTrackingActivity.class);
        startActivity(intent);
    }

    public void onRegisterClick(View view) {
        // Получаем данные из полей ввода
        EditText loginField = findViewById(R.id.loginField);
        EditText passwordField = findViewById(R.id.passwordField);

        String login = loginField.getText().toString();
        String password = passwordField.getText().toString();

        // Создаем объект MyObject
        MyObject myObject = new MyObject(login, "", password, 0);
        // Пока email и age не заполнены
        // Передаем объект в RegistrationActivity
        Intent intent = new Intent(this, RegistrationActivity.class);
        intent.putExtra("myObject", myObject);
        startActivity(intent);
    }
}