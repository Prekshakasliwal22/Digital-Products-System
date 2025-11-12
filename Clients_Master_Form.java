import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
public class Clients_Master_Form extends JFrame implements ActionListener
{
  JLabel lbtitle,lbclient_idno,lbclient_name,lbaddress,lbcity,lbgender,lbbirth_date, lbmobile_no,lbemail_id;
  JTextField tfclient_idno,tfclient_name,tfaddress,tfcity,tfgender,tfbirth_date, tfmobile_no,tfemail_id;
  JButton butadd,butdelete,butmodify,butsave,butsearch,butfirst,butprevious,butnext,butlast,butclose;
  Connection con=null;
  Statement st=null;
  ResultSet rs=null;
  char check='X';
  int count=0;
  Clients_Master_Form()
  {
    setSize(1380,730);
    setVisible(true);
    setLayout(null);
    setTitle("Clients Master Application");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL BLACK",Font.PLAIN,30);
   Font f2=new Font("ARIAL",Font.BOLD,22);
   Font f3=new Font("TIMES NEW ROMAN",Font.BOLD,16);

   lbtitle=new JLabel("CLIENTS master data manipulation form");
   lbclient_idno=new JLabel("Client's ID No.");
   lbclient_name=new JLabel("Client's Name");
   lbaddress=new JLabel("Address");
   lbcity=new JLabel("City");
   lbgender=new JLabel("Gender(M/F)");
   lbbirth_date=new JLabel("Date of Birth");
   lbmobile_no=new JLabel("Mobile No.");
   lbemail_id=new JLabel("Email ID");

  tfclient_idno=new JTextField();
  tfclient_name=new JTextField();
  tfaddress=new JTextField();
  tfcity=new JTextField();
  tfgender=new JTextField();
  tfbirth_date=new JTextField();
  tfmobile_no=new JTextField();
  tfemail_id=new JTextField();

  butadd=new JButton("Add New Client");
  butdelete=new JButton("Delete the Record");
  butmodify=new JButton("Modify the Data");
  butsave=new JButton("Save Client Data");
  butsearch=new JButton("Search the Client");
  butclose=new JButton("Close the Form");
  butfirst=new JButton("First Client");
  butnext=new JButton("Next Client");
  butprevious=new JButton("Previous Client");
  butlast=new JButton("Last Client");
  butadd.addActionListener(this); 
  butdelete.addActionListener(this); 
  butmodify.addActionListener(this); 
  butsave.addActionListener(this); 
  butsearch.addActionListener(this); 
  butclose.addActionListener(this); 
  butfirst.addActionListener(this); 
  butprevious.addActionListener(this); 
  butnext.addActionListener(this); 
  butlast.addActionListener(this); 

  lbtitle.setFont(f1);
  lbclient_idno.setFont(f2);
  lbclient_name.setFont(f2);
  lbaddress.setFont(f2);
  lbcity.setFont(f2);
  lbgender.setFont(f2);
  lbbirth_date.setFont(f2);
  lbmobile_no.setFont(f2);
  lbemail_id.setFont(f2);
  tfclient_idno.setFont(f3);
  tfclient_name.setFont(f3);
  tfaddress.setFont(f3);
  tfcity.setFont(f3);
  tfgender.setFont(f3);
  tfbirth_date.setFont(f3);
  tfmobile_no.setFont(f3);
  tfemail_id.setFont(f3);
  butadd.setFont(f3);
  butdelete.setFont(f3);
  butmodify.setFont(f3);
  butsave.setFont(f3);
  butsearch.setFont(f3);
  butclose.setFont(f3);
  butfirst.setFont(f3);
  butprevious.setFont(f3);
  butnext.setFont(f3);
  butlast.setFont(f3);

  add(lbtitle);
  add(lbclient_idno);
  add(tfclient_idno);
  add(lbclient_name);
  add(tfclient_name);
  add(lbaddress);
  add(tfaddress);
  add(lbcity);
  add(tfcity);
  add(lbgender);
  add(tfgender);
  add(lbbirth_date);
  add(tfbirth_date);
  add(lbmobile_no);
  add(tfmobile_no);
  add(lbemail_id);
  add(tfemail_id);
  add(butadd);
  add(butdelete);
  add(butmodify);
  add(butsave);
  add(butsearch);
  add(butclose);
  add(butfirst);
  add(butprevious);
  add(butnext);
  add(butlast);

  lbtitle.setBounds(275, 50, 700, 35);
  lbclient_idno.setBounds(100, 170, 200, 25);
  tfclient_idno.setBounds(350, 170, 150, 25);
  lbclient_name.setBounds(100, 210, 200, 25);
  tfclient_name.setBounds(350, 210, 500, 25);
  lbaddress.setBounds(100, 250, 200, 25);
  tfaddress.setBounds(350, 250, 800, 25);
  lbcity.setBounds(100, 290, 200, 25);
  tfcity.setBounds(350, 290, 350, 25);
  lbgender.setBounds(100, 330, 200, 25);
  tfgender.setBounds(350, 330, 150, 25);
  lbbirth_date.setBounds(100, 370, 200, 25);
  tfbirth_date.setBounds(350, 370, 250, 25);
  lbmobile_no.setBounds(100, 410, 200, 25);
  tfmobile_no.setBounds(350, 410, 250, 25);
  lbemail_id.setBounds(100, 450, 200, 25);
  tfemail_id.setBounds(350, 450, 500, 25);
  butadd.setBounds(125, 570, 175, 30);
  butdelete.setBounds(325, 570, 175, 30);
  butmodify.setBounds(525, 570, 175, 30);
  butsave.setBounds(725, 570, 175, 30);
  butsearch.setBounds(925, 570, 175, 30);
  butfirst.setBounds(125, 620, 175, 30);
  butnext.setBounds(325, 620, 175, 30);
  butprevious.setBounds(525, 620, 175, 30);
  butlast.setBounds(725, 620, 175, 30);
  butclose.setBounds(925, 620, 175, 30);
  
  tfclient_idno.setEditable(false); 
  tfclient_name.setEditable(false); 
  tfaddress.setEditable(false); 
  tfcity.setEditable(false); 
  tfgender.setEditable(false); 
  tfbirth_date.setEditable(false); 
  tfmobile_no.setEditable(false); 
  tfemail_id.setEditable(false); 

   try
   {
     Class.forName("com.mysql.cj.jdbc.Driver");
     con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
     //JOptionPane.showMessageDialog(this,"Connection made successfully");
    st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery("select * from Clients_Master order by client_idno");
    Statement st1=con.createStatement();
    ResultSet rs1=st1.executeQuery("select count(*) from Clients_Master");
    rs1.next();
    count=rs1.getInt(1);
    if(count>=1)
    {
      rs.first();
      view_clients();
    }
    buttons_enable_disable();
   }
  catch(ClassNotFoundException e1)
  {
    JOptionPane.showMessageDialog(this,"Problems occured when loads,registers the drivers");
  }
  catch(SQLException e2)
  {
  JOptionPane.showMessageDialog(this,"Problems occured during eshtablishing the connection between Java and Oracle");
  }
  tfclient_idno.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfclient_idno.getText().length()>=4)
                ke.consume();
             if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
                return;
             else
                ke.consume();
           }
        }
   );
   tfclient_name.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfclient_name.getText().length()>=30)
                ke.consume();
           }
        }
   );
   tfaddress.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)//space bar ascii value is 8
                return; 
             if(ke.getKeyChar()==44)
                return;       
             if(tfaddress.getText().length()>=75)
                ke.consume();
           }
        }
   );

   tfcity.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfcity.getText().length()>=15)
                ke.consume();
           }
        }
   );

   tfgender.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfgender.getText().length()>=1)
                ke.consume();
           }
        }
   );

   tfbirth_date.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfbirth_date.getText().length()>=10)
                ke.consume();
             }
        }
   );

   tfmobile_no.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfmobile_no.getText().length()>=10)
                ke.consume();
             if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
                return;
             else
                ke.consume();
           }
        }
   );

   tfemail_id.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfemail_id.getText().length()>=25)
                ke.consume();
           }
        }
   );

 }

   void view_clients()
   {
     try
     {
       int vclient_idno;
       String vclient_name, vaddress, vcity, vgender, vbirth_date, vemail_id;
       Long vmobile_no;
       vclient_idno=rs.getInt(1);
       vclient_name=rs.getString(2);
       vaddress=rs.getString(3);
       vcity=rs.getString(4);
       vgender=rs.getString(5);
       SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
       vbirth_date=sdf.format(rs.getDate(6));
       vmobile_no=rs.getLong(7);
       vemail_id=rs.getString(8);

       tfclient_idno.setText(String.valueOf(vclient_idno));
       tfclient_name.setText(vclient_name);
       tfaddress.setText(vaddress);
       tfcity.setText(vcity);
       tfgender.setText(vgender);
       tfbirth_date.setText(vbirth_date);
       tfmobile_no.setText(String.valueOf(vmobile_no));
       tfemail_id.setText(vemail_id);
       }
     catch(SQLException e3)
     {
      JOptionPane.showMessageDialog(this,"Problems occured during viewing the Client's Data");
     }    
    
   }
   void buttons_enable_disable()
   {
     try
     {
      if(count==0)
      {
        butadd.setEnabled(true);
        butdelete.setEnabled(false);
        butmodify.setEnabled(false);
        butsave.setEnabled(false);
        butsearch.setEnabled(false);
        butfirst.setEnabled(false);
        butnext.setEnabled(false);
        butprevious.setEnabled(false);
        butlast.setEnabled(false);
      }
      else if(count==1)
      {
        butadd.setEnabled(true);
        butdelete.setEnabled(true);
        butmodify.setEnabled(true);
        butsave.setEnabled(true);
        butsearch.setEnabled(false);
        butfirst.setEnabled(false);
        butnext.setEnabled(false);
        butprevious.setEnabled(false);
        butlast.setEnabled(false);        
      }
     else
     {
        butadd.setEnabled(true);
        butdelete.setEnabled(true);
        butmodify.setEnabled(true);
        butsave.setEnabled(true);
        butsearch.setEnabled(true);
        if(rs.isFirst())
       {
        butfirst.setEnabled(false);
        butnext.setEnabled(true);
        butprevious.setEnabled(false);
        butlast.setEnabled(true);        
       }
       else if(rs.isLast())
       {
        butfirst.setEnabled(true);
        butnext.setEnabled(false);
        butprevious.setEnabled(true);
        butlast.setEnabled(false);        
       }
       else
       {
        butfirst.setEnabled(true);
        butnext.setEnabled(true);
        butprevious.setEnabled(true);
        butlast.setEnabled(true);        
       }       
     }
}
      catch(SQLException e14)
      {
        JOptionPane.showMessageDialog(this,"Problems occured during Buttons Enable Disable");     
      }
   }
   public void actionPerformed(ActionEvent ae)
   {      
     if(ae.getSource()==butadd)
     {
      tfclient_idno.setEditable(true);
      tfclient_name.setEditable(true);
      tfaddress.setEditable(true);
      tfcity.setEditable(true);
      tfgender.setEditable(true);
      tfbirth_date.setEditable(true);
      tfmobile_no.setEditable(true);
      tfemail_id.setEditable(true);
      
      tfclient_idno.setText("");
      tfclient_name.setText("");
      tfaddress.setText("");
      tfcity.setText("");
      tfgender.setText("");
      tfbirth_date.setText("");
      tfmobile_no.setText("");
      tfemail_id.setText("");

      try
      {
        Statement st2=con.createStatement();
        ResultSet rs2=st2.executeQuery("select max(client_idno) from Clients_Master");
        rs2.next();
        int x=rs2.getInt(1)+1;
        tfclient_idno.setText(String.valueOf(x));
      }
      catch(SQLException e4)
      {
        JOptionPane.showMessageDialog(this,"Problems occured during generating next Client ID");     
      }
      tfclient_idno.setEditable(false);
      tfclient_name.requestFocus(); 
      Date dt=new Date();
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
      String current_date=sdf.format(dt);
      tfbirth_date.setText(current_date);
      check='A';
      butsave.setEnabled(true); 
      butadd.setEnabled(false);    
     }
     else if(ae.getSource()==butdelete)
     {
        int ans;
        ans=JOptionPane.showConfirmDialog(this,"Are you sure to delete this client's record?","DeleteConfirmation",JOptionPane.YES_NO_OPTION);
        if(ans==JOptionPane.YES_OPTION)
        {
          check='D';
         JOptionPane.showMessageDialog(this,"Please Click on SAVE CLIENT DATA Button to delete this record permanantly");     
        }
     }
     else if(ae.getSource()==butmodify)
     {
      tfclient_name.setEditable(true);
      tfaddress.setEditable(true);
      tfcity.setEditable(true);
      tfgender.setEditable(true);
      tfbirth_date.setEditable(true);
      tfmobile_no.setEditable(true);
      tfemail_id.setEditable(true);
      tfclient_name.requestFocus();
      check='M';
     }  
     else if(ae.getSource()==butsave)
     {
       if(tfclient_idno.getText().length()==0)
       {
         tfclient_idno.requestFocus();
         JOptionPane.showMessageDialog(this,"Client ID Number is empty, please enter suitable Client ID No.");            
       } 
      else if(tfclient_name.getText().length()==0)
      {
       tfclient_name.requestFocus();
       JOptionPane.showMessageDialog(this,"Client Name is empty, please enter proper name");            
      }
      else if(tfaddress.getText().length()==0)
      {
        tfaddress.requestFocus();
       JOptionPane.showMessageDialog(this,"Client's address is empty, please enter the suitable address");                  
      }
      else if(tfcity.getText().length()==0)
      {
       tfcity.requestFocus();
       JOptionPane.showMessageDialog(this,"Client's City Name is empty, please enter proper City Name");            
      }
      else if(tfgender.getText().length()==0)
      {
       tfgender.requestFocus();
       JOptionPane.showMessageDialog(this,"Client's Gender is empty, please enter suitable gender of the client.");            
      }
      else if(tfbirth_date.getText().length()==0)
      {
       tfbirth_date.requestFocus();
       JOptionPane.showMessageDialog(this,"Client's Birthdate is empty, please enter the birth date.");            
      }
      else if(tfmobile_no.getText().length()==0)
      {
       tfmobile_no.requestFocus();
       JOptionPane.showMessageDialog(this,"Mobile No. is empty, please enter the mobile number");            
      }
      else if(tfemail_id.getText().length()==0)
      {
       tfemail_id.requestFocus();
       JOptionPane.showMessageDialog(this,"Email ID is empty, please enter suitable email id");            
      }
      else
      {
       if(check=='A')
       {
         try
         {
         PreparedStatement ps2=con.prepareStatement("insert into Clients_Master values(?,?,?,?,?,?,?,?)");
         ps2.setInt(1,Integer.parseInt(tfclient_idno.getText()));
         ps2.setString(2,tfclient_name.getText());
         ps2.setString(3,tfaddress.getText());
         ps2.setString(4,tfcity.getText());
         ps2.setString(5,tfgender.getText());
         SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
         Date bdate1=sdf1.parse(tfbirth_date.getText());
         java.sql.Date mydate1=new java.sql.Date(bdate1.getTime());
         ps2.setDate(6,mydate1);
         ps2.setLong(7,Long.parseLong(tfmobile_no.getText()));
         ps2.setString(8,tfemail_id.getText());
         ps2.executeUpdate();
        JOptionPane.showMessageDialog(this,"Client's Data/Record is Added, Saved Successfully in the table");
         count++;
         rs=st.executeQuery("select * from Clients_Master order by client_idno");
         rs.last();                 
         }
        catch(SQLException e5)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the inserted record of Client");     
       }
        catch(ParseException e19)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during date conversion when saving the inserted record of Client");     
       }
      tfclient_idno.setEditable(false);
      tfclient_name.setEditable(false);
      tfaddress.setEditable(false);
      tfcity.setEditable(false);
      tfgender.setEditable(false);
      tfbirth_date.setEditable(false);
      tfmobile_no.setEditable(false);
      tfemail_id.setEditable(false);
     }
     else if(check=='D')
     {
         try
         {
         PreparedStatement ps3=con.prepareStatement("delete from Clients_Master where client_idno=?");
         ps3.setInt(1,Integer.parseInt(tfclient_idno.getText()));
         ps3.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record is Deleted Successfully from the table");
        count--;
         rs=st.executeQuery("select * from Clients_Master order by client_idno");
         if(count==0)
         {
           tfclient_idno.setText("");
           tfclient_name.setText("");
           tfaddress.setText("");
           tfcity.setText("");
           tfgender.setText("");
           tfbirth_date.setText("");
           tfmobile_no.setText("");
           tfemail_id.setText("");
         }
         else
         {
            rs.first();
            view_clients();
         }                 
        }
        catch(SQLException e6)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the deleted record of Client");     
       }
             
     }
     else if(check=='M')
     {
         try
         {
         PreparedStatement ps4=con.prepareStatement("update Clients_Master set client_name=?, address=?, city=?, gender=?,birth_date=?, mobile_no=?,email_id=? where client_idno=?");
         ps4.setString(1,tfclient_name.getText());
         ps4.setString(2,tfaddress.getText());
         ps4.setString(3,tfcity.getText());
         ps4.setString(4,tfgender.getText());
         SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
         Date bdate2=sdf2.parse(tfbirth_date.getText());
         java.sql.Date mydate2=new java.sql.Date(bdate2.getTime());
         ps4.setDate(5,mydate2);
         ps4.setLong(6,Long.parseLong(tfmobile_no.getText()));
         ps4.setString(7,tfemail_id.getText());
         ps4.setInt(8,Integer.parseInt(tfclient_idno.getText()));
         ps4.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record is Modified Successfully in the table");
         rs=st.executeQuery("select * from Clients_Master order by client_idno");                 
         int idno=Integer.parseInt(tfclient_idno.getText());
         while(rs.next())
         {
            if(rs.getInt(1)==idno)
                break;
         }                 
        }
        catch(SQLException e7)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the modified record of Client");     
       }
        catch(ParseException e18)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during date conversion when saving the modified record of Client");     
       }
      tfclient_name.setEditable(false);
      tfaddress.setEditable(false);
      tfcity.setEditable(false);
      tfgender.setEditable(false);
      tfbirth_date.setEditable(false);
      tfmobile_no.setEditable(false);
      tfemail_id.setEditable(false);
     }
     else
     {
        JOptionPane.showMessageDialog(this,"No action taken");     
     }
        check='X';
        buttons_enable_disable();
   }
     }
     else if(ae.getSource()==butsearch)
     {
       int cid;
       cid=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Client ID Number, whose record you want to search"));
   try
   {
     int chk=0;
     rs.beforeFirst();
     while(rs.next())
     {
       if(rs.getInt(1)==cid)
       {
          chk=1;
          break;
       }       
     }
    if(chk==1)
    {
     view_clients();
      buttons_enable_disable();  
     JOptionPane.showMessageDialog(this,"Client Found, its record is viewed on screen.");  
    }
    else
    {
      tfclient_idno.setText("");
      tfclient_name.setText("");
      tfaddress.setText("");
      tfcity.setText("");
      tfgender.setText("");
      tfbirth_date.setText("");
      tfmobile_no.setText("");
      tfemail_id.setText("");
      JOptionPane.showMessageDialog(this,"Invalid Client ID Number, such client does not exist");    
    }
   }
   catch(SQLException e8)
   {
    JOptionPane.showMessageDialog(this,"Problems occured during searching the record.");
   }    
    
     }
     else if(ae.getSource()==butfirst)
     {
       try
       {
         rs.first();
         view_clients();
        buttons_enable_disable();
       }
       catch(SQLException e9)
      {
        JOptionPane.showMessageDialog(this,"Problems occured when viewing first record");
      }    
   
    }
     else if(ae.getSource()==butnext)
     {
       try
       {
        if(!rs.isLast())
        {
          rs.next();
          view_clients();
        buttons_enable_disable();
        }
       }
       catch(SQLException e10)
      {
        JOptionPane.showMessageDialog(this,"Problems occured when viewing next record");
      }    

     }
     else if(ae.getSource()==butprevious)
     {
       try
       {
         if(!rs.isFirst())
         {
           rs.previous();
           view_clients();
        buttons_enable_disable();
         }
       }
       catch(SQLException e11)
      {
        JOptionPane.showMessageDialog(this,"Problems occured when viewing previous record");
      }    

     }
     else if(ae.getSource()==butlast)
     {
       try
       {
         rs.last();
         view_clients();
        buttons_enable_disable();
       }
       catch(SQLException e12)
      {
        JOptionPane.showMessageDialog(this,"Problems occured when viewing last record");
      }    

     }
     else if(ae.getSource()==butclose)
     {
        try
        {
          con.close();
        } 
        catch(SQLException e13)
       {
         JOptionPane.showMessageDialog(this,"Problems occured during closing the connection");
       }    
     dispose();
    }

   }
  public static void main(String args[])
  {
   new Clients_Master_Form();   
  }
} 

