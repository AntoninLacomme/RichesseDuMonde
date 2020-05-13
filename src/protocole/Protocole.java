package protocole;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.ServerSocket;

public class Protocole {
	synchronized static public int[] getAvailablePort(int nb) {
		ServerSocket[] s = new ServerSocket[nb];
		int[] port = new int[nb];

		for (int i=0; i<nb; i++) {
			try {
				s[i] = new ServerSocket(0);
				port[i] = s[i].getLocalPort();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i=0; i<nb; i++) {
			try {
				s[i].close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		return port;
	}

}
