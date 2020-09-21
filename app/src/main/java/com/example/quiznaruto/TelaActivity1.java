package com.example.quiznaruto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


import static com.example.quiznaruto.R.id.buttonConfereT1;

public class TelaActivity1 extends AppCompatActivity {

    Button  buttonConfere;
    RadioButton  radioButtonIruka;
    TextView    textViewNome;
    EditText     editTextNome;
    String  nome;
    Button  buttonAvanced;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        buttonConfere = findViewById(R.id.buttonConfereT1);
        radioButtonIruka = findViewById(R.id.radioButtonIruka);
        editTextNome = findViewById(R.id.editTextNome);
        textViewNome = findViewById(R.id.textViewNome);
        buttonAvanced = findViewById(R.id.buttonAvançarT1);
        int erros;


        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");

        //passar a info
        if(!nome.equals("")) {
            textViewNome.setText(nome);
        }

        buttonConfere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButtonIruka.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(TelaActivity1.this);
                    builder.setTitle("Acertou");
                    builder.setMessage("Como o naruto diria: TO CERTOOOO!!");
                    builder.show();

                    buttonAvanced.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(TelaActivity1.this, TelaActivity2.class);
                            intent.putExtra("nome", textViewNome.getText().toString()); // PASSAR INFORMAÇÕES ENTRE ACTIVITIES
                            startActivity(intent);

                        }
                    });

                }
                else{

                    AlertDialog.Builder builder = new AlertDialog.Builder(TelaActivity1.this);
                    builder.setTitle("Errou");
                    builder.setMessage("Não foi dessa vez, mas o naruto não desistiria");
                    builder.show();
                    buttonAvanced.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                int erros = bundle.getInt("erros");
                                erros++;
                                Intent intent = new Intent(TelaActivity1.this, TelaActivity2.class);
                                intent.putExtra("nome", textViewNome.getText().toString()); // PASSAR INFORMAÇÕES ENTRE ACTIVITIES
                                startActivity(intent);

                        }
                    });
            }
            }
            });
}}