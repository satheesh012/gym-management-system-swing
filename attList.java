import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class attList extends JFrame implements ActionListener{
	String x[]={"Cutomer ID","Time","Attendance","Date"};
	JButton bt;
	JPanel p1,p2;
	JLabel l1,l2;
	JTextField tf1;
	Font f1,f2;
	String s[][]=new String[20][4];
	int i=0,j=0;
	JTable t;
	Font f;
	
	JButton btn1,btn2,btn3;
	Choice ch1,ch2;
	
	
	
	attList(){
		super("Attendance List");
		setSize(800,400);
		setLocation(1,1);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/ELCOT/Desktop/javaGym/243.jpg");
		setIconImage(icon);
		
		
		
		btn1 = new JButton("ID");
		
		
		btn2 = new JButton("All");
		ch1=new Choice();
		try{
			ConnectionClass obj = new ConnectionClass();
			String q = "select id from attendance";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()){
				ch1.add(rest.getString("id"));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		JScrollPane sp = new JScrollPane(t);
		
		f1=new Font("Lucida Fax",Font.BOLD,25);
		
		p1 = new JPanel();
		p1.add(btn1);
		p1.add(ch1);
		p1.add(btn2);
		p1.add(sp);
		add(p1,"West");
		p1.setBackground(Color.BLACK);
		//setVisible(true);
		
		
		btn1.addActionListener(this);
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		btn2.addActionListener(this);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.WHITE);
		
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btn1){
			try{
			ConnectionClass obj = new ConnectionClass();
			int cus_id=Integer.parseInt(ch1.getSelectedItem());
			String q="Select * from attendance where id='"+cus_id+"'";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()){
				i=0;
				s[i][j++]=rest.getString("id");
				s[i][j++]=rest.getString("time");
				s[i][j++]=rest.getString("atten");
				s[i][j++]=rest.getString("data");
				i++;
				j=0;i=0;
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
		}
		
		if(e.getSource()==btn2){
			try{
			ConnectionClass obj = new ConnectionClass();
			String q="Select * from attendance";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()){
				
				s[i][j++]=rest.getString("id");
				s[i][j++]=rest.getString("time");
				s[i][j++]=rest.getString("atten");
				s[i][j++]=rest.getString("data");
				i++;j=0;
			}
			//i=0;
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
		new attList().setVisible(true);
	}
}