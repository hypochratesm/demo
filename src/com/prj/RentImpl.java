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

	public RentImpl(){	//생성자

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
				System.out.println("=========== 날짜 선택 ===========");
				System.out.print("대여일? [ex.yyyy-mm-dd]");
				startDay = sc.next();
				cnt1 = diffOfDate(today, startDay);
				vo.setStartday(startDay);

			}while(cnt1==-1);


		} catch (Exception e) {

			System.out.println("\n▒날짜를 다시 입력해주세요▒");
			System.out.println();
			return;
		}

		try {

			do{
				System.out.print("반납일? [ex.yyyy-mm-dd]");
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

			System.out.println("\n▒날짜를 다시 입력해주세요▒");
			System.out.println();
			return;
		}

		while(true){

			System.out.println();
			System.out.println();
			System.out.print("\t검 색 중  ");

			Thread t1 = new Thread(new RentImpl());	//쓰레드
			t1.start();
			try {
				t1.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("\t검 색 완 료 !");

			System.out.println();
			System.out.println();
			System.out.println("                        ▒ 예약가능한 차량 목록 ▒");
			posiCar();
			System.out.println("===========================================================================");
			System.out.println("    ▷차량을 선택하세요");

			do{
				System.out.print("    차량 번호: ");
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

					System.out.println("\n▒정확한 차량번호를 입력하세요▒");
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
					System.out.println("=========== 차량 선택 ==========");
					System.out.printf("☞차량번호: %s\n☞모델명: %s\n",vo.getScar(),rent.getCname());
					break;
				}
			}
			int dif = diffOfDate(startDay, endDay);
			System.out.printf("☞대여기간: %d일\n", dif);

			Iterator<RentVO> it2 = lst.iterator();
			while(it2.hasNext()){
				RentVO rent = it2.next();
				if(vo.getScar().equals(rent.getCbun())) {
					int price = replacePrice(rent.getPrice());
					System.out.printf("☞총 대여비용: %,3d원\n", dif*price);
					System.out.println();					
					vo.setSprice(dif*price);
					break;
				}
			}
			try {
				do {
					System.out.println("1.다음단계로  2.다시선택");
					System.out.print("▷ ");
					ch = sc.nextInt();

				}while(ch<1 || ch>2);

				if(ch==1){

					do{
						System.out.println();
						System.out.println("============================= 면책 제도 선택 ==============================");
						System.out.println("1.완전면책 : 면책한도(500만원)까지 고객 부담금 없음");
						System.out.println("2.일반면책 : 면책한도(500만원)까지 자기부담금 30만원 + 휴차보상료 부담");
						System.out.println("3.가입안함 : 수리비전액 + 휴차보상료 자기부담");
						System.out.println();
						System.out.print("면책 제도를 선택하세요 ▷ ");
						try {

							ch = sc.nextInt();

						} catch (Exception e) {

							System.out.println("\n▒숫자로 입력해 주세요▒");
							System.out.println();
						}


						switch(ch){
						case 1:
							vo.setInsure("완전면책");
							break;
						case 2:
							vo.setInsure("일반면책");
							break;
						case 3:
							vo.setInsure("가입안함");
							break;
						}

					}while(ch<1||ch>3);

					break;
				}

			} catch (java.util.InputMismatchException e) {

				System.out.println("\n▒숫자로 입력해 주세요▒");
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
			System.out.println("======== 예약자 정보 입력 ========");

			System.out.print("이름: ");
			vo.setName(sc.next());
			do {	
				System.out.print("생년월일[yyyymmdd]: ");
				String b = sc.next();
				matBirth = pBirth.matcher(b);
				vo.setBirth(b);
			}while(!matBirth.matches());


			do{
				System.out.print("연락처: ");
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
						System.out.println("\n▒연락처를 다시 확인해주세요▒");
						System.out.println("\n▒양식에 맞지 않거나 중복되었습니다▒");
						break;	
					}						
				}



			}while(flag==false); 

			do {
				System.out.print("이메일: ");
				String email = sc.next();
				matEmail = pEmail.matcher(email);
				vo.setEmail(email);

			}while(!matEmail.matches());

			try {
				System.out.println();
				System.out.println();

				System.out.println("======== 예약자 정보 확인 ========");
				System.out.println("☞이름: "+vo.getName());
				System.out.println("☞생년월일: "+vo.getBirth());
				System.out.println("☞연락처: "+vo.getTel());
				System.out.println("☞이메일: "+vo.getEmail());
				System.out.println();
				System.out.println("** 입력하신 내용이 맞습니까?");
				System.out.println("** 1.확인 2.다시입력 ");
				System.out.print("▷ ");
				ch = sc.nextInt();

				if(ch==1){
					break;
				}
			} catch (Exception e) {
				System.out.println("\n▒숫자로 입력해 주세요▒\n");
			}

		}

		System.out.println();
		System.out.println("============ 예약 내용 ===========");
		System.out.println(vo.toStringClient());
		System.out.println("----------------------------------");
		System.out.println("☞대여일: "+vo.getStartday());
		System.out.println("☞반납일: "+vo.getEndday());
		System.out.println();
		System.out.println("===================================================================================");
		System.out.println("           차량번호 | 제조사 |    모델명  | 차종 | 색상 | 탑승인원 | 연료 |  가격 ");
		System.out.println("===================================================================================");
		System.out.println("차량정보: "+vo.toStringSelecCar());
		System.out.println();
		System.out.println("보험정보: "+vo.getInsure());
		System.out.println();
		System.out.println();

		try {
			System.out.println("예약하시겠습니까?    1.예  2.아니오");
			System.out.print("▷ ");
			ch=sc.nextInt();




		} catch (Exception e) {

			System.out.println("\n▒숫자로 입력해 주세요▒");
			System.out.println();
		}


		if(ch==1){

			System.out.print("\t예 약 진 행 중 ");

			Thread t2 = new Thread(new RentImpl());	//쓰레드
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


					System.out.println("\n\t▒ 예약 성공! ▒");
					System.out.println();
					System.out.println();
				}

			} catch (Exception e) {

				System.out.println("\n\t▒예약에 실패하였습니다. 다시 시도해주세요▒");
				System.out.println();
			}
		}
		else{



			System.out.println("\n\t▒예약을 취소하였습니다▒");
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
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격 ");
		System.out.println("===========================================================================");

		int startY, startM, startD;
		String tempDate1, tempDate2;

		List<RentVO> tempRes = new ArrayList<RentVO>();
		List<RentVO> noRes = new ArrayList<RentVO>();



		//입력받은 날짜 기간을 배열 dates에 저장.

		int d = diffOfDate(startDay, endDay);

		Calendar cal = Calendar.getInstance();

		String[] dates = new String[d+1];	//예약자에게 입력받은 날짜들 저장할 배열 선언

		String[] getTemp = new String[3];	//입력날짜 date연산을 위해 분리
		getTemp = startDay.split("-");

		startY = Integer.parseInt(getTemp[0]);
		startM = Integer.parseInt(getTemp[1]);
		startD = Integer.parseInt(getTemp[2]);
		cal.set(startY, startM-1, startD);	//날짜 세팅

		for(int i=0 ; i<dates.length ; i++) {
			int tempY = cal.get(Calendar.YEAR);
			int tempM = cal.get(Calendar.MONTH)+1;
			int tempD = cal.get(Calendar.DATE);	
			tempDate1 = Integer.toString(tempY) + Integer.toString(tempM) + Integer.toString(tempD);
			dates[i]=tempDate1;		 
			cal.add(Calendar.DATE, 1);
		}


		//예약자리스트에서 예약날짜 가져오기
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

		//배열과 리스트 비교
		for(int i=0;i<dates.length;i++){
			Iterator<RentVO> it2 = tempRes.iterator();
			while(it2.hasNext()){
				RentVO vo = it2.next();
				if(dates[i].equals(vo.getStartday())){
					noRes.add(vo);	//출력하면 안되는 차 번호 리스트
				}
			}
		}
		//finalRes 리스트에 검색결과로 보여줄 데이터 추가
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

		//가격 null값 입력
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

		Iterator<RentVO> printIt2 = finalRes.iterator();	//최종출력
		while(printIt2.hasNext()) {
			RentVO vo = printIt2.next();
			System.out.println(vo.toStringCar());
		}

	}

	@Override
	public void searchRes() {// ★☆ 변동사항! > 이름,연락처 맞지 않을시 반복질문

		String name;
		String tel;
		int ch;
		boolean flag;
		System.out.println("========예약자 정보 입력=======");

		do{
			Iterator<RentVO> ite = clientLists.iterator();
			flag = false;

			System.out.print("등록시 이름: ");
			name = sc.next();

			while(ite.hasNext()){
				RentVO ob = ite.next();
				if(name.equals(ob.getName())){
					flag=true;
					break;
				}
			}
			if(flag==false){

				System.out.println("\n▒존재하지 않는 이름입니다▒\n");

			}
		}while(flag==false);

		do{
			Iterator<RentVO> ite = clientLists.iterator();
			flag = false;

			System.out.print("등록시 연락처: ");
			tel = sc.next();

			while(ite.hasNext()){
				RentVO ob = ite.next();
				if(tel.equals(ob.getTel())){
					flag=true;
					break;
				}
			}
			if(flag==false){

				System.out.println("\n▒연락처가 일치하지 않습니다▒\n");

			}
		}while(flag==false);


		Iterator<RentVO> it = clientLists.iterator();

		while(it.hasNext()){
			RentVO rent = it.next();

			if(name.equals(rent.getName())){
				if(tel.equals(rent.getTel())){
					System.out.println();
					System.out.println();
					System.out.println("===========예약자정보==========");
					System.out.println();
					System.out.println(rent.toStringClient());	
					System.out.println("===========================================================================");
					System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격 ");
					System.out.println("===========================================================================");
					System.out.println(rent.toStringSelecCar());	
					System.out.println();

					do{
						System.out.println("1.확인   2.예약취소");
						System.out.print("▷ ");
						ch = sc.nextInt();
						if(ch==1){
							return;
						}
						if(ch==2){
							try {
								System.out.println();
								System.out.print("예약을 취소하시겠습니까? (Y/N) ");
								char ch2 = (char)System.in.read();
								if(ch!='Y' && ch!='y'){
									clientLists.remove(clientLists.indexOf(rent));
									resDel(name,tel);

									System.out.println("\n▒취소하였습니다▒\n");

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

		System.out.println("\n▒예약된 내역이 없습니다▒\n");

		System.out.println();
	}



	public int diffOfDate(String startDay, String endDay){ //두 날짜 차이값계산

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
	public void allSearch() { //모든 예약자 조회



		Iterator<RentVO> it = clientLists.iterator();

		System.out.println();
		System.out.println("                                                ▒    전체 예약자 목록    ▒                                                  ");
		System.out.println("===============================================================================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   대여일   |   반납일   |   대여료   | 대여자 |  휴대폰 번호 ");
		System.out.println("===============================================================================================================================");
		//System.out.println("   9987      BEN       컨티넨T    대형   검정    4인승     휘발   2018-06-29   2018-07-11   11,999,988   지현우  010-0001-0045");
		while(it.hasNext()){

			RentVO rent = it.next();

			//이메일만 제외하고 출력

			System.out.println(rent.toStringRes());

		}

		System.out.println();
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");



	}

	@Override
	public void admin() {//관리자 로그인

		boolean flag = false;

		String id = null;
		String password = null;
		do{
			System.out.print("\t아이디를 입력하세요 |   ");
			id=sc.next();
			if(id.equals(Id)){
				flag = true;

			}
			if(flag==false){

				System.out.println("\t <!> 아이디를 확인하세요!");
				System.out.println();

			}

		}while(flag==false);

		flag=false;

		do{
			System.out.print("\t비밀번호를 입력하세요 |   ");
			password=sc.next();

			if(password.equals(Password)){
				flag = true;

			}
			if(flag==false){

				System.out.println("\t <!> 비밀번호를 확인하세요!");
				System.out.println();
			}

		}while(flag==false);

		System.out.println();
		System.out.println();
		System.out.print("\t <♪> 로그인 성공! ");
		System.out.println();



		while(true){//관리자메뉴 출력

			System.out.println("===============================================================================================================================");
			System.out.println("            1.차량정보조회  |  2.차량정보등록  |  3.차량정보수정  |  4.차량정보삭제  |  5.예약현황  |  6.메인으로              ");
			System.out.println("===============================================================================================================================");
			System.out.print("▷ ");
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

			do{//동일한 차량번호 걸러냄
				Iterator<RentVO> it = lst.iterator();

				flag = true;
				System.out.print("차량 번호");
				cBun = sc.next();

				while(it.hasNext()){

					RentVO v1 = it.next();
					if(v1.getCbun().equals(cBun)){
						System.out.println("이미 있는 차량번호 입니다!");
						flag=false;	
					}
				}
			}while(flag==false);

			System.out.print("회사");
			vo.setCmanu(sc.next());

			System.out.print("모델명");
			vo.setCname(br.readLine());

			System.out.print("차종");
			vo.setCsize(sc.next());

			System.out.print("색상");
			vo.setCcolor(sc.next());

			System.out.print("탑승인원");
			vo.setCseat(sc.next());

			System.out.print("연료");
			vo.setCfuel(sc.next());


			//예약날짜가 없으면 타예약정보 자동 null주기
			System.out.print("예약 시작 날짜");
			vo.setStartday(br.readLine());

			if(vo.getStartday().trim().equals("-")){
				vo.setEndday("    -     ");
				vo.setName("   -   ");
				vo.setTel("       -      ");
			}else if(!vo.getStartday().trim().equals("-")){

				System.out.print("예약 만기 날짜");
				vo.setEndday(br.readLine());

				System.out.print("대여자");
				vo.setName(br.readLine());

				System.out.print("휴대폰 번호");
				vo.setTel(br.readLine());
			}

			System.out.print("대여료");
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
			System.out.println("\t <♪> 저장 성공");
			System.out.println();

		} catch (Exception e) {
			System.out.println();
			System.out.println("\t <!> 저장 불가능!");
			System.out.println();
		}

	}

	@Override
	public void carUpdt() {//차량의 고객정보 수정

		try {//차량과 고객파일 동시 수정
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
			System.out.println("\t <!> 파일 불러오기 실패!");
		}//파일 불러옴


		String num = null;
		boolean flag = false;

		do{
			System.out.print("\t 정보를 수정할 차량번호를 입력하세요 |  ");
			num = sc.next();

			Iterator<RentVO> ite = lst.iterator();

			while(ite.hasNext()){

				RentVO vv = ite.next();

				if(num.equals(vv.getCbun())){
					flag = true;
				}
			}
			if(flag==false){
				System.out.println("\t <!> 존재하지 않는 차량번호!");
			}

		}while(flag==false);
		System.out.println();//차량번호 유무 검사


		int ch = 0;
		String str= null;


		Iterator<RentVO> it = lst.iterator();

		while(it.hasNext()){//차량파일 수정

			RentVO v1 = it.next();

			if(num.equals(v1.getCbun())){

				System.out.println("\t\t\t\t\t\t   < 수정할 정보 >");
				System.out.println("===============================================================================================================================");
				System.out.println("                      1.대여일  |  2.반납일  |  3.대여자  |  4.대여자 연락처  |  5.대여료  |  6.취소              ");
				System.out.println("===============================================================================================================================");

				ch = sc.nextInt();

				switch(ch) {

				case 1:
					System.out.print("\t 대여일 ex[yyyy-mm-dd] |  ");
					str = sc.next();
					v1.setStartday(str);
					System.out.println("\t <♪> 수정되었습니다!");
					System.out.println();
					break;
				case 2:
					System.out.print("\t반납일 ex[yyyy-mm-dd] |  ");
					str = sc.next();
					v1.setEndday(str);
					System.out.println("\t <♪> 수정되었습니다!");
					System.out.println();
					break;
				case 3:
					System.out.print("\t 이름 |  ");
					str = sc.next();
					v1.setName(str);
					System.out.println("\t <♪> 수정되었습니다!");
					System.out.println();
					break;
				case 4:
					System.out.print("\t 연락처 ex[010-0000-0000] |  ");
					str = sc.next();
					v1.setTel(str);
					System.out.println("\t <♪> 수정되었습니다!");
					System.out.println();
					break;
				case 5:
					System.out.print("차량의 대여료 ex[00,000]  | ");
					str = sc.next();
					v1.setPrice(str);
					System.out.println("\t <♪> 수정되었습니다!");
					System.out.println();
					break;
				case 6:
					return;
				}
			}
		}


		Iterator<RentVO> iter = clientLists.iterator();

		while(iter.hasNext()){//고객파일 수정

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
	public void carDel() {//차량 삭제

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
				System.out.print("삭제할 차량번호: ");
				num = sc.next();

				while(it.hasNext()){

					RentVO vt = it.next();

					if(num.equals(vt.getCbun())){
						if(vt.getEndday().trim().equals("-")){
							lst.remove(vt);

							System.out.println("\n▒삭제 완료▒\n");

							flag=true;
							break;

						}else{

							System.out.println("\n▒삭제불가! 예약된 차량입니다▒\n");

							flag=false;
						}				
					}else{
						flag=false;
					}
				}
			}while(flag==false);

		} catch (Exception e) {
			System.out.println("\n▒오류: 존재하지 않는 차량번호▒\n");
		}

		try {

			FileOutputStream fos = new FileOutputStream(carFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(lst);

			oos.close();
			fos.close();

		} catch (Exception e) {

			System.out.println("\n▒오류: 저장 불가능▒\n");

		}

	}

	@Override
	public void carPrint() {//전체 차량 조회

		ArrayList<RentVO> lst = new ArrayList<RentVO>();

		try {

			FileInputStream fis = new FileInputStream(carFile);
			ObjectInputStream ois = new ObjectInputStream(fis);

			lst = (ArrayList<RentVO>) ois.readObject();

			Iterator<RentVO> it = lst.iterator();

			System.out.println();
			System.out.println("                                                     ▒ 전체 차량 목록 ▒                                                     ");
			System.out.println("===============================================================================================================================");
			System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |    대여일    |    반납일    | 대여료 | 대여자 | 휴대폰 번호 ");
			System.out.println("===============================================================================================================================");

			while(it.hasNext()){

				RentVO vo = it.next();
				System.out.println(vo.toSrtingAdmin());
			}	
			System.out.println();
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
		}	
	}


	public void carRes(String Scar) {//차량파일의 예약자정보를 수정 

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

	public void carWrite(String Scar){//고객파일에 들어갈 선택 차량정보

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

	public void resDel(String name, String tel){//예약취소시 차량파일의 예약자 정보 삭제

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
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒□□□□□□□□▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□□□□□□□□□□□▒▒▒▒▒▒□□□□□□□□□□□▒▒▒□□▒▒▒▒");
		System.out.println("▒▒□□□□□□□□▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□□□□□□□□□□□▒▒▒▒▒▒□□□□□□□□□□□▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒□□▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒□□▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒□□▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒□□▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒□□▒▒▒▒");
		System.out.println("▒▒□□□□□□□□▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒□□▒▒▒▒");
		System.out.println("▒▒□□□□□□□□▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒□□▒▒▒▒");
		System.out.println("▒▒□□▒▒▒▒▒▒▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□□□□□□□□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒□□▒▒▒▒");
		System.out.println("▒▒□□▒▒▒▒▒▒▒▒□□□□▒□□▒▒▒▒▒▒▒□□□□□□□□□□□□▒▒▒▒▒▒□□□□□□□□□□□▒▒▒□□▒▒▒▒");
		System.out.println("▒▒□□▒▒▒▒▒▒▒▒□□□□▒□□▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□□□□□□□□□▒▒▒□□□□□▒");
		System.out.println("▒▒□□▒▒▒▒▒▒▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□▒▒▒□□□□□▒");
		System.out.println("▒▒□□▒▒▒▒▒▒▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□▒▒▒□□▒▒▒▒");
		System.out.println("▒▒□□□□□□□□▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒□□□□□□□□▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□□□□□□□□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒□□▒▒▒▒▒▒▒□□□□□□□□□□□□▒▒▒▒▒▒▒▒▒▒▒▒□□□▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□▒▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□▒▒▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒□□□□□□□□□□□□□▒▒▒▒▒□□□□□□□□□□□□□□□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒□□□□□□□□□□□□□▒▒▒▒▒□□□□□□□□□□□□□□□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒□▒▒□□□□□□□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□□□□□□▒▒▒□▒□▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒□▒□▒▒▒▒▒□▒▒□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒▒□▒▒▒▒▒□▒□▒▒▒▒□▒▒▒▒□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒▒▒▒□▒▒□□□▒□▒▒▒□▒▒▒▒▒▒□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒▒▒▒▒▒□▒▒▒□▒□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒▒▒▒▒▒▒▒□▒▒□▒□▒▒□□□□□□□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒□▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒□▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□□□□□□□□□□□□□□□□□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□□□□□□□□□□□□□□□□□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒□▒□▒▒");
		System.out.println("▒▒▒▒▒▒▒▒□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□▒▒▒▒▒▒▒▒▒▒□▒▒▒□▒▒▒▒▒");
		System.out.println("▒▒▒▒▒□□□□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒▒▒▒□□▒□□▒▒▒▒▒□▒");
		System.out.println("▒▒▒□□□□□▒▒▒▒▒▒□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒▒□□▒▒▒□▒▒▒▒□▒▒▒");
		System.out.println("▒▒□□□▒▒▒▒▒▒▒▒▒□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□▒▒▒▒□▒□▒□▒▒▒▒□▒▒▒▒▒");
		System.out.println("▒▒□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□□□▒▒▒▒□▒▒□▒▒▒▒▒□▒▒");
		System.out.println("▒▒□□▒▒▒▒□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□□▒▒▒□□□□□▒□□▒▒▒□▒▒□▒□□□□▒");
		System.out.println("▒▒□□▒▒▒□▒▒▒▒□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒▒▒▒□▒▒□□▒▒▒▒▒▒□□□▒□▒▒□□□▒□▒");
		System.out.println("▒▒□□▒▒□▒▒▒▒▒▒□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒▒▒▒▒▒□▒□□▒▒▒▒▒▒▒▒▒□□□□▒□▒▒▒▒");
		System.out.println("▒▒□□▒▒□▒▒▒▒▒▒□▒▒□□□□□□□□□□□□□□□□▒▒□▒▒▒▒▒▒□▒▒▒▒▒▒▒▒▒▒□▒▒▒□□□▒□▒▒▒");
		System.out.println("▒▒▒▒▒▒□▒▒▒▒▒▒□▒▒□□□□□□□□□□□□□□□□▒▒□▒▒▒▒▒▒□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒□▒▒▒▒□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□▒▒▒▒□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒□□□□▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□");
		System.out.println("□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒");
		System.out.println("▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□");
		System.out.println("□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒□□▒▒");
		System.out.println("                                                                                                            이현진-조일준-김누리");
	}
	




	@Override
	public void run() { //스레드

		String str = ". . . . . . . . .  ";
		String str2 = "(*'ㅅ'*)/";
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
	public void carSearch() {//조건에 따른 예약가능 차량 조회

		String view=null;//전체보기

		while(true){
			System.out.println("===============================================================================================================================");
			System.out.println("             1.제조사  |  2.차량 색상  |  3.차량 탑승 가능인원  |  4.연료별  |  5.전체 자동차  |  6.메인화면으로               ");
			System.out.println("===============================================================================================================================");
			System.out.print("▷ ");
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
				System.out.println("매장 내의 자동차 정보를 출력합니다");
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

		System.out.println("저희 매장에서는 현대(HYU),기아(KIA),폭스바겐(VWK),쉐보레(SHV),쌍용(SSY)차량이 준비되어 있습니다.");


		do{
			flag=false;
			System.out.println();
			System.out.println("찾으시는 제조사를 영문자로 입력해주세요");
			System.out.print("▷ ");
			manu=sc.next();

			for(int i=0;i<man.length;i++){

				if(manu.trim().equals(man[i])){
					flag=true;		
					break;		
				}
			}
			if(!(manu.trim().length()==3)){

				System.out.println("\n▒글자수를 3자리로 입력해주세요▒\n");

				flag=false;
				//System.out.println("원하는 색상을 다시 입력해주세요");
				//color = sc.next();
			}
		}while(flag==false);


		do{	
			System.out.println();
			System.out.println("===========================================================================");
			System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격   ");
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
				
				System.out.println("\n▒제조사가 존재하지 않습니다▒\n");
				

		}while(flag==false);    
		System.out.println();
	}


	public void seeColor(){

		String color;
		boolean flag=false;

		String[] col = {"검정","흰색","파랑","흰색","남색","노랑","은색","빨강","살구","갈색"};

		System.out.println("저희 매장에는 검정, 흰색, 파랑 ,흰색 ,남색 ,노랑 ,은색 ,빨강 ,살구 , 갈색의 차량이 준비되어 있습니다.");


		do{
			flag=false;
			System.out.println();
			System.out.println("색상을 입력하세요");
			System.out.print("▷ ");
			color=sc.next();

			for(int i=0;i<col.length;i++){

				if(color.trim().equals(col[i])){
					flag=true;		
					break;		
				}
			}
			if(!(color.trim().length()==2)){
				System.out.println("\n▒글자수를 2자리로 입력해주세요▒\n");

				flag=false;
				//System.out.println("원하는 색상을 다시 입력해주세요");
				//color = sc.next();
			}
		}while(flag==false);


		do{
			System.out.println();
			System.out.println("===========================================================================");
			System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격   ");
			System.out.println("===========================================================================");

			flag=false;

			Iterator<RentVO> it = lst.iterator();
			while(it.hasNext()){//리스트에서 색상 차량 정보를 가져옴

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

				System.out.println("\n▒색상이 존재하지 않습니다▒\n");	


		}while(flag==false);
		System.out.println();
	}


	public void seeSeat(){

		String seat;
		boolean flag=false;

		String[] sea = {"2인승","4인승","5인승","6인승","7인승","9인승"};

		System.out.println("저희 매장에서는 2인승, 4인승, 5인승, 6인승, 7인승, 9인승의 차량이 준비되어 있습니다.");


		do{
			flag=false;
			System.out.println();
			System.out.println("찾으시는 차량의 좌석수를 입력해주세요");
			System.out.print("▷ ");
			seat=sc.next();

			for(int i=0;i<sea.length;i++){

				if(seat.trim().equals(sea[i])){
					flag=true;		
					break;		
				}
			}
			if(!(seat.trim().length()==3)){
				
				System.out.println("\n▒글자수를 3자리로 입력해주세요▒\n");
				
				flag=false;
				//System.out.println("원하는 색상을 다시 입력해주세요");
				//color = sc.next();
			}
		}while(flag==false);


		do{
			System.out.println();
			System.out.println("===========================================================================");
			System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격   ");
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
				System.out.println("\n▒차량이 존재하지 않습니다▒\n");	
				
			}
		}while(flag==false);    
		System.out.println();
	}
	
	public void seeFuel(){

		String fuel;
		boolean flag=false;

		String[] fue = {"디젤","가솔","가스","휘발","경유","하이","디젤"};

		System.out.println("저희 매장에서는 디젤,경유,가스,하이(브리드),휘발,가솔의 차량이 준비되어 있습니다.");


		do{
			flag=false;
			System.out.println();
			System.out.println("찾으시는 차량의 연료타입을 2자리로 입력해주세요");
			System.out.print("▷ ");
			fuel=sc.next();

			for(int i=0;i<fue.length;i++){

				if(fuel.trim().equals(fue[i])){
					flag=true;		
					break;		
				}
			}
			if(!(fuel.trim().length()==2)){
				System.out.println("\n▒글자수를 2자리로 입력해주세요▒\n");
				
				flag=false;
				//System.out.println("원하는 색상을 다시 입력해주세요");
				//color = sc.next();
			}
		}while(flag==false);


		do{
			System.out.println();
			System.out.println("===========================================================================");
			System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격   ");
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
				System.out.println("\n▒차량이 존재하지 않습니다▒\n");	

		}while(flag==false);     
		System.out.println();
	}


	public void allView(String view){
		
		System.out.println();
		System.out.println("                       ▒ 예약가능 전체차량 목록 ▒                        ");
		System.out.println("===========================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격   ");
		System.out.println("===========================================================================");

		Iterator<RentVO>it = lst.iterator();

		while(it.hasNext()){//리스트에서 차량의 전체정보를 가져옴
			RentVO rent =it.next();

			if(rent.getStartday().trim().equals("-")){
				System.out.println(rent.toStringCar());
			}
		}
	}

}



