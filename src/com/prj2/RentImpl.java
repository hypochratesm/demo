package com.prj2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RentImpl implements Rent, Runnable{

	RentDAO rentDAO = new RentDAO();

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);	

	private static final String Id="admin";
	private static final String Password="a123b";

	String startDay, endDay;

	List<String> getCarInfoLists = new ArrayList<String>();
	List<CarDTO> printLists = new ArrayList<CarDTO>();


	//1.�����ϱ�
	@Override
	public void input() {

		CustomDTO cusDTO = new CustomDTO();

		Calendar now = Calendar.getInstance();
		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH)+1;
		int d = now.get(Calendar.DATE);	

		String today = Integer.toString(y) +"-"+ Integer.toString(m) +"-"+ Integer.toString(d);

		int ch;
		int cnt;	//diffOfdate�޼ҵ� ��ȯ�� �����޴� ����

		boolean flag = false;

		try {

			do{

				System.out.println("=========== ��¥ ���� ===========");
				System.out.print("�뿩��? [ex.yyyy-mm-dd]");
				startDay = sc.next();
				cusDTO.setStartday(startDay);
				cnt = 0;
				cnt = diffOfDate(today, startDay);


			}while(cnt==-1);


		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("\n�Ƴ�¥�� �ٽ� �Է����ּ����");
			System.out.println();
			return;
		}

		try {

			do{
				System.out.print("�ݳ���? [ex.yyyy-mm-dd]");
				endDay = sc.next();
				cusDTO.setEndday(endDay);
				cnt = 0;	
				cnt = diffOfDate(startDay,endDay);


			}while(cnt<1);

		} catch (Exception e) {

			System.out.println("\n�Ƴ�¥�� �ٽ� �Է����ּ����");
			System.out.println();
			return;
		}

		System.out.println();
		System.out.println();
		System.out.print("\t�� �� �� ");

		Thread t1 = new Thread(new RentImpl());	//������
		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			System.out.println(e.toString());
		}


		//���� ������ ���� ����Ʈ �˻� �� ���
		posiCar();

		System.out.println("===========================================================================");
		System.out.println();
		System.out.println("    �������� �����ϼ���");

		do{
			System.out.print("    ���� ��ȣ: ");
			String select = sc.next();
			cusDTO.setCarNum(select);

			if(printLists.size()==0){
				break;
			}

			Iterator<CarDTO> carIt = printLists.iterator();

			flag = false;

			while(carIt.hasNext()){

				CarDTO rent = carIt.next();

				if(select.equals(rent.getCarNum())) {
					flag = true;

				}
			}
			if(flag==false){

				System.out.println("\n����Ȯ�� ������ȣ�� �Է��ϼ����");
				System.out.println();
			}

		}while(flag==false);

		System.out.println("=========== ���� ���� ==========");
		System.out.printf("��������ȣ: %s\n�Ѹ𵨸�: %s\n",cusDTO.getCarNum(),rentDAO.getCarModel(cusDTO.getCarNum()));

		int dif = diffOfDate(startDay, endDay);
		System.out.printf("�Ѵ뿩�Ⱓ: %d��\n", dif);

		cusDTO.setTotprice(rentDAO.getTotPrice(cusDTO.getCarNum(), dif));
		System.out.printf("���� �뿩���: %,3d��\n", cusDTO.getTotprice());


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
						cusDTO.setInsure("������å");
						break;
					case 2:
						cusDTO.setInsure("�Ϲݸ�å");
						break;
					case 3:
						cusDTO.setInsure("���Ծ���");
						break;
					}

				}while(ch<1||ch>3);

			}

		} catch (java.util.InputMismatchException e) {

			System.out.println("\n�Ƽ��ڷ� �Է��� �ּ����");
			System.out.println();
		}

		while(true) {

			Pattern pBirth = Pattern.compile("\\d{4}-\\d{2}-\\d{2}$");
			Pattern pEmail = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
			Pattern pTel = Pattern.compile("^\\d{2,3}-\\d{3,4}-\\d{4}$");
			Matcher matBirth;
			Matcher matEmail;
			Matcher matTel;


			System.out.println();
			System.out.println("======== ������ ���� �Է� ========");

			System.out.print("�̸�: ");
			cusDTO.setName(sc.next());
			do {	
				System.out.print("�������[YYYY-MM-DD]: ");
				String birth = sc.next();
				matBirth = pBirth.matcher(birth);
				cusDTO.setBirth(birth);
			}while(!matBirth.matches());


			do{
				flag = false;
				System.out.print("����ó: ");
				cusDTO.setTel(sc.next());
				matTel = pTel.matcher(cusDTO.getTel());


				//DB���� ����ó �ߺ��˻� checkTel(��ȭ��ȣ)
				//true�� �Ѿ���� �ߺ��� ����ó		
				if(rentDAO.checkTel(cusDTO.getTel())){
					System.out.println("�ߺ��� ����ó �Դϴ�..!! �ٽ� �Է����ּ���!");
				}

			}while(!matTel.matches() || flag==true); 

			do {
				System.out.print("�̸���: ");
				String email = sc.next();
				matEmail = pEmail.matcher(email);
				cusDTO.setEmail(email);

			}while(!matEmail.matches());

			try {
				System.out.println();
				System.out.println();

				System.out.println("======== ������ ���� Ȯ�� ========");
				System.out.println("���̸�: "+cusDTO.getName());
				System.out.println("�ѻ������: "+cusDTO.getBirth());
				System.out.println("�ѿ���ó: "+cusDTO.getTel());
				System.out.println("���̸���: "+cusDTO.getEmail());
				System.out.println();
				System.out.println("** �Է��Ͻ� ������ �½��ϱ�?");
				System.out.println("** 1.Ȯ�� 2.�ٽ��Է� ");
				System.out.print("�� ");
				ch = sc.nextInt();

				if(ch==1){
					break;
				}

			} catch (Exception e) {
				System.out.println("\n�� �ٽ� �Է��� �ּ���! ��\n");
			}

		}

		System.out.println();
		System.out.println("============ ���� ���� ===========");
		System.out.println("���̸�: "+cusDTO.getName());
		System.out.println("�ѻ������: "+cusDTO.getBirth());
		System.out.println("�ѿ���ó: "+cusDTO.getTel());
		System.out.println("���̸���: "+cusDTO.getEmail());
		System.out.println("----------------------------------");
		System.out.println("�Ѵ뿩��: "+cusDTO.getStartday());
		System.out.println("�ѹݳ���: "+cusDTO.getEndday());
		System.out.printf("���� �뿩���: %,3d��",cusDTO.getTotprice());
		System.out.println();
		System.out.println("==========================================================================");
		System.out.println("           ������ȣ | ������ |    �𵨸�  | ���� | ���� | ž���ο� | ���� ");
		System.out.println("==========================================================================");
		System.out.println("��������: "+ rentDAO.printSelectCar(cusDTO.getCarNum()));
		System.out.println();
		System.out.println("��������: "+cusDTO.getInsure());
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

		try {

			if(ch==1){

				System.out.print("\t�� �� �� �� �� ");

				Thread t2 = new Thread(new RentImpl());	//������
				t2.start();
				try {
					t2.join();
				} catch (Exception e) {
					System.out.println(e.toString());
				}

				//�����ȣ ����
				String bkNum = rentDAO.createBookingNo();

				//DB�� �������� ����
				int recheck1 = rentDAO.insertRescar(cusDTO, bkNum);
				int recheck2 = rentDAO.insertCustomer(cusDTO, bkNum);

				if(recheck1==1 && recheck2==1) {
					System.out.println("\n\t�� ���� ����! ��");
					System.out.println();
					System.out.println();
				}

			}
			else{

				System.out.println("\n\t�ƿ����� ����Ͽ����ϴ٢�");
				System.out.println();
				return;
			}

		} catch (Exception e) {
			System.out.println("\n\t�ƿ��࿡ �����Ͽ����ϴ�. �ٽ� �õ����ּ����");
			System.out.println();
		}

	}//end...input()


	@Override
	public void posiCar() {
		System.out.println();
		System.out.println();
		System.out.println("                        �� ���డ���� ���� ��� ��");
		System.out.println();

		System.out.println("===========================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ���� ");
		System.out.println("===========================================================================");

		int startY, startM, startD;
		String tempDate1, tempDate2;


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

		List<CustomDTO> daysLists = new ArrayList<CustomDTO>();
		List<CustomDTO> saveDaysLists = new ArrayList<CustomDTO>();
		List<CustomDTO> okRes = new ArrayList<CustomDTO>();

		//DB���� ���೯¥ ��������(����Ʈ�� ��ȯ����)
		daysLists = rentDAO.searchResDate();

		Iterator<CustomDTO> it = daysLists.iterator();

		while(it.hasNext()){

			CustomDTO itDTO = it.next();

			Calendar cal2 = Calendar.getInstance();		

			int dif = diffOfDate(itDTO.getStartday(),itDTO.getEndday());

			String getTemp2[] = new String[3];

			getTemp2 = itDTO.getStartday().split("-");

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

				CustomDTO saveDTO = new CustomDTO();
				saveDTO.setStartday(tempDate2);
				saveDTO.setCarNum(itDTO.getCarNum());

				saveDaysLists.add(saveDTO);
			}
		}				

		for(int i=0;i<dates.length;i++){

			Iterator<CustomDTO> searchIt = saveDaysLists.iterator();

			while(searchIt.hasNext()){
				CustomDTO dto = searchIt.next();

				if(dates[i].equals(dto.getStartday())){

					Iterator<CustomDTO> checkIt = okRes.iterator();


					while(checkIt.hasNext()){

						CustomDTO chDTO = checkIt.next();				

						if(chDTO.getCarNum().equals(dto.getCarNum())){

							break;	
						}

					}
					if(!okRes.contains(dto)){

						okRes.add(dto);//getPrintList���� �Ѱ��� ����Ʈ ����(����Ұ����� ���� ����Ʈ)
					}		
				}

			}
		}

		//DB���� ������ ������ ���������� ������(����Ʈ printLists�� �޾ƿ�)


		if(okRes.size()!=0){

			printLists = rentDAO.getPrintList(okRes);

			System.out.println(printLists.size());


			if(printLists.size()!=0){
				Iterator<CarDTO> printIt = printLists.iterator();

				while(printIt.hasNext()){
					CarDTO printDTO = printIt.next();
					System.out.println(printDTO.toStringCar());
				}
			}
		}

		else{
			List<CarDTO> dtoList = rentDAO.carPrint();

			Iterator<CarDTO> dtoIt = dtoList.iterator();

			while(dtoIt.hasNext()){

				CarDTO carDTO = dtoIt.next();

				System.out.println(carDTO.toStringCar());		

			}
		}


	}//end..posicar()

	//2. ������ȸ
	public void searchRes() {//������ȸ, �������

		int ch=0;
		String str,str1;


		System.out.print("��ȭ��ȣ: ");
		String tel = sc.next();

		if(!rentDAO.checkTel(tel)){
			System.out.println("���೻���� �������� �ʽ��ϴ�");
			return;
		}

		CustomDTO cusdto = rentDAO.selCus(tel);
		String resno = cusdto.getResno();

		AllDTO alldto = rentDAO.selAllDTO(resno);
		String carnum = alldto.getCarNum();

		CarDTO cardto = rentDAO.selCar(carnum);


		System.out.println();
		System.out.println("===========����������==========");
		str = String.format("���� ��ȣ: %s\n�̸�: %s\n����ó: %s\n�������: %s\n�̸���: %s\n�뿩�Ⱓ: %-10s~%10s"
				,cusdto.getResno(),cusdto.getName(),cusdto.getTel(),cusdto.getBirth(),cusdto.getEmail()
				,alldto.getStartDay(),alldto.getEndDay());
		System.out.println(str);
		System.out.println("====================================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ����   |  ����");
		System.out.println("====================================================================================");
		str1 = String.format("%7s %8s %10s %5s %4s %6s %6s   %,3d %6s"
				, cardto.getCarNum(),cardto.getManu(),cardto.getModel()
				,cardto.getType(),cardto.getColor(),cardto.getSeat(),cardto.getFuel(),alldto.getTotPrice(),alldto.getStatus());
		System.out.println(str1);
		System.out.println();
		System.out.printf("���� ����: %s\n",alldto.getInsure());
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
					if(ch2=='Y' || ch2=='y'){

						int result = rentDAO.delres(resno);

						if(result!=0){
							System.out.println();
							System.out.println("������Ͽ����ϴ٢�");
							System.out.println();
						}else{

							System.out.println("����� ����!��");
						}
					}

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		}while(ch<1 || ch>2);		

	}


	//3. ���� �˻�
	@Override
	public void carSearch() {

		while(true){

			System.out.println("===============================================================================================================================");
			System.out.println("       1.��ü����   |  2.������ �˻�  |  3.�������� �˻�  |  4.���� ž�°����ο� �˻�  |  5.���Ằ �˻�  |  6.����ȭ������     ");
			System.out.println("===============================================================================================================================");
			System.out.print("�� ");
			int ch = sc.nextInt();

			switch(ch){

			case 1:
				carPrint();
				break;

			case 2:
				seeManu();
				break;

			case 3:
				seeColor();
				break;

			case 4:
				seeSeat();
				break;

			case 5:
				seeFuel();
				break;

			case 6:
				return;

			}while(ch<1||ch>6);
		}
	}

	//3-2.������˻�
	public void seeManu(){

		String manu;

		System.out.println("���� ���忡���� ����(HYU),���(KIA),�����ٰ�(VWK),������(SHV),�ֿ�(SSY)������ �غ�Ǿ� �ֽ��ϴ�.");
		System.out.println();
		System.out.println("ã���ô� �����縦 �����ڷ� �Է����ּ���");
		System.out.print("�� ");
		manu=sc.next();

		List<CarDTO> lists = rentDAO.seeManu(manu);

		System.out.println("===========================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ����   ");
		System.out.println("===========================================================================");
		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
		System.out.println();
		System.out.println();
	}

	//3-3. ��������˻�
	public void seeColor(){

		String color;

		System.out.println("���� ���忡�� ����, ���, �Ķ�, ���, ����, ���, ����, ����, �챸, ������ ������ �غ�Ǿ� �ֽ��ϴ�.");
		System.out.println();
		System.out.println("������ �Է����ּ���");
		System.out.print("�� ");
		color=sc.next();

		System.out.println();
		System.out.println("===========================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ����   ");
		System.out.println("===========================================================================");
		List<CarDTO> lists = rentDAO.seeColor(color);

		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
		System.out.println();
		System.out.println();
	}


	//3-4. ����ž���ο� �˻�
	public void seeSeat(){

		String seat;
		System.out.println("���� ���忡���� 2�ν�, 4�ν�, 5�ν�, 6�ν�, 7�ν�, 9�ν��� ������ �غ�Ǿ� �ֽ��ϴ�.");
		System.out.println();
		System.out.println("���Ͻô� ž���ο��� �Է��ϼ���");
		System.out.print("�� ");
		seat=sc.next();

		System.out.println();
		System.out.println("===========================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ����   ");
		System.out.println("===========================================================================");

		List<CarDTO> lists = rentDAO.seeSeat(seat);

		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
		System.out.println();
		System.out.println();
	}

	//3-5.���Ằ �˻�
	public void seeFuel(){

		String fuel;

		System.out.println("���� ���忡���� ����,����,����,����(�긮��),�ֹ�,������ ������ �غ�Ǿ� �ֽ��ϴ�.");

		System.out.println("ã���ô� ������ ����Ÿ���� 2�ڸ��� �Է����ּ���");
		System.out.print("�� ");
		fuel=sc.next();
		System.out.println();
		System.out.println("===========================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ����   ");
		System.out.println("===========================================================================");
		List<CarDTO> lists = rentDAO.seeFuel(fuel);

		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
		System.out.println();
		System.out.println();
	}



	//4.������ �α���
	@Override
	public void admin() {

		boolean flag = false;

		/*		String id = null;
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
		System.out.println();*/


		//4.�����ڸ��
		while(true){

			System.out.println("===============================================================================================================================");
			System.out.println("      1.�뿩/�ݳ� |  2.����������ȸ  |  3.�����������  |  4.����������  |  5.������������  |  6.������Ȳ  |  7.��������     ");
			System.out.println("===============================================================================================================================");
			System.out.print("�� ");
			int ch = sc.nextInt();

			switch(ch){	

			case 1: 
				inOut();
				break;
			case 2:
				carPrint();
				break;
			case 3:
				carInfo();
				break;
			case 4:
				carUpdt();
				break;
			case 5:
				carDel();
				break;
			case 6:
				allSearch();
				break;
			case 7:
				return;	
			}

		}

	}

	//4-1.�뿩, �ݳ� �޴�
	public void inOut(){

		int ch;
		List<AllDTO> lst = new ArrayList<AllDTO>();
		lst = rentDAO.searchAllRes();

		Iterator<AllDTO> it = lst.iterator();

		System.out.println();
		System.out.println("                                                �ƿ��� ���� ��Ϣ�                                                 ");
		while(it.hasNext()){

			AllDTO dto = it.next();
			System.out.println(dto.toString());		
		}
		System.out.println();

		do{
			System.out.println("=============================");
			System.out.println("     1.�뿩   |   2.�ݳ�         ");
			System.out.println("=============================");

			ch = sc.nextInt();

		}while(ch<1 || ch>2);

		if(ch==1){
			statRent();
		}
		else{
			statRetr();
		}

	}

	//4-1. �뿩������ ��ȯ
	public void statRent(){

		String resno;
		int rs;

		do{
			System.out.print("�ٲ� �����ȣ: ");
			resno = sc.next();

			rs = rentDAO.chkRes(resno);
			if(rs!=0){
				break;
			}else{
				System.out.println();
				System.out.println("���������� �ʴ� �����ȣ �Դϴ٢�");
				System.out.println();
			}		

		}while(rs==0);

		rentDAO.statRent(resno);


	}


	//4-1. ���������� �ݳ� ó����
	public void statRetr(){

		System.out.print("�ݳ��� �����ȣ: ");
		String resno = sc.next();

		AllDTO allDTO = rentDAO.getList(resno);

		int result = rentDAO.insertData(allDTO);
		int result2 = rentDAO.deleteData(resno);

		if(result!=0&&result2!=0){
			System.out.println("\t <��> �ݳ� �Ϸ�!");
			System.out.println();
		}

		else{
			System.out.println("\t <!> ��ȯ ����!");
			System.out.println();
		}

	}

	//4-2.��ü ������ȸ
	@Override
	public void carPrint() {

		List<CarDTO> dtoList = rentDAO.carPrint();

		Iterator<CarDTO> dtoIt = dtoList.iterator();
		System.out.println("                           �� ��ü ���� ���  ��                           ");
		System.out.println("===========================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� |   ����   ");
		System.out.println("===========================================================================");

		while(dtoIt.hasNext()){

			CarDTO carDTO = dtoIt.next();

			System.out.println(carDTO.toStringCar());		

		}
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println();

	}

	//4-3. ���� ���� ���

	@Override
	public void carInfo() {//���� ���� �Է�


		//�Է��ϴ� �������� ������ 8��.
		//carnum :������ȣ
		//manu:������
		//model:���� �̸�
		//type :���� ����
		//color: ���� �÷�
		//seat : ������ ž�� ������ �ο�
		//fuel : ����
		//price : �Ϸ� �뿩��

		CarDTO dto1 =new CarDTO();

		System.out.println("������ȣ?");
		dto1.setCarNum(sc.next());

		System.out.println("������?");
		dto1.setManu(sc.next());

		System.out.println("�𵨸�?");
		dto1.setModel(sc.next());

		System.out.println("���� ����?");
		dto1.setType(sc.next());

		System.out.println("�����÷�?");
		dto1.setColor(sc.next());

		System.out.println("ž���ο�?");
		dto1.setSeat(sc.next());

		System.out.println("����?");
		dto1.setFuel(sc.next());

		System.out.println("�뿩��/1��?");
		dto1.setPrice(sc.nextInt());

		int result = rentDAO.carInfo(dto1);

		if(result!=0){
			System.out.println("�߰�����");	
		}else
			System.out.println("�߰�����");

	}



	//4-4.��������� ����
	@Override
	public void carUpdt() {//������ ������ ����


		RentDAO dao = new RentDAO();
		String str;


		CustomDTO cusdto = new CustomDTO();


		System.out.print("\t ������ ������ �����ȣ�� �Է��ϼ��� ");
		cusdto.setResno(sc.next());

		System.out.print("\t �̸�?");
		cusdto.setName(sc.next());

		System.out.print("\t ����?");
		cusdto.setBirth(sc.next());

		System.out.print("\t �̸���");
		cusdto.setEmail(sc.next());

		int result = dao.carUpdt(cusdto);

		if(result!=0){
			System.out.println();
			System.out.println("�� ���� �Ϸ� ��");
			System.out.println();
		}else{
			System.out.println();
			System.out.println("\t <!> �������� �ʴ� �����ȣ!");
			System.out.println();

		}
	}

	//4-5.�������� ����
	@Override
	public void carDel() {


		System.out.print("\t ������ ���� �ѹ�?");
		String carNum = sc.next();

		int result = rentDAO.carDel(carNum);

		if(result!=0){
			System.out.println();
			System.out.println("\t�ƻ��� ������");
			System.out.println();

		}else{
			System.out.println();
			System.out.println("\t�ƻ��� ���Т�");
			System.out.println();
		}

	}


	//��ü ������ ��ȸ
	@Override
	public void allSearch() {

		AllDTO allDTO = new AllDTO();

		List<AllDTO> allSearchList = rentDAO.searchAllRes();

		Iterator<AllDTO> printIt = allSearchList.iterator();

		System.out.println("                                                ��    ��ü ������ ���    ��                                                  ");
		System.out.println("===============================================================================================================================");
		System.out.println("   �����ȣ | ������ȣ | ������ |   ����   |  �̸�  |     ����ó     |   �뿩��   |   �ݳ���   |   ����   |  �뿩��  |  ���� ");
		System.out.println("===============================================================================================================================");

		while(printIt.hasNext()){

			AllDTO dto = printIt.next();
			System.out.println(dto.toString());
		}
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

	}//end...run()


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



}//end...class




