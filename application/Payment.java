package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Payment {
	 @FXML
	    private Button buybutton;

	    @FXML
	    private TextField creditNumber;

	    @FXML
	    private Button buyButton1;

	    @FXML
	    private TextField secCode;

	public void buy (ActionEvent event) {
		Alert alert= new Alert(AlertType.INFORMATION);
		alert.setContentText("Successfull");
		alert.show();
	}
	

}
