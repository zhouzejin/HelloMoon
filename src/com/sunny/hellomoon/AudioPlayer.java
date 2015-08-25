package com.sunny.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class AudioPlayer {
	
	private MediaPlayer mMeidaPlayer;
	
	public void stop() {
		if (mMeidaPlayer != null) {
			mMeidaPlayer.release();
			mMeidaPlayer = null;
		}
	}
	
	public void play(Context context) {
		// 在play(Context)方法的开头就调用stop()方法，可避免用户多次单击Play按钮创建多个
		// MediaPlayer实例的情况发生；音频文件完成播放后，立即调用stop()方法，可尽可能快地释
		// 放MediaPlayer实例及其占用的资源
		stop();
		
		mMeidaPlayer = MediaPlayer.create(context, R.raw.one_small_step);
		
		mMeidaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				stop();
			}
		});
		
		mMeidaPlayer.start();
	}

}
