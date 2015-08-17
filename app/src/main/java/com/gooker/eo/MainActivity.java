package com.gooker.eo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;

public class MainActivity extends Activity {

	private Button btnUpdate;
	private TextView tvMsg;
	private Bus mBus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		btnUpdate = (Button) findViewById(R.id.btn_update);
		tvMsg = (TextView) findViewById(R.id.tv_msg);

		mBus = new Bus();

		


		btnUpdate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				mBus.post("btnOnCLick");
//				mBus.post();
				mBus.post(new DataChange("lis","40"));
			}
		});
	}

	@Subscribe
	public void sayHello(String info) {
		Log.e("MainActivity", info);
		tvMsg.setText(info);
	}

	@Subscribe
	public void updateData(DataChange data) {
		tvMsg.setText(data.toString());
	}

	@Produce
	public DataChange loadData() {
		return new DataChange("zhangsan", "20");
	}

	@Override
	protected void onResume() {
		super.onResume();
		mBus.register(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (null != mBus) {
			mBus.unregister(this);
		}
	}

}
