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

	private JTextField[] tf= new JTextField[4];//입력할 정보가 4개...
	private JButton btn1,btn2;
	private JTable table;

	public Test2(){

		getContentPane().setLayout(null);

		String[] caption = {"이름","국어","영어","수학"};

		for(int i=0; i <caption.length;i++){

			JLabel lbl = new JLabel(caption[i]);
			lbl.setBounds(10, (i+1)*30, 50, 20);
			getContentPane().add(lbl);

			tf[i] = new JTextField();
			tf[i].setBounds(80, (i+1)*30, 70, 20);
			getContentPane().add(tf[i]);

		}

		btn1 = new JButton("추가");
		btn1.setBounds(10, 160, 60, 20);
		btn1.addActionListener(this);
		getContentPane().add(btn1);

		btn2 = new JButton("종료");
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

		setTitle("성적처리");
		setSize(550,250);
		setVisible(true);


	}

	private void addTable(){

		String[] title = {"이름","국어","영어","수학","총점","평균"};

		MytableModel model = new MytableModel(title);//생성자가 없어서 에러가 발생한다.
		table = new JTable(model);

		//스크롤바 생성
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(160,30, 355, 150);
		getContentPane().add(sp);

		//컬럼크기 자동 변경 off//데이터가 많다고 해서 콜럼의 크기가 변하지 않는다.

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//컬럼폭 지정.
		for(int i = 0;i<title.length;i++){

			TableColumn col = table.getColumnModel().getColumn(i);
			col.setPreferredWidth(55);

		}
	}



	class MytableModel extends DefaultTableModel{//오버라이드.


		private static final long serialVersionUID = 1L;

		private String[] title;//스프링에서는 의존성 주입이라고 말한다.

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
				
				data[i] = tf[i].getText();//국영수
				
				tot+=Integer.parseInt(tf[i].getText());//총점
				
				
			}
			
			data[4] = Integer.toString(tot);//총점을 넣어준다.
			data[5] = Integer.toString(tot/3);//평균을 넣어준다.
			
			
			//table에 배열값 넣기
			((MytableModel)table.getModel()).addRow(data);		
			
			//tf초기화
			
		for(int i =0; i<tf.length;i++){
			
			tf[i].setText("");
		}
		
		tf[0].requestFocus();
			
			
		} catch (Exception e) {
			
		}


	}


}
