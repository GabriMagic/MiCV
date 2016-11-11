package dad.micv.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AddEmailView extends GridPane {
	private Label emailLabel;
	private TextField emailText;
	private Button addButton, cancelButton;

	public AddEmailView() {

		emailLabel = new Label("Dirección");

		emailText = new TextField();

		addButton = new Button("Añadir");
		addButton.setDefaultButton(true);

		cancelButton = new Button("Cancelar");

		HBox botones = new HBox(5, addButton, cancelButton);
		botones.setAlignment(Pos.BASELINE_RIGHT);

		add(emailLabel, 0, 0);
		add(emailText, 1, 0);
		add(botones, 1, 2);

		GridPane.setHgrow(emailText, Priority.ALWAYS);

		setVgap(5);
		setHgap(5);

		setPadding(new Insets(10, 10, 20, 10));

	}

	public Label getEmailLabel() {
		return emailLabel;
	}

	public TextField getEmailText() {
		return emailText;
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

}
