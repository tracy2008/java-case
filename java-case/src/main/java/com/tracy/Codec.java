/**
 * 
 */
package com.tracy;

import com.tracy.util.EntrypUtil;

/**
 * 
 * @author tracy
 * 2017年11月4日
 */
public class Codec {
	
	
	public static void main(String[] args) throws Exception {
		String input = "234";
		System.out.println(EntrypUtil.md5(input));
		System.out.println(EntrypUtil.sha(input));
		
	}

}
