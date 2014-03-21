package com.example.threats_and_preventions;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseQuiz extends SQLiteOpenHelper {

	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "questionAnswerManager";
 
    // question_answer table name
    private static final String TABLE_QUESTION_ANSWER = "QuestionAnswer";
 
    // QuestionAnswer Table Columns names
    //private static final String KEY_ID = "id";
    private static final String KEY_QUESTION = "Question";
    private static final String KEY_ANSWER = "Answer";
 
    public DatabaseQuiz (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
	@Override
	public void onCreate(SQLiteDatabase dbq) {
		String CREATE_QA_TABLE = "CREATE TABLE " + TABLE_QUESTION_ANSWER + "("
                + KEY_QUESTION + " TEXT NOT NULL PRIMARY KEY," + KEY_ANSWER + " TEXT NOT NULL" + ")";
        dbq.execSQL(CREATE_QA_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase dbq, int oldVersion, int newVersion) {
		// Drop older table if existed
        dbq.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION_ANSWER);
 
        // Create tables again
        onCreate(dbq);
	}


	public void deleteTable() {
		// Drop older table if existed
		//dbq.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION_ANSWER);

		String selectQuery = "DROP TABLE IF EXISTS " + TABLE_QUESTION_ANSWER;

		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL(selectQuery);

		// Create tables again
		onCreate(db);
	}

	// Adding new Question-Answer
	public void addQA(QuestionAnswerID questionAnswer) {
		SQLiteDatabase dbq = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_QUESTION, questionAnswer.getQuestion()); // QAID question
		values.put(KEY_ANSWER, questionAnswer.getAnswer()); // QAID Answer

		// Inserting Row
		dbq.insert(TABLE_QUESTION_ANSWER, null, values);
		dbq.close(); // Closing database connection
	}
	
	
	// Getting single question_Answer
	public QuestionAnswerID getQuestionAnswer(String ques) {
	    SQLiteDatabase db = this.getReadableDatabase();
	 
	    Cursor cursor = db.query(TABLE_QUESTION_ANSWER, new String[] {
	            KEY_QUESTION, KEY_ANSWER }, KEY_QUESTION + "=?",
	            new String[] { String.valueOf(ques) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    QuestionAnswerID questionAnswerId = new QuestionAnswerID (cursor.getString(0),
	            cursor.getString(1));
	    // return question-Answer-ID
	    return questionAnswerId;
	}
	
	
	// Getting All Question-Answer
	public List<QuestionAnswerID> getAllQuestionAnswer() {
		List<QuestionAnswerID> questionAnswerList = new ArrayList<QuestionAnswerID>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUESTION_ANSWER;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				QuestionAnswerID questionAnswer = new QuestionAnswerID();
				//questionAnswerId.setID(cursor.getString(0));
				questionAnswer.setQuestion(cursor.getString(0));
				questionAnswer.setAnswer(cursor.getString(1));
				
				// Adding Question-Answer-Id to list
				questionAnswerList.add(questionAnswer);
			} while (cursor.moveToNext());
		}

		// return Question-Answer-Id list
		return questionAnswerList;
	}


	// Getting All distinct Answers
	public List<String> getAllAnswers() {
		List<String> answerList = new ArrayList<String>();
		// Select All Query
		String selectQuery = "SELECT DISTINCT " + KEY_ANSWER + " FROM " + TABLE_QUESTION_ANSWER;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				String answer = new String(cursor.getString(0));

				// Adding Question-Answer-Id to list
				answerList.add(answer);
			} while (cursor.moveToNext());
		}

		// return Question-Answer-Id list
		return answerList;
	}

	
	// Getting Question-Answer Count
    public int getQuestionAnswerCount() {
        String countQuery = "SELECT  * FROM " + TABLE_QUESTION_ANSWER;
        SQLiteDatabase dbq = this.getReadableDatabase();
        Cursor cursor = dbq.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
    
    // Updating single contact
//    public int updateQuestionAnswerId(QuestionAnswerID questionAnswerId) {
//        SQLiteDatabase db = this.getWritableDatabase();
//     
//        ContentValues values = new ContentValues();
//        values.put(KEY_QUESTION, questionAnswerId.getQuestion());
//        values.put(KEY_ANSWER, questionAnswerId.getAnswer());
//     
//        // updating row
//        return db.update(TABLE_QUESTION_ANSWER, values,KEY_QUESTION + " = ?",
//                new String[] { String.valueOf(questionAnswerId.getID()) });
//    }
    
    
    // Deleting single Question-Answer
    public void deleteContact(QuestionAnswerID questionAnswerId) {
    	SQLiteDatabase dbq = this.getWritableDatabase();
    	dbq.delete(TABLE_QUESTION_ANSWER, KEY_QUESTION + " = ?",
    			new String[] { String.valueOf(questionAnswerId.getAnswer()) });
    	dbq.close();
    }
	 
    
}
