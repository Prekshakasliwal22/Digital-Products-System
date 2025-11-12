import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Read_Product_Form extends JFrame implements ActionListener,ItemListener
{
  JLabel lbtitle1,lbtitle2,lbstart_date,lbend_date;
  JLabel lbproduct_idno,lbproduct_type,lbbrand_name;
  JTextField tfstart_date,tfend_date;
  JTextField tfproduct_idno,tfproduct_type,tfbrand_name;
  JButton butreport,butvalidate,butcancel;
  JComboBox jcbproducts;
  int num;
  double gst;
  Connection con=null;
  Read_Product_Form(int no)
  {
    num=no;
    setSize(1050,550);
    setVisible(true);
    setLayout(null);
    setTitle("Accepting Products Data from User");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL",Font.BOLD,22);
   Font f2=new Font("ARIAL BLACK",Font.PLAIN,28);
   Font f3=new Font("ARIAL",Font.BOLD,20);
   Font f4=new Font("TIMES NEW ROMAN",Font.BOLD,16);

   lbtitle1=new JLabel("Select Digital Product and Enter PERIOD for producing");
   if(no==323)
       lbtitle2=new JLabel("Digital Productwise Inward Report");
   else if(no==354)
       lbtitle2=new JLabel("Digital Productwise Credit Sales Report");
   else if(no==355)
       lbtitle2=new JLabel("Digital Productwise Cash Sales Report");
   lbproduct_idno=new JLabel("Digital Product ID No.");
   lbproduct_type=new JLabel("Product Type");
   lbbrand_name=new JLabel("Brand Name");
   lbstart_date=new JLabel("Period from (Starting Date):");
   lbend_date=new JLabel("Period to (Ending Date):");

  tfproduct_idno=new JTextField();
  tfproduct_type=new JTextField();
  tfbrand_name=new JTextField();
  tfstart_date=new JTextField("15/09/2025");
  tfend_date=new JTextField("30/09/2025");

  jcbproducts=new JComboBox();
  jcbproducts.addItemListener(this);
  
  butreport=new JButton("Produce Report");
  butcancel=new JButton("Cancel");
  butvalidate=new JButton("Validate");
  butreport.addActionListener(this); 
  butcancel.addActionListener(this); 
  butvalidate.addActionListener(this); 

  lbtitle1.setFont(f1);
  lbtitle2.setFont(f2);
  lbproduct_idno.setFont(f3);
  lbproduct_type.setFont(f3);
  lbbrand_name.setFont(f3);
  lbstart_date.setFont(f3);
  lbend_date.setFont(f3);
  tfproduct_idno.setFont(f4);
  tfproduct_type.setFont(f4);
  tfbrand_name.setFont(f4);
  tfstart_date.setFont(f4);
  tfend_date.setFont(f4);
  jcbproducts.setFont(f4);
  butreport.setFont(f4);
  butcancel.setFont(f4);
  butvalidate.setFont(f4);

  add(lbtitle1);
  add(lbtitle2);
  add(lbproduct_idno);
  add(tfproduct_idno);
  add(lbproduct_type);
  add(tfproduct_type);
  add(lbbrand_name);
  add(tfbrand_name);
  add(lbstart_date);
  add(tfstart_date);
  add(lbend_date);
  add(tfend_date);
  add(jcbproducts);
  add(butreport);
  add(butcancel);
  add(butvalidate);

  lbtitle1.setBounds(235,50,580,25);
  lbtitle2.setBounds(175,100,700,35);
  lbproduct_idno.setBounds(50,215,300,20);
  tfproduct_idno.setBounds(400,215,150,20);
  butvalidate.setBounds(600,215,150,20);
  jcbproducts.setBounds(800,215,200,20);
  lbproduct_type.setBounds(50,250,300,20);
  tfproduct_type.setBounds(400,250,200,20);
  lbbrand_name.setBounds(50,285,300,20);
  tfbrand_name.setBounds(400,285,200,20);
  lbstart_date.setBounds(50,350,300,20);
  tfstart_date.setBounds(400,350,200,20);
  lbend_date.setBounds(50,400,300,20);
  tfend_date.setBounds(400,400,200,20);
  butreport.setBounds(250,475,200,30);
  butcancel.setBounds(500,475,200,30);

  tfproduct_type.setEditable(false);  
  tfbrand_name.setEditable(false);  

   try
   {
     Class.forName("com.mysql.cj.jdbc.Driver");
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
    //JOptionPane.showMessageDialog(this,"Connection made successfully");
    Statement st3=con.createStatement();
    ResultSet rs3=st3.executeQuery("select count(*) from Digital_Products_Master");
    rs3.next();
    int count2=rs3.getInt(1);
    if(count2>0)
    {
      Statement st4=con.createStatement();
      ResultSet rs4=st4.executeQuery("select digital_product_idno,product_type,brand_name,gst_in_per from Digital_Products_Master order by digital_product_idno");
     int vproduct_id;
     String vproduct_type,vbrand_name,vproduct_item;
     double vgst;
     while(rs4.next())
     {
       vproduct_id=rs4.getInt(1);
       vproduct_type=rs4.getString(2);
       vbrand_name=rs4.getString(3);
       vgst=rs4.getDouble(4);
       vproduct_item=String.valueOf(vproduct_id)+"$"+vproduct_type+"$"+vbrand_name+"$"+String.valueOf(vgst);
       jcbproducts.addItem(vproduct_item); 
     }
    }
  }
  catch(ClassNotFoundException e1)
  {
    JOptionPane.showMessageDialog(this,"Problems occured when loads,registers the drivers");
  }
  catch(SQLException e2)
  {
  JOptionPane.showMessageDialog(this,"Problems occured during eshtablishing the connection between Java and Oracle");
  }
  tfproduct_idno.setText("");
  tfproduct_type.setText("");
  tfbrand_name.setText("");
 }

   public void itemStateChanged(ItemEvent ie)
   {
      if(ie.getSource()==jcbproducts)
      {
         String item2="";
         item2=(String)jcbproducts.getSelectedItem();
         String products[]=item2.split("\\$");
         tfproduct_idno.setText(products[0]);
         tfproduct_type.setText(products[1]);
         tfbrand_name.setText(products[2]);                
         gst=Double.parseDouble(products[3]);
      }  
   }

   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==butreport)
      {
        if(tfproduct_idno.getText().length()==0)
        {
          tfproduct_idno.requestFocus();
          JOptionPane.showMessageDialog(this,"Product ID No. is empty, please enter proper Product ID No.");            
        }
       else if(tfproduct_type.getText().length()==0 || tfbrand_name.getText().length()==0)
       {
         JOptionPane.showMessageDialog(this,"Product ID No is not validated, please validate the Product ID No.");            
       }
        else if(tfstart_date.getText().length()==0)
        {
          tfstart_date.requestFocus();
          JOptionPane.showMessageDialog(this,"Start Date is empty, please enter the starting date.");            
        }
        else if(tfend_date.getText().length()==0)
        {
          tfend_date.requestFocus();
          JOptionPane.showMessageDialog(this,"End Date is empty, please enter the ending date.");            
        }
        else
        {
         dispose();
         if(num==323)
             new Productwise_Inward_Report(tfproduct_idno.getText(),tfproduct_type.getText(),tfbrand_name.getText(),tfstart_date.getText(),tfend_date.getText(),gst);
        else if(num==354)
             new Productwise_Credit_Sales_Report(tfproduct_idno.getText(),tfproduct_type.getText(),tfbrand_name.getText(),tfstart_date.getText(),tfend_date.getText(),gst);
       else if(num==355)
              new Productwise_Cash_Sales_Report(tfproduct_idno.getText(),tfproduct_type.getText(),tfbrand_name.getText(),tfstart_date.getText(),tfend_date.getText(),gst);
        }
      }
      else if(ae.getSource()==butcancel)
      {
         dispose();
      }          
   else if(ae.getSource()==butvalidate)
   {
       try
       {
        Statement st8=con.createStatement();
        ResultSet rs8=st8.executeQuery("select count(*) from Digital_Products_Master where digital_product_idno="+tfproduct_idno.getText());
        rs8.next();
        int c2=rs8.getInt(1);
        if(c2>0)
        {
           rs8=st8.executeQuery("select product_type,brand_name,gst_in_per from Digital_Products_Master where digital_product_idno="+tfproduct_idno.getText());
           rs8.next();
           String xproduct_type=rs8.getString(1);
           String xbrand_name=rs8.getString(2);
           gst=rs8.getDouble(3);
           tfproduct_type.setText(xproduct_type);
           tfbrand_name.setText(xbrand_name);
        }
       else
       {
          tfproduct_idno.requestFocus();
         JOptionPane.showMessageDialog(this,"Invalid Product ID Number, please check");        
       }
     }
     catch(SQLException e22)
     {
          JOptionPane.showMessageDialog(this,"Problems occured during validating the Product ID number");
     }
 
   }
  
 }

  public static void main(String args[])
  {
   new Read_Product_Form(322);   
  }
}