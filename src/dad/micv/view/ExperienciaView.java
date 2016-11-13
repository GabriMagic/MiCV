package dad.micv.view;

import java.time.LocalDate;
import dad.micv.model.Experiencia;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

public class ExperienciaView extends GridPane {

	TableView<Experiencia> experienciaTable;
	TableColumn<Experiencia, LocalDate> desdeColumn, hastaColumn;
	TableColumn<Experiencia, String> denominacionColumn, empleadorColumn;

	Button addButton, eliminarButton;

	public ExperienciaView() {

		experienciaTable = new TableView<>();
		experienciaTable.setEditable(true);

		desdeColumn = new TableColumn<>("Desde");
		desdeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {

			@Override
			public LocalDate fromString(String string) {
				String[] partes = string.split("/");
				return LocalDate.parse(partes[2] + "-" + partes[1] + "-" + partes[0]);
			}

			@Override
			public String toString(LocalDate object) {
				return object.getDayOfMonth() + "/" + object.getMonthValue() + "/" + object.getYear();
			}
		}));
		desdeColumn.setCellValueFactory(new PropertyValueFactory<>("desde"));
		desdeColumn.setPrefWidth(100);

		hastaColumn = new TableColumn<>("Hasta");
		hastaColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {

			@Override
			public LocalDate fromString(String string) {
				String[] partes = string.split("/");
				return LocalDate.parse(partes[2] + "-" + partes[1] + "-" + partes[0]);
			}

			@Override
			public String toString(LocalDate object) {
				return object.getDayOfMonth() + "/" + object.getMonthValue() + "/" + object.getYear();
			}
		}));
		hastaColumn.setCellValueFactory(new PropertyValueFactory<>("hasta"));
		hastaColumn.setPrefWidth(100);

		denominacionColumn = new TableColumn<>("Denominacion");
		denominacionColumn.setCellValueFactory(new PropertyValueFactory<>("denominacion"));
		denominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		denominacionColumn.setPrefWidth(150);

		empleadorColumn = new TableColumn<>("Empleador");
		empleadorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		empleadorColumn.setCellValueFactory(new PropertyValueFactory<>("empleador"));
		empleadorColumn.setPrefWidth(150);

		experienciaTable.getColumns().add(desdeColumn);
		experienciaTable.getColumns().add(hastaColumn);
		experienciaTable.getColumns().add(denominacionColumn);
		experienciaTable.getColumns().add(empleadorColumn);

		addButton = new Button("Añadir");
		addButton.setDefaultButton(true);
		addButton.setMaxWidth(Double.MAX_VALUE);

		eliminarButton = new Button("Eliminar");

		GridPane.setHgrow(experienciaTable, Priority.ALWAYS);
		GridPane.setVgrow(experienciaTable, Priority.ALWAYS);
		setHgap(5);
		setPadding(new Insets(5));
		add(experienciaTable, 0, 0);
		add(new VBox(5, addButton, eliminarButton), 1, 0);

	}

	public TableView<Experiencia> getExperienciaTable() {
		return experienciaTable;
	}

	public TableColumn<Experiencia, String> getEmpleadorColumn() {
		return empleadorColumn;
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getEliminarButton() {
		return eliminarButton;
	}

}
