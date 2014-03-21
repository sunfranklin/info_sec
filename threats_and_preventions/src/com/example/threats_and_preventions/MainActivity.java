package com.example.threats_and_preventions;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
		View btnThreats = (Button) findViewById(R.id.threats_button);
		btnThreats.setOnClickListener(this);
		View btnQuiz = (Button) findViewById(R.id.quiz_button);
		btnQuiz.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.threats_button:
			startActivity(new Intent(this, ThreatsMenu.class));;
			break;
		case R.id.quiz_button:
//			finish();
			startActivity(new Intent(this, QuizActivity.class));
			break;
		}
	}
       
}
