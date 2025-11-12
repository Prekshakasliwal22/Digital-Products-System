import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Retailerwise_Payments_Report
{
   Retailerwise_Payments_Report(String retailerid,String firmname,String retailercity,String startdate,String enddate)
   {
     try
     {
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-yyyy");
       String current_date=sdf.format(dt);

       String xdate=convert_format(startdate);
       String ydate=convert_format(enddate);

       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
       //System.out.println("Connection eshtablished successfully");
       Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs=st.executeQuery("select received_payment_entryno,received_payment_date,received_payment_amount,mode_of_payment,against_reference from Retailer_Payments where retailer_idno="+retailerid+" and received_payment_date between '"+xdate+"' and '"+ydate+"' order by received_payment_entryno");

       BufferedWriter bw=new BufferedWriter(new FileWriter("received_payment2_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Retailerwise Payments Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Retailerwise Received Payments Summary Report</h1>"); 
       bw.write("<br>");
       bw.write("<br>");
       bw.write("Report Date: "+current_date);
       bw.write("<br>");
       bw.write("Report for the period: "+startdate+" - "+enddate);
       bw.write("<br>");
       bw.write("Report for - Retailer ID No: "+retailerid);
       bw.write("<br>");
       bw.write("Retailer Firmname: "+firmname);
       bw.write("<br>");
       bw.write("Retailer City: "+retailercity);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=1>");
       bw.write("<tr>");

       bw.write("<th>Received Payment Entry No</th>");
       bw.write("<th>Received Payment Date</th>");
       bw.write("<th>Received Payment Amount</th>");
       bw.write("<th>Mode of Payment</th>");
       bw.write("<th>Against Reference</th>");
       bw.write("</tr>");
      
       int ventry_no,vpayment_amount;
       String vpayment_date,vpayment_mode,vreference;
       long s=0;
       while(rs.next())
       {
         ventry_no=rs.getInt(1);
         vpayment_date=sdf.format(rs.getDate(2));
         vpayment_amount=rs.getInt(3);
         s=s+vpayment_amount;
         vpayment_mode=rs.getString(4);
         vreference=rs.getString(5);
         
         bw.write("<tr>"); 
         bw.write("<td>"+ventry_no+"</td>"); 
         bw.write("<td>"+vpayment_date+"</td>"); 
         bw.write("<td>"+vpayment_amount+"</td>"); 
         bw.write("<td>"+vpayment_mode+"</td>"); 
         bw.write("<td>"+vreference+"</td>"); 
         bw.write("</tr>"); 
       }
       bw.write("<tr>");
       bw.write("<td></td>"+"<td>Total Received Amount:</td>"+"<td>"+s+"</td>"); 
       bw.write("</tr>");
 
       bw.write("</table>");       
       bw.write("</center>");
       bw.write("</body>");
       bw.write("</html>");
       bw.close();
       con.close();
      Runtime RT=Runtime.getRuntime();
      RT.exec("Explorer received_payment2_report.html"); 
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

   String convert_format(String mydate)
   {
    String a=mydate.substring(0,2);    
    String b=mydate.substring(3,5);    
    String c=mydate.substring(6);
    
   return(c+"-"+b+"-"+a);    
 }
   public static void main(String args[])
   { 
     new Retailerwise_Payments_Report("4","Shreya Mobiles","Shrirampur","01/09/2025","30/10/2025");
   }
}