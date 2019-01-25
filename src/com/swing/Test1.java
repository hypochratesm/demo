package com.swing;//awt�� �����ؼ� ���°�

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

		lbl = new JLabel("�޽���",JLabel.CENTER);

		//�޴��߰�

		JMenuBar mbar = new JMenuBar();

		JMenu menu;
		JMenuItem mi;

		getContentPane().add(lbl);

		menu = new JMenu("�޼��� ��ȭ����");


		mi = new JMenuItem("�޽���");
		mi.addActionListener(this);
		menu.add(mi);

		mi = new JMenuItem("�Է�");
		mi.addActionListener(this);
		menu.add(mi);

		mi = new JMenuItem("����");
		mi.addActionListener(this);
		menu.add(mi);

		mbar.add(menu);

		setJMenuBar(mbar);//�޴��� ������ â�� �־��ִ� ����.


		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setTitle("��ȭ����");
		setSize(300,300);
		setVisible(true);


	}


	public static void main(String[] args) {
		new Test1();

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		String str = e.getActionCommand();
		//������ �Ѿ�� e�� �׼�Ŀ�ǵ带 �޴´�.


		if(str.equals("�޽���")){

			JOptionPane.showMessageDialog(this, "������ ����� �Դϴ�!", "����",JOptionPane.INFORMATION_MESSAGE);


		}else if(str.equals("�Է�")){


			String age = JOptionPane.showInputDialog(this,"����� ���̴�?","�����Է�",JOptionPane.QUESTION_MESSAGE);

			lbl.setText("�����" +age + "�� �̱���!");

		}else if(str.equals("����")){


			int result;

			result = JOptionPane.showConfirmDialog(this, "���α׷��� ���� �Ͻðڽ��ϱ�?","����Ȯ��",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

			/*System.out.println(JOptionPane.YES_OPTION);
			 */

			if(result==JOptionPane.YES_OPTION)//���⼭ yes �ɼ��� ���� ��..
				System.exit(0);


		}





	}



}
