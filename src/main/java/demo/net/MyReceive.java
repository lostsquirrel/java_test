package demo.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class MyReceive implements Runnable
{
	private DatagramSocket ds;

	public MyReceive()
	{
		try {
			this.ds = new DatagramSocket();
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
			while(true)
			{
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(),0,dp.getLength());
				int port = dp.getPort();
				System.out.println(ip + "::" + data + "::" + port);
				System.out.println(Thread.currentThread().getName() + " recived at " + new Date());
//				if(data.equals("bye"))
//					break;
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("接收端失败！！！");
		}
	}
}
