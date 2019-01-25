package exam;

import java.util.Random;
import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {

		int[] lotto = new int[6];
		boolean isWin = false;
		Scanner sc = new Scanner(System.in);
		int m=0;
		
		System.out.println("몇 게임을 하실껍니까?");
		
		int	game =sc.nextInt();
		
		Lottoloop:
		while (!isWin) {
			//난수생성
			 m++;
			for (int i = 0; i < lotto.length; i++) {
				lotto[i] = (int) (Math.random() * (45 + 1));
				//중복제거
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
				if (i == 5) {
					break;
				}
			}
			int num = 0;
			//정렬
			for (int i = 0; i < lotto.length; i++) {
				for (int j = 0; j < i; j++) {
					if (lotto[i]< lotto[j]) {
						num = lotto[j];		
						lotto[j]= lotto[i];		
						lotto[i] = num;		
					}
				}
			}
			for (int i = 0; i < lotto.length; i++) {
				System.out.print("["+lotto[i]+"]");
			}
			System.out.println();
			if (game==m) {
				System.out.println();
				System.out.println();
				System.out.println(game+"게임이 생성되었습니다");
				break Lottoloop;
			}
		}
	}

}
