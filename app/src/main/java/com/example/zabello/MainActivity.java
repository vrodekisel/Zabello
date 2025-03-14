package com.example.zabello;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("onCreate", "method start");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i("onCreate", "method end");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart", "method start");
        Log.i("onStart", "method end");
        Button btn = findViewById(R.id.startButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("onResume", "method start");
        Log.i("onResume", "method start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause", "method start");
        Log.i("onPause", "method start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop", "method start");
        Log.i("onStop", "method start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy", "method start");
        Log.i("onDestroy", "method start");
    }

    public void onNextActivity(View view){
        EditText fiotxt = findViewById(R.id.registrationField1);
        EditText grouptxt = findViewById(R.id.registrationField2);
        EditText agetxt = findViewById(R.id.registrationField3);
        EditText marktxt = findViewById(R.id.registrationField4);

        String fio = fiotxt.getText().toString();
        String group = grouptxt.getText().toString();
        int age = Integer.parseInt(agetxt.getText().toString());
        int mark = Integer.parseInt(marktxt.getText().toString());

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("fio", fio);
        intent.putExtra("group", group);
        intent.putExtra("age", age);
        intent.putExtra("mark", mark);
        startActivity(intent);
    }
}