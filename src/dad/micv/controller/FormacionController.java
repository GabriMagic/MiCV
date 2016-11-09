package dad.micv.controller;

import dad.micv.view.FormacionView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FormacionController {

	private FormacionView view;
	private FormacionADDController controller;
	private Stage formacionAdd;
	private Scene formScene;

	public FormacionController() {
		view = new FormacionView();
		controller = new FormacionADDController();

		formScene = new Scene(controller.getView());
		formacionAdd = new Stage();
		formacionAdd.setScene(formScene);

		view.getAñadirButton().setOnAction(e -> onAddButtonAction(e));
	}

	private void onAddButtonAction(ActionEvent e) {

		formacionAdd.show();
	}

	public FormacionView getView() {
		return view;
	}
}
