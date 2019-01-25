package com.swing;//awt를 보완해서 나온것

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Test1 extends JFrame implements ActionListener{


	private static final long serialVersionUID = 1L;

	private JLabel lbl;

	public Test1(){

		lbl = new JLabel("메시지",JLabel.CENTER);

		//메뉴추가

		JMenuBar mbar = new JMenuBar();

		JMenu menu;
		JMenuItem mi;

		getContentPane().add(lbl);

		menu = new JMenu("메세지 대화상자");


		mi = new JMenuItem("메시지");
		mi.addActionListener(this);
		menu.add(mi);

		mi = new JMenuItem("입력");
		mi.addActionListener(this);
		menu.add(mi);

		mi = new JMenuItem("종료");
		mi.addActionListener(this);
		menu.add(mi);

		mbar.add(menu);

		setJMenuBar(mbar);//메뉴를 기존에 창에 넣어주는 역할.


		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setTitle("대화상자");
		setSize(300,300);
		setVisible(true);


	}


	public static void main(String[] args) {
		new Test1();

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		String str = e.getActionCommand();
		//위에서 넘어온 e의 액션커맨드를 받는다.


		if(str.equals("메시지")){

			JOptionPane.showMessageDialog(this, "오늘은 목요일 입니다!", "요일",JOptionPane.INFORMATION_MESSAGE);


		}else if(str.equals("입력")){


			String age = JOptionPane.showInputDialog(this,"당신의 나이는?","나이입력",JOptionPane.QUESTION_MESSAGE);

			lbl.setText("당신은" +age + "살 이군요!");

		}else if(str.equals("종료")){


			int result;

			result = JOptionPane.showConfirmDialog(this, "프로그램을 종료 하시겠습니까?","종료확인",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

			/*System.out.println(JOptionPane.YES_OPTION);
			 */

			if(result==JOptionPane.YES_OPTION)//여기서 yes 옵션이 갖는 값..
				System.exit(0);


		}





	}



}
