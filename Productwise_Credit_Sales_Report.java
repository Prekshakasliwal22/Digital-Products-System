import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Productwise_Credit_Sales_Report
{
   Productwise_Credit_Sales_Report(String productid,String producttype,String brandname,String startdate,String enddate,double mygst)
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
       ResultSet rs1=st1.executeQuery("select m.credit_sales_billno,m.credit_sales_date,m.retailer_idno,r.retailer_firmname,r.city from Products_Credit_Sales_Master m,Products_Credit_Sales_Details d,Retailers_Master r,Digital_Products_Master p where m.credit_sales_billno=d.credit_sales_billno and m.retailer_idno=r.retailer_idno and d.digital_product_idno=p.digital_product_idno and d.digital_product_idno="+productid+" and m.credit_sales_date between '"+xdate+"' and '"+ydate+"' order by m.credit_sales_billno");
       Statement st2=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs2=st2.executeQuery("select d.credit_sales_billno,d.credit_sales_qty,d.credit_sales_cost from Products_Credit_Sales_Master m, Products_Credit_Sales_Details d, Digital_Products_Master p where m.credit_sales_billno=d.credit_sales_billno and d.digital_product_idno=p.digital_product_idno and d.digital_product_idno="+productid+" and m.credit_sales_date between '"+xdate+"' and '"+ydate+"' order by d.credit_sales_billno");

       BufferedWriter bw=new BufferedWriter(new FileWriter("credit_sales2_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Productwise Credit Sales Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Retailerwise Digital Products Credit Sales Report</h1>"); 
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

       bw.write("<th>Credit Sales Bill No</th>");
       bw.write("<th>Credit Sales Date</th>");
       bw.write("<th>Retailer ID No.</th>");
       bw.write("<th>Retailer Firmname</th>");
       bw.write("<th>City</th>");

       bw.write("<th>Credit Sales Qty</th>");
       bw.write("<th>Credit Sales Cost</th>");
       bw.write("<th>Credit Sales Amount</th>");
       bw.write("<th>GST Amount</th>");
       bw.write("<th>Net Bill Amount</th>");
       bw.write("</tr>");
      
       int vcredit_sales_billno,vretailer_idno;
       int wbill_no;
       int vcredit_sales_amount=0,vcredit_sales_qty,vcredit_sales_cost;
       String vcredit_sales_date,vretailer_firmname,vcity;
       double gst_amount,net_amount;
       double s=0;         
       while(rs1.next())
       {
         vcredit_sales_billno=rs1.getInt(1);
         vcredit_sales_date=sdf.format(rs1.getDate(2));
         vretailer_idno=rs1.getInt(3);
         vretailer_firmname=rs1.getString(4);
         vcity=rs1.getString(5);
         bw.write("<tr>"); 
         bw.write("<td>"+vcredit_sales_billno+"</td>"); 
         bw.write("<td>"+vcredit_sales_date+"</td>"); 
         bw.write("<td>"+vretailer_idno+"</td>"); 
         bw.write("<td>"+vretailer_firmname+"</td>"); 
         bw.write("<td>"+vcity+"</td>"); 
         
         rs2.beforeFirst();
         while(rs2.next())
         {
           wbill_no=rs2.getInt(1);
           vcredit_sales_qty=rs2.getInt(2);
           vcredit_sales_cost=rs2.getInt(3);
           if(vcredit_sales_billno==wbill_no)
           {
           vcredit_sales_amount=vcredit_sales_qty*vcredit_sales_cost;
           gst_amount=mygst*vcredit_sales_amount/100;
           net_amount=vcredit_sales_amount+gst_amount;
           s=s+net_amount;
             bw.write("<td>"+vcredit_sales_qty+"</td>");
             bw.write("<td>"+vcredit_sales_cost+"</td>");
             bw.write("<td>"+vcredit_sales_amount+"</td>");
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
      RT.exec("Explorer credit_sales2_report.html"); 
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
     new Productwise_Credit_Sales_Report("2","ABC","XYZ","01/09/2025","30/09/2025",5);
   }
}