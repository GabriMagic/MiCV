package dad.micv.controller;

import dad.micv.model.Nivel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AddIdiomaView extends GridPane {

	private Label denominacionLabel, nivelLabel, certificacionLabel;
	private TextField denominacionText, certificacionText;
	private ComboBox<Nivel> nivelBox;
	private Button addButton, cancelButton;

	public AddIdiomaView() {

		denominacionLabel = new Label("Denominación");
		certificacionLabel = new Label("Certificación");
		nivelLabel = new Label("Nivel");

		denominacionText = new TextField();
		denominacionText.setPrefColumnCount(10);

		certificacionText = new TextField();
		certificacionText.setPrefColumnCount(10);

		nivelBox = new ComboBox<>();
		nivelBox.setPromptText("Seleccione tipo");
		nivelBox.getItems().addAll(Nivel.BASICO, Nivel.MEDIO, Nivel.AVANZADO);
		nivelBox.setValue(Nivel.BASICO);

		addButton = new Button("Añadir");
		addButton.setMaxWidth(Double.MAX_VALUE);
		addButton.setDefaultButton(true);

		cancelButton = new Button("Cancelar");

		HBox botones = new HBox(5, addButton, cancelButton);
		botones.setAlignment(Pos.BASELINE_RIGHT);

		add(denominacionLabel, 0, 0);
		add(denominacionText, 1, 0);

		add(certificacionLabel, 0, 1);
		add(certificacionText, 1, 1);

		add(nivelLabel, 0, 2);
		add(nivelBox, 1, 2);
		add(botones, 1, 2);

		GridPane.setHgrow(denominacionText, Priority.ALWAYS);

		setVgap(5);
		setHgap(5);

		setPadding(new Insets(10));

	}

	public Label getDenominacionLabel() {
		return denominacionLabel;
	}

	public Label getNivelLabel() {
		return nivelLabel;
	}

	public TextField getTelefonoText() {
		return denominacionText;
	}

	public TextField getCertificacionText() {
		return certificacionText;
	}

	public ComboBox<Nivel> getNivelBox() {
		return nivelBox;
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

}
