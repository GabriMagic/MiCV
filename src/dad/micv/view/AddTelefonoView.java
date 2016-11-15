package dad.micv.view;

import dad.micv.model.TipoTelefono;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AddTelefonoView extends GridPane {

	private Label telefonoLabel, tipoTelefonoLabel;
	private TextField telefonoText;
	private ComboBox<TipoTelefono> tipoTelefonoBox;
	private Button addButton, cancelButton;

	public AddTelefonoView() {

		telefonoLabel = new Label("Teléfono");

		tipoTelefonoLabel = new Label("Tipo de teléfono");

		telefonoText = new TextField();
		telefonoText.setPrefColumnCount(10);

		tipoTelefonoBox = new ComboBox<>();
		tipoTelefonoBox.setPromptText("Seleccione tipo");
		tipoTelefonoBox.getItems().addAll(TipoTelefono.DOMICILIO, TipoTelefono.MOVIL);
		tipoTelefonoBox.setMaxWidth(Double.MAX_VALUE);
		tipoTelefonoBox.setValue(TipoTelefono.DOMICILIO);

		addButton = new Button("Añadir");
		addButton.setDefaultButton(true);

		cancelButton = new Button("Cancelar");

		HBox botones = new HBox(5, addButton, cancelButton);
		botones.setAlignment(Pos.BASELINE_RIGHT);

		add(telefonoLabel, 0, 0);
		add(tipoTelefonoLabel, 0, 1);
		add(telefonoText, 1, 0);
		add(tipoTelefonoBox, 1, 1);
		add(botones, 1, 2);

		GridPane.setHgrow(telefonoText, Priority.ALWAYS);

		setVgap(5);
		setHgap(5);

		setPadding(new Insets(10));

	}

	public Label getTelefonoLabel() {
		return telefonoLabel;
	}

	public Label getTipoTelefonoLabel() {
		return tipoTelefonoLabel;
	}

	public TextField getTelefonoText() {
		return telefonoText;
	}

	public ComboBox<TipoTelefono> getTipoTelefonoBox() {
		return tipoTelefonoBox;
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

}
