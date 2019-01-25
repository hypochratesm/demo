package com.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Test2 extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;

	private JTextField[] tf= new JTextField[4];//�Է��� ������ 4��...
	private JButton btn1,btn2;
	private JTable table;

	public Test2(){

		getContentPane().setLayout(null);

		String[] caption = {"�̸�","����","����","����"};

		for(int i=0; i <caption.length;i++){

			JLabel lbl = new JLabel(caption[i]);
			lbl.setBounds(10, (i+1)*30, 50, 20);
			getContentPane().add(lbl);

			tf[i] = new JTextField();
			tf[i].setBounds(80, (i+1)*30, 70, 20);
			getContentPane().add(tf[i]);

		}

		btn1 = new JButton("�߰�");
		btn1.setBounds(10, 160, 60, 20);
		btn1.addActionListener(this);
		getContentPane().add(btn1);

		btn2 = new JButton("����");
		btn2.setBounds(90, 160, 60, 20);
		btn2.addActionListener(this);
		getContentPane().add(btn2);


		addTable();




		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setTitle("����ó��");
		setSize(550,250);
		setVisible(true);


	}

	private void addTable(){

		String[] title = {"�̸�","����","����","����","����","���"};

		MytableModel model = new MytableModel(title);//�����ڰ� ��� ������ �߻��Ѵ�.
		table = new JTable(model);

		//��ũ�ѹ� ����
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(160,30, 355, 150);
		getContentPane().add(sp);

		//�÷�ũ�� �ڵ� ���� off//�����Ͱ� ���ٰ� �ؼ� �ݷ��� ũ�Ⱑ ������ �ʴ´�.

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//�÷��� ����.
		for(int i = 0;i<title.length;i++){

			TableColumn col = table.getColumnModel().getColumn(i);
			col.setPreferredWidth(55);

		}
	}



	class MytableModel extends DefaultTableModel{//�������̵�.


		private static final long serialVersionUID = 1L;

		private String[] title;//������������ ������ �����̶�� ���Ѵ�.

		public MytableModel(String[] title){
			this.title = title;
		}


		public int getColumnCount(){

			if(title==null||title.length==0)
				return 0 ;
			return title.length;

		}

		public String getColumnName(int column){


			if(title==null||title.length==0)
				return null;
			return title[column];



		}



	}

	public static void main(String[] args) {

		new Test2();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object ob = e.getSource();

		if(ob instanceof JButton){

			JButton b = (JButton)ob;

			if(b==btn1){
				
				process();


			}else if(b==btn2){

				System.exit(0);
			}



		}



	}
	private void process(){
		
		String[] data = new String[6];
		int tot;
		
		try {
			
			tot = 0;
			
			data[0] = tf[0].getText();
			
			for(int i = 1;i<=3;i++){
				
				data[i] = tf[i].getText();//������
				
				tot+=Integer.parseInt(tf[i].getText());//����
				
				
			}
			
			data[4] = Integer.toString(tot);//������ �־��ش�.
			data[5] = Integer.toString(tot/3);//����� �־��ش�.
			
			
			//table�� �迭�� �ֱ�
			((MytableModel)table.getModel()).addRow(data);		
			
			//tf�ʱ�ȭ
			
		for(int i =0; i<tf.length;i++){
			
			tf[i].setText("");
		}
		
		tf[0].requestFocus();
			
			
		} catch (Exception e) {
			
		}


	}


}