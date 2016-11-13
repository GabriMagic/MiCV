package dad.micv.controller;

import java.io.File;
import java.util.Optional;

import dad.micv.main.MiCvAPP;
import dad.micv.model.CV;
import dad.micv.view.MainView;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Alert.AlertType;

public class MainController {

	CV cv;
	MiCvAPP app;
	MainView mainView;
	PersonalController personalController;
	ContactoController contactoController;
	FormacionController formacionController;
	ExperienciaController experienciaController;
	ConocimientosController conocimientosController;

	public MainController() {

		mainView = new MainView();
		cv = new CV();

		app = new MiCvAPP();

		personalController = new PersonalController(cv);
		contactoController = new ContactoController(cv);
		formacionController = new FormacionController(cv);
		experienciaController = new ExperienciaController(cv);
		conocimientosController = new ConocimientosController(cv);

		// PESTAÑAS
		mainView.getPersonalTab().setContent(personalController.getView());
		mainView.getContactoTab().setContent(contactoController.getView());
		mainView.getFormaciónTab().setContent(formacionController.getView());
		mainView.getExperienciaTab().setContent(experienciaController.getView());
		mainView.getConocimientosTab().setContent(conocimientosController.getView());

		// ACTIONS
		mainView.getSalir().setOnAction(e -> onSalir(e));
		mainView.getGuardar().setOnAction(e -> onGuardar(e));
		mainView.getNuevo().setOnAction(e -> onNuevo(e));
		mainView.getAbrir().setOnAction(e -> onAbrir(e));
		mainView.getGuardarComo().setOnAction(e -> onGuardarComo(e));

	}

	private void onAbrir(ActionEvent e) {

		FileChooser fc = new FileChooser();
		fc.setTitle("Abrir curriculum existente");
		fc.getExtensionFilters().add(new ExtensionFilter("Fichero XML", "*.xml"));

		File fichero = new File(".");
		fc.setInitialDirectory(fichero);

		File file = fc.showOpenDialog(app.getPrimaryStage());
		if (file != null) {
			try {
				cv = CV.read(file);

				personalController.bind(cv.getPersonal());
				contactoController.bind(cv.getContacto());

				Bindings.bindBidirectional(formacionController.getView().getFormacionTable().itemsProperty(),
						cv.tituloProperty());

			} catch (Exception e1) {
			}
		}
	}

	private void onGuardarComo(ActionEvent e) {

		FileChooser fc = new FileChooser();
		fc.setTitle("Guardar curriculum XML...");
		fc.getExtensionFilters().add(new ExtensionFilter("Fichero XML", "*.xml"));
		fc.setInitialDirectory(new File("."));

		File file = fc.showOpenDialog(app.getPrimaryStage());
		if (file != null) {
			try {
				cv.save(file);
			} catch (Exception e1) {
			}
		}

	}

	private void onNuevo(ActionEvent e) {
		cv = new CV();
		Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
		confirmAlert.setHeaderText("Se borrarán los datos no guardados");
		confirmAlert.setContentText("¿Desea cerrar el curriculum actual?");
		Optional<ButtonType> confirm = confirmAlert.showAndWait();

		if (confirm.get() == ButtonType.OK) {
			personalController.bind(cv.getPersonal());
			contactoController.bind(cv.getContacto());
			Bindings.bindBidirectional(formacionController.getView().getFormacionTable().itemsProperty(),
					cv.tituloProperty());
		} else {

		}

	}

	private void onGuardar(ActionEvent e) {
		try {
			File fich = new File("micurriculum.xml");

			if (fich.exists()) {
				Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
				confirmAlert.setHeaderText("El fichero ya existe");
				confirmAlert.setContentText("¿Desea sobreescribir el fichero?");
				Optional<ButtonType> confirm = confirmAlert.showAndWait();

				if (confirm.get() == ButtonType.OK) {
					cv.save(fich);
				} else {

				}

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void onSalir(ActionEvent e) {

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
