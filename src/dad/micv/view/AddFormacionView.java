package dad.micv.view;

import dad.micv.model.Titulo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AddFormacionView extends GridPane {

	private Titulo formacion;
	private Label desdeLabel, hastaLabel, denominacionLabel, organizadorLabel;
	private DatePicker desde, hasta;
	private TextField denominacionText, organizadorText;
	private Button addButton, cancelarButton;

	public AddFormacionView() {

		formacion = new Titulo();

		desdeLabel = new Label("Desde");
		hastaLabel = new Label("Hasta");
		denominacionLabel = new Label("Denominación");
		organizadorLabel = new Label("Organizador");

		desde = new DatePicker();
		hasta = new DatePicker();

		denominacionText = new TextField();
		organizadorText = new TextField();

		addButton = new Button("Añadir");
		addButton.setDefaultButton(true);

		cancelarButton = new Button("Cancelar");

		HBox cajaButton = new HBox(5, addButton, cancelarButton);
		cajaButton.setAlignment(Pos.BASELINE_RIGHT);

		add(desdeLabel, 0, 0);
		add(desde, 1, 0);
		add(hastaLabel, 0, 1);
		add(hasta, 1, 1);
		add(denominacionLabel, 0, 2);
		add(denominacionText, 1, 2);
		add(organizadorLabel, 0, 3);
		add(organizadorText, 1, 3);
		add(cajaButton, 1, 4);

		ColumnConstraints col1 = new ColumnConstraints();
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setHgrow(Priority.ALWAYS);

		getColumnConstraints().addAll(col1, col2);

		setPadding(new Insets(5));
		setVgap(5);
		setHgap(5);
	}

	public Titulo getFormacion() {
		return formacion;
	}

	public Label getDesdeLabel() {
		return desdeLabel;
	}

	public Label getHastaLabel() {
		return hastaLabel;
	}

	public Label getDenominacionLabel() {
		return denominacionLabel;
	}

	public Label getOrganizadorLabel() {
		return organizadorLabel;
	}

	public DatePicker getDesde() {
		return desde;
	}

	public DatePicker getHasta() {
		return hasta;
	}

	public TextField getDenominacionText() {
		return denominacionText;
	}

	public TextField getOrganizadorText() {
		return organizadorText;
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

}
