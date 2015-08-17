package com.gooker.eo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class EventsBusActivity extends AppCompatActivity {

	private Button btnLoad;
	private TextView tvLog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events_bus);

		btnLoad = (Button) findViewById(R.id.btn_load);

		tvLog = (TextView) findViewById(R.id.tv_log);

		EventBus.getDefault().register(this);
		btnLoad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				EventBus.getDefault().post(new DataChange("mozi", "20"));
				EventBus.getDefault().post("hello");
			}
		});
	}

	@Subscribe
	public void onEventMainThread(DataChange msg) {
		tvLog.setText(msg.toString());
	}

	@Subscribe
	public void onEvent(String msg) {
		tvLog.setText(msg);
	}

	@Override
	protected void onResume() {
		super.onResume();


	}

	@Override
	protected void onPause() {
		super.onPause();
		EventBus.getDefault().unregister(this);
	}
}
