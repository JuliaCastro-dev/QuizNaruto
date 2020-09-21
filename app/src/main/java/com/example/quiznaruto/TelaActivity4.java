package com.example.quiznaruto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TelaActivity4 extends AppCompatActivity {
     Button buttonAvanced;
     Button buttonConfere;
    EditText editTextNome;
    TextView textViewNome;
    CheckBox   checkBoxNaruto;
    CheckBox     checkBoxMadara;
    CheckBox     checkBoxKaka;
    CheckBox checkBoxTsu;

    String nome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4);

        buttonAvanced = findViewById(R.id.buttonAvancarT4);
        buttonConfere = findViewById(R.id.buttonConfereT4);
        editTextNome = findViewById(R.id.editTextNome);
        textViewNome = findViewById(R.id.textViewNomeT4);
        checkBoxKaka = findViewById(R.id.checkBoxKaka);
        checkBoxMadara = findViewById(R.id.checkBoxMadara);
        checkBoxNaruto = findViewById(R.id.checkBoxNaruto);
        checkBoxTsu = findViewById(R.id.checkBoxTsu);


        int erros;
        
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");

      

        if(!nome.equals(""))
            textViewNome.setText(nome);


        buttonConfere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBoxMadara.isChecked() && checkBoxKaka.isChecked() && !checkBoxNaruto.isChecked() && !checkBoxTsu.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(TelaActivity4.this);
                    builder.setTitle("Acertou");
                    builder.setMessage("Como o naruto diria: TO CERTOOOO!!");
                    builder.show();

                    buttonAvanced.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(TelaActivity4.this, TelaActivity5.class);
                            intent.putExtra("nome", textViewNome.getText().toString()); // PASSAR INFORMAÇÕES ENTRE ACTIVITIES
                            startActivity(intent);

                        }
                    });

                }
                else{

                    AlertDialog.Builder builder = new AlertDialog.Builder(TelaActivity4.this);
                    builder.setTitle("Errou");
                    builder.setMessage("Não foi dessa vez, mas o naruto não desistiria     " +
                            "Resposta Certa: Madara E Kakashi ");
                    builder.show();
                    buttonAvanced.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            int erros = 0;
                            erros += 1;
                            Intent intent = new Intent(TelaActivity4.this, TelaActivity5.class);
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