package com.example.threats_and_preventions;

public class QuestionAnswerID {

	//private variables
//    private String _id;
    private String _question;
    private String _answer;
     
    // Empty constructor
    public QuestionAnswerID (){
         
    }
//    // constructor with question, answer and id
//    public QuestionAnswerID (String id, String question, String _answer){
//        this._id = id;
//        this._question = question;
//        this._answer = _answer;
//    }
     
    // constructor with question and answer
    public QuestionAnswerID (String question, String answer){
        this._question = question;
        this._answer = answer;
    }
//    // getting ID
//    public String getID(){
//        return this._id;
//    }
     
//    // setting id
//    public void setID(String id){
//        this._id = id;
//    }
     
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
