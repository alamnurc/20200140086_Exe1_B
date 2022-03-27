package com.example.exepamtodo_086;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class activity_hasil extends AppCompatActivity {
    TextView hasilinputTask,hasilinputjenis,hasilinputwaktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil); //ini buat nyambungin

        hasilinputTask = findViewById(R.id.hasilTask);
        hasilinputjenis = findViewById(R.id.jenisTask);
        hasilinputwaktu = findViewById(R.id.waktuTask);

        Bundle bundle = getIntent().getExtras();

        String task = bundle.getString("b");
        String task2 = bundle.getString("c");
        String task3 = bundle.getString("d");

        hasilinputTask.setText(task);
        hasilinputjenis.setText(task2);
        hasilinputwaktu.setText(task3);
    }
}