package dad.micv.view;

import dad.micv.model.Nacionalidad;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PersonalView extends GridPane {

	private Label dniLabel, nombreLabel, apellidosLabel, fechaNacLabel, direccionLabel, codPostalLabel, localidadLabel,
			paisLabel, nacionalidadLabel;
	private TextArea direccionText;
	private TextField dniText, nombreText, apellidosText, codPostalText, localidadText;
	private DatePicker fechaNacimiento;
	private Button masButton, menosButton;
	private ComboBox<String> pais;
	private ListView<Nacionalidad> nacionalidadList;

	public PersonalView() {

		dniLabel = new Label("DNI/NIE/Pasaporte");
		nombreLabel = new Label("Nombre");
		apellidosLabel = new Label("Apellidos");
		fechaNacLabel = new Label("Fecha de nacimiento");
		direccionLabel = new Label("Dirección");
		codPostalLabel = new Label("Código Postal");
		localidadLabel = new Label("Localidad");
		paisLabel = new Label("País");
		nacionalidadLabel = new Label("Nacionalidad");

		direccionText = new TextArea();
		direccionText.setMaxHeight(50);

		nacionalidadList = new ListView<Nacionalidad>();
		nacionalidadList.setMaxHeight(150);

		dniText = new TextField();
		nombreText = new TextField();
		apellidosText = new TextField();
		codPostalText = new TextField();
		codPostalText.setMaxWidth(70);
		localidadText = new TextField();

		fechaNacimiento = new DatePicker();

		pais = new ComboBox<>();
		pais.setPromptText("Seleccione un país");

		masButton = new Button("+");
		masButton.setMaxWidth(Double.MAX_VALUE);
		menosButton = new Button("-");
		menosButton.setMaxWidth(Double.MAX_VALUE);

		add(dniLabel, 0, 0);
		add(dniText, 1, 0);
		add(nombreLabel, 0, 1);
		add(nombreText, 1, 1);
		add(apellidosLabel, 0, 2);
		add(apellidosText, 1, 2);
		add(fechaNacLabel, 0, 3);
		add(fechaNacimiento, 1, 3);
		add(direccionLabel, 0, 4);
		add(direccionText, 1, 4);
		add(codPostalLabel, 0, 5);
		add(codPostalText, 1, 5);
		add(localidadLabel, 0, 6);
		add(localidadText, 1, 6);
		add(paisLabel, 0, 7);
		add(pais, 1, 7);
		add(nacionalidadLabel, 0, 8);
		add(nacionalidadList, 1, 8);
		add(new VBox(5, masButton, menosButton), 2, 8);

		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.RIGHT);
		col1.setPrefWidth(120);

		ColumnConstraints col2 = new ColumnConstraints();
		col2.setHgrow(Priority.ALWAYS);

		ColumnConstraints col3 = new ColumnConstraints();
		col3.setHgrow(Priority.NEVER);

		getColumnConstraints().addAll(col1, col2, col3);

		setColumnSpan(dniText, 2);
		setColumnSpan(nombreText, 2);
		setColumnSpan(apellidosText, 2);
		setColumnSpan(direccionText, 2);
		setColumnSpan(localidadText, 2);

		setPadding(new Insets(5));
		setVgap(5);
		setHgap(5);

	}

	public Button getMasButton() {
		return masButton;
	}

	public Button getMenosButton() {
		return menosButton;
	}

	public Label getDniLabel() {
		return dniLabel;
	}

	public Label getNombreLabel() {
		return nombreLabel;
	}

	public Label getApellidosLabel() {
		return apellidosLabel;
	}

	public Label getFechaNacLabel() {
		return fechaNacLabel;
	}

	public Label getDireccionLabel() {
		return direccionLabel;
	}

	public Label getCodPostalLabel() {
		return codPostalLabel;
	}

	public Label getLocalidadLabel() {
		return localidadLabel;
	}

	public Label getPaisLabel() {
		return paisLabel;
	}

	public Label getNacionalidadLabel() {
		return nacionalidadLabel;
	}

	public TextArea getDireccionText() {
		return direccionText;
	}

	public ListView<Nacionalidad> getNacionalidadList() {
		return nacionalidadList;
	}

	public TextField getDniText() {
		return dniText;
	}

	public TextField getNombreText() {
		return nombreText;
	}

	public TextField getApellidosText() {
		return apellidosText;
	}

	public TextField getCodPostalText() {
		return codPostalText;
	}

	public TextField getLocalidadText() {
		return localidadText;
	}

	public DatePicker getFechaNacimiento() {
		return fechaNacimiento;
	}

	public ComboBox<String> getPais() {
		return pais;
	}

}
