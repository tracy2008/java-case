/**
 * 
 */
package com.tracy.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 常用的加密工具
 * @author tracy
 * @date 2017年11月4日
 */
public class EntrypUtil {

	/**
	 * 将摘要返回的哈希值转为字符串
	 * @param data
	 * @return
	 */
	private static String convertToHexString(byte data[]) {
		StringBuffer strBuffer = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			strBuffer.append(Integer.toHexString(0xff & data[i]));
		}
		return strBuffer.toString();
	}

	/**
	 * md5加密
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String md5(String input) throws NoSuchAlgorithmException   {
		byte[] data = MessageDigest.getInstance("MD5").digest(input.getBytes());
		return convertToHexString(data);
	}

	/**
	 * SHA-1加密比md5长32位，坑攻击强度大，效率比md5低
	 * @throws NoSuchAlgorithmException 
	 * 
	 */
	public static String sha(String input) throws NoSuchAlgorithmException {
		byte[] data = MessageDigest.getInstance("SHA-1").digest(input.getBytes());
		return convertToHexString(data);
	}
}
