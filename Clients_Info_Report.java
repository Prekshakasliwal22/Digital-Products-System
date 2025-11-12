import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Clients_Info_Report
{
   Clients_Info_Report()
   {
     try
     {
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-yyyy");
       String current_date=sdf.format(dt);

       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");

       //System.out.println("Connection eshtablished successfully");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select * from Clients_Master ORDER BY client_idno");
       BufferedWriter bw=new BufferedWriter(new FileWriter("clients_info_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Client's Info Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Client's Information Report</h1>"); 
       bw.write("<br>");
       bw.write("<br>");
       bw.write("Report Date: "+current_date);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=2>");
       bw.write("<tr>");
       bw.write("<th>Client ID No</th>");
       bw.write("<th>Client Name</th>");
       bw.write("<th>Address</th>");
       bw.write("<th>City</th>");
       bw.write("<th>Gender</th>");
       bw.write("<th>Birth Date</th>");
       bw.write("<th>Mobile Number</th>");
       bw.write("<th>Email ID</th>");
       bw.write("</tr>");
      
       int vclient_id;
       String vclient_name,vaddress,vcity,vgender,vbirth_date,vemail_id;
       Long vmobile_no;
       while(rs.next())
       {
         vclient_id=rs.getInt(1);
         vclient_name=rs.getString(2);
         vaddress=rs.getString(3);
         vcity=rs.getString(4);
         vgender=rs.getString(5);
         SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
         vbirth_date=sdf2.format(rs.getDate(6));
         vmobile_no=rs.getLong(7);
         vemail_id=rs.getString(8);
         bw.write("<tr>"); 
         bw.write("<td>"+vclient_id+"</td>"); 
         bw.write("<td>"+vclient_name+"</td>"); 
         bw.write("<td>"+vaddress+"</td>"); 
         bw.write("<td>"+vcity+"</td>"); 
         bw.write("<td>"+vgender+"</td>"); 
         bw.write("<td>"+vbirth_date+"</td>"); 
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
      RT.exec("Explorer clients_info_report.html"); 
     }
     catch(IOException e1)
     {
       System.out.println("I/O System Failure, so problems are occured"); 
     }
    catch(ClassNotFoundException e2)
     {
       System.out.println("Java-Oracle Drivers are not registered properly, so problems"); 
     }
      catch(SQLException e3)
     {
       System.out.println("Problems during Java-Oracle connection"); 
     }
   }
   public static void main(String args[])
   { 
     new Clients_Info_Report();
   }
} 
    

