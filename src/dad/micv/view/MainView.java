package dad.micv.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {

	MenuBar menuBar;
	Menu archivo, ayuda;
	MenuItem nuevo, abrir, guardar, guardarComo, salir, acercaDe;
	TabPane tabPane;
	Tab personalTab, contactoTab, formaciónTab, experienciaTab, conocimientosTab;

	public MainView() {
		super();

		menuBar = new MenuBar();

		// MENU ITEMS
		nuevo = new MenuItem("Nuevo", new ImageView("nuevo.gif"));
		nuevo.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));

		abrir = new MenuItem("Abrir", new ImageView("abrir.gif"));
		abrir.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));

		guardar = new MenuItem("Guardar", new ImageView("guardar.gif"));
		guardar.setAccelerator(KeyCombination.keyCombination("Ctrl+G"));

		guardarComo = new MenuItem("Guarar Como...");

		salir = new MenuItem("Salir");
		salir.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		acercaDe = new MenuItem("Acerca de...");

		archivo = new Menu("_Archivo");
		archivo.setMnemonicParsing(true);
		ayuda = new Menu("A_yuda");
		ayuda.setMnemonicParsing(true);

		archivo.getItems().addAll(nuevo, abrir, guardar, guardarComo, new SeparatorMenuItem(), salir);
		ayuda.getItems().addAll(acercaDe);

		menuBar.getMenus().addAll(archivo, ayuda);

		personalTab = new Tab("Personal");
		personalTab.setClosable(false);
		contactoTab = new Tab("Contacto");
		contactoTab.setClosable(false);
		formaciónTab = new Tab("Formación");
		formaciónTab.setClosable(false);
		experienciaTab = new Tab("Experiencia");
		experienciaTab.setClosable(false);
		conocimientosTab = new Tab("Habilidades");
		conocimientosTab.setClosable(false);

		tabPane = new TabPane(personalTab, contactoTab, formaciónTab, experienciaTab, conocimientosTab);

		setTop(menuBar);
		setCenter(tabPane);
	}

	public MenuItem getNuevo() {
		return nuevo;
	}

	public MenuItem getAbrir() {
		return abrir;
	}

	public MenuItem getGuardar() {
		return guardar;
	}

	public MenuItem getGuardarComo() {
		return guardarComo;
	}

	public MenuItem getSalir() {
		return salir;
	}

	public MenuItem getAcercaDe() {
		return acercaDe;
	}

	public TabPane getTabPane() {
		return tabPane;
	}

	public Tab getPersonalTab() {
		return personalTab;
	}

	public Tab getContactoTab() {
		return contactoTab;
	}

	public Tab getFormaciónTab() {
		return formaciónTab;
	}

	public Tab getExperienciaTab() {
		return experienciaTab;
	}

	public Tab getConocimientosTab() {
		return conocimientosTab;
	}

}