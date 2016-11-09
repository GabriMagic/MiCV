package dad.micv.view;

import java.time.LocalDate;
import dad.micv.model.Titulo;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class FormacionView extends GridPane {

	TableView<Titulo> formacionTable;
	TableColumn<Titulo, LocalDate> desdeColumn, hastaColumn;
	TableColumn<Titulo, String> denominacionColumn, organizadorColumn;

	Button a�adirButton, eliminarButton;

	public FormacionView() {

		formacionTable = new TableView<>();

		desdeColumn = new TableColumn<>("Desde");
		desdeColumn.setPrefWidth(100);

		hastaColumn = new TableColumn<>("Hasta");
		hastaColumn.setPrefWidth(100);

		denominacionColumn = new TableColumn<>("Denominacion");
		denominacionColumn.setPrefWidth(150);

		organizadorColumn = new TableColumn<>("Organizador");
		organizadorColumn.setPrefWidth(150);

		formacionTable.getColumns().add(desdeColumn);
		formacionTable.getColumns().add(hastaColumn);
		formacionTable.getColumns().add(denominacionColumn);
		formacionTable.getColumns().add(organizadorColumn);

		a�adirButton = new Button("A�adir");
		a�adirButton.setMaxWidth(Double.MAX_VALUE);
		eliminarButton = new Button("Eliminar");

		GridPane.setHgrow(formacionTable, Priority.ALWAYS);
		GridPane.setVgrow(formacionTable, Priority.ALWAYS);
		setHgap(5);
		setPadding(new Insets(5));
		add(formacionTable, 0, 0);
		add(new VBox(5, a�adirButton, eliminarButton), 1, 0);

	}
}
