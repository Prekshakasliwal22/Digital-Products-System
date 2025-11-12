import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Retailerwise_Sales_Report
{
   Retailerwise_Sales_Report(String retailerid,String firmname,String retailercity,String startdate,String enddate)
   {
     try
     {
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-yyyy");
       String current_date=sdf.format(dt);

       String xdate=convert_format(startdate);
       String ydate=convert_format(enddate);

       Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
//JOptionPane.showMessageDialog(this,"Connection made successfully");
       Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs1=st1.executeQuery("select credit_sales_billno, credit_sales_date from Products_Credit_Sales_Master where retailer_idno="+retailerid+" and credit_sales_date between '"+xdate+"' and '"+ydate+"' order by credit_sales_billno");
       Statement st2=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs2=st2.executeQuery("select d.credit_sales_billno, d.digital_product_idno, p.product_type, p.brand_name,p.gst_in_per, d.credit_sales_qty, d.credit_sales_cost from Products_Credit_Sales_Master m, Products_Credit_Sales_Details d, Digital_Products_Master p where m.credit_sales_billno=d.credit_sales_billno and d.digital_product_idno=p.digital_product_idno and m.credit_sales_date between '"+xdate+"' and '"+ydate+"' order by m.credit_sales_billno");

       BufferedWriter bw=new BufferedWriter(new FileWriter("credit_sales2_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Retailerwise Sales Report</title>");
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
       bw.write("Report for - Retailer ID No: "+retailerid);
       bw.write("<br>");
       bw.write("Retailer Firmname: "+firmname);
       bw.write("<br>");
       bw.write("Retailer City: "+retailercity);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=1>");
       bw.write("<tr>");

       bw.write("<th>Credit Sales Bill No</th>");
       bw.write("<th>Sales Date</th>");
       bw.write("<th>Product ID No.</th>");
       bw.write("<th>Product Type</th>");
       bw.write("<th>Brand Name</th>");
       bw.write("<th>Sales Qty</th>");
       bw.write("<th>Sales Cost</th>");
       bw.write("<th>Sales Amount</th>");
       bw.write("<th>GST in %</th>");
       bw.write("<th>GST Amount</th>");
       bw.write("<th>Net Bill Amount</th>");
       bw.write("</tr>");
      
       int vcredit_sales_billno,wcredit_sales_billno,vproduct_idno;
       int vcredit_sales_amount=0,vcredit_sales_qty,vcredit_sales_cost;
       String vcredit_sales_date,vproduct_type,vbrand_name;
       double gst_per,gst_amount,net_amount,s=0;
       int c;
       while(rs1.next())
       {
         vcredit_sales_billno=rs1.getInt(1);
         vcredit_sales_date=sdf.format(rs1.getDate(2));
         bw.write("<tr>"); 
         bw.write("<td>"+vcredit_sales_billno+"</td>"); 
         bw.write("<td>"+vcredit_sales_date+"</td>"); 
         
         rs2.beforeFirst();
         c=0;         
         while(rs2.next())
         {
           wcredit_sales_billno=rs2.getInt(1);
           vproduct_idno=rs2.getInt(2);
           vproduct_type=rs2.getString(3);
           vbrand_name=rs2.getString(4);
           gst_per=rs2.getDouble(5);
           vcredit_sales_qty=rs2.getInt(6);
           vcredit_sales_cost=rs2.getInt(7);
           vcredit_sales_amount=vcredit_sales_qty*vcredit_sales_cost;
           gst_amount=gst_per*vcredit_sales_amount/100;
           net_amount=vcredit_sales_amount+gst_amount;
           if(vcredit_sales_billno==wcredit_sales_billno)
           {
              s=s+net_amount;
              if(c==0)
              {
               bw.write("<td>"+vproduct_idno+"</td>"); 
               bw.write("<td>"+vproduct_type+"</td>"); 
               bw.write("<td>"+vbrand_name+"</td>");
               bw.write("<td>"+vcredit_sales_qty+"</td>");
               bw.write("<td>"+vcredit_sales_cost+"</td>");
               bw.write("<td>"+vcredit_sales_amount+"</td>");
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
               bw.write("<td>"+vcredit_sales_qty+"</td>");
               bw.write("<td>"+vcredit_sales_cost+"</td>");
               bw.write("<td>"+vcredit_sales_amount+"</td>");
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
     new Retailerwise_Sales_Report("4","Shreya Mobiles","Shrirampur","01/09/2025","30/10/2025");
   }
}
