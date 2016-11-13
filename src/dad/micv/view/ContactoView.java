package dad.micv.view;

import dad.micv.model.Email;
import dad.micv.model.Telefono;
import dad.micv.model.TipoTelefono;
import dad.micv.model.Web;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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

	private ObservableList<TipoTelefono> tipoTelefonos;
	
	private TitledPane telefonosPane;
	private TitledPane emailsPane;
	private TitledPane websPane;

	private GridPane telefonoINPane, emailsINPane, websINPane;

	private Button telefonoAddButton, telefonoDelButotn;
	private Button emailsAddButton, emailsDelButotn;
	private Button websAddButton, websDelButotn;

	public ContactoView() {

		tipoTelefonos = FXCollections.observableArrayList(TipoTelefono.DOMICILIO, TipoTelefono.MOVIL);
		
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
		telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("numero"));
		telefonoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		telefonoColumn.setPrefWidth(120);
		tipoTelefonoColumn = new TableColumn<>("Tipo");
		tipoTelefonoColumn.setCellFactory(ComboBoxTableCell.forTableColumn(tipoTelefonos));
		tipoTelefonoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tipoTelefonoColumn.setPrefWidth(120);

		telefonosTable = new TableView<Telefono>();
		telefonosTable.setEditable(true);
		telefonosTable.getColumns().add(telefonoColumn);
		telefonosTable.getColumns().add(tipoTelefonoColumn);

		emailColumn = new TableColumn<>("E-Mail");
		emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		emailColumn.setPrefWidth(300);
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("direccion"));

		emailsTable = new TableView<Email>();
		emailsTable.setEditable(true);
		emailsTable.getColumns().add(emailColumn);

		webColumn = new TableColumn<>("URL");
		webColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		webColumn.setPrefWidth(300);
		webColumn.setCellValueFactory(new PropertyValueFactory<>("url"));

		websTable = new TableView<Web>();
		websTable.setEditable(true);
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
		setDividerPositions(0.33, 0.66);
	}

	public TableView<Telefono> getTelefonosTable() {
		return telefonosTable;
	}

	public TableView<Email> getEmailsTable() {
		return emailsTable;
	}

	public TableView<Web> getWebsTable() {
		return websTable;
	}

	public TableColumn<Telefono, String> getTelefonoColumn() {
		return telefonoColumn;
	}

	public TableColumn<Telefono, TipoTelefono> getTipoTelefonoColumn() {
		return tipoTelefonoColumn;
	}

	public TableColumn<Email, String> getEmailColumn() {
		return emailColumn;
	}

	public TableColumn<Web, String> getWebColumn() {
		return webColumn;
	}

	public TitledPane getTelefonosPane() {
		return telefonosPane;
	}

	public TitledPane getEmailsPane() {
		return emailsPane;
	}

	public TitledPane getWebsPane() {
		return websPane;
	}

	public GridPane getTelefonoINPane() {
		return telefonoINPane;
	}

	public GridPane getEmailsINPane() {
		return emailsINPane;
	}

	public GridPane getWebsINPane() {
		return websINPane;
	}

	public Button getTelefonoAddButton() {
		return telefonoAddButton;
	}

	public Button getTelefonoDelButotn() {
		return telefonoDelButotn;
	}

	public Button getEmailsAddButton() {
		return emailsAddButton;
	}

	public Button getEmailsDelButotn() {
		return emailsDelButotn;
	}

	public Button getWebsAddButton() {
		return websAddButton;
	}

	public Button getWebsDelButotn() {
		return websDelButotn;
	}
}
