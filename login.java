import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
	JLabel l1,l2,l3;
	JTextField tf;
	JPasswordField pf;
	JPanel p1,p2;
	JButton btn1,btn2,btn3,btn4,btn5,btn6;
	Font f,f1;
	
	login(){
		super("login");
		setLocation(50,50);
		setSize(400,300);
		setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/ELCOT/Desktop/javaGym/243.jpg");
		setIconImage(icon);
		
		f = new Font("Arial",Font.BOLD,20);
		f1 = new Font("Arial",Font.BOLD,15);
		
		l1=new JLabel("Welcome to Fitness");
		l2=new JLabel("Username");
		l3=new JLabel("Password");
		
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setForeground(Color.RED);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		
		l1.setFont(f);
		l2.setFont(f1);
		l3.setFont(f1);
		
		tf = new JTextField();
		pf = new JPasswordField();
		
		tf.setFont(f1);
		pf.setFont(f1);
		
		btn1=new JButton("Login");
		btn2=new JButton("Cancel");
		btn3=new JButton("Forget Password");
		btn4=new JButton("AttendanceList");
		btn5=new JButton("FeesList");
		btn6=new JButton("Default");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		
		btn1.setBackground(Color.BLACK);
		btn2.setBackground(Color.BLACK);
		btn4.setBackground(Color.BLACK);
		btn5.setBackground(Color.BLACK);
		btn3.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		btn2.setForeground(Color.WHITE);
		btn3.setForeground(Color.RED);
		btn4.setForeground(Color.WHITE);
		btn5.setForeground(Color.WHITE);
		btn1.setFont(f1);
		btn2.setFont(f1);
		btn3.setFont(f1);
		btn4.setFont(f1);
		btn5.setFont(f1);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(4,2,10,10));
		p1.add(l2);
		p1.add(tf);
		p1.add(l3);
		p1.add(pf);
		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);
		p1.setBackground(Color.BLACK);
		//p1.add(btn6);
		
		p2 = new JPanel();
		p2.add(btn4);
		p2.add(btn5);
		p2.setBackground(Color.BLACK);
		setLayout(new BorderLayout(30,30));
		
		add(l1,"North");
		add(p1,"Center");
		add(p2,"South");
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);

		
	}
	
	public void actionPerformed(ActionEvent e){
		String name = tf.getText();
		String pass = pf.getText();
		
		if(e.getSource()==btn1){
			try{
				ConnectionClass obj = new ConnectionClass();
				String q="select * from login where username='"+name+"' and password='"+pass+"'";
				ResultSet rest = obj.stm.executeQuery(q);
				if(rest.next()){
					new Homepage().setVisible(true);
					this.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null,"Not Found Any Data");
					this.setVisible(true);
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		if(e.getSource()==btn2){
			JOptionPane.showMessageDialog(null,"Are You Sure to cancel...?");
			this.setVisible(true);
			setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		}
		if(e.getSource()==btn6){
			JOptionPane.showMessageDialog(null,"I am Waste");
			
		}
		if(e.getSource()==btn3){
			this.setVisible(false);
			new forgetPass().setVisible(true);
		}
		if(e.getSource()==btn4){
			
			new attList().setVisible(true);
			this.setVisible(true);
		}
		if(e.getSource()==btn5){
			
			new feesList().setVisible(true);
			this.setVisible(true);
		}
		
		
	}
	public static void main(String args[]){
		new login().setVisible(true);
	}

}







































