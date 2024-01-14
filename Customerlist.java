import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class Customerlist extends JFrame{
	String x[]={"Cutomer ID","Name","DOB","Father's Name","Email","Address","Contact no","Aadhar","Payments Plan","Gender","Height","Weight","Remarks"};
	JButton bt;
	JPanel p1,p2,p3;
	JLabel l1,l2;
	JTextField tf1;
	Font f1,f2;
	String s[][]=new String[43][13];
	int i=0,j=0;
	JTable t;
	Font f;
	
	Customerlist(){
		super("Customer List");
		setSize(1800,1000);
		setLocation(1,1);
		f=new Font("MS UI Gothic",Font.BOLD,15);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/ELCOT/Desktop/javaGym/243.jpg");
		setIconImage(icon);
		try{
			ConnectionClass obj = new ConnectionClass();
			String q="Select * from addcustomer";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()){
				s[i][j++]=rest.getString("id");
				s[i][j++]=rest.getString("name");
				s[i][j++]=rest.getString("dob");
				s[i][j++]=rest.getString("fname");
				s[i][j++]=rest.getString("email");
				s[i][j++]=rest.getString("address");
				s[i][j++]=rest.getString("cont");
				s[i][j++]=rest.getString("aadhar");
				s[i][j++]=rest.getString("minag");
				s[i][j++]=rest.getString("gender");
				s[i][j++]=rest.getString("height");
				s[i][j++]=rest.getString("weight");
				s[i][j++]=rest.getString("remarks");
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
		
		add(sp);
		
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	}
	public static void main(String args[]){
		new Customerlist().setVisible(true);
	}
}