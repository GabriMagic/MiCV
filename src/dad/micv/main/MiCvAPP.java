package dad.micv.main;


import dad.micv.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MiCvAPP extends Application {

	MainController mainController;

	@Override
	public void start(Stage primaryStage) throws Exception {

		mainController = new MainController();

		Scene root = new Scene(mainController.getMainView(), primaryStage.getWidth(), 480);

		primaryStage.getIcons().add(new Image("cv64x64.png"));

		primaryStage.setScene(root);
		primaryStage.setTitle("Mi CV");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
