package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InicialController implements Initializable {

	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	
	@FXML
	Button btnAdiciona;
	
	@FXML
	Button btnListar;
	
	@FXML
	Button btnSair;
	
	@FXML
	Label lblTitulo;
	
	@FXML
	public void adicionar(ActionEvent event) throws IOException{
		Parent cadastro = FXMLLoader.load(getClass().getResource("/fxml/adiciona.fxml"));
		Scene cadastroCena = new Scene(cadastro);
		Stage cadastroTela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		cadastroTela.setScene(cadastroCena);
		cadastroTela.show();
			
	}
	
	
	@FXML
	public void listar(ActionEvent event) throws IOException{
		Parent cadastro = FXMLLoader.load(getClass().getResource("/fxml/lista.fxml"));
		Scene cadastroCena = new Scene(cadastro);
		Stage cadastroTela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		cadastroTela.setScene(cadastroCena);
		cadastroTela.show();
			
	}
	
	
}
