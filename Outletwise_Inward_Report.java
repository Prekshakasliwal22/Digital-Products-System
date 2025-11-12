import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Outletwise_Inward_Report
{
   Outletwise_Inward_Report(String outletid,String firmname,String outletcity,String startdate,String enddate)
   {
     try
     {
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       String current_date=sdf.format(dt);

       String xdate=convert_format(startdate);
       String ydate=convert_format(enddate);

       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
       //System.out.println("Connection eshtablished successfully");
       Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs1=st1.executeQuery("select inward_billno, inward_date from Products_Inward_Master where outlet_idno="+outletid+" and inward_date between '"+xdate+"' and '"+ydate+"' order by inward_billno");
       Statement st2=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs2=st2.executeQuery("select d.inward_billno, d.digital_product_idno, p.product_type, p.brand_name,p.gst_in_per, d.inward_qty, d.inward_cost from Products_Inward_Master m, Products_Inward_Details d, Digital_Products_Master p where m.inward_billno=d.inward_billno and d.digital_product_idno=p.digital_product_idno and m.inward_date between '"+xdate+"' and '"+ydate+"' order by m.inward_billno");

       BufferedWriter bw=new BufferedWriter(new FileWriter("inward2_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Outletwise Inward Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Company Outletwise Digital Products Inward Report</h1>"); 
       bw.write("<br>");
       bw.write("<br>");
       bw.write("Report Date: "+current_date);
       bw.write("<br>");
       bw.write("Report for the period: "+startdate+" - "+enddate);
       bw.write("<br>");
       bw.write("Report for - Company Outlet ID No: "+outletid);
       bw.write("<br>");
       bw.write("Company Outlet's Firmname: "+firmname);
       bw.write("<br>");
       bw.write("Company Outlet's City: "+outletcity);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=1>");
       bw.write("<tr>");

       bw.write("<th>Inward Bill No</th>");
       bw.write("<th>Inward Date</th>");
       bw.write("<th>Product ID No.</th>");
       bw.write("<th>Product Type</th>");
       bw.write("<th>Brand Name</th>");
       bw.write("<th>Inward Qty</th>");
       bw.write("<th>Inward Cost</th>");
       bw.write("<th>Inward Amount</th>");
       bw.write("<th>GST in %</th>");
       bw.write("<th>GST Amount</th>");
       bw.write("<th>Net Bill Amount</th>");
       bw.write("</tr>");
      
       int vinward_billno,winward_billno,vproduct_idno;
       int vinward_amount=0,vinward_qty,vinward_cost;
       String vinward_date,vproduct_type,vbrand_name;
       double gst_per,gst_amount,net_amount,s=0;
       int c;
       while(rs1.next())
       {
         vinward_billno=rs1.getInt(1);
         vinward_date=sdf.format(rs1.getDate(2));
         bw.write("<tr>"); 
         bw.write("<td>"+vinward_billno+"</td>"); 
         bw.write("<td>"+vinward_date+"</td>"); 
         
         rs2.beforeFirst();
         c=0;         
         while(rs2.next())
         {
           winward_billno=rs2.getInt(1);
           vproduct_idno=rs2.getInt(2);
           vproduct_type=rs2.getString(3);
           vbrand_name=rs2.getString(4);
           gst_per=rs2.getDouble(5);
           vinward_qty=rs2.getInt(6);
           vinward_cost=rs2.getInt(7);
           vinward_amount=vinward_qty*vinward_cost;
           gst_amount=gst_per*vinward_amount/100;
           net_amount=vinward_amount+gst_amount;
           if(vinward_billno==winward_billno)
           {
              s=s+net_amount;
              if(c==0)
              {
               bw.write("<td>"+vproduct_idno+"</td>"); 
               bw.write("<td>"+vproduct_type+"</td>"); 
               bw.write("<td>"+vbrand_name+"</td>");
               bw.write("<td>"+vinward_qty+"</td>");
               bw.write("<td>"+vinward_cost+"</td>");
               bw.write("<td>"+vinward_amount+"</td>");
               bw.write("<td>"+gst_per+"</td>");
               bw.write("<td>"+gst_amount+"</td>");
               bw.write("<td>"+net_amount+"</td>");
               bw.write("</tr>"); 
              }
              else
              {
               bw.write("<tr>"); 
               bw.write("<td></td>"); 
               bw.write("<td></td>"); 
               bw.write("<td>"+vproduct_idno+"</td>"); 
               bw.write("<td>"+vproduct_type+"</td>"); 
               bw.write("<td>"+vbrand_name+"</td>");
               bw.write("<td>"+vinward_qty+"</td>");
               bw.write("<td>"+vinward_cost+"</td>");
               bw.write("<td>"+vinward_amount+"</td>");
               bw.write("<td>"+gst_per+"</td>");
               bw.write("<td>"+gst_amount+"</td>");
               bw.write("<td>"+net_amount+"</td>");
               bw.write("</tr>"); 
              }
              c++; 
           }
        }
       }
       bw.write("<tr>");
       bw.write("<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>"+"<td>Total Bill Amount:</td>"+"<td>"+s+"</td>");
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
       System.out.println("Java-Oracle Drivers are not registered properly, so problems"); 
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
     new Outletwise_Inward_Report("4","TechZone Electronics","Pune","01/10/2025","30/10/2025");

   }
}