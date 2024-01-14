import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class adminInfo extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField txt1,txt2;
	JButton btn1,btn2;
	JPanel p1,p2;
	
	adminInfo(){
		super("Admin Information");
		setLocation(50,50);
		setSize(400,200);
		setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/ELCOT/Desktop/javaGym/243.jpg");
		setIconImage(icon);
			
			
		l1 = new JLabel("Admin Information");
		l2 = new JLabel("New Username");
		l3 = new JLabel("New Password");
		
		txt1 = new JTextField();
		txt2 = new JTextField();
		
		btn1 = new JButton("Update");
		btn2 = new JButton("Cancel");
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		l1.setHorizontalAlignment(JLabel.CENTER);
		p1=new JPanel();
		p1.setLayout(new GridLayout(3,3,10,10));
		p1.add(l2);
		p1.add(txt1);
		p1.add(l3);
		p1.add(txt2);
		p1.add(btn1);
		p1.add(btn2);
		p1.setBackground(Color.BLACK);
		
		
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		
		btn1.setBackground(Color.BLACK);
		btn2.setBackground(Color.BLACK);
		
		btn1.setForeground(Color.WHITE);
		btn2.setForeground(Color.RED);
		
		
		
		setLayout(new BorderLayout(30,30));
		
		add(l1,"North");
		add(p1,"Center");
		
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
	
	
	}
	public void actionPerformed(ActionEvent e){
		String username = txt1.getText();
			String password = txt2.getText();
			
			if(e.getSource()==btn1){
				try{
				ConnectionClass obj = new ConnectionClass();
				String q="update login set username='"+username+"',password='"+password+"' where id = 1";
				ResultSet rest = obj.stm.executeQuery(q);
				if(rest.next()){
					JOptionPane.showMessageDialog(null,"Data Updated");
					new Homepage().setVisible(true);
					this.setVisible(false);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}}
			if(e.getSource()==btn2){
				JOptionPane.showMessageDialog(null,"Are You Sure..?");
				this.setVisible(false);
			}
	}
	
	public static void main(String args[]){
		new adminInfo().setVisible(true);
	}
	
}
