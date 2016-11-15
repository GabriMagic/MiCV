package dad.micv.view;

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

public class AddConocimientoView extends GridPane {

	private Label denominacionLabel, nivelLabel;
	private TextField denominacionText;
	private ComboBox<Nivel> nivelBox;
	private Button addButton, cancelButton;

	public AddConocimientoView() {

		denominacionLabel = new Label("Denominación");

		nivelLabel = new Label("Nivel");

		denominacionText = new TextField();
		denominacionText.setPrefColumnCount(10);

		nivelBox = new ComboBox<>();
		nivelBox.setPromptText("Seleccione tipo");
		nivelBox.getItems().addAll(Nivel.BASICO, Nivel.MEDIO, Nivel.AVANZADO);
		nivelBox.setMaxWidth(Double.MAX_VALUE);
		nivelBox.setValue(Nivel.BASICO);

		addButton = new Button("Añadir");
		addButton.setDefaultButton(true);

		cancelButton = new Button("Cancelar");

		HBox botones = new HBox(5, addButton, cancelButton);
		botones.setAlignment(Pos.BASELINE_RIGHT);

		add(denominacionLabel, 0, 0);
		add(nivelLabel, 0, 1);
		add(denominacionText, 1, 0);
		add(nivelBox, 1, 1);
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

	public TextField getDenominacionText() {
		return denominacionText;
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
