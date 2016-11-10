package dad.micv.controller;

import javafx.scene.control.Alert.AlertType;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import dad.micv.view.FormacionADDView;
import dad.micv.view.FormacionView;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import dad.micv.model.Titulo;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.time.Period;

public class FormacionController {

	private Titulo titulo;
	private FormacionView view;
	private FormacionADDController controller;
	private Stage formacionAdd;
	private Scene formScene;
	private FormacionADDView editVista;
	private ObservableList<Titulo> titulos;

	public FormacionController() {

		controller = new FormacionADDController();

		view = new FormacionView();
		editVista = controller.getView();

		titulo = new Titulo();

		titulos = FXCollections.observableArrayList();

		formScene = new Scene(controller.getView(), 305, 155);

		formacionAdd = new Stage();
		formacionAdd.getIcons().add(new Image("cv64x64.png"));
		formacionAdd.initModality(Modality.APPLICATION_MODAL);
		formacionAdd.setTitle("Añadir Título");
		formacionAdd.setScene(formScene);

		view.getFormacionTable().setItems(titulos);

		view.getAñadirButton().setOnAction(e -> onAddButtonAction(e));
		view.getEliminarButton().setOnAction(e -> onEliminarButtonAction(e));
		editVista.getCancelarButton().setOnAction(e -> onCancelarButton(e));
		editVista.getAddButton().setOnAction(e -> onConfirmAction(e));

	}

	private void onConfirmAction(ActionEvent e) {

		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText(null);

		if (Period.between(editVista.getDesde().getValue(), editVista.getHasta().getValue()).getDays() > 0) {

			titulo.setDesde(editVista.getDesde().getValue());
			titulo.setHasta(editVista.getHasta().getValue());
			titulo.setDenominacion(editVista.getDenominacionText().getText());
			titulo.setOrganizador(editVista.getOrganizadorText().getText());

			titulos.add(titulo);

			vaciarVentana();

			formacionAdd.close();

		} else if (editVista.getDenominacionText().getText().isEmpty()) {
			errorAlert.setTitle("Campos vacíos");
			errorAlert.setContentText("Rellene todos los campos");
			errorAlert.show();
		} else {
			errorAlert.setTitle("Fecha Incorrecta");
			errorAlert.setContentText("Las fechas deben ser correctas.");
			errorAlert.show();
		}

	}

	private void vaciarVentana() {
		editVista.getDesde().setValue(null);
		editVista.getHasta().setValue(null);
		editVista.getDenominacionText().setText(null);
		editVista.getOrganizadorText().setText(null);
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
