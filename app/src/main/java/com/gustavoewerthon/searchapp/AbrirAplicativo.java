package com.gustavoewerthon.searchapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

/*
Nessa classe, criaremos a função para pesquisar o app e tudo que estiver acoplado nele
*/
public class AbrirAplicativo {

    private Context context;

    // recebendo o contexto para usar intents
    public AbrirAplicativo(Context context) {
        this.context = context;
    }


    //Aqui está toda a logica da abertura, onde ignoramos os espaços para facilitar para o usuario
    public boolean abrirAplicativo(String name) {
        PackageManager pm = context.getPackageManager();

        Intent mainIntent = new Intent(Intent.ACTION_MAIN);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> apps = pm.queryIntentActivities(mainIntent, 0);

        for (ResolveInfo info : apps) {
            String label = info.loadLabel(pm).toString();
            String noSpace = label.replaceAll("\\s+", "");

            if (label.equalsIgnoreCase(name) || noSpace.equalsIgnoreCase(name)) {

                Intent launchIntent =
                        pm.getLaunchIntentForPackage(info.activityInfo.packageName);

                if (launchIntent != null) {
                    context.startActivity(launchIntent);
                    return true;
                }
            }
        }
        return false;
    }
}
