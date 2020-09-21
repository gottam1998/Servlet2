package HandsOn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String loginId=request.getParameter("loginId");
System.out.println(loginId);
String password=request.getParameter("password");
System.out.println(password);
Connection con=null;
LoginClass loginClass=null;
try{

           Class.forName("com.mysql.jdbc.Driver");

           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hcl","root","reddy");

           PreparedStatement ps=con.prepareStatement("select * from login where loginId=? and password=?");
           
           ps.setString(1, loginId);
           
       		ps.setString(2, password);
       	
           ResultSet rs=ps.executeQuery();

           if(rs.next()) {
           loginClass = new LoginClass();
           loginClass.setLoginId(rs.getString(1));
           loginClass.setPassword(rs.getString(2));
           }
           if(loginClass!=null) {
        	   request.getRequestDispatcher("Success.html").forward(request, response);
           }

           else {
					request.getRequestDispatcher("Error.html").forward(request, response);		
           }       

       }

        catch(Exception e){

           System.out.println(e);

        }
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
}

}

