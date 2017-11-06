/**
 * 
 */
package com.tracy;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author tracy
 * @date 2017年11月6日
 */
public class MyClassLoader extends ClassLoader {

	private String path = ""; // 默认路径

	private String fileType = ".class";// 文件类型

	
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	
	/**
	 * 
	 */
	public MyClassLoader() {
		// 调用父类构造函数，默认将AppClassLoader作为父类加载器
		super();
	}

	/**
	 * 重写findClass，实现自定义装载
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {

		// 加载给定的类
		byte[] data = loadClassData(name);

		return this.defineClass(name, data, 0, data.length);
	}

	/**
	 * 读取class文件
	 * 
	 * @param name
	 * @return
	 */
	private byte[] loadClassData(String name) {

		byte[] data = null;

		InputStream in = null;

		ByteArrayOutputStream baos = null;
		name = name.replace(".", "/");
		String pathname = path + name + fileType;

		try {
			in = new BufferedInputStream(new FileInputStream(pathname));

			baos = new ByteArrayOutputStream();
			int ch = 0;
			while (-1 != (ch = in.read())) {
				baos.write(ch);
			}
			data = baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}

	
	public static void main(String[] args) throws ClassNotFoundException, Exception, IllegalAccessException {
		MyClassLoader myClassLoader = new MyClassLoader();
		myClassLoader.setPath("D:/works/hadoop-sample/target/classes/");
		Class clazz = myClassLoader.loadClass("com.tracy.hadoop.WordCount");
		Object obj = clazz.newInstance();
		System.out.println(obj.toString());
	}
}
