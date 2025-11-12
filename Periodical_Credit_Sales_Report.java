import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Periodical_Credit_Sales_Report
{
   Periodical_Credit_Sales_Report(String startdate,String enddate)
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
       ResultSet rs1=st1.executeQuery("select m.credit_sales_billno, m.credit_sales_date, m.retailer_idno, r.retailer_firmname, r.city from Products_Credit_Sales_Master m, Retailers_Master r where m.retailer_idno=r.retailer_idno and m.credit_sales_date between '"+xdate+"' and '"+ydate+"' order by m.credit_sales_billno");
       Statement st2=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs2=st2.executeQuery("select d.credit_sales_billno, d.digital_product_idno, p.product_type, p.brand_name, d.credit_sales_qty, d.credit_sales_cost from Products_Credit_Sales_Master m, Products_Credit_Sales_Details d, Digital_Products_Master p where m.credit_sales_billno=d.credit_sales_billno and d.digital_product_idno=p.digital_product_idno and m.credit_sales_date between '"+xdate+"' and '"+ydate+"' order by m.credit_sales_billno");

       BufferedWriter bw=new BufferedWriter(new FileWriter("credit_sales1_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Periodical Credit Sales Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Digital Products Credit Sales Report (Periodical)</h1>"); 
       bw.write("<br>");
       bw.write("<br>");
       bw.write("Report Date: "+current_date);
       bw.write("<br>");
       bw.write("Report for the period: "+startdate+" - "+enddate);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=1>");
       bw.write("<tr>");

       bw.write("<th>Credit Sales Bill No</th>");
       bw.write("<th>Credit Sales Date</th>");
       bw.write("<th>Retailer ID No.</th>");
       bw.write("<th>Retailer Firmname</th>");
       bw.write("<th>City</th>");

       bw.write("<th>Product ID No.</th>");
       bw.write("<th>Product Type</th>");
       bw.write("<th>Brand Name</th>");
       bw.write("<th>Credit Sales Qty</th>");
       bw.write("<th>Credit Sales Cost</th>");
       bw.write("<th>Credit Sales Amount</th>");
       bw.write("</tr>");
      
       int vcredit_sales_billno,wcredit_sales_billno,vretailer_idno,vproduct_idno;
       int vcredit_sales_amount=0,vcredit_sales_qty,vcredit_sales_cost;
       String vcredit_sales_date,vretailer_firmname,vcity,vproduct_type,vbrand_name;
       int c;
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
         c=0;         
         while(rs2.next())
         {
           wcredit_sales_billno=rs2.getInt(1);
           vproduct_idno=rs2.getInt(2);
           vproduct_type=rs2.getString(3);
           vbrand_name=rs2.getString(4);
           vcredit_sales_qty=rs2.getInt(5);
           vcredit_sales_cost=rs2.getInt(6);
           vcredit_sales_amount=vcredit_sales_qty*vcredit_sales_cost;
           if(vcredit_sales_billno==wcredit_sales_billno)
           {
              if(c==0)
              {
               bw.write("<td>"+vproduct_idno+"</td>"); 
               bw.write("<td>"+vproduct_type+"</td>"); 
               bw.write("<td>"+vbrand_name+"</td>");
               bw.write("<td>"+vcredit_sales_qty+"</td>");
               bw.write("<td>"+vcredit_sales_cost+"</td>");
               bw.write("<td>"+vcredit_sales_amount+"</td>");
               bw.write("</tr>"); 
              }
              else
              {
               bw.write("<tr>"); 
               bw.write("<td></td>"); 
               bw.write("<td></td>"); 
               bw.write("<td></td>"); 
               bw.write("<td></td>"); 
               bw.write("<td></td>"); 
               bw.write("<td>"+vproduct_idno+"</td>"); 
               bw.write("<td>"+vproduct_type+"</td>"); 
               bw.write("<td>"+vbrand_name+"</td>");
               bw.write("<td>"+vcredit_sales_qty+"</td>");
               bw.write("<td>"+vcredit_sales_cost+"</td>");
               bw.write("<td>"+vcredit_sales_amount+"</td>");
               bw.write("</tr>"); 
              }
              c++; 
           }
        }
       }
       bw.write("</table>");       
       bw.write("</center>");
       bw.write("</body>");
       bw.write("</html>");
       bw.close();
       con.close();
      Runtime RT=Runtime.getRuntime();
      RT.exec("Explorer credit_sales1_report.html"); 
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
     new Periodical_Credit_Sales_Report("15/09/2025","28/10/2025");
   }
}