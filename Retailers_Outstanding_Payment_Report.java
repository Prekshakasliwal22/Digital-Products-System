import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Retailers_Outstanding_Payment_Report
{
   Retailers_Outstanding_Payment_Report()
   {
     try
     {
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-yyyy");
       String current_date=sdf.format(dt);

       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
       //JOptionPane.showMessageDialog(this,"Connection made successfully");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select a.retailer_idno,b.retailer_firmname,b.city,a.balance_amount from Retailers_Ledger a, Retailers_Master b where a.retailer_idno=b.retailer_idno order by a.retailer_idno");
       BufferedWriter bw=new BufferedWriter(new FileWriter("outstanding2_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Retailer Outstanding Payment Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Retailers Outstanding Payments Report</h1>"); 
       bw.write("<br>");
       bw.write("<br>");
       bw.write("Report Date: "+current_date);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=1>");
       bw.write("<tr>");
       bw.write("<th>Retailer ID No</th>");
       bw.write("<th>Retailer Firmname</th>");
       bw.write("<th>City</th>");
       bw.write("<th>Outstanding/Balance Amount</th>");
       bw.write("</tr>");
      
       int vretailer_idno,vbalance_amount;
       String vretailer_firmname,vcity;
       long s=0;
       while(rs.next())
       {
         vretailer_idno=rs.getInt(1);
         vretailer_firmname=rs.getString(2);
         vcity=rs.getString(3);
         vbalance_amount=rs.getInt(4);
         s=s+vbalance_amount;
         bw.write("<tr>"); 
         bw.write("<td>"+vretailer_idno+"</td>"); 
         bw.write("<td>"+vretailer_firmname+"</td>"); 
         bw.write("<td>"+vcity+"</td>"); 
         bw.write("<td>"+vbalance_amount+"</td>"); 
         bw.write("</tr>"); 
       }
       bw.write("<tr>");
       bw.write("<td></td><td></td>"+"<td>Total Outstanding Payment:</td>"+"<td>"+s+"</td>"); 
       bw.write("</tr>");
 
       bw.write("</table>");       
       bw.write("</center>");
       bw.write("</body>");
       bw.write("</html>");
       bw.close();
       con.close();
      Runtime RT=Runtime.getRuntime();
      RT.exec("Explorer outstanding2_report.html"); 
     }
     catch(IOException e1)
     {
       System.out.println("I/O System Failure, so problems are occured"); 
     }
    catch(ClassNotFoundException e2)
     {
       System.out.println("Java-MySQL Drivers are not registered properly, so problems"); 
     }
      catch(SQLException e3)
     {
       System.out.println("Problems during Java-MySQL connection"); 
     }
   }
   public static void main(String args[])
   { 
     new Retailers_Outstanding_Payment_Report();
   }
}