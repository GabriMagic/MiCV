package dad.micv.controller;

import java.io.File;
import java.util.Optional;

import dad.micv.main.MiCvAPP;
import dad.micv.model.CV;
import dad.micv.model.Contacto;
import dad.micv.model.Personal;
import dad.micv.view.MainView;
import javafx.application.Platform;
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

		personalController = new PersonalController();
		contactoController = new ContactoController();
		formacionController = new FormacionController();
		experienciaController = new ExperienciaController();
		conocimientosController = new ConocimientosController();

		cv.setPersonal(personalController.getPersonal());
		cv.setContacto(contactoController.getContacto());
		cv.getExperiencia().add(experienciaController.getExperiencia());
		cv.getHabilidad().add(conocimientosController.getConocimiento());
		cv.getTitulo().add(formacionController.getTitulo());

		mainView.getPersonalTab().setContent(personalController.getView());
		mainView.getContactoTab().setContent(contactoController.getView());
		mainView.getFormaciónTab().setContent(formacionController.getView());
		mainView.getExperienciaTab().setContent(experienciaController.getView());
		mainView.getConocimientosTab().setContent(conocimientosController.getView());

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
				CV c2 = CV.read(file);

				cv.personalProperty().bind(c2.personalProperty());
				cv.contactoProperty().bind(c2.contactoProperty());
				cv.habilidadProperty().bind(c2.habilidadProperty());
				cv.experienciaProperty().bind(c2.experienciaProperty());
				cv.tituloProperty().bind(c2.tituloProperty());
			} catch (Exception e1) {
			}
		}
	}

	private void onGuardarComo(ActionEvent e) {

		FileChooser fc = new FileChooser();
		fc.setTitle("Guardar curriculum XML...");
		fc.getExtensionFilters().add(new ExtensionFilter("Fichero XML", "*.xml"));

		if (System.getProperty("os.name").indexOf("Win") >= 0) {
			File fichero = new File(
					System.getProperty("user.home").toString() + System.getProperty("file.separator") + "Desktop");
			fc.setInitialDirectory(fichero);
		} else if (System.getProperty("os.name").indexOf("Lin") >= 0) {
			File fichero = new File(
					System.getProperty("user.home").toString() + System.getProperty("file.separator") + "Desktop");
			fc.setInitialDirectory(fichero);
		}
		File file = fc.showOpenDialog(app.getPrimaryStage());
		if (file != null) {
			try {
				this.cv.save(file);
			} catch (Exception e1) {
			}
		}

	}

	private void onNuevo(ActionEvent e) {
		cv = new CV();

		cv.setPersonal(new Personal());
		cv.setContacto(new Contacto());
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
