package ��ϰ;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectMethod {
	public static void main(String[] args) {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner (System.in); 
		try {
			System.out.println("������ѧ������");
//	        String name = bf.readLine();
			String name = in.nextLine();
	        Class<?> c = Class.forName("��ϰ.Student");
	        Object o = c.newInstance();
	    	setter(o,"name",name,String.class);
	    	System.out.println("�ղŸ�ֵ�Ķ�����:"+getter(o,"name"));			
				
	       
	        System.out.println("������ѧ������");
//			int age = bf.read();
	        int age = in.nextInt();
	        setter(o,"age",age,int.class);
	        System.out.println("�ղŸ�ֵ�Ķ�����:"+getter(o,"age"));			
//			
			System.out.println("������ѧ���ɼ�");
//			double grade = Double.parseDouble(bf.readLine());
			double grade = in.nextDouble();
	        setter(o,"grade",grade,double.class);
	        System.out.println("�ղŸ�ֵ�Ķ�����:"+getter(o,"grade"));			
//			
			File file = new File("e:\\student.txt");
			FileOutputStream fos = new FileOutputStream(file);
//			Method method = c.getClass().getMethod("toString");
//			String string = method.invoke(c.newInstance()).toString();
//		
			String string = "name: "+getter(o,"name")+"   age: "+getter(o,"age")+"   grade: "+getter(o,"grade");
			byte[] b = string.getBytes();
			for (int i = 0; i < b.length; i++) {
				fos.write(b[i]);
			}
			fos.close();
	 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	/**
	 * 
	 * @param o Ҫ�����Ķ���
	 * @param attr Ҫ��������������
	 * @param value Ҫ���õ�����
	 * @param type Ҫ���õ���������
	 */
	public static void setter(Object o , String attr , Object value, Class<?> type){
		try {
			Method method = o.getClass().getMethod("set"+initStr(attr), type);
			method.invoke(o, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object getter(Object o , String attr){
		try {
			Method method = o.getClass().getMethod("get"+initStr(attr));
			Object invoke = method.invoke(o);
			return invoke;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String initStr(String attr){
		String s = attr.substring(0,1).toUpperCase()+attr.substring(1);
		return s;
	}
}


