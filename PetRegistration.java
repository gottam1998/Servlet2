package HandsOn;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PetRegistration")
public class PetRegistration extends HttpServlet {
private static final long serialVersionUID = 1L;
  
    public PetRegistration() {
        super();
       
    }
    
    

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String firstName= request.getParameter("firstName");
    String lastName= request.getParameter("lastName");
    String address= request.getParameter("address");
    String emailID= request.getParameter("emailID");
    String city= request.getParameter("city");
    String state= request.getParameter("state");
    String petName= request.getParameter("petName");
    String phoneNumber= request.getParameter("phoneNumber");
    String petType= request.getParameter("petType");
    int petsAge= Integer.parseInt(request.getParameter("petsAge"));
    
    Connection con=null;;
try {
Class.forName("com.mysql.jdbc.Driver");

           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hcl","root","reddy");
           PreparedStatement ps=con.prepareStatement("insert into pet values(?,?,?,?,?,?,?,?,?,?)");

ps.setString(1, firstName);
ps.setString(2, lastName);
ps.setString(3, address);
ps.setString(4, emailID);
ps.setString(5, city);
ps.setString(6, state);
ps.setString(7, petName);
ps.setString(8, phoneNumber);
ps.setString(9, petType);
ps.setInt(10, petsAge);
int i=ps.executeUpdate();
if(i==1)
	System.out.println("success");
else
	System.out.println("fail");
}
catch(Exception e){
e.printStackTrace();
}
 
}


}

