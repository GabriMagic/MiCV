package dad.micv.controller;

import java.util.Optional;

import dad.micv.view.MainView;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class MainController {

	MainView mainView;
	PersonalController personalController;
	ContactoController contactoController;

	public MainController() {
		mainView = new MainView();
		personalController = new PersonalController();
		contactoController = new ContactoController();

		mainView.getPersonalTab().setContent(personalController.getView());
		mainView.getContactoTab().setContent(contactoController.getView());

		mainView.getSalir().setOnAction(e -> onSalirMenuItem());

	}

	private void onSalirMenuItem() {

		Alert salirAlert = new Alert(AlertType.CONFIRMATION);
		salirAlert.setContentText("¿Desea salir de la aplicación?");

		Optional<ButtonType> opt = salirAlert.showAndWait();

		if (opt.get() == ButtonType.OK)
			Platform.exit();
	}

	public MainView getMainView() {
		return mainView;
	}

}
