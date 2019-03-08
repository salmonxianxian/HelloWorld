package java16_thread.chat1on1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_1on1 {

	public Client_1on1() {
		Socket sock = null;
		
		try {
			System.out.println("+ + Ŭ���̾�Ʈ ���� + +");
			sock = new Socket("localhost",1194);
			
			System.out.println("���� ���� ���� !");
			
			chat(sock);
		} catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�");

		} catch (IOException e) {
			System.out.println("����� ����");

		}
	}
	
	public void chat(Socket sock) {
		new Sender_1on1(sock).start();
		new Receiver_1on1(sock).start();
	}
	
	public static void main(String[] args) {
		
		new Client_1on1();
		System.out.println();
	}
}
