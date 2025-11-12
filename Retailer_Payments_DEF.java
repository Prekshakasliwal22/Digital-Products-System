import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Retailer_Payments_DEF extends JFrame implements ActionListener,ItemListener
{
  JLabel lbtitle1, lbtitle2, lbentry_no, lbentry_date, lbretailer_idno, lbretailer_firmname, lbcity, lbpayment_amount, lbpayment_mode, lbreference,lbbalance_amount;
  JTextField tfentry_no, tfentry_date, tfretailer_idno,tfretailer_firmname, tfcity, tfpayment_amount, tfpayment_mode, tfreference,tfbalance_amount;
  JButton butadd, butsave, butsearch_view, butretailer_validate,butclose;
  JComboBox jcbretailers;
  Connection con=null;
  Retailer_Payments_DEF()
  {
    setSize(1250,700);
    setVisible(true);
    setLayout(null);
    setTitle("Retailer Payment Application");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL BLACK",Font.PLAIN,30);
   Font f2=new Font("ARIAL",Font.BOLD,24);
   Font f3=new Font("ARIAL",Font.BOLD,20);
   Font f4=new Font("TIMES NEW ROMAN",Font.BOLD,14);

   lbtitle1 = new JLabel("RETAILER PAYMENT data entry form");
   lbtitle2 = new JLabel("Data Entry of Received Payments from Retailers");
   lbentry_no = new JLabel("Received Payment Entry No.");
   lbentry_date = new JLabel("Received Payment Date");
   lbretailer_idno = new JLabel("Retailer's ID No.");
   lbretailer_firmname = new JLabel("Retailer Firmname");
   lbcity = new JLabel("City");   
   lbpayment_amount = new JLabel("Received Payment Amount");
   lbpayment_mode = new JLabel("Mode of Payment");
   lbreference = new JLabel("Against / Reference");
   lbbalance_amount = new JLabel("Balance Amount");

   tfentry_no = new JTextField();
   tfentry_date = new JTextField();
   tfretailer_idno = new JTextField();
   tfretailer_firmname = new JTextField();
   tfcity = new JTextField();   
   tfpayment_amount = new JTextField();
   tfpayment_mode = new JTextField();
   tfreference = new JTextField();
   tfbalance_amount = new JTextField();

  butadd = new JButton("Add New Payment");
  butsave = new JButton("Save Payment Data");
  butsearch_view = new JButton("Search, View Payment");
  butclose = new JButton("Close the Form");
  butretailer_validate = new JButton("Validate");
  butadd.addActionListener(this);
  butsave.addActionListener(this);
  butsearch_view.addActionListener(this);
  butclose.addActionListener(this);
  butretailer_validate.addActionListener(this);
  jcbretailers=new JComboBox();
  jcbretailers.addItemListener(this);
  
  lbtitle1.setFont(f1);
  lbtitle2.setFont(f2);
  lbentry_no.setFont(f3);
  lbentry_date.setFont(f3);
  lbretailer_idno.setFont(f3);
  lbretailer_firmname.setFont(f3);
  lbcity.setFont(f3);
  lbpayment_amount.setFont(f3);
  lbpayment_mode.setFont(f3);
  lbreference.setFont(f3);
  lbbalance_amount.setFont(f3);
  
  tfentry_no.setFont(f4);
  tfentry_date.setFont(f4);
  tfretailer_idno.setFont(f4);
  tfretailer_firmname.setFont(f4);
  tfcity.setFont(f4); 
  tfpayment_amount.setFont(f4);
  tfpayment_mode.setFont(f4);
  tfreference.setFont(f4);
  tfbalance_amount.setFont(f4);

  butadd.setFont(f3);
  butsave.setFont(f3);
  butsearch_view.setFont(f3);
  butclose.setFont(f3);
  butretailer_validate.setFont(f3);
  jcbretailers.setFont(f3);

  add(lbtitle1);
  add(lbtitle2);
  add(lbentry_no);
  add(tfentry_no);
  add(lbentry_date);
  add(tfentry_date);
  add(lbretailer_idno);
  add(tfretailer_idno);
  add(lbretailer_firmname);
  add(tfretailer_firmname);
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
  add(butretailer_validate);
  add(jcbretailers);

  lbtitle1.setBounds(325,50,650,35);
  lbtitle2.setBounds(350,100,550,25);
  lbentry_no.setBounds(125,200,275,20);
  tfentry_no.setBounds(450,200,150,20);
  lbentry_date.setBounds(150,240,250,20);
  tfentry_date.setBounds(450,240,200,20);
  lbretailer_idno.setBounds(150,290,250,20);
  tfretailer_idno.setBounds(450,290,150,20);
  butretailer_validate.setBounds(630,290,150,20);
  jcbretailers.setBounds(810,290,250,25);
  lbretailer_firmname.setBounds(150,320,300,20);
  tfretailer_firmname.setBounds(450,320,500,20);
  lbcity.setBounds(150,350,250,20);
  tfcity.setBounds(450,350,250,20);
  lbbalance_amount.setBounds(775,350,200,20);
  tfbalance_amount.setBounds(1000,350,200,20);
  lbpayment_amount.setBounds(125,400,275,20);
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
    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
    //JOptionPane.showMessageDialog(this,"Connection made successfully");
    Statement st1=con.createStatement();
    ResultSet rs1=st1.executeQuery("select count(*) from Retailers_Master");
    rs1.next();
    int count1=rs1.getInt(1);
    if(count1>0)
    {
      Statement st2=con.createStatement();
      ResultSet rs2=st2.executeQuery("select r.retailer_idno,r.retailer_firmname,r.city,l.balance_amount from Retailers_Master r,Retailers_Ledger l where r.retailer_idno=l.retailer_idno order by r.retailer_idno");
     int vretailer_id,vbalance_amount;
     String vretailer_firmname,vcity,vretailer_item;
     while(rs2.next())
     {
       vretailer_id=rs2.getInt(1);
       vretailer_firmname=rs2.getString(2);
       vcity=rs2.getString(3);
       vbalance_amount=rs2.getInt(4);
       vretailer_item=String.valueOf(vretailer_id)+"$"+vretailer_firmname+"$"+vcity+"$"+String.valueOf(vbalance_amount);
       jcbretailers.addItem(vretailer_item); 
     }
    }
    Statement st3=con.createStatement();
    ResultSet rs3=st3.executeQuery("select count(*) from Retailer_Payments");
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
  JOptionPane.showMessageDialog(this,"Problems occured during eshtablishing the connection between Java and Oracle");
  }
  
  tfretailer_idno.setText("");
  tfretailer_firmname.setText("");
  tfcity.setText(""); 

   tfentry_no.setEnabled(false);
   tfentry_date.setEnabled(false);
   tfretailer_idno.setEnabled(false);
   tfretailer_firmname.setEnabled(false);
   tfcity.setEnabled(false);
   tfbalance_amount.setEnabled(false);
   tfpayment_amount.setEnabled(false);
   tfpayment_mode.setEnabled(false);
   tfreference.setEnabled(false);
   butretailer_validate.setEnabled(false);
   jcbretailers.setEnabled(false);
   butsave.setEnabled(false);
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
         tfbalance_amount.setText(retailers[3]);
         tfpayment_amount.requestFocus();
      }
   }
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==butadd)
      {
       tfentry_no.setEnabled(true);
       tfentry_date.setEnabled(true);
       tfretailer_idno.setEnabled(true);
       tfretailer_firmname.setEnabled(true);
       tfcity.setEnabled(true);
       tfbalance_amount.setEnabled(true);
       tfpayment_amount.setEnabled(true);
       tfpayment_mode.setEnabled(true);
       tfreference.setEnabled(true);
       butretailer_validate.setEnabled(true);
       jcbretailers.setEnabled(true);
       butsave.setEnabled(true);

       tfentry_date.setEditable(true);
       tfretailer_idno.setEditable(true);
       tfpayment_amount.setEditable(true);
       tfpayment_mode.setEditable(true);
       tfreference.setEditable(true);
       tfretailer_firmname.setEditable(false);
       tfcity.setEditable(false);
       tfbalance_amount.setEditable(false);

        tfentry_no.setText("");
        tfentry_date.setText("");
        tfretailer_idno.setText("");
        tfretailer_firmname.setText("");
        tfcity.setText("");
        tfpayment_amount.setText("");
        tfpayment_mode.setText("");
        tfreference.setText("");
        butretailer_validate.setEnabled(true);
        jcbretailers.setEnabled(true);
       
       try
       {
        Statement st4=con.createStatement();
        ResultSet rs4=st4.executeQuery("select max(received_payment_entryno) from Retailer_Payments");
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
         JOptionPane.showMessageDialog(this,"Retailer Payment Date is empty, please enter the payment date");            
       }
       else if(tfretailer_idno.getText().length()==0)
       {
         tfretailer_idno.requestFocus();
         JOptionPane.showMessageDialog(this,"Retailer ID No. is empty, please enter proper Received ID No.");            
       }
       else if(tfretailer_firmname.getText().length()==0 || tfcity.getText().length()==0)
       {
         JOptionPane.showMessageDialog(this,"Retailer ID No is not validated, please validate the Retailer ID No.");            
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
          PreparedStatement ps1=con.prepareStatement("insert into Retailer_Payments values(?,?,?,?,?,?)");
          ps1.setInt(1,Integer.parseInt(tfentry_no.getText()));
          SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
          Date paydate=sdf2.parse(tfentry_date.getText());
          java.sql.Date mydate=new java.sql.Date(paydate.getTime());
          ps1.setDate(2,mydate);
          ps1.setInt(3,Integer.parseInt(tfretailer_idno.getText()));
          ps1.setInt(4,Integer.parseInt(tfpayment_amount.getText()));
          ps1.setString(5,tfpayment_mode.getText());
          ps1.setString(6,tfreference.getText());
          ps1.executeUpdate();
         JOptionPane.showMessageDialog(this,"Retailer's Payment Data is Added, Saved Successfully in the table");

          PreparedStatement pstmt=con.prepareStatement("update Retailers_Ledger set balance_amount=balance_amount-"+tfpayment_amount.getText()+" where retailer_idno="+tfretailer_idno.getText());
          pstmt.executeUpdate();
          
          tfentry_no.setEnabled(false);
          tfentry_date.setEnabled(false);
          tfretailer_idno.setEnabled(false);
          tfretailer_firmname.setEnabled(false);
          tfcity.setEnabled(false);
          tfpayment_amount.setEnabled(false);
          tfpayment_mode.setEnabled(false);
          tfreference.setEnabled(false);
          butretailer_validate.setEnabled(false);
          jcbretailers.setEnabled(false);
         }
         catch(SQLException e4)
        {
         JOptionPane.showMessageDialog(this,"Problems occured during saving Retailer's Payment Data");     
        }
         catch(ParseException e5)
        {
         JOptionPane.showMessageDialog(this,"Problems occured during setting the Payment Date");     
        }
          butsave.setEnabled(false);
          if(butsearch_view.isEnabled()==false)
               butsearch_view.setEnabled(true);         
     }   
    }
      else if(ae.getSource()==butsearch_view)
      {
         int entryno;
         entryno=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Retailer Payment Entry Number, whose record you want to search"));
         try
        {
          int chk=0;
          Statement st5=con.createStatement();
          ResultSet rs5=st5.executeQuery("select a.received_payment_entryno, a.received_payment_date, a.retailer_idno, b.retailer_firmname, b.city,a.received_payment_amount,a.mode_of_payment,a.against_reference from Retailer_Payments a, Retailers_Master b where a.retailer_idno=b.retailer_idno order by a.received_payment_entryno");
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
             tfretailer_idno.setEnabled(true);
             tfretailer_idno.setEditable(true);
             tfretailer_idno.setText(String.valueOf(rs5.getInt(3)));
             tfretailer_idno.setEditable(false);
             tfretailer_firmname.setEnabled(true);
             tfretailer_firmname.setEditable(true);
             tfretailer_firmname.setText(rs5.getString(4));
             tfretailer_firmname.setEditable(false);
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
            JOptionPane.showMessageDialog(this,"Retailer Payment Entry Number is found and viewed on the screen");    
            chk=1;
            break;
          }       
        }
        if(chk==0)
         JOptionPane.showMessageDialog(this,"Invalid Retailer Payment Entry Number, such entry number does not exist");        
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
      else if(ae.getSource()==butretailer_validate)
      {
       try
       {
        Statement st6=con.createStatement();
        ResultSet rs6=st6.executeQuery("select count(*) from Retailers_Master where retailer_idno="+tfretailer_idno.getText());
        rs6.next();
        int c1=rs6.getInt(1);
        if(c1>0)
        {
           rs6=st6.executeQuery("select r.retailer_firmname,r.city,l.balance_amount from Retailers_Master r, Retailers_Ledger l where r.retailer_idno=l.retailer_idno and r.retailer_idno="+tfretailer_idno.getText());
           rs6.next();
           String xretailer_firmname=rs6.getString(1);
           String xcity=rs6.getString(2);
           int xbalance_amount=rs6.getInt(3);
           tfretailer_firmname.setText(xretailer_firmname);
           tfcity.setText(xcity);
           tfbalance_amount.setText(String.valueOf(xbalance_amount));
           tfpayment_amount.requestFocus();
           butretailer_validate.setEnabled(false);
        }
       else
       {
         JOptionPane.showMessageDialog(this,"Invalid Retailer ID Number, please check");        
       }
      }
     catch(SQLException e8)
     {
          JOptionPane.showMessageDialog(this,"Problems occured during validating the Retailer ID number");
     }
 
   }
  
}
  public static void main(String args[])
  {
   new Retailer_Payments_DEF();   
  }
}