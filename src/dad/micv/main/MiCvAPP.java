package dad.micv.main;

import dad.micv.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MiCvAPP extends Application {

	private MainController mainController;
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		mainController = new MainController();

		Scene root = new Scene(mainController.getMainView(), primaryStage.getWidth(), 480);

		this.primaryStage.getIcons().add(new Image("cv64x64.png"));

		this.primaryStage.setScene(root);
		this.primaryStage.setTitle("Mi CV");
		this.primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

}
