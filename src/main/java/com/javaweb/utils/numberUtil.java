package com.javaweb.utils;

public class numberUtil {
	public static boolean checkNumber(String data) {
		try {
			Long.parseLong(data) ; 
		} catch (NumberFormatException ex) {
			return false ; 
		}
		return true;
	}
}
