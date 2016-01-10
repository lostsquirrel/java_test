package test.lang;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class EncodingTest {
	public static void main(String ...args) throws UnsupportedEncodingException, FileNotFoundException {
		String a = "zhangshan";
		print(a);
	
		String b = new String("zhangshan".getBytes(), "iso-8859-1");
		print(b);
		
		String c = "张三";
		print(c);
		
		String d = new String("张三".getBytes(), "iso-8859-1");
		print(d);
		RandomAccessFile f = new RandomAccessFile("", "");
		
	}
	
	public static void print(String x) {
		System.out.println(Arrays.toString(x.getBytes()));
		System.out.println(x.getBytes().length);
	}
}


