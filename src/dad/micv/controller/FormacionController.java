package dad.micv.controller;

import dad.micv.main.MiCvAPP;
import dad.micv.model.Titulo;
import dad.micv.view.FormacionADDView;
import dad.micv.view.FormacionView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormacionController {

	private MiCvAPP app;
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

		app = new MiCvAPP();

		titulo = new Titulo();

		titulos = FXCollections.observableArrayList();

		formScene = new Scene(controller.getView(), 305, 155);

		formacionAdd = new Stage();
		formacionAdd.initModality(Modality.APPLICATION_MODAL);
		formacionAdd.initOwner(app.getPrimaryStage());
		formacionAdd.setTitle("Añadir Título");

		formacionAdd.setScene(formScene);

		view.getAñadirButton().setOnAction(e -> onAddButtonAction(e));
		view.getEliminarButton().setOnAction(e -> onEliminarButtonAction(e));
		editVista.getCancelarButton().setOnAction(e -> onCancelarButton(e));
		editVista.getAddButton().setOnAction(e -> onConfirmAction(e));
	}

	private void onConfirmAction(ActionEvent e) {

		titulo.setDesde(editVista.getDesde().getValue());
		titulo.setHasta(editVista.getHasta().getValue());
		titulo.setDenominacion(editVista.getDenominacionText().getText());
		titulo.setOrganizador(editVista.getOrganizadorText().getText());

		titulos.add(titulo);
		view.getFormacionTable().setItems(titulos);
		formacionAdd.close();

		editVista.getDesde().setValue(null);
		editVista.getHasta().setValue(null);
		editVista.getDenominacionText().setText(null);
		editVista.getOrganizadorText().setText(null);

	}

	private void onCancelarButton(ActionEvent e) {
		formacionAdd.close();
	}

	private void onEliminarButtonAction(ActionEvent e) {

	}

	private void onAddButtonAction(ActionEvent e) {
		formacionAdd.show();
	}

	public FormacionView getView() {
		return view;
	}
}
