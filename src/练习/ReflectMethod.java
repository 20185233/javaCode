package 练习;

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
			System.out.println("请输入学生姓名");
//	        String name = bf.readLine();
			String name = in.nextLine();
	        Class<?> c = Class.forName("练习.Student");
	        Object o = c.newInstance();
	    	setter(o,"name",name,String.class);
	    	System.out.println("刚才赋值的对象是:"+getter(o,"name"));			
				
	       
	        System.out.println("请输入学生年龄");
//			int age = bf.read();
	        int age = in.nextInt();
	        setter(o,"age",age,int.class);
	        System.out.println("刚才赋值的对象是:"+getter(o,"age"));			
//			
			System.out.println("请输入学生成绩");
//			double grade = Double.parseDouble(bf.readLine());
			double grade = in.nextDouble();
	        setter(o,"grade",grade,double.class);
	        System.out.println("刚才赋值的对象是:"+getter(o,"grade"));			
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
	 * @param o 要操作的对象
	 * @param attr 要操作的属性名称
	 * @param value 要设置的内容
	 * @param type 要设置的属性类型
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


