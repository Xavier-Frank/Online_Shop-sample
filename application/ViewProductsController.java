package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewProductsController implements Initializable{
	  @FXML
	    private TableView<Products> tableView;

	    @FXML
	    private TableColumn<Products,String> CATEGORY;

	    @FXML
	    private TableColumn<Products,String> NAME;

	    @FXML
	    private TableColumn<Products,String> PRODUCT_ID;

	    @FXML
	    private TableColumn<Products, String> DESCRIPTION;

	    @FXML
	    private TableColumn<Products,Integer> QUANTITY;

	    @FXML
	    private TableColumn<Products,Integer> WARRANTY;

	    @FXML
	    private TableColumn<Products, Float> PRICE;
	    @FXML
	    private TableColumn<Products, String> ImagePath;
	    
	    ObservableList<Products> product=FXCollections.observableArrayList();

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			try(Connection connection=DBConnection.getConnection();
					java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
					ResultSet resultSet=statement.executeQuery("Select * from Product");){
				while (resultSet.next()) {
					product.add(new Products(resultSet.getString("CATEGORY"),resultSet.getString("NAME") ,resultSet.getString("PRODUCT_ID") ,resultSet.getString("DESCRIPTION"),resultSet.getString("ImagePath") ,resultSet.getInt("QUANTITY") , null, resultSet.getFloat("PRICE")));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
					
				CATEGORY.setCellValueFactory(new PropertyValueFactory<>("CATEGORY"));	
				NAME.setCellValueFactory(new PropertyValueFactory<>("NAME"));
				PRODUCT_ID.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
				DESCRIPTION.setCellValueFactory(new PropertyValueFactory<>("DESCRIPTION"));
				ImagePath.setCellValueFactory(new PropertyValueFactory<>("ImagePath"));
				QUANTITY.setCellValueFactory(new PropertyValueFactory<>("QUANTITY"));
//				WARRANTY.setCellValueFactory(new PropertyValueFactory<>("WARRANTY"));
				PRICE.setCellValueFactory(new PropertyValueFactory<>("PRICE"));
				
				tableView.setItems(product);
				
			
		}
		public void Back(ActionEvent event) throws IOException {
			try {
				
				Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AdminPage.fxml"));
				Scene main = new Scene(frontPage);
				Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
				stage.setScene(main);
				stage.show();
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}


}
