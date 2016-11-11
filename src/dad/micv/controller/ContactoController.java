package dad.micv.controller;

import dad.micv.model.Contacto;
import dad.micv.model.Email;
import dad.micv.model.Telefono;
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

public class ContactoController {

	private Contacto contacto;
	private ContactoView view;
	private AddTelefonoView addTelefonoView;
	private AddEmailView addEmailView;
	private AddWebsView addWebsView;
	private Stage addStage;
	private ObservableList<Telefono> telefonos;
	private ObservableList<Email> emails;
	private ObservableList<Web> webs;

	public ContactoController() {

		view = new ContactoView();

		contacto = new Contacto();

		addTelefonoView = new AddTelefonoView();

		telefonos = FXCollections.observableArrayList();
		emails = FXCollections.observableArrayList();
		webs = FXCollections.observableArrayList();

		addStage = new Stage();
		addStage.setScene(new Scene(new VBox()));
		addStage.initModality(Modality.APPLICATION_MODAL);

		view.getTelefonoAddButton().setOnAction(e -> {
			addStage.setTitle("Añadir Teléfono");
			addStage.getScene().setRoot(addTelefonoView);
			addStage.show();
		});

		view.getEmailsAddButton().setOnAction(e -> {
			addStage.setTitle("Añadir E-Mail");
			addStage.getScene().setRoot(addEmailView);
			addStage.show();
		});

		view.getWebsAddButton().setOnAction(e -> {
			addStage.setTitle("Añadir Web");
			addStage.getScene().setRoot(addWebsView);
			addStage.show();
		});

		addTelefonoView.getAddButton().setOnAction(e -> AddTelefono(e));
		addTelefonoView.getCancelButton().setOnAction(e -> addStage.close());

		bind();
	}

	public void bind() {
		view.getTelefonosTable().itemsProperty().bind(contacto.telefonosProperty());
		view.getEmailsTable().itemsProperty().bind(contacto.emailsProperty());
		view.getWebsTable().itemsProperty().bind(contacto.websProperty());
	}

	private void AddTelefono(ActionEvent e) {
		Telefono t1 = new Telefono();
		t1.setNumero(addTelefonoView.getTelefonoText().getText());
		t1.setTipo(addTelefonoView.getTipoTelefonoBox().getValue());

		contacto.getTelefonos().add(t1);

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

	public Contacto getContacto() {
		return contacto;
	}
}
