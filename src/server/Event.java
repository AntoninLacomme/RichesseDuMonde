package server;

import java.util.ArrayList;
import protocole.CallBackUDP;
import protocole.DataUDP;

public class Event {
	private String nameEvent;
	private String descriptionEvent;
	private CallBackUDP fonctionEvent;
	private ArrayList<CallBackUDP> listTempEvents;

	public Event (String name, CallBackUDP fx) {
		this (name, name, fx);
	}
	
	public Event (String name, String description, CallBackUDP fx) {
		this.nameEvent = name;
		this.descriptionEvent = description;
		this.fonctionEvent = fx;
		listTempEvents = new ArrayList<CallBackUDP> ();
	}
	
	public String getNom () { return this.nameEvent; }
	public String getDescription () { return this.descriptionEvent; }
	
	/*
	 * Fonction a appeler pour déclencher l'event
	 */
	public void applyEvent (DataUDP data) {
		this.fonctionEvent.run(data);
		for (CallBackUDP call : this.listTempEvents) {
			call.run(data);
		}
		listTempEvents = new ArrayList<CallBackUDP> ();
	}

	public void addTempCallBack(CallBackUDP fx) {
		this.listTempEvents.add(fx);
	}
}
