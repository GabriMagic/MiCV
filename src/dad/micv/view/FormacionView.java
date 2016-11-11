package dad.micv.view;

import java.time.LocalDate;
import dad.micv.model.Titulo;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class FormacionView extends GridPane {

	TableView<Titulo> formacionTable;
	TableColumn<Titulo, LocalDate> desdeColumn, hastaColumn;
	TableColumn<Titulo, String> denominacionColumn, organizadorColumn;

	Button addButton, eliminarButton;

	public FormacionView() {

		formacionTable = new TableView<>();

		desdeColumn = new TableColumn<>("FechaInicio");
		desdeColumn.setCellValueFactory(new PropertyValueFactory<>("desde"));
		desdeColumn.setPrefWidth(100);

		hastaColumn = new TableColumn<>("FechaFin");
		hastaColumn.setCellValueFactory(new PropertyValueFactory<>("hasta"));
		hastaColumn.setPrefWidth(100);

		denominacionColumn = new TableColumn<>("Denominacion");
		denominacionColumn.setCellValueFactory(new PropertyValueFactory<>("denominacion"));
		denominacionColumn.setPrefWidth(150);

		organizadorColumn = new TableColumn<>("Organizador");
		organizadorColumn.setCellValueFactory(new PropertyValueFactory<>("organizador"));
		organizadorColumn.setPrefWidth(150);

		formacionTable.getColumns().add(desdeColumn);
		formacionTable.getColumns().add(hastaColumn);
		formacionTable.getColumns().add(denominacionColumn);
		formacionTable.getColumns().add(organizadorColumn);

		addButton = new Button("Aņadir");
		addButton.setMaxWidth(Double.MAX_VALUE);
		addButton.setDefaultButton(true);
		eliminarButton = new Button("Eliminar");

		GridPane.setHgrow(formacionTable, Priority.ALWAYS);
		GridPane.setVgrow(formacionTable, Priority.ALWAYS);
		setHgap(5);
		setPadding(new Insets(5));
		add(formacionTable, 0, 0);
		add(new VBox(5, addButton, eliminarButton), 1, 0);

	}

	public TableView<Titulo> getFormacionTable() {
		return formacionTable;
	}

	public TableColumn<Titulo, LocalDate> getDesdeColumn() {
		return desdeColumn;
	}

	public TableColumn<Titulo, LocalDate> getHastaColumn() {
		return hastaColumn;
	}

	public TableColumn<Titulo, String> getDenominacionColumn() {
		return denominacionColumn;
	}

	public TableColumn<Titulo, String> getOrganizadorColumn() {
		return organizadorColumn;
	}

	public Button getAņadirButton() {
		return addButton;
	}

	public Button getEliminarButton() {
		return eliminarButton;
	}
}
