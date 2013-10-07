package com.real.robotcontroller;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText enterIp;
	Button buttonIp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		enterIp = (EditText) findViewById(R.id.enter_ip);
		buttonIp = (Button) findViewById(R.id.button_ip);
		buttonIp.setOnClickListener(enterIpListener);
//		buttonIp.
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	OnClickListener enterIpListener = new Button.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			Bundle b = new Bundle();
			b.putString("ip", enterIp.getText().toString());
			Intent commandRobot = new Intent(MainActivity.this, CommandActivity.class);
			commandRobot.putExtras(b);
			startActivity(commandRobot);
		}
	};
}
