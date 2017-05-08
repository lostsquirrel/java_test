package demo.net;

public class MyChat
{

	public static void main(String[] args)
	{
//		DatagramSocket send = null;
//		DatagramSocket receive = null;
//		try
//		{
//			send = new DatagramSocket();
//			receive = new DatagramSocket(10086);
//		}
//		catch (SocketException e)
//		{
//			e.printStackTrace();
//		}
		new Thread(new MyReceive()).start();
		new Thread(new MySend()).start();
	}
}
