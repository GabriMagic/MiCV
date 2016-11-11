package dad.micv.controller;

import dad.micv.view.ContactoView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class ContactoController {

	private ContactoView view;
	private Stage addStage;

	public ContactoController() {

		view = new ContactoView();

		addStage = new Stage();

		view.getTelefonoAddButton().setOnAction(e -> onTelefonoAddButton(e));
		view.getEmailsAddButton().setOnAction(e -> onEmailsAddButton(e));
		view.getWebsAddButton().setOnAction(e -> onWebsAddButton(e));

	}

	private void onWebsAddButton(ActionEvent e) {

	}

	private void onEmailsAddButton(ActionEvent e) {

	}

	private void onTelefonoAddButton(ActionEvent e) {

	}

	public ContactoView getView() {
		return view;
	}
}
