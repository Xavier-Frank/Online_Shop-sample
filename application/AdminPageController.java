package application;


import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

//Administrative methods
public class AdminPageController {
	 @FXML
	    private Label lbl1;
	
	public void addAdmin(ActionEvent event) throws Exception {
		try {
			
			Parent adminPage=FXMLLoader.load(getClass().getResource("/application/AddAdmin.fxml"));
			Scene main = new Scene(adminPage);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(main);
			stage.show();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void viewAdmins(ActionEvent event) throws IOException {
		//create a view page
		try {
			
			Parent adminPage=FXMLLoader.load(getClass().getResource("/application/ViewAdmins.fxml"));
			Scene main = new Scene(adminPage);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(main);
			stage.show();
			
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
	
	public void deleteAdmin(ActionEvent event) throws IOException {
		//delete page
		try {
			
			Parent frontPage=FXMLLoader.load(getClass().getResource("/application/DeleteAdmin.fxml"));
			Scene main = new Scene(frontPage);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(main);
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
		
	
//User methods
	public void addUser(ActionEvent event) throws Exception{
		try {
			Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AddUser.fxml"));
			Scene main = new Scene(frontPage);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(main);
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		
		}		
	}
	public void viewUser(ActionEvent event) {
//		//create view page
		try {
			Parent frontPage=FXMLLoader.load(getClass().getResource("/application/ViewUser.fxml"));
			Scene main = new Scene(frontPage);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(main);
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}		
	public void deleteUser(ActionEvent event) throws Exception {
		//create delete page
		try {
			
			Parent frontPage=FXMLLoader.load(getClass().getResource("/application/DeleteUser.fxml"));
			Scene main = new Scene(frontPage);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(main);
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	//Product methods
	public void addProducts(ActionEvent event) throws Exception {
		//create add product page
		try {
			Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AddProducts.fxml"));
			Scene main = new Scene(frontPage);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(main);
			stage.show();			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void viewProduct(ActionEvent event) {
		//create view product page
			try {
				
				Parent frontPage=FXMLLoader.load(getClass().getResource("/application/ViewProducts.fxml"));
				Scene main = new Scene(frontPage);
				Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
				stage.setScene(main);
				stage.show();
			} catch (Exception e) {
				System.out.println(e);
			}
	}
			
		
		
//	public void searchProduct(ActionEvent event) {
//		//search product page
//		
//	}
//	public void editProducts(ActionEvent event) {
//		//edit product page
//		
//	}
	public void deleteProduct(ActionEvent event) throws IOException {
		Parent frontPage=FXMLLoader.load(getClass().getResource("/application/DeleteProduct.fxml"));
		Scene main = new Scene(frontPage);
		Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(main);
		stage.show();
		
	}
	public void Back(ActionEvent event) throws IOException {
		
	Parent frontPage=FXMLLoader.load(getClass().getResource("/application/MyProductPage.fxml"));
	Scene main = new Scene(frontPage);
	Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
	stage.setScene(main);
	stage.show();
	}
	
}
	
	

