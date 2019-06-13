// Exercise31_01Server.java: The server can communicate with
// multiple clients concurrently using the multiple threads
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise31_01Server extends Application {
	// Text area for displaying contents
	private TextArea ta = new TextArea();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		ta.setWrapText(true);

		// Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(ta), 400, 200);
		primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread( () -> {
			try {
				// Create a server socket
				ServerSocket serverSocket = new ServerSocket(8000);
				Platform.runLater(() ->
				ta.appendText("Server started at " + new Date() + '\n'));

				// Listen for a connection request
				Socket socket = serverSocket.accept();

				// Create data input and output streams
				DataInputStream inputFromClient = new DataInputStream(
						socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(
						socket.getOutputStream());

				while (true) {
					// Receive info from the client
					double annualInterestRate = inputFromClient.readDouble();
					int numberOfYears = inputFromClient.readInt();
					double loanAmount = inputFromClient.readDouble();

					// make a loan
					Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
					double monthlyPayment = loan.getMonthlyPayment();
					double totalPayment = loan.getTotalPayment();

					// Send  back to the client
					outputToClient.writeDouble(monthlyPayment);
					outputToClient.writeDouble(totalPayment);

					Platform.runLater(() -> {
						ta.appendText("\nInterest Rate: " + annualInterestRate);
						ta.appendText("\nNum of Years: " + numberOfYears);
						ta.appendText("\nLoan Amount: " + loanAmount);
						ta.appendText("\nMonthly Payment: " + monthlyPayment);
						ta.appendText("\nTotal Payment: " + totalPayment);
						
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
