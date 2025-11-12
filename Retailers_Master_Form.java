import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Retailers_Master_Form extends JFrame implements ActionListener
{
  JLabel lbtitle,lbretailer_id,lbretailer_firmname,lbaddress,lbcity,lbowner_name,lbmobile_no,lbemail_id;
  JTextField tfretailer_id,tfretailer_firmname,tfaddress,tfcity,tfowner_name,tfmobile_no,tfemail_id;
  JButton butadd,butdelete,butmodify,butsave,butsearch,butfirst,butprevious,butnext,butlast,butclose;
  Connection con=null;
  Statement st=null;
  ResultSet rs=null;
  char check='X';
  int count=0;
  Retailers_Master_Form()
  {
    setSize(1380,730);
    setVisible(true);
    setLayout(null);
    setTitle("Credit Holder Retailers Application");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL BLACK",Font.PLAIN,30);
   Font f2=new Font("ARIAL",Font.BOLD,22);
   Font f3=new Font("TIMES NEW ROMAN",Font.BOLD,16);

   lbtitle=new JLabel("Creditor RETAILERS Master Data Manipulation Form");
   lbretailer_id=new JLabel("Retailer's ID No.");
   lbretailer_firmname=new JLabel("Firmname");
   lbaddress=new JLabel("Address");
   lbcity=new JLabel("City");
   lbowner_name=new JLabel("Firm Owner Name");
   lbmobile_no=new JLabel("Mobile No.");
   lbemail_id=new JLabel("Email ID");

  tfretailer_id=new JTextField();
  tfretailer_firmname=new JTextField();
  tfaddress=new JTextField();
  tfcity=new JTextField();
  tfowner_name=new JTextField();
  tfmobile_no=new JTextField();
  tfemail_id=new JTextField();

  butadd=new JButton("Add New Retailer");
  butdelete=new JButton("Delete the Record");
  butmodify=new JButton("Modify the Data");
  butsave=new JButton("Save Retailer Data");
  butsearch=new JButton("Search the Retailer");
  butclose=new JButton("Close the Form");
  butfirst=new JButton("First Retailer");
  butnext=new JButton("Next Retailer");
  butprevious=new JButton("Previous Retailer");
  butlast=new JButton("Last Retailer");
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
  lbretailer_id.setFont(f2);
  lbretailer_firmname.setFont(f2);
  lbaddress.setFont(f2);
  lbcity.setFont(f2);
  lbowner_name.setFont(f2);
  lbmobile_no.setFont(f2);
  lbemail_id.setFont(f2);
  tfretailer_id.setFont(f3);
  tfretailer_firmname.setFont(f3);
  tfaddress.setFont(f3);
  tfcity.setFont(f3);
  tfowner_name.setFont(f3);
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
  add(lbretailer_id);
  add(tfretailer_id);
  add(lbretailer_firmname);
  add(tfretailer_firmname);
  add(lbaddress);
  add(tfaddress);
  add(lbcity);
  add(tfcity);
  add(lbowner_name);
  add(tfowner_name);
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

  lbtitle.setBounds(200, 50, 900, 35);
  lbretailer_id.setBounds(100, 200, 200, 25);
  tfretailer_id.setBounds(350, 200, 150, 25);
  lbretailer_firmname.setBounds(100, 240, 200, 25);
  tfretailer_firmname.setBounds(350, 240, 500, 25);
  lbaddress.setBounds(100, 280, 200, 25);
  tfaddress.setBounds(350, 280, 800, 25);
  lbcity.setBounds(100, 320, 200, 25);
  tfcity.setBounds(350, 320, 350, 25);
  lbowner_name.setBounds(100, 360, 200, 25);
  tfowner_name.setBounds(350, 360, 500, 25);
  lbmobile_no.setBounds(100, 400, 200, 25);
  tfmobile_no.setBounds(350, 400, 350, 25);
  lbemail_id.setBounds(100, 440, 200, 25);
  tfemail_id.setBounds(350, 440, 500, 25);
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
  
  tfretailer_id.setEditable(false); 
  tfretailer_firmname.setEditable(false); 
  tfaddress.setEditable(false); 
  tfcity.setEditable(false); 
  tfowner_name.setEditable(false); 
  tfmobile_no.setEditable(false); 
  tfemail_id.setEditable(false); 

   try
   {
     Class.forName("com.mysql.cj.jdbc.Driver");
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
    //JOptionPane.showMessageDialog(this,"Connection made successfully");
    st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery("select * from Retailers_Master order by retailer_idno");
    Statement st1=con.createStatement();
    ResultSet rs1=st1.executeQuery("select count(*) from Retailers_Master");
    rs1.next();
    count=rs1.getInt(1);
    if(count>=1)
    {
      rs.first();
      view_retailer();
    }
    buttons_enable_disable();
   }
  catch(ClassNotFoundException e1)
  {
    JOptionPane.showMessageDialog(this,"Problems occured when loads,registers the drivers");
  }
  catch(SQLException e2)
  {
  JOptionPane.showMessageDialog(this,"Problems occured during eshtablishing the connection between Java and MySQL");
  }
  tfretailer_id.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfretailer_id.getText().length()>=4)
                ke.consume();
             if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
                return;
             else
                ke.consume();
           }
        }
   );
   tfretailer_firmname.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfretailer_firmname.getText().length()>=30)
                ke.consume();
           }
        }
   );
   tfaddress.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
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

   tfowner_name.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfowner_name.getText().length()>=25)
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

   void view_retailer()
   {
     try
     {
       int vretailer_id;
       String vretailer_firmname, vaddress, vcity, vowner_name, vemail_id;
       Long vmobile_no;
       vretailer_id=rs.getInt(1);
       vretailer_firmname=rs.getString(2);
       vaddress=rs.getString(3);
       vcity=rs.getString(4);
       vowner_name=rs.getString(5);
       vmobile_no=rs.getLong(6);
       vemail_id=rs.getString(7);

       tfretailer_id.setText(String.valueOf(vretailer_id));
       tfretailer_firmname.setText(vretailer_firmname);
       tfaddress.setText(vaddress);
       tfcity.setText(vcity);
       tfowner_name.setText(vowner_name);
       tfmobile_no.setText(String.valueOf(vmobile_no));
       tfemail_id.setText(vemail_id);
       }
     catch(SQLException e3)
     {
      JOptionPane.showMessageDialog(this,"Problems occured during viewing the Retailers Data");
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
      tfretailer_id.setEditable(true);
      tfretailer_firmname.setEditable(true);
      tfaddress.setEditable(true);
      tfcity.setEditable(true);
      tfowner_name.setEditable(true);
      tfmobile_no.setEditable(true);
      tfemail_id.setEditable(true);

      tfretailer_id.setText("");
      tfretailer_firmname.setText("");
      tfaddress.setText("");
      tfcity.setText("");
      tfowner_name.setText("");
      tfmobile_no.setText("");
      tfemail_id.setText("");

      try
      {
        Statement st2=con.createStatement();
        ResultSet rs2=st2.executeQuery("select max(retailer_idno) from Retailers_Master");
        rs2.next();
        int x=rs2.getInt(1)+1;
        tfretailer_id.setText(String.valueOf(x));
      }
      catch(SQLException e4)
      {
        JOptionPane.showMessageDialog(this,"Problems occured during generating next Retailer ID");     
      }
      tfretailer_id.setEditable(false);
      tfretailer_firmname.requestFocus(); 
      check='A';
      butsave.setEnabled(true);     
     }
     else if(ae.getSource()==butdelete)
     {
        int ans;
        ans=JOptionPane.showConfirmDialog(this,"Are you sure to delete this retailer's record?","DeleteConfirmation",JOptionPane.YES_NO_OPTION);
        if(ans==JOptionPane.YES_OPTION)
        {
          check='D';
         JOptionPane.showMessageDialog(this,"Please Click on SAVE RETAILERS DATA Button to delete this record permanantly");     
        }
     }
     else if(ae.getSource()==butmodify)
     {
      tfretailer_firmname.setEditable(true);
      tfaddress.setEditable(true);
      tfcity.setEditable(true);
      tfowner_name.setEditable(true);
      tfmobile_no.setEditable(true);
      tfemail_id.setEditable(true);
      tfretailer_firmname.requestFocus();
      check='M';
     }  
     else if(ae.getSource()==butsave)
     {
       if(tfretailer_id.getText().length()==0)
       {
         tfretailer_id.requestFocus();
         JOptionPane.showMessageDialog(this,"Retailer ID Number is empty, please enter suitable Retailer ID No.");            
       } 
      else if(tfretailer_firmname.getText().length()==0)
      {
       tfretailer_firmname.requestFocus();
       JOptionPane.showMessageDialog(this,"Retailer Firmname is empty, please enter proper firmname");            
      }
      else if(tfaddress.getText().length()==0)
      {
        tfaddress.requestFocus();
       JOptionPane.showMessageDialog(this,"Retailer address is empty, please enter the suitable address");                  
      }
      else if(tfcity.getText().length()==0)
      {
       tfcity.requestFocus();
       JOptionPane.showMessageDialog(this,"Retailer City Name is empty, please enter proper City Name");            
      }
      else if(tfowner_name.getText().length()==0)
      {
       tfowner_name.requestFocus();
       JOptionPane.showMessageDialog(this,"Owner Name is empty, please enter the name of owner");            
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
         PreparedStatement ps2=con.prepareStatement("insert into Retailers_Master values(?,?,?,?,?,?,?)");
         ps2.setInt(1,Integer.parseInt(tfretailer_id.getText()));
         ps2.setString(2,tfretailer_firmname.getText());
         ps2.setString(3,tfaddress.getText());
         ps2.setString(4,tfcity.getText());
         ps2.setString(5,tfowner_name.getText());
         ps2.setLong(6,Long.parseLong(tfmobile_no.getText()));
         ps2.setString(7,tfemail_id.getText());
         ps2.executeUpdate();
        JOptionPane.showMessageDialog(this,"Retailer's Data/Record is Added, Saved Successfully in the table");
         PreparedStatement pstmt=con.prepareStatement("insert into Retailers_Ledger values(?,0)");
         pstmt.setInt(1,Integer.parseInt(tfretailer_id.getText()));
         pstmt.executeUpdate();
         count++;
         rs=st.executeQuery("select * from Retailers_Master order by retailer_idno");
         rs.last();                 
         }
        catch(SQLException e5)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the inserted record of Retailers");     
       }
      tfretailer_id.setEditable(false);
      tfretailer_firmname.setEditable(false);
      tfaddress.setEditable(false);
      tfcity.setEditable(false);
      tfowner_name.setEditable(false);
      tfmobile_no.setEditable(false);
      tfemail_id.setEditable(false);
     }
     else if(check=='D')
     {
         try
         {
         PreparedStatement ps3=con.prepareStatement("delete from Retailers_Master where retailer_idno=?");
         ps3.setInt(1,Integer.parseInt(tfretailer_id.getText()));
         ps3.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record is Deleted Successfully from the table");
        count--;
         rs=st.executeQuery("select * from Retailers_Master order by retailer_idno");
         if(count==0)
         {
           tfretailer_id.setText("");
           tfretailer_firmname.setText("");
           tfaddress.setText("");
           tfcity.setText("");
           tfowner_name.setText("");
           tfmobile_no.setText("");
           tfemail_id.setText("");
         }
         else
         {
            rs.first();
            view_retailer();
         }                 
        }
        catch(SQLException e6)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the deleted record of Retailers");     
       }
             
     }
     else if(check=='M')
     {
         try
         {
         PreparedStatement ps4=con.prepareStatement("update Retailers_Master set retailer_firmname=?, address=?, city=?, owner_name=?, mobile_no=?,email_id=? where retailer_idno=?");
         ps4.setString(1,tfretailer_firmname.getText());
         ps4.setString(2,tfaddress.getText());
         ps4.setString(3,tfcity.getText());
         ps4.setString(4,tfowner_name.getText());
         ps4.setLong(5,Long.parseLong(tfmobile_no.getText()));
         ps4.setString(6,tfemail_id.getText());
         ps4.setInt(7,Integer.parseInt(tfretailer_id.getText()));
         ps4.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record is Modified Successfully in the table");
         rs=st.executeQuery("select * from Retailers_Master order by retailer_idno");                 
         int idno=Integer.parseInt(tfretailer_id.getText());
         while(rs.next())
         {
            if(rs.getInt(1)==idno)
                break;
         }                 
        }
        catch(SQLException e7)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the modified record of Retailer");     
       }
      tfretailer_firmname.setEditable(false);
      tfaddress.setEditable(false);
      tfcity.setEditable(false);
      tfowner_name.setEditable(false);
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
       cid=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Retailer ID Number, whose record you want to search"));
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
     view_retailer();
      buttons_enable_disable();  
     JOptionPane.showMessageDialog(this,"Retailer Found, its record is viewed on screen.");  
    }
    else
    {
      tfretailer_id.setText("");
      tfretailer_firmname.setText("");
      tfaddress.setText("");
      tfcity.setText("");
      tfowner_name.setText("");
      tfmobile_no.setText("");
      tfemail_id.setText("");
      JOptionPane.showMessageDialog(this,"Invalid Retailer ID Number, such retailer does not exist");    
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
         view_retailer();
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
          view_retailer();
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
           view_retailer();
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
         view_retailer();
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
   new Retailers_Master_Form();   
  }
}