import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Outlet_Payments_DEF extends JFrame implements ActionListener,ItemListener
{
  JLabel lbtitle1, lbtitle2, lbentry_no, lbentry_date, lboutlet_idno, lboutlet_firmname, lbcity, lbpayment_amount, lbpayment_mode, lbreference,lbbalance_amount;
  JTextField tfentry_no, tfentry_date, tfoutlet_idno,tfoutlet_firmname, tfcity, tfpayment_amount, tfpayment_mode, tfreference,tfbalance_amount;
  JButton butadd, butsave, butsearch_view, butoutlet_validate,butclose;
  JComboBox jcboutlets;
  Connection con=null;
  Outlet_Payments_DEF()
  {
    setSize(1380,730);
    setVisible(true);
    setLayout(null);
    setTitle("Outlet Payment Application");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL BLACK",Font.PLAIN,30);
   Font f2=new Font("ARIAL",Font.BOLD,24);
   Font f3=new Font("ARIAL",Font.BOLD,20);
   Font f4=new Font("TIMES NEW ROMAN",Font.BOLD,14);

   lbtitle1 = new JLabel("OUTLET PAYMENT data entry form");
   lbtitle2 = new JLabel("Data Entry of Paid Payment to Company Outlet");
   lbentry_no = new JLabel("Paid Payment Entry No.");
   lbentry_date = new JLabel("Paid Payment Date");
   lboutlet_idno = new JLabel("Company Outlet ID No.");
   lboutlet_firmname = new JLabel("Outlet Firmname");
   lbcity = new JLabel("City");   
   lbpayment_amount = new JLabel("Paid Payment Amount");
   lbpayment_mode = new JLabel("Mode of Payment");
   lbreference = new JLabel("Against / Reference");
   lbbalance_amount = new JLabel("Balance Amount");

   tfentry_no = new JTextField();
   tfentry_date = new JTextField();
   tfoutlet_idno = new JTextField();
   tfoutlet_firmname = new JTextField();
   tfcity = new JTextField();   
   tfpayment_amount = new JTextField();
   tfpayment_mode = new JTextField();
   tfreference = new JTextField();
   tfbalance_amount = new JTextField();

  butadd = new JButton("Add New Payment");
  butsave = new JButton("Save Payment Data");
  butsearch_view = new JButton("Search, View Payment");
  butclose = new JButton("Close the Form");
  butoutlet_validate = new JButton("Validate");
  butadd.addActionListener(this);
  butsave.addActionListener(this);
  butsearch_view.addActionListener(this);
  butclose.addActionListener(this);
  butoutlet_validate.addActionListener(this);
  jcboutlets=new JComboBox();
  jcboutlets.addItemListener(this);
  
  lbtitle1.setFont(f1);
  lbtitle2.setFont(f2);
  lbentry_no.setFont(f3);
  lbentry_date.setFont(f3);
  lboutlet_idno.setFont(f3);
  lboutlet_firmname.setFont(f3);
  lbcity.setFont(f3);
  lbpayment_amount.setFont(f3);
  lbpayment_mode.setFont(f3);
  lbreference.setFont(f3);
  lbbalance_amount.setFont(f3);
  
  tfentry_no.setFont(f4);
  tfentry_date.setFont(f4);
  tfoutlet_idno.setFont(f4);
  tfoutlet_firmname.setFont(f4);
  tfcity.setFont(f4); 
  tfpayment_amount.setFont(f4);
  tfpayment_mode.setFont(f4);
  tfreference.setFont(f4);
  tfbalance_amount.setFont(f4);

  butadd.setFont(f3);
  butsave.setFont(f3);
  butsearch_view.setFont(f3);
  butclose.setFont(f3);
  butoutlet_validate.setFont(f3);
  jcboutlets.setFont(f3);

  add(lbtitle1);
  add(lbtitle2);
  add(lbentry_no);
  add(tfentry_no);
  add(lbentry_date);
  add(tfentry_date);
  add(lboutlet_idno);
  add(tfoutlet_idno);
  add(lboutlet_firmname);
  add(tfoutlet_firmname);
  add(lbcity);
  add(tfcity);
  add(lbpayment_amount);
  add(tfpayment_amount);
  add(lbpayment_mode);
  add(tfpayment_mode);
  add(lbreference);
  add(tfreference);
  add(lbbalance_amount);
  add(tfbalance_amount);
  add(butadd);
  add(butsave);
  add(butsearch_view);
  add(butclose);
  add(butoutlet_validate);
  add(jcboutlets);

  lbtitle1.setBounds(325,50,650,35);
  lbtitle2.setBounds(350,100,550,25);
  lbentry_no.setBounds(150,200,250,20);
  tfentry_no.setBounds(450,200,150,20);
  lbentry_date.setBounds(150,240,250,20);
  tfentry_date.setBounds(450,240,200,20);
  lboutlet_idno.setBounds(150,290,250,20);
  tfoutlet_idno.setBounds(450,290,150,20);
  butoutlet_validate.setBounds(630,290,150,20);
  jcboutlets.setBounds(810,290,250,25);
  lboutlet_firmname.setBounds(150,320,300,20);
  tfoutlet_firmname.setBounds(450,320,500,20);
  lbcity.setBounds(150,350,250,20);
  tfcity.setBounds(450,350,250,20);
  lbbalance_amount.setBounds(775,350,200,20);
  tfbalance_amount.setBounds(1000,350,200,20);
  lbpayment_amount.setBounds(150,400,250,20);
  tfpayment_amount.setBounds(450,400,200,20);
  lbpayment_mode.setBounds(150,440,250,20);
  tfpayment_mode.setBounds(450,440,350,20);
  lbreference.setBounds(150,480,250,20);
  tfreference.setBounds(450,480,500,20);
  butadd.setBounds(100,590,225,30);
  butsave.setBounds(350,590,225,30);
  butsearch_view.setBounds(600,590,300,30);
  butclose.setBounds(925,590,225,30);
   
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
      ResultSet rs2=st2.executeQuery("select o.outlet_idno,o.outlet_firmname,o.city,l.balance_amount from Company_Outlets_Master o,Company_Outlets_Ledger l where o.outlet_idno=l.outlet_idno order by o.outlet_idno");
      int voutlet_id,vbalance_amount;
      String voutlet_firmname,vcity,voutlet_item;
      while(rs2.next())
      {
       voutlet_id=rs2.getInt(1);
       voutlet_firmname=rs2.getString(2);
       vcity=rs2.getString(3);
       vbalance_amount=rs2.getInt(4);
       voutlet_item=String.valueOf(voutlet_id)+"$"+voutlet_firmname+"$"+vcity+"$"+String.valueOf(vbalance_amount);
       jcboutlets.addItem(voutlet_item); 
     }
   }
    Statement st3=con.createStatement();
    ResultSet rs3=st3.executeQuery("select count(*) from Outlet_Payments");
    rs3.next();
    int count2=rs3.getInt(1);
    if(count2==0)
        butsearch_view.setEnabled(false);
    else
        butsearch_view.setEnabled(true);
  }
  catch(ClassNotFoundException e1)
  {
    JOptionPane.showMessageDialog(this,"Problems occured when loads,registers the drivers");
  }
  catch(SQLException e2)
  {
  JOptionPane.showMessageDialog(this,"Problems occured during eshtablishing the connection between Java and MySQL\n" + e2.getMessage());
  }
  
  tfoutlet_idno.setText("");
  tfoutlet_firmname.setText("");
  tfcity.setText(""); 

   tfentry_no.setEnabled(false);
   tfentry_date.setEnabled(false);
   tfoutlet_idno.setEnabled(false);
   tfoutlet_firmname.setEnabled(false);
   tfcity.setEnabled(false);
   tfbalance_amount.setEnabled(false);
   tfpayment_amount.setEnabled(false);
   tfpayment_mode.setEnabled(false);
   tfreference.setEnabled(false);
   butoutlet_validate.setEnabled(false);
   jcboutlets.setEnabled(false);
   butsave.setEnabled(false);
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
         tfbalance_amount.setText(outlets[3]);
         tfpayment_amount.requestFocus();
      }
   }
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==butadd)
      {
       tfentry_no.setEnabled(true);
       tfentry_date.setEnabled(true);
       tfoutlet_idno.setEnabled(true);
       tfoutlet_firmname.setEnabled(true);
       tfcity.setEnabled(true);
       tfbalance_amount.setEnabled(true);
       tfpayment_amount.setEnabled(true);
       tfpayment_mode.setEnabled(true);
       tfreference.setEnabled(true);
       butoutlet_validate.setEnabled(true);
       jcboutlets.setEnabled(true);
       butsave.setEnabled(true);

       tfentry_date.setEditable(true);
       tfoutlet_idno.setEditable(true);
       tfpayment_amount.setEditable(true);
       tfpayment_mode.setEditable(true);
       tfreference.setEditable(true);
       tfoutlet_firmname.setEditable(false);
       tfcity.setEditable(false);
       tfbalance_amount.setEditable(false);

        tfentry_no.setText("");
        tfentry_date.setText("");
        tfoutlet_idno.setText("");
        tfoutlet_firmname.setText("");
        tfcity.setText("");
        tfpayment_amount.setText("");
        tfpayment_mode.setText("");
        tfreference.setText("");
        butoutlet_validate.setEnabled(true);
        jcboutlets.setEnabled(true);
       
       try
       {
        Statement st4=con.createStatement();
        ResultSet rs4=st4.executeQuery("select max(paid_payment_entryno) from Outlet_Payments");
        rs4.next();
        int x=rs4.getInt(1)+1;
        tfentry_no.setText(String.valueOf(x));
        tfentry_no.setEditable(false);        
       }
       catch(SQLException e3)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during generating next Payment's Entry Number");     
       }
    
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
       String current_date=sdf.format(dt);
       tfentry_date.setText(current_date);
       tfentry_date.requestFocus();
      }
      else if(ae.getSource()==butsave)
      {
       if(tfentry_date.getText().length()==0)
       {
         tfentry_date.requestFocus();
         JOptionPane.showMessageDialog(this,"Outlet Payment Date is empty, please enter the payment date");            
       }
       else if(tfoutlet_idno.getText().length()==0)
       {
         tfoutlet_idno.requestFocus();
         JOptionPane.showMessageDialog(this,"Outlet ID No. is empty, please enter proper Outlet ID No.");            
       }
       else if(tfoutlet_firmname.getText().length()==0 || tfcity.getText().length()==0)
       {
         JOptionPane.showMessageDialog(this,"Outlet ID No is not validated, please validate the Outlet ID No.");            
       }
       else if(Integer.parseInt(tfpayment_amount.getText())>Integer.parseInt(tfbalance_amount.getText()))
       {
          tfpayment_amount.requestFocus();
         JOptionPane.showMessageDialog(this,"Invalid Payment Amount, Payment Amount is greater than Balance Amount");            
       }
       else
       {
         try
         {
          PreparedStatement ps1=con.prepareStatement("insert into Outlet_Payments values(?,?,?,?,?,?)");
          ps1.setInt(1,Integer.parseInt(tfentry_no.getText()));
          SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
          Date paydate=sdf2.parse(tfentry_date.getText());
          java.sql.Date mydate=new java.sql.Date(paydate.getTime());
          ps1.setDate(2,mydate);
          ps1.setInt(3,Integer.parseInt(tfoutlet_idno.getText()));
          ps1.setInt(4,Integer.parseInt(tfpayment_amount.getText()));
          ps1.setString(5,tfpayment_mode.getText());
          ps1.setString(6,tfreference.getText());
          ps1.executeUpdate();
         JOptionPane.showMessageDialog(this,"Outlet's Payment Data is Added, Saved Successfully in the table");

          PreparedStatement pstmt=con.prepareStatement("update Company_Outlets_Ledger set balance_amount=balance_amount-"+tfpayment_amount.getText()+" where outlet_idno="+tfoutlet_idno.getText());
          pstmt.executeUpdate();

          tfentry_no.setEnabled(false);
          tfentry_date.setEnabled(false);
          tfoutlet_idno.setEnabled(false);
          tfoutlet_firmname.setEnabled(false);
          tfcity.setEnabled(false);
          tfpayment_amount.setEnabled(false);
          tfpayment_mode.setEnabled(false);
          tfreference.setEnabled(false);
          butoutlet_validate.setEnabled(false);
          jcboutlets.setEnabled(false);
         }
         catch(SQLException e4)
        {
         JOptionPane.showMessageDialog(this,"Problems occured during saving Outlet's Payment Data");     
        }
         catch(ParseException e5)
        {
         JOptionPane.showMessageDialog(this,"Problems occured during setting the Payment Date");     
        }
          butsave.setEnabled(false);
          if(butsearch_view.isEnabled()==false)
               butsearch_view.setEnabled(false);         
     }   
    }
      else if(ae.getSource()==butsearch_view)
      {
         int entryno;
         entryno=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Outlet Payment Entry Number, whose record you want to search"));
         try
        {
          int chk=0;
          Statement st5=con.createStatement();
          ResultSet rs5=st5.executeQuery("select a.paid_payment_entryno, a.paid_payment_date, a.outlet_idno, b.outlet_firmname, b.city,a.paid_payment_amount,a.mode_of_payment,a.against_reference from Outlet_Payments a, Company_Outlets_Master b where a.outlet_idno=b.outlet_idno order by a.paid_payment_entryno");
         while(rs5.next())
         {
           if(rs5.getInt(1)==entryno)
           {
             tfentry_no.setEnabled(true);
             tfentry_no.setEditable(true);
             tfentry_no.setText(String.valueOf(rs5.getInt(1)));
             tfentry_no.setEditable(false);
             tfentry_date.setEnabled(true);
             tfentry_date.setEditable(true);
             SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
             String entrydate=sdf.format(rs5.getDate(2));
             tfentry_date.setText(entrydate);
             tfentry_date.setEditable(false);
             tfoutlet_idno.setEnabled(true);
             tfoutlet_idno.setEditable(true);
             tfoutlet_idno.setText(String.valueOf(rs5.getInt(3)));
             tfoutlet_idno.setEditable(false);
             tfoutlet_firmname.setEnabled(true);
             tfoutlet_firmname.setEditable(true);
             tfoutlet_firmname.setText(rs5.getString(4));
             tfoutlet_firmname.setEditable(false);
             tfcity.setEnabled(true);
             tfcity.setEditable(true);
             tfcity.setText(rs5.getString(5));
             tfcity.setEditable(false);
             tfpayment_amount.setEnabled(true);
             tfpayment_amount.setEditable(true);
             tfpayment_amount.setText(String.valueOf(rs5.getInt(6)));
             tfpayment_amount.setEditable(false);
             tfpayment_mode.setEnabled(true);
             tfpayment_mode.setEditable(true);
             tfpayment_mode.setText(rs5.getString(7));
             tfpayment_mode.setEditable(false);
             tfreference.setEnabled(true);
             tfreference.setEditable(true);
             tfreference.setText(rs5.getString(8));
             tfreference.setEditable(false);
            JOptionPane.showMessageDialog(this,"Outlet Payment Entry Number is found and viewed on the screen");    
            chk=1;
            break;
          }       
        }
        if(chk==0)
         JOptionPane.showMessageDialog(this,"Invalid Outlet Payment Entry Number, such entry number does not exist");        
    }
    catch(SQLException e6)
   {
    JOptionPane.showMessageDialog(this,"Problems occured during searching,viewing the record.");
   }  
  
      }

      else if(ae.getSource()==butclose)
      {
         try
         {
          con.close();
         }
         catch(SQLException e7)
         {
          JOptionPane.showMessageDialog(this,"Problems occured when closing the connection");
         }
        dispose();           
      }
      else if(ae.getSource()==butoutlet_validate)
      {
       try
       {
        Statement st6=con.createStatement();
        ResultSet rs6=st6.executeQuery("select count(*) from Company_Outlets_Master where outlet_idno="+tfoutlet_idno.getText());
        rs6.next();
        int c1=rs6.getInt(1);
        if(c1>0)
        {
           rs6=st6.executeQuery("select o.outlet_firmname,o.city,l.balance_amount from Company_Outlets_Master o,Company_Outlets_Ledger l where o.outlet_idno=l.outlet_idno and o.outlet_idno="+tfoutlet_idno.getText());
           rs6.next();
           String xoutlet_firmname=rs6.getString(1);
           String xcity=rs6.getString(2);
           int xbalance_amount=rs6.getInt(3);
           tfoutlet_firmname.setText(xoutlet_firmname);
           tfcity.setText(xcity);
           tfbalance_amount.setText(String.valueOf(xbalance_amount));
           tfpayment_amount.requestFocus();
           butoutlet_validate.setEnabled(false);
        }
       else
       {
         JOptionPane.showMessageDialog(this,"Invalid Outlet ID Number, please check");        
       }
      }
     catch(SQLException e8)
     {
          JOptionPane.showMessageDialog(this,"Problems occured during validating the Outlet ID number");
     }
 
   }
  
}
  public static void main(String args[])
  {
   new Outlet_Payments_DEF();   
  }
}