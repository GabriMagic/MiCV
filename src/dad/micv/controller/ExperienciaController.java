package dad.micv.controller;

import dad.micv.model.Experiencia;
import dad.micv.view.ExperienciaView;

public class ExperienciaController {

	Experiencia experiencia;
	ExperienciaView view;

	public ExperienciaController() {

		experiencia = new Experiencia();
		view = new ExperienciaView();
	}

	public ExperienciaView getView() {
		return view;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}
}
