package application;



public class Person {
	private String FIRST_NAME,LAST_NAME,USERNAME;
	
	public Person(String FIRST_NAME,String LAST_NAME,String USERNAME) {
		this.FIRST_NAME= new String(FIRST_NAME);
		this.LAST_NAME=new String(LAST_NAME);
		this.USERNAME= new String(USERNAME);
		
		
	}
	public Person(String USERNAME) {
		this.USERNAME=USERNAME;
		// TODO Auto-generated constructor stub
	}
	//getters
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	//setters
	public void setFIRST_NAME(String FIRST_NAME) {
		this.FIRST_NAME = FIRST_NAME;
	}
	public void setLAST_NAME(String LAST_NAME) {
		this.LAST_NAME = LAST_NAME;
	}
	public void setUSERNAME(String USERNAME) {
		this.USERNAME = USERNAME;
	}

}
