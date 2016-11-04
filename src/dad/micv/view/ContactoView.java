package dad.micv.view;

import dad.micv.model.Email;
import dad.micv.model.Telefono;
import dad.micv.model.TipoTelefono;
import dad.micv.model.Web;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ContactoView extends SplitPane {

	private TableView<Telefono> telefonosTable;
	private TableView<Email> emailsTable;
	private TableView<Web> websTable;
	private TableColumn<Telefono, String> telefonoColumn;
	private TableColumn<Telefono, TipoTelefono> tipoTelefonoColumn;
	private TableColumn<Email, String> emailColumn;
	private TableColumn<Web, String> webColumn;

	private TitledPane telefonosPane;
	private TitledPane emailsPane;
	private TitledPane websPane;

	private GridPane telefonoINPane, emailsINPane, websINPane;

	private Button telefonoAddButton, telefonoDelButotn;
	private Button emailsAddButton, emailsDelButotn;
	private Button websAddButton, websDelButotn;

	public ContactoView() {

		telefonoAddButton = new Button("Añadir");
		telefonoAddButton.setMaxWidth(Double.MAX_VALUE);
		telefonoDelButotn = new Button("Eliminar");
		emailsAddButton = new Button("Añadir");
		emailsAddButton.setMaxWidth(Double.MAX_VALUE);
		emailsDelButotn = new Button("Eliminar");
		websAddButton = new Button("Añadir");
		websAddButton.setMaxWidth(Double.MAX_VALUE);
		websDelButotn = new Button("Eliminar");

		telefonoColumn = new TableColumn<>("Número");
		telefonoColumn.setMaxWidth(500);
		tipoTelefonoColumn = new TableColumn<>("Tipo");

		telefonosTable = new TableView<Telefono>();
		telefonosTable.getColumns().add(telefonoColumn);
		telefonosTable.getColumns().add(tipoTelefonoColumn);

		emailColumn = new TableColumn<>("E-Mail");

		emailsTable = new TableView<Email>();
		emailsTable.getColumns().add(emailColumn);

		webColumn = new TableColumn<>("URL");

		websTable = new TableView<Web>();
		websTable.getColumns().add(webColumn);

		// SPLITPANEL TELEFONOS
		telefonoINPane = new GridPane();
		GridPane.setHgrow(telefonosTable, Priority.ALWAYS);
		telefonoINPane.setHgap(5);
		telefonoINPane.setMaxWidth(Double.MAX_VALUE);
		telefonoINPane.add(telefonosTable, 0, 0);
		telefonoINPane.add(new VBox(5, telefonoAddButton, telefonoDelButotn), 1, 0);

		telefonosPane = new TitledPane();
		telefonosPane.setText("Teléfonos");
		telefonosPane.setPadding(new Insets(5));
		telefonosPane.setCollapsible(false);
		telefonosPane.setContent(telefonoINPane);

		// SPLITPANEL EMAILS
		emailsINPane = new GridPane();
		GridPane.setHgrow(emailsTable, Priority.ALWAYS);
		emailsINPane.setHgap(5);
		emailsINPane.setMaxWidth(Double.MAX_VALUE);
		emailsINPane.add(emailsTable, 0, 0);
		emailsINPane.add(new VBox(5, emailsAddButton, emailsDelButotn), 1, 0);

		emailsPane = new TitledPane();
		emailsPane.setText("E-Mails");
		emailsPane.setPadding(new Insets(5));
		emailsPane.setCollapsible(false);
		emailsPane.setContent(emailsINPane);

		// SPLITPANEL WEBS
		websINPane = new GridPane();
		GridPane.setHgrow(websTable, Priority.ALWAYS);
		websINPane.setHgap(5);
		websINPane.setMaxWidth(Double.MAX_VALUE);
		websINPane.add(websTable, 0, 0);
		websINPane.add(new VBox(5, websAddButton, websDelButotn), 1, 0);

		websPane = new TitledPane();
		websPane.setText("Webs");
		websPane.setPadding(new Insets(5));
		websPane.setCollapsible(false);
		websPane.setContent(websINPane);

		getItems().addAll(telefonosPane, emailsPane, websPane);

		setOrientation(Orientation.VERTICAL);
	}
}
