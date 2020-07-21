/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adesh
 */




/**
 *
 * @author adesh
 */
public class student
{
	//private Map<String,String> doubt = new HashMap<>();
        private String id;
     //  private String username;
        private String name;
        private String email;
        private String password; 
      
  
        public student(String id,String name,String email,String password)
         {
                this.id=id;
		this.name = name;
		this.email = email;
		this.password = password;
		
	 }

           public String getId() {
		return this.id;
	  }
	   public String getname() {
		return this.name;
	    }
	
           public String getemail() {
		return this.email;
	    }
           public void setname(String name) {
		this.name=name;
	    }
            public void setid(String id) {
		this.id = id;
	   }
            public void setemail(String email) {
		this.email=email;
	   }
         
           public void setpassword(String password) {
		this.password=password;
	   }
           
           public String getpassword() {
		return this.password;
	   } 
              
}
