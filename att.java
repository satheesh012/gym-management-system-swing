import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class att extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5;
	Choice ch1,ch2,ch3;
	Font f1,f2;
	JButton btn1,btn2;
	JPanel p1,p2;
	
	att(){
		super("Customer attendance");
		setLocation(70,80);
		setSize(400,250);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/ELCOT/Desktop/javaGym/243.jpg");
		setIconImage(icon);
		
		Font f1 = new Font("Lucida Fax",Font.BOLD,25);
		Font f2 = new Font("MS UI Gothic",Font.BOLD,18);
		
		l1=new JLabel("Customer No");
		l2=new JLabel("Select Time");
		l3=new JLabel("Take Attendance");
		l4=new JLabel("Customer Attendance");
		
		
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		
		l4.setHorizontalAlignment(JLabel.CENTER);
		
		ch1=new Choice();
		ch1.add("Morning Time");
		ch1.add("Evening Time");
		ch1.add("Full Time");
		
		ch2=new Choice();
		ch2.add("Absent");
		ch2.add("Present");
		
		ch3=new Choice();
		try{
			ConnectionClass obj = new ConnectionClass();
			String q = "select id from addcustomer";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()){
				ch3.add(rest.getString("id"));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		btn1=new JButton("Submit");
		btn2=new JButton("Cancel");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.RED);
		
		l1.setFont(f2);
		l2.setFont(f2);
		l3.setFont(f2);
		l4.setFont(f2);
		ch1.setFont(f2);
		ch2.setFont(f2);
		ch3.setFont(f2);
		btn1.setFont(f2);
		btn2.setFont(f2);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(4,2,10,10));
		p1.setBackground(Color.BLACK);
		p1.add(l1);
		p1.add(ch3);
		p1.add(l2);
		p1.add(ch1);
		p1.add(l3);
		p1.add(ch2);
		p1.add(btn1);
		p1.add(btn2);
		
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(1,1,10,10));
		p2.setBackground(Color.BLACK);
		
		p2.add(l4);
		
		setLayout(new BorderLayout(0,0));
		
		add(p1,"Center");
		add(p2,"North");
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		

	}
	
	public void actionPerformed(ActionEvent e){
		String id = ch3.getSelectedItem();
		String time=ch1.getSelectedItem();
		String atten = ch2.getSelectedItem();
		String data=new java.util.Date().toString();
		
		if(e.getSource()==btn1)
		{
			try
			{
				ConnectionClass obj1 = new ConnectionClass();
				String q1="insert into attendance values('"+id+"','"+time+"','"+atten+"','"+data+"')";
				obj1.stm.executeQuery(q1);
				
				JOptionPane.showMessageDialog(null,"Insert Attendance");
				setVisible(false);
			}
			catch(Exception exx)
			{
				exx.printStackTrace();
			}
		}
		if(e.getSource()==btn2)
		{
			JOptionPane.showMessageDialog(null,"Are You Sure...?");
			setVisible(false);
		}
			
			
				
			
		
	}
	public static void main(String args[]){
		new att().setVisible(true);
	}
}







































