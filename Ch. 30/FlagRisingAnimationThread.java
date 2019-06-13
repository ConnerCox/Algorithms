import javafx.animation.PathTransition; 
import javafx.application.Application; 
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimationThread extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Add an image view and add it to pane
		ImageView imageView = new ImageView("us.gif");
		pane.getChildren().add(imageView);
		imageView.setY(200);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 200); 
		primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread(()-> {
			try {
				while(true) {
					Platform.runLater(()->imageView.setY(imageView.getY()-1));
					Thread.sleep(50);
				}
			} 
			catch (InterruptedException e) {

			}
		}).start();
	}
}
