package dad.micv.controller;

import java.time.Period;

import dad.micv.model.Experiencia;
import dad.micv.view.AddExperienciaView;
import dad.micv.view.ExperienciaView;
import javafx.beans.property.ListProperty;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExperienciaController {

	private ExperienciaView view;
	private Stage formacionAdd;
	private Scene formScene;
	private AddExperienciaView addView;
	private ListProperty<Experiencia> experiencias;

	public ExperienciaController() {

		view = new ExperienciaView();
		addView = new AddExperienciaView();

		formScene = new Scene(addView, 305, 155);

		formacionAdd = new Stage();
		formacionAdd.getIcons().add(new Image("cv64x64.png"));
		formacionAdd.initModality(Modality.APPLICATION_MODAL);
		formacionAdd.setTitle("Añadir Título");
		formacionAdd.setScene(formScene);

		view.getAddButton().setOnAction(e -> onAddButtonAction(e));
		view.getEliminarButton().setOnAction(e -> onEliminarButtonAction(e));

		addView.getCancelarButton().setOnAction(e -> onCancelarButton(e));
		addView.getAddButton().setOnAction(e -> onConfirmAction(e));
	}

	public void bind(ListProperty<Experiencia> experienciaProperty) {
		this.experiencias = experienciaProperty;
		view.getExperienciaTable().itemsProperty().bind(experiencias);
	}

	private void onConfirmAction(ActionEvent e) {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText(null);

		try {
			if (Period.between(addView.getDesde().getValue(), addView.getHasta().getValue()).getDays() > 0) {
				Experiencia e1 = new Experiencia();
				e1.setDesde(addView.getDesde().getValue());
				e1.setHasta(addView.getHasta().getValue());
				e1.setDenominacion(addView.getDenominacionText().getText());
				e1.setEmpleador(addView.getEmpleadorText().getText());
				experiencias.add(e1);
				vaciarVentana();
				formacionAdd.close();
			} else if (addView.getDenominacionText().getText().equals("")) {
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

	private void onCancelarButton(ActionEvent e) {
		formacionAdd.close();
	}

	private void onAddButtonAction(ActionEvent e) {
		formacionAdd.show();
	}

	private void onEliminarButtonAction(ActionEvent e) {
		experiencias.remove(view.getExperienciaTable().getSelectionModel().getSelectedItem());
	}

	private void vaciarVentana() {
		addView.getDesde().setValue(null);
		addView.getHasta().setValue(null);
		addView.getDenominacionText().setText("");
		addView.getEmpleadorText().setText("");
	}

	public ExperienciaView getView() {
		return view;
	}

}
