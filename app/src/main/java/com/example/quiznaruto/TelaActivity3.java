package com.example.quiznaruto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class TelaActivity3 extends AppCompatActivity {

    Button buttonAvancarT3;
    RadioButton radioButtonUzu;
    Button  buttonConfere;
    EditText editTextNome;
    TextView textViewNome;
    String nome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);
        radioButtonUzu = findViewById(R.id.radioButtonUzu);
        buttonAvancarT3 = findViewById(R.id.buttonAvancarT3);
        textViewNome = findViewById(R.id.textViewNomeT3);
        buttonConfere = findViewById(R.id.buttonAvancarT3);
        editTextNome = findViewById(R.id.editTextNome);

        int erros;

        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");

        erros = bundle.getInt("erros");

        if(!nome.equals(""))
            textViewNome.setText(nome);

        buttonConfere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButtonUzu.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(TelaActivity3.this);
                    builder.setTitle("Acertou");
                    builder.setMessage("Como o naruto diria: TO CERTOOOO!!");
                    builder.show();

                    buttonAvancarT3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(TelaActivity3.this, TelaActivity4.class);
                            intent.putExtra("nome", textViewNome.getText().toString()); // PASSAR INFORMAÇÕES ENTRE ACTIVITIES
                            startActivity(intent);

                        }
                    });

                }
                else{

                    AlertDialog.Builder builder = new AlertDialog.Builder(TelaActivity3.this);
                    builder.setTitle("Errou");
                    builder.setMessage("Não foi dessa vez, mas o naruto não desistiria");
                    builder.show();
                    buttonAvancarT3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                    int erros = bundle.getInt("erros");
                                    erros++;
                                    Intent intent = new Intent(TelaActivity3.this, TelaActivity4.class);
                                    intent.putExtra("Erros", erros);
                                    intent.putExtra("nome", textViewNome.getText().toString()); // PASSAR INFORMAÇÕES ENTRE ACTIVITIES
                                    startActivity(intent);
                        }
                    });

                }
            }
        });



    }
}