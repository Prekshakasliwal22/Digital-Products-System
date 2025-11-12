import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Read_Outlet_Form extends JFrame implements ActionListener,ItemListener
{
  JLabel lbtitle1,lbtitle2,lbstart_date,lbend_date;
  JLabel lboutlet_idno,lboutlet_firmname,lbcity;
  JTextField tfstart_date,tfend_date;
  JTextField tfoutlet_idno,tfoutlet_firmname,tfcity;
  JButton butreport,butvalidate,butcancel;
  JComboBox jcboutlets;
  int num;
  Connection con=null;
  Read_Outlet_Form(int no)
  {
    num=no;
    setSize(1050,550);
    setVisible(true);
    setLayout(null);
    setTitle("Accepting Outlet Data from User");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL",Font.BOLD,22);
   Font f2=new Font("ARIAL BLACK",Font.PLAIN,28);
   Font f3=new Font("ARIAL",Font.BOLD,20);
   Font f4=new Font("TIMES NEW ROMAN",Font.BOLD,16);

   lbtitle1=new JLabel("Select Outlet and Enter PERIOD for producing");
   if(no==322)
       lbtitle2=new JLabel("Company Outletwise Digital Products Inward Report");
   else if(no==342)
       lbtitle2=new JLabel("Company Outletwise Paid Payments Summary Report");
   lboutlet_idno=new JLabel("Company Outlet ID No.");
   lboutlet_firmname=new JLabel("Company Outlet Firmname");
   lbcity=new JLabel("City");
   lbstart_date=new JLabel("Period from (Starting Date):");
   lbend_date=new JLabel("Period to (Ending Date):");

  tfoutlet_idno=new JTextField();
  tfoutlet_firmname=new JTextField();
  tfcity=new JTextField();
  tfstart_date=new JTextField("15/09/2025");
  tfend_date=new JTextField("30/09/2025");

  jcboutlets=new JComboBox();
  jcboutlets.addItemListener(this);
  
  butreport=new JButton("Produce Report");
  butcancel=new JButton("Cancel");
  butvalidate=new JButton("Validate");
  butreport.addActionListener(this); 
  butcancel.addActionListener(this); 
  butvalidate.addActionListener(this); 

  lbtitle1.setFont(f1);
  lbtitle2.setFont(f2);
  lboutlet_idno.setFont(f3);
  lboutlet_firmname.setFont(f3);
  lbcity.setFont(f3);
  lbstart_date.setFont(f3);
  lbend_date.setFont(f3);
  tfoutlet_idno.setFont(f4);
  tfoutlet_firmname.setFont(f4);
  tfcity.setFont(f4);
  tfstart_date.setFont(f4);
  tfend_date.setFont(f4);
  jcboutlets.setFont(f4);
  butreport.setFont(f4);
  butcancel.setFont(f4);
  butvalidate.setFont(f4);

  add(lbtitle1);
  add(lbtitle2);
  add(lboutlet_idno);
  add(tfoutlet_idno);
  add(lboutlet_firmname);
  add(tfoutlet_firmname);
  add(lbcity);
  add(tfcity);
  add(lbstart_date);
  add(tfstart_date);
  add(lbend_date);
  add(tfend_date);
  add(jcboutlets);
  add(butreport);
  add(butcancel);
  add(butvalidate);

  lbtitle1.setBounds(275,50,500,25);
  lbtitle2.setBounds(100,100,850,35);
  lboutlet_idno.setBounds(50,215,300,20);
  tfoutlet_idno.setBounds(400,215,150,20);
  butvalidate.setBounds(600,215,150,20);
  jcboutlets.setBounds(800,215,200,20);
  lboutlet_firmname.setBounds(50,250,300,20);
  tfoutlet_firmname.setBounds(400,250,200,20);
  lbcity.setBounds(50,285,300,20);
  tfcity.setBounds(400,285,200,20);
  lbstart_date.setBounds(50,350,300,20);
  tfstart_date.setBounds(400,350,200,20);
  lbend_date.setBounds(50,400,300,20);
  tfend_date.setBounds(400,400,200,20);
  butreport.setBounds(250,475,200,30);
  butcancel.setBounds(500,475,200,30);

  tfoutlet_firmname.setEditable(false);  
  tfcity.setEditable(false);  

   try
   {
     Class.forName("com.mysql.cj.jdbc.Driver");
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
    //JOptionPane.showMessageDialog(this,"Connection made successfully");
    Statement st1=con.createStatement();
    ResultSet rs1=st1.executeQuery("select count(*) from Company_Outlets_Master");
    rs1.next();
    int count1=rs1.getInt(1);
    if(count1>0)
    {
      Statement st2=con.createStatement();
      ResultSet rs2=st2.executeQuery("select outlet_idno,outlet_firmname,city from Company_Outlets_Master order by outlet_idno");
     int voutlet_id;
     String voutlet_firmname,vcity,voutlet_item;
     while(rs2.next())
     {
       voutlet_id=rs2.getInt(1);
       voutlet_firmname=rs2.getString(2);
       vcity=rs2.getString(3);
       voutlet_item=String.valueOf(voutlet_id)+"$"+voutlet_firmname+"$"+vcity;
       jcboutlets.addItem(voutlet_item); 
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
  tfoutlet_idno.setText("");
  tfoutlet_firmname.setText("");
  tfcity.setText("");
 }

   public void itemStateChanged(ItemEvent ie)
   {
      if(ie.getSource()==jcboutlets)
      {
         String item1="";
         item1=(String)jcboutlets.getSelectedItem();
         String outlets[]=item1.split("\\$");
         tfoutlet_idno.setText(outlets[0]);
         tfoutlet_firmname.setText(outlets[1]);
         tfcity.setText(outlets[2]);
      }
   }

   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==butreport)
      {
        if(tfoutlet_idno.getText().length()==0)
        {
          tfoutlet_idno.requestFocus();
          JOptionPane.showMessageDialog(this,"Outlet ID No. is empty, please enter proper Outlet ID No.");            
        }
       else if(tfoutlet_firmname.getText().length()==0 || tfcity.getText().length()==0)
       {
         JOptionPane.showMessageDialog(this,"Outlet ID No is not validated, please validate the Outlet ID No.");            
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
         if(num==322)
               new Outletwise_Inward_Report(tfoutlet_idno.getText(),tfoutlet_firmname.getText(),tfcity.getText(),tfstart_date.getText(),tfend_date.getText());         
         else if(num==342)
               new Outletwise_Payments_Report(tfoutlet_idno.getText(),tfoutlet_firmname.getText(),tfcity.getText(),tfstart_date.getText(),tfend_date.getText());
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
        ResultSet rs5=st5.executeQuery("select count(*) from Company_Outlets_Master where outlet_idno="+tfoutlet_idno.getText());
        rs5.next();
        int c1=rs5.getInt(1);
        if(c1>0)
        {
           rs5=st5.executeQuery("select outlet_firmname,city from Company_Outlets_Master where outlet_idno="+tfoutlet_idno.getText());
           rs5.next();
           String xoutlet_firmname=rs5.getString(1);
           String xcity=rs5.getString(2);
           tfoutlet_firmname.setText(xoutlet_firmname);
           tfcity.setText(xcity);
        }
       else
       {
         JOptionPane.showMessageDialog(this,"Invalid Outlet ID Number, please check");        
       }
      }
     catch(SQLException e21)
     {
          JOptionPane.showMessageDialog(this,"Problems occured during validating the Outlet ID number");
     }
 
   }

   }

  public static void main(String args[])
  {
   new Read_Outlet_Form(322);   
  }
}