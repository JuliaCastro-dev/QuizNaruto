package com.example.quiznaruto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import static com.example.quiznaruto.R.*;

public class MainActivity extends AppCompatActivity {

    EditText     editTextName;
    Button buttonAdvanced;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        buttonAdvanced = findViewById(id.buttonAvancar);
        editTextName = findViewById(R.id.editTextNome);



        buttonAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TelaActivity1.class);
                intent.putExtra("nome", editTextName.getText().toString()); // PASSAR INFORMAÇÕES ENTRE ACTIVITIES
                startActivity(intent);
            }
        });

    }
}