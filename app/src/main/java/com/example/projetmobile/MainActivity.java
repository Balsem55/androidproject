package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button3, button5;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button5 = findViewById(R.id.button5);
        button3 = findViewById(R.id.button3);
        username = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextTextPassword2);
        button3.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button5) {
            startactivity();
        } else if (view.getId() == R.id.button3) {
            enteractivity();
        }
    }

    public void startactivity() {
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }

    public void enteractivity() {
        String name = username.getText().toString();
        String pass = password.getText().toString();
        Log.d("test", name + " " + pass);
        Intent Y = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(Y);
    }
}