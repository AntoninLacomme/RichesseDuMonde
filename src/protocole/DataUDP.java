package protocole;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class DataUDP {
	private InetAddress ip;
	private int port;
	private String message;
	private String commande;
	private ArrayList<String[]> data = new ArrayList<String[]> ();
	//private HashMap<String, String> data = new HashMap<String, String> ();

	public DataUDP (byte[] packet) {
		message = new String (packet);
		data = new ArrayList<String[]> ();
		if (message.indexOf("{") >= 0) {
			this.commande = message.substring(0, message.indexOf("{"));
		}
		else {
			this.commande = message;
		}
	}
	
	public DataUDP (String message) {
		data = new ArrayList<String[]> ();
		if (message.indexOf("{") >= 0) {
			this.commande = message.substring(0, message.indexOf("{"));
		}
		else {
			this.commande = message;
		}
	}
	
	public DataUDP(DatagramPacket packet) {
		this (packet.getData());
		this.ip = packet.getAddress();
		this.port = packet.getPort();
	}

	public String getCommande ( ) { return this.commande; }
	
	public String getNameCommand() {
		return this.commande;
	}
	
	public ArrayList<String[]> getData () { return this.data; }
	public ArrayList<String> getKeysData () {
		ArrayList<String> keys = new ArrayList<String> ();
		for (String[] tuple: this.data) {
			keys.add(tuple[0]);
		}
		return keys;
	}
	public ArrayList<String> getValuesData () {
		ArrayList<String> values = new ArrayList<String> ();
		for (String[] tuple: this.data) {
			values.add(tuple[1]);
		}
		return values;
	}
	public int getPort () { return this.port; }
	public InetAddress getIp () { return this.ip; }
	
	public void addData (String value) {
		this.addData("" + data.size(), value);
	}
	
	public void addData (String key, String value) {
		String[] tuple = new String[2];
		tuple[0] = key;
		tuple[1] = value;
		this.data.add(tuple);
	}

	public void convertMessageToData() {
		this.data = new ArrayList<String[]> ();
		
    	if (!message.contains("{;}")) {
			message = message.substring(message.indexOf("{") + 1);    		
    		
    		String[] datas = new String[message.length() - (message.replace(";", "").length())];
    		int acc=0;
    		while (message.indexOf(";") >= 0) {
    			datas[acc] = message.substring(0, (message.indexOf(";")));
    			message = message.substring(message.indexOf(";") + 1);
    			acc++;    			
    		}
    		
    		for (String val : datas) {
    			String tmp = val;
    			String key = tmp.substring(tmp.indexOf("<") +1, tmp.indexOf(">"));
    			tmp = tmp.substring(tmp.indexOf(">") + 1);
    			String value = tmp.substring(tmp.indexOf("<") +1, tmp.indexOf(">"));
    			this.addData(key, value);
    		}
    	}
	}
	
	public String convertDataToMessage () {
		String message = "{";
		if (data.size() > 0) {
			for (String o : this.getKeysData()) {
				message += "<" + o + "><" + this.getValue(o) + ">";
				message += ";";
			}
		}
		else {
			message += ";";
		}
		message += "}";
		return message;
	}

	public String getValue(String o) {
		for (String[] tuple : this.data) {
			try {
				if (tuple[0].equals(o)) {
					return tuple[1];
				}
			}
			catch (Exception e) {
				System.out.println(e.toString());
				System.out.println(o);
				System.out.println(tuple[0]);
				return null;
			}
		}
		return null;
	}

	public byte[] getBytes() {
		return (this.commande + this.convertDataToMessage()).getBytes();
	}
}
