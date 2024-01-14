import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class Feesupdate extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JButton bt1,bt2;
	Choice ch1,ch2;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
	JPanel p1,p2,p3;
	
	Feesupdate(){
		super("Fees Update");
		setSize(650,300);
		setLocation(270,250);
		setResizable(false);
		
		Font f2 = new Font("Lucida Fax",Font.BOLD,25);
		Font f1 = new Font("MS UI Gothic",Font.BOLD,18);
		
		l1=new JLabel("Customer ID");
		l2=new JLabel("Name");
		l3=new JLabel("Month");
		l4=new JLabel("Charge fees Per Month");
		l5=new JLabel("Fees Update");
		l5.setFont(f1);
		l5.setHorizontalAlignment(JLabel.CENTER);
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		
		l1.setFont(f1);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		tf1.setFont(f1);
		tf2.setFont(f1);
		tf3.setFont(f1);
		
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		l5.setForeground(Color.YELLOW);
		
		ch1=new Choice();
		try{
			ConnectionClass obj = new ConnectionClass();
			String q = "select id from feesinfo";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()){
				ch1.add(rest.getString("id"));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		ch1.setFont(f1);
		
		ch2=new Choice();
		ch2.add("January");
		ch2.add("February");
		ch2.add("March");
		ch2.add("April");
		ch2.add("May");
		ch2.add("June");
		ch2.add("July");
		ch2.add("August");
		ch2.add("September");
		ch2.add("October");
		ch2.add("November");
		ch2.add("December");
		
		ch2.setFont(f1);
		
		bt1=new JButton("Update");
		bt2=new JButton("Delete");
		
		bt1.setFont(f1);
		bt2.setFont(f2);

		bt1.setBackground(Color.BLACK);
		bt1.setForeground(Color.CYAN);
		bt2.setBackground(Color.BLACK);
		bt2.setBackground(Color.RED);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l5);
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(7,2,10,10));
		
		p2.add(l1);
		p2.add(ch1);
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(ch2);
		p2.add(l4);
		p2.add(tf2);
		p2.add(bt1);
		p2.add(bt2);
		
		p1.setBackground(Color.BLACK);
		p2.setBackground(Color.BLACK);
		
		setLayout(new BorderLayout(0,0));
		
		add(p1,"North");
		add(p2,"Center");
		
		ch1.addMouseListener(new MouseAdapter()
		{
			
			public void mouseClicked(MouseEvent arg){
				int cus_id=Integer.parseInt(ch1.getSelectedItem());
				try{
					ConnectionClass obj1 = new ConnectionClass();
					
					String qry="select * from feesinfo where id='"+cus_id+"'";
					ResultSet rest1=obj1.stm.executeQuery(qry);
					while(rest1.next()){
						tf1.setText(rest1.getString("name"));
						tf2.setText(rest1.getString("fees"));
						
					}
					
				}
				catch(Exception exx){
					//exx.printStackTrace();
					JOptionPane.showMessageDialog(null,"Canot Selected");
				}
				}
		});
		
		
		
		
		
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		String id = ch1.getSelectedItem();
		String name = tf1.getText();
		String month = ch2.getSelectedItem();
		float fees = Float.parseFloat(tf2.getText());
		try{
			if(e.getSource()==bt1){
				ConnectionClass obj = new ConnectionClass();
				String q="update feesinfo set name='"+name+"',month='"+month+"',fees='"+fees+"' where id='"+id+"'";
				obj.stm.executeQuery(q);
				JOptionPane.showMessageDialog(null,"Data Update Successfull");
				setVisible(false);
			}
			else if(e.getSource()==bt2){
				ConnectionClass obj9 = new ConnectionClass();
				String q = "delete from feesinfo where id='"+id+"'";
				obj9.stm.executeQuery(q);
				JOptionPane.showMessageDialog(null,"Data Deleted");
				setVisible(false);
				//new Customerlist().setVisible(true);
			}
		}
		catch(Exception exxx){
			//exxx.printStackTrace();
			JOptionPane.showMessageDialog(null,"Data Cannot Updated");
		}
	}
	
	public static void main(String args[]){
		new Feesupdate().setVisible(true);
	}
}