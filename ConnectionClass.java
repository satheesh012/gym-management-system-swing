import java.sql.*;
public class ConnectionClass{
	Connection con;
	Statement stm;
	ConnectionClass()
	{
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@avatarsatheesh:1521:xe","system","oracle");
			stm=con.createStatement();
			if(con.isClosed()){
				System.out.println("Failed");
			}
			else{
				System.out.println("Success");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		new ConnectionClass();
	}
}