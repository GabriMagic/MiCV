package dad.micv.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AddWebsView extends GridPane {

	private Label webLabel;
	private TextField webText;
	private Button addButton, cancelButton;

	public AddWebsView() {

		webLabel = new Label("Dirección");

		webText = new TextField();
		webText.setPrefColumnCount(20);

		addButton = new Button("Añadir");
		addButton.setDefaultButton(true);

		cancelButton = new Button("Cancelar");

		HBox botones = new HBox(5, addButton, cancelButton);
		botones.setAlignment(Pos.BASELINE_RIGHT);

		add(webLabel, 0, 0);
		add(webText, 1, 0);
		add(botones, 1, 2);

		GridPane.setHgrow(webText, Priority.ALWAYS);

		setVgap(5);
		setHgap(5);

		setPadding(new Insets(10));

	}

	public Label getWebLabel() {
		return webLabel;
	}

	public TextField getWebText() {
		return webText;
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

}
