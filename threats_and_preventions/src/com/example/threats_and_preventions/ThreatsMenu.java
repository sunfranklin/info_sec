package com.example.threats_and_preventions;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThreatsMenu extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_threats_menu);
		
		View btnDOS = (Button) findViewById(R.id.denial_of_service_button);
		btnDOS.setOnClickListener(this);
		View btnVirus = (Button) findViewById(R.id.virus_button);
		btnVirus.setOnClickListener(this);
		View btnSniffer = (Button) findViewById(R.id.sniffer_button);
		btnSniffer.setOnClickListener(this);
		View btnSpoof = (Button) findViewById(R.id.spoof_button);
		btnSpoof.setOnClickListener(this);
		View btnPhishing = (Button) findViewById(R.id.phishing_button);
		btnPhishing.setOnClickListener(this);
		View btnPharming = (Button) findViewById(R.id.pharming_button);
		btnPharming.setOnClickListener(this);
		View btnMiddleman = (Button) findViewById(R.id.middleman_button);
		btnMiddleman.setOnClickListener(this);
		View btnSpam = (Button) findViewById(R.id.spam_button);
		btnSpam.setOnClickListener(this);
		View btnPasswordcrack = (Button) findViewById(R.id.passwordcrack_button);
		btnPasswordcrack.setOnClickListener(this);
		View btnTrojan = (Button) findViewById(R.id.trojan_button);
		btnTrojan.setOnClickListener(this);
		View btnBack = (Button) findViewById(R.id.back_button);
		btnBack.setOnClickListener(this);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.threats_menu, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
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
		case R.id.spoof_button:
			startActivity(new Intent(this, Spoofing_info.class));
			break;
		case R.id.phishing_button:
			startActivity(new Intent(this, PhishingInfo.class));
			break;
		case R.id.pharming_button:
			startActivity(new Intent(this, PharmingInfo.class));
			break;
		case R.id.middleman_button:
			startActivity(new Intent(this, MiddlemanInfo.class));
			break;
		case R.id.spam_button:
			startActivity(new Intent(this, SpamInfo.class));
			break;
		case R.id.passwordcrack_button:
			startActivity(new Intent(this, PasswordcrackInfo.class));
			break;
		case R.id.trojan_button:
			startActivity(new Intent(this, TrojanInfo.class));
			break;
		case R.id.back_button:
			startActivity(new Intent(this, MainActivity.class));
			break;
		}
	}

}
