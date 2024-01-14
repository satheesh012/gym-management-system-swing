import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

import java.util.Date;

class Updatedelete extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
	Choice ch1,ch2,ch3;
	JButton bt1,bt2;
	JPanel p1,p2,p3;
	Font f,f1;
	
	
	Updatedelete(){
		super("Update & Delete Customer");
		setSize(750,700);
		setLocation(10,10);
		setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/ELCOT/Desktop/javaGym/243.jpg");
		setIconImage(icon);
		
		f = new Font("Lucida Fax",Font.BOLD,25);
		f1 = new Font("MS UI Gothic",Font.BOLD,18);
		
		l14 = new JLabel("ID");
		l1=new JLabel("Name");
		l2=new JLabel("Date-of-Birth");
		l3=new JLabel("Father Name");
		l4=new JLabel("Email");
		l5=new JLabel("Address");
		l6=new JLabel("Contact no");
		l7=new JLabel("Aadhar no");
		l8=new JLabel("Payments plan(month)");
		l9=new JLabel("Gender");
		l10=new JLabel("Height(inc)");
		l11=new JLabel("weight(kg)");
		l12=new JLabel("Remarks");
		l13=new JLabel("Update and Delete");
		
		
		
		l12.setFont(f1);
		l12.setForeground(Color.YELLOW);
		
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf6=new JTextField();
		tf7=new JTextField();
		tf8=new JTextField();
		tf9=new JTextField();
		tf10=new JTextField();
		
		
		ch1=new Choice();
		try{
			ConnectionClass obj0 = new ConnectionClass();
			String q0="select id from addcustomer";
			ResultSet rest = obj0.stm.executeQuery(q0);
			while(rest.next()){
				ch1.add(rest.getString("id"));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		ch2=new Choice();
		ch3=new Choice();
		
		ch2.add("1 month");
		ch2.add("2 month");
		ch2.add("3 month");
		ch2.add("12 month");
		
		ch3.add("Male");
		ch3.add("Female");
		ch3.add("Transgender");
		
		bt1=new JButton("Update");
		bt2=new JButton("Delete");
		
		bt1.setBackground(Color.BLACK);
		bt1.setForeground(Color.WHITE);
		bt2.setBackground(Color.BLACK);
		bt2.setForeground(Color.RED);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		l1.setFont(f);
		l2.setFont(f);
		l3.setFont(f);
		l4.setFont(f);
		l5.setFont(f);
		l6.setFont(f);
		l7.setFont(f);
		l8.setFont(f);
		l9.setFont(f);
		l10.setFont(f);
		l11.setFont(f);
		l12.setFont(f);
		l13.setFont(f);
		l14.setFont(f);
		
		tf1.setFont(f);
		tf2.setFont(f);
		tf3.setFont(f);
		tf4.setFont(f);
		tf5.setFont(f);
		tf6.setFont(f);
		tf7.setFont(f);
		tf8.setFont(f);
		tf9.setFont(f);
		tf10.setFont(f);
		
		
		bt1.setFont(f);
		bt2.setFont(f);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(15,2,10,10));
		p1.add(l14);
		p1.add(ch1);
		p1.add(l1);
		p1.add(tf1);
		p1.add(l2);
		p1.add(tf2);
		p1.add(l3);
		p1.add(tf3);
		p1.add(l4);
		p1.add(tf4);
		p1.add(l5);
		p1.add(tf5);
		p1.add(l6);
		p1.add(tf6);
		p1.add(l7);
		p1.add(tf7);
		
		p1.add(l8);
		p1.add(ch2);
		
		p1.add(l9);
		p1.add(ch3);
		
		p1.add(l10);
		p1.add(tf8);
		p1.add(l11);
		p1.add(tf9);
		p1.add(l12);
		p1.add(tf10);
		
		p1.add(bt1);
		p1.add(bt2);
		
		
		
		p1.setBackground(Color.BLACK);
		
		
		
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		l5.setForeground(Color.WHITE);
		l6.setForeground(Color.WHITE);
		l7.setForeground(Color.WHITE);
		l8.setForeground(Color.WHITE);
		l9.setForeground(Color.WHITE);
		l10.setForeground(Color.WHITE);
		l11.setForeground(Color.WHITE);
		l12.setForeground(Color.WHITE);
		l13.setForeground(Color.RED);
		getContentPane().setBackground(Color.BLACK);
		l14.setForeground(Color.WHITE);
		
		
		setLayout(new BorderLayout(0,0));
		l13.setHorizontalAlignment(JLabel.CENTER);
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		add(l13,"North");
		add(p1,"Center");
		
		ch1.addMouseListener(new MouseAdapter()
		{
			
			public void mouseClicked(MouseEvent arg0){
				try{
					ConnectionClass obj2 = new ConnectionClass();
					int cus_id=Integer.parseInt(ch1.getSelectedItem());
					String qry="select * from addcustomer where id='"+cus_id+"'";
					ResultSet rest1=obj2.stm.executeQuery(qry);
					while(rest1.next()){
						tf1.setText(rest1.getString("name"));
						tf2.setText(rest1.getString("dob"));
						tf3.setText(rest1.getString("fname"));
						tf4.setText(rest1.getString("email"));
						tf5.setText(rest1.getString("address"));
						tf6.setText(rest1.getString("cont"));
						tf7.setText(rest1.getString("aadhar"));
						tf8.setText(rest1.getString("height"));
						tf9.setText(rest1.getString("weight"));
						tf10.setText(rest1.getString("remarks"));
						//ch2.setText(rest1.getString("minag"));
						//ch3.setText(rest1.getString("gender"));
					}
				}
				catch(Exception exx){
					//exx.printStackTrace();
					JOptionPane.showMessageDialog(null,"Data Cannot Updated");
				}
			}
		});
		
	}
	
	public void actionPerformed(ActionEvent e){
		String name = tf1.getText();
		String dob = tf2.getText();
		String fname = tf3.getText();
		String email = tf4.getText();
		String address = tf5.getText();
		String cont = tf6.getText();
		String aadhar =tf7.getText();
		int id = Integer.parseInt(ch1.getSelectedItem());
		String minag = ch2.getSelectedItem();
		String gender = ch3.getSelectedItem();
		float height =Float.parseFloat(tf8.getText());
		float weight =Float.parseFloat(tf9.getText());
		String remarks = tf10.getText();
		
		
		try{
			if(e.getSource()==bt1){
				ConnectionClass obj = new ConnectionClass();
				String q="update addcustomer set name='"+name+"',fname='"+fname+"',email='"+email+"',address='"+address+"',cont='"+cont+"',minag='"+minag+"',gender='"+gender+"',height='"+height+"',weight='"+weight+"',remarks='"+remarks+"',aadhar='"+aadhar+"',dob='"+dob+"' where id='"+id+"'";
				obj.stm.executeQuery(q);
				JOptionPane.showMessageDialog(null,"Data Update Successfull");
				setVisible(false);
			}
			else if(e.getSource()==bt2){
				ConnectionClass obj9 = new ConnectionClass();
				String q = "delete from addcustomer where id='"+id+"'";
				obj9.stm.executeQuery(q);
				JOptionPane.showMessageDialog(null,"Data Deleted");
				setVisible(false);
				//new Customerlist().setVisible(true);
			}}
		catch(Exception exxx){
			JOptionPane.showMessageDialog(null,"Data Cannot Updated");
			//setVisible(true);
		}
		
		
		/*if(e.getSource()==bt2){
			try{
				ConnectionClass obj9 = new ConnectionClass();
				String q = "delete from addcustomer where id='"+id+"'";
				obj9.stm.executeQuery(q);
				JOptionPane.showMessageDialog(null,"Data Deleted");
				setVisible(false);
				//new Customerlist().setVisible(true);
			}
			catch(Exception exxxx){
				exxxx.printStackTrace();
				//JOptionPane.showMessageDialog(null,"Data Cannot Delete");
			}
		}
		else{
			JOptionPane.showMessageDialog(null,"Data Cannot Delete");
			this.setVisible(true);
		}*/
	}
	
	public static void main(String args[]){
		new Updatedelete().setVisible(true);
	}
	
	
}























































