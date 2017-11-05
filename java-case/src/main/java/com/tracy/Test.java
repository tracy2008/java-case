package com.tracy;

import java.util.Arrays;

/**
 * 
 * @author tracy
 * @date 2017年11月5日
 */
public class Test {
	
	public static void main(String[] args) {
		Object[] elementData = new Object[]{1,2,3};
		
		 Object[] ss = Arrays.copyOf(elementData, elementData.length, Object[].class);
		 ss[2] = 12;
		 System.out.println(String.format("%s", elementData[2]));
		 System.out.println(String.format("%s", ss[2]));
	}

}
