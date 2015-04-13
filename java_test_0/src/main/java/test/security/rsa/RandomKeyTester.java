package test.security.rsa;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;

public class RandomKeyTester {

	public static void main(String[] args) throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		byte[] input = "aa".getBytes();
		Cipher cipher = Cipher.getInstance("RSA/None/NoPadding", "BC");
		// the source of randomness.
//		This class provides a cryptographically strong random number generator (RNG). 
		SecureRandom random = new SecureRandom(); 

		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");
		// the keysize. This is an algorithm-specific metric, 
		//such as modulus length, specified in number of bits.
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
