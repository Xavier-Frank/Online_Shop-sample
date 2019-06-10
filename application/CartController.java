package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController implements Initializable{
	  @FXML
	    private TableView<Cart> tableview;

	    @FXML
	    private TableColumn<Cart, String> category;

	    @FXML
	    private TableColumn<Cart, String> name;

	    @FXML
	    private TableColumn<Cart, String> productId;

	    @FXML
	    private TableColumn<Cart, Float> price;
	    
	    ObservableList<Cart> product=FXCollections.observableArrayList();

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			try(Connection connection=DBConnection.getConnection();
					java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
					ResultSet resultSet=statement.executeQuery("Select * Cart");) {
				product.add(new Cart(resultSet.getString("CATEGORY"),resultSet.getString("NAME") ,resultSet.getString("PRODUCT_ID") ,resultSet.getFloat("PRICE") ));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			category.setCellValueFactory(new PropertyValueFactory<>("CATEGORY"));
			name.setCellValueFactory(new PropertyValueFactory<>("NAME"));
			productId.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
			price.setCellValueFactory(new PropertyValueFactory<>("PRICE"));
			
			
		}

	    
}
