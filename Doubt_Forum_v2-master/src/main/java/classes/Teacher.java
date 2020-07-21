/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author adesh
 */
public class Teacher 
{
    String name;
    String password;
    String email;
    String id;
    public Teacher(String name,String password,String id,String email) {
        this.name=name;
        this.password=password;
        this.id=id;
        this.email=email;
    }

    public Teacher() {
        
    }
    public String getName() {
		return this.name;
	}
	
	public void setName(String nametion) {
		this.name = nametion;
	}
        public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String teacher) {
		this.password = teacher;
	}
        public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
        public String getemail() {
		return this.email;
	}
	public void setemail(String email) {
		this.email = email;
	}
        public String toString() {
		return (this.id + "\t\t " + this.name + " \nStudent id: " + this.email+ "\t\t"+this.password+"");
	}
}
