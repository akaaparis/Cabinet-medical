import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Design");

		try {
			FXMLLoader loader = new FXMLLoader(
					Main.class
							.getResource("/DesignView/ConsultAppointment.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page, 791, 800);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}