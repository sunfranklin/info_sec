package com.example.threats_and_preventions;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThreatsMenu extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_threats_menu);
		
		View btnDOS = (Button) findViewById(R.id.denial_of_service_button);
		btnDOS.setOnClickListener(this);
		View btnVirus = (Button) findViewById(R.id.virus_button);
		btnVirus.setOnClickListener(this);
		View btnSniffer = (Button) findViewById(R.id.sniffer_button);
		btnSniffer.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.threats_menu, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.denial_of_service_button:
			startActivity(new Intent(this, DosInfo.class));
			break;
		case R.id.virus_button:
			startActivity(new Intent(this, VirusInfo.class));
			break;
		case R.id.sniffer_button:
			startActivity(new Intent(this, SnifferInfo.class));
			break;
		}
	}

}
