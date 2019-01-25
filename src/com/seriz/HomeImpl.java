package com.seriz;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class HomeImpl implements Home {

	private ArrayList<HomeVO> lists = new ArrayList<HomeVO>();
	
	Scanner sc = new Scanner(System.in);

@SuppressWarnings("unchecked")
public void open(){
	
	try {
		
		FileInputStream fis = new FileInputStream("d:\\doc\\test.txt");

		ObjectInputStream ois = new ObjectInputStream(fis);

		while(true){

			lists=(ArrayList<HomeVO>)ois.readObject();

			if(lists==null)
				break;



			ois.close();
			fis.close();

			
		}

	} catch (Exception e) {
		// TODO: handle exception
	}

	
}






	@Override
	public int input() {

		
        
		int result = 0;		

		HomeVO vo = new HomeVO(null, result, null);


		System.out.println("�̸�?");
		vo.setName(sc.next());

		System.out.println("����?");
		vo.setBirth(sc.next());

		System.out.println("����?");
		vo.setScore(sc.nextInt());



		lists.add(vo);
		



		return 0;
	}

	@Override
	public void print() {
		
		
		Iterator<HomeVO> it = lists.iterator();
        
		System.out.printf(" %2s %2s %2s\n" , "�̸�","����", "����");
		System.out.println("---------------");
        
	

		while(it.hasNext()){

			HomeVO vo = it.next();
			System.out.println(vo.toString());
			System.out.println();
		


		}
	}
	@Override
	public void save() {


		try {



			FileOutputStream fos = new FileOutputStream("d:\\doc\\test.txt");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(lists);
			System.out.println("������ �Ϸ� �Ǿ����ϴ�.");



		} catch (Exception e) {
			System.out.println("������ �Ұ��� �մϴ�.");

		}


	}


	@SuppressWarnings("unchecked")
	@Override
	public void load() {


		try {

			lists =null;


			FileInputStream fis = new FileInputStream("d:\\doc\\test.txt");

			ObjectInputStream ois = new ObjectInputStream(fis);

			while(true){

				lists=(ArrayList<HomeVO>)ois.readObject();

				if(lists==null)
					break;



				ois.close();
				fis.close();

				System.out.println(lists.toString());
				System.out.println();

			}
		} catch (Exception e) {
			// TODO: handle exception
		}




	}

}
