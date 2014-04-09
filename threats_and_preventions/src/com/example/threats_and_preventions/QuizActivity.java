package com.example.threats_and_preventions;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends Activity implements OnClickListener {

	DatabaseQuiz dbquiz = new DatabaseQuiz(this);
	

	final Context context = this;
	int questAnsPosition;
	List<QuestionAnswer> questAns;
	String correctAnswer;
	private Handler mHandler = new Handler();
	private int question_counter = 1;
	private int correct_answers;
	private int correctAnsPosition;
	
	//Buttons View
	Button  a_button;
	Button  b_button;
	Button  c_button;
	Button  d_button;
	TextView question;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);        
        setContentView(R.layout.activity_quiz);

        dbquiz.deleteTable();
        UploadQuestionAnswer(dbquiz);
        
        questAns = dbquiz.getAllQuestionAnswer();
        		
        a_button = (Button) findViewById(R.id.A_button);
        a_button.setOnClickListener(this);
        
        b_button = (Button) findViewById(R.id.B_button);
        b_button.setOnClickListener(this);
        
        c_button = (Button) findViewById(R.id.C_button);
        c_button.setOnClickListener(this);
        
        d_button = (Button) findViewById(R.id.D_button);
        d_button.setOnClickListener(this);
        
        question = (TextView) findViewById(R.id.question);
        
        SetQuestionAnswers(question, a_button, b_button, c_button, d_button);
        
	}
	
	private void UploadQuestionAnswer(DatabaseQuiz dbquiz)
	{
		dbquiz.addQA(new QuestionAnswer("What kind of information attack involves redirection " +
				"of legitimate Web traffic (e.g., browser requests) to an illegitimate" +
				" site for the purpose of obtaining private information?","Pharming"));
		
		dbquiz.addQA(new QuestionAnswer("What kind of information attack is best described as " +
				"an attempt to acquire information such as usernames, passwords, and credit card" +
				" details by disguising oneself as a trustworthy entity?","Phishing"));

		dbquiz.addQA(new QuestionAnswer("What kind of information attack is best described as" +
				" a program or device that monitors data traveling over a network; can be used " +
				"both for legitimate purposes and for stealing information from a network?","Sniffer"));
		
		dbquiz.addQA(new QuestionAnswer("What kind of information attack is best described as" +
				" a technique used to gain unauthorized access where the intruder assumes" +
				" a trusted IP address?","Spoofing"));
		
		//Questions and answers related to the prevention of attacks
		dbquiz.addQA(new QuestionAnswer("What kind of information attack can be prevented" +
				" by using strong encryption?","Man-In-The-Middle"));
		
		dbquiz.addQA(new QuestionAnswer("When signing up for a website, making sure that " +
				"the web master will not sell your address can be a way of preventing...","Spam"));
		
		dbquiz.addQA(new QuestionAnswer("Hiding/masking your IP address as much as possible is an effiecient" +
				" way of preventing...","Denial-of-Service (DoS) or Distributed Denial-of-Service (DDoS)"));
		
		dbquiz.addQA(new QuestionAnswer("What kind of information attack can be prevented by using" +
				" Message-Digest Algorithm (MD5) passwords that confines a \"strong\" password " +
				"containing numbers, symbols and upper/lower case letters.","Password Crack"));	
	}

	
	@Override
	public void onClick(final View v) {
		
		Button chosenOpt = (Button) findViewById(v.getId());
		
		String chosenAnswer = (String) chosenOpt.getText();
		
	    if (correctAnswer.equals(chosenAnswer))
		{
//		    chosenOpt.setTextColor(0xff46D246);
			v.setBackgroundResource(R.drawable.green_button);
			correct_answers++;
		}
		else {
//			chosenOpt.setTextColor(0xff971425);
			v.setBackgroundResource(R.drawable.red_button);
			//shows the correct answer half second 
			//after an incorrect answer is selected
			mHandler.postDelayed(revealCorrectAnswer, 500);
		}
	    
	    //disable buttons so more than one answer isn't selected
	    a_button.setEnabled(false);
	    b_button.setEnabled(false);
	    c_button.setEnabled(false);
	    d_button.setEnabled(false);

	    //Cause the Runnable to be sent to the Handler after a specified delay in ms:
	    mHandler.postDelayed(mUpdateTimeTask, 2000);    
	}
	
	
	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	private int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	


	//Define a Runnable:
	private Runnable mUpdateTimeTask = new Runnable() {
		public void run() {

			a_button.setBackgroundResource(R.drawable.button_shape);
			b_button.setBackgroundResource(R.drawable.button_shape);
			c_button.setBackgroundResource(R.drawable.button_shape);
			d_button.setBackgroundResource(R.drawable.button_shape);
			
			if (questAns.size() > 0) 
				SetQuestionAnswers(question, a_button, b_button, c_button, d_button);
			else {
				Intent intent = new Intent(QuizActivity.this, QuizResultsActivity.class);
				intent.putExtra("correct", correct_answers);
				startActivity(intent);
			}

			// You could do this call if you wanted it to be periodic:
			//mHandler.postDelayed(this, 5000 );
		}
	};
	
	
	/**
	 * Define a Runnable that display the correct answer when an incorrect answer is selected.
	 */
	private Runnable revealCorrectAnswer = new Runnable() {
		public void run() {

			switch (correctAnsPosition)
			{
			case 1:
				//correct answer is at option A
				a_button.setBackgroundResource(R.drawable.green_button);
				break;
			case 2:
				//correct answer is at option B
				b_button.setBackgroundResource(R.drawable.green_button);
				break;
			case 3:
				//correct answer is at option C
				c_button.setBackgroundResource(R.drawable.green_button);
				break;
			case 4:
				//correct answer is at option D
				d_button.setBackgroundResource(R.drawable.green_button);
				break;
			}  
		}
	};
	
	/**
	 * 
	 * @param text TextView that display the question 
	 * @param a Button that correspond to option answer A
	 * @param b Button that correspond to option answer B
	 * @param c Button that correspond to option answer C
	 * @param d Button that correspond to option answer D
	 */
	private void SetQuestionAnswers(TextView question, Button a, Button b, Button c, Button d)
	{		
		
		String wrongAnswer1, wrongAnswer2, wrongAnswer3;
		
		//generate a random integer value
        //between the size of the quesAns list
        questAnsPosition = randInt(0, questAns.size()-1);
        
        //get the question-answer pair from the list 
        //questAns at pos corresponding to questAnsPosition
        QuestionAnswer questionAnswer = questAns.remove(questAnsPosition);
        
        //set question equal to the current question of the quiz 
        question.setText("Question "+question_counter+": "+questionAnswer.getQuestion());
        question_counter++;
        
        //get the correct answer
        correctAnswer = questionAnswer.getAnswer();
        		
        List<String> answerList = dbquiz.getAllAnswers();
        //remove the correct answer from the alternative options
		answerList.remove(questionAnswer.getAnswer());
		
		//randomly remove 3 wrong answers among all possible wrong answers
		wrongAnswer1 = answerList.remove(randInt(0,answerList.size()-1));
		wrongAnswer2 = answerList.remove(randInt(0,answerList.size()-1));
		wrongAnswer3 = answerList.remove(randInt(0,answerList.size()-1));
				
        //generate a random integer value between 1-4 
        correctAnsPosition = randInt(1,4);
        
        switch (correctAnsPosition)
        {
        	case 1:
        		//place the correct answer at option A
        		a.setText(questionAnswer.getAnswer());
        		//place the wrong answers at remaining options
        		b.setText(wrongAnswer1);
        		c.setText(wrongAnswer2);
        		d.setText(wrongAnswer3);
        		break;
        	case 2:
        		//place the correct answer at option B
        		b.setText(questionAnswer.getAnswer());
        		//place the wrong answers at remaining options
        		a.setText(wrongAnswer2);
        		c.setText(wrongAnswer1);
        		d.setText(wrongAnswer3);
        		break;
        	case 3:
        		//place the correct answer at option C
        		c.setText(questionAnswer.getAnswer());
        		//place the wrong answers at remaining options
        		b.setText(wrongAnswer3);
        		a.setText(wrongAnswer2);
        		d.setText(wrongAnswer1);
        		break;
        	case 4:
        		//place the correct answer at option D
        		d.setText(questionAnswer.getAnswer());
        		//place the wrong answers at remaining options
        		a.setText(wrongAnswer1);
        		b.setText(wrongAnswer2);
        		c.setText(wrongAnswer3);
        		break;
        }  
        
        // re-enable all the buttons
        a_button.setEnabled(true);
	    b_button.setEnabled(true);
	    c_button.setEnabled(true);
	    d_button.setEnabled(true);
	}
	
}
