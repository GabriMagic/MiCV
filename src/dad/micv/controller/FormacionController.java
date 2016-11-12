package dad.micv.controller;

import javafx.scene.control.Alert.AlertType;
import dad.micv.view.AddFormacionView;
import dad.micv.view.FormacionView;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import dad.micv.model.CV;
import dad.micv.model.Titulo;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.time.Period;

public class FormacionController {

	private CV cv;
	private Titulo titulo;
	private FormacionView view;
	private Stage formacionAdd;
	private Scene formScene;
	private AddFormacionView editVista;

	public FormacionController() {

		view = new FormacionView();
		editVista = new AddFormacionView();

		cv = new CV();
		titulo = new Titulo();

		formScene = new Scene(editVista, 305, 155);

		formacionAdd = new Stage();
		formacionAdd.getIcons().add(new Image("cv64x64.png"));
		formacionAdd.initModality(Modality.APPLICATION_MODAL);
		formacionAdd.setTitle("Añadir Título");
		formacionAdd.setScene(formScene);

		view.getAñadirButton().setOnAction(e -> onAddButtonAction(e));
		view.getEliminarButton().setOnAction(e -> onEliminarButtonAction(e));

		view.getFormacionTable().itemsProperty().bind(cv.tituloProperty());

		editVista.getCancelarButton().setOnAction(e -> onCancelarButton(e));
		editVista.getAddButton().setOnAction(e -> onConfirmAction(e));
	}

	private void onConfirmAction(ActionEvent e) {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText(null);

		try {
			if (Period.between(editVista.getDesde().getValue(), editVista.getHasta().getValue()).getDays() > 0) {
				Titulo t1 = new Titulo();
				t1.setDesde(editVista.getDesde().getValue());
				t1.setHasta(editVista.getHasta().getValue());
				t1.setDenominacion(editVista.getDenominacionText().getText());
				t1.setOrganizador(editVista.getOrganizadorText().getText());
				cv.getTitulo().add(t1);
				vaciarVentana();
				formacionAdd.close();
			} else if (editVista.getDenominacionText().getText().equals("")) {
				errorAlert.setTitle("Campos vacíos");
				errorAlert.setContentText("Rellene todos los campos");
				errorAlert.show();
			} else {
				errorAlert.setTitle("Fecha Incorrecta");
				errorAlert.setContentText("Las fechas deben ser correctas.");
				errorAlert.show();
			}
		} catch (NullPointerException e2) {
			errorAlert.setTitle("Campos vacíos");
			errorAlert.setContentText("Rellene todos los campos");
			errorAlert.show();
		}

	}

	private void vaciarVentana() {
		editVista.getDesde().setValue(null);
		editVista.getHasta().setValue(null);
		editVista.getDenominacionText().setText("");
		editVista.getOrganizadorText().setText("");
	}

	private void onCancelarButton(ActionEvent e) {
		formacionAdd.close();
	}

	private void onEliminarButtonAction(ActionEvent e) {
		 cv.getTitulo().remove(view.getFormacionTable().getSelectionModel().getSelectedItem());
	}

	private void onAddButtonAction(ActionEvent e) {
		formacionAdd.show();
	}

	public FormacionView getView() {
		return view;
	}

	public Titulo getTitulo() {
		return titulo;
	}
}