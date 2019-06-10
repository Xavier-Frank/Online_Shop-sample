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

public class ViewUsersController implements Initializable{
	@FXML
	private TableView<Person> tableView;
	
	@FXML
	private TableColumn<Person, String> FIRST_NAME;
	
	@FXML
	private TableColumn<Person, String> LAST_NAME;
	
	@FXML
	private TableColumn<Person, String> USERNAME;
	
	ObservableList<Person> customers=FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try(Connection connection=DBConnection.getConnection();
				java.sql.Statement statement=connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
				ResultSet resultSet=statement.executeQuery("Select * from Customer");) {
			while (resultSet.next()) {
				customers.add(new Person(resultSet.getString("FIRST_NAME"),resultSet.getString("LAST_NAME") ,resultSet.getString("USERNAME") ));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		FIRST_NAME.setCellValueFactory(new PropertyValueFactory<>("FIRST_NAME"));
		LAST_NAME.setCellValueFactory(new PropertyValueFactory<>("LAST_NAME"));
		USERNAME.setCellValueFactory(new PropertyValueFactory<>("USERNAME"));
		
		tableView.setItems(customers);
		
		
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








