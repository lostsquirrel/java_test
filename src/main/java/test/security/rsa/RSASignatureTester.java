package test.security.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;

public class RSASignatureTester {

	public static void main(String[] args) throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");

		keyGen.initialize(512, new SecureRandom());

		KeyPair keyPair = keyGen.generateKeyPair();
		Signature signature = Signature.getInstance("SHA1withRSA", "BC");

		signature.initSign(keyPair.getPrivate(), new SecureRandom());

//		签名
		byte[] message = "abc".getBytes();
		signature.update(message);
		byte[] sigBytes = signature.sign();
//		验签
		signature.initVerify(keyPair.getPublic());
		signature.update(message);
		System.out.println(signature.verify(sigBytes));
	}
}
