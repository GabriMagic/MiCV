package dad.micv.controller;

import java.io.File;
import java.util.Optional;

import dad.micv.model.CV;
import dad.micv.view.MainView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class MainController {

	MainView mainView;
	PersonalController personalController;
	ContactoController contactoController;
	FormacionController formacionController;
	ExperienciaController experienciaController;
	ConocimientosController conocimientosController;
	CV cv;

	public MainController() {

		mainView = new MainView();
		cv = new CV();

		personalController = new PersonalController();
		contactoController = new ContactoController();
		formacionController = new FormacionController();
		experienciaController = new ExperienciaController();
		conocimientosController = new ConocimientosController();

		mainView.getPersonalTab().setContent(personalController.getView());
		mainView.getContactoTab().setContent(contactoController.getView());
		mainView.getFormaciónTab().setContent(formacionController.getView());
		mainView.getExperienciaTab().setContent(experienciaController.getView());
		mainView.getConocimientosTab().setContent(conocimientosController.getView());

		mainView.getSalir().setOnAction(e -> onSalirMenuItem());
		mainView.getGuardar().setOnAction(e -> onGuardar(e));
	}

	private void onGuardar(ActionEvent e) {
		try {
			File fich = new File("asd.xml");

			if (fich.exists()) {
				Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
				confirmAlert.setHeaderText("El fichero ya existe");
				confirmAlert.setContentText("¿Desea sobreescribir el fichero?");
				cv.save(fich);

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
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
