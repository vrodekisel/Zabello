package com.example.zabello;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DetailedInfoActivity extends AppCompatActivity {

    private MyObject myObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_info);

        // Получаем объект MyObject из Intent
        myObject = (MyObject) getIntent().getSerializableExtra("myObject");

        // Используем данные из объекта
        if (myObject != null) {
            // Вывести age пользователя
            int age = myObject.getAge();
        }
    }
}