package com.example.threats_and_preventions;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TrojanInfo extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_trojan_info);
		
		View btnOK = (Button) findViewById(R.id.ok_button);
		btnOK.setOnClickListener(this);
		View btnBack = (Button) findViewById(R.id.back_button);
		btnBack.setOnClickListener(this);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.trojan_info, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.ok_button:
			startActivity(new Intent(this, ThreatsMenu.class));
			break;
		case R.id.back_button:
			startActivity(new Intent(this, ThreatsMenu.class));
			break;			
		}
	}

}