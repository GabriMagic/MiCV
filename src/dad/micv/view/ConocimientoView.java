package dad.micv.view;

import dad.micv.model.Experiencia;
import dad.micv.model.Nivel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ConocimientoView extends GridPane {

	TableView<Experiencia> conocimientoTable;
	TableColumn<Experiencia, Nivel> nivelColumn;
	TableColumn<Experiencia, String> denominacionColumn;

	Button aņadirConocimientoButton, aņadirIdiomaButton, eliminarButton;

	public ConocimientoView() {

		conocimientoTable = new TableView<>();

		nivelColumn = new TableColumn<>("Nivel");

		denominacionColumn = new TableColumn<>("Denominacion");
		denominacionColumn.setPrefWidth(150);

		conocimientoTable.getColumns().add(denominacionColumn);
		conocimientoTable.getColumns().add(nivelColumn);

		aņadirConocimientoButton = new Button("Aņadir conocimiento");
		aņadirIdiomaButton = new Button("Aņadir Idioma");
		aņadirIdiomaButton.setMaxWidth(Double.MAX_VALUE);
		eliminarButton = new Button("Eliminar");
		eliminarButton.setMaxWidth(Double.MAX_VALUE);

		GridPane.setHgrow(conocimientoTable, Priority.ALWAYS);
		GridPane.setVgrow(conocimientoTable, Priority.ALWAYS);
		setHgap(5);
		setPadding(new Insets(5));
		add(conocimientoTable, 0, 0);
		add(new VBox(5, aņadirConocimientoButton, aņadirIdiomaButton, eliminarButton), 1, 0);

	}
}
