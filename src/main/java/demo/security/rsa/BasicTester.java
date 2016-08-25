package demo.security.rsa;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;

public class BasicTester {

	public static void main(String[] args) throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		byte[] input = new byte[] { (byte) 0xbe, (byte) 0xef };
		String transformation = "RSA/None/NoPadding";
		String provider  = "BC"; 
		Cipher cipher = Cipher.getInstance(transformation, provider);

		KeyFactory keyFactory = KeyFactory.getInstance("RSA", provider);
		BigInteger modulus = new BigInteger("12345678", 16);
		BigInteger publicExponent = new BigInteger("11", 16);
		BigInteger privateExponent = new BigInteger("12345678", 16);
//		Creates a new RSAPublicKeySpec
		RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(modulus, publicExponent);
//		Creates a new RSAPrivateKeySpec.
		RSAPrivateKeySpec privKeySpec = new RSAPrivateKeySpec(modulus, privateExponent);

		RSAPublicKey pubKey = (RSAPublicKey) keyFactory
				.generatePublic(pubKeySpec);
		RSAPrivateKey privKey = (RSAPrivateKey) keyFactory
				.generatePrivate(privKeySpec);

		cipher.init(Cipher.ENCRYPT_MODE, pubKey);

		System.out.println("input: " + new String(input));
		System.out.println("input: " + Arrays.toString(input));
		byte[] cipherText = cipher.doFinal(input);
		System.out.println("cipher: " + new String(cipherText));
		System.out.println("cipher: " +  Arrays.toString(cipherText));

		cipher.init(Cipher.DECRYPT_MODE, privKey);
		byte[] plainText = cipher.doFinal(cipherText);
		System.out.println("plain : " + new String(plainText));
		System.out.println("plain : " + Arrays.toString(plainText));
	}
}
