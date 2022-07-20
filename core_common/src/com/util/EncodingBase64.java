package com.util;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.google.common.io.BaseEncoding;

public class EncodingBase64 {

	private static final String algorithm = "AES";

	/**
	 * 
	 * @param data
	 * @param keyValue (16 char)
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(Object data, String keyValue) throws Exception {
		Key key = generateKey(keyValue);
		Cipher c = Cipher.getInstance(algorithm);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(String.valueOf(data).getBytes());
		// encrypt step 1
		String value1 = Base64.getEncoder().encodeToString(encVal);
		// encrypt step 2
		String encryptedValue = BaseEncoding.base64().encode(value1.getBytes("UTF-8"));
		return encryptedValue;
	}

	/**
	 * 
	 * @param encryptedData
	 * @param keyValue      (16 char)
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String encryptedData, String keyValue) throws Exception {
		// decrypt step1
		byte[] contentInBytes = BaseEncoding.base64().decode(encryptedData);
		String value1 = new String(contentInBytes, "UTF-8");

		Key key = generateKey(keyValue);
		Cipher c = Cipher.getInstance(algorithm);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = Base64.getDecoder().decode(value1);
		byte[] decValue = c.doFinal(decordedValue);
		// decrypt step2
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	private static Key generateKey(String keyValue) throws Exception {
		Key key = new SecretKeySpec(keyValue.getBytes(), algorithm);
		return key;
	}

}
