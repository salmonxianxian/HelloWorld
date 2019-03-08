package java16_thread.chat1on1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender_1on1 extends Thread{

	// 통신소켓 변수
	private Socket sock;
	
	// 키보드입력 변수
	private BufferedReader reader;
	
	// 소켓출력 변수
	private PrintWriter writer;
	
	public Sender_1on1(Socket sock) {
		this.sock = sock;
	}
	
	@Override
	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(sock.getOutputStream(),true);

			String str;

			while((str = reader.readLine())!=null) {
				
				if(str.equals("/EXIT")) break;
					writer.println(str);
	
			}

		} catch (IOException e) {
			System.out.println("통신 종료");
		} finally {
			try {
				if(reader!=null)	reader.close();
				if(writer!=null)	writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
