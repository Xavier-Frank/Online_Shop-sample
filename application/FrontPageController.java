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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class FrontPageController implements Initializable {
	
		// login page
		public void Starting(ActionEvent event)throws Exception {

			try {
				Parent frontPage=FXMLLoader.load(getClass().getResource("/application/loginScreen.fxml"));
				Scene main = new Scene(frontPage);
				Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
				stage.setScene(main);
				stage.show();
			} catch (Exception e) {
				System.out.println(e);
				// TODO: handle exception
			}
		}
		//sign up page
		public void signUp(ActionEvent event) throws Exception{

			try {
				Parent frontPage=FXMLLoader.load(getClass().getResource("/application/signUpScreen.fxml"));
				Scene main = new Scene(frontPage);
				Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
				stage.setScene(main);
				stage.show();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		public void Admin(ActionEvent event) throws Exception{
			try {
				Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AdminLogin.fxml"));
				Scene main = new Scene(frontPage);
				Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
				stage.setScene(main);
				stage.show();
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		public void cart(ActionEvent event) {
			try {
				Parent frontPage=FXMLLoader.load(getClass().getResource("/application/Cart.fxml"));
				Scene main = new Scene(frontPage);
				Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
				stage.setScene(main);
				stage.show();
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}

		  @FXML
		    private ImageView image1;

		    @FXML
		    private Label name1;

		    @FXML
		    private Label price1;

		    @FXML
		    private Button addToCart1;

		    @FXML
		    private Label desc1;

		    @FXML
		    private ImageView image2;

		    @FXML
		    private Label name2;

		    @FXML
		    private Label price2;

		    @FXML
		    private Label desc2;

		    @FXML
		    private Button addToCart2;

		    @FXML
		    private ImageView image3;

		    @FXML
		    private Button addToCart3;
		    @FXML
		    private Label price3;

		    @FXML
		    private Label name3;

		    @FXML
		    private Label desc3;
		    
		    int productId1,productId2,productId3;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
			try(Connection connection=DBConnection.getConnection();
					java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
					ResultSet resultSet=statement.executeQuery("Select * from Product")) {
				
				System.out.println("hellooooooo");
				for (int i = 0; i < 3; i++) {
					if (resultSet.next()) {
						
					switch (i) {
					case 0:
						productId1 = resultSet.getInt("PRODUCT_ID");
						
						Image image = new Image(resultSet.getString("ImagePath"));
						image1.setImage(image);
						name1.setText(resultSet.getString("NAME"));
						price1.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
						desc1.setText(resultSet.getString("DESCRIPTION"));
						break;
					case 1:
						productId2 = resultSet.getInt("PRODUCT_ID");
						
						Image image1 = new Image(resultSet.getString("ImagePath"));
						image2.setImage(image1);
						name2.setText(resultSet.getString("NAME"));
						price2.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
						desc2.setText(resultSet.getString("DESCRIPTION"));
					case 2:
						productId3 = resultSet.getInt("PRODUCT_ID");
						
						Image image2 = new Image(resultSet.getString("ImagePath"));
						image3.setImage(image2);
						name3.setText(resultSet.getString("NAME"));
						price3.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
						desc3.setText(resultSet.getString("DESCRIPTION"));
					}
					
				}
				
				}
				
				
			} catch (Exception e) {
				System.out.println(e);
				
			}
			
		}
	//keeps info of the current page
	int count=3; 
	public void next(ActionEvent event) {
		try (Connection connection=DBConnection.getConnection();
					java.sql.Statement statement=connection.createStatement();
					ResultSet resultSet=statement.executeQuery("Select * from Product");) {
			
			for (int i = 0; i < count; i++) { //update to the current product in the table
				resultSet.next();
				
			}
			for (int i = 0; i < 3; i++) {
				if (resultSet.next()) {
					count++;
					switch (i) {
					case 0:
						productId1 = resultSet.getInt("PRODUCT_ID");
						
						Image image = new Image(resultSet.getString("ImagePath"));
						image1.setImage(image);
						name1.setText(resultSet.getString("NAME"));
						price1.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
						desc1.setText(resultSet.getString("DESCRIPTION"));
						break;
					case 1:
						productId2 = resultSet.getInt("PRODUCT_ID");
						
						Image image1 = new Image(resultSet.getString("ImagePath"));
						image2.setImage(image1);
						name2.setText(resultSet.getString("NAME"));
						price2.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
						desc2.setText(resultSet.getString("DESCRIPTION"));
					case 2:
						productId3 = resultSet.getInt("PRODUCT_ID");
						
						Image image2 = new Image(resultSet.getString("ImagePath"));
						image3.setImage(image2);
						name3.setText(resultSet.getString("NAME"));
						price3.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
						desc3.setText(resultSet.getString("DESCRIPTION"));
					}
					
				}
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public void preview(ActionEvent event) {
		if (count > 3) { 
			count -= 3; 
			}
		
		try (Connection connection=DBConnection.getConnection();
				java.sql.Statement statement=connection.createStatement();
				ResultSet resultSet=statement.executeQuery("Select * from Product");) {
			
//			moves cursor to the current row in the result set
			for (int i = 0; i < count; i++) {
				resultSet.next();
			}

		 for (int i = 1; i < 4; i++) { 
			 if (resultSet.previous()) { 
				 switch (i) { 
				 	case 3:
				 		productId1 = resultSet.getInt("PRODUCT_ID");
				 		
				 		Image image = new Image(resultSet.getString("ImagePath"));
				 		image1.setImage(image);
				 		name1.setText(resultSet.getString("NAME"));
				 		price1.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
				 		desc1.setText(resultSet.getString("DESCRIPTION")); 
				 		break; 
				 	case 2:
				 		productId2 = resultSet.getInt("PRODUCT_ID");
				 		
				 		Image image1 = new Image(resultSet.getString("ImagePath"));
				 		image2.setImage(image1);
				 		name2.setText(resultSet.getString("NAME"));
				 		price2.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
				 		desc2.setText(resultSet.getString("DESCRIPTION")); 
				 		break; 
				 	case 1:
				 		productId3 = resultSet.getInt("PRODUCT_ID");
				 		
				 		Image image2 = new Image(resultSet.getString("ImagePath"));
				 		image3.setImage(image2);
				 		name3.setText(resultSet.getString("NAME"));
				 		price3.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
				 		desc3.setText(resultSet.getString("DESCRIPTION")); 
				 		break; 
		  
				 	} 
				 } 
			 }
		 } catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	 ObservableList<Cart> product=FXCollections.observableArrayList();
	public void addToCart1(ActionEvent event) {
		try(Connection connection=DBConnection.getConnection();
				java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
				ResultSet resultSet=statement.executeQuery("Select * from Product where productId1="+ productId1);
				) {
			while (resultSet.next()) {
				
				product.add(new Cart(resultSet.getString("CATEGORY"), resultSet.getString("NAME"), 
						resultSet.getString("PRODUCT_ID"), resultSet.getFloat("PRICE")));
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
			
			
		}
		
	}	
	public void addToCart2(ActionEvent event) {
		try(Connection connection=DBConnection.getConnection();
				java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
				ResultSet resultSet=statement.executeQuery("Select * from Product where productId1="+ productId2);
				) {
			while (resultSet.next()) {
				
				product.add(new Cart(resultSet.getString("CATEGORY"), resultSet.getString("NAME"), 
						resultSet.getString("PRODUCT_ID"), resultSet.getFloat("PRICE")));
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
			
			
		}
		
	}	
	public void addToCart3(ActionEvent event) {
		try(Connection connection=DBConnection.getConnection();
				java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
				ResultSet resultSet=statement.executeQuery("Select * from Product where productId1="+ productId3);
				) {
			while (resultSet.next()) {
				
				product.add(new Cart(resultSet.getString("CATEGORY"), resultSet.getString("NAME"), 
						resultSet.getString("PRODUCT_ID"), resultSet.getFloat("PRICE")));
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
			
			
		}
		
	}	
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
	public void Cart (ActionEvent event) throws IOException {
		
		Parent frontPage=FXMLLoader.load(getClass().getResource("/application/Cart.fxml"));
		Scene main = new Scene(frontPage);
		Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(main);
		stage.show();
		
		category.setCellValueFactory(new PropertyValueFactory<>("CATEGORY"));
		name.setCellValueFactory(new PropertyValueFactory<>("NAME"));
		productId.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
		price.setCellValueFactory(new PropertyValueFactory<>("PRICE"));
		
		tableview.setItems(product);
		
	}
//	public void Back (ActionEvent event) throws IOException {
//		try {
//			
//			Parent frontPage=FXMLLoader.load(getClass().getResource("/application/MyProduct2.fxml"));
//			Scene main = new Scene(frontPage);
//			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
//			stage.setScene(main);
//			stage.show();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
	}
	

		

		


