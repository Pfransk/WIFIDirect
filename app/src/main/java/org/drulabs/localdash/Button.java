package org.drulabs.localdash;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import org.drulabs.localdash.model.ChatDTO;
import org.drulabs.localdash.transfer.DataSender;
import org.drulabs.localdash.utils.ConnectionUtils;
import org.drulabs.localdash.utils.Utility;



public class Button extends AppCompatActivity{


    public static final String KEY_CHAT_IP = "chatterip";
    public static final String KEY_CHAT_PORT = "chatterport";
    public static final String KEY_CHATTING_WITH = "chattingwith";

    private String destIP;
    private int destPort;
    private String chattingWith;
    String message;
    ImageButton b1,b2,b3;
    int count = 0;
    String holder;
    boolean pressed1,pressed2,pressed3; ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        b1 = (ImageButton) findViewById(R.id.video_1);
        b2 = (ImageButton) findViewById(R.id.video_2);
        b3 = (ImageButton) findViewById(R.id.video_3);
        


        Bundle extras = getIntent().getExtras();

        destIP = extras.getString(KEY_CHAT_IP);
        destPort = extras.getInt(KEY_CHAT_PORT);

        chattingWith = extras.getString(KEY_CHATTING_WITH);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(count<2 && !pressed1 ){
                            count++;
                            pressed1 = true;
                            message = "1";

                            b1.setBackgroundResource(R.mipmap.onegreen);
//                            if (v1 != v2) {
//                                v1.setBackgroundResource(R.mipmap.onegreen);
//                                setBackground(v2);
//                            }

                            SendChatInfo(view);

                    }
                    else if(count>=2){
                             if(pressed1){
                                 pressed1=false;
                                 holder = "pressed1";
                                 count--;
                                 b1.setBackgroundResource(R.mipmap.oneblue);
                                 message = "stop1";
                                 SendChatInfo(view);
                             }else {
                                 Toast.makeText(getApplicationContext(), "Release one button!!", Toast.LENGTH_SHORT).show();
                             }
                    }else if(pressed1)
                    {

                        pressed1=false;
                        holder = "pressed1";
                        count--;
                        b1.setBackgroundResource(R.mipmap.oneblue);
                        message = "stop1";
                        SendChatInfo(view);
                    }
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(count<2 && !pressed2 ){
                        count++;
                        pressed2 = true;
                        message = "2";
                        b2.setBackgroundResource(R.mipmap.twogreen);
//                        if (v1 != v2) {
//                            v1.setBackgroundResource(R.mipmap.twogreen);
//                            setBackground(v2);
//                        }

                        SendChatInfo(view);

                    }
                    else if(count>=2){
                        if(pressed2){

                            pressed2 = false;
                            holder = "pressed2";
                            count--;
                            b2.setBackgroundResource(R.mipmap.twoblue);
                            message = "stop2";
                            SendChatInfo(view);
                        }else {
                            Toast.makeText(getApplicationContext(), "Release one button!!", Toast.LENGTH_SHORT).show();
                        }
                    }else if(pressed2)
                    {

                        pressed2 = false;
                        holder = "pressed2";
                        count--;
                        b2.setBackgroundResource(R.mipmap.twoblue);
                        message = "stop2";
                        SendChatInfo(view);
                    }

                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(count<2 && !pressed3 ){
                        count++;
                        pressed3 = true;
                        message = "3";
                        b3.setBackgroundResource(R.mipmap.threegreen);
//                        if (v1 != v2) {
//                            v1.setBackgroundResource(R.mipmap.threegreen);
//                            setBackground(v2);
//                        }
                        SendChatInfo(view);

                    }
                    else if(count>=2){
                        if(pressed3){

                            pressed3 = false;
                            holder = "pressed3";
                            count--;
                            b3.setBackgroundResource(R.mipmap.threeblue);
                            message = "stop3";
                            SendChatInfo(view);
                        }else {
                            Toast.makeText(getApplicationContext(), "Release one button!!", Toast.LENGTH_SHORT).show();
                        }
                    }else if(pressed3)
                    {

                        pressed3 = false;
                        holder = "pressed3";
                        count--;
                        b3.setBackgroundResource(R.mipmap.threeblue);
                        message = "stop3";
                        SendChatInfo(view);
                    }

                }
            });
    }

//    private void setBackground(View v2) {
//        if(v2==b1)
//        {
//            v2.setBackgroundResource(R.mipmap.oneblue);
//        }else if(v2==b2){
//            v2.setBackgroundResource(R.mipmap.twoblue);
//        }else if(v2==b3){
//            v2.setBackgroundResource(R.mipmap.threeblue);
//        }else
//        {
//            return;
//        }
//    }

    public void SendChatInfo(View v) {

        ChatDTO myChat = new ChatDTO();
        myChat.setPort(ConnectionUtils.getPort(Button.this));
        myChat.setFromIP(Utility.getString(Button.this, "myip"));
        myChat.setLocalTimestamp(System.currentTimeMillis());
        myChat.setMessage(message);
        myChat.setSentBy(chattingWith);
        myChat.setMyChat(true);
        DataSender.sendChatInfo(Button.this, destIP, destPort, myChat);

    }

}
