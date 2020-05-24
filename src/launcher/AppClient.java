package launcher;
import client.Client;
import javafx.application.Application;

public class AppClient {
	public static void main (String[] args) {
		Application.launch(Client.class, new String[0]);
	}
}
