package com.xxl.hex.core.serialise;

import java.math.BigInteger;

/**
 * hex/byte util
 * @author xuxueli 2015-11-14 22:47:28
 */
public class ByteHexConverter {
	
	/**
	 * byte - to - radix, use BigInteger
	 */
	private static final String hex_tables = "0123456789ABCDEF";
	public static String byte2hex (byte[] iBytes) {
		StringBuilder hex = new StringBuilder(iBytes.length * 2);
		for (int index = 0; index < iBytes.length; index++) {
			hex.append(hex_tables.charAt((iBytes[index] & 0xf0) >> 4));
			hex.append(hex_tables.charAt((iBytes[index] & 0x0f) >> 0));
		}		
		return hex.toString();
	}
	public static byte[] hex2Byte(String hexString) {
		if (hexString == null || hexString.equals("")) {  
	        return null;  
	    }
		byte[] res = new byte[hexString.length() / 2];
		char[] chs = hexString.toCharArray();
		for (int i = 0, c = 0; i < chs.length; i += 2, c++) {
			res[c] = (byte) (Integer.parseInt(new String(chs, i, 2), 16));
		}
		return res;
	}
	
	/**
	 * byte - to - radix, use BigInteger
	 */
	public static final int HEX = 16;
	public static String byte2radix(byte[] iBytes, int radix){
		return new BigInteger(1, iBytes).toString(radix);
	}
	public static byte[] radix2byte(String val, int radix){
		return new BigInteger(val, radix).toByteArray();
	}
	 
	public static void main(String[] args) {
		String temp = "24234234234";
		System.out.println(new String(temp.getBytes()));
		System.out.println(byte2hex(temp.getBytes()));
		System.out.println(new String(hex2Byte(byte2hex(temp.getBytes()))));
		
		System.out.println(byte2radix(temp.getBytes(), HEX));
		System.out.println(new String(radix2byte(byte2radix(temp.getBytes(), HEX), HEX)));
	}
	
}
