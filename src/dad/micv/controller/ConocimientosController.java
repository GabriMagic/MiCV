package dad.micv.controller;

import dad.micv.model.Conocimiento;
import dad.micv.view.AddConocimientoView;
import dad.micv.view.ConocimientoView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConocimientosController {

	private Conocimiento conocimiento;
	private AddConocimientoView addConocimientoView;
	private AddIdiomaView addIdiomaView;
	private ConocimientoView view;
	private Stage addStage;
	private ObservableList<Conocimiento> habilidades;

	public ConocimientosController() {

		conocimiento = new Conocimiento();
		view = new ConocimientoView();
		addConocimientoView = new AddConocimientoView();
		addIdiomaView = new AddIdiomaView();

		habilidades = FXCollections.observableArrayList();

		addStage = new Stage();
		addStage.setTitle("Añadir habiliad");
		addStage.setScene(new Scene(new VBox()));

		view.getAddConocimientoButton().setOnAction(e -> onAddConocimiento(e));
		view.getAddIdiomaButton().setOnAction(e -> onAddIdioma(e));

		addConocimientoView.getAddButton().setOnAction(e -> addConocimiento(e));
	}

	private void addConocimiento(ActionEvent e) {
		Conocimiento c1 = new Conocimiento();
		c1.setDenominacion(addConocimientoView.getDenominacionText().getText());
		c1.setNivel(addConocimientoView.getNivelBox().getValue());

		habilidades.add(c1);
		addStage.close();

	}

	private void onAddIdioma(ActionEvent e) {
		addStage.getScene().setRoot(addIdiomaView);
		addStage.show();
	}

	private void onAddConocimiento(ActionEvent e) {
		addStage.getScene().setRoot(addConocimientoView);
		addStage.show();
	}

	public ConocimientoView getView() {
		return view;
	}

	public Conocimiento getConocimiento() {
		return conocimiento;
	}
}