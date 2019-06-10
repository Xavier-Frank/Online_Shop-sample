package application;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SignUpController {
	
	@FXML
	private TextField fName;
	@FXML
	private TextField lName;
	@FXML
	private TextField userName;
	@FXML
	private TextField password;
	@FXML
	private TextField password1;
	@FXML
	private Label lbl1;
	@FXML
	private Label lbl2;
	@FXML
	private Label lbl3;
	@FXML
	private Label lbl4;
	@FXML
	private Label lbl5;
	@FXML
	private Label lbl6;
	@FXML
	private Button signUp;
	
	public void signUpProcess(ActionEvent event){
		String FIRST_NAME =fName.getText();
		String LAST_NAME =lName.getText();
		String USERNAME =userName.getText();
		String PASSWORD =password.getText();
		String passWord1 =password1.getText();
		lbl1.setText("");
		lbl2.setText("");
		lbl3.setText("");
		lbl4.setText("");
		lbl5.setText("");
		lbl6.setText("");
		
		try(
				Connection conn = DBConnection.getConnection();
				Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery("select USERNAME from Customer");) {
		
		Boolean validDetails = true;
		
		if (FIRST_NAME.equals("")) {
			validDetails = false;
			lbl1.setText("Add firstname");
			lbl1.setTextFill(Color.PALEVIOLETRED);
		}
		if (LAST_NAME.contentEquals("")) {
			validDetails = false;
			lbl2.setText("Add lastname");
			lbl2.setTextFill(Color.PALEVIOLETRED);
		}
		if (USERNAME.equals("")) {
			validDetails = false;
			lbl3.setText("Add a username");
			lbl3.setTextFill(Color.PALEVIOLETRED);
		}
		if (!USERNAME.contains("@") || !USERNAME.contains(".") || !USERNAME.contains("com") || (USERNAME.indexOf("@") == 0) || (USERNAME.indexOf(".") == 0)) {
			validDetails = false;
			lbl3.setText("Invalid username");
			lbl3.setTextFill(Color.DARKRED);			
		}
		if (PASSWORD.equals("")) {
			validDetails = false;
			lbl4.setText("add a password");
			lbl4.setTextFill(Color.PALEVIOLETRED);
		}
		if (!PASSWORD.equals(passWord1)) {
			validDetails = false;
			lbl5.setText("Password do not match");
			lbl5.setTextFill(Color.PALEVIOLETRED);
		}
		if (PASSWORD.equals(passWord1)) {
			lbl6.setText("Sign up now");
			lbl6.setTextFill(Color.GREEN);
			}
		while (resultSet.next()) {
			if (resultSet.getString("USERNAME").equals(USERNAME)) {
				lbl3.setText("Username already taken");
				lbl3.setTextFill(Color.RED);
				break;
				
			}
			
			
		}
		if (validDetails) {
			
			String sql= "INSERT INTO Customer (FIRST_NAME,LAST_NAME,USERNAME,PASSWORD)" + "VALUES(?,?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, FIRST_NAME);
			stmt.setString(2, LAST_NAME);
			stmt.setString(3, USERNAME);
			stmt.setString(4, PASSWORD);
			
			stmt.executeUpdate();
			
			
			Parent frontPage=FXMLLoader.load(getClass().getResource("/application/loginScreen.fxml"));
			Scene main = new Scene(frontPage);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(main);
			stage.show();
			
			
		}
		
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void cancel(ActionEvent event) throws Exception {
		
		try {
			Parent frontPage=FXMLLoader.load(getClass().getResource("/application/MyProductPage2.fxml"));
			Scene main = new Scene(frontPage);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(main);
			stage.show();
			
			
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
//		
	}
	
		
			
		
			
	

}
