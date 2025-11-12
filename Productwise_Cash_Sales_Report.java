import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Productwise_Cash_Sales_Report
{
   Productwise_Cash_Sales_Report(String productid,String producttype,String brandname,String startdate,String enddate,double mygst)
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
       ResultSet rs1=st1.executeQuery("select m.cash_sales_billno,m.cash_sales_date,m.client_idno,c.client_name,c.city from Products_Cash_Sales_Master m,Products_Cash_Sales_Details d,Clients_Master c,Digital_Products_Master p where m.cash_sales_billno=d.cash_sales_billno and m.client_idno=c.client_idno and d.digital_product_idno=p.digital_product_idno and d.digital_product_idno="+productid+" and m.cash_sales_date between '"+xdate+"' and '"+ydate+"' order by m.cash_sales_billno");
       Statement st2=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs2=st2.executeQuery("select d.cash_sales_billno,d.cash_sales_qty,d.cash_sales_cost from Products_Cash_Sales_Master m, Products_Cash_Sales_Details d, Digital_Products_Master p where m.cash_sales_billno=d.cash_sales_billno and d.digital_product_idno=p.digital_product_idno and d.digital_product_idno="+productid+" and m.cash_sales_date between '"+xdate+"' and '"+ydate+"' order by d.cash_sales_billno");

       BufferedWriter bw=new BufferedWriter(new FileWriter("cash_sales2_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Productwise Cash Sales Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Digital Productwise Cash Sales Report</h1>"); 
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

       bw.write("<th>Cash Sales Bill No</th>");
       bw.write("<th>Cash Sales Date</th>");
       bw.write("<th>Client ID No.</th>");
       bw.write("<th>Client Name</th>");
       bw.write("<th>City</th>");

       bw.write("<th>Cash Sales Qty</th>");
       bw.write("<th>Cash Sales Cost</th>");
       bw.write("<th>Cash Sales Amount</th>");
       bw.write("<th>GST Amount</th>");
       bw.write("<th>Net Bill Amount</th>");
       bw.write("</tr>");
      
       int vcash_sales_billno,vclient_idno;
       int wbill_no;
       int vcash_sales_amount=0,vcash_sales_qty,vcash_sales_cost;
       String vcash_sales_date,vclient_name,vcity;
       double gst_amount,net_amount;
       double s=0;         
       while(rs1.next())
       {
         vcash_sales_billno=rs1.getInt(1);
         vcash_sales_date=sdf.format(rs1.getDate(2));
         vclient_idno=rs1.getInt(3);
         vclient_name=rs1.getString(4);
         vcity=rs1.getString(5);
         bw.write("<tr>"); 
         bw.write("<td>"+vcash_sales_billno+"</td>"); 
         bw.write("<td>"+vcash_sales_date+"</td>"); 
         bw.write("<td>"+vclient_idno+"</td>"); 
         bw.write("<td>"+vclient_name+"</td>"); 
         bw.write("<td>"+vcity+"</td>"); 
         
         rs2.beforeFirst();
         while(rs2.next())
         {
           wbill_no=rs2.getInt(1);
           vcash_sales_qty=rs2.getInt(2);
           vcash_sales_cost=rs2.getInt(3);
           if(vcash_sales_billno==wbill_no)
           {
              vcash_sales_amount=vcash_sales_qty*vcash_sales_cost;
              gst_amount=mygst*vcash_sales_amount/100;
              net_amount=vcash_sales_amount+gst_amount;
              s=s+net_amount;
               bw.write("<td>"+vcash_sales_qty+"</td>");
               bw.write("<td>"+vcash_sales_cost+"</td>");
               bw.write("<td>"+vcash_sales_amount+"</td>");
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
      RT.exec("Explorer cash_sales2_report.html"); 
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
     new Productwise_Cash_Sales_Report("2","ABC","XYZ","01/09/2025","30/09/2025",5);
   }
}