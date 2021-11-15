package com.example.szamologep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int a = 2, b = 5;
    Random veletlenSzam = new Random(System.currentTimeMillis());

    TextView textViewTask;
    TextView textViewStatus;
    Button btnNewTask;
    Button btnResult;
    EditText editTextResult;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTask = /*(TextView)*/ findViewById(R.id.textViewTask);
        btnNewTask = findViewById(R.id.btnNewTask);
        btnResult = findViewById(R.id.btnResult);
        textViewStatus = findViewById(R.id.textViewStatus);
        editTextResult = findViewById(R.id.editTextResult);

        a = veletlenSzam.nextInt(10)+1;
        b = veletlenSzam.nextInt(10)+1;

        textViewTask.setText(String.format("%1$d + %2$d = ", a, b));

    }

    @SuppressLint("DefaultLocale")
    public void onClick(View view) {
        if (view.getId() == btnNewTask.getId()) {
            a = veletlenSzam.nextInt(10)+1;
            b = veletlenSzam.nextInt(10)+1;
            textViewTask.setText(String.format("%1$d + %2$d = ", a, b));
            textViewStatus.setVisibility(View.INVISIBLE);
            editTextResult.setText("");
        }

        if (view.equals(btnResult)) {
            if (!editTextResult.getText().toString().equals("")) {
                if (a + b == Integer.parseInt(editTextResult.getText().toString())) {
                    textViewStatus.setText(R.string.textViewStatus);
                } else {
                    textViewStatus.setText(R.string.textViewStatusRossz);
                }
                textViewStatus.setVisibility(View.VISIBLE);
            }
        }
    }
}