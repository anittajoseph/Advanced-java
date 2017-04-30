/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class Moviedetails extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
String URL="jdbc:derby://localhost:1527/movie";

try
{
    int count=0,mcount=0,ncount=0;
  

    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con = null;
    try 
    {
        con = DriverManager.getConnection(URL,"movie","movie");
    }
    catch (SQLException ex)
    {
        Logger.getLogger(MOVIEDATA.class.getName()).log(Level.SEVERE, null, ex);
    }
    Statement stmt=con.createStatement();
    String qry="select * from APP.MOVIEDATA ";
    ResultSet rs=stmt.executeQuery(qry);
    
    while(rs.next())
    {
        String category=rs.getString("m_type");
        String name=rs.getString("m_name");
        String director=rs.getString("m_director");
        double dis=rs.getDouble("m_rating");
        Date date=rs.getDate("m_releasedate");
     
            if("u".equals(category))
             {

            // count=count+1;
                 out.println("<br/>Name of movie belongs to U category:"+name);
             }
            
             if("xyz".equals(director))
             {
                 out.println("<br/>Name of movie belongs to the XYZ director:"+name);
             }
            if(dis >= 4) 
            {
             count=count+1;   
            }
             if(name!= null) 
            {
             mcount=mcount+1;   
            }
             
              if(dis >= 2.5) 
            {
             ncount=ncount+1;   
            }
                if("xyz".equals(director))
             {
                 out.println("<br/>Name of movie belongs to the XYZ director:"+date);
             }
                
     }
              //out.println("<br/>number of movie belongs to u category:"+count);
out.println("</br>rating more than 4 is :"+count);
out.println("<br/>movie count is :"+mcount);
out.println("<br/>rating more than 2.5 is :"+ncount);

    } 

catch ( ClassNotFoundException | SQLException ex) 
    {
        Logger.getLogger(MOVIEDATA.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
