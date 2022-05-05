package itts_multiThreaded;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{
	
	private final Socket socket; 
	
	public ClientHandler(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		Scanner sc = null; 
		DataOutputStream dos = null;
		try {
			sc=new Scanner(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream()); 
			String risposta;
			
			while((risposta=sc.nextLine())!= null) {
				System.out.println("Dal client: " + risposta);
				dos.writeBytes(risposta);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
            try {
                if (dos != null) {
                    dos.close();
                }
                if (sc != null) {
                    sc.close();
                    socket.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
	
