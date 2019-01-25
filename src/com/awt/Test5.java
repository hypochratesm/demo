package com.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test5 extends Frame implements ActionListener {


	private static final long serialVersionUID = 1L;

	private TextField[] tf = new TextField[4];
	private Label result = new Label("",Label.LEFT);
	private Button btn1,btn2;

	public Test5(){

		String[] title = {"이름","국어","영어","수학","총점"};

		setTitle("성적처리");
		setLayout(null);//레이아웃 초기화(수동배치)
		setSize(260,180);
		setResizable(false);//확대하지 못하게 하는 메소드.

		for(int i=0;i<5;i++){

			//Label
			Label lbl = new Label();//배열 생성

			lbl.setText(title[i]);

			lbl.setBounds(10, (i+1)*30, 50, 20);//X,Y 가로 세로 값.

			add(lbl);

			//TextField

			if(i!=4){

				tf[i] = new TextField();//객체생성

				tf[i].setBounds(80, (i+1)*30, 70, 20);
				tf[i].addKeyListener(new KeyHandler());//무명의 클래스를 사용할 수 없다.//키보드에서의 감시자.

				add(tf[i]);
			}else{

				result.setBounds(80, (i+1)*30, 70, 20);
				add(result);
			}//end..if

		}//end..for

		//버튼을 넣어보자.//결과버튼

		btn1 = new Button("결과");
		btn1.setBounds(180, 30, 60, 20);
		add(btn1);

		btn1.addActionListener(this);
		btn1.addKeyListener(new KeyHandler());//버튼을 눌렀을때 감시자
		//


		//종료
		btn2 = new Button("종료");
		btn2.setBounds(180,60,60,20);
		add(btn2);

		btn2.addActionListener(this);



		addWindowListener(new WindowAdapter() {//무명의 클래스//종료의 코딩... 종료할때 무조건 사용해준다.

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}


		});

		setVisible(true);
	}

	public static void main(String[] args) {

		new Test5();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object ob = e.getSource();

		if(ob instanceof Button){//btn1,btn2


			Button b =(Button)ob;

			if(b==btn1){
		execute();

		
			}else if(b==btn2){

				System.exit(0);

			}


		}


	}
	private void execute(){

		int tot=0;

		try {

			for(int i=1; i<=3;i++){

				tot +=Integer.parseInt(tf[i].getText());

			}

			result.setText(Integer.toString(tot));//숫자를 문자로 변환.


		} catch (Exception e2) {
			result.setText("입력오류");

		}




	}

	class KeyHandler extends KeyAdapter{

		public void keyPressed(KeyEvent e){

			Object ob = e.getSource();

			if(e.getKeyCode()!=KeyEvent.VK_ENTER){
				return;

			}
			if(ob instanceof Button){
				Button b = (Button)ob;
				if(b==btn1){


					execute();
				}
				return;
			}
			if(ob instanceof TextField){

				TextField t = (TextField)ob;

				for(int i=0;i<tf.length;i++){

					if(i!=3&&tf[i]==t){

						tf[i+1].requestFocus();
						return;
					}else if(tf[3]==t){

						btn1.requestFocus();
						return;
					}
				}
			}
		}
	}
}
