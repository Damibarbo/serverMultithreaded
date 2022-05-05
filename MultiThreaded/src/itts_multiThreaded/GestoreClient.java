package itts_multiThreaded;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GestoreClient {
	
public static void main(String[] args) {
	
		
		Client cl;
		try {
			cl = new Client(InetAddress.getLocalHost(),2000);
			cl.connessione();
			cl.chat();
			//cl.chiusura();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		
}

}
