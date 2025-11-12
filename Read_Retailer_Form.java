import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Read_Retailer_Form extends JFrame implements ActionListener,ItemListener
{
  JLabel lbtitle1,lbtitle2,lbstart_date,lbend_date;
  JLabel lbretailer_idno,lbretailer_firmname,lbcity;
  JTextField tfstart_date,tfend_date;
  JTextField tfretailer_idno,tfretailer_firmname,tfcity;
  JButton butreport,butvalidate,butcancel;
  JComboBox jcbretailers;
  int num;
  Connection con=null;
  Read_Retailer_Form(int no)
  {
    num=no;
    setSize(1050,550);
    setVisible(true);
    setLayout(null);
    setTitle("Accepting Retailer Data from User");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL",Font.BOLD,22);
   Font f2=new Font("ARIAL BLACK",Font.PLAIN,28);
   Font f3=new Font("ARIAL",Font.BOLD,20);
   Font f4=new Font("TIMES NEW ROMAN",Font.BOLD,16);

   lbtitle1=new JLabel("Select Retailer and Enter PERIOD for producing");
    if(no==353)
       lbtitle2=new JLabel("Retailerwise Digital Products Credit Sales Report");
   else if(no==362)
       lbtitle2=new JLabel("Retailerwise received Payment Summary Report");
   lbretailer_idno=new JLabel("Retailer ID No.");
   lbretailer_firmname=new JLabel("Retailer Firmname");
   lbcity=new JLabel("City");
   lbstart_date=new JLabel("Period from (Starting Date):");
   lbend_date=new JLabel("Period to (Ending Date):");

  tfretailer_idno=new JTextField();
  tfretailer_firmname=new JTextField();
  tfcity=new JTextField();
  tfstart_date=new JTextField("15/09/2025");
  tfend_date=new JTextField("30/09/2025");

  jcbretailers=new JComboBox();
  jcbretailers.addItemListener(this);
  
  butreport=new JButton("Produce Report");
  butcancel=new JButton("Cancel");
  butvalidate=new JButton("Validate");
  butreport.addActionListener(this); 
  butcancel.addActionListener(this); 
  butvalidate.addActionListener(this); 

  lbtitle1.setFont(f1);
  lbtitle2.setFont(f2);
  lbretailer_idno.setFont(f3);
  lbretailer_firmname.setFont(f3);
  lbcity.setFont(f3);
  lbstart_date.setFont(f3);
  lbend_date.setFont(f3);
  tfretailer_idno.setFont(f4);
  tfretailer_firmname.setFont(f4);
  tfcity.setFont(f4);
  tfstart_date.setFont(f4);
  tfend_date.setFont(f4);
  jcbretailers.setFont(f4);
  butreport.setFont(f4);
  butcancel.setFont(f4);
  butvalidate.setFont(f4);

  add(lbtitle1);
  add(lbtitle2);
  add(lbretailer_idno);
  add(tfretailer_idno);
  add(lbretailer_firmname);
  add(tfretailer_firmname);
  add(lbcity);
  add(tfcity);
  add(lbstart_date);
  add(tfstart_date);
  add(lbend_date);
  add(tfend_date);
  add(jcbretailers);
  add(butreport);
  add(butcancel);
  add(butvalidate);

  lbtitle1.setBounds(275,50,500,25);
  lbtitle2.setBounds(100,100,850,35);
  lbretailer_idno.setBounds(50,215,300,20);
  tfretailer_idno.setBounds(400,215,150,20);
  butvalidate.setBounds(600,215,150,20);
  jcbretailers.setBounds(800,215,200,20);
  lbretailer_firmname.setBounds(50,250,300,20);
  tfretailer_firmname.setBounds(400,250,200,20);
  lbcity.setBounds(50,285,300,20);
  tfcity.setBounds(400,285,200,20);
  lbstart_date.setBounds(50,350,300,20);
  tfstart_date.setBounds(400,350,200,20);
  lbend_date.setBounds(50,400,300,20);
  tfend_date.setBounds(400,400,200,20);
  butreport.setBounds(250,475,200,30);
  butcancel.setBounds(500,475,200,30);

  tfretailer_firmname.setEditable(false);  
  tfcity.setEditable(false);  

   try
   {
     Class.forName("com.mysql.cj.jdbc.Driver");
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
    //JOptionPane.showMessageDialog(this,"Connection made successfully");
    Statement st1=con.createStatement();
    ResultSet rs1=st1.executeQuery("select count(*) from Retailers_Master");
    rs1.next();
    int count1=rs1.getInt(1);
    if(count1>0)
    {
      Statement st2=con.createStatement();
      ResultSet rs2=st2.executeQuery("select retailer_idno,retailer_firmname,city from Retailers_Master order by retailer_idno");
     int vretailer_id;
     String vretailer_firmname,vcity,vretailer_item;
     while(rs2.next())
     {
       vretailer_id=rs2.getInt(1);
       vretailer_firmname=rs2.getString(2);
       vcity=rs2.getString(3);
       vretailer_item=String.valueOf(vretailer_id)+"$"+vretailer_firmname+"$"+vcity;
       jcbretailers.addItem(vretailer_item); 
     }
    }
  }
  catch(ClassNotFoundException e1)
  {
    JOptionPane.showMessageDialog(this,"Problems occured when loads,registers the drivers");
  }
  catch(SQLException e2)
  {
  JOptionPane.showMessageDialog(this,"Problems occured during eshtablishing the connection between Java and MySQL");
  }
  tfretailer_idno.setText("");
  tfretailer_firmname.setText("");
  tfcity.setText("");
 }

   public void itemStateChanged(ItemEvent ie)
   {
      if(ie.getSource()==jcbretailers)
      {
         String item1="";
         item1=(String)jcbretailers.getSelectedItem();
         String retailers[]=item1.split("\\$");
         tfretailer_idno.setText(retailers[0]);
         tfretailer_firmname.setText(retailers[1]);
         tfcity.setText(retailers[2]);
      }
   }

   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==butreport)
      {
        if(tfretailer_idno.getText().length()==0)
        {
          tfretailer_idno.requestFocus();
          JOptionPane.showMessageDialog(this,"Retailer ID No. is empty, please enter proper Retailer ID No.");            
        }
       else if(tfretailer_firmname.getText().length()==0 || tfcity.getText().length()==0)
       {
         JOptionPane.showMessageDialog(this,"Retailer ID No is not validated, please validate the Retailer ID No.");            
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
         if(num==353)
            new Retailerwise_Sales_Report(tfretailer_idno.getText(),tfretailer_firmname.getText(),tfcity.getText(),tfstart_date.getText(),tfend_date.getText()); 
        else if(num==362)
            new Retailerwise_Payments_Report(tfretailer_idno.getText(),tfretailer_firmname.getText(),tfcity.getText(),tfstart_date.getText(),tfend_date.getText()); 
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
        Statement st5=con.createStatement();
        ResultSet rs5=st5.executeQuery("select count(*) from Retailers_Master where retailer_idno="+tfretailer_idno.getText());
        rs5.next();
        int c1=rs5.getInt(1);
        if(c1>0)
        {
           rs5=st5.executeQuery("select retailer_firmname,city from Retailers_Master where retailer_idno="+tfretailer_idno.getText());
           rs5.next();
           String xretailer_firmname=rs5.getString(1);
           String xcity=rs5.getString(2);
           tfretailer_firmname.setText(xretailer_firmname);
           tfcity.setText(xcity);
        }
       else
       {
         JOptionPane.showMessageDialog(this,"Invalid Retailer ID Number, please check");        
       }
      }
     catch(SQLException e21)
     {
          JOptionPane.showMessageDialog(this,"Problems occured during validating the Retailer ID number");
     }
 
    }          
   }

  public static void main(String args[])
  {
   new Read_Retailer_Form(353);   
  }
}