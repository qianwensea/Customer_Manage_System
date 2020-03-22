package com.shi.util;

import java.util.Scanner;

/**
 * 
     * @ClassName: CMUtility
     * @Description: TODO(工具类)
     * @author 千文sea
     * @date 2020年3月22日
     *
 */
public class CMUtility {

	private static Scanner scan = new Scanner(System.in);

	/**
	 * 
	     * @Title: readMenuSelection
	     * @Description: TODO(读入键盘字符判断选择的功能)
	     * @param @return 参数
	     * @return char 返回类型
	 */
	public static char readMenuSelection() {
		char c;
		for (;;) {
			String s = readKeyBoard(1, false);
			c = s.charAt(0);
			if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
				System.out.print("输入错误请重新输入：");
			} else
				return c;
		}
	}

	/**
	 * 
	     * @Title: readConfirmSelection
	     * @Description: TODO(判断是否退出)
	     * @param @return 参数
	     * @return char 返回类型
	 */
	public static char readConfirmSelection() {
		for (;;) {
			String s = readKeyBoard(1, false).toUpperCase();
			char c = s.charAt(0);
			if (c != 'Y' && c != 'N')
				System.out.print("输入错误请重新输入：");
			else
				return c;
		}
	}

	/**
	 * 
	     * @Title: readString
	     * @Description: TODO(读取String)
	     * @param @param limit
	     * @param @return 参数
	     * @return String 返回类型
	 */
	public static String readString(int limit) {
		return readKeyBoard(limit, false);
	}

	/**
	 * 
	     * @Title: readString
	     * @Description: TODO(如果没有输入则返回默认值)
	     * @param @param limit
	     * @param @return 参数
	     * @return String 返回类型
	 */
	public static String readString(int limit, String defaultValue) {
		String s = readKeyBoard(limit, true);
		if (s.equals("")) {
			return defaultValue;
		}
		return s;
	}

	/**
	 * 
	     * @Title: readChar
	     * @Description: TODO(读取char)
	     * @param @param limit
	     * @param @return 参数
	     * @return String 返回类型
	 */
	public static char readChar() {
		char c;
		while (true) {
			c = readKeyBoard(1, false).charAt(0);
			if (c != '男' && c != '女') {
				System.out.print("输入错误,请重新输入:");
				continue;
			}
			break;
		}
		return c;
	}

	/**
	 * 
	     * @Title: readChar
	     * @Description: TODO(如果没有输入则返回默认值)
	     * @param @param defaultValue
	     * @param @return 参数
	     * @return char 返回类型
	 */
	public static char readChar(char defaultValue) {
		char c;
		while (true) {
			String s = readKeyBoard(1, true);
			if (s.equals(""))
				return defaultValue;
			c = s.charAt(0);
			if (c != '男' && c != '女') {
				System.out.print("输入错误,请重新输入:");
				continue;
			}
			break;
		}
		return c;
	}

	/**
	 * 
	     * @Title: readInt
	     * @Description: TODO(读取int类型数据)
	     * @param @return 参数
	     * @return int 返回类型
	 */
	public static int readInt() {
		int n;
		while (true) {
			String s = readKeyBoard(2, false);
			try {
				n = Integer.parseInt(s);
				break;
			} catch (Exception e) {
				System.out.print("数字输入错误,请重新输入:");
			}
		}
		return n;
	}

	/**
	 * 
	     * @Title: readInt
	     * @Description: TODO(如果没有输入则返回默认值)
	     * @param @return 参数
	     * @return int 返回类型
	 */
	public static int readInt(int defaultValue) {
		int n;
		while (true) {
			String s = readKeyBoard(2, true);
			if (s.equals(""))
				return defaultValue;
			try {
				n = Integer.parseInt(s);
				break;
			} catch (Exception e) {
				System.out.print("数字输入错误,请重新输入:");
			}
		}
		return n;
	}

	/**
	 * 
	     * @Title: readKeyBoard
	     * @Description: TODO(读取键盘字符并返回)
	     * @param @param index
	     * @param @return 参数
	     * @return String 返回类型
	 */
	public static String readKeyBoard(int limit, boolean isReturn) {
		String s = "";
		while (scan.hasNextLine()) {
			s = scan.nextLine();
			if (s.length() == 0) {
				if (isReturn)
					return s;
				else
					continue;
			}
			if (s.length() > limit) {
				System.out.print("输入字符不能大于:" + limit + ",请重新输入:");
				continue;
			}
			break;
		}
		return s;
	}
}
