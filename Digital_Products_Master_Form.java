import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Digital_Products_Master_Form extends JFrame implements ActionListener
{
  JLabel lbtitle,lbproduct_id,lbproduct_type,lbbrand_name,lbmodel,lbtechnical_info,lbsize_capacity,lbstd_cost,lbgst;
  JTextField tfproduct_id,tfbrand_name,tfmodel,tftechnical_info,tfsize_capacity,tfstd_cost,tfgst;
  JButton butadd,butdelete,butmodify,butsave,butsearch,butfirst,butprevious,butnext,butlast,butclose;
  JComboBox jcbproduct_type;
  Connection con=null;
  Statement st=null;
  ResultSet rs=null;
  char check='X';
  int count=0;
  Digital_Products_Master_Form()
  {
    setSize(1250,700);
    setVisible(true);
    setLayout(null);
    setTitle("Digital Products Application");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL BLACK",Font.PLAIN,30);
   Font f2=new Font("ARIAL",Font.BOLD,22);
   Font f3=new Font("TIMES NEW ROMAN",Font.BOLD,16);

   lbtitle=new JLabel("DIGITAL PRODUCTS master data manipulation form");
   lbproduct_id=new JLabel("Digital Product's ID No.");
   lbproduct_type=new JLabel("Product Type");
   lbbrand_name=new JLabel("Brand Name");
   lbmodel=new JLabel("Model No, Name");
   lbtechnical_info=new JLabel("Technical Information");
   lbsize_capacity=new JLabel("Product Size, Capacity");
   lbstd_cost=new JLabel("Standard Cost");
   lbgst=new JLabel("GST(in Percentage)");

  tfproduct_id=new JTextField();
  tfbrand_name=new JTextField();
  tfmodel=new JTextField();
  tftechnical_info=new JTextField();
  tfsize_capacity=new JTextField();
  tfstd_cost=new JTextField();
  tfgst=new JTextField();
  jcbproduct_type=new JComboBox();

  butadd=new JButton("Add New Product");
  butdelete=new JButton("Delete the Product");
  butmodify=new JButton("Modify Product Data");
  butsave=new JButton("Save Product Data");
  butsearch=new JButton("Search the Product");
  butclose=new JButton("Close the Form");
  butfirst=new JButton("First Product");
  butnext=new JButton("Next Product");
  butprevious=new JButton("Previous Product");
  butlast=new JButton("Last Product");
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
  lbproduct_id.setFont(f2);
  lbproduct_type.setFont(f2);
  lbbrand_name.setFont(f2);
  lbmodel.setFont(f2);
  lbtechnical_info.setFont(f2);
  lbsize_capacity.setFont(f2);
  lbstd_cost.setFont(f2);
  lbgst.setFont(f2);
  tfproduct_id.setFont(f3);
  jcbproduct_type.setFont(f3);
  tfbrand_name.setFont(f3);
  tfmodel.setFont(f3);
  tftechnical_info.setFont(f3);
  tfsize_capacity.setFont(f3);
  tfstd_cost.setFont(f3);
  tfgst.setFont(f3);
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
  add(lbproduct_id);
  add(tfproduct_id);
  add(lbproduct_type);
  add(jcbproduct_type);
  add(lbbrand_name);
  add(tfbrand_name);
  add(lbmodel);
  add(tfmodel);
  add(lbtechnical_info);
  add(tftechnical_info);
  add(lbsize_capacity);
  add(tfsize_capacity);
  add(lbstd_cost);
  add(tfstd_cost);
  add(lbgst);
  add(tfgst);
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
  lbproduct_id.setBounds(100,130,300,25);
  tfproduct_id.setBounds(450,130,150,25);
  lbproduct_type.setBounds(100,170,300,25);
  jcbproduct_type.setBounds(450,170,300,25);
  lbbrand_name.setBounds(100,210,300,25);
  tfbrand_name.setBounds(450,210,500,25);
  lbmodel.setBounds(100,250,300,25);
  tfmodel.setBounds(450,250,450,25);
  lbtechnical_info.setBounds(100,290,300,25);
  tftechnical_info.setBounds(450,290,750,25);
  lbsize_capacity.setBounds(100,330,300,25);
  tfsize_capacity.setBounds(450,330,500,25);
  lbstd_cost.setBounds(100,370,300,25);
  tfstd_cost.setBounds(450,370,250,25);
  lbgst.setBounds(100,410,300,25);
  tfgst.setBounds(450,410,250,25);
  butadd.setBounds(125,510,175,30);
  butdelete.setBounds(325,510,175,30);
  butmodify.setBounds(525,510,175,30);
  butsave.setBounds(725,510,175,30);
  butsearch.setBounds(925,510,175,30);
  butfirst.setBounds(125,560,175,30);
  butnext.setBounds(325,560,175,30);
  butprevious.setBounds(525,560,175,30);
  butlast.setBounds(725,560,175,30);
  butclose.setBounds(925,560,175,30);
  
  tfproduct_id.setEditable(false); 
  jcbproduct_type.setEnabled(false); 
  tfbrand_name.setEditable(false); 
  tfmodel.setEditable(false); 
  tftechnical_info.setEditable(false); 
  tfsize_capacity.setEditable(false); 
  tfstd_cost.setEditable(false); 
  tfgst.setEditable(false); 

   try
   {
     Class.forName("com.mysql.jdbc.Driver");
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
    //JOptionPane.showMessageDialog(this,"Connection made successfully");
    Statement stmt=con.createStatement();
    ResultSet rsmt=stmt.executeQuery("select * from Product_Types");
    String pt;
    while(rsmt.next())
    {
      pt=rsmt.getString(1);
      jcbproduct_type.addItem(pt);  
    }
    st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery("select * from Digital_Products_Master order by digital_product_idno");
    Statement st1=con.createStatement();
    ResultSet rs1=st1.executeQuery("select count(*) from Digital_Products_Master");
    rs1.next();
    count=rs1.getInt(1);
    if(count>=1)
    {
      rs.first();
      view_digital_product();
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
  tfproduct_id.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfproduct_id.getText().length()>=4)
                ke.consume();
             if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
                return;
             else
                ke.consume();
           }
        }
   );
   tfbrand_name.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfbrand_name.getText().length()>=25)
                ke.consume();
           }
        }
   );

   tfmodel.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfmodel.getText().length()>=20)
                ke.consume();
           }
        }
   );

   tftechnical_info.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tftechnical_info.getText().length()>=60)
                ke.consume();
           }
        }
   );

   tfsize_capacity.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfsize_capacity.getText().length()>=25)
                ke.consume();
           }
        }
   );

   tfstd_cost.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfstd_cost.getText().length()>=6)
                ke.consume();
             if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
                return;
             else
                ke.consume();
           }
        }
   );

   tfgst.addKeyListener(
        new KeyAdapter()
        {
           public void keyTyped(KeyEvent ke)
           {
             if(ke.getKeyChar()==8)
                return;     
             if(tfgst.getText().length()>=5)
                ke.consume();
             if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9' || ke.getKeyChar()=='.')
                return;
             else
                ke.consume();
           }
        }
   );

 }

   void view_digital_product()
   {
     try
     {
       int vproduct_id, vstd_cost;
       String vproduct_type, vbrand_name, vmodel, vtechnical_info, vsize_capacity;
       double vgst;
       vproduct_id=rs.getInt(1);
       vproduct_type=rs.getString(2);
       vbrand_name=rs.getString(3);
       vmodel=rs.getString(4);
       vtechnical_info=rs.getString(5);
       vsize_capacity=rs.getString(6);
       vstd_cost=rs.getInt(7);
       vgst=rs.getDouble(8);

       tfproduct_id.setText(String.valueOf(vproduct_id));
       jcbproduct_type.setSelectedItem(vproduct_type);
       tfbrand_name.setText(vbrand_name);
       tfmodel.setText(vmodel);
       tftechnical_info.setText(vtechnical_info);
       tfsize_capacity.setText(vsize_capacity);
       tfstd_cost.setText(String.valueOf(vstd_cost));
       tfgst.setText(String.valueOf(vgst));
       }
     catch(SQLException e3)
     {
      JOptionPane.showMessageDialog(this,"Problems occured during viewing the digital product");
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
      tfproduct_id.setEditable(true);
      jcbproduct_type.setEnabled(true);
      tfbrand_name.setEditable(true);
      tfmodel.setEditable(true);
      tftechnical_info.setEditable(true);
      tfsize_capacity.setEditable(true);
      tfstd_cost.setEditable(true);
      tfgst.setEditable(true);

      tfproduct_id.setText("");
      tfbrand_name.setText("");
      tfmodel.setText("");
      tftechnical_info.setText("");
      tfsize_capacity.setText("");
      tfstd_cost.setText("");
      tfgst.setText("");

      try
      {
        Statement st2=con.createStatement();
        ResultSet rs2=st2.executeQuery("select max(digital_product_idno) from Digital_Products_Master");
        rs2.next();
        int x=rs2.getInt(1)+1;
        tfproduct_id.setText(String.valueOf(x));
      }
      catch(SQLException e4)
      {
        JOptionPane.showMessageDialog(this,"Problems occured during generating next Product ID");     
      }
      tfproduct_id.setEditable(false);
      jcbproduct_type.requestFocus(); 
      check='A';
      butsave.setEnabled(true);     
     }
     else if(ae.getSource()==butdelete)
     {
        int ans;
        ans=JOptionPane.showConfirmDialog(this,"Are you sure to delete this client record?","DeleteConfirmation",JOptionPane.YES_NO_OPTION);
        if(ans==JOptionPane.YES_OPTION)
        {
          check='D';
         JOptionPane.showMessageDialog(this,"Please Click on SAVE PRODUCT DATA Button to delete this record permanantly");     
        }
     }
     else if(ae.getSource()==butmodify)
     {
      jcbproduct_type.setEnabled(true);
      tfbrand_name.setEditable(true);
      tfmodel.setEditable(true);
      tftechnical_info.setEditable(true);
      tfsize_capacity.setEditable(true);
      tfstd_cost.setEditable(true);
      tfgst.setEditable(true);
      jcbproduct_type.requestFocus();
      check='M';
     }  
     else if(ae.getSource()==butsave)
     {
       if(tfproduct_id.getText().length()==0)
       {
         tfproduct_id.requestFocus();
         JOptionPane.showMessageDialog(this,"Product ID Number is empty, please enter suitable Product ID No.");            
       } 
      else if(tfbrand_name.getText().length()==0)
      {
        tfbrand_name.requestFocus();
       JOptionPane.showMessageDialog(this,"Product brand_name is empty, please enter the suitable brand_name");                  
      }
      else if(tfmodel.getText().length()==0)
      {
       tfmodel.requestFocus();
       JOptionPane.showMessageDialog(this,"Product model No,Name is empty, please enter the Model No,Name");            
      }
      else if(tftechnical_info.getText().length()==0)
      {
       tftechnical_info.requestFocus();
       JOptionPane.showMessageDialog(this,"Product's technical information is empty, please enter suitable data for technical configuration");            
      }
      else if(tfsize_capacity.getText().length()==0)
      {
       tfsize_capacity.requestFocus();
       JOptionPane.showMessageDialog(this,"Product Size or Capacity is empty, please enter the suitable value for Product Size,Capacity");            
      }
      else if(tfstd_cost.getText().length()==0)
      {
       tfstd_cost.requestFocus();
       JOptionPane.showMessageDialog(this,"Product's Standard Cost is empty, please enter the suitable cost for the Product");            
      }
      else if(tfgst.getText().length()==0)
      {
       tfgst.requestFocus();
       JOptionPane.showMessageDialog(this,"GST is empty, please enter GST for the product");            
      }
      else
      {
       if(check=='A')
       {
         try
         {
         PreparedStatement ps2=con.prepareStatement("insert into Digital_Products_Master values(?,?,?,?,?,?,?,?)");
         ps2.setInt(1,Integer.parseInt(tfproduct_id.getText()));
         ps2.setString(2,(String)jcbproduct_type.getSelectedItem());
         ps2.setString(3,tfbrand_name.getText());
         ps2.setString(4,tfmodel.getText());
         ps2.setString(5,tftechnical_info.getText());
         ps2.setString(6,tfsize_capacity.getText());
         ps2.setInt(7,Integer.parseInt(tfstd_cost.getText()));
         ps2.setDouble(8,Double.parseDouble(tfgst.getText()));
         ps2.executeUpdate();
        JOptionPane.showMessageDialog(this,"Digital Products Data/Record is Added, Saved Successfully in the table");
        
         PreparedStatement pstempty=con.prepareStatement("insert into Digital_Products_Stock values(?,?)");
         pstempty.setInt(1,Integer.parseInt(tfproduct_id.getText()));
         pstempty.setInt(2,0);
         pstempty.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record of Newly Added Product is maintained into Stock Register");
        
         count++;
         rs=st.executeQuery("select * from Digital_Products_Master order by digital_product_idno");
         rs.last();                 
         }
        catch(SQLException e5)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the inserted record of digital product");     
       }
      tfproduct_id.setEditable(false);
      jcbproduct_type.setEnabled(false);
      tfbrand_name.setEditable(false);
      tfmodel.setEditable(false);
      tftechnical_info.setEditable(false);
      tfsize_capacity.setEditable(false);
      tfstd_cost.setEditable(false);
      tfgst.setEditable(false);
     }
     else if(check=='D')
     {
         try
         {
         PreparedStatement ps3=con.prepareStatement("delete from Digital_Products_Master where digital_product_idno=?");
         ps3.setInt(1,Integer.parseInt(tfproduct_id.getText()));
         ps3.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record is Deleted Successfully in the table");
        count--;
         rs=st.executeQuery("select * from Digital_Products_Master order by digital_product_idno");
         if(count==0)
         {
           tfproduct_id.setText("");
           tfbrand_name.setText("");
           tfmodel.setText("");
           tftechnical_info.setText("");
           tfsize_capacity.setText("");
           tfstd_cost.setText("");
           tfgst.setText("");
         }
         else
         {
            rs.first();
            view_digital_product();
         }                 
        }
        catch(SQLException e6)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the deleted record of digital product");     
       }
             
     }
     else if(check=='M')
     {
         try
         {
         PreparedStatement ps4=con.prepareStatement("update Digital_Products_Master set product_type=?, brand_name=?, model_no_name=?, technical_info=?, product_size_capacity=?, std_cost=?, gst_in_per=? where digital_product_idno=?");
         ps4.setString(1,(String)jcbproduct_type.getSelectedItem());
         ps4.setString(2,tfbrand_name.getText());
         ps4.setString(3,tfmodel.getText());
         ps4.setString(4,tftechnical_info.getText());
         ps4.setString(5,tfsize_capacity.getText());
         ps4.setString(6,tfstd_cost.getText());
         ps4.setDouble(7,Double.parseDouble(tfgst.getText()));
         ps4.setInt(8,Integer.parseInt(tfproduct_id.getText()));
         ps4.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record is Modified Successfully in the table");
         rs=st.executeQuery("select * from Digital_Products_Master order by digital_product_idno");
         int idno=Integer.parseInt(tfproduct_id.getText());
         while(rs.next())
         {
            if(rs.getInt(1)==idno)
                break;
         }                 
        }
        catch(SQLException e7)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during saving the modified record of digital product");     
       }
      jcbproduct_type.setEnabled(false);
      tfbrand_name.setEditable(false);
      tfmodel.setEditable(false);
      tftechnical_info.setEditable(false);
      tfsize_capacity.setEditable(false);
      tfstd_cost.setEditable(false);
      tfgst.setEditable(false);
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
       cid=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Digital Product ID Number, whose record you want to search"));
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
     view_digital_product();
      buttons_enable_disable();  
     JOptionPane.showMessageDialog(this,"Product Found, its record is viewed on screen.");  
    }
    else
    {
      tfproduct_id.setText("");
      tfbrand_name.setText("");
      tfmodel.setText("");
      tftechnical_info.setText("");
      tfsize_capacity.setText("");
      tfstd_cost.setText("");
      tfgst.setText("");
      JOptionPane.showMessageDialog(this,"Invalid Product ID Number, such product does not exist");    
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
         view_digital_product();
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
          view_digital_product();
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
           view_digital_product();
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
         view_digital_product();
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
   new Digital_Products_Master_Form();   
  }
}