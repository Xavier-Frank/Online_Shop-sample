package application;

public class Products {
	String CATEGORY,NAME,PRODUCT_ID,DESCRIPTION,ImagePath;
	Integer QUANTITY,WARRANTY;
	Float PRICE;
	
	public Products(String CATEGORY,String NAME,String PRODUCT_ID,String DESCRIPTION,String ImagePath,Integer QUANTITY,Integer WARRANTY,Float PRICE) {
		this.CATEGORY=CATEGORY;
		this.NAME=NAME;
		this.PRODUCT_ID=PRODUCT_ID;
		this.DESCRIPTION=DESCRIPTION;
		this.QUANTITY=QUANTITY;
		this.WARRANTY=WARRANTY;
		this.PRICE=PRICE;
		this.ImagePath=ImagePath;
	}
	//getter methods
	public String getCATEGORY() {
		return CATEGORY;
	}public String getNAME() {
		return NAME;
	}public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}public String getDESCRIPTION() {
		return DESCRIPTION;
	}public Integer getQUANTITY() {
		return QUANTITY;
	}public Integer getWARRANTY() {
		return WARRANTY;
	}public Float getPRICE() {
		return PRICE;
	}public String getImagePage() {
		return ImagePath;
	}
	//setter methods
	public void setCATEGORY(String CATEGORY) {
		this.CATEGORY = CATEGORY;
	}public void setNAME(String NAME) {
		this.NAME = NAME;
	}public void setPRODUCT_ID(String PRODUCT_ID) {
		this.PRODUCT_ID = PRODUCT_ID;
	}public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
	}public void setQUANTITY(Integer QUANTITY) {
		this.QUANTITY = QUANTITY;
	}public void setWARRANTY(Integer WARRANTY) {
		this.WARRANTY = WARRANTY;
	}public void setPRICE(Float PRICE) {
		this.PRICE = PRICE;
	}public void setImagePage(String imagePage) {
		ImagePath = imagePage;
	}

}
