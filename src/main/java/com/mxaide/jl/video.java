package com.mxaide.jl;
import android.support.v7.app.*;
import android.os.*;
import android.widget.*;
import android.net.*;
import android.media.*;
import android.app.*;

public class video extends Activity
{
	VideoView vv;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
		vv=(VideoView) findViewById(R.id.videoVideoView1);
		vv.setMediaController(new MediaController(this));

        vv.setVideoURI(Uri.parse("http://alcdn.hls.xiaoka.tv/2017427/14b/7b3/Jzq08Sl8BbyELNTo/index.m3u8"));
		vv.start();

		vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					Toast.makeText(video.this, "播放完成了", Toast.LENGTH_SHORT).show();
				}
			});
		
		
}


}
