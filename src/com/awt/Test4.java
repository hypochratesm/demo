package com.awt;
//이벤트 단위의 프로그램을 만드는 방법.

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//가장자리에서의 이벤트는 어댑터
//텍스트 안에서 발생하는 이벤트는 action performed



public class Test4 extends Frame implements ActionListener{//객체의 행위에 대한 감시자.

	private Button btn;   //변수선언
	private TextArea ta;
	private TextField tf;



	private static final long serialVersionUID = 1L;

	public Test4(){

		tf = new TextField();
		ta = new TextArea();
		btn = new Button("추가");
		
		tf.addActionListener(this);//텍스트 필드에 추가한다.//감시자들이 필드와 에어리어에 생성 되었다.
		btn.addActionListener(this);


		add(tf,BorderLayout.NORTH);//위쪽에 추가한다.
		add(ta,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);

		setTitle("윈도우");
		setSize(200,300);

		addWindowListener(new WindowAdapter() {//무명의 클래스//종료의 코딩... 종료할때 무조건 사용해준다.

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}


		});

		setVisible(true);
	}

	public static void main(String[] args) {

		new Test4();

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		//자바가 스스로 해주는 것은 object로 받아야 한다.
		
		
		
		Object ob = evt.getSource();

		if(ob instanceof Button  || ob instanceof TextField){

			String str = tf.getText();//사용자가 입력한 값을 str에 넣어준다.

			if(!str.equals("")){//str에 있는 값이 null이 아니라면

				ta.append(str + "\n\r");


			}
			
			tf.setText("");
			tf.requestFocus();
		}


	}





}



