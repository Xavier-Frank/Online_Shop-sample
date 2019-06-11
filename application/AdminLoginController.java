package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AdminLoginController {
	@FXML
	private TextField txtUsername;
	@FXML
	private Label lbl1;
	@FXML
	private Label lbl2;
	@FXML
	private Label lbl3;
	
	@FXML
	private PasswordField pass;
	 @FXML
	    private Label lbl11;
	
	public void AdminLogin(ActionEvent event) throws Exception {
		String USERNAME=txtUsername.getText();
		String PASSWORD=pass.getText();
		lbl1.setText("");
		lbl2.setText("");
		lbl3.setText("");
		
		try (Connection conn = DBConnection.getConnection();
				Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery("select * from Admin");){
			

			if (USERNAME.equals("")) {
				lbl2.setText("Add a username");
				lbl2.setTextFill(Color.PALEVIOLETRED);
				}
				if (PASSWORD.equals("")) {
					lbl3.setText("Add a username");
					lbl3.setTextFill(Color.PALEVIOLETRED);
				}
				while (resultSet.next()) {
					if (!resultSet.getString("USERNAME").equals(USERNAME) || !resultSet.getString("PASSWORD").equals(PASSWORD)) {
						lbl1.setText("Invalid Password or Username");
						lbl1.setTextFill(Color.RED);
					}
					if (resultSet.getString("USERNAME").equals(USERNAME) && resultSet.getString("PASSWORD").equals(PASSWORD)) {
						lbl1.setText("Login Successfull");
						lbl1.setTextFill(Color.GREEN);
						
						Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AdminPage.fxml"));
						Scene main = new Scene(frontPage);
						Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
						stage.setScene(main);
						stage.show();
						
					}
					
						
					}
				
				
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
	public void cancel(ActionEvent event) throws Exception {
		Parent frontPage=FXMLLoader.load(getClass().getResource("/application/MyProductPage2.fxml"));
		Scene main = new Scene(frontPage);
		Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(main);
		stage.show();
		
	}

}
