package dad.micv.view;

import dad.micv.model.Conocimiento;
import dad.micv.model.Nivel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ConocimientoView extends GridPane {

	private TableView<Conocimiento> conocimientoTable;
	private TableColumn<Conocimiento, Nivel> nivelColumn;
	private TableColumn<Conocimiento, String> denominacionColumn;
	private ObservableList<Nivel> niveles;
	private Button addConocimientoButton, addIdiomaButton, eliminarButton;

	public ConocimientoView() {

		conocimientoTable = new TableView<>();
		conocimientoTable.setEditable(true);
		
		niveles = FXCollections.observableArrayList(Nivel.BASICO, Nivel. MEDIO, Nivel.AVANZADO);

		nivelColumn = new TableColumn<>("Nivel");
		nivelColumn.setCellValueFactory(new PropertyValueFactory<>("nivel"));
		nivelColumn.setCellFactory(ComboBoxTableCell.forTableColumn(niveles));

		denominacionColumn = new TableColumn<>("Denominacion");
		denominacionColumn.setCellValueFactory(new PropertyValueFactory<>("denominacion"));
		denominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		denominacionColumn.setPrefWidth(150);

		conocimientoTable.getColumns().add(denominacionColumn);
		conocimientoTable.getColumns().add(nivelColumn);

		addConocimientoButton = new Button("Añadir conocimiento");
		addIdiomaButton = new Button("Añadir Idioma");
		addIdiomaButton.setMaxWidth(Double.MAX_VALUE);
		eliminarButton = new Button("Eliminar");
		eliminarButton.setMaxWidth(Double.MAX_VALUE);

		GridPane.setHgrow(conocimientoTable, Priority.ALWAYS);
		GridPane.setVgrow(conocimientoTable, Priority.ALWAYS);
		setHgap(5);
		setPadding(new Insets(5));
		add(conocimientoTable, 0, 0);
		add(new VBox(5, addConocimientoButton, addIdiomaButton, eliminarButton), 1, 0);

	}

	public TableView<Conocimiento> getConocimientoTable() {
		return conocimientoTable;
	}

	public TableColumn<Conocimiento, Nivel> getNivelColumn() {
		return nivelColumn;
	}

	public TableColumn<Conocimiento, String> getDenominacionColumn() {
		return denominacionColumn;
	}

	public Button getAddConocimientoButton() {
		return addConocimientoButton;
	}

	public Button getAddIdiomaButton() {
		return addIdiomaButton;
	}

	public Button getEliminarButton() {
		return eliminarButton;
	}

}
