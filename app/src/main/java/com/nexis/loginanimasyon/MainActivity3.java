package com.nexis.loginanimasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nexis.loginanimasyon.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    ActivityMain3Binding binding;
    Databaseyardimci databaseyardimci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseyardimci = new Databaseyardimci(this);

        binding.buttonkayityap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.kaydolmail.getText().toString();
                String sifre = binding.kaydolsifre.getText().toString();
                String tekrarsifre = binding.kaydolsifretekrar.getText().toString();
                
                if(email.equals("") || sifre.equals("") || tekrarsifre.equals(""))
                    Toast.makeText(MainActivity3.this, "Bütün Alanları Doldurulmak Zorunlu", Toast.LENGTH_SHORT).show();
                else{
                    if(sifre.equals(tekrarsifre)){
                        Boolean checkEmail = databaseyardimci.checkEmail(email);

                        if(checkEmail == false ){
                            Boolean insert = databaseyardimci.insertData(email, sifre);

                            if (insert == true){
                                Toast.makeText(MainActivity3.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity3.this, "Kayıt Başarısız", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity3.this, "Bu Kullanıcı  Zaten Kayıtlı", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity3.this, "Geçersiz Parola", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}