package test.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class MySend implements Runnable
{
	private DatagramSocket ds;

	public MySend()
	{
		try {
			this.ds = new DatagramSocket(10086);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{
		try
		{
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			String line = null;
//			while ((line = br.readLine()) != null)
//			{
//				DatagramPacket dp = null;
//				byte[] buf = null;
//				buf = line.getBytes();
//				dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 8989);
//				ds.send(dp);
//				System.out.println(ds.isConnected());
//				if (line.trim().equals("bye"))
//				{
////					dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("Shen-PC"), 1234);
//					break;
//				}
////				ds.close();
//			}
//			br.close();
			int x = 10;
			while (x > 0) {
				x--;
				byte[] buf = new Integer(x).toString().getBytes();
				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 10086);
				ds.send(dp);
				
				System.out.println(Thread.currentThread().getName() + " send at " + new Date()); 
				Thread.sleep(1000);
				
			}
			ds.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException("发送端失败！！！");
		}
	}
}
