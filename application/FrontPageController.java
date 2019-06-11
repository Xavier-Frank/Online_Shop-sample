package application;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mysql.jdbc.Statement;

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
import javafx.scene.control.TableView;
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
		//load cart
		
		
		
		public void cartButtonPressed (ActionEvent event) {
			try(Connection connection=DBConnection.getConnection();
					java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_SCROLL_INSENSITIVE);
					ResultSet resultSet=statement.executeQuery("Select * from Product where PRODUCT_ID = " + productId1)) {
				
				resultSet.next();
				
				FXMLLoader loader= new FXMLLoader();
				loader.setLocation(getClass().getResource("/application/Cart.fxml"));
				Parent root = loader.load();
				
				CartController cartController=loader.getController();
				cartController.product.add(new Cart(resultSet.getString("CATEGORY"), resultSet.getString("NAME"), resultSet.getString("PRODUCT_ID"),resultSet.getInt("QUANTITY") , resultSet.getFloat("PRICE")));
				
				Scene scene=new Scene(root);
				Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
				stage.setScene(scene);

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
		    
		    String productId1;

			String productId2;

			String productId3;
		    @FXML
		    private Button setting;

		    @FXML
		    private Button cart;

		    @FXML
		    private Button login;

		    @FXML
		    private Button signUp;

	@Override
	//for initialised display on the front page
	public void initialize(URL location, ResourceBundle resources) {
			try(Connection connection=DBConnection.getConnection();
					java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
					ResultSet resultSet=statement.executeQuery("Select * from Product")) {
				
				
				for (int i = 0; i < 3; i++) {
					if (resultSet.next()) {
						
					switch (i) {
					case 0:
						productId1 = resultSet.getString("PRODUCT_ID");
						
						Image image = new Image(resultSet.getString("ImagePath"));
						image1.setImage(image);
						name1.setText(resultSet.getString("NAME"));
						price1.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
						desc1.setText(resultSet.getString("DESCRIPTION"));
						break;
					case 1:
						productId2 = resultSet.getString("PRODUCT_ID");
						
						Image image1 = new Image(resultSet.getString("ImagePath"));
						image2.setImage(image1);
						name2.setText(resultSet.getString("NAME"));
						price2.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
						desc2.setText(resultSet.getString("DESCRIPTION"));
					case 2:
						productId3 = resultSet.getString("PRODUCT_ID");
						
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
	//keeps info of the current page so that when next button is pressed a viewer sees the 4th product and so on
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
						productId1 = resultSet.getString("PRODUCT_ID");
						
						Image image = new Image(resultSet.getString("ImagePath"));
						image1.setImage(image);
						name1.setText(resultSet.getString("NAME"));
						price1.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
						desc1.setText(resultSet.getString("DESCRIPTION"));
						break;
					case 1:
						productId2 = resultSet.getString("PRODUCT_ID");
						Image image1 = new Image(resultSet.getString("ImagePath"));
						image2.setImage(image1);
						name2.setText(resultSet.getString("NAME"));
						price2.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
						desc2.setText(resultSet.getString("DESCRIPTION"));
					case 2:
						productId3 = resultSet.getString("PRODUCT_ID");
						
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
				 		productId1 = resultSet.getString("PRODUCT_ID");
				 		
				 		Image image = new Image(resultSet.getString("ImagePath"));
				 		image1.setImage(image);
				 		name1.setText(resultSet.getString("NAME"));
				 		price1.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
				 		desc1.setText(resultSet.getString("DESCRIPTION")); 
				 		break; 
				 	case 2:
				 		productId2 = resultSet.getString("PRODUCT_ID");
				 		
				 		Image image1 = new Image(resultSet.getString("ImagePath"));
				 		image2.setImage(image1);
				 		name2.setText(resultSet.getString("NAME"));
				 		price2.setText("Kshs " + Float.toString(resultSet.getFloat("PRICE")));
				 		desc2.setText(resultSet.getString("DESCRIPTION")); 
				 		break; 
				 	case 1:
				 		productId3 = resultSet.getString("PRODUCT_ID");
				 		
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

	 // add to cart the left product
	public void addToCart1(ActionEvent event) {
		try(Connection connection=DBConnection.getConnection();
				java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
				ResultSet resultSet=statement.executeQuery("Select * from Product where PRODUCT_ID = "+productId1 );
				) {
			while (resultSet.next()) {
				
				product.add(new Cart(resultSet.getString("CATEGORY"), resultSet.getString("NAME"), 
						resultSet.getString("PRODUCT_ID"), resultSet.getInt("QUANTITY"), resultSet.getFloat("PRICE")));
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}	
	//add to cart the middle image
	public void addToCart2(ActionEvent event) {
		try(Connection connection=DBConnection.getConnection();
				java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
				ResultSet resultSet=statement.executeQuery("Select * from Product where PRODUCT_ID = "+ productId2);
				) {
			while (resultSet.next()) {
				
				product.add(new Cart(resultSet.getString("CATEGORY"), resultSet.getString("NAME"), 
						resultSet.getString("PRODUCT_ID"), resultSet.getInt("QUANTITY"), resultSet.getFloat("PRICE")));
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
			
			
		}
		
	}	
	//add to cart the right image
	public void addToCart3(ActionEvent event) {
		try(Connection connection=DBConnection.getConnection();
				java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
				ResultSet resultSet=statement.executeQuery("Select * from Product where PRODUCT_ID = "+ productId3);
				) {
			while (resultSet.next()) {
				
				product.add(new Cart(resultSet.getString("CATEGORY"), resultSet.getString("NAME"), 
						resultSet.getString("PRODUCT_ID"), resultSet.getInt("QUANTITY"), resultSet.getFloat("PRICE")));
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
			
			
		}
		
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
	

		

		


