package test.gui.gui.event;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Client extends JFrame
{
	private static final long serialVersionUID = 3867566778878405116L;
	JScrollPane jspTop = new JScrollPane();
	JScrollPane jspBot = new JScrollPane();
	JTextArea jtaTop = new JTextArea();
	JTextArea jtaBot = new JTextArea();
	JButton btn = new JButton("����");
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd  HH:mm:ss");
	BufferedWriter bw;
	/**
	 * ���췽��
	 */
	public Client()
	{
		initComponent();

		this.setTitle("Client");
		this.setSize(510, 380);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		initListener();
		initSocket();
	}

	/**
	 * ��ʼ�����
	 */
	private void initComponent()
	{

		// ���������岼��Ϊ��ʽ����
		this.setLayout(new FlowLayout());
		// ����JTextArea�ı��򲻿ɱ༭
		jtaTop.setEditable(false);
		// ����jspTop��jspBot�������Ĵ�С���߿�
		jspTop.setPreferredSize(new Dimension(480, 150));
		jspTop.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Server"));
		jspTop.getViewport().add(jtaTop);// ����ϲ��ı���
		jspBot.setPreferredSize(new Dimension(480, 150));
		jspBot.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Client"));
		jspBot.getViewport().add(jtaBot);// ����²��ı���

		this.add(jspTop);
		this.add(jspBot);
		this.add(btn);
	}
	
	/**
	 * ��ʼ��������
	 */
	private void initListener()
	{
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String line = jtaBot.getText();
				String time = sdf.format(new Date());
				jtaTop.append(time + " Client˵��\n");
				jtaTop.append(line + "\n");
				try
				{
					bw.write(time + " Client˵��");
					bw.newLine();
					bw.write(line);
					bw.newLine();
					bw.flush();
					jtaBot.setText("");
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * ��ʼ��Socket
	 */
	private void initSocket()
	{
		try
		{
			Socket client = new Socket("192.168.19.100", 6666);
			new Receive(client).start();
//			new Send(client).start();
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		new Client();
	}

	/**
	 * ���շ�������Ϣ���߳�
	 * 
	 * @author Administrator
	 *
	 */
	class Receive extends Thread
	{
		Socket s;

		public Receive(Socket s)
		{
			this.s = s;
		}

		@Override
		public void run()
		{
			try (BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())))
			{
				String line;
				while ((line = br.readLine()) != null)
				{
					jtaTop.append(line + "\n");
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}
	}

	/**
	 * �������������Ϣ���߳�
	 * 
	 * @author Administrator
	 *
	 */
//	class Send extends Thread
//	{
//		Socket s;
//
//		public Send(Socket s)
//		{
//			this.s = s;
//		}
//
//		@Override
//		public void run()
//		{
//			try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream())))
//			{
//				String line;
//				String time;
//				while ((line = br.readLine()) != null)
//				{
//					time = sdf.format(new Date());
//					jtaTop.append(time + " Client˵��\n");
//					jtaTop.append(line + "\n");
//					bw.write(time + " Client˵��");
//					bw.newLine();
//					bw.write(line);
//					bw.newLine();
//					bw.flush();
//				}
//			}
//			catch (IOException e)
//			{
//				e.printStackTrace();
//			}
//
//		}
//	}

}
