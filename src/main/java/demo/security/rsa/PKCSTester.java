package demo.security.rsa;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;

public class PKCSTester {

	public static void main(String[] args) throws Exception {
	    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

	    byte[] input = "abc".getBytes();
//	    PKCS1Padding
	    Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", "BC");
	    SecureRandom random = new SecureRandom();
	    KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");

	    int keysize = 256;
		generator.initialize(keysize, random);

	    KeyPair pair = generator.generateKeyPair();
	    Key pubKey = pair.getPublic();
	    Key privKey = pair.getPrivate();

	    cipher.init(Cipher.ENCRYPT_MODE, pubKey, random);
	    byte[] cipherText = cipher.doFinal(input);
	    System.out.println("cipher: " + new String(cipherText));

	    cipher.init(Cipher.DECRYPT_MODE, privKey);
	    byte[] plainText = cipher.doFinal(cipherText);
	    System.out.println("plain : " + new String(plainText));
	  }
}
