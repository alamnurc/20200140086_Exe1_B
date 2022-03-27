package com.example.exepamtodo_086;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_isi_todo extends AppCompatActivity {

    TextView txEmail, enama;
    EditText edtask1, edjenisTask1, edtimetask1;
    String inpNama, task, jtask, ttask,nm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_todo);

        edtask1=findViewById (R.id.edtask);
        edjenisTask1= findViewById(R.id.edjenisTask);
        edtimetask1= findViewById(R.id.edtimetask);
        enama= findViewById(R.id.nama);

        txEmail = findViewById(R.id.nama2);

        Bundle view = getIntent().getExtras();
        inpNama = view.getString("a");
        enama.setText(inpNama);

        Bundle bnd = getIntent().getExtras();
        nm2 = view.getString("b");
        txEmail.setText(nm2);

        Bundle bundle = getIntent().getExtras();

        FloatingActionButton fab = findViewById(R.id.simpan);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = edtask1.getText().toString();
                jtask = edjenisTask1.getText().toString();
                ttask = edtimetask1.getText().toString();

                edtask1.setError("Nama Diperlukan");

                Bundle bn = new Bundle();
                bn.putString("b", task.trim());
                bn.putString("c", jtask.trim());
                bn.putString("d", ttask.trim());

                Intent i = new Intent(getApplicationContext(), activity_hasil.class);
                i.putExtras(bn);

                startActivity(i);
            }
        });
    }
}
