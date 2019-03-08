package java16_thread.chat1on1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_1on1 {
	
	
	public Server_1on1() {
		ServerSocket server = null;
		Socket sock = null;
		
		try {
			System.out.println(" = = ���� ���� = =");
			server = new ServerSocket(1194);
			System.out.println("--- Ŭ���̾�Ʈ ����� ---");
			sock = server.accept();

			InetAddress ip = sock.getInetAddress();
			System.out.println(">> " + ip.getHostAddress()+"����");
			
			chat(sock);
			
		} catch (IOException e) {
			System.out.println("�������� ���� ����!!");
		}
	}
	
	public void chat(Socket sock) {
		new Sender_1on1(sock).start();
		new Receiver_1on1(sock).start();
	}
	
	public static void main(String[] args) {
		new Server_1on1();
	}
}
