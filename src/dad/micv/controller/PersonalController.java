package dad.micv.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import dad.micv.model.Personal;
import dad.micv.view.PersonalView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Alert.AlertType;

public class PersonalController {

	private Personal personal;
	
	private PersonalView view;
	private ChoiceDialog<String> nacionalidadChoice;
	private ObservableList<String> listaNacionalidades;

	public PersonalController() {

		view = new PersonalView();
		listaNacionalidades = FXCollections.observableArrayList();

		personal = new Personal();
		
		view.getMasButton().setOnAction(e -> onMasButtonAction());
		view.getMenosButton().setOnAction(e -> onMenosButtonAction());

		bind(personal);
		cargarComboBox();
	}
	
	private void bind(Personal personal) {
		personal.dniProperty().bind(view.getDniText().textProperty());
		personal.nombreProperty().bind(view.getNombreText().textProperty());
		personal.apellidosProperty().bind(view.getApellidosText().textProperty());
		personal.fechaNacimientoProperty().bind(view.getFechaNacimiento().valueProperty());
		personal.codigoPostalProperty().bind(view.getCodPostalText().textProperty());
		personal.localidadProperty().bind(view.getLocalidadText().textProperty());
		personal.paisProperty().bind(view.getPaises().valueProperty());
		// Bindear una ListProperty
//		personal.nacionalidadesProperty().bind(view.getNacionalidadText());
	}

	private void onMenosButtonAction() {

	}

	private boolean comprobarNacionalidad(String nacionalidad) {

		boolean exit = false;

		for (int i = 0; i < listaNacionalidades.size(); i++) {
			if (listaNacionalidades.get(i).equals(nacionalidad)) {
				return true;
			} else {
				exit = false;
			}
		}
		return exit;

	}

	private void onMasButtonAction() {

		BufferedReader bf = null;
		ArrayList<String> nacionChoice = new ArrayList<String>();

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

		try {

			nacionalidadChoice = new ChoiceDialog<>();
			nacionalidadChoice.setHeaderText("Añadir Nacionalidad");
			nacionalidadChoice.setContentText("Seleccione una nacionalidad");
			nacionalidadChoice.getItems().addAll(nacionChoice);

			Optional<String> nac = nacionalidadChoice.showAndWait();
			if (!comprobarNacionalidad(nac.get())) {
				listaNacionalidades.add(listaNacionalidades.size(), nac.get());
			} else {
				Alert nacionalidadExist = new Alert(AlertType.ERROR);
				nacionalidadExist.setHeaderText(null);
				nacionalidadExist.setTitle("Nacionalidad añadida");
				nacionalidadExist.setContentText("Ya se ha añadido esa nacionalidad.");
				nacionalidadExist.showAndWait();
				onMasButtonAction();
			}

		} catch (NoSuchElementException e) {
			Alert errorNacionalidad = new Alert(AlertType.ERROR);
			errorNacionalidad.setHeaderText("Eliga una nacionalidad válida");
			errorNacionalidad.setTitle("Error de nacionalidad");
			errorNacionalidad.setContentText("La nacionalidad que ha seleccionado no es correcta");
			errorNacionalidad.showAndWait();
			onMasButtonAction();
		}

		view.getNacionalidadText().setItems(listaNacionalidades);
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

		view.getPaises().setItems(listaPaises);
	}

	public PersonalView getView() {
		return view;
	}

}
