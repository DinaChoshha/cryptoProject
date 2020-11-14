package cryptoProject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		RSAKeyGeneration rsa = new RSAKeyGeneration(33);//primeSize=33
		BigInteger publicKeyB = rsa.getE();
		BigInteger privateKeyB = rsa.getD();
		BigInteger randomNumberB = rsa.getN();
		try {
			String key=rsa.generateKey(publicKeyB,privateKeyB, randomNumberB);
			MyElGamal elgamal = new MyElGamal();
			elgamal.signthemessage();//call the function that signs the message 
			
			elgamal.verification();//call the function that verify the digital signature 
			Blowfish bf= new Blowfish(key,elgamal);
		}catch (IOException e) {
				e.printStackTrace();
			} 
	}

}
