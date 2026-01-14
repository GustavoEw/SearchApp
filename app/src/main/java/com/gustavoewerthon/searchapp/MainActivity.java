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
            //caso não ache vai ve o erro.
            if (!abrirAplicativo(nome)) {
                mostrarErro();
            }
        });
    }

    private boolean abrirAplicativo(String nome) {
        PackageManager pm = getPackageManager();
        //enviando que usaramos uma acao principal no sistema
        Intent mainIntent = new Intent(Intent.ACTION_MAIN);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        //listando aplicativos que possam ser abestos
        List<ResolveInfo> apps = pm.queryIntentActivities(mainIntent, 0);
        //percorrer eles até encontra o nome referente
        for (ResolveInfo info : apps) {
            String label = info.loadLabel(pm).toString();

            if (label.equalsIgnoreCase(nome)) {
                Intent launchIntent =
                        pm.getLaunchIntentForPackage(info.activityInfo.packageName);

                if (launchIntent != null) {
                    startActivity(launchIntent);
                    return true;
                }
            }
        }
        return false;
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
