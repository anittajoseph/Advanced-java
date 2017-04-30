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
public class Empdetails extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
String URL="jdbc:derby://localhost:1527/Employee";

try
{
    int count=0,ecount=0,dcount=0,scount=0,ccount=0,Tcount=0,i=0,ds=0,s=0,k=0,p=0,m=0,b=0;
    double avg=0,avg1=0,avg2=0,avg3=0,avg4=0,avg5=0;
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con = null;
    try 
    {
        con = DriverManager.getConnection(URL,"emp","emp");
    }
    catch (SQLException ex)
    {
        Logger.getLogger(EMPDATA.class.getName()).log(Level.SEVERE, null, ex);
    }
    Statement stmt=con.createStatement();
    String qry="select  age,id,dept,salary,maritalstatus,city from APP.EMPDATA ";
    ResultSet rs=stmt.executeQuery(qry);
    
    while(rs.next())
    {
    int age=rs.getInt("age");
    int id=rs.getInt("id");
    String dept=rs.getString("dept");
    String city=rs.getString("city");
    String maritalstatus=rs.getString("maritalstatus");
    double salary=rs.getDouble("salary");
    salary=salary+1;
    avg=(salary/ecount);
    if(age>=58)
    {
    count=count+1;
    }
   
    if(id!=0)
    {
    ecount=ecount+1;
    }
    
    if("single".equals(maritalstatus))
    {
    scount=scount+1;
    }

    if("Testing".equals(dept))
    {
    Tcount=Tcount+1;
    }
    if("IT".equals(dept))
    {
    i=i+1;
    }
     if("Data Entry".equals(dept))
    {
    ds=ds+1;
    }
      if("Support".equals(dept))
    {
    s=s+1;
    }
      if("others".equals(dept))
    {
    dcount=dcount+1;
    } 
    if("kochi".equals(city))
    {
    k=k+1;
    } 
    if ("pune".equals(city))
    {
     p = p + 1;
    }
    if ("mysore".equals(city))
    {
     m = m + 1;
    }
    if ("bangaluru".equals(city))
    {
     b = b + 1;
    }
   if("IT".equals(dept))
    {
     double sal1=rs.getDouble("salary");
    sal1=sal1+1;
    avg1=(sal1/i);
    }
    if("Testing".equals(dept))
    {
     double sal2=rs.getDouble("salary");
    sal2=sal2+1;
    avg2=(sal2/Tcount);
    }
     if("Data Entry".equals(dept))
    {
     double sal3=rs.getDouble("salary");
    sal3=sal3+1;
    avg3=(sal3/ds);
    }
      if("Support".equals(dept))
    {
     double sal4=rs.getDouble("salary");
    sal4=sal4+1;
    avg4=(sal4/s);
    }
         if("others".equals(dept))
    {
     double sal5=rs.getDouble("salary");
    sal5=sal5+1;
    avg5=(sal5/dcount);
    }
//         if(!"abc".equals(city))
//    {
//    ccount=ccount+1;
//    }
    }

  
    out.println("<br/>The total Number of Employees="+ecount);
    out.println("<br/>The Number of employees in the Department Testing ="+Tcount);
    out.println("<br/>The Number of employees in the Department IT ="+i);
    out.println("<br/>The Number of employees in the Department Data Entry ="+ds);
    out.println("<br/>The Number of employees in the Department Support ="+s);
    out.println("<br/>The Number of employees in the Department others ="+dcount);
    out.println("<br/>The Number of employees from the city Kochi ="+k);
    out.println("<br/>The Number of employees from the city Pune ="+p);
    out.println("<br/>The Number of employees from the city Mysore ="+m);
    out.println("<br/>The Number of employees from the city Bangaluru ="+b);
    out.println("<br/>Average Salary="+avg);
    out.println("<br/>Average Salary of the department IT="+avg1);
    out.println("<br/>Average Salary of the department Testing="+avg2);
    out.println("<br/>Average Salary of the department Data Entry="+avg3);
    out.println("<br/>Average Salary of the department Support="+avg4);
    out.println("<br/>Average Salary of the department others="+avg5);
    out.println("<br/>Number of employees who has status Single="+scount);
    out.println("<br/>Number of employees who will retire within two years="+count);
//    out.println("<br/>Dept="+dcount);
//    out.println("<br/>city="+ccount);
    
   } 


catch (ClassNotFoundException ex) 
    {
        Logger.getLogger(EMPDATA.class.getName()).log(Level.SEVERE, null, ex);
    }
catch (SQLException ex) 
    {
        Logger.getLogger(EMPDATA.class.getName()).log(Level.SEVERE, null, ex);
    }


}
}
