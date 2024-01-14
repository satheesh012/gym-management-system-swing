import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class Homepage extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	Font f,f1,f2,f3;
	JPanel p1,p2;
	
	Homepage(){
		super("Home Page");
		setSize(1600,900);
		setLocation(0,0);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/ELCOT/Desktop/javaGym/Gym.jpg");
		setIconImage(icon);
		
		Image img = Toolkit.getDefaultToolkit().getImage("C:/Users/ELCOT/Desktop/javaGym/fit.jpg"); 
		this.setContentPane(new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(img,0,0,null);
			}
		});
		
		f = new Font("Lucida Fax",Font.BOLD,20);
		f1 = new Font("MS UI Gothic",Font.BOLD,18);
		f2 = new Font("Gadugi",Font.BOLD,35);
		f3 = new Font("Gadugi",Font.BOLD,30);
		
		JMenuBar m1 = new JMenuBar();
		//JMenu men1 = new JMenu("Menu");
		JMenu menu1 = new JMenu("Customer");
		JMenu menu2 = new JMenu("Attendance");
		JMenu menu3 = new JMenu("Fees");
		JMenu menu4 = new JMenu("Admin");
		JMenuItem ment1 = new JMenuItem("Add Customer");
		JMenuItem ment2 = new JMenuItem("Attendance");
		JMenuItem ment3 = new JMenuItem("Attendance Update");
		JMenuItem ment4 = new JMenuItem("Attendance List");
		JMenuItem ment5 = new JMenuItem("Update & Delete Customer");
		JMenuItem ment6 = new JMenuItem("Customer List");
		JMenuItem ment7 = new JMenuItem("Fees Information");
		JMenuItem ment8 = new JMenuItem("Fees Update");
		JMenuItem ment9 = new JMenuItem("Fees List");
		JMenuItem ment10 = new JMenuItem("Admin Info");
		JMenuItem ment11 = new JMenuItem("Logout");
		
		//men1.add(ment1);
		//men1.add(ment2);
		//men1.add(ment3);
		//men1.add(ment4);
		//men1.add(ment5);
		//men1.add(ment6);
		menu1.add(ment1);
		menu1.add(ment5);
		menu1.add(ment6);
		m1.add(menu1);
		
		menu2.add(ment2);
		menu2.add(ment3);
		menu2.add(ment4);
		m1.add(menu2);
		
		menu3.add(ment7);
		menu3.add(ment8);
		menu3.add(ment9);
		m1.add(menu3);
		
		menu4.add(ment10);
		menu4.add(ment11);
		m1.add(menu4);
		/*m1.add(ment1);
		m1.add(ment2);
		m1.add(ment3);
		m1.add(ment4);
		m1.add(ment5);
		m1.add(ment6);
		m1.add(ment7);
		m1.add(ment8);
		m1.add(ment9);
		m1.add(ment10);*/
		
		
		
		//men1.setFont(f);
		ment1.setFont(f1);
		ment2.setFont(f1);
		ment3.setFont(f1);
		ment4.setFont(f1);
		ment5.setFont(f1);
		ment6.setFont(f1);
		ment7.setFont(f1);
		ment8.setFont(f1);
		ment9.setFont(f1);
		ment10.setFont(f1);
		ment11.setFont(f1);
		
		menu1.setFont(f3);
		menu2.setFont(f3);
		menu3.setFont(f3);
		menu4.setFont(f3);
		
		//men1.setForeground(Color.GRAY);
		ment1.setForeground(Color.WHITE);
		ment2.setForeground(Color.WHITE);
		ment3.setForeground(Color.WHITE);
		ment4.setForeground(Color.WHITE);
		ment5.setForeground(Color.WHITE);
		ment6.setForeground(Color.WHITE);
		ment7.setForeground(Color.WHITE);
		ment8.setForeground(Color.WHITE);
		ment9.setForeground(Color.WHITE);
		ment10.setForeground(Color.WHITE);
		ment11.setForeground(Color.WHITE);
		
		menu1.setForeground(Color.RED);
		menu2.setForeground(Color.RED);
		menu3.setForeground(Color.RED);
		menu4.setForeground(Color.RED);
		
		
		//men1.setBackground(Color.YELLOW);
		ment1.setBackground(Color.BLACK);
		ment2.setBackground(Color.BLACK);
		ment3.setBackground(Color.BLACK);
		ment4.setBackground(Color.BLACK);
		ment5.setBackground(Color.BLACK);
		ment6.setBackground(Color.BLACK);
		ment7.setBackground(Color.BLACK);
		ment8.setBackground(Color.BLACK);
		ment9.setBackground(Color.BLACK);
		ment10.setBackground(Color.BLACK);
		ment11.setBackground(Color.BLACK);
		ment11.setBackground(Color.BLACK);
		
		menu1.setBackground(Color.BLACK);
		menu2.setBackground(Color.BLACK);
		menu3.setBackground(Color.BLACK);
		menu4.setBackground(Color.BLACK);
		
		m1.setBackground(Color.BLACK);
		
		ment1.addActionListener(this);
		ment2.addActionListener(this);
		ment3.addActionListener(this);
		ment4.addActionListener(this);
		ment5.addActionListener(this);
		ment6.addActionListener(this);
		ment7.addActionListener(this);
		ment8.addActionListener(this);
		ment9.addActionListener(this);
		ment10.addActionListener(this);
		ment11.addActionListener(this);
		
		
		
		setJMenuBar(m1);
		getContentPane().setBackground(Color.BLACK);
		
		
	}
	public void actionPerformed(ActionEvent e){
		String comnd = e.getActionCommand();
		if(comnd.equals("Add Customer")){
			new AddCustomer().setVisible(true);
		}
		else if(comnd.equals("Attendance")){
			new att().setVisible(true);
		}
		else if(comnd.equals("Attendance Update")){
			new attUpdate().setVisible(true);
		}
		else if(comnd.equals("Attendance List")){
			new attList().setVisible(true);
		}
		else if(comnd.equals("Update & Delete Customer")){
			new Updatedelete().setVisible(true);
		}
		else if(comnd.equals("Fees Information")){
			new Feesinfo().setVisible(true);
		}
		else if(comnd.equals("Fees Update")){
			new Feesupdate().setVisible(true);
		}
		else if(comnd.equals("Fees List")){
			new feesList().setVisible(true);
		}
		else if(comnd.equals("Customer List")){
			new Customerlist().setVisible(true);
		}
		else if(comnd.equals("Admin Info")){
			new adminInfo().setVisible(true);
		}
		else if(comnd.equals("Logout")){
			//System.exit(0);new attUpdate().setVisible(true);
			this.setVisible(false);
            new login().setVisible(true);

		}
	}
	
	public static void main(String args[]){
		new Homepage().setVisible(true);
	}
	
	
}	