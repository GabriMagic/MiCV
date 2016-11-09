package dad.micv.view;

import dad.micv.model.Titulo;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FormacionADDView extends GridPane {

	private Titulo formacion;
	private Label desdeLabel, hastaLabel, denominacionLabel, organizadorLabel;
	private DatePicker desde, hasta;
	private TextField denominacionText, organizadorText;

	public FormacionADDView() {

		formacion = new Titulo();

		desdeLabel = new Label("Desde");
		hastaLabel = new Label("Hasta");
		denominacionLabel = new Label("Denominación");
		organizadorLabel = new Label("Organizador");

		desde = new DatePicker();
		hasta = new DatePicker();

		denominacionText = new TextField();
		organizadorText = new TextField();

		add(desdeLabel, 0, 0);
		add(desde, 1, 0);
		add(hastaLabel, 0, 1);
		add(hasta, 1, 1);
		add(denominacionLabel, 0, 2);
		add(denominacionText, 1, 2);
		add(organizadorLabel, 0, 3);
		add(organizadorText, 1, 3);

		
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

}
