package com.example.quiznaruto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaActivity5 extends AppCompatActivity {
     TextView textViewErro;
     int erros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela5);

        Intent intent = new Intent(TelaActivity5.this, TelaActivity5.class);
        intent.putExtra("Erros", erros);

        if(!(erros == 0)) {
            textViewErro.setText(" " +erros);
        }


    }
}