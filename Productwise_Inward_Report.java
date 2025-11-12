import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Productwise_Inward_Report
{
   Productwise_Inward_Report(String productid,String producttype,String brandname,String startdate,String enddate,double mygst)
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
       Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs1=st1.executeQuery("select m.inward_billno,m.inward_date,m.outlet_idno,o.outlet_firmname,o.city from Products_Inward_Master m,Products_Inward_Details d,Company_Outlets_Master o,Digital_Products_Master p where m.inward_billno=d.inward_billno and m.outlet_idno=o.outlet_idno and d.digital_product_idno=p.digital_product_idno and d.digital_product_idno="+productid+" and m.inward_date between '"+xdate+"' and '"+ydate+"' order by m.inward_billno");
       Statement st2=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs2=st2.executeQuery("select d.inward_billno,d.inward_qty,d.inward_cost from Products_Inward_Master m, Products_Inward_Details d, Digital_Products_Master p where m.inward_billno=d.inward_billno and d.digital_product_idno=p.digital_product_idno and d.digital_product_idno="+productid+" and m.inward_date between '"+xdate+"' and '"+ydate+"' order by d.inward_billno");

       BufferedWriter bw=new BufferedWriter(new FileWriter("inward2_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Productwise Inward Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Digital Productwise Inward Report</h1>"); 
       bw.write("<br>");
       bw.write("<br>");
       bw.write("Report Date: "+current_date);
       bw.write("<br>");
       bw.write("Report for the period: "+startdate+" - "+enddate);
       bw.write("<br>");
       bw.write("Report for - Digital Product ID No: "+productid);
       bw.write("<br>");
       bw.write("Product Type: "+producttype+"&nbsp&nbsp&nbsp&nbsp&nbsp"+"GST in % : "+mygst);
       bw.write("<br>");
       bw.write("Brand Name: "+brandname);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=1>");
       bw.write("<tr>");

       bw.write("<th>Inward Bill No</th>");
       bw.write("<th>Inward Date</th>");
       bw.write("<th>Outlet ID No.</th>");
       bw.write("<th>Outlet Firmname</th>");
       bw.write("<th>City</th>");

       bw.write("<th>Inward Qty</th>");
       bw.write("<th>Inward Cost</th>");
       bw.write("<th>Inward Amount</th>");
       bw.write("<th>GST Amount</th>");
       bw.write("<th>Net Bill Amount</th>");
       bw.write("</tr>");
      
       int vinward_billno,voutlet_idno;
       int wbill_no;
       int vinward_amount=0,vinward_qty,vinward_cost;
       String vinward_date,voutlet_firmname,vcity;
       double gst_amount,net_amount;
       double s=0;         
       while(rs1.next())
       {
         vinward_billno=rs1.getInt(1);
         vinward_date=sdf.format(rs1.getDate(2));
         voutlet_idno=rs1.getInt(3);
         voutlet_firmname=rs1.getString(4);
         vcity=rs1.getString(5);
         bw.write("<tr>"); 
         bw.write("<td>"+vinward_billno+"</td>"); 
         bw.write("<td>"+vinward_date+"</td>"); 
         bw.write("<td>"+voutlet_idno+"</td>"); 
         bw.write("<td>"+voutlet_firmname+"</td>"); 
         bw.write("<td>"+vcity+"</td>"); 
         
         rs2.beforeFirst();
         while(rs2.next())
         {
           wbill_no=rs2.getInt(1);
           vinward_qty=rs2.getInt(2);
           vinward_cost=rs2.getInt(3);
           if(vinward_billno==wbill_no)
           {
             vinward_amount=vinward_qty*vinward_cost;
              gst_amount=mygst*vinward_amount/100;
              net_amount=vinward_amount+gst_amount;
              s=s+net_amount;
               bw.write("<td>"+vinward_qty+"</td>");
               bw.write("<td>"+vinward_cost+"</td>");
               bw.write("<td>"+vinward_amount+"</td>");
               bw.write("<td>"+gst_amount+"</td>");
               bw.write("<td>"+net_amount+"</td>");
               bw.write("</tr>"); 
            }
         }
       }
       bw.write("<tr>");
       bw.write("<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>"+"<td>Total Bill Amount:</td>"+"<td>"+s+"</td>");
       bw.write("</tr>");

       bw.write("</table>");       
       bw.write("</center>");
       bw.write("</body>");
       bw.write("</html>");
       bw.close();
       con.close();
      Runtime RT=Runtime.getRuntime();
      RT.exec("Explorer inward2_report.html"); 
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
     new Productwise_Inward_Report("2","Television","Samsung","01/09/2025","30/10/2025",5);
   }
}