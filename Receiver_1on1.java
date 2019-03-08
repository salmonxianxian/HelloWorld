package java16_thread.chat1on1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Receiver_1on1 extends Thread{
	
	// ��ż��� ����
	private Socket sock;
	
	// �����Է� ����
	private BufferedReader reader;
	
	// ����� ��� ����
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
					System.out.println("���� ���� ����");
					
					break;
				}
				System.out.print("���� �޽��� : ");
				writer.println(str);
				
			}
		} catch (IOException e) {
//			System.out.println("������ ������ �����߽��ϴ�.");
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
