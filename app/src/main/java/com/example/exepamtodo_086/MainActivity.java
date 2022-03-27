package com.example.exepamtodo_086;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnRegister;
    EditText edemail, edpassword;
    String name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btSignin);
        btnRegister=findViewById(R.id.btRegister);

        edemail=findViewById (R.id.edEmail);
        edpassword= findViewById(R.id.edPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), activity_daftar.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edemail.getText().toString();

                password = edpassword.getText().toString();

                String Email="Alam";
                String pass="12345678";

                if (name.length()==0){
                    edemail.setError("Nama harus ada");
                    Toast.makeText(getApplicationContext(),"Data tidak boleh kosong",Toast.LENGTH_SHORT).show();

                }
                else if (password.length()==0){
                    Toast.makeText(MainActivity.this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else if (!name.equals(Email)){
                    Toast.makeText(MainActivity.this, "Nama Salah", Toast.LENGTH_SHORT).show();
                }
                else if (!password.equals(pass)){
                    Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                }
                else if (name.equals(Email)&&password.equals(pass)){
                    Toast.makeText(getApplicationContext(),"Login sukses",Toast.LENGTH_SHORT).show();

                    Bundle bundle = new Bundle();
                    bundle.putString("a",name.trim());
                    Intent intent = new Intent(getApplicationContext(),activity_isi_todo.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Gagal",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}