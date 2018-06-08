package com.yoyo.test;

import com.yoyo.util.Md5Util;

public class Test {
	public static void main(String[] args) {
		String pwd = Md5Util.generateTwoPassword("admin");
		System.out.println(pwd);
		
		String pwd1 = Md5Util.generatePassword("admin");
		System.out.println(pwd1);
		
		String pwd2 = Md5Util.generatePassword(pwd1);
		System.out.println(pwd2);
		
		String pwd3 = Md5Util.generateTwoPassword(new String("admin"));
		System.out.println(pwd3);
		
		String pwd4 = Md5Util.generatePassword(pwd3);
		System.out.println(pwd4);
	}
}
