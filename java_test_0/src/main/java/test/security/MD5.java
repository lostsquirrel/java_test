package test.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	public static String md5sum(String source, String charsetName) {
		String result = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(source.getBytes(charsetName));
			byte[] bytes = messageDigest.digest();
			System.out.println(bytes.length);
			StringBuilder sb = new StringBuilder();
			for (byte b : bytes) {
				String hs = Integer.toHexString(b & 0xFF);
				if (hs.length() == 1) {
					sb.append("0");
				}
				sb.append(hs);
			}
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String md5sum(String source) {
		return md5sum(source, "UTF-8");
	}
	
	public static void main(String[] args) {
		String source = "";
		String sign = MD5.md5sum(source);
		System.out.println(sign);
		System.out.println(sign.length());
	}
}
