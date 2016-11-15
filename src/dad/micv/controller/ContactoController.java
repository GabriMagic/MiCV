package dad.micv.controller;

import dad.micv.model.CV;
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

	private CV cv;
	private ContactoView view;
	private AddTelefonoView addTelefonoView;
	private AddEmailView addEmailView;
	private AddWebsView addWebsView;
	private Stage addStage;

	public ContactoController(CV cv) {

		this.cv = cv;
		view = new ContactoView();

		addTelefonoView = new AddTelefonoView();
		addEmailView = new AddEmailView();
		addWebsView = new AddWebsView();

		addStage = new Stage();
		addStage.getIcons().add(new Image("cv64x64.png"));
		addStage.setScene(new Scene(new VBox()));
		addStage.initModality(Modality.APPLICATION_MODAL);

		view.getTelefonoAddButton().setOnAction(e -> addTelefonoOpen());
		view.getTelefonoDelButotn().setOnAction(e -> onDelTelefono());
		view.getEmailsAddButton().setOnAction(e -> addEmailOpen());
		view.getEmailsDelButotn().setOnAction(e -> onDelEmail());
		view.getWebsAddButton().setOnAction(e -> addWebOpen());
		view.getWebsDelButotn().setOnAction(e -> onDelWeb());

		addTelefonoView.getAddButton().setOnAction(e -> AddTelefono(e));
		addTelefonoView.getCancelButton().setOnAction(e -> onEndTelefono(e));

		addEmailView.getAddButton().setOnAction(e -> AddEmail(e));
		addEmailView.getCancelButton().setOnAction(e -> onEndEmail(e));

		addWebsView.getAddButton().setOnAction(e -> addWeb(e));
		addWebsView.getCancelButton().setOnAction(e -> onEndWeb(e));

		bind(cv);
	}

	public void bind(CV cv) {
		Bindings.bindBidirectional(view.getTelefonosTable().itemsProperty(), cv.getContacto().telefonosProperty());
		Bindings.bindBidirectional(view.getEmailsTable().itemsProperty(), cv.getContacto().emailsProperty());
		Bindings.bindBidirectional(view.getWebsTable().itemsProperty(), cv.getContacto().websProperty());

	}

	// TELEFONOS
	private void addTelefonoOpen() {
		addStage.setTitle("Añadir Teléfono");
		addStage.getScene().setRoot(addTelefonoView);
		addStage.show();
	}

	private void AddTelefono(ActionEvent e) {
		Telefono t1 = new Telefono();
		t1.setNumero(addTelefonoView.getTelefonoText().getText());
		t1.setTipo(addTelefonoView.getTipoTelefonoBox().getValue());
		cv.getContacto().getTelefonos().add(t1);
		onEndTelefono(e);
	}

	private void onEndTelefono(ActionEvent e) {
		addTelefonoView.getTelefonoText().setText("");
		addTelefonoView.getTelefonoText().setText("");
		addStage.close();
	}

	private void onDelTelefono() {
		cv.getContacto().getTelefonos().remove(view.getTelefonosTable().getSelectionModel().getSelectedItem());
	}

	// EMAILS
	private void addEmailOpen() {
		addStage.setTitle("Añadir E-Mail");
		addStage.getScene().setRoot(addEmailView);
		addStage.show();
	}

	private void AddEmail(ActionEvent e) {
		Email e1 = new Email();
		e1.setDireccion(addEmailView.getEmailText().getText());
		cv.getContacto().getEmails().add(e1);
		onEndEmail(e);
	}

	private void onEndEmail(ActionEvent e) {
		addEmailView.getEmailText().setText("");
		addStage.close();
	}

	private void onDelEmail() {
		cv.getContacto().getEmails().remove(view.getEmailsTable().getSelectionModel().getSelectedItem());
	}

	// WEBS
	private void addWebOpen() {
		addStage.setTitle("Añadir Web");
		addStage.getScene().setRoot(addWebsView);
		addStage.show();
	}

	private void addWeb(ActionEvent e) {
		Web w1 = new Web();
		w1.setUrl(addWebsView.getWebText().getText());
		cv.getContacto().getWebs().add(w1);
		onEndWeb(e);
	}

	private void onEndWeb(ActionEvent e) {
		addWebsView.getWebText().setText("");
		addStage.close();
	}

	private void onDelWeb() {
		cv.getContacto().getWebs().remove(view.getWebsTable().getSelectionModel().getSelectedItem());
	}

	public ContactoView getView() {
		return view;
	}

	public Contacto getContacto() {
		return cv.getContacto();
	}

}