package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.omg.CORBA.PUBLIC_MEMBER;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;

public class CartController implements Initializable{
	  @FXML
	    private TableColumn<Cart, Float> price;

	    @FXML
	    private Label deletelbl;
	    @FXML
	    private Label total;
	    @FXML
	    private TableView<Cart> tableview;
	    @FXML
	    private Button totalButton;


	    @FXML
	    private TableColumn<Cart, String> category;

	    @FXML
	    private TableColumn<Cart, String> name;

	    @FXML
	    private TableColumn<Cart, String> productId;

	    @FXML
	    private TableColumn<Cart, Integer> quantity;

	    @FXML
	    private Button backbutton;
	    
	   public static ObservableList<Cart> product=FXCollections.observableArrayList();
	
		@Override
		public void initialize(URL location, ResourceBundle resources) { 
			//make table editable
			tableview.setEditable(true);
			
			try(Connection connection=DBConnection.getConnection();
					java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE)){
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			category.setCellValueFactory(new PropertyValueFactory<>("CATEGORY"));
			name.setCellValueFactory(new PropertyValueFactory<>("NAME"));
			productId.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
			quantity.setCellValueFactory(new PropertyValueFactory<>("QUANTITY"));
			price.setCellValueFactory(new PropertyValueFactory<>("PRICE"));
			
			
			tableview.setItems(product);
		}
		public void total(ActionEvent event) {
			double ttl=0.0;
			for (Cart cart : product) {
				ttl+= cart.getPRICE() * cart.getQUANTITY();
			}
			total.setText("Ksh" + ttl);
			
			
		}
		public void delete(ActionEvent event) {
			double ttl=0.0;
			Cart cart=tableview.getSelectionModel().getSelectedItem();
			tableview.getItems().remove(cart);
			
			for (Cart cart1 : product) {
				ttl+=cart1.getPRICE() * cart1.getQUANTITY();
				
			}
			total.setText("Kshs." + ttl);
			
			tableview.setItems(product);
			
		}
		
		public void Back (ActionEvent event) {
			try {
				
				Parent frontPage=FXMLLoader.load(getClass().getResource("/application/MyProduct2.fxml"));
				Scene main = new Scene(frontPage);
				Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
				stage.setScene(main);
				stage.show();
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		public void buy(ActionEvent event) {
try {
				
				Parent frontPage=FXMLLoader.load(getClass().getResource("/application/Buy.fxml"));
				Scene main = new Scene(frontPage);
				Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
				stage.setScene(main);
				stage.show();
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		

	    
}
