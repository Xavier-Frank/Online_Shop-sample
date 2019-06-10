package application;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddProductsController {
	 @FXML
	    private TextField Category;

	    @FXML
	    private TextField Name;

	    @FXML
	    private TextField productId;

	    @FXML
	    private Button Cancel;

	    @FXML
	    private Button submit;

	    @FXML
	    private TextArea desc;

	    @FXML
	    private TextField quantity;

	    @FXML
	    private TextField warranty;

	    @FXML
	    private TextField price;

	    @FXML
	    private ImageView imageViewer;

	    @FXML
	    private Button addImage;

	    @FXML
	    private Label errorChecker;

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

	    @FXML
	    private Label lbl6;

	    @FXML
	    private Label lbl7;
    
    //for storing image paths in our database
    String imageDir;
   
	@FXML
	   public  void addProducts (ActionEvent event) {
		String addProduct="INSERT INTO Product(CATEGORY,NAME,PRODUCT_ID,DESCRIPTION,QUANTITY,WARRANTY,PRICE,ImagePath)" + "VALUES (?,?,?,?,?,?,?,?)";
		try (Connection connection=DBConnection.getConnection();
				java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
				PreparedStatement preparedStatement=connection.prepareStatement(addProduct);
				){
			
			preparedStatement.setString(1, Category.getText());
			preparedStatement.setString(2, Name.getText());
			preparedStatement.setString(3, productId.getText());
			preparedStatement.setString(4, desc.getText());
			preparedStatement.setInt(5, Integer.parseInt(quantity.getText()));
			preparedStatement.setInt(6, Integer.parseInt(warranty.getText()));
			preparedStatement.setFloat(7, Float.parseFloat(price.getText()));
			preparedStatement.setString(8, imageDir);
			
			preparedStatement.executeUpdate();
			
			errorChecker.setText("Succesfull");
			errorChecker.setTextFill(Color.GREEN);
			
			Parent frontPage=FXMLLoader.load(getClass().getResource("/application/AdminPage.fxml"));
			Scene main = new Scene(frontPage);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(main);
			stage.show();
			
			
			
		} catch (Exception e) {
			
		}
    	
	}
	   public void cancel(ActionEvent event) throws Exception {

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
	   public void addImage (ActionEvent event) throws MalformedURLException {
		   FileChooser fileChooser = new FileChooser();
		   File selectedFile=fileChooser.showOpenDialog(errorChecker.getScene().getWindow());
		   
		   if (selectedFile !=null) {
			imageDir=selectedFile.toURI().toURL().toString();
			Image image=new Image(imageDir);
			imageViewer.setImage(image);
			
		} else {
			errorChecker.setText("Unable to conduct selection");
		}
		   
		   
		   
		
	}
		


}
