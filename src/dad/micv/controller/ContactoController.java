package dad.micv.controller;

import dad.micv.model.Contacto;
import dad.micv.model.Email;
import dad.micv.model.Telefono;
import dad.micv.model.Web;
import dad.micv.view.AddEmailView;
import dad.micv.view.AddTelefonoView;
import dad.micv.view.AddWebsView;
import dad.micv.view.ContactoView;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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

	public ContactoController() {

		view = new ContactoView();

		contacto = new Contacto();

		addTelefonoView = new AddTelefonoView();
		addEmailView = new AddEmailView();
		addWebsView = new AddWebsView();

		addStage = new Stage();
		addStage.getIcons().add(new Image("cv64x64.png"));
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
		addTelefonoView.getCancelButton().setOnAction(e -> onEndTelefono(e));

		addEmailView.getAddButton().setOnAction(e -> AddEmail(e));
		addEmailView.getCancelButton().setOnAction(e -> onEndEmail(e));

		addWebsView.getAddButton().setOnAction(e -> addWeb(e));
		addWebsView.getCancelButton().setOnAction(e -> onEndWeb(e));

		bind(contacto);
	}

	public void bind(Contacto contacto) {
		Bindings.bindBidirectional(view.getTelefonosTable().itemsProperty(), contacto.telefonosProperty());
		Bindings.bindBidirectional(view.getEmailsTable().itemsProperty(), contacto.emailsProperty());
		Bindings.bindBidirectional(view.getWebsTable().itemsProperty(), contacto.websProperty());
		
	}

	// TELEFONOS
	private void AddTelefono(ActionEvent e) {
		Telefono t1 = new Telefono();
		t1.setNumero(addTelefonoView.getTelefonoText().getText());
		t1.setTipo(addTelefonoView.getTipoTelefonoBox().getValue());
		contacto.getTelefonos().add(t1);
		onEndTelefono(e);
	}

	// EMAILS
	private void AddEmail(ActionEvent e) {
		Email e1 = new Email();
		e1.setDireccion(addEmailView.getEmailText().getText());
		contacto.getEmails().add(e1);
		onEndEmail(e);
	}

	// WEBS
	private void addWeb(ActionEvent e) {
		Web w1 = new Web();
		w1.setUrl(addWebsView.getWebText().getText());
		contacto.getWebs().add(w1);
		onEndWeb(e);
	}

	private void onEndTelefono(ActionEvent e) {
		addTelefonoView.getTelefonoText().setText("");
		addTelefonoView.getTelefonoText().setText("");
		addStage.close();
	}

	private void onEndEmail(ActionEvent e) {
		addEmailView.getEmailText().setText("");
		addStage.close();
	}

	private void onEndWeb(ActionEvent e) {
		addWebsView.getWebText().setText("");
		addStage.close();
	}

	public ContactoView getView() {
		return view;
	}

	public Contacto getContacto() {
		return contacto;
	}

}