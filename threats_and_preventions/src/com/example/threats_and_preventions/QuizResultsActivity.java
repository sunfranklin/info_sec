package com.example.threats_and_preventions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QuizResultsActivity extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);        
		setContentView(R.layout.activity_quiz_results);

		Intent intent = getIntent();
		int num_correct = intent.getIntExtra("correct", 0);

		TextView text = (TextView) findViewById(R.id.quiz_results_text);
		text.setText("You scored "+num_correct+" of 8 correct!");
		Button home_button = (Button) findViewById(R.id.return_home);
		home_button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.return_home:
			startActivity(new Intent(this, MainActivity.class));;
			break;
		default:
			break;
		}
	}

}
