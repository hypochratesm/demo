package com.seriz;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//Externalizable//하나하나 낱개로 읽어올 수 있다.
//serializable의 인터페이스에 하위 인터페이스
//serializable과 같은 기능을 하되 좀 더 완벽한 제어가 가능함.
//writeExternal(),readExternal()메소드를 정의


class DataTest implements Externalizable{

	String name;
	int age;

	public DataTest(){

	}

	public DataTest(String name, int age){

		this.name = name;
		this.age =age;

	}

	@Override
	public String toString() {
		return name + ":" + age;
	}


	@Override//복원시 호출
	public void readExternal(ObjectInput in) throws IOException,//입력
	ClassNotFoundException {

		name = (String)in.readObject();
		age = in.readInt();
		System.out.println("readExternnal() 실행됨...");

	}

	@Override//직렬화 할 때 호출
	public void writeExternal(ObjectOutput out) throws IOException {//출력

		out.writeObject(name);
		out.writeInt(age);

		System.out.println("writeExternnal() 실행됨...");

	}


}


public class Test3 {

	public static void main(String[] args) throws Exception{

		try {

			DataTest ob = new DataTest("배수지", 25);

			FileOutputStream fos = new FileOutputStream("d:\\doc\\a3.txt");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(ob);

			fos.close();
			oos.close();

			FileInputStream fis = new FileInputStream("d:\\doc\\a3.txt");

			ObjectInputStream ois = new ObjectInputStream(fis);

			DataTest dt = (DataTest)ois.readObject();

			System.out.println(dt.toString());

		} catch (Exception e) {
			// TODO: handle exception
		}









	}

}
