package application;

import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SignUpButtonController {
	@FXML
    private TextField fName;

    @FXML
    private TextField lName;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password1;

    @FXML
    private Button signUp;

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
	
	public void signUpProcess(ActionEvent event){
		lbl1.setText("");lbl2.setText("");lbl3.setText("");lbl4.setText("");lbl5.setText("");
		
		try(Connection connection=DBConnection.getConnection();
				Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
				ResultSet resultSet=statement.executeQuery("Select * from Customer");){	
			Boolean isValidBoolean=true;
		
			while (resultSet.next()) {
				if (fName.getText().equals("")) {
					lbl1.setText("Field required");
					lbl1.setTextFill(Color.RED);
					isValidBoolean=false;
				}
				if (lName.getText().equals("")) {
					lbl2.setText("FileDataSource required");
					lbl2.setTextFill(Color.RED);
					isValidBoolean=false;
					
				}
				if (userName.getText().equals("")) {
					lbl3.setText("FileDataSource required");
					lbl3.setTextFill(Color.RED);
					isValidBoolean=false;
				}if (password.getText().equals("")) {
					lbl4.setText("FileDataSource required");
					lbl4.setTextFill(Color.RED);
					isValidBoolean=false;
					
				}if (! password.getText().equals(password1.getText())) {
					lbl5.setText("Passwords not match");
					lbl5.setTextFill(Color.RED);
					isValidBoolean=false;
				}
				if (resultSet.getString("USERNAME").equals(userName.getText())) {
					lbl3.setText("USername alraedy taken");
					lbl3.setTextFill(Color.RED);
					isValidBoolean=false;
					
				}
			}
			if (isValidBoolean) {
				String sql= "INSERT INTO Customer (FIRST_NAME,LAST_NAME,USERNAME,PASSWORD)" + "VALUES(?,?,?,?)";
				PreparedStatement stmt=connection.prepareStatement(sql);
				
				stmt.setString(1, fName.getText());
				stmt.setString(2, lName.getText());
				stmt.setString(3, userName.getText());
				stmt.setString(4, password.getText());
				
				stmt.executeUpdate();
				
				
				Parent frontPage=FXMLLoader.load(getClass().getResource("/application/loginScreen.fxml"));
				Scene main = new Scene(frontPage);
				Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
				stage.setScene(main);
				stage.show();
			}
		} catch (Exception e) {
			System.out.println(e);
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
