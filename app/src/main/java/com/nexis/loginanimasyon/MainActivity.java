package com.nexis.loginanimasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.nexis.loginanimasyon.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Databaseyardimci databaseyardimci;
    Button kaydol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        kaydol=findViewById(R.id.kayityap);

        databaseyardimci = new Databaseyardimci(this);

        binding.btngir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.mail.getText().toString();
                String sifre = binding.sifre.getText().toString();

                if(email.equals("") || sifre.equals("")){
                    Toast.makeText(MainActivity.this, "Email ve şifre boş olamaz", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean kontrol= databaseyardimci.checkEmailSifre(email, sifre);

                    if(kontrol == true ){
                        Toast.makeText(MainActivity.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext() , MainActivity2.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Kullanııcı Bulunamadı", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent2);

            }
        });
    }
}