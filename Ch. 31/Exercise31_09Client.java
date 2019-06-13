import javafx.application.Application;
import javafx.application.Platform;
import static javafx.application.Application.launch;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise31_09Client extends Application {
	//Text Areas
	private TextArea taHistory = new TextArea();
	private TextArea taMessage = new TextArea();
	
	//IO streams
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		taHistory.setWrapText(true);
		taMessage.setWrapText(true);
		taHistory.setDisable(true);

		BorderPane pane1 = new BorderPane();
		pane1.setTop(new Label("History"));
		pane1.setCenter(new ScrollPane(taHistory));
		BorderPane pane2 = new BorderPane();
		pane2.setTop(new Label("New Message"));
		pane2.setCenter(new ScrollPane(taMessage));

		VBox vBox = new VBox(5);
		vBox.getChildren().addAll(pane1, pane2);

		// Create a scene and place it in the stage
		Scene scene = new Scene(vBox, 200, 200);
		primaryStage.setTitle("Exercise31_09Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		//send messages when ENTER is pressed
		taMessage.setOnKeyPressed(e -> { 
			if(e.getCode() == KeyCode.ENTER) {
				try {
					String message = taMessage.getText();
					toServer.writeUTF(message);
					taMessage.clear();
					Platform.runLater(() -> {
						taHistory.appendText("C: " + message); //TODO: Write to History
					});
				}
				catch (IOException ex) {
					System.err.println(ex);
				}
			}
		});
		
		//listen for messages (server side also sets up some things)
		new Thread( () -> {
			try {
				// Create a socket to connect to the server
				Socket socket = new Socket("localhost", 8000);
				
				// Create an input & output stream to receive data from the server
				fromServer = new DataInputStream(socket.getInputStream());
				toServer = new DataOutputStream(socket.getOutputStream());
				
				//receive messages
				while (true) {
					String message = fromServer.readUTF();

					Platform.runLater(() -> {
						taHistory.appendText("S: " + message + "\n");
						taMessage.clear();
					});
				}
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}).start();
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
