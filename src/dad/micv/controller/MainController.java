package dad.micv.controller;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import dad.micv.main.MiCvAPP;
import dad.micv.model.CV;
import dad.micv.view.MainView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MainController {

	private CV cv;
	private MiCvAPP app;
	private MainView mainView;
	private PersonalController personalController;
	private ContactoController contactoController;
	private FormacionController formacionController;
	private ExperienciaController experienciaController;
	private ConocimientosController conocimientosController;
	private Stage stage;

	public MainController() {

		mainView = new MainView();
		cv = new CV();

		app = new MiCvAPP();

		stage = new Stage();
		stage.setScene(new Scene(new VBox()));
		stage.initModality(Modality.APPLICATION_MODAL);

		personalController = new PersonalController();
		contactoController = new ContactoController();
		formacionController = new FormacionController();
		experienciaController = new ExperienciaController();
		conocimientosController = new ConocimientosController();

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
		mainView.getAcercaDe().setOnAction(e -> onFormat(e));

		bind(cv);

	}

	public void bind(CV cv) {
		personalController.bind(cv.getPersonal());
		contactoController.bind(cv.getContacto());
		formacionController.bind(cv.tituloProperty());
		experienciaController.bind(cv.experienciaProperty());
		conocimientosController.bind(cv.habilidadProperty());
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
				this.cv = CV.read(file);
				bind(cv);
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
			bind(cv);
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

	@FXML
	private GridPane formatView;

	@FXML
	private Label formatLabel;

	@FXML
	private ProgressBar formatBar;

	private void onFormat(ActionEvent e) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/micv/view/FormatView.fxml"));
			loader.setController(this);
			formatView = loader.load();
		} catch (IOException e1) {
		}

		stage.getScene().setRoot(formatView);
		stage.show();

		new Thread(new Runnable() {

			@Override
			public void run() {
				do {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					formatBar.setProgress(formatBar.getProgress() + 0.01);

				} while (formatBar.getProgress() <= 1.0);
				
				
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						stage.close();
						formatBar.setProgress(0.0);
					}
				});
			}
		}).start();

	}

	public MainView getMainView() {
		return mainView;
	}

}
