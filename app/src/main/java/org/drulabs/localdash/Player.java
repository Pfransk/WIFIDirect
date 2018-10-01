package org.drulabs.localdash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;

import org.drulabs.localdash.model.ChatDTO;

import java.io.File;

import bg.devlabs.fullscreenvideoview.FullscreenVideoView;

public class Player extends AppCompatActivity {


    public static final String ACTION_CHAT_RECEIVED = "org.drulabs.localdash.chatreceived";

    public static final String KEY_CHAT_DATA = "chat_data_key";

    public static final String KEY_CHATTING_WITH = "chattingwith";
    public static final String KEY_CHAT_IP = "chatterip";
    public static final String KEY_CHAT_PORT = "chatterport";
    VideoView videoHolder1,videoHolder2;

    String emptyHolder ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_player);

       videoHolder1 = (VideoView) findViewById(R.id.videoViewLinear1);

       videoHolder2 = (VideoView) findViewById(R.id.videoViewLinear2);

        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_CHAT_RECEIVED);
        LocalBroadcastManager.getInstance(Player.this).registerReceiver(chatReceiver, filter);
    }


    private BroadcastReceiver chatReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case ACTION_CHAT_RECEIVED:
                    ChatDTO chat = (ChatDTO) intent.getSerializableExtra(KEY_CHAT_DATA);
                    String s =chat.getMessage();
                    decision(s);
                    break;
                default:
                    break;
            }
        }
    };

    public void decision(String s){
        if(s.equals("1")){
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.video1);
            videoHolder1.setVideoURI(video);
            videoHolder1.canSeekBackward();
            videoHolder1.canSeekForward();
            videoHolder1.canPause();
            videoHolder1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Completed",Toast.LENGTH_LONG).show();
                }

            });
            videoHolder1.start();

        }

        if(s.equals("2")){
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.video);
            videoHolder2.setVideoURI(video);
            videoHolder2.canSeekBackward();
            videoHolder2.canSeekForward();
            videoHolder2.canPause();
            videoHolder2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Completed",Toast.LENGTH_LONG).show();
                }

            });
            videoHolder2.start();
        }

        if(s.equals("3")){
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.video3);
            videoHolder1.setVideoURI(video);
            videoHolder1.canSeekBackward();
            videoHolder1.canSeekForward();
            videoHolder1.canPause();
            videoHolder1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                    Toast.makeText(getApplicationContext(),"Completed",Toast.LENGTH_LONG).show();
                }

            });
            videoHolder1.start();
        }

        if(s.equals("stop1"))
        {
            ((VideoView) videoHolder1).stopPlayback();

        }else if(s.equals("stop2"))
        {
            ((VideoView) videoHolder2).stopPlayback();
        }else if(s.equals("stop3"))
        {
            ((VideoView) videoHolder1).stopPlayback();
        }
    }

//    public void decision(String s){
//        if(s.equals("1"))
//        {
//            splashPlayer();
//        }
//       else if(s.equals("2"))
//        {
//            splashPlayer2();
//        }
//        else
//        {
//            splashPlayer3();
//        }
//    }


//    public void splashPlayer() {
////        final VideoView videoHolder = (VideoView) findViewById(R.id.videoViewRelative);
////        setContentView(videoHolder);
//
////        DisplayMetrics metrics = new DisplayMetrics(); getWindowManager().getDefaultDisplay().getMetrics(metrics);
////        android.widget.FrameLayout.LayoutParams params = (android.widget.FrameLayout.LayoutParams) videoHolder.getLayoutParams();
////        params.width =  metrics.widthPixels;
////        params.height = metrics.heightPixels;
////        params.leftMargin = 0;
////        videoHolder.setLayoutParams(params);
//
//        Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.video1);
//        videoHolder.setVideoURI(video);
//        videoHolder.canSeekBackward();
//        videoHolder.canSeekForward();
//        videoHolder.canPause();
//        videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            public void onCompletion(MediaPlayer mp) {
//                mp.start();
//                Toast.makeText(getApplicationContext(),"Completed",Toast.LENGTH_LONG).show();
//            }
//
//        });
//        videoHolder.start();
//        videoHolder.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                ((VideoView) v).stopPlayback();
//
//                return true;
//            }
//        });
//    }

//    public void splashPlayer2() {
////        final VideoView videoHolder = new VideoView(this);
////        setContentView(videoHolder);
//        Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.video);
//        videoHolder.setVideoURI(video);
//        videoHolder.canSeekBackward();
//        videoHolder.canSeekForward();
//        videoHolder.canPause();
//        videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            public void onCompletion(MediaPlayer mp) {
//                mp.start();
//                Toast.makeText(getApplicationContext(),"Completed",Toast.LENGTH_LONG).show();
//            }
//
//        });
//        videoHolder.start();
//        videoHolder.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                ((VideoView) v).stopPlayback();
//
//                return true;
//            }
//        });
//    }
//
//    public void splashPlayer3() {
////        final VideoView videoHolder = new VideoView(this);
////        setContentView(videoHolder);
//        Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.video3);
//        videoHolder.setVideoURI(video);
//        videoHolder.canSeekBackward();
//        videoHolder.canSeekForward();
//        videoHolder.canPause();
//        videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            public void onCompletion(MediaPlayer mp) {
//                mp.start();
//                Toast.makeText(getApplicationContext(),"Completed",Toast.LENGTH_LONG).show();
//            }
//
//        });
//        videoHolder.start();
//        videoHolder.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                ((VideoView) v).stopPlayback();
//
//                return true;
//            }
//        });
//    }


}
