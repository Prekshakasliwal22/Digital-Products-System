import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Retailers_Info_Report
{
   Retailers_Info_Report()
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
       ResultSet rs=st.executeQuery("select * from Retailers_Master ORDER BY retailer_idno");
       BufferedWriter bw=new BufferedWriter(new FileWriter("retailers_info_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Retailer's Info Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Creditor Retailers Information Report</h1>"); 
       bw.write("<br>");
       bw.write("<br>");
       bw.write("Report Date: "+current_date);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=1>");
       bw.write("<tr>");
       bw.write("<th>Retailer ID No</th>");
       bw.write("<th>Firmname</th>");
       bw.write("<th>Address</th>");
       bw.write("<th>City</th>");
       bw.write("<th>Owner Name</th>");
       bw.write("<th>Mobile Number</th>");
       bw.write("<th>Email ID</th>");
       bw.write("</tr>");
      
       int vretailer_id;
       String vretailer_firmname,vaddress,vcity,vowner_name,vemail_id;
       Long vmobile_no;
       while(rs.next())
       {
         vretailer_id=rs.getInt(1);
         vretailer_firmname=rs.getString(2);
         vaddress=rs.getString(3);
         vcity=rs.getString(4);
         vowner_name=rs.getString(5);
         vmobile_no=rs.getLong(6);
         vemail_id=rs.getString(7);
         bw.write("<tr>"); 
         bw.write("<td>"+vretailer_id+"</td>"); 
         bw.write("<td>"+vretailer_firmname+"</td>"); 
         bw.write("<td>"+vaddress+"</td>"); 
         bw.write("<td>"+vcity+"</td>"); 
         bw.write("<td>"+vowner_name+"</td>"); 
         bw.write("<td>"+vmobile_no+"</td>"); 
         bw.write("<td>"+vemail_id+"</td>"); 
         bw.write("</tr>"); 
       }
       bw.write("</table>");       
       bw.write("</center>");
       bw.write("</body>");
       bw.write("</html>");
       bw.close();
       con.close();
      Runtime RT=Runtime.getRuntime();
      RT.exec("Explorer retailers_info_report.html"); 
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
     new Retailers_Info_Report();
   }
}