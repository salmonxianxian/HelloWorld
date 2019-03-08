package java16_thread.chat1on1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Receiver_1on1 extends Thread{
	
	// 통신소켓 변수
	private Socket sock;
	
	// 소켓입력 변수
	private BufferedReader reader;
	
	// 모니터 출력 변수
	private PrintWriter writer;
	
	public Receiver_1on1(Socket sock) {
		this.sock = sock;
	}

	@Override
	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			writer = new PrintWriter(System.out,true);
			
			String str;
			while(true) {
				str = reader.readLine();
				if(str == null) {
					System.out.println("상대방 접속 종료");
					
					break;
				}
				System.out.print("받은 메시지 : ");
				writer.println(str);
				
			}
		} catch (IOException e) {
//			System.out.println("상대방이 접속을 종료했습니다.");
		} finally {
			try {
				if(reader!=null)	reader.close();
				if(writer!=null)writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
