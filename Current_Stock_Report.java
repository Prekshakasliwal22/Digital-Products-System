import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Current_Stock_Report
{
   Current_Stock_Report()
   {
     try
     {
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd MMMM yyyy");
       String current_date=sdf.format(dt);

       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
       //JOptionPane.showMessageDialog(this,"Connection made successfully");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select a.digital_product_idno, b.product_type, b.brand_name, b.model_no_name,a.current_stock from Digital_Products_Stock a, Digital_Products_Master b where a.digital_product_idno=b.digital_product_idno order by a.digital_product_idno");
       BufferedWriter bw=new BufferedWriter(new FileWriter("stock_report.html"));
       bw.write("<html>");
       bw.write("<head>");
       bw.write("<title>Product's Stock Report</title>");
       bw.write("</head>");
       bw.write("<body>");
       bw.write("<center>");
       bw.write("<h1>Digital Products Current Stock Report</h1>"); 
       bw.write("<br>");
       bw.write("<br>");
       bw.write("Report Date: "+current_date);
       bw.write("<br>");
       bw.write("<table cellspacing=0 cellpadding=0 border=2>");
       bw.write("<tr>");
       bw.write("<th>Product ID No</th>");
       bw.write("<th>Product Type</th>");
       bw.write("<th>Brand Name</th>");
       bw.write("<th>Model No, Name</th>");
       bw.write("<th>Current Stock</th>");
       bw.write("</tr>");
      
       int vproduct_id,vstock;
       String vproduct_type,vbrand_name,vmodel;
       while(rs.next())
       {
         vproduct_id=rs.getInt(1);
         vproduct_type=rs.getString(2);
         vbrand_name=rs.getString(3);
         vmodel=rs.getString(4);
         vstock=rs.getInt(5);
         bw.write("<tr>"); 
         bw.write("<td>"+vproduct_id+"</td>"); 
         bw.write("<td>"+vproduct_type+"</td>"); 
         bw.write("<td>"+vbrand_name+"</td>"); 
         bw.write("<td>"+vmodel+"</td>"); 
         bw.write("<td>"+vstock+"</td>"); 
         bw.write("</tr>"); 
       }
       bw.write("</table>");       
       bw.write("</center>");
       bw.write("</body>");
       bw.write("</html>");
       bw.close();
       con.close();
      Runtime RT=Runtime.getRuntime();
      RT.exec("Explorer stock_report.html"); 
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
     new Current_Stock_Report();
   }
}