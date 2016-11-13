package dad.micv.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Optional;

import dad.micv.model.CV;
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

	private CV cv;
	private PersonalView view;
	private ChoiceDialog<Nacionalidad> nacionalidadChoice;
	private ArrayList<Nacionalidad> nacionChoice;
	private BufferedReader bf;

	public PersonalController(CV cv) {

		this.cv = cv;
		view = new PersonalView();

		view.getMasButton().setOnAction(e -> onMasButtonAction());
		view.getMenosButton().setOnAction(e -> onMenosButtonAction());
		nacionChoice = new ArrayList<Nacionalidad>();

		bind(cv);
		cargarComboBox();
		cargarNacionalidades();

	}

	private void cargarNacionalidades() {
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

	public void bind(CV cv) {
		Bindings.bindBidirectional(view.getNombreText().textProperty(), cv.getPersonal().nombreProperty());
		Bindings.bindBidirectional(view.getDniText().textProperty(), cv.getPersonal().dniProperty());
		Bindings.bindBidirectional(view.getApellidosText().textProperty(), cv.getPersonal().apellidosProperty());
		Bindings.bindBidirectional(view.getFechaNacimiento().valueProperty(),
				cv.getPersonal().fechaNacimientoProperty());
		Bindings.bindBidirectional(view.getCodPostalText().textProperty(), cv.getPersonal().codigoPostalProperty());
		Bindings.bindBidirectional(view.getDireccionText().textProperty(), cv.getPersonal().direccionProperty());
		Bindings.bindBidirectional(view.getLocalidadText().textProperty(), cv.getPersonal().localidadProperty());
		Bindings.bindBidirectional(view.getPais().valueProperty(), cv.getPersonal().paisProperty());
		Bindings.bindBidirectional(view.getNacionalidadList().itemsProperty(),
				cv.getPersonal().nacionalidadesProperty());
	}

	private void onMenosButtonAction() {
		try {
			Nacionalidad nacAux = view.getNacionalidadList().getSelectionModel().getSelectedItem();
			nacionChoice.add(nacAux);
			// nacionChoice.sort(String::compareToIgnoreCase);
			cv.getPersonal().getNacionalidades().remove(nacAux);
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
		for (Nacionalidad nacAux : cv.getPersonal().getNacionalidades())
			if (nacAux.toString().equals(nacionalidad.toString()))
				exit = true;
		return exit;
	}

	private void onMasButtonAction() {

		actualizarComboBox();
		try {

			nacionalidadChoice = new ChoiceDialog<>();
			nacionalidadChoice.setSelectedItem(nacionChoice.get(0));
			nacionalidadChoice.setHeaderText("A�adir Nacionalidad");
			nacionalidadChoice.setContentText("Seleccione una nacionalidad");
			nacionalidadChoice.getItems().addAll(nacionChoice);

			Optional<Nacionalidad> nac = nacionalidadChoice.showAndWait();
			Nacionalidad aux = new Nacionalidad();
			aux.setDenominacion(nac.get().toString());

			if (!comprobarNacionalidad(aux)) {

				Nacionalidad nacionalidad = new Nacionalidad();
				nacionalidad.setDenominacion(nac.get().toString());
				cv.getPersonal().getNacionalidades().add(nacionalidad);

				// actualizarComboBox();

				for (int i = 0; i < nacionChoice.size(); i++) {
					if (nacionChoice.get(i).equals(nac.get())) {
						nacionChoice.remove(i);
					}
				}

			} else {
				Alert nacionalidadExist = new Alert(AlertType.ERROR);
				nacionalidadExist.setHeaderText(null);
				nacionalidadExist.setTitle("Nacionalidad a�adida");
				nacionalidadExist.setContentText("Ya se ha a�adido esa nacionalidad.");
				nacionalidadExist.showAndWait();
			}

		} catch (NoSuchElementException e) {
		}

	}

	private void actualizarComboBox() {
		try {
			for (Nacionalidad nac : cv.getPersonal().getNacionalidades()) {
				System.out.println("Estamos buscando " + nac);
				for (Nacionalidad nacBox : nacionChoice) {
					System.out.println("Comparamos " + nac + " con " + nacBox);
					if (nac.toString() == nacBox.toString()) {
						System.out.println("EUREKA " + nac + " coincide con " + nacBox);
						nacionChoice.remove(nacBox);
					}
				}
			}
		} catch (ConcurrentModificationException e) {

		}
		// nacionalidadChoice.getItems().addAll(nacionChoice);
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
		return cv.getPersonal();
	}

}
