package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DeleteUserController {
	@FXML
	private TextField txtUsername;
	@FXML
	private Label lbl1;
	@FXML
	private Label lbl2;
	
	public void deleteUser(ActionEvent event) {
		String USERNAME=txtUsername.getText();
		lbl1.setText("");
		lbl2.setText("");
		
		try(Connection connection = DBConnection.getConnection();
				java.sql.Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet resultSet=statement.executeQuery("select * from Customer")) {
			
			if (USERNAME.equals("")) {
				lbl2.setText("Add a Username");
				
			}
			while (resultSet.next()) {
				if (! resultSet.getString("USERNAME").equals(USERNAME)) {
					lbl1.setText("UserName does not exist");
					lbl1.setTextFill(Color.RED);
				}
				if (resultSet.getString("USERNAME").equals(USERNAME)) {
					String sql="DELETE FROM Customer where USERNAME=?";
					PreparedStatement stmt=connection.prepareStatement(sql);
					
					stmt.setString(1, USERNAME);
					stmt.executeUpdate();
					
					Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AdminPage.fxml"));
					Scene main = new Scene(frontPage);
					Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
					stage.setScene(main);
					stage.show();
					
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	public void Cance(ActionEvent event) throws IOException {
		Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AdminPage.fxml"));
		Scene main = new Scene(frontPage);
		Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(main);
		stage.show();
		
	}
	

}
