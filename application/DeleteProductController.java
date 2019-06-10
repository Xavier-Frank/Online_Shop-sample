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

	public class DeleteProductController {
		 @FXML
		   private TextField productId;
		    @FXML
		    private Label lbl1;
		    
		public void deleteProduct(ActionEvent event) {
			lbl1.setText("");
			String PRODUCT_ID=productId.getText();
			try(Connection connection=DBConnection.getConnection();
					java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
					ResultSet resultSet=statement.executeQuery("Select * from Product");) {
				Boolean isValidBoolean=true;
				while (resultSet.next()) {
					if (resultSet.getString("").equals(PRODUCT_ID)) {
						lbl1.setText("Product id does not exist");
						lbl1.setTextFill(Color.RED);
						isValidBoolean=false;
						
					}
					if (PRODUCT_ID.equals("")) {
						lbl1.setText("Field required");
						lbl1.setTextFill(Color.RED);
						isValidBoolean=false;
					}
					if (isValidBoolean) {
						String sqlString="DELETE FROM Product WHERE PRODUCT_ID=?";
						PreparedStatement preparedStatement=connection.prepareStatement(sqlString);
						
						preparedStatement.setString(1, PRODUCT_ID);
						
						preparedStatement.executeUpdate();
						
						Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AdminPage.fxml"));
						Scene main = new Scene(frontPage);
						Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
						stage.setScene(main);
						stage.show();
					}
						
				}
						
						
						
						
						
					
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	public void cancel(ActionEvent event) throws IOException {
		Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AdminPage.fxml"));
		Scene main = new Scene(frontPage);
		Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(main);
		stage.show();
		
	}


}
