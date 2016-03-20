package com.greetink.android.kado;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void playMusic(View view){
        EditText et = (EditText) findViewById(R.id.edit_text);
        MediaPlayer mp = MediaPlayer.create(this,R.raw.happy_birthday);
        Button b = (Button) findViewById(R.id.music_button);
        TextView tv = (TextView) findViewById(R.id.text);
        ImageView iv = (ImageView) findViewById(R.id.rwp);
        AudioManager mAudio = (AudioManager) getSystemService(AUDIO_SERVICE);
        int originalVolume = mAudio.getStreamVolume(AudioManager.STREAM_MUSIC);
        if(et.getText().toString().isEmpty()){
            Toast.makeText(this,"Namamu Kosong :'(",Toast.LENGTH_LONG).show();
        }else if(et.getText().toString().length()<=3){
            Toast.makeText(this,"Itu Bukan Namamu Kan? :'(",Toast.LENGTH_LONG).show();
        //}else if(){

        }else{
            mp.start();
            b.setVisibility(View.GONE);
            et.setVisibility(View.GONE);
            tv.setVisibility(View.VISIBLE);
            tv.setText("Selamat Ulang Tahun :)\n"+et.getText().toString());
            iv.setVisibility(View.VISIBLE);
        }
    }
}
