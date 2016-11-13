package dad.micv.view;

import dad.micv.model.Conocimiento;
import dad.micv.model.Nivel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ConocimientoView extends GridPane {

	TableView<Conocimiento> conocimientoTable;
	TableColumn<Conocimiento, Nivel> nivelColumn;
	TableColumn<Conocimiento, String> denominacionColumn;

	Button addConocimientoButton, addIdiomaButton, eliminarButton;

	public ConocimientoView() {

		conocimientoTable = new TableView<>();

		nivelColumn = new TableColumn<>("Nivel");

		denominacionColumn = new TableColumn<>("Denominacion");
		denominacionColumn.setPrefWidth(150);

		conocimientoTable.getColumns().add(denominacionColumn);
		conocimientoTable.getColumns().add(nivelColumn);

		addConocimientoButton = new Button("A�adir conocimiento");
		addIdiomaButton = new Button("A�adir Idioma");
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
