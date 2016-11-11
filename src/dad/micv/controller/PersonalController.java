package dad.micv.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
	private ChoiceDialog<String> nacionalidadChoice;
	private ArrayList<String> nacionChoice;

	public PersonalController() {

		view = new PersonalView();

		personal = new Personal();

		view.getMasButton().setOnAction(e -> onMasButtonAction());
		view.getMenosButton().setOnAction(e -> onMenosButtonAction());

		bind(personal);
		cargarComboBox();

		BufferedReader bf = null;
		nacionChoice = new ArrayList<String>();

		try {
			bf = new BufferedReader(new FileReader(new File("nacionalidades.csv")));

			while (bf.ready())
				nacionChoice.add(bf.readLine());

		} catch (IOException e) {
		} finally {
			try {
				bf.close();
			} catch (IOException e1) {
			}
		}
	}

	private void bind(Personal personal) {
		Bindings.bindBidirectional(view.getDniText().textProperty(), personal.dniProperty());
		Bindings.bindBidirectional(view.getNombreText().textProperty(), personal.nombreProperty());
		Bindings.bindBidirectional(view.getApellidosText().textProperty(), personal.apellidosProperty());
		Bindings.bindBidirectional(view.getFechaNacimiento().valueProperty(), personal.fechaNacimientoProperty());
		Bindings.bindBidirectional(view.getCodPostalText().textProperty(), personal.codigoPostalProperty());
		Bindings.bindBidirectional(view.getLocalidadText().textProperty(), personal.localidadProperty());
		Bindings.bindBidirectional(view.getPais().valueProperty(), personal.paisProperty());
		Bindings.bindBidirectional(view.getNacionalidadList().itemsProperty(), personal.nacionalidadesProperty());
	}

	private void onMenosButtonAction() {
		try {
			Nacionalidad nacAux = view.getNacionalidadList().getSelectionModel().getSelectedItem();
			nacionChoice.add(nacAux.getDenominacion());
			nacionChoice.sort(String::compareToIgnoreCase);
			personal.getNacionalidades().remove(nacAux);
		} catch (NullPointerException e) {
			Alert nacionalidadExist = new Alert(AlertType.WARNING);
			nacionalidadExist.setHeaderText(null);
			nacionalidadExist.setTitle("Nada seleccionado");
			nacionalidadExist.setContentText("No hay ninguna nacionalidad seleccionada.");
			nacionalidadExist.showAndWait();
		}
	}

	private boolean comprobarNacionalidad(Nacionalidad nacionalidad) {
		boolean exit = false;
		for (Nacionalidad nacAux : personal.getNacionalidades())
			if (nacAux.toString().equals(nacionalidad.toString()))
				exit = true;
		return exit;
	}

	private void onMasButtonAction() {

		try {

			nacionalidadChoice = new ChoiceDialog<>();
			nacionalidadChoice.setSelectedItem(nacionChoice.get(0));
			nacionalidadChoice.setHeaderText("Añadir Nacionalidad");
			nacionalidadChoice.setContentText("Seleccione una nacionalidad");
			nacionalidadChoice.getItems().addAll(nacionChoice);

			Optional<String> nac = nacionalidadChoice.showAndWait();
			Nacionalidad aux = new Nacionalidad();
			aux.setDenominacion(nac.get());

			if (!comprobarNacionalidad(aux)) {

				Nacionalidad nacionalidad = new Nacionalidad();
				nacionalidad.setDenominacion(nac.get());
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

		} catch (NoSuchElementException e) {
		}

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

	public Personal getPersonal() {
		return personal;
	}

}
