
package demo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocketClient {

	public static void main(String[] args) {
		
		try 
		(
				Socket socket = new Socket(SocketConfig.HOST, SocketConfig.PORT);
				BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
				BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter os=new PrintWriter(socket.getOutputStream());
		)
		{
			String readline;
			readline=sin.readLine(); //从系统标准输入读入一字符串
			os.println(readline);
			os.flush();
			System.out.println(is.readLine());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
