import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Outlets_Info_Report
{
   Outlets_Info_Report()
   {
     try
     {
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd MMMM yyyy");
       String current_date=sdf.format(dt);

       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
//JOptionPane.showMessageDialog(this,"Connection made successfully");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select * from Company_Outlets_Master ORDER BY outlet_idno");
       BufferedWriter bw=new BufferedWriter(new FileWriter("outlets_info_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Outlets Info Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Company Outlets Information Report</h1>"); 
       bw.write("<br>");
       bw.write("<br>");
       bw.write("Report Date: "+current_date);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=1>");
       bw.write("<tr>");
       bw.write("<th>Outlet ID No</th>");
       bw.write("<th>Outlet Firmname</th>");
       bw.write("<th>Address of Company Outlet</th>");
       bw.write("<th>City</th>");
       bw.write("<th>Person 1 Name</th>");
       bw.write("<th>Person 1 Mobile No.</th>");
       bw.write("<th>Person 2 Name</th>");
       bw.write("<th>Person 2 Mobile No.</th>");
       bw.write("<th>Outlet Email ID</th>");
       bw.write("</tr>");
      
       int voutlet_id;
       String voutlet_firmname,vaddress,vcity,vperson1_name,vperson2_name,vemail_id;
       Long vperson1_mobileno,vperson2_mobileno;
       while(rs.next())
       {
         voutlet_id=rs.getInt(1);
         voutlet_firmname=rs.getString(2);
         vaddress=rs.getString(3);
         vcity=rs.getString(4);
         vperson1_name=rs.getString(5);
         vperson1_mobileno=rs.getLong(6);
         vperson2_name=rs.getString(7);
         vperson2_mobileno=rs.getLong(8);
         vemail_id=rs.getString(9);
         bw.write("<tr>"); 
         bw.write("<td>"+voutlet_id+"</td>"); 
         bw.write("<td>"+voutlet_firmname+"</td>"); 
         bw.write("<td>"+vaddress+"</td>"); 
         bw.write("<td>"+vcity+"</td>"); 
         bw.write("<td>"+vperson1_name+"</td>"); 
         bw.write("<td>"+vperson1_mobileno+"</td>"); 
         bw.write("<td>"+vperson2_name+"</td>"); 
         bw.write("<td>"+vperson2_mobileno+"</td>"); 
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
      RT.exec("Explorer outlets_info_report.html"); 
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
     new Outlets_Info_Report();
   }
}