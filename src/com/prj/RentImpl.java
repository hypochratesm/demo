package com.prj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RentImpl implements Rent, Runnable{


	private List<RentVO> clientLists = null;	
	List<RentVO> finalRes = new ArrayList<RentVO>();
	private ArrayList<RentVO> lst = new ArrayList<RentVO>();
	private RentVO vo;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);	

	private String path = "d:\\doc";	
	private File clientFile = new File(path, "\\client.txt");
	private File carFile = new File(path, "\\car.txt");

	private String startDay, endDay;

	private static final String Id="admin";
	private static final String Password="a123b";

	public RentImpl(){	//������

		try {		
			if(!clientFile.getParentFile().exists()){	
				clientFile.getParentFile().mkdirs();
			}

			if(clientFile.exists()){

				FileInputStream fis = new FileInputStream(clientFile);

				ObjectInputStream ois = new ObjectInputStream(fis);

				clientLists = (ArrayList<RentVO>)ois.readObject();

				fis.close();
				ois.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			if(!carFile.getParentFile().exists()){	
				carFile.getParentFile().mkdirs();
			}

			if(carFile.exists()){

				FileInputStream fis = new FileInputStream(carFile);

				ObjectInputStream ois = new ObjectInputStream(fis);

				lst = (ArrayList<RentVO>)ois.readObject();

				fis.close();
				ois.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void input() {

		vo = new RentVO();

		Calendar now = Calendar.getInstance();
		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH)+1;
		int d = now.get(Calendar.DATE);	

		String today = Integer.toString(y) +"-"+ Integer.toString(m) +"-"+ Integer.toString(d);

		int startY, startM, startD;
		int endY, endM, endD;

		int ch;
		int cnt1, cnt2;

		boolean flag = false;

		try {

			do{
				cnt1 =0;
				System.out.println("=========== ��¥ ���� ===========");
				System.out.print("�뿩��? [ex.yyyy-mm-dd]");
				startDay = sc.next();
				cnt1 = diffOfDate(today, startDay);
				vo.setStartday(startDay);

			}while(cnt1==-1);


		} catch (Exception e) {

			System.out.println("\n�Ƴ�¥�� �ٽ� �Է����ּ����");
			System.out.println();
			return;
		}

		try {

			do{
				System.out.print("�ݳ���? [ex.yyyy-mm-dd]");
				endDay = sc.next();
				vo.setEndday(endDay);

				startY = Integer.parseInt(vo.getStartday().substring(0, 4));
				startM = Integer.parseInt(vo.getStartday().substring(5, 7));
				startD = Integer.parseInt(vo.getStartday().substring(8, 10));

				endY = Integer.parseInt(vo.getStartday().substring(0, 4));
				endM = Integer.parseInt(vo.getStartday().substring(5, 7));
				endD = Integer.parseInt(vo.getStartday().substring(8, 10));	

				cnt2 = 0;	
				cnt2 = diffOfDate(vo.getStartday(), vo.getEndday());


			}while(cnt2<1);

		} catch (Exception e) {

			System.out.println("\n�Ƴ�¥�� �ٽ� �Է����ּ����");
			System.out.println();
			return;
		}

		while(true){

			System.out.println();
			System.out.println();
			System.out.print("\t�� �� ��  ");

			Thread t1 = new Thread(new RentImpl());	//������
			t1.start();
			try {
				t1.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("\t�� �� �� �� !");

			System.out.println();
			System.out.println();
			System.out.println("                        �� ���డ���� ���� ��� ��");
			posiCar();
			System.out.println("===========================================================================");
			System.out.println("    �������� �����ϼ���");

			do{
				System.out.print("    ���� ��ȣ: ");
				String select = sc.next();

				Iterator<RentVO> it = finalRes.iterator();

				flag = false;

				while(it.hasNext()){

					RentVO rent = it.next();

					if(select.equals(rent.getCbun())) {
						flag = true;
						vo.setScar(select);	
					}
				}
				if(flag==false){

					System.out.println("\n����Ȯ�� ������ȣ�� �Է��ϼ����");
					System.out.println();
				}

			}while(flag==false);

			flag = true;

			carWrite(vo.getScar());

			Iterator<RentVO> it = lst.iterator();
			while(it.hasNext()){
				RentVO rent = it.next();
				if(vo.getScar().equals(rent.getCbun())) {
					System.out.println();
					System.out.println("=========== ���� ���� ==========");
					System.out.printf("��������ȣ: %s\n�Ѹ𵨸�: %s\n",vo.getScar(),rent.getCname());
					break;
				}
			}
			int dif = diffOfDate(startDay, endDay);
			System.out.printf("�Ѵ뿩�Ⱓ: %d��\n", dif);

			Iterator<RentVO> it2 = lst.iterator();
			while(it2.hasNext()){
				RentVO rent = it2.next();
				if(vo.getScar().equals(rent.getCbun())) {
					int price = replacePrice(rent.getPrice());
					System.out.printf("���� �뿩���: %,3d��\n", dif*price);
					System.out.println();					
					vo.setSprice(dif*price);
					break;
				}
			}
			try {
				do {
					System.out.println("1.�����ܰ��  2.�ٽü���");
					System.out.print("�� ");
					ch = sc.nextInt();

				}while(ch<1 || ch>2);

				if(ch==1){

					do{
						System.out.println();
						System.out.println("============================= ��å ���� ���� ==============================");
						System.out.println("1.������å : ��å�ѵ�(500����)���� �� �δ�� ����");
						System.out.println("2.�Ϲݸ�å : ��å�ѵ�(500����)���� �ڱ�δ�� 30���� + ��������� �δ�");
						System.out.println("3.���Ծ��� : ���������� + ��������� �ڱ�δ�");
						System.out.println();
						System.out.print("��å ������ �����ϼ��� �� ");
						try {

							ch = sc.nextInt();

						} catch (Exception e) {

							System.out.println("\n�Ƽ��ڷ� �Է��� �ּ����");
							System.out.println();
						}


						switch(ch){
						case 1:
							vo.setInsure("������å");
							break;
						case 2:
							vo.setInsure("�Ϲݸ�å");
							break;
						case 3:
							vo.setInsure("���Ծ���");
							break;
						}

					}while(ch<1||ch>3);

					break;
				}

			} catch (java.util.InputMismatchException e) {

				System.out.println("\n�Ƽ��ڷ� �Է��� �ּ����");
				System.out.println();
			}

		}


		while(true){

			Pattern pBirth = Pattern.compile("\\d{8}");
			Pattern pEmail = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
			Pattern pTel = Pattern.compile("^\\d{2,3}-\\d{3,4}-\\d{4}$");
			Matcher matBirth;
			Matcher matEmail;
			Matcher matTel;


			System.out.println();
			System.out.println("======== ������ ���� �Է� ========");

			System.out.print("�̸�: ");
			vo.setName(sc.next());
			do {	
				System.out.print("�������[yyyymmdd]: ");
				String b = sc.next();
				matBirth = pBirth.matcher(b);
				vo.setBirth(b);
			}while(!matBirth.matches());


			do{
				System.out.print("����ó: ");
				String tel = sc.next();
				matTel = pTel.matcher(tel);

				flag = false;
				Iterator<RentVO> it = lst.iterator();
				while(it.hasNext()){
					if(matTel.matches()) {
						RentVO rent = it.next();
						if(!tel.equals(rent.getTel())){
							vo.setTel(tel);
							flag = true;
						}

					}
					else{
						flag = false;
						System.out.println("\n�ƿ���ó�� �ٽ� Ȯ�����ּ����");
						System.out.println("\n�ƾ�Ŀ� ���� �ʰų� �ߺ��Ǿ����ϴ٢�");
						break;	
					}						
				}



			}while(flag==false); 

			do {
				System.out.print("�̸���: ");
				String email = sc.next();
				matEmail = pEmail.matcher(email);
				vo.setEmail(email);

			}while(!matEmail.matches());

			try {
				System.out.println();
				System.out.println();

				System.out.println("======== ������ ���� Ȯ�� ========");
				System.out.println("���̸�: "+vo.getName());
				System.out.println("�ѻ������: "+vo.getBirth());
				System.out.println("�ѿ���ó: "+vo.getTel());
				System.out.println("���̸���: "+vo.getEmail());
				System.out.println();
				System.out.println("** �Է��Ͻ� ������ �½��ϱ�?");
				System.out.println("** 1.Ȯ�� 2.�ٽ��Է� ");
				System.out.print("�� ");
				ch = sc.nextInt();

				if(ch==1){
					break;
				}
			} catch (Exception e) {
				System.out.println("\n�Ƽ��ڷ� �Է��� �ּ����\n");
			}

		}

		System.out.println();
		System.out.println("============ ���� ���� ===========");
		System.out.println(vo.toStringClient());
		System.out.println("----------------------------------");
		System.out.println("�Ѵ뿩��: "+vo.getStartday());
		System.out.println("�ѹݳ���: "+vo.getEndday());
		System.out.println();
		System.out.println("===================================================================================");
		System.out.println("           ������ȣ | ������ |    �𵨸�  | ���� | ���� | ž���ο� | ���� |  ���� ");
		System.out.println("===================================================================================");
		System.out.println("��������: "+vo.toStringSelecCar());
		System.out.println();
		System.out.println("��������: "+vo.getInsure());
		System.out.println();
		System.out.println();

		try {
			System.out.println("�����Ͻðڽ��ϱ�?    1.��  2.�ƴϿ�");
			System.out.print("�� ");
			ch=sc.nextInt();




		} catch (Exception e) {

			System.out.println("\n�Ƽ��ڷ� �Է��� �ּ����");
			System.out.println();
		}


		if(ch==1){

			System.out.print("\t�� �� �� �� �� ");

			Thread t2 = new Thread(new RentImpl());	//������
			t2.start();
			try {
				t2.join();
			} catch (Exception e) {
				// TODO: handle exception
			}

			if(clientLists==null){
				clientLists = new ArrayList<RentVO>();
			}
			clientLists.add(vo);

			try {

				carRes(vo.getScar());

				if(clientLists!=null){

					FileOutputStream fos = new FileOutputStream(clientFile);

					ObjectOutputStream oos = new ObjectOutputStream(fos);

					oos.writeObject(clientLists);

					fos.close();
					oos.close();


					System.out.println("\n\t�� ���� ����! ��");
					System.out.println();
					System.out.println();
				}

			} catch (Exception e) {

				System.out.println("\n\t�ƿ��࿡ �����Ͽ����ϴ�. �ٽ� �õ����ּ����");
				System.out.println();
			}
		}
		else{



			System.out.println("\n\t�ƿ����� ����Ͽ����ϴ٢�");
			System.out.println();
			return;
		}

	}

	public int replacePrice(String str){

		String price = str;

		str = str.replace(",", "").trim();

		return Integer.parseInt(str);	
	}

	@Override
	public void posiCar() {

		System.out.println("===========================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ���� ");
		System.out.println("===========================================================================");

		int startY, startM, startD;
		String tempDate1, tempDate2;

		List<RentVO> tempRes = new ArrayList<RentVO>();
		List<RentVO> noRes = new ArrayList<RentVO>();



		//�Է¹��� ��¥ �Ⱓ�� �迭 dates�� ����.

		int d = diffOfDate(startDay, endDay);

		Calendar cal = Calendar.getInstance();

		String[] dates = new String[d+1];	//�����ڿ��� �Է¹��� ��¥�� ������ �迭 ����

		String[] getTemp = new String[3];	//�Է³�¥ date������ ���� �и�
		getTemp = startDay.split("-");

		startY = Integer.parseInt(getTemp[0]);
		startM = Integer.parseInt(getTemp[1]);
		startD = Integer.parseInt(getTemp[2]);
		cal.set(startY, startM-1, startD);	//��¥ ����

		for(int i=0 ; i<dates.length ; i++) {
			int tempY = cal.get(Calendar.YEAR);
			int tempM = cal.get(Calendar.MONTH)+1;
			int tempD = cal.get(Calendar.DATE);	
			tempDate1 = Integer.toString(tempY) + Integer.toString(tempM) + Integer.toString(tempD);
			dates[i]=tempDate1;		 
			cal.add(Calendar.DATE, 1);
		}


		//�����ڸ���Ʈ���� ���೯¥ ��������
		Iterator<RentVO> it = clientLists.iterator();

		while(it.hasNext()) {
			RentVO rent = it.next();

			if(!(rent.getStartday().trim().equals("-"))) {

				Calendar cal2 = Calendar.getInstance();

				int dif = diffOfDate(rent.getStartday(), rent.getEndday());

				String getTemp2[] = new String[3];

				getTemp2 = rent.getStartday().split("-");

				startY = Integer.parseInt(getTemp2[0]);
				startM = Integer.parseInt(getTemp2[1]);
				startD = Integer.parseInt(getTemp2[2]);
				cal2.set(startY, startM-1, startD);

				for(int i=0 ; i<dif+1 ; i++) {

					int tempY = cal2.get(Calendar.YEAR);
					int tempM = cal2.get(Calendar.MONTH)+1;
					int tempD = cal2.get(Calendar.DATE);

					tempDate2 = Integer.toString(tempY) + Integer.toString(tempM) + Integer.toString(tempD);

					cal2.add(Calendar.DATE, 1);

					RentVO vo = new RentVO();
					vo.setStartday(tempDate2);
					vo.setCbun(rent.getCbun());

					tempRes.add(vo);
				}

			}
		}

		//�迭�� ����Ʈ ��
		for(int i=0;i<dates.length;i++){
			Iterator<RentVO> it2 = tempRes.iterator();
			while(it2.hasNext()){
				RentVO vo = it2.next();
				if(dates[i].equals(vo.getStartday())){
					noRes.add(vo);	//����ϸ� �ȵǴ� �� ��ȣ ����Ʈ
				}
			}
		}
		//finalRes ����Ʈ�� �˻������ ������ ������ �߰�
		Iterator<RentVO> strIt2 = clientLists.iterator();
		while(strIt2.hasNext()){
			boolean flag = true;
			RentVO vo = strIt2.next();	


			Iterator<RentVO> strIt3 = noRes.iterator();
			while(strIt3.hasNext()){
				RentVO vo2 = strIt3.next();

				if(vo.getCbun().equals(vo2.getCbun())){
					flag = false;
					break;
				}
			}

			if(flag==true){
				if(!finalRes.contains(vo)){
					finalRes.add(vo);
				}
			}
		}

		//���� null�� �Է�
		Iterator<RentVO> price = finalRes.iterator();
		while(price.hasNext()) {
			RentVO vo = price.next();

			Iterator<RentVO> printIt = lst.iterator();
			while(printIt.hasNext()) {
				RentVO vo2 = printIt.next();
				if(vo.getCbun().equals(vo2.getCbun())) {
					vo.setPrice(vo2.getPrice());
					break;
				}
			}
		}

		Iterator<RentVO> printIt = lst.iterator();

		while(printIt.hasNext()){
			RentVO vo = printIt.next();
			if(vo.getStartday().trim().equals("-")) {
				finalRes.add(vo);

			}
		}

		Collections.sort(finalRes);

		Iterator<RentVO> printIt2 = finalRes.iterator();	//�������
		while(printIt2.hasNext()) {
			RentVO vo = printIt2.next();
			System.out.println(vo.toStringCar());
		}

	}

	@Override
	public void searchRes() {// �ڡ� ��������! > �̸�,����ó ���� ������ �ݺ�����

		String name;
		String tel;
		int ch;
		boolean flag;
		System.out.println("========������ ���� �Է�=======");

		do{
			Iterator<RentVO> ite = clientLists.iterator();
			flag = false;

			System.out.print("��Ͻ� �̸�: ");
			name = sc.next();

			while(ite.hasNext()){
				RentVO ob = ite.next();
				if(name.equals(ob.getName())){
					flag=true;
					break;
				}
			}
			if(flag==false){

				System.out.println("\n���������� �ʴ� �̸��Դϴ٢�\n");

			}
		}while(flag==false);

		do{
			Iterator<RentVO> ite = clientLists.iterator();
			flag = false;

			System.out.print("��Ͻ� ����ó: ");
			tel = sc.next();

			while(ite.hasNext()){
				RentVO ob = ite.next();
				if(tel.equals(ob.getTel())){
					flag=true;
					break;
				}
			}
			if(flag==false){

				System.out.println("\n�ƿ���ó�� ��ġ���� �ʽ��ϴ٢�\n");

			}
		}while(flag==false);


		Iterator<RentVO> it = clientLists.iterator();

		while(it.hasNext()){
			RentVO rent = it.next();

			if(name.equals(rent.getName())){
				if(tel.equals(rent.getTel())){
					System.out.println();
					System.out.println();
					System.out.println("===========����������==========");
					System.out.println();
					System.out.println(rent.toStringClient());	
					System.out.println("===========================================================================");
					System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ���� ");
					System.out.println("===========================================================================");
					System.out.println(rent.toStringSelecCar());	
					System.out.println();

					do{
						System.out.println("1.Ȯ��   2.�������");
						System.out.print("�� ");
						ch = sc.nextInt();
						if(ch==1){
							return;
						}
						if(ch==2){
							try {
								System.out.println();
								System.out.print("������ ����Ͻðڽ��ϱ�? (Y/N) ");
								char ch2 = (char)System.in.read();
								if(ch!='Y' && ch!='y'){
									clientLists.remove(clientLists.indexOf(rent));
									resDel(name,tel);

									System.out.println("\n������Ͽ����ϴ٢�\n");

									try {
										FileOutputStream fos = new FileOutputStream(clientFile);
										ObjectOutputStream oos = new ObjectOutputStream(fos);

										oos.writeObject(clientLists);

										oos.close();
										fos.close();

									} catch (Exception e) {
										// TODO: handle exception
									}
									return;
								}

							} catch (Exception e) {
								// TODO: handle exception
							}
						}

					}while(ch<1 || ch>2);


				}

			}

		}

		System.out.println("\n�ƿ���� ������ �����ϴ٢�\n");

		System.out.println();
	}



	public int diffOfDate(String startDay, String endDay){ //�� ��¥ ���̰����

		Calendar startCal = Calendar.getInstance();

		String[] startTemp = new String[3];
		startTemp = startDay.trim().split("-");

		int startY = Integer.parseInt(startTemp[0]);
		int startM = Integer.parseInt(startTemp[1]);
		int startD = Integer.parseInt(startTemp[2]);

		startCal.set(startY, startM-1, startD);

		Calendar endCal = Calendar.getInstance();
		String[] endTemp = new String[3];
		endTemp = endDay.trim().split("-");

		int endY = Integer.parseInt(endTemp[0]);
		int endM = Integer.parseInt(endTemp[1]);
		int endD = Integer.parseInt(endTemp[2]);

		endCal.set(endY, endM-1, endD); 

		int cnt = 0;

		while (!startCal.after(endCal))	{
			cnt++;
			startCal.add(Calendar.DATE, 1); 
		}

		return cnt-1;
	}


	@Override
	public void allSearch() { //��� ������ ��ȸ



		Iterator<RentVO> it = clientLists.iterator();

		System.out.println();
		System.out.println("                                                ��    ��ü ������ ���    ��                                                  ");
		System.out.println("===============================================================================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   �뿩��   |   �ݳ���   |   �뿩��   | �뿩�� |  �޴��� ��ȣ ");
		System.out.println("===============================================================================================================================");
		//System.out.println("   9987      BEN       ��Ƽ��T    ����   ����    4�ν�     �ֹ�   2018-06-29   2018-07-11   11,999,988   ������  010-0001-0045");
		while(it.hasNext()){

			RentVO rent = it.next();

			//�̸��ϸ� �����ϰ� ���

			System.out.println(rent.toStringRes());

		}

		System.out.println();
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");



	}

	@Override
	public void admin() {//������ �α���

		boolean flag = false;

		String id = null;
		String password = null;
		do{
			System.out.print("\t���̵� �Է��ϼ��� |   ");
			id=sc.next();
			if(id.equals(Id)){
				flag = true;

			}
			if(flag==false){

				System.out.println("\t <!> ���̵� Ȯ���ϼ���!");
				System.out.println();

			}

		}while(flag==false);

		flag=false;

		do{
			System.out.print("\t��й�ȣ�� �Է��ϼ��� |   ");
			password=sc.next();

			if(password.equals(Password)){
				flag = true;

			}
			if(flag==false){

				System.out.println("\t <!> ��й�ȣ�� Ȯ���ϼ���!");
				System.out.println();
			}

		}while(flag==false);

		System.out.println();
		System.out.println();
		System.out.print("\t <��> �α��� ����! ");
		System.out.println();



		while(true){//�����ڸ޴� ���

			System.out.println("===============================================================================================================================");
			System.out.println("            1.����������ȸ  |  2.�����������  |  3.������������  |  4.������������  |  5.������Ȳ  |  6.��������              ");
			System.out.println("===============================================================================================================================");
			System.out.print("�� ");
			int ch = sc.nextInt();

			switch(ch){	

			case 1:
				carPrint();
				break;
			case 2:
				carInfo();
				break;
			case 3:
				carUpdt();
				break;
			case 4:
				carDel();
				break;
			case 5:
				allSearch();
				break;
			case 6:
				return;	
			}

		}

	}

	@Override
	public void carInfo() {

		try {

			FileInputStream fis = new FileInputStream(carFile);
			ObjectInputStream ois = new ObjectInputStream(fis);

			lst = (ArrayList<RentVO>) ois.readObject();

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {

			String setStartday = " ";
			String setEndday = " ";
			String cBun;
			boolean flag = false;

			RentVO vo = new RentVO();

			do{//������ ������ȣ �ɷ���
				Iterator<RentVO> it = lst.iterator();

				flag = true;
				System.out.print("���� ��ȣ");
				cBun = sc.next();

				while(it.hasNext()){

					RentVO v1 = it.next();
					if(v1.getCbun().equals(cBun)){
						System.out.println("�̹� �ִ� ������ȣ �Դϴ�!");
						flag=false;	
					}
				}
			}while(flag==false);

			System.out.print("ȸ��");
			vo.setCmanu(sc.next());

			System.out.print("�𵨸�");
			vo.setCname(br.readLine());

			System.out.print("����");
			vo.setCsize(sc.next());

			System.out.print("����");
			vo.setCcolor(sc.next());

			System.out.print("ž���ο�");
			vo.setCseat(sc.next());

			System.out.print("����");
			vo.setCfuel(sc.next());


			//���೯¥�� ������ Ÿ�������� �ڵ� null�ֱ�
			System.out.print("���� ���� ��¥");
			vo.setStartday(br.readLine());

			if(vo.getStartday().trim().equals("-")){
				vo.setEndday("    -     ");
				vo.setName("   -   ");
				vo.setTel("       -      ");
			}else if(!vo.getStartday().trim().equals("-")){

				System.out.print("���� ���� ��¥");
				vo.setEndday(br.readLine());

				System.out.print("�뿩��");
				vo.setName(br.readLine());

				System.out.print("�޴��� ��ȣ");
				vo.setTel(br.readLine());
			}

			System.out.print("�뿩��");
			vo.setPrice(sc.next());

			lst.add(vo);


		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			FileOutputStream fos = new FileOutputStream(carFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(lst);

			oos.close();
			fos.close();
			System.out.println();
			System.out.println("\t <��> ���� ����");
			System.out.println();

		} catch (Exception e) {
			System.out.println();
			System.out.println("\t <!> ���� �Ұ���!");
			System.out.println();
		}

	}

	@Override
	public void carUpdt() {//������ ������ ����

		try {//������ ������ ���� ����
			FileInputStream fis = new FileInputStream(carFile);
			ObjectInputStream ois = new ObjectInputStream(fis);

			lst = (ArrayList<RentVO>)ois.readObject();

			ois.close();
			fis.close();

			FileInputStream fiis = new FileInputStream(clientFile);
			ObjectInputStream oiis = new ObjectInputStream(fiis);
			clientLists = (ArrayList<RentVO>)oiis.readObject();

			oiis.close();
			fiis.close();

		} catch (Exception e) {
			System.out.println("\t <!> ���� �ҷ����� ����!");
		}//���� �ҷ���


		String num = null;
		boolean flag = false;

		do{
			System.out.print("\t ������ ������ ������ȣ�� �Է��ϼ��� |  ");
			num = sc.next();

			Iterator<RentVO> ite = lst.iterator();

			while(ite.hasNext()){

				RentVO vv = ite.next();

				if(num.equals(vv.getCbun())){
					flag = true;
				}
			}
			if(flag==false){
				System.out.println("\t <!> �������� �ʴ� ������ȣ!");
			}

		}while(flag==false);
		System.out.println();//������ȣ ���� �˻�


		int ch = 0;
		String str= null;


		Iterator<RentVO> it = lst.iterator();

		while(it.hasNext()){//�������� ����

			RentVO v1 = it.next();

			if(num.equals(v1.getCbun())){

				System.out.println("\t\t\t\t\t\t   < ������ ���� >");
				System.out.println("===============================================================================================================================");
				System.out.println("                      1.�뿩��  |  2.�ݳ���  |  3.�뿩��  |  4.�뿩�� ����ó  |  5.�뿩��  |  6.���              ");
				System.out.println("===============================================================================================================================");

				ch = sc.nextInt();

				switch(ch) {

				case 1:
					System.out.print("\t �뿩�� ex[yyyy-mm-dd] |  ");
					str = sc.next();
					v1.setStartday(str);
					System.out.println("\t <��> �����Ǿ����ϴ�!");
					System.out.println();
					break;
				case 2:
					System.out.print("\t�ݳ��� ex[yyyy-mm-dd] |  ");
					str = sc.next();
					v1.setEndday(str);
					System.out.println("\t <��> �����Ǿ����ϴ�!");
					System.out.println();
					break;
				case 3:
					System.out.print("\t �̸� |  ");
					str = sc.next();
					v1.setName(str);
					System.out.println("\t <��> �����Ǿ����ϴ�!");
					System.out.println();
					break;
				case 4:
					System.out.print("\t ����ó ex[010-0000-0000] |  ");
					str = sc.next();
					v1.setTel(str);
					System.out.println("\t <��> �����Ǿ����ϴ�!");
					System.out.println();
					break;
				case 5:
					System.out.print("������ �뿩�� ex[00,000]  | ");
					str = sc.next();
					v1.setPrice(str);
					System.out.println("\t <��> �����Ǿ����ϴ�!");
					System.out.println();
					break;
				case 6:
					return;
				}
			}
		}


		Iterator<RentVO> iter = clientLists.iterator();

		while(iter.hasNext()){//������ ����

			RentVO v2 = iter.next();

			if(num.equals(v2.getCbun())){
				if(ch==1)
					v2.setStartday(str);
				else if(ch==2)
					v2.setEndday(str);
				else if(ch==3)
					v2.setName(str);
				else if(ch==4)
					v2.setTel(str);
				else if(ch==5)
					v2.setPrice(str);				
			}	
		}

		try {
			FileOutputStream fos = new FileOutputStream(carFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(lst);

			fos.close();
			oos.close();

			FileOutputStream foos = new FileOutputStream(clientFile);
			ObjectOutputStream ooos = new ObjectOutputStream(foos);

			ooos.writeObject(clientLists);

			foos.close();
			ooos.close();



		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	@Override
	public void carDel() {//���� ����

		String num;
		boolean flag = false;

		ArrayList<RentVO> lst = new ArrayList<RentVO>();


		try {
			FileInputStream fis = new FileInputStream(carFile);
			ObjectInputStream ois = new ObjectInputStream(fis);

			lst = (ArrayList<RentVO>) ois.readObject();

			do{
				flag=true;
				Iterator<RentVO> it = lst.iterator();
				System.out.println();
				System.out.print("������ ������ȣ: ");
				num = sc.next();

				while(it.hasNext()){

					RentVO vt = it.next();

					if(num.equals(vt.getCbun())){
						if(vt.getEndday().trim().equals("-")){
							lst.remove(vt);

							System.out.println("\n�ƻ��� �Ϸ��\n");

							flag=true;
							break;

						}else{

							System.out.println("\n�ƻ����Ұ�! ����� �����Դϴ٢�\n");

							flag=false;
						}				
					}else{
						flag=false;
					}
				}
			}while(flag==false);

		} catch (Exception e) {
			System.out.println("\n�ƿ���: �������� �ʴ� ������ȣ��\n");
		}

		try {

			FileOutputStream fos = new FileOutputStream(carFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(lst);

			oos.close();
			fos.close();

		} catch (Exception e) {

			System.out.println("\n�ƿ���: ���� �Ұ��ɢ�\n");

		}

	}

	@Override
	public void carPrint() {//��ü ���� ��ȸ

		ArrayList<RentVO> lst = new ArrayList<RentVO>();

		try {

			FileInputStream fis = new FileInputStream(carFile);
			ObjectInputStream ois = new ObjectInputStream(fis);

			lst = (ArrayList<RentVO>) ois.readObject();

			Iterator<RentVO> it = lst.iterator();

			System.out.println();
			System.out.println("                                                     �� ��ü ���� ��� ��                                                     ");
			System.out.println("===============================================================================================================================");
			System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |    �뿩��    |    �ݳ���    | �뿩�� | �뿩�� | �޴��� ��ȣ ");
			System.out.println("===============================================================================================================================");

			while(it.hasNext()){

				RentVO vo = it.next();
				System.out.println(vo.toSrtingAdmin());
			}	
			System.out.println();
			System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
		}	
	}


	public void carRes(String Scar) {//���������� ������������ ���� 

		Iterator<RentVO> it = lst.iterator();
		while(it.hasNext()){

			RentVO v1 = it.next();

			if(Scar.equals(v1.getCbun())){

				v1.setStartday(vo.getStartday());
				v1.setEndday(vo.getEndday());
				v1.setName(vo.getName());
				v1.setTel(vo.getTel());
			}
		}
		try {

			FileOutputStream fos = new FileOutputStream(carFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(lst);

			oos.close();
			fos.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void carWrite(String Scar){//�����Ͽ� �� ���� ��������

		Iterator<RentVO> it = lst.iterator();

		while(it.hasNext()){
			RentVO v1 = it.next();

			if(Scar.equals(v1.getCbun())){
				vo.setCbun(v1.getCbun());
				vo.setCmanu(v1.getCmanu());
				vo.setCname(v1.getCname());
				vo.setCsize(v1.getCsize());
				vo.setCcolor(v1.getCcolor());
				vo.setCseat(v1.getCseat());
				vo.setCfuel(v1.getCfuel());

			}	
		}	
	}

	public void resDel(String name, String tel){//������ҽ� ���������� ������ ���� ����

		Iterator<RentVO> it = lst.iterator();

		while(it.hasNext()){
			RentVO v1 = it.next();

			if(name.equals(v1.getName())&&tel.equals(v1.getTel())){
				v1.setStartday("    -     ");
				v1.setEndday("    -     ");
				v1.setName("   -   ");
				v1.setTel("       -      ");
			}	
		}

		try {

			FileOutputStream fos = new FileOutputStream(carFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(lst);

			oos.close();
			fos.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public void carPic(){
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�Ƣơ��������ƢƢƢơ��ơ��ƢƢƢƢƢƢơ������������ƢƢƢƢƢơ�����������ƢƢơ��ƢƢƢ�");
		System.out.println("�Ƣơ��������ƢƢƢơ��ơ��ƢƢƢƢƢƢơ������������ƢƢƢƢƢơ�����������ƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢơ��ƢƢƢơ��ơ��ƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢơ��ƢƢƢơ��ơ��ƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢơ��ƢƢƢơ��ơ��ƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢơ��ƢƢƢơ��ơ��ƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢơ��ƢƢƢ�");
		System.out.println("�Ƣơ��������ƢƢƢơ��ơ��ƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢơ��ƢƢƢ�");
		System.out.println("�Ƣơ��������ƢƢƢơ��ơ��ƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢơ��ƢƢƢ�");
		System.out.println("�Ƣơ��ƢƢƢƢƢƢƢƢƢơ��ơ��ƢƢƢƢƢƢơ������������ƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢơ��ƢƢƢ�");
		System.out.println("�Ƣơ��ƢƢƢƢƢƢƢơ����ơ��ƢƢƢƢƢƢơ������������ƢƢƢƢƢơ�����������ƢƢơ��ƢƢƢ�");
		System.out.println("�Ƣơ��ƢƢƢƢƢƢƢơ����ơ��ƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�����������ƢƢơ������");
		System.out.println("�Ƣơ��ƢƢƢƢƢƢƢƢƢơ��ơ��ƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ���ƢƢơ������");
		System.out.println("�Ƣơ��ƢƢƢƢƢƢƢƢƢơ��ơ��ƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ���ƢƢơ��ƢƢƢ�");
		System.out.println("�Ƣơ��������ƢƢƢơ��ơ��ƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ���ƢƢƢơ��ƢƢƢ�");
		System.out.println("�Ƣơ��������ƢƢƢơ��ơ��ƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ���ƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ơ��ƢƢƢƢƢƢơ������������ƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ơ��ƢƢƢƢƢƢơ������������ƢƢƢƢƢƢƢƢƢƢƢơ���ƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ���ƢƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ���ƢƢƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢơ�������������ƢƢƢƢơ������������������ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢơ�������������ƢƢƢƢơ������������������ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�ơ�Ƣơ����������ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��������ƢƢơ�ơ�ƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢơ�ơ�ƢƢƢƢơ�Ƣơ�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�Ƣơ�ƢƢƢƢơ�ơ�ƢƢƢơ�ƢƢƢơ�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�ƢƢƢơ�Ƣơ���ơ�ƢƢơ�ƢƢƢƢƢơ�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�ƢƢƢƢƢơ�ƢƢơ�ơ�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�ƢƢƢƢƢƢƢơ�Ƣơ�ơ�Ƣơ����������ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�ơ�ƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�ơ�ƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ����������������������ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ����������������������ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�Ƣ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢơ�������������������������������ƢƢƢƢƢƢƢƢƢƢƢƢƢơ�ơ�ơ�Ƣ�");
		System.out.println("�ƢƢƢƢƢƢƢơ������������������������������������ƢƢƢƢƢƢƢƢƢơ�ƢƢơ�ƢƢƢƢ�");
		System.out.println("�ƢƢƢƢơ�������ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢƢƢƢơ��ơ��ƢƢƢƢơ��");
		System.out.println("�ƢƢơ�����ƢƢƢƢƢơ����ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢƢơ��ƢƢơ�ƢƢƢơ�ƢƢ�");
		System.out.println("�Ƣơ���ƢƢƢƢƢƢƢƢơ����ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ��ƢƢƢơ�ơ�ơ�ƢƢƢơ�ƢƢƢƢ�");
		System.out.println("�Ƣơ��ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�����ƢƢƢơ�Ƣơ�ƢƢƢƢơ�Ƣ�");
		System.out.println("�Ƣơ��ƢƢƢơ����ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ����ƢƢơ�����ơ��ƢƢơ�Ƣơ�ơ�����");
		System.out.println("�Ƣơ��ƢƢơ�ƢƢƢơ�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�ƢƢƢơ�Ƣơ��ƢƢƢƢƢơ���ơ�Ƣơ���ơ��");
		System.out.println("�Ƣơ��Ƣơ�ƢƢƢƢƢơ�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�ƢƢƢƢƢơ�ơ��ƢƢƢƢƢƢƢƢơ����ơ�ƢƢƢ�");
		System.out.println("�Ƣơ��Ƣơ�ƢƢƢƢƢơ�Ƣơ����������������Ƣơ�ƢƢƢƢƢơ�ƢƢƢƢƢƢƢƢƢơ�ƢƢơ���ơ�ƢƢ�");
		System.out.println("�ƢƢƢƢƢơ�ƢƢƢƢƢơ�Ƣơ����������������Ƣơ�ƢƢƢƢƢơ�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�ƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢơ�ƢƢƢơ�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ�ƢƢƢơ�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢơ����ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢơ����ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��");
		System.out.println("���Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣ�");
		System.out.println("�Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��");
		System.out.println("���Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣơ��Ƣ�");
		System.out.println("                                                                                                            ������-������-�贩��");
	}
	




	@Override
	public void run() { //������

		String str = ". . . . . . . . .  ";
		String str2 = "(*'��'*)/";
		int i = 0;


		while(i<str.length()){
			System.out.print(str.substring(i, i+1));
			i++;

			try {
				Thread.sleep(100);

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}   

		System.out.println(str2);


		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void carSearch() {//���ǿ� ���� ���డ�� ���� ��ȸ

		String view=null;//��ü����

		while(true){
			System.out.println("===============================================================================================================================");
			System.out.println("             1.������  |  2.���� ����  |  3.���� ž�� �����ο�  |  4.���Ằ  |  5.��ü �ڵ���  |  6.����ȭ������               ");
			System.out.println("===============================================================================================================================");
			System.out.print("�� ");
			int ch = sc.nextInt();

			switch(ch){

			case 1:
				seeManu();
				break;

			case 2:
				seeColor();
				break;

			case 3:
				seeSeat();
				break;

			case 4:
				seeFuel();
				break;

			case 5:
				System.out.println("���� ���� �ڵ��� ������ ����մϴ�");
				allView(view);
				break;

			case 6:
				return;

			}while(ch<1||ch>7);
		}


	}

	public void seeManu(){

		String manu;
		boolean flag=false;

		String[] man = {"HYU","SHV","KIA","VWK","SSY","BEN"};

		System.out.println("���� ���忡���� ����(HYU),���(KIA),�����ٰ�(VWK),������(SHV),�ֿ�(SSY)������ �غ�Ǿ� �ֽ��ϴ�.");


		do{
			flag=false;
			System.out.println();
			System.out.println("ã���ô� �����縦 �����ڷ� �Է����ּ���");
			System.out.print("�� ");
			manu=sc.next();

			for(int i=0;i<man.length;i++){

				if(manu.trim().equals(man[i])){
					flag=true;		
					break;		
				}
			}
			if(!(manu.trim().length()==3)){

				System.out.println("\n�Ʊ��ڼ��� 3�ڸ��� �Է����ּ����\n");

				flag=false;
				//System.out.println("���ϴ� ������ �ٽ� �Է����ּ���");
				//color = sc.next();
			}
		}while(flag==false);


		do{	
			System.out.println();
			System.out.println("===========================================================================");
			System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ����   ");
			System.out.println("===========================================================================");

			flag=false;

			Iterator<RentVO> it = lst.iterator();
			while(it.hasNext()){

				RentVO rent = it.next();			

				if(rent.getStartday().trim().equals("-")){

					if(rent.getCmanu().equals(manu)){

						System.out.println(rent.toStringCar());
						flag=true;

					}

				}else{
					if(rent.getCmanu().equals(manu)){
						flag=true;
					}
				}

			} if(flag==false)	
				
				System.out.println("\n�������簡 �������� �ʽ��ϴ٢�\n");
				

		}while(flag==false);    
		System.out.println();
	}


	public void seeColor(){

		String color;
		boolean flag=false;

		String[] col = {"����","���","�Ķ�","���","����","���","����","����","�챸","����"};

		System.out.println("���� ���忡�� ����, ���, �Ķ� ,��� ,���� ,��� ,���� ,���� ,�챸 , ������ ������ �غ�Ǿ� �ֽ��ϴ�.");


		do{
			flag=false;
			System.out.println();
			System.out.println("������ �Է��ϼ���");
			System.out.print("�� ");
			color=sc.next();

			for(int i=0;i<col.length;i++){

				if(color.trim().equals(col[i])){
					flag=true;		
					break;		
				}
			}
			if(!(color.trim().length()==2)){
				System.out.println("\n�Ʊ��ڼ��� 2�ڸ��� �Է����ּ����\n");

				flag=false;
				//System.out.println("���ϴ� ������ �ٽ� �Է����ּ���");
				//color = sc.next();
			}
		}while(flag==false);


		do{
			System.out.println();
			System.out.println("===========================================================================");
			System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ����   ");
			System.out.println("===========================================================================");

			flag=false;

			Iterator<RentVO> it = lst.iterator();
			while(it.hasNext()){//����Ʈ���� ���� ���� ������ ������

				RentVO rent = it.next();			

				if(rent.getStartday().trim().equals("-")){

					if(rent.getCcolor().equals(color)){

						System.out.println(rent.toStringCar());
						flag=true;

					}

				}else {
					if(rent.getCcolor().equals(color)){

						flag=true;
					}
				}

			} if(flag==false)	

				System.out.println("\n�ƻ����� �������� �ʽ��ϴ٢�\n");	


		}while(flag==false);
		System.out.println();
	}


	public void seeSeat(){

		String seat;
		boolean flag=false;

		String[] sea = {"2�ν�","4�ν�","5�ν�","6�ν�","7�ν�","9�ν�"};

		System.out.println("���� ���忡���� 2�ν�, 4�ν�, 5�ν�, 6�ν�, 7�ν�, 9�ν��� ������ �غ�Ǿ� �ֽ��ϴ�.");


		do{
			flag=false;
			System.out.println();
			System.out.println("ã���ô� ������ �¼����� �Է����ּ���");
			System.out.print("�� ");
			seat=sc.next();

			for(int i=0;i<sea.length;i++){

				if(seat.trim().equals(sea[i])){
					flag=true;		
					break;		
				}
			}
			if(!(seat.trim().length()==3)){
				
				System.out.println("\n�Ʊ��ڼ��� 3�ڸ��� �Է����ּ����\n");
				
				flag=false;
				//System.out.println("���ϴ� ������ �ٽ� �Է����ּ���");
				//color = sc.next();
			}
		}while(flag==false);


		do{
			System.out.println();
			System.out.println("===========================================================================");
			System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ����   ");
			System.out.println("===========================================================================");

			flag=false;

			Iterator<RentVO> it = lst.iterator();
			while(it.hasNext()){

				RentVO rent = it.next();			

				if(rent.getStartday().trim().equals("-")){

					if(rent.getCseat().equals(seat)){

						System.out.println(rent.toStringCar());
						flag=true;
					}

				}else{
					if(rent.getCseat().equals(seat)){
						flag=true;
					}
				}

			} if(flag==false){
				System.out.println("\n�������� �������� �ʽ��ϴ٢�\n");	
				
			}
		}while(flag==false);    
		System.out.println();
	}
	
	public void seeFuel(){

		String fuel;
		boolean flag=false;

		String[] fue = {"����","����","����","�ֹ�","����","����","����"};

		System.out.println("���� ���忡���� ����,����,����,����(�긮��),�ֹ�,������ ������ �غ�Ǿ� �ֽ��ϴ�.");


		do{
			flag=false;
			System.out.println();
			System.out.println("ã���ô� ������ ����Ÿ���� 2�ڸ��� �Է����ּ���");
			System.out.print("�� ");
			fuel=sc.next();

			for(int i=0;i<fue.length;i++){

				if(fuel.trim().equals(fue[i])){
					flag=true;		
					break;		
				}
			}
			if(!(fuel.trim().length()==2)){
				System.out.println("\n�Ʊ��ڼ��� 2�ڸ��� �Է����ּ����\n");
				
				flag=false;
				//System.out.println("���ϴ� ������ �ٽ� �Է����ּ���");
				//color = sc.next();
			}
		}while(flag==false);


		do{
			System.out.println();
			System.out.println("===========================================================================");
			System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ����   ");
			System.out.println("===========================================================================");

			flag=false;

			Iterator<RentVO> it = lst.iterator();
			while(it.hasNext()){

				RentVO rent = it.next();			

				if(rent.getStartday().trim().equals("-")){

					if(rent.getCfuel().equals(fuel)){

						System.out.println(rent.toStringCar());
						flag=true;

					}

				}else{
					if(rent.getCfuel().equals(fuel)){
						flag=true;
					}
				}

			} if(flag==false)	
				System.out.println("\n�������� �������� �ʽ��ϴ٢�\n");	

		}while(flag==false);     
		System.out.println();
	}


	public void allView(String view){
		
		System.out.println();
		System.out.println("                       �� ���డ�� ��ü���� ��� ��                        ");
		System.out.println("===========================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ����   ");
		System.out.println("===========================================================================");

		Iterator<RentVO>it = lst.iterator();

		while(it.hasNext()){//����Ʈ���� ������ ��ü������ ������
			RentVO rent =it.next();

			if(rent.getStartday().trim().equals("-")){
				System.out.println(rent.toStringCar());
			}
		}
	}

}



