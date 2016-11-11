package dad.micv.controller;

import dad.micv.view.ConocimientoView;

public class ConocimientosController {
	ConocimientoView view;

	public ConocimientosController() {
		view = new ConocimientoView();
	}

	public ConocimientoView getView() {
		return view;
	}
}