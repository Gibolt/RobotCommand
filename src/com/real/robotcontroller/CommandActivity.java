package com.real.robotcontroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;


public class CommandActivity extends Activity {
	private TcpHandler handler = null;
	private String ip;
	
	private Button buttonForward;
	private Button buttonReverse;
	private Button buttonLeft;
	private Button buttonRight;
	private Button buttonEnd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_command);

		Bundle b = getIntent().getExtras();
		ip = b.getString("ip");
		handler = new TcpHandler(ip);
		
		buttonForward = (Button) findViewById(R.id.button_forward);
		buttonReverse = (Button) findViewById(R.id.button_reverse);
		buttonLeft    = (Button) findViewById(R.id.button_left);
		buttonRight   = (Button) findViewById(R.id.button_right);
		buttonEnd     = (Button) findViewById(R.id.command_end);
		
		buttonForward.setOnClickListener(buttonForwardListener);
		buttonReverse.setOnClickListener(buttonReverseListener);
		buttonLeft   .setOnClickListener(buttonLeftListener);
		buttonRight  .setOnClickListener(buttonRightListener);
		buttonEnd.setOnClickListener(buttonEndListener);
		
	}
	
	OnClickListener buttonForwardListener = new Button.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			checkOK();
			handler.sendCommandTcp("f");
		}
	};
	
	OnClickListener buttonReverseListener = new Button.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			checkOK();
			handler.sendCommandTcp("b");
		}
	};
	
	OnClickListener buttonLeftListener = new Button.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			checkOK();
			handler.sendCommandTcp("l");
		}
	};
	
	OnClickListener buttonRightListener = new Button.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			checkOK();
			handler.sendCommandTcp("r");
		}
	};
	
	OnClickListener buttonEndListener = new Button.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			end();
		}
	};
	
	private void checkOK() {
		if (!handler.isOK()) {
			handler.close();
			this.finish();
		}
	}
	
	private void end() {
		handler.close();
		this.finish();
	}
}
