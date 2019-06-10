package application;


public class Cart {
	
	String CATEGORY,NAME,PRODUCT_ID;
	Float PRICE;
	
	public Cart(String CATEGORY,String NAME,String PRODUCT_ID,Float PRICE) {
		this.CATEGORY=CATEGORY;
		this.NAME=NAME;
		this.PRODUCT_ID=PRODUCT_ID;
		this.PRICE=PRICE;
	}
	//GETTER METHODS
	public String getCATEGORY() {
		return CATEGORY;
	}public String getNAME() {
		return NAME;
	}public Float getPRICE() {
		return PRICE;
	}public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	//setter methods
	public void setCATEGORY(String CATEGORY) {
		this.CATEGORY = CATEGORY;
	}public void setNAME(String NAME) {
		this.NAME = NAME;
	}public void setPRICE(Float PRICE) {
		this.PRICE = PRICE;
	}public void setPRODUCT_ID(String PRODUCT_ID) {
		this.PRODUCT_ID = PRODUCT_ID;
	}
}
