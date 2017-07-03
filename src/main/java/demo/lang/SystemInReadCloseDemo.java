package demo.lang;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemInReadCloseDemo {
	
	private static final Logger log = LoggerFactory.getLogger(SystemInReadCloseDemo.class);
	
	public static void main(String[] args) throws Exception {
		final InputStream in = System.in;
		new Thread() {
			public void run() {
				log.debug("读取开始。。。");
				try {
					in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		int timeout = 1;
		TimeUnit.SECONDS.sleep(timeout);
		log.debug("睡了{}秒", timeout);
		new Thread() {
			public void run() {
				log.debug("关闭开始。。。");
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		
	}
}
