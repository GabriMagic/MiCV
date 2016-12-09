package dad.micv.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;
import dad.micv.model.Nacionalidad;
import dad.micv.model.Personal;
import dad.micv.view.PersonalView;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Alert.AlertType;

public class PersonalController {

	private Personal personal;

	private PersonalView view;
	private ChoiceDialog<Nacionalidad> nacionalidadChoice;
	private ArrayList<Nacionalidad> nacionChoice;
	private BufferedReader bf;
	private Comparator<Nacionalidad> nacComp;

	public PersonalController() {

		view = new PersonalView();

		nacionChoice = new ArrayList<Nacionalidad>();

		view.getMasButton().setOnAction(e -> onMasButtonAction());
		view.getMenosButton().setOnAction(e -> onMenosButtonAction());

		cargarComboBox();
		cargarNacionalidades();

		nacComp = new Comparator<Nacionalidad>() {
			@Override
			public int compare(Nacionalidad nac1, Nacionalidad nac2) {
				return nac1.getDenominacion().compareToIgnoreCase(nac2.getDenominacion());
			}
		};

	}

	public void bind(Personal personal) {
		this.personal = personal;
		view.getNombreText().textProperty().bind(personal.nombreProperty());
		view.getDniText().textProperty().bind(personal.dniProperty());
		view.getApellidosText().textProperty().bind(personal.apellidosProperty());
		view.getFechaNacimiento().valueProperty().bind(personal.fechaNacimientoProperty());
		view.getCodPostalText().textProperty().bind(personal.codigoPostalProperty());
		view.getDireccionText().textProperty().bind(personal.direccionProperty());
		view.getLocalidadText().textProperty().bind(personal.localidadProperty());
		Bindings.bindBidirectional(view.getPais().valueProperty(), personal.paisProperty());
		view.getNacionalidadList().itemsProperty().bind(personal.nacionalidadesProperty());
	}

	public void cargarNacionalidades() {
		try {
			bf = new BufferedReader(new FileReader(new File("nacionalidades.csv")));

			while (bf.ready()) {
				Nacionalidad n1 = new Nacionalidad();
				n1.setDenominacion(bf.readLine());
				nacionChoice.add(n1);
			}
		} catch (IOException e) {
		} finally {
			try {
				bf.close();
			} catch (IOException e1) {
			}
		}
	}

	private void onMenosButtonAction() {
		try {
			Nacionalidad nacAux = view.getNacionalidadList().getSelectionModel().getSelectedItem();
			nacionChoice.add(nacAux);
			personal.getNacionalidades().remove(nacAux);
			nacionChoice.sort(nacComp);
		} catch (NullPointerException | NoSuchElementException e) {
			Alert nacionalidadExist = new Alert(AlertType.WARNING);
			nacionalidadExist.setHeaderText(null);
			nacionalidadExist.setTitle("Nada seleccionado");
			nacionalidadExist.setContentText("No hay ninguna nacionalidad seleccionada.");
			nacionalidadExist.showAndWait();
		}
	}

	private void onMasButtonAction() {

		try {

			nacionalidadChoice = new ChoiceDialog<>();
			nacionalidadChoice.setSelectedItem(nacionChoice.get(0));
			nacionalidadChoice.setHeaderText("Añadir Nacionalidad");
			nacionalidadChoice.setContentText("Seleccione una nacionalidad");
			nacionalidadChoice.getItems().addAll(nacionChoice);

			Optional<Nacionalidad> nac = nacionalidadChoice.showAndWait();
			Nacionalidad aux = new Nacionalidad();

			aux.setDenominacion(nac.get().toString());

			if (!comprobarNacionalidad(aux)) {

				Nacionalidad nacionalidad = new Nacionalidad();
				nacionalidad.setDenominacion(nac.get().toString());
				personal.getNacionalidades().add(nacionalidad);

				for (int i = 0; i < nacionChoice.size(); i++) {
					if (nacionChoice.get(i).equals(nac.get())) {
						nacionChoice.remove(i);
					}
				}

			} else {
				Alert nacionalidadExist = new Alert(AlertType.ERROR);
				nacionalidadExist.setHeaderText(null);
				nacionalidadExist.setTitle("Nacionalidad añadida");
				nacionalidadExist.setContentText("Ya se ha añadido esa nacionalidad.");
				nacionalidadExist.showAndWait();
			}

			personal.getNacionalidades().sort(nacComp);

		} catch (NoSuchElementException e) {
		}

	}

	private boolean comprobarNacionalidad(Nacionalidad nacionalidad) {
		boolean exit = false;
		for (Nacionalidad nacAux : personal.getNacionalidades())
			if (nacAux.toString().equals(nacionalidad.toString()))
				exit = true;
			else {
				exit = false;
			}
		return exit;
	}

	private void cargarComboBox() {

		ArrayList<String> paisesArray = new ArrayList<String>();
		ObservableList<String> listaPaises = null;
		BufferedReader bf = null;

		try {
			bf = new BufferedReader(new FileReader(new File("paises.csv")));

			while (bf.ready())
				paisesArray.add(bf.readLine());

			listaPaises = FXCollections.observableArrayList(paisesArray);

		} catch (IOException e) {
		} finally {
			try {
				bf.close();
			} catch (IOException e1) {
			}
		}

		view.getPais().setItems(listaPaises);
	}

	public PersonalView getView() {
		return view;
	}

}
