package com.example.exepamtodo_086;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class activity_daftar extends AppCompatActivity {

    EditText edtNama, edtEmail, edtPassword, edtepass;
    Button save;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        edtNama = findViewById(R.id.tinama);
        edtEmail = findViewById(R.id.tiemail);
        edtPassword = findViewById(R.id.tipass);
        edtepass = findViewById(R.id.tirespas);
        save = findViewById(R.id.buttonSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edtNama.getText().toString();

                if (edtNama.getText().toString().length() == 0)
                    edtNama.setError("Nama Harus diisi");
                else if (edtEmail.getText().toString().length() == 0)
                    edtEmail.setError("Email Harus diisi");
                else if (edtPassword.getText().toString().length()==0)
                    edtPassword.setError("Password Harus diisi");
                else if (edtepass.getText().toString().length() == 0)
                    edtepass.setError("Re Password Harus diisi");
                else
                {
                    if (edtPassword.getText().toString().equals(edtepass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Register Sukses",
                                Toast.LENGTH_LONG).show();
                        Bundle bn = new Bundle();
                        bn.putString("b", nama.trim());

                        Intent i = new Intent(getApplicationContext(), activity_isi_todo.class);
                        i.putExtras(bn);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view, "Password Incorrect", Snackbar.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}