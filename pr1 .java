package project1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class pr1 
{
	public static void main(String [] args) {
		String url = "jdbc:mysql://localhost:3306/db2";
		String user = "root";
		String password = "root";
		
		String filePath = "C:\\New folder\\vijay.jpg";
		
		try {
			  Connection conn = DriverManager.getConnection(url,user, password);
			
			String sql = "INSERT INTO dbtable2 (name,img) value (?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,"Ravina");
			
			InputStream inputStream = new FileInputStream(new File(filePath));
			statement.setBlob(2,inputStream);
			
			int row = statement.executeUpdate();
			if(row > 0) {
				System.out.println("A contact was inserted with photo image.");
			}
			conn.close();
			
			
		}catch (SQLException ex) {
			ex.printStackTrace();
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
			
		

}


}
