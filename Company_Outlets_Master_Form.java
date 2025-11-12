import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Company_Outlets_Master_Form extends JFrame implements ActionListener
{
  JLabel lbtitle,lboutlet_id,lboutlet_firmname,lbaddress,lbcity,lbperson1_name,lbperson1_mobileno,lbperson2_name,lbperson2_mobileno,lbemail_id;
  JTextField tfoutlet_id,tfoutlet_firmname,tfaddress,tfcity,tfperson1_name,tfperson1_mobileno,tfperson2_name,tfperson2_mobileno,tfemail_id;
  JButton butadd,butdelete,butmodify,butsave,butsearch,butfirst,butprevious,butnext,butlast,butclose;
  Connection con=null;
  Statement st=null;
  ResultSet rs=null;
  char check='X';
  int count=0;
  Company_Outlets_Master_Form()
  {
    setSize(1250,700);
    setVisible(true);
    setLayout(null);
    setTitle("Company Outlets Application");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL BLACK",Font.PLAIN,30);
   Font f2=new Font("ARIAL",Font.BOLD,22);
   Font f3=new Font("TIMES NEW ROMAN",Font.BOLD,16);

   lbtitle=new JLabel("COMPANY OUTLETS master data manipulation form");
   lboutlet_id=new JLabel("Company Outlet ID No.");
   lboutlet_firmname=new JLabel("Outlet FirmName");
   lbaddress=new JLabel("Address");
   lbcity=new JLabel("City");
   lbperson1_name=new JLabel("Contact Person-1 Name");
   lbperson1_mobileno=new JLabel("Person-1 Mobile No.");
   lbperson2_name=new JLabel("Contact Person-2 Name");
   lbperson2_mobileno=new JLabel("Person-2 Mobile No.");
   lbemail_id=new JLabel("Company Outlet Email ID");

  tfoutlet_id=new JTextField();
  tfoutlet_firmname=new JTextField();
  tfaddress=new JTextField();
  tfcity=new JTextField();
  tfperson1_name=new JTextField();
  tfperson1_mobileno=new JTextField();
  tfperson2_name=new JTextField();
  tfperson2_mobileno=new JTextField();
  tfemail_id=new JTextField();

  butadd=new JButton("Add New Outlet");
  butdelete=new JButton("Delete the Outlet");
  butmodify=new JButton("Modify Outlet Data");
  butsave=new JButton("Save Outlet Data");
  butsearch=new JButton("Search the Outlet");
  butclose=new JButton("Close the Form");
  butfirst=new JButton("First Outlet");
  butnext=new JButton("Next Outlet");
  butprevious=new JButton("Previous Outlet");
  butlast=new JButton("Last Outlet");
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
  lboutlet_id.setFont(f2);
  lboutlet_firmname.setFont(f2);
  lbaddress.setFont(f2);
  lbcity.setFont(f2);
  lbperson1_name.setFont(f2);
  lbperson1_mobileno.setFont(f2);
  lbperson2_name.setFont(f2);
  lbperson2_mobileno.setFont(f2);
  lbemail_id.setFont(f2);
  tfoutlet_id.setFont(f3);
  tfoutlet_firmname.setFont(f3);
  tfaddress.setFont(f3);
  tfcity.setFont(f3);
  tfperson1_name.setFont(f3);
  tfperson1_mobileno.setFont(f3);
  tfperson2_name.setFont(f3);
  tfperson2_mobileno.setFont(f3);
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
  add(lboutlet_id);
  add(tfoutlet_id);
  add(lboutlet_firmname);
  add(tfoutlet_firmname);
  add(lbaddress);
  add(tfaddress);
  add(lbcity);
  add(tfcity);
  add(lbperson1_name);
  add(tfperson1_name);
  add(lbperson1_mobileno);
  add(tfperson1_mobileno);
  add(lbperson2_name);
  add(tfperson2_name);
  add(lbperson2_mobileno);
  add(tfperson2_mobileno);
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

  lbtitle.setBounds(175,40,900,35);
  lboutlet_id.setBounds(100,110,300,25);
  tfoutlet_id.setBounds(450,110,150,25);
  lboutlet_firmname.setBounds(100,150,300,25);
  tfoutlet_firmname.setBounds(450,150,500,25);
  lbaddress.setBounds(100,190,300,25);
  tfaddress.setBounds(450,190,500,25);
  lbcity.setBounds(100,230,300,25);
  tfcity.setBounds(450,230,450,25);
  lbperson1_name.setBounds(100,270,300,25);
  tfperson1_name.setBounds(450,270,750,25);
  lbperson1_mobileno.setBounds(100,310,300,25);
  tfperson1_mobileno.setBounds(450,310,500,25);
  lbperson2_name.setBounds(100,350,300,25);
  tfperson2_name.setBounds(450,350,250,25);
  lbperson2_mobileno.setBounds(100,390,300,25);
  tfperson2_mobileno.setBounds(450,390,750,25);
  lbemail_id.setBounds(100,430,300,25);
  tfemail_id.setBounds(450,430,750,25);
  butadd.setBounds(125,540,175,30);
  butdelete.setBounds(325,540,175,30);
  butmodify.setBounds(525,540,175,30);
  butsave.setBounds(725,540,175,30);
  butsearch.setBounds(925,540,175,30);
  butfirst.setBounds(125,580,175,30);
  butnext.setBounds(325,580,175,30);
  butprevious.setBounds(525,580,175,30);
  butlast.setBounds(725,580,175,30);
  butclose.setBounds(925,580,175,30);
  
  tfoutlet_id.setEditable(false); 
  tfoutlet_firmname.setEditable(false); 
  tfaddress.setEditable(false); 
  tfcity.setEditable(false); 
  tfperson1_name.setEditable(false); 
  tfperson1_mobileno.setEditable(false); 
  tfperson2_name.setEditable(false); 
  tfperson2_mobileno.setEditable(false); 
  tfemail_id.setEditable(false); 

   try
   {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
    //JOptionPane.showMessageDialog(this,"Connection made successfully");
    st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery("select * from Company_Outlets_Master order by outlet_idno");
    Statement st1=con.createStatement();
    ResultSet rs1=st1.executeQuery("select count(*) from Company_Outlets_Master");
    rs1.next();
    count=rs1.getInt(1);
    if(count>=1)
    {
      rs.first();
      view_company_outlet();
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
  tfoutlet_id.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfoutlet_id.getText().length()>=4)
                ke.consume();
             if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
                return;
             else
                ke.consume();
           }
        }
   );
   tfoutlet_firmname.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfoutlet_firmname.getText().length()>=30)
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

   tfperson1_name.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfperson1_name.getText().length()>=25)
                ke.consume();
           }
        }
   );

   tfperson1_mobileno.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfperson1_mobileno.getText().length()>=10)
                ke.consume();
             if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
                return;
             else
                ke.consume();
           }
        }
   );

   tfperson2_name.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfperson2_name.getText().length()>=25)
                ke.consume();
           }
        }
   );

   tfperson2_mobileno.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfperson2_mobileno.getText().length()>=10)
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

   void view_company_outlet()
   {
     try
     {
       int voutlet_id;
       String voutlet_firmname, vaddress, vcity, vperson1_name, vperson2_name, vemail_id;
       Long vperson1_mobileno,vperson2_mobileno;
       voutlet_id=rs.getInt(1);
       voutlet_firmname=rs.getString(2);
       vaddress=rs.getString(3);
       vcity=rs.getString(4);
       vperson1_name=rs.getString(5);
       vperson1_mobileno=rs.getLong(6);
       vperson2_name=rs.getString(7);
       vperson2_mobileno=rs.getLong(8);
       vemail_id=rs.getString(9);

       tfoutlet_id.setText(String.valueOf(voutlet_id));
       tfoutlet_firmname.setText(voutlet_firmname);
       tfaddress.setText(vaddress);
       tfcity.setText(vcity);
       tfperson1_name.setText(vperson1_name);
       tfperson1_mobileno.setText(String.valueOf(vperson1_mobileno));
       tfperson2_name.setText(vperson2_name);
       tfperson2_mobileno.setText(String.valueOf(vperson2_mobileno));
       tfemail_id.setText(vemail_id);
       }
     catch(SQLException e3)
     {
      JOptionPane.showMessageDialog(this,"Problems occured during viewing the Company Outlet");
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
      tfoutlet_id.setEditable(true);
      tfoutlet_firmname.setEditable(true);
      tfaddress.setEditable(true);
      tfcity.setEditable(true);
      tfperson1_name.setEditable(true);
      tfperson1_mobileno.setEditable(true);
      tfperson2_name.setEditable(true);
      tfperson2_mobileno.setEditable(true);
      tfemail_id.setEditable(true);

      tfoutlet_id.setText("");
      tfoutlet_firmname.setText("");
      tfaddress.setText("");
      tfcity.setText("");
      tfperson1_name.setText("");
      tfperson1_mobileno.setText("");
      tfperson2_name.setText("");
      tfperson2_mobileno.setText("");
      tfemail_id.setText("");

      try
      {
        Statement st2=con.createStatement();
        ResultSet rs2=st2.executeQuery("select max(outlet_idno) from Company_Outlets_Master");
        rs2.next();
        int x=rs2.getInt(1)+1;
        tfoutlet_id.setText(String.valueOf(x));
      }
      catch(SQLException e4)
      {
        JOptionPane.showMessageDialog(this,"Problems occured during generating next Outlet ID");     
      }
      tfoutlet_id.setEditable(false);
      tfoutlet_firmname.requestFocus(); 
      check='A';
      butsave.setEnabled(true);     
     }
     else if(ae.getSource()==butdelete)
     {
        int ans;
        ans=JOptionPane.showConfirmDialog(this,"Are you sure to delete this outletrecord?","DeleteConfirmation",JOptionPane.YES_NO_OPTION);
        if(ans==JOptionPane.YES_OPTION)
        {
          check='D';
         JOptionPane.showMessageDialog(this,"Please Click on SAVE OUTLET DATA Button to delete this record permanantly");     
        }
     }
     else if(ae.getSource()==butmodify)
     {
      tfoutlet_firmname.setEditable(true);
      tfaddress.setEditable(true);
      tfcity.setEditable(true);
      tfperson1_name.setEditable(true);
      tfperson1_mobileno.setEditable(true);
      tfperson2_name.setEditable(true);
      tfperson2_mobileno.setEditable(true);
      tfemail_id.setEditable(true);
      tfoutlet_firmname.requestFocus();
      check='M';
     }  
     else if(ae.getSource()==butsave)
     {
       if(tfoutlet_id.getText().length()==0)
       {
         tfoutlet_id.requestFocus();
         JOptionPane.showMessageDialog(this,"Outlet ID Number is empty, please enter suitable Outlet ID No.");            
       } 
      else if(tfoutlet_firmname.getText().length()==0)
      {
       tfoutlet_firmname.requestFocus();
       JOptionPane.showMessageDialog(this,"Outlet Firmname is empty, please enter proper firmname");            
      }
      else if(tfaddress.getText().length()==0)
      {
        tfaddress.requestFocus();
       JOptionPane.showMessageDialog(this,"Outlet address is empty, please enter the suitable address");                  
      }
      else if(tfcity.getText().length()==0)
      {
       tfcity.requestFocus();
       JOptionPane.showMessageDialog(this,"Outlet City Name is empty, please enter proper City Name");            
      }
      else if(tfperson1_name.getText().length()==0)
      {
       tfperson1_name.requestFocus();
       JOptionPane.showMessageDialog(this,"First Person Name is empty, please enter the name of first contact person");            
      }
      else if(tfperson1_mobileno.getText().length()==0)
      {
       tfperson1_mobileno.requestFocus();
       JOptionPane.showMessageDialog(this,"First Person's Mobile No. is empty, please enter the mobile number");            
      }
      else if(tfperson2_name.getText().length()==0)
      {
       tfperson2_name.requestFocus();
       JOptionPane.showMessageDialog(this,"Second Person Name is empty, please enter proper name of second contact person");         
      }
      else if(tfperson2_mobileno.getText().length()==0)
      {
       tfperson2_mobileno.requestFocus();
       JOptionPane.showMessageDialog(this,"Second Person's Mobile No. is empty, please enter the mobile number");            
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
         PreparedStatement ps2=con.prepareStatement("insert into Company_Outlets_Master values(?,?,?,?,?,?,?,?,?)");
         ps2.setInt(1,Integer.parseInt(tfoutlet_id.getText()));
         ps2.setString(2,tfoutlet_firmname.getText());
         ps2.setString(3,tfaddress.getText());
         ps2.setString(4,tfcity.getText());
         ps2.setString(5,tfperson1_name.getText());
         ps2.setLong(6,Long.parseLong(tfperson1_mobileno.getText()));
         ps2.setString(7,tfperson2_name.getText());
         ps2.setLong(8,Long.parseLong(tfperson2_mobileno.getText()));
         ps2.setString(9,tfemail_id.getText());
         ps2.executeUpdate();
        JOptionPane.showMessageDialog(this,"Company Outlet Data/Record is Added, Saved Successfully in the table");
         count++;
         rs=st.executeQuery("select * from Company_Outlets_Master order by outlet_idno");
         rs.last();                 
         }
        catch(SQLException e5)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the inserted record of company outlet");     
       }
      tfoutlet_id.setEditable(false);
      tfoutlet_firmname.setEditable(false);
      tfaddress.setEditable(false);
      tfcity.setEditable(false);
      tfperson1_name.setEditable(false);
      tfperson1_mobileno.setEditable(false);
      tfperson2_name.setEditable(false);
      tfperson2_mobileno.setEditable(false);
      tfemail_id.setEditable(false);
     }
     else if(check=='D')
     {
         try
         {
         PreparedStatement ps3=con.prepareStatement("delete from Company_Outlets_Master where outlet_idno=?");
         ps3.setInt(1,Integer.parseInt(tfoutlet_id.getText()));
         ps3.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record is Deleted Successfully from the table");
        count--;
         rs=st.executeQuery("select * from Company_Outlets_Master order by outlet_idno");
         if(count==0)
         {
           tfoutlet_id.setText("");
           tfoutlet_firmname.setText("");
           tfaddress.setText("");
           tfcity.setText("");
           tfperson1_name.setText("");
           tfperson1_mobileno.setText("");
           tfperson2_name.setText("");
           tfperson2_mobileno.setText("");
           tfemail_id.setText("");
         }
         else
         {
            rs.first();
            view_company_outlet();
         }                 
        }
        catch(SQLException e6)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the deleted record of company outlet");     
       }
             
     }
     else if(check=='M')
     {
         try
         {
         PreparedStatement ps4=con.prepareStatement("update Company_Outlets_Master set outlet_firmname=?, address=?, city=?, person1_name=?, person1_mobileno=?, person2_name=?, person2_mobileno=?,outlet_email_id=? where outlet_idno=?");
         ps4.setString(1,tfoutlet_firmname.getText());
         ps4.setString(2,tfaddress.getText());
         ps4.setString(3,tfcity.getText());
         ps4.setString(4,tfperson1_name.getText());
         ps4.setLong(5,Long.parseLong(tfperson1_mobileno.getText()));
         ps4.setString(6,tfperson2_name.getText());
         ps4.setLong(7,Long.parseLong(tfperson2_mobileno.getText()));
         ps4.setString(8,tfemail_id.getText());
         ps4.setInt(9,Integer.parseInt(tfoutlet_id.getText()));
         ps4.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record is Modified Successfully in the table");
         rs=st.executeQuery("select * from Company_Outlets_Master order by outlet_idno");                 
        }
        catch(SQLException e7)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the modified record of copmany outlet");     
       }
      tfoutlet_firmname.setEditable(false);
      tfaddress.setEditable(false);
      tfcity.setEditable(false);
      tfperson1_name.setEditable(false);
      tfperson1_mobileno.setEditable(false);
      tfperson2_name.setEditable(false);
      tfperson2_mobileno.setEditable(false);
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
       cid=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Company Outlet ID Number, whose record you want to search"));
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
     view_company_outlet();
      buttons_enable_disable();  
     JOptionPane.showMessageDialog(this,"Company Outlet Found, its record is viewed on screen.");  
    }
    else
    {
      tfoutlet_id.setText("");
      tfoutlet_firmname.setText("");
      tfaddress.setText("");
      tfcity.setText("");
      tfperson1_name.setText("");
      tfperson1_mobileno.setText("");
      tfperson2_name.setText("");
      tfperson2_mobileno.setText("");
      tfemail_id.setText("");
      JOptionPane.showMessageDialog(this,"Invalid Outlet ID Number, such outlet does not exist");    
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
         view_company_outlet();
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
          view_company_outlet();
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
           view_company_outlet();
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
         view_company_outlet();
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
   new Company_Outlets_Master_Form();   
  }
}