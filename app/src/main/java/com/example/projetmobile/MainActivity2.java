package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Button btns;
    EditText mail,user,motdepass,confirmer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        btns=findViewById(R.id.buttonsign);
        mail=findViewById(R.id.Email);
        user=findViewById(R.id.username);
        motdepass=findViewById(R.id.password);
        confirmer=findViewById(R.id.confirmer);
    }
    public void onClick(View V){
        String E=mail.getText().toString();
        String U=user.getText().toString();
        String M=motdepass.getText().toString();
        String C=confirmer.getText().toString();
        if(M==C && U.length()>10 && E.length()<40){
            Intent Y=new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(Y);
        }
    }
}