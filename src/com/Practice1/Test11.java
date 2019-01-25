package com.Practice1;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;

	class CarVO {

		String string1;
		String string2;
		String string3;
		String string4;
		String string5;
		String string6;

		public CarVO(String str1, String str2, String str3, String str4,
				String str5, String str6) {

			string1 = str1;
			string2 = str2;
			string3 = str3;
			string4 = str4;
			string5 = str5;
			string6 = str6;

		}

		public CarVO() {
		
		}

		@Override
		public String toString() {
			String str = string1 + " | " + string2 + " | " + string3 + " | "
					+ string4 + " | " + string5 + " | " + string6;
			return str;
		}

	}

	public class Test11 {

		public static void main(String[] args) {
			List<CarVO> lists = new ArrayList<CarVO>();

			File f = new File("d:\\prj\\carList.txt");

			String[] splitedStr;

			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						new FileInputStream(f), "utf-8"));

				String line = null;
				splitedStr = null;

				while ((line = br.readLine()) != null) {

					splitedStr = null;
					splitedStr = line.split(" ");

					for (int i = 0; i < splitedStr.length; i++) {
						splitedStr[i] = splitedStr[i].trim();
					}

					lists.add(new CarVO(splitedStr[0], splitedStr[1],
							splitedStr[2], splitedStr[3], splitedStr[4],
							splitedStr[5]));

				}
				br.close();

			} catch (Exception e) {
				// TODO: handle exception
			}

			Iterator<CarVO> it = lists.iterator();
			while (it.hasNext()) {
				CarVO vo = it.next();
				System.out.println(vo.toString());
			}

		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


