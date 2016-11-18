package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.PessoaDao;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Pessoa;
import tabela.PessoaTabela;

public class ListaController implements Initializable {

	@FXML
	private Label lblTitulo;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnSair;
	
	@FXML
	private Label lblNome;
	
	@FXML
	private TextField tfNome;
		
	@FXML
	private Label lblIdade;
	
	@FXML
	private TextField tfIdade;
		
	@FXML
	private TableView<PessoaTabela> tvTabela;

	@FXML
	private TableColumn<PessoaTabela, String> tcNome;

	@FXML
	private TableColumn<PessoaTabela, Integer> tcIdade;

	private PessoaDao dao = new PessoaDao();

	private List<Pessoa> pessoaList = dao.listPessoa();

	private ObservableList<PessoaTabela> listPessoaTabela = FXCollections.observableArrayList();

	public void listarPessoas() {
		if (!listPessoaTabela.isEmpty()) {
			listPessoaTabela.clear();
			System.out.println("Limpou a tabela");
		}

		for (Pessoa pessoa : pessoaList) {

			PessoaTabela p = new PessoaTabela(pessoa.getId(), pessoa.getNome(), pessoa.getIdade());
			listPessoaTabela.add(p);
		}

		tcNome.setCellValueFactory(new PropertyValueFactory<PessoaTabela, String>("Nome"));
		tcIdade.setCellValueFactory(new PropertyValueFactory<PessoaTabela, Integer>("Idade"));

		tvTabela.setItems(listPessoaTabela);
	}

	public void initialize(URL location, ResourceBundle resources) {

		listarPessoas();
	}

	@FXML
	public void excluir() {

		PessoaTabela pessoa = tvTabela.getSelectionModel().getSelectedItem();
		int id = pessoa.getId();

		listPessoaTabela.remove(pessoa);

		dao.removePessoa(id);

		pessoaList = dao.listPessoa();

		listarPessoas();
	}

	
	
	public void editar(){
		
		PessoaTabela pessoaTabela = tvTabela.getSelectionModel().getSelectedItem();
		
		Pessoa pessoa = new Pessoa(pessoaTabela);
		
		pessoa.setNome(tfNome.getText());
		pessoa.setIdade(Integer.parseInt(tfIdade.getText()));
		
		dao.updatePessoa(pessoa);
		
		pessoaList = dao.listPessoa();
		
		listarPessoas();
		
	}
	
	
	public void sair(ActionEvent event) throws IOException {

		Parent cadastro = FXMLLoader.load(getClass().getResource("/fxml/inicial.fxml"));
		Scene cadastroCena = new Scene(cadastro);
		Stage cadastroTela = (Stage) ((Node) event.getSource()).getScene().getWindow();

		cadastroTela.setScene(cadastroCena);
		cadastroTela.show();

	}

}
