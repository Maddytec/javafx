package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.PessoaDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Pessoa;

public class AdicionaController implements Initializable {

	@FXML
	private Button btnSalvar;
		
	@FXML
	private Button btnSair;
	
	@FXML
	private Label lblNome; 
	
	@FXML
	private Label lblIdade;
	
	@FXML
	private Label lblTitulo;
	
	@FXML
	private TextField tfNome;
	
	@FXML
	private TextField tfIdade;
	
	
	@FXML
	public void salvar(ActionEvent event) throws IOException{
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome(tfNome.getText());
		
		pessoa.setIdade(Integer.parseInt(tfIdade.getText()));
		
		PessoaDao dao = new PessoaDao();
		
		dao.addPessoa(pessoa);
		
		Parent cadastro = FXMLLoader.load(getClass().getResource("/fxml/inicial.fxml"));
		Scene cadastroCena = new Scene(cadastro);
		Stage cadastroTela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		cadastroTela.setScene(cadastroCena);
		cadastroTela.show();
		
	}
	
	public void sair(ActionEvent event) throws IOException{
		
		Parent cadastro = FXMLLoader.load(getClass().getResource("/fxml/inicial.fxml"));
		Scene cadastroCena = new Scene(cadastro);
		Stage cadastroTela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		cadastroTela.setScene(cadastroCena);
		cadastroTela.show();
		
	}
	
	
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
