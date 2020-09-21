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

public class TelaActivity2 extends AppCompatActivity {

    Button   buttonAvancarT2;
    Button buttonConfere;
    RadioButton  radioButtonMina;
    EditText     editTextNome;
    TextView     textViewNome;
    String nome = "";
    int erros;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        buttonAvancarT2 = findViewById(R.id.buttonAvancarT2);
        radioButtonMina = findViewById(R.id.radioButtonMina);
        buttonConfere = findViewById(R.id.buttonConfereT2);

        editTextNome = findViewById(R.id.editTextNome);
        textViewNome = findViewById(R.id.textViewT2);

        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");

        final int erros = bundle.getInt("erros");

        if(!nome.equals(""))
            textViewNome.setText(nome);

        buttonConfere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TelaActivity2.this);
                if(radioButtonMina.isChecked()) {
                    builder.setTitle("Acertou");
                    builder.setMessage("Como o naruto diria: TO CERTOOOO!!");
                    builder.show();

                    buttonAvancarT2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(TelaActivity2.this, TelaActivity3.class);
                            intent.putExtra("nome", textViewNome.getText().toString()); // PASSAR INFORMAÇÕES ENTRE ACTIVITIES
                            startActivity(intent);

                        }
                    });

                }
                else{

                    builder.setTitle("Errou");
                    builder.setMessage("Não foi dessa vez, mas o naruto não desistiria");
                    builder.show();
                    buttonAvancarT2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int erros = bundle.getInt("erros");
                            Intent intent = new Intent(TelaActivity2.this, TelaActivity3.class);
                            intent.putExtra("Erros", erros);
                            intent.putExtra("nome", textViewNome.getText().toString()); // PASSAR INFORMAÇÕES ENTRE ACTIVITIES
                            startActivity(intent);
                            erros++;

                        }

                        });
                    }

            }
        });







    }
}