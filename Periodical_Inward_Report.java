import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Periodical_Inward_Report
{
   Periodical_Inward_Report(String startdate,String enddate)
   {
     try
     {
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd MMMM yyyy");
       String current_date=sdf.format(dt);
       String xdate=convert_format(startdate);//method
       String ydate=convert_format(enddate);
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
       //JOptionPane.showMessageDialog(this,"Connection made successfully");
       Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs1=st1.executeQuery("select m.inward_billno, m.inward_date, m.outlet_idno, c.outlet_firmname, c.city from Products_Inward_Master m, Company_Outlets_Master c where m.outlet_idno=c.outlet_idno and m.inward_date between '"+xdate+"' and '"+ydate+"' order by m.inward_billno");
       Statement st2=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs2=st2.executeQuery("select d.inward_billno, d.digital_product_idno, p.product_type, p.brand_name, d.inward_qty, d.inward_cost from Products_Inward_Master m, Products_Inward_Details d, Digital_Products_Master p where m.inward_billno=d.inward_billno and d.digital_product_idno=p.digital_product_idno and m.inward_date between '"+xdate+"' and '"+ydate+"' order by m.inward_billno");
       BufferedWriter bw=new BufferedWriter(new FileWriter("inward1_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Periodical Inward Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Digital Products Inward Report (Periodical)</h1>"); 
       bw.write("<br>");
       bw.write("<br>");
       bw.write("Report Date: "+current_date);
       bw.write("<br>");
       bw.write("Report for the period: "+startdate+" - "+enddate);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=1>");
       bw.write("<tr>");
       bw.write("<th>Inward Bill No</th>");
       bw.write("<th>Inward Date</th>");
       bw.write("<th>Outlet ID No.</th>");
       bw.write("<th>Outlet Firmname</th>");
       bw.write("<th>City</th>");
       bw.write("<th>Product ID No.</th>");
       bw.write("<th>Product Type</th>");
       bw.write("<th>Brand Name</th>");
       bw.write("<th>Inward Qty</th>");
       bw.write("<th>Inward Cost</th>");
       bw.write("<th>Inward Amount</th>");
       bw.write("</tr>");
      
       int vinward_billno,winward_billno,voutlet_idno,vproduct_idno;
       int vinward_amount=0,vinward_qty,vinward_cost;
       String vinward_date,voutlet_firmname,vcity,vproduct_type,vbrand_name;
       int c;
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
         c=0;
         while(rs2.next())
         {
           winward_billno=rs2.getInt(1);
           vproduct_idno=rs2.getInt(2);
           vproduct_type=rs2.getString(3);
           vbrand_name=rs2.getString(4);
           vinward_qty=rs2.getInt(5);
           vinward_cost=rs2.getInt(6);
           vinward_amount=vinward_qty*vinward_cost;
           if(vinward_billno==winward_billno)
           {
              if(c==0)
              {
               bw.write("<td>"+vproduct_idno+"</td>"); 
               bw.write("<td>"+vproduct_type+"</td>"); 
               bw.write("<td>"+vbrand_name+"</td>");
               bw.write("<td>"+vinward_qty+"</td>");
               bw.write("<td>"+vinward_cost+"</td>");
               bw.write("<td>"+vinward_amount+"</td>");
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
               bw.write("<td>"+vinward_qty+"</td>");
               bw.write("<td>"+vinward_cost+"</td>");
               bw.write("<td>"+vinward_amount+"</td>");
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
      RT.exec("Explorer inward1_report.html"); 
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
   String convert_format(String mydate)
   {
    String a=mydate.substring(0,2);    
    String b=mydate.substring(3,5);    
    String c=mydate.substring(6);
    
   return(c+"-"+b+"-"+a);    
 }
   public static void main(String args[])
   { 
     new Periodical_Inward_Report("22/09/2025","22/10/2025");
   }
}
