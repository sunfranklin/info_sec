package com.example.threats_and_preventions;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PreventionsMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preventions_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preventions_menu, menu);
		return true;
	}

}
