package dad.micv.controller;

import dad.micv.model.Email;
import dad.micv.model.Telefono;
import dad.micv.model.TipoTelefono;
import dad.micv.model.Web;
import dad.micv.view.AddTelefonoView;
import dad.micv.view.ContactoView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ContactoController {

	private ContactoView view;
	private AddTelefonoView addTelefonoView;
	private AddEmailView addEmailView;
	private AddWebsView addWebsView;
	private Stage addStage;
	private Scene addScene;
	private ObservableList<Telefono> telefonos;
	private ObservableList<Email> emails;
	private ObservableList<Web> webs;

	public ContactoController() {

		view = new ContactoView();

		addTelefonoView = new AddTelefonoView();

		telefonos = FXCollections.observableArrayList();
		emails = FXCollections.observableArrayList();
		webs = FXCollections.observableArrayList();

		addStage = new Stage();
		addStage.setScene(new Scene(new VBox()));
		addStage.initModality(Modality.APPLICATION_MODAL);

		view.getTelefonoAddButton().setOnAction(e -> {
			addStage.setTitle("A�adir Tel�fono");
			addStage.getScene().setRoot(addTelefonoView);
			addStage.show();
		});

		view.getEmailsAddButton().setOnAction(e -> {
			addStage.setTitle("A�adir E-Mail");
			addStage.getScene().setRoot(addEmailView);
			addStage.show();
		});

		view.getWebsAddButton().setOnAction(e -> {
			addStage.setTitle("A�adir Web");
			addStage.getScene().setRoot(addWebsView);
			addStage.show();
		});

		addTelefonoView.getAddButton().setOnAction(e -> AddTelefono(e));
		addTelefonoView.getCancelButton().setOnAction(e -> addStage.close());

		bind();
	}

	public void bind() {
		view.getTelefonosTable().setItems(telefonos);
		view.getEmailsTable().setItems(emails);
		view.getWebsTable().setItems(webs);
	}

	private void AddTelefono(ActionEvent e) {
		Telefono t1 = new Telefono();
		t1.setNumero(addTelefonoView.getTelefonoText().getText());
		t1.setTipo(addTelefonoView.getTipoTelefonoBox().getValue());
		telefonos.add(t1);

		addTelefonoView.getTelefonoText().setText("");
		addTelefonoView.getTelefonoText().setText("");
		addStage.close();
	}

	// EMAILS
	private void onEmailsAddButton(ActionEvent e) {

	}

	// WEBS
	private void onWebsAddButton(ActionEvent e) {

	}

	public ContactoView getView() {
		return view;
	}
}
