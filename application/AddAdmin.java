package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class AddAdmin {
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
	
	public void addAdmin(ActionEvent event) throws Exception {
		String USERNAME = txtUsername.getText();
		String PASSWORD = pass.getText();
		lbl1.setText("");
		lbl2.setText("");
		lbl3.setText("");
		
		try(Connection conn = DBConnection.getConnection();
				Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery("select USERNAME from Admin");) {
			Boolean validDetails =true;
			
			if (USERNAME.equals("")) {
				validDetails=false;
				lbl2.setText("Add a username");
				lbl2.setTextFill(Color.PALEVIOLETRED);
				}
				if (PASSWORD.equals("")) {
					validDetails=false;
					lbl3.setText("Add a Password");
					lbl3.setTextFill(Color.PALEVIOLETRED);
				}
				while (resultSet.next()) {
					if (resultSet.getString("USERNAME").equals(USERNAME)) {
						lbl2.setText("Username already taken");
						lbl2.setTextFill(Color.RED);
						break;
					}
				
					
				}
				if (validDetails) {
					String sql = "INSERT INTO Admin(USERNAME,PASSWORD)" + "values(?,?)";
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1, USERNAME);
					stmt.setString(2, PASSWORD);
					stmt.executeUpdate();
					
					Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AdminPage.fxml"));
					Scene main = new Scene(frontPage);
					Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
					stage.setScene(main);
					stage.show();
				}
		}catch (Exception e) {
			System.out.println(e);
		}
				
		
	}
	public void cancel(ActionEvent event) {

		try {
			Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AdminPage.fxml"));
			Scene main = new Scene(frontPage);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(main);
			stage.show();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
//		
	}
}

			
			
		
				
				
				


