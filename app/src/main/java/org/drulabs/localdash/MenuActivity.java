package org.drulabs.localdash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.drulabs.localdash.model.ChatDTO;
import org.drulabs.localdash.notification.NotificationToast;
import org.drulabs.localdash.transfer.DataSender;
import org.drulabs.localdash.utils.ConnectionUtils;
import org.drulabs.localdash.utils.Utility;

public class MenuActivity extends AppCompatActivity {


    public static final String KEY_CHATTING_WITH = "chattingwith";
    public static final String KEY_CHAT_IP = "chatterip";
    public static final String KEY_CHAT_PORT = "chatterport";
    Button menu,player;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu = (Button) findViewById(R.id.button_1);
        player = (Button) findViewById(R.id.button_2);


        final Bundle extras = getIntent().getExtras();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this, org.drulabs.localdash.Button.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });


        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,Player.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });
    }

}
