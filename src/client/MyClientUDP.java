package client;

import java.io.IOException;

import client.controllers.ControllerMainPlateau;
import game.Plateau;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import protocole.CallBackUDP;
import protocole.DataUDP;

public class MyClientUDP extends ClientUDP {
	private ControllerMainPlateau ctrlMain;

	public MyClientUDP(String name, String ipConnect, int portDefault, int myportEnvoi, int myportReception) {
		super(name, ipConnect, portDefault, myportEnvoi, myportReception);
		
		this.setEventListener("ANSWER_EMPTY_PLATEAU", new CallBackUDP () {
			@Override
			public void run (DataUDP data) {
				answerEmptyPlateau(data);
			}
		});		

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.getFullPlateau();
	}
	
	public void getFullPlateau () {
		this.sendPacket(new DataUDP("GET_EMPTY_PLATEAU"));
	}	
	
	protected void answerEmptyPlateau(DataUDP data) {
		Plateau p = new Plateau(data);
		ctrlMain.drawPlateau(p);
	}
	
	public void setControllerMainPlateau (ControllerMainPlateau ctrl) {
		this.ctrlMain = ctrl;
	}

	public void sendEventDeconnected() {
		DataUDP data = new DataUDP("DECONNECTION");
		data.addData("port", "" + this.portReception);
		this.sendPacket(data);
	}

}
