package com.sunny.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
	
	private Button mPlayBtn;
	private Button mStopBtn;
	
	private AudioPlayer mPlayer = new AudioPlayer();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// fragment的retainInstance属性值默认为false。这表明其不会被保留。因此，设备旋转时
		// fragment会随托管activity一起销毁并重建。调用setRetainInstance(true)方法可保留
		// fragment。已保留的fragment不会随activity一起被销毁。相反，它会被一直保留并在需要时原封
		// 不动的传递给新的activity
		setRetainInstance(true); // 保留fragment时保存了AudioPlayer实例，旋转屏幕时不会中断语音播放
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_hello_moon, container, false);
		
		mPlayBtn = (Button) view.findViewById(R.id.btn_hellomoon_play);
		mPlayBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayer.play(getActivity());
			}
		});
		
		mStopBtn = (Button) view.findViewById(R.id.btn_hellomoon_stop);
		mStopBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayer.stop();
			}
		});
		
		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}

}
