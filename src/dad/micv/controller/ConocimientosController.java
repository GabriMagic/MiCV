package dad.micv.controller;

import dad.micv.model.Conocimiento;
import dad.micv.model.Idioma;
import dad.micv.model.Nivel;
import dad.micv.view.AddConocimientoView;
import dad.micv.view.AddIdiomaView;
import dad.micv.view.ConocimientoView;
import javafx.beans.property.ListProperty;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConocimientosController {

	private AddConocimientoView addConocimientoView;
	private AddIdiomaView addIdiomaView;
	private ConocimientoView view;
	private Stage addStage;
	private ListProperty<Conocimiento> habilidades;

	public ConocimientosController() {

		view = new ConocimientoView();

		addConocimientoView = new AddConocimientoView();
		addIdiomaView = new AddIdiomaView();

		addStage = new Stage();
		addStage.initModality(Modality.APPLICATION_MODAL);
		addStage.setTitle("Añadir habiliad");
		addStage.setScene(new Scene(new VBox()));

		view.getAddConocimientoButton().setOnAction(e -> onAddConocimiento(e));
		view.getAddIdiomaButton().setOnAction(e -> onAddIdioma(e));
		view.getEliminarButton().setOnAction(e -> onEliminar(e));

		addConocimientoView.getAddButton().setOnAction(e -> addConocimiento(e));
		addConocimientoView.getCancelButton().setOnAction(e -> EndConocimientoADD(e));
		addIdiomaView.getAddButton().setOnAction(e -> addIdioma(e));
		addIdiomaView.getCancelButton().setOnAction(e -> EndIdiomaADD(e));
	}

	public void bind(ListProperty<Conocimiento> habilidadProperty) {
		this.habilidades = habilidadProperty;
		view.getConocimientoTable().itemsProperty().bind(habilidades);
	}

	// CONOCIMIENTOS
	private void onAddConocimiento(ActionEvent e) {
		addStage.getScene().setRoot(addConocimientoView);
		addStage.show();
	}

	private void addConocimiento(ActionEvent e) {
		Conocimiento c1 = new Conocimiento();
		c1.setDenominacion(addConocimientoView.getDenominacionText().getText());
		c1.setNivel(addConocimientoView.getNivelBox().getValue());

		habilidades.add(c1);
		EndConocimientoADD(e);

	}

	private void EndConocimientoADD(ActionEvent e) {
		addStage.close();
		addConocimientoView.getDenominacionText().setText("");
		addConocimientoView.getNivelBox().setValue(Nivel.BASICO);
	}

	// IDIOMAS
	private void onAddIdioma(ActionEvent e) {
		addStage.getScene().setRoot(addIdiomaView);
		addStage.show();
	}

	private void addIdioma(ActionEvent e) {
		Idioma i1 = new Idioma();
		i1.setDenominacion(addIdiomaView.getDenominacionText().getText());
		i1.setCertificacion(addIdiomaView.getCertificacionText().getText());
		i1.setNivel(addConocimientoView.getNivelBox().getValue());

		habilidades.add(i1);
		EndIdiomaADD(e);
	}

	private void EndIdiomaADD(ActionEvent e) {
		addStage.close();
		addIdiomaView.getDenominacionText().setText("");
		addIdiomaView.getCertificacionText().setText("");
		addIdiomaView.getNivelBox().setValue(Nivel.BASICO);
	}

	private void onEliminar(ActionEvent e) {
		habilidades.remove(view.getConocimientoTable().getSelectionModel().getSelectedItem());
	}

	public ConocimientoView getView() {
		return view;
	}

}