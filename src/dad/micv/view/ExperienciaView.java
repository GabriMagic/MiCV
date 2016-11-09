package dad.micv.view;

import java.time.LocalDate;
import dad.micv.model.Experiencia;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ExperienciaView extends GridPane {

	TableView<Experiencia> experienciaTable;
	TableColumn<Experiencia, LocalDate> desdeColumn, hastaColumn;
	TableColumn<Experiencia, String> denominacionColumn, empleadorColumn;

	Button añadirButton, eliminarButton;

	public ExperienciaView() {

		experienciaTable = new TableView<>();
		
		desdeColumn = new TableColumn<>("Desde");
		desdeColumn.setPrefWidth(100);
		
		hastaColumn = new TableColumn<>("Hasta");
		hastaColumn.setPrefWidth(100);
		
		denominacionColumn = new TableColumn<>("Denominacion");
		denominacionColumn.setPrefWidth(150);
		
		empleadorColumn = new TableColumn<>("Empleador");
		empleadorColumn.setPrefWidth(150);
		
		experienciaTable.getColumns().add(desdeColumn);
		experienciaTable.getColumns().add(hastaColumn);
		experienciaTable.getColumns().add(denominacionColumn);
		experienciaTable.getColumns().add(empleadorColumn);

		añadirButton = new Button("Añadir");
		añadirButton.setMaxWidth(Double.MAX_VALUE);
		eliminarButton = new Button("Eliminar");

		GridPane.setHgrow(experienciaTable, Priority.ALWAYS);
		GridPane.setVgrow(experienciaTable, Priority.ALWAYS);
		setHgap(5);
		setPadding(new Insets(5));
		add(experienciaTable, 0, 0);
		add(new VBox(5, añadirButton, eliminarButton), 1, 0);

	}
}
