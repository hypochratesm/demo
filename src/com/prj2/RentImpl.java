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


	//1.예약하기
	@Override
	public void input() {

		CustomDTO cusDTO = new CustomDTO();

		Calendar now = Calendar.getInstance();
		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH)+1;
		int d = now.get(Calendar.DATE);	

		String today = Integer.toString(y) +"-"+ Integer.toString(m) +"-"+ Integer.toString(d);

		int ch;
		int cnt;	//diffOfdate메소드 반환값 돌려받는 변수

		boolean flag = false;

		try {

			do{

				System.out.println("=========== 날짜 선택 ===========");
				System.out.print("대여일? [ex.yyyy-mm-dd]");
				startDay = sc.next();
				cusDTO.setStartday(startDay);
				cnt = 0;
				cnt = diffOfDate(today, startDay);


			}while(cnt==-1);


		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("\n▒날짜를 다시 입력해주세요▒");
			System.out.println();
			return;
		}

		try {

			do{
				System.out.print("반납일? [ex.yyyy-mm-dd]");
				endDay = sc.next();
				cusDTO.setEndday(endDay);
				cnt = 0;	
				cnt = diffOfDate(startDay,endDay);


			}while(cnt<1);

		} catch (Exception e) {

			System.out.println("\n▒날짜를 다시 입력해주세요▒");
			System.out.println();
			return;
		}

		System.out.println();
		System.out.println();
		System.out.print("\t검 색 중 ");

		Thread t1 = new Thread(new RentImpl());	//쓰레드
		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			System.out.println(e.toString());
		}


		//예약 가능한 차량 리스트 검색 및 출력
		posiCar();

		System.out.println("===========================================================================");
		System.out.println();
		System.out.println("    ▷차량을 선택하세요");

		do{
			System.out.print("    차량 번호: ");
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

				System.out.println("\n▒정확한 차량번호를 입력하세요▒");
				System.out.println();
			}

		}while(flag==false);

		System.out.println("=========== 차량 선택 ==========");
		System.out.printf("☞차량번호: %s\n☞모델명: %s\n",cusDTO.getCarNum(),rentDAO.getCarModel(cusDTO.getCarNum()));

		int dif = diffOfDate(startDay, endDay);
		System.out.printf("☞대여기간: %d일\n", dif);

		cusDTO.setTotprice(rentDAO.getTotPrice(cusDTO.getCarNum(), dif));
		System.out.printf("☞총 대여비용: %,3d원\n", cusDTO.getTotprice());


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
						cusDTO.setInsure("완전면책");
						break;
					case 2:
						cusDTO.setInsure("일반면책");
						break;
					case 3:
						cusDTO.setInsure("가입안함");
						break;
					}

				}while(ch<1||ch>3);

			}

		} catch (java.util.InputMismatchException e) {

			System.out.println("\n▒숫자로 입력해 주세요▒");
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
			System.out.println("======== 예약자 정보 입력 ========");

			System.out.print("이름: ");
			cusDTO.setName(sc.next());
			do {	
				System.out.print("생년월일[YYYY-MM-DD]: ");
				String birth = sc.next();
				matBirth = pBirth.matcher(birth);
				cusDTO.setBirth(birth);
			}while(!matBirth.matches());


			do{
				flag = false;
				System.out.print("연락처: ");
				cusDTO.setTel(sc.next());
				matTel = pTel.matcher(cusDTO.getTel());


				//DB에서 연락처 중복검사 checkTel(전화번호)
				//true가 넘어오면 중복된 연락처		
				if(rentDAO.checkTel(cusDTO.getTel())){
					System.out.println("중복된 연락처 입니다..!! 다시 입력해주세요!");
				}

			}while(!matTel.matches() || flag==true); 

			do {
				System.out.print("이메일: ");
				String email = sc.next();
				matEmail = pEmail.matcher(email);
				cusDTO.setEmail(email);

			}while(!matEmail.matches());

			try {
				System.out.println();
				System.out.println();

				System.out.println("======== 예약자 정보 확인 ========");
				System.out.println("☞이름: "+cusDTO.getName());
				System.out.println("☞생년월일: "+cusDTO.getBirth());
				System.out.println("☞연락처: "+cusDTO.getTel());
				System.out.println("☞이메일: "+cusDTO.getEmail());
				System.out.println();
				System.out.println("** 입력하신 내용이 맞습니까?");
				System.out.println("** 1.확인 2.다시입력 ");
				System.out.print("▷ ");
				ch = sc.nextInt();

				if(ch==1){
					break;
				}

			} catch (Exception e) {
				System.out.println("\n▒ 다시 입력해 주세요! ▒\n");
			}

		}

		System.out.println();
		System.out.println("============ 예약 내용 ===========");
		System.out.println("☞이름: "+cusDTO.getName());
		System.out.println("☞생년월일: "+cusDTO.getBirth());
		System.out.println("☞연락처: "+cusDTO.getTel());
		System.out.println("☞이메일: "+cusDTO.getEmail());
		System.out.println("----------------------------------");
		System.out.println("☞대여일: "+cusDTO.getStartday());
		System.out.println("☞반납일: "+cusDTO.getEndday());
		System.out.printf("☞총 대여비용: %,3d원",cusDTO.getTotprice());
		System.out.println();
		System.out.println("==========================================================================");
		System.out.println("           차량번호 | 제조사 |    모델명  | 차종 | 색상 | 탑승인원 | 연료 ");
		System.out.println("==========================================================================");
		System.out.println("차량정보: "+ rentDAO.printSelectCar(cusDTO.getCarNum()));
		System.out.println();
		System.out.println("보험정보: "+cusDTO.getInsure());
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

		try {

			if(ch==1){

				System.out.print("\t예 약 진 행 중 ");

				Thread t2 = new Thread(new RentImpl());	//쓰레드
				t2.start();
				try {
					t2.join();
				} catch (Exception e) {
					System.out.println(e.toString());
				}

				//예약번호 생성
				String bkNum = rentDAO.createBookingNo();

				//DB에 예약정보 저장
				int recheck1 = rentDAO.insertRescar(cusDTO, bkNum);
				int recheck2 = rentDAO.insertCustomer(cusDTO, bkNum);

				if(recheck1==1 && recheck2==1) {
					System.out.println("\n\t▒ 예약 성공! ▒");
					System.out.println();
					System.out.println();
				}

			}
			else{

				System.out.println("\n\t▒예약을 취소하였습니다▒");
				System.out.println();
				return;
			}

		} catch (Exception e) {
			System.out.println("\n\t▒예약에 실패하였습니다. 다시 시도해주세요▒");
			System.out.println();
		}

	}//end...input()


	@Override
	public void posiCar() {
		System.out.println();
		System.out.println();
		System.out.println("                        ▒ 예약가능한 차량 목록 ▒");
		System.out.println();

		System.out.println("===========================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격 ");
		System.out.println("===========================================================================");

		int startY, startM, startD;
		String tempDate1, tempDate2;


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

		List<CustomDTO> daysLists = new ArrayList<CustomDTO>();
		List<CustomDTO> saveDaysLists = new ArrayList<CustomDTO>();
		List<CustomDTO> okRes = new ArrayList<CustomDTO>();

		//DB에서 예약날짜 가져오기(리스트로 반환받음)
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

						okRes.add(dto);//getPrintList에게 넘겨줄 리스트 생성(예약불가능한 차량 리스트)
					}		
				}

			}
		}

		//DB에서 예약이 가능한 차량정보를 가져옴(리스트 printLists로 받아옴)


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

	//2. 예약조회
	public void searchRes() {//예약조회, 예약취소

		int ch=0;
		String str,str1;


		System.out.print("전화번호: ");
		String tel = sc.next();

		if(!rentDAO.checkTel(tel)){
			System.out.println("예약내역이 존재하지 않습니다");
			return;
		}

		CustomDTO cusdto = rentDAO.selCus(tel);
		String resno = cusdto.getResno();

		AllDTO alldto = rentDAO.selAllDTO(resno);
		String carnum = alldto.getCarNum();

		CarDTO cardto = rentDAO.selCar(carnum);


		System.out.println();
		System.out.println("===========예약자정보==========");
		str = String.format("예약 번호: %s\n이름: %s\n연락처: %s\n생년월일: %s\n이메일: %s\n대여기간: %-10s~%10s"
				,cusdto.getResno(),cusdto.getName(),cusdto.getTel(),cusdto.getBirth(),cusdto.getEmail()
				,alldto.getStartDay(),alldto.getEndDay());
		System.out.println(str);
		System.out.println("====================================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격   |  상태");
		System.out.println("====================================================================================");
		str1 = String.format("%7s %8s %10s %5s %4s %6s %6s   %,3d %6s"
				, cardto.getCarNum(),cardto.getManu(),cardto.getModel()
				,cardto.getType(),cardto.getColor(),cardto.getSeat(),cardto.getFuel(),alldto.getTotPrice(),alldto.getStatus());
		System.out.println(str1);
		System.out.println();
		System.out.printf("보험 여부: %s\n",alldto.getInsure());
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
					if(ch2=='Y' || ch2=='y'){

						int result = rentDAO.delres(resno);

						if(result!=0){
							System.out.println();
							System.out.println("▒취소하였습니다▒");
							System.out.println();
						}else{

							System.out.println("▒취소 실패!▒");
						}
					}

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		}while(ch<1 || ch>2);		

	}


	//3. 차량 검색
	@Override
	public void carSearch() {

		while(true){

			System.out.println("===============================================================================================================================");
			System.out.println("       1.전체차량   |  2.제조사 검색  |  3.차량색상 검색  |  4.차량 탑승가능인원 검색  |  5.연료별 검색  |  6.메인화면으로     ");
			System.out.println("===============================================================================================================================");
			System.out.print("▷ ");
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

	//3-2.제조사검색
	public void seeManu(){

		String manu;

		System.out.println("저희 매장에서는 현대(HYU),기아(KIA),폭스바겐(VWK),쉐보레(SHV),쌍용(SSY)차량이 준비되어 있습니다.");
		System.out.println();
		System.out.println("찾으시는 제조사를 영문자로 입력해주세요");
		System.out.print("▷ ");
		manu=sc.next();

		List<CarDTO> lists = rentDAO.seeManu(manu);

		System.out.println("===========================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격   ");
		System.out.println("===========================================================================");
		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
		System.out.println();
		System.out.println();
	}

	//3-3. 차량색상검색
	public void seeColor(){

		String color;

		System.out.println("저희 매장에는 검정, 흰색, 파랑, 흰색, 남색, 노랑, 은색, 빨강, 살구, 갈색의 차량이 준비되어 있습니다.");
		System.out.println();
		System.out.println("색상을 입력해주세요");
		System.out.print("▷ ");
		color=sc.next();

		System.out.println();
		System.out.println("===========================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격   ");
		System.out.println("===========================================================================");
		List<CarDTO> lists = rentDAO.seeColor(color);

		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
		System.out.println();
		System.out.println();
	}


	//3-4. 차량탑승인원 검색
	public void seeSeat(){

		String seat;
		System.out.println("저희 매장에서는 2인승, 4인승, 5인승, 6인승, 7인승, 9인승의 차량이 준비되어 있습니다.");
		System.out.println();
		System.out.println("원하시는 탑승인원을 입력하세요");
		System.out.print("▷ ");
		seat=sc.next();

		System.out.println();
		System.out.println("===========================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격   ");
		System.out.println("===========================================================================");

		List<CarDTO> lists = rentDAO.seeSeat(seat);

		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
		System.out.println();
		System.out.println();
	}

	//3-5.연료별 검색
	public void seeFuel(){

		String fuel;

		System.out.println("저희 매장에서는 디젤,경유,가스,하이(브리드),휘발,가솔의 차량이 준비되어 있습니다.");

		System.out.println("찾으시는 차량의 연료타입을 2자리로 입력해주세요");
		System.out.print("▷ ");
		fuel=sc.next();
		System.out.println();
		System.out.println("===========================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격   ");
		System.out.println("===========================================================================");
		List<CarDTO> lists = rentDAO.seeFuel(fuel);

		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
		System.out.println();
		System.out.println();
	}



	//4.관리자 로그인
	@Override
	public void admin() {

		boolean flag = false;

		/*		String id = null;
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
		System.out.println();*/


		//4.관리자모드
		while(true){

			System.out.println("===============================================================================================================================");
			System.out.println("      1.대여/반납 |  2.차량정보조회  |  3.차량정보등록  |  4.고객정보수정  |  5.차량정보삭제  |  6.예약현황  |  7.메인으로     ");
			System.out.println("===============================================================================================================================");
			System.out.print("▷ ");
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

	//4-1.대여, 반납 메뉴
	public void inOut(){

		int ch;
		List<AllDTO> lst = new ArrayList<AllDTO>();
		lst = rentDAO.searchAllRes();

		Iterator<AllDTO> it = lst.iterator();

		System.out.println();
		System.out.println("                                                ▒예약 차량 목록▒                                                 ");
		while(it.hasNext()){

			AllDTO dto = it.next();
			System.out.println(dto.toString());		
		}
		System.out.println();

		do{
			System.out.println("=============================");
			System.out.println("     1.대여   |   2.반납         ");
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

	//4-1. 대여중으로 전환
	public void statRent(){

		String resno;
		int rs;

		do{
			System.out.print("바꿀 예약번호: ");
			resno = sc.next();

			rs = rentDAO.chkRes(resno);
			if(rs!=0){
				break;
			}else{
				System.out.println();
				System.out.println("▒존재하지 않는 예약번호 입니다▒");
				System.out.println();
			}		

		}while(rs==0);

		rentDAO.statRent(resno);


	}


	//4-1. 예약차량을 반납 처리함
	public void statRetr(){

		System.out.print("반납할 예약번호: ");
		String resno = sc.next();

		AllDTO allDTO = rentDAO.getList(resno);

		int result = rentDAO.insertData(allDTO);
		int result2 = rentDAO.deleteData(resno);

		if(result!=0&&result2!=0){
			System.out.println("\t <♪> 반납 완료!");
			System.out.println();
		}

		else{
			System.out.println("\t <!> 전환 실패!");
			System.out.println();
		}

	}

	//4-2.전체 차량조회
	@Override
	public void carPrint() {

		List<CarDTO> dtoList = rentDAO.carPrint();

		Iterator<CarDTO> dtoIt = dtoList.iterator();
		System.out.println("                           ▒ 전체 차량 목록  ▒                           ");
		System.out.println("===========================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 |   가격   ");
		System.out.println("===========================================================================");

		while(dtoIt.hasNext()){

			CarDTO carDTO = dtoIt.next();

			System.out.println(carDTO.toStringCar());		

		}
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println();

	}

	//4-3. 차량 정보 등록

	@Override
	public void carInfo() {//차량 정보 입력


		//입력하는 데이터의 갯수는 8개.
		//carnum :차량번호
		//manu:제조사
		//model:차량 이름
		//type :차량 종류
		//color: 차량 컬러
		//seat : 차량에 탑승 가능한 인원
		//fuel : 연료
		//price : 하루 대여료

		CarDTO dto1 =new CarDTO();

		System.out.println("차량번호?");
		dto1.setCarNum(sc.next());

		System.out.println("제조사?");
		dto1.setManu(sc.next());

		System.out.println("모델명?");
		dto1.setModel(sc.next());

		System.out.println("차량 종류?");
		dto1.setType(sc.next());

		System.out.println("차량컬러?");
		dto1.setColor(sc.next());

		System.out.println("탑승인원?");
		dto1.setSeat(sc.next());

		System.out.println("연료?");
		dto1.setFuel(sc.next());

		System.out.println("대여료/1일?");
		dto1.setPrice(sc.nextInt());

		int result = rentDAO.carInfo(dto1);

		if(result!=0){
			System.out.println("추가성공");	
		}else
			System.out.println("추가실패");

	}



	//4-4.예약고객정보 수정
	@Override
	public void carUpdt() {//차량의 고객정보 수정


		RentDAO dao = new RentDAO();
		String str;


		CustomDTO cusdto = new CustomDTO();


		System.out.print("\t 정보를 수정할 예약번호를 입력하세요 ");
		cusdto.setResno(sc.next());

		System.out.print("\t 이름?");
		cusdto.setName(sc.next());

		System.out.print("\t 생일?");
		cusdto.setBirth(sc.next());

		System.out.print("\t 이메일");
		cusdto.setEmail(sc.next());

		int result = dao.carUpdt(cusdto);

		if(result!=0){
			System.out.println();
			System.out.println("▒ 수정 완료 ▒");
			System.out.println();
		}else{
			System.out.println();
			System.out.println("\t <!> 존재하지 않는 예약번호!");
			System.out.println();

		}
	}

	//4-5.차량정보 삭제
	@Override
	public void carDel() {


		System.out.print("\t 삭제할 차량 넘버?");
		String carNum = sc.next();

		int result = rentDAO.carDel(carNum);

		if(result!=0){
			System.out.println();
			System.out.println("\t▒삭제 성공▒");
			System.out.println();

		}else{
			System.out.println();
			System.out.println("\t▒삭제 실패▒");
			System.out.println();
		}

	}


	//전체 예약자 조회
	@Override
	public void allSearch() {

		AllDTO allDTO = new AllDTO();

		List<AllDTO> allSearchList = rentDAO.searchAllRes();

		Iterator<AllDTO> printIt = allSearchList.iterator();

		System.out.println("                                                ▒    전체 예약자 목록    ▒                                                  ");
		System.out.println("===============================================================================================================================");
		System.out.println("   예약번호 | 차량번호 | 제조사 |   차종   |  이름  |     연락처     |   대여일   |   반납일   |   보험   |  대여료  |  상태 ");
		System.out.println("===============================================================================================================================");

		while(printIt.hasNext()){

			AllDTO dto = printIt.next();
			System.out.println(dto.toString());
		}
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

	}//end...run()


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



}//end...class




