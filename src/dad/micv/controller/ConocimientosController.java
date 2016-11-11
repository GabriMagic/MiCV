package dad.micv.controller;

import dad.micv.model.Conocimiento;
import dad.micv.view.ConocimientoView;

public class ConocimientosController {

	private Conocimiento conocimiento;
	private ConocimientoView view;

	public ConocimientosController() {

		conocimiento = new Conocimiento();

		view = new ConocimientoView();
	}

	public ConocimientoView getView() {
		return view;
	}

	public Conocimiento getConocimiento() {
		return conocimiento;
	}
}