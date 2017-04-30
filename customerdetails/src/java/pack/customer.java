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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class customer extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
String URL="jdbc:derby://localhost:1527/customer";

try
{
    int count=0,datec=0,count1=0,count2=0;
    int dcount=0,ecount=0,scount=0,drcount=0;
//    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
//   Date date1=sdf.parse("2017-01-01");
//   Date date2=sdf.parse("2017-01-31");
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con = null;
//    Date date = new Date();
//     DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
               
                
    try 
    {
        con = DriverManager.getConnection(URL,"cust","cust");
    }
    catch (SQLException ex)
    {
        Logger.getLogger(CUSTDATA.class.getName()).log(Level.SEVERE, null, ex);
    }
    Statement stmt=con.createStatement();
    String qry="select * from APP.CUSTDATA ";
    ResultSet rs=stmt.executeQuery(qry);
  

    
    while(rs.next())
    {
    int id=rs.getInt("custid");
    double dis=rs.getDouble("discount");
    String type=rs.getString("producttype");
    Date date=rs.getDate("dateofpurchase");
//      String string = "2017-01-01";
//    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(string);
//    preparedStatement.setDate(index, new java.sql.Date(date.getTime()));
   // String strDate = dateFormat.format(date);
//    String strDate = dateFormat.format("dateofpurchase");
//    date=date.toString(date);
        
    int quantity=rs.getInt("quantity");
    if(id==101|| date!=date)
    {
    count=count+1;
    }
     if(id==102)
    {
    count1=count1+1;
    }
      if(id==103)
    {
    count2=count2+1;
    }
    if(dis>25)
    {
    dcount=dcount+1;
    
    }
        switch(type)
        {
            case "electronic" :
                ecount=ecount+1;
                break;
            case "sport" :
                scount=scount+1;
                break;
            case "dress" :
                drcount=dcount+1;
                break;
            default:
                out.println("no other category");
                break;
        }
//        (date==01012017 && date=31012017)
//           
//        {
//        datec=datec+1;
//        }
//  if(   "01012017".equals(strDate) || "01012017".equals(strDate) )
//  {
//      datec=datec+1;
//  }
//    out.println("Date converted to String: " + strDate);

    }
     out.println("<br/>Total parchase made by customer 101:"+count);
     out.println("<br/>Total parchase made by customer 102:"+count1);
     out.println("<br/>Total parchase made by customer 103:"+count2);
     out.println("<br/>Number of product having discount morethan 25% is :"+dcount);
      out.println("</br><br/>CATEGORY WISE SELL</br>");
      out.println("****************<br/>Electronics:"+ecount);
       out.println("<br/>Sport:"+scount);
        out.println("<br/>Cloths:"+drcount);
//        out.println("<br/>date:"+datec);


    } 

catch ( ClassNotFoundException | SQLException ex) 
    {
        Logger.getLogger(CUSTDATA.class.getName()).log(Level.SEVERE, null, ex);
    }
}
   
}
