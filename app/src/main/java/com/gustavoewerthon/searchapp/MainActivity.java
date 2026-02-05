package com.gustavoewerthon.searchapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText app;
    Button pesquisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        app = findViewById(R.id.app);
        pesquisar = findViewById(R.id.pesquisa);

        pesquisar.setOnClickListener(v -> {
            String nome = app.getText().toString().trim();

            if (nome.isEmpty()) {
                Toast.makeText(this, "Digite o nome do app", Toast.LENGTH_SHORT).show();
                return;
            }

        });
    }


    //popup, alertando q o app não foi encontrado
    private void mostrarErro() {
        new AlertDialog.Builder(this)
                .setTitle("Erro")
                .setMessage("Aplicativo não encontrado")
                .setPositiveButton("OK", null)
                .show();
    }
}
