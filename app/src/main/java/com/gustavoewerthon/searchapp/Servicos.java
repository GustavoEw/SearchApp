package com.gustavoewerthon.searchapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

/**
 * Service responsável por manter o aplicativo ativo em primeiro plano.
 *
 * Este serviço NÃO gerencia diretamente o overlay (janela flutuante),
 * apenas garante que o processo continue rodando mesmo com a tela bloqueada,
 * utilizando um Foreground Service com notificação persistente.
 */
public class Servicos extends Service {

    // Contexto do próprio Service
    private Context context;

    // ID do canal de notificação utilizado pelo Foreground Service
    private static final String CHANNEL_ID = "ForegroundServiceChannel";

    /**
     * Chamado quando o Service é criado.
     * Aqui realizamos inicializações que devem ocorrer apenas uma vez,
     * como verificação de permissões e criação do NotificationChannel.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;



        // Cria o canal de notificação exigido para Foreground Service
        createNotificationChannel();
    }

    /**
     * Chamado toda vez que o Service é iniciado via startService().
     * Aqui iniciamos o Service em primeiro plano com uma notificação persistente.
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Notificação obrigatória para manter o Service em primeiro plano
        Notification notification =
                new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setContentTitle("App rodando")
                        .setContentText("O serviço está ativo em segundo plano")
                        .setSmallIcon(android.R.drawable.ic_media_play)
                        .build();

        // Inicia o Service como Foreground Service
        startForeground(1, notification);

        // Garante que o Service seja recriado caso o sistema o finalize
        return START_STICKY;
    }

    /**
     * Este Service não permite binding com Activities,
     * portanto retornamos null.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * Chamado quando o Service é finalizado.
     * Ideal para liberar recursos ou encerrar processos auxiliares.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Cria o NotificationChannel necessário para notificações
     * em dispositivos com Android 8.0 (API 26) ou superior.
     *
     * Sem este canal, o Foreground Service não pode ser iniciado.
     */
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Canal do Serviço em Primeiro Plano",
                    NotificationManager.IMPORTANCE_LOW
            );

            NotificationManager manager =
                    getSystemService(NotificationManager.class);

            if (manager != null) {
                manager.createNotificationChannel(serviceChannel);
            }
        }
    }
}