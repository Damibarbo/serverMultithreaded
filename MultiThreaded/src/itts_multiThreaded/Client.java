package itts_multiThreaded;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;



public class Client {
	Socket socket;
	InetAddress ip; 
	int porta; 
	
	public Client(InetAddress ip, int porta) {
		this.ip=ip;
		this.porta=porta; 
	}
	
	
	
	public void connessione() {
		try {
			socket= new Socket(ip, porta);
			System.out.println("Client avviato con successo"); 
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void chiusura() {
		try {
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void chat() {
		Scanner in=null;
		DataOutputStream dos=null;
		try {
			in = new Scanner(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			Scanner sc = new Scanner(System.in);
            String line = null;
            
            while(!"exit".equalsIgnoreCase(line)) {
            	System.out.println("inserisci");
            	line = sc.nextLine();
            	line +="\n";
            	  
                // sending the user input to server
                dos.writeBytes(line);
                dos.flush();
  
                // displaying server reply
                System.out.println("Server replied "+ in.nextLine());
            	
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	/*public void leggi() {
		Scanner sc;
		try {
			sc=new Scanner(socket.getInputStream());
			String risposta=sc.nextLine(); 
			risposta +="\n"; 
			System.out.println("Client: " + risposta); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	} */

	/*public void scrivi() {
	try {
		  
		Scanner in=new Scanner(System.in); 
		
		System.out.println("inserisci il messaggio da mandare al client");
		String messaggio=in.nextLine(); 
		messaggio += "\n";
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
		dos.writeBytes(messaggio);
		
		
	}  catch (IOException e) {
		e.printStackTrace();
	} 

	} */


}