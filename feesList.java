import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class feesList extends JFrame implements ActionListener{
	String x[]={"Cutomer ID","Name","Month","Fees"};
	JButton bt;
	JPanel p1,p2,p3;
	JLabel l1,l2;
	JTextField tf1;
	Font f1,f2;
	String s[][]=new String[43][4];
	int i=0,j=0;
	JTable t;
	Font f;
	
	JButton btn1,btn2,btn3;
	Choice ch1,ch2;
	
	
	feesList(){
		super("Fees List");
		setSize(900,400);
		setLocation(1,1);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/ELCOT/Desktop/javaGym/Gym.jpg");
		setIconImage(icon);
		
		//btn1 = new JButton("All");
		
		btn2 = new JButton("Month");
		ch1 = new Choice();
		ch1.add("January");
		ch1.add("February");
		ch1.add("March");
		ch1.add("April");
		ch1.add("May");
		ch1.add("June");
		ch1.add("July");
		ch1.add("August");
		ch1.add("September");
		ch1.add("October");
		ch1.add("November");
		ch1.add("December");
		
		btn3 = new JButton("ID");
		ch2=new Choice();
		try{
			ConnectionClass obj = new ConnectionClass();
			String q = "select id from feesInfo";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()){
				ch2.add(rest.getString("id"));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		p1 = new JPanel();
		//p1.add(btn1);
		p1.add(btn2);
		p1.add(ch1);
		p1.add(btn3);
		p1.add(ch2);
		p1.setBackground(Color.BLACK);
		
		add(p1,"West");
		
		//btn1.addActionListener(this);
		//btn1.setBackground(Color.BLACK);
		//btn1.setForeground(Color.WHITE);
		btn2.addActionListener(this);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.WHITE);
		btn3.addActionListener(this);
		btn3.setBackground(Color.BLACK);
		btn3.setForeground(Color.WHITE);
		
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
	}
	public void actionPerformed(ActionEvent e){
		/*if(e.getSource()==btn1){
			try{
			ConnectionClass obj = new ConnectionClass();
			String q="Select * from feesInfo";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()){
				s[i][j++]=rest.getString("id");
				s[i][j++]=rest.getString("name");
				s[i][j++]=rest.getString("month");
				s[i][j++]=rest.getString("fees");
				i++;
				j=0;
				
				
				
			}
			
			t=new JTable(s,x);
			t.setFont(f);
			t.setBackground(Color.BLACK);
			t.setForeground(Color.WHITE);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		JScrollPane sp = new JScrollPane(t);
		
		f1=new Font("Lucida Fax",Font.BOLD,25);
		
		p2 = new JPanel();
		p2.add(sp);
		add(p2,"East");
		setVisible(true);
		}*/
		
		if(e.getSource()==btn2){
			try{
			ConnectionClass obj = new ConnectionClass();
			String month=ch1.getSelectedItem();
			String q="Select * from feesInfo where month='"+month+"'";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()){
			
				s[i][j++]=rest.getString("id");
				s[i][j++]=rest.getString("name");
				s[i][j++]=rest.getString("month");
				s[i][j++]=rest.getString("fees");
				i++;
				j=0;
				
				
			}
			i=0;
		
			t=new JTable(s,x);
			t.setFont(f);
			t.setBackground(Color.BLACK);
			t.setForeground(Color.WHITE);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		JScrollPane sp = new JScrollPane(t);
		
		f1=new Font("Lucida Fax",Font.BOLD,25);
		
		p2 = new JPanel();
		p2.add(sp);
		add(p2,"East");
		setVisible(true);
		}
		
		if(e.getSource()==btn3){
			try{
			ConnectionClass obj = new ConnectionClass();
			int cus_id=Integer.parseInt(ch2.getSelectedItem());
			String q="Select * from feesInfo where id='"+cus_id+"'";
			ResultSet rest = obj.stm.executeQuery(q);
			
			while(rest.next()){
				s[i][j++]=rest.getString("id");
				s[i][j++]=rest.getString("name");
				s[i][j++]=rest.getString("month");
				s[i][j++]=rest.getString("fees");
				i++;
				j=0;
				
				
			}
			i=0;
			
			t=new JTable(s,x);
			t.setFont(f);
			t.setBackground(Color.BLACK);
			t.setForeground(Color.WHITE);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		JScrollPane sp = new JScrollPane(t);
		
		f1=new Font("Lucida Fax",Font.BOLD,25);
		
		p2 = new JPanel();
		p2.add(sp);
		add(p2,"East");
		setVisible(true);
		}
	}
	public static void main(String args[]){
		new feesList().setVisible(true);
	}	
}