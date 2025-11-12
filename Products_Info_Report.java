import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Products_Info_Report
{
   Products_Info_Report()
   {
     try
     {
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-yyyy");
       String current_date=sdf.format(dt);

       Class.forName("com.mysql.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
       //System.out.println("Connection eshtablished successfully");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select * from Digital_Products_Master ORDER BY digital_product_idno");
       BufferedWriter bw=new BufferedWriter(new FileWriter("products_info_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Product's Info Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Digital Products Information Report</h1>"); 
       bw.write("<br>");
       bw.write("<br>");
       bw.write("Report Date: "+current_date);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=1>");
       bw.write("<tr>");
       bw.write("<th>Product ID No</th>");
       bw.write("<th>Product Name</th>");
       bw.write("<th>Brand Name</th>");
       bw.write("<th>Model No, Name</th>");
       bw.write("<th>Technical Information</th>");
       bw.write("<th>Product's Size, Capacity</th>");
       bw.write("<th>Standard Cost</th>");
       bw.write("<th>Additional Information</th>");
       bw.write("</tr>");
      
       int vproduct_id,vstd_cost;
       String vproduct_name,vbrand_name,vmodel,vtechnical_info,vproduct_size,vadd_info;
       while(rs.next())
       {
         vproduct_id=rs.getInt(1);
         vproduct_name=rs.getString(2);
         vbrand_name=rs.getString(3);
         vmodel=rs.getString(4);
         vtechnical_info=rs.getString(5);
         vproduct_size=rs.getString(6);
         vstd_cost=rs.getInt(7);
         vadd_info=rs.getString(8);
         bw.write("<tr>"); 
         bw.write("<td>"+vproduct_id+"</td>"); 
         bw.write("<td>"+vproduct_name+"</td>"); 
         bw.write("<td>"+vbrand_name+"</td>"); 
         bw.write("<td>"+vmodel+"</td>"); 
         bw.write("<td>"+vtechnical_info+"</td>"); 
         bw.write("<td>"+vproduct_size+"</td>"); 
         bw.write("<td>"+vstd_cost+"</td>"); 
         bw.write("<td>"+vadd_info+"</td>"); 
         bw.write("</tr>"); 
       }
       bw.write("</table>");       
       bw.write("</center>");
       bw.write("</body>");
       bw.write("</html>");
       bw.close();
       con.close();
      Runtime RT=Runtime.getRuntime();
      RT.exec("Explorer products_info_report.html"); 
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
     new Products_Info_Report();
   }
}