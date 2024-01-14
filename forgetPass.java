import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class forgetPass extends JFrame implements ActionListener
{
	
	JLabel l1,l2,l3;
	JTextField txt1,txt2;
	JButton btn1,btn2;
	JPanel p1,p2;
	
	forgetPass(){
		super("Forget Password");
		setLocation(50,50);
		setSize(400,200);
		setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/ELCOT/Desktop/javaGym/243.jpg");
		setIconImage(icon);
		
		l1 = new JLabel("Forget Password");
		l2 = new JLabel("ID");
		l3 = new JLabel("New Password");
		
		txt1 = new JTextField();
		txt2 = new JTextField();
		
		btn1 = new JButton("Set");
		btn2 = new JButton("Cancel");
		
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.RED);
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		
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
		
		setLayout(new BorderLayout(30,30));
		getContentPane().setBackground(Color.BLACK);
		
		add(l1,"North");
		add(p1,"Center");
		
	}
		public void actionPerformed(ActionEvent e){
			String id = txt1.getText();
			String pass = txt2.getText();
			/*if(pass==conpass){System.out.println("ok");}
			else{System.out.println("Nook");}*/
			if(e.getSource()==btn1){
				try{
				ConnectionClass obj = new ConnectionClass();
				String q="update login set password='"+pass+"' where id = '"+id+"'";
				ResultSet rest = obj.stm.executeQuery(q);
				if(rest.next()){
					JOptionPane.showMessageDialog(null,"Password Updated");
					new login().setVisible(true);
					this.setVisible(false);
				}
			}catch(Exception ex){
				//ex.printStackTrace();
				JOptionPane.showMessageDialog(null,"Invalid ID....");
			}}
			
			if(e.getSource()==btn2){
				JOptionPane.showMessageDialog(null,"Are You Sure..?");
				this.setVisible(false);
				new login().setVisible(true);
			}
		}
		
	
	
	public static void main(String args[]){
		new forgetPass().setVisible(true);
	}
}