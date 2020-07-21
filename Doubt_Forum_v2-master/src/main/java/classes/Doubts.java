package classes;

import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adesh
 */
public class Doubts {
    String ques;
    String ans;
    String qid;
    String stid;

    public Doubts(String ques,String ans,String qid,String stid) {
        this.ques=ques;
        this.ans=ans;
        this.qid=qid;
        this.stid=stid;
    }

    
    public Doubts() {
        
    }
    public String getQuestion() {
		return this.ques;
	}
	
	public void setQuestion(String question) {
		this.ques = question;
	}
        public String getAnswer() {
		return this.ans;
	}
	
	public void setAnswer(String teacher) {
		this.ans = teacher;
	}
        public String getId() {
		return this.qid;
	}
	public void setId(String id) {
		this.qid = id;
	}
        public String getStId() {
		return this.stid;
	}
	public void setStId(String id) {
		this.stid = id;
	}
        public String toString() {
		return (this.qid + "\t\t " + this.ques + " \nStudent id: " + this.stid+ "\t\t"+this.ans+"");
	}
    
}
