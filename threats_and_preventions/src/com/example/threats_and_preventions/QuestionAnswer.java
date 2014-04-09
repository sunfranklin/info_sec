package com.example.threats_and_preventions;

public class QuestionAnswer {

	//private variables
//    private String _id;
    private String _question;
    private String _answer;
     
    // Empty constructor
    public QuestionAnswer (){
         
    }
     
    // constructor with question and answer
    public QuestionAnswer (String question, String answer){
        this._question = question;
        this._answer = answer;
    }
     
    // getting answer
    public String getAnswer(){
        return this._answer;
    }
     
    // setting answer
    public void setAnswer(String answer){
        this._answer = answer;
    }
     
    // getting phone number
    public String getQuestion(){
        return this._question;
    }
     
    // setting phone number
    public void setQuestion(String question){
        this._question = question;
    }
}
