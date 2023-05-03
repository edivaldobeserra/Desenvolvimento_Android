package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSalvar, btnApresentar;
    EditText editModelo, editTamanho, editTextQtd;
    TextView textInfo;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnApresentar = findViewById(R.id.btnApresentar);
        editModelo = findViewById(R.id.editModelo);
        editTamanho = findViewById(R.id.editTamanho);
        editTextQtd = findViewById(R.id.editTextQtd);
        textInfo = findViewById(R.id.textInfo);

        editModelo.requestFocus();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pf = getSharedPreferences("chaveGeral", MODE_PRIVATE);
                SharedPreferences.Editor editor = pf.edit();
                editor.putString("chaveModelo", editModelo.getText().toString());
                editor.putString("chaveTamanho", editTamanho.getText().toString());
                editor.putString("chaveQtd", editTextQtd.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this, "SAlvo Com Sucesso", Toast.LENGTH_SHORT).show();

            }
        });

        btnApresentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String modelo,tamanho,quantidade;
                SharedPreferences pref = getSharedPreferences("chaveGeral",MODE_PRIVATE);

                modelo=pref.getString("chaveModelo","");
                tamanho=pref.getString("chaveTamanho","");
                quantidade=pref.getString("chaveQtd","");

                textInfo.setText(modelo + tamanho + quantidade);





            }
        });
    }
}