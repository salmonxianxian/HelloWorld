package java16_thread.chat1on1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_1on1 {

	public Client_1on1() {
		Socket sock = null;
		
		try {
			System.out.println("+ + 클라이언트 실행 + +");
			sock = new Socket("localhost",1194);
			
			System.out.println("서버 접속 성공 !");
			
			chat(sock);
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다");

		} catch (IOException e) {
			System.out.println("입출력 실패");

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
