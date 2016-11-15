package dad.micv.controller;

import javafx.scene.control.Alert.AlertType;
import dad.micv.view.AddFormacionView;
import dad.micv.view.FormacionView;
import javafx.scene.control.Alert;
import javafx.beans.property.ListProperty;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import dad.micv.model.Titulo;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.time.Period;

public class FormacionController {

	private FormacionView view;
	private Stage formacionAdd;
	private Scene formScene;
	private AddFormacionView addView;
	private ListProperty<Titulo> titulos;

	public FormacionController() {

		view = new FormacionView();
		addView = new AddFormacionView();

		formScene = new Scene(addView, 305, 155);

		formacionAdd = new Stage();
		formacionAdd.getIcons().add(new Image("cv64x64.png"));
		formacionAdd.initModality(Modality.APPLICATION_MODAL);
		formacionAdd.setTitle("Añadir Título");
		formacionAdd.setScene(formScene);

		view.getAñadirButton().setOnAction(e -> onAddButtonAction(e));
		view.getEliminarButton().setOnAction(e -> onEliminarButtonAction(e));

		addView.getCancelarButton().setOnAction(e -> onCancelarButton(e));
		addView.getAddButton().setOnAction(e -> onConfirmAction(e));
	}

	public void bind(ListProperty<Titulo> tituloProperty) {
		this.titulos = tituloProperty;
		view.getFormacionTable().itemsProperty().bind(titulos);
	}

	private void onConfirmAction(ActionEvent e) {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText(null);

		try {
			if (Period.between(addView.getDesde().getValue(), addView.getHasta().getValue()).getDays() > 0) {
				Titulo t1 = new Titulo();
				t1.setDesde(addView.getDesde().getValue());
				t1.setHasta(addView.getHasta().getValue());
				t1.setDenominacion(addView.getDenominacionText().getText());
				t1.setOrganizador(addView.getOrganizadorText().getText());
				titulos.add(t1);
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

	private void vaciarVentana() {
		addView.getDesde().setValue(null);
		addView.getHasta().setValue(null);
		addView.getDenominacionText().setText("");
		addView.getOrganizadorText().setText("");
	}

	private void onCancelarButton(ActionEvent e) {
		formacionAdd.close();
	}

	private void onEliminarButtonAction(ActionEvent e) {
		titulos.remove(view.getFormacionTable().getSelectionModel().getSelectedItem());
	}

	private void onAddButtonAction(ActionEvent e) {
		formacionAdd.show();
	}

	public FormacionView getView() {
		return view;
	}

}