package com.example.zabello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AgeInputActivity extends AppCompatActivity {

    private MyObject myObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_input);

        // Получаем объект MyObject из Intent
        myObject = (MyObject) getIntent().getSerializableExtra("myObject");
    }

    // Обработка нажатия кнопки "Назад"
    public void onBackClick(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Очистка стека до RegistrationActivity
        startActivity(intent);
    }

    // Обработка нажатия кнопки "Завершить регистрацию"
    public void onFinishClick(View view) {
        // Получаем данные из поля ввода возраста
        EditText ageField = findViewById(R.id.ageField);
        int age = Integer.parseInt(ageField.getText().toString());

        // Обновляем объект MyObject
        myObject.setAge(age);

        // Передаем объект в HealthTrackingActivity
        Intent intent = new Intent(this, HealthTrackingActivity.class);
        intent.putExtra("myObject", myObject);
        startActivity(intent);
    }
}