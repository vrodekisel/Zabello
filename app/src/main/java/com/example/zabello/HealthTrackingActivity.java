package com.example.zabello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HealthTrackingActivity extends AppCompatActivity {

    private MyObject myObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tracking);

        // Получаем объект MyObject из Intent
        myObject = (MyObject) getIntent().getSerializableExtra("myObject");

        // Используем данные из объекта (если нужно)
        if (myObject != null) {
            // Например, можно вывести логин пользователя
            String login = myObject.getLogin();
        }
    }

    // Обработка нажатия кнопки "Назад"
    public void onBackClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Очистка стека до MainActivity
        startActivity(intent);
    }

    // Обработка нажатия кнопки "Подробная информация"
    public void onDetailsClick(View view) {
        Intent intent = new Intent(this, DetailedInfoActivity.class);
        intent.putExtra("myObject", myObject); // Передаем объект в DetailedInfoActivity
        startActivity(intent);
    }
}