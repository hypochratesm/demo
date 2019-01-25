package com.awt;
//�̺�Ʈ ������ ���α׷��� ����� ���.

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//�����ڸ������� �̺�Ʈ�� �����
//�ؽ�Ʈ �ȿ��� �߻��ϴ� �̺�Ʈ�� action performed



public class Test4 extends Frame implements ActionListener{//��ü�� ������ ���� ������.

	private Button btn;   //��������
	private TextArea ta;
	private TextField tf;



	private static final long serialVersionUID = 1L;

	public Test4(){

		tf = new TextField();
		ta = new TextArea();
		btn = new Button("�߰�");
		
		tf.addActionListener(this);//�ؽ�Ʈ �ʵ忡 �߰��Ѵ�.//�����ڵ��� �ʵ�� ���� ���� �Ǿ���.
		btn.addActionListener(this);


		add(tf,BorderLayout.NORTH);//���ʿ� �߰��Ѵ�.
		add(ta,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);

		setTitle("������");
		setSize(200,300);

		addWindowListener(new WindowAdapter() {//������ Ŭ����//������ �ڵ�... �����Ҷ� ������ ������ش�.

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
		//�ڹٰ� ������ ���ִ� ���� object�� �޾ƾ� �Ѵ�.
		
		
		
		Object ob = evt.getSource();

		if(ob instanceof Button  || ob instanceof TextField){

			String str = tf.getText();//����ڰ� �Է��� ���� str�� �־��ش�.

			if(!str.equals("")){//str�� �ִ� ���� null�� �ƴ϶��

				ta.append(str + "\n\r");


			}
			
			tf.setText("");
			tf.requestFocus();
		}


	}





}



