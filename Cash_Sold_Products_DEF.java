import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Cash_Sold_Products_DEF extends JFrame implements ActionListener,ItemListener
{
  JLabel lbtitle1, lbtitle2, lbtitle3;
  JLabel lbcash_sales_billno, lbcash_sales_date, lbclient_idno, lbclient_name, lbcity;
  JLabel lbproduct_idno,lbproduct_type, lbbrand_name, lbgst, lbcash_sales_qty, lbcash_sales_cost;
  JTextField tfcash_sales_billno, tfcash_sales_date, tfclient_idno,tfclient_name, tfcity;
  JTextField tfproduct_idno, tfproduct_type, tfbrand_name, tfgst, tfcash_sales_qty, tfcash_sales_cost;
  JButton butmaster_add, butmaster_save, butsearch_view, butdetails_add, butdetails_save, butclient_validate, butproduct_validate, butclose;
  JComboBox jcbclients,jcbproducts;
  Connection con=null;
  int view_count;
  Cash_Sold_Products_DEF()
  {
    setSize(1250,700);
    setVisible(true);
    setLayout(null);
    setTitle("Cash Sales Application");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL BLACK",Font.PLAIN,30);
   Font f2=new Font("ARIAL",Font.BOLD,24);
   Font f3=new Font("ARIAL",Font.BOLD,20);
   Font f4=new Font("TIMES NEW ROMAN",Font.BOLD,14);

   lbtitle1 = new JLabel("Client's Cash Sales Receipt data entry form");
   lbtitle2 = new JLabel("Data Entry of Sold Digital Products to Client on Cash");
   lbtitle3 = new JLabel("Entry of Sold Products to Client on Cash");
   lbcash_sales_billno = new JLabel("Cash Sales Bill No.");
   lbcash_sales_date = new JLabel("Cash Sales Date");
   lbclient_idno = new JLabel("Sold to: Client ID No.");
   lbclient_name = new JLabel("Client Name");
   lbcity = new JLabel("City");
   
   lbproduct_idno = new JLabel("Product ID No.");
   lbproduct_type = new JLabel("Product Type");
   lbbrand_name = new JLabel("Brand Name");
   lbgst = new JLabel("GST in %");
   lbcash_sales_qty = new JLabel("Cash Sales Qty");
   lbcash_sales_cost = new JLabel("Cost Per Qty");

   tfcash_sales_billno = new JTextField();
   tfcash_sales_date = new JTextField();
   tfclient_idno = new JTextField();
   tfclient_name = new JTextField();
   tfcity = new JTextField();
   
   tfproduct_idno = new JTextField();
   tfproduct_type = new JTextField();
   tfbrand_name = new JTextField();
   tfgst = new JTextField();
   tfcash_sales_qty = new JTextField();
   tfcash_sales_cost = new JTextField();

  butmaster_add = new JButton("Add New Sales-Bill");
  butmaster_save = new JButton("Save Master-Data");
  butsearch_view = new JButton("Search, View Sales Bill");
  butdetails_add = new JButton("Add Sold Product");
  butdetails_save = new JButton("Save Product Data");
  butclient_validate = new JButton("Validate");
  butproduct_validate = new JButton("Validate");
  butclose = new JButton("Close the Form");
  jcbclients=new JComboBox();
  jcbclients.addItemListener(this);
  jcbproducts=new JComboBox();
  jcbproducts.addItemListener(this);
  butmaster_add.addActionListener(this);
  butmaster_save.addActionListener(this);
  butsearch_view.addActionListener(this);
  butdetails_add.addActionListener(this);
  butdetails_save.addActionListener(this);
  butclient_validate.addActionListener(this);
  butproduct_validate.addActionListener(this);
  butclose.addActionListener(this);
  
  lbtitle1.setFont(f1);
  lbtitle2.setFont(f2);
  lbtitle3.setFont(f2);
  lbcash_sales_billno.setFont(f3);
  lbcash_sales_date.setFont(f3);
  lbclient_idno.setFont(f3);
  lbclient_name.setFont(f3);
  lbcity.setFont(f3);
  
  lbproduct_idno.setFont(f3);
  lbproduct_type.setFont(f3);
  lbbrand_name.setFont(f3);
  lbgst.setFont(f3);
  lbcash_sales_qty.setFont(f3);
  lbcash_sales_cost.setFont(f3);
  
  tfcash_sales_billno.setFont(f4);
  tfcash_sales_date.setFont(f4);
  tfclient_idno.setFont(f4);
  tfclient_name.setFont(f4);
  tfcity.setFont(f4);
  
  tfproduct_idno.setFont(f4);
  tfproduct_type.setFont(f4);
  tfbrand_name.setFont(f4);
  tfgst.setFont(f4);
  tfcash_sales_qty.setFont(f4);
  tfcash_sales_cost.setFont(f4);

  butmaster_add.setFont(f3);
  butmaster_save.setFont(f3);
  butsearch_view.setFont(f3);
  butdetails_add.setFont(f3);
  butdetails_save.setFont(f3);
  butclient_validate.setFont(f3);
  butproduct_validate.setFont(f3);
  jcbclients.setFont(f3);
  jcbproducts.setFont(f3);
  butclose.setFont(f3);

  add(lbtitle1);
  add(lbtitle2);
  add(lbtitle3);
  add(lbcash_sales_billno);
  add(tfcash_sales_billno);
  add(lbcash_sales_date);
  add(tfcash_sales_date);
  add(lbclient_idno);
  add(tfclient_idno);
  add(lbclient_name);
  add(tfclient_name);
  add(lbcity);
  add(tfcity);
  add(lbproduct_idno);
  add(tfproduct_idno);
  add(lbproduct_type);
  add(tfproduct_type);
  add(lbbrand_name);
  add(tfbrand_name);
  add(lbgst);
  add(tfgst);
  add(lbcash_sales_qty);
  add(tfcash_sales_qty);
  add(lbcash_sales_cost);
  add(tfcash_sales_cost);
  add(butmaster_add);
  add(butmaster_save);
  add(butsearch_view);
  add(butdetails_add);
  add(butdetails_save);
  add(butclient_validate);
  add(butproduct_validate);
  add(jcbclients);
  add(jcbproducts);
  add(butclose);

  lbtitle1.setBounds(245,30,760,30);
  lbtitle2.setBounds(295,70,660,25);
  lbcash_sales_billno.setBounds(150,130,200,20);
  tfcash_sales_billno.setBounds(375,130,150,20);
  lbcash_sales_date.setBounds(670,130,170,20);
  tfcash_sales_date.setBounds(850,130,200,20);
  lbclient_idno.setBounds(125,160,225,20);
  tfclient_idno.setBounds(375,160,150,20);
  butclient_validate.setBounds(550,160,150,20);
  jcbclients.setBounds(750,160,250,25);
  lbclient_name.setBounds(150,190,200,20);
  tfclient_name.setBounds(375,190,300,20);
  lbcity.setBounds(700,190,125,20);
  tfcity.setBounds(850,190,350,20);
  butmaster_add.setBounds(100,235,225,25);
  butmaster_save.setBounds(350,235,225,25);
  butsearch_view.setBounds(600,235,300,25);
  butclose.setBounds(925,235,225,25);
  
  lbtitle3.setBounds(365,295,520,25);
  lbproduct_idno.setBounds(30,350,150,20);
  tfproduct_idno.setBounds(200,350,100,20);
  butproduct_validate.setBounds(310,350,120,20);
  jcbproducts.setBounds(450,350,250,25);
  lbproduct_type.setBounds(30,380,150,20);
  tfproduct_type.setBounds(200,380,400,20);
  lbbrand_name.setBounds(30,410,150,20);
  tfbrand_name.setBounds(200,410,500,20);
  lbgst.setBounds(800,410,150,20);
  tfgst.setBounds(975,410,150,20);
  lbcash_sales_qty.setBounds(30,440,160,20);
  tfcash_sales_qty.setBounds(200,440,150,20);
  lbcash_sales_cost.setBounds(800,440,150,20);
  tfcash_sales_cost.setBounds(975,440,150,20);
  butdetails_add.setBounds(100,475,250,25);
  butdetails_save.setBounds(400,475,250,25);

   try
   {
     Class.forName("com.mysql.cj.jdbc.Driver");
    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
    //JOptionPane.showMessageDialog(this,"Connection made successfully");
    Statement st1=con.createStatement();
    ResultSet rs1=st1.executeQuery("select count(*) from Clients_Master");
    rs1.next();
    int count1=rs1.getInt(1);
    if(count1>0)
    {
      Statement st2=con.createStatement();
      ResultSet rs2=st2.executeQuery("select client_idno,client_name,city from Clients_Master order by client_idno");
     int vclient_id;
     String vclient_name,vcity,vclient_item;
     while(rs2.next())
     {
       vclient_id=rs2.getInt(1);
       vclient_name=rs2.getString(2);
       vcity=rs2.getString(3);
       vclient_item=String.valueOf(vclient_id)+"$"+vclient_name+"$"+vcity;
       jcbclients.addItem(vclient_item); 
     }
    }
    Statement st3=con.createStatement();
    ResultSet rs3=st3.executeQuery("select count(*) from Digital_Products_Master");
    rs3.next();
    int count2=rs3.getInt(1);
    if(count2>0)
    {
      Statement st4=con.createStatement();
      ResultSet rs4=st4.executeQuery("select digital_product_idno,product_type,brand_name,gst_in_per,std_cost from Digital_Products_Master order by digital_product_idno");
     int vproduct_id,vstd_cost;
     String vproduct_type,vbrand_name,vproduct_item;
     double vgst;
     while(rs4.next())
     {
       vproduct_id=rs4.getInt(1);
       vproduct_type=rs4.getString(2);
       vbrand_name=rs4.getString(3);
       vgst=rs4.getDouble(4);
       vstd_cost=rs4.getInt(5);
       vproduct_item=String.valueOf(vproduct_id)+"$"+vproduct_type+"$"+vbrand_name+"$"+String.valueOf(vgst)+"$"+String.valueOf(vstd_cost);
       jcbproducts.addItem(vproduct_item); 
     }
    }
    Statement st5=con.createStatement();
    ResultSet rs5=st5.executeQuery("select count(*) from Products_Cash_Sales_Master");
    rs5.next();
    view_count=rs5.getInt(1);
    if(view_count==0)
        butsearch_view.setEnabled(false);
    else
        butsearch_view.setEnabled(true);
  }
  catch(ClassNotFoundException e1)
  {
    JOptionPane.showMessageDialog(this,"Problems occured when loads,registers the drivers");
  }
  catch(SQLException e2) {
    JOptionPane.showMessageDialog(this,"Problems occured during eshtablishing the connection between Java and MySQL\n" + e2.getMessage());
}
  
  tfclient_idno.setText("");
  tfclient_name.setText("");
  tfcity.setText(""); 
  tfproduct_idno.setText("");
  tfproduct_type.setText("");
  tfbrand_name.setText("");
  tfgst.setText("");

   tfcash_sales_billno.setEnabled(false);
   tfcash_sales_date.setEnabled(false);
   tfclient_idno.setEnabled(false);
   tfclient_name.setEnabled(false);
   tfcity.setEnabled(false);
   tfproduct_idno.setEnabled(false);
   tfproduct_type.setEnabled(false);
   tfbrand_name.setEnabled(false);
   tfgst.setEnabled(false);
   tfcash_sales_qty.setEnabled(false);
   tfcash_sales_cost.setEnabled(false);
   jcbclients.setEnabled(false);
   jcbproducts.setEnabled(false);

  butmaster_save.setEnabled(false);
  butdetails_add.setEnabled(false);
  butdetails_save.setEnabled(false);
  butclient_validate.setEnabled(false);
  butproduct_validate.setEnabled(false);
  products_table();
 
}
  void products_table()
  {
       try
       {
        int c3;
        Statement st11=con.createStatement();
        ResultSet rs11=null;
         if(tfcash_sales_billno.getText().length()==0)
            c3=0;
        else
        {
          rs11=st11.executeQuery("select count(*) from Products_Cash_Sales_Details where cash_sales_billno="+tfcash_sales_billno.getText());
          rs11.next();
          c3=rs11.getInt(1);
        }
        if(c3==0)
        {
          String data[][]={{"","","","","","","","",""}};
          String heading[]={"Product ID", "Product Type", "Brand Name", "Sold Qty", "Cost Per Qty", "Product Amount", "GST", "GST Amount","Net Amount"};
          JTable jtproduct=new JTable(data,heading);
         JScrollPane jspproduct=new JScrollPane(jtproduct);
         add(jspproduct);
         jspproduct.setBounds(100,515,1050,175);
        }
        else
        {
           String data[][]=new String[c3][9];
           rs11=st11.executeQuery("select a.digital_product_idno,b.product_type,b.brand_name,b.gst_in_per,a.cash_sales_qty,a.cash_sales_cost from Products_Cash_Sales_Details a, Digital_Products_Master b where a.digital_product_idno=b.digital_product_idno and a.cash_sales_billno="+tfcash_sales_billno.getText()+" order by a.digital_product_idno");
           int pid,pqty,pcost,pamount;
          double pgst,pgst_amount,pnet_amount;
          String ptype,pbrand_name;
          int i=0;
          while(rs11.next())
          {
            pid=rs11.getInt(1);
            ptype=rs11.getString(2);
            pbrand_name=rs11.getString(3);
            pgst=rs11.getDouble(4);
            pqty=rs11.getInt(5);
            pcost=rs11.getInt(6);
            pamount=pqty*pcost;
            pgst_amount=pgst*(double)pamount/100;
            pnet_amount=pamount+pgst_amount;

            data[i][0]=String.valueOf(pid);
            data[i][1]=ptype;
            data[i][2]=pbrand_name;
            data[i][3]=String.valueOf(pqty);
            data[i][4]=String.valueOf(pcost);
            data[i][5]=String.valueOf(pamount);
            data[i][6]=String.valueOf(pgst);
            data[i][7]=String.valueOf(pgst_amount);
            data[i][8]=String.valueOf(pnet_amount);
            i++;
          }
          String heading[]={"Product ID", "Product Type", "Brand Name", "Sold Qty", "Cost Per Qty", "Product Amount", "GST", "GST Amount","Net Amount"};
          JTable jtproduct=new JTable(data,heading);
         JScrollPane jspproduct=new JScrollPane(jtproduct);
         add(jspproduct);
         jspproduct.setBounds(100,515,1050,175);
        }
      }
     catch(SQLException e23)
     {
          JOptionPane.showMessageDialog(this,"Problems occured when viewing the sold product's records");
     }
 }
 
   public void itemStateChanged(ItemEvent ie)
   {
      if(ie.getSource()==jcbclients)
      {
         String item1="";
         item1=(String)jcbclients.getSelectedItem();
         String clients[]=item1.split("\\$");
         tfclient_idno.setText(clients[0]);
         tfclient_name.setText(clients[1]);
         tfcity.setText(clients[2]);
      }
      else if(ie.getSource()==jcbproducts)
      {
         String item2="";
         item2=(String)jcbproducts.getSelectedItem();
         String products[]=item2.split("\\$");
         tfproduct_idno.setText(products[0]);
         tfproduct_type.setText(products[1]);
         tfbrand_name.setText(products[2]);                
         tfgst.setText(products[3]);                
         tfcash_sales_cost.setText(products[4]); 
         tfcash_sales_qty.requestFocus();               
      }  
   }
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==butmaster_add)
      {
        tfcash_sales_billno.setEnabled(true);
        tfcash_sales_billno.setEditable(false);
        tfcash_sales_date.setEnabled(true);
        tfcash_sales_date.setEditable(true);
        tfclient_idno.setEnabled(true);
        tfclient_idno.setEditable(true);
        tfclient_name.setEnabled(true);
        tfclient_name.setEditable(false);
        tfcity.setEnabled(true);
        tfcity.setEditable(false);
        
        tfcash_sales_date.setText("");
        tfclient_idno.setText("");
        tfclient_name.setText("");
        tfcity.setText("");
        butclient_validate.setEnabled(true);
        jcbclients.setEnabled(true);
        
       try
       {
        Statement st6=con.createStatement();
        ResultSet rs6=st6.executeQuery("select max(cash_sales_billno) from Products_Cash_Sales_Master");
        rs6.next();
        int x=rs6.getInt(1)+1;
        tfcash_sales_billno.setText(String.valueOf(x));
        tfcash_sales_billno.setEditable(false);        
       }
       catch(SQLException e4)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during generating next Sales Bill Number");     
       }
     
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
       String current_date=sdf.format(dt);
       tfcash_sales_date.setText(current_date);
       tfcash_sales_date.requestFocus();
       butmaster_save.setEnabled(true);
      }
      else if(ae.getSource()==butmaster_save)
      {
       if(tfcash_sales_date.getText().length()==0)
       {
         tfcash_sales_date.requestFocus();
         JOptionPane.showMessageDialog(this,"Sales Date is empty, please enter proper Sales Date");            
       }
       else if(tfclient_idno.getText().length()==0)
       {
         tfclient_idno.requestFocus();
         JOptionPane.showMessageDialog(this,"Client ID No. is empty, please enter proper Client ID No.");            
       }
       else if(tfclient_name.getText().length()==0 || tfcity.getText().length()==0)
       {
         JOptionPane.showMessageDialog(this,"Client ID No is not validated, please validate the Client ID No.");            
       }
       else
       {
         try
         {
          PreparedStatement ps2=con.prepareStatement("insert into Products_Cash_Sales_Master values(?,?,?)");
          ps2.setInt(1,Integer.parseInt(tfcash_sales_billno.getText()));
          SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
          Date indate=sdf2.parse(tfcash_sales_date.getText());
          java.sql.Date mydate2=new java.sql.Date(indate.getTime());
          ps2.setDate(2,mydate2);
          ps2.setInt(3,Integer.parseInt(tfclient_idno.getText()));
          ps2.executeUpdate();
         JOptionPane.showMessageDialog(this,"Master Data of Sales Bill is Added, Saved Successfully in the table");

          tfcash_sales_date.setEditable(false);
          tfclient_idno.setEditable(false);
          butclient_validate.setEnabled(false);
          jcbclients.setEnabled(false);
          butdetails_add.setEnabled(true);
         }
         catch(SQLException e5)
        {
         JOptionPane.showMessageDialog(this,"Problems occured during saving the Master Data of Sales Bill");     
        }
         catch(ParseException e6)
        {
         JOptionPane.showMessageDialog(this,"Problems occured during setting the Sales Date");     
        }
          butmaster_save.setEnabled(false);
          if(butsearch_view.isEnabled()==false)
               butsearch_view.setEnabled(true);         
     }   
    }
      else if(ae.getSource()==butsearch_view)
      {
         int billno;
         billno=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Sales Bill Number, whose record you want to search"));
         try
        {
          int chk=0;
          Statement st7=con.createStatement();
          ResultSet rs7=st7.executeQuery("select a.cash_sales_billno, a.cash_sales_date, a.client_idno, b.client_name, b.city from Products_Cash_Sales_Master a, Clients_Master b where a.client_idno=b.client_idno order by a.cash_sales_billno");
         while(rs7.next())
         {
           if(rs7.getInt(1)==billno)
           {
             tfcash_sales_billno.setEnabled(true);
             tfcash_sales_billno.setEditable(true);
             tfcash_sales_billno.setText(String.valueOf(rs7.getInt(1)));
             tfcash_sales_billno.setEditable(false);
             tfcash_sales_date.setEnabled(true);
             tfcash_sales_date.setEditable(true);
             SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
             String billdate=sdf.format(rs7.getDate(2));
             tfcash_sales_date.setText(billdate);
             tfcash_sales_date.setEditable(false);
             tfclient_idno.setEnabled(true);
             tfclient_idno.setEditable(true);
             tfclient_idno.setText(String.valueOf(rs7.getInt(3)));
             tfclient_idno.setEditable(false);
             tfclient_name.setEnabled(true);
             tfclient_name.setEditable(true);
             tfclient_name.setText(rs7.getString(4));
             tfclient_name.setEditable(false);
             tfcity.setEnabled(true);
             tfcity.setEditable(true);
             tfcity.setText(rs7.getString(5));
             tfcity.setEditable(false);
            JOptionPane.showMessageDialog(this,"Sales Bill Number is found and viewed on the screen");    
            butdetails_add.setEnabled(true);
            chk=1;
            break;
          }       
        }
        if(chk==0)
         JOptionPane.showMessageDialog(this,"Invalid Bill Number, such sales bill number does not exist");
       else
            products_table();         
    }
    catch(SQLException e8)
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
         catch(SQLException e20)
         {
          JOptionPane.showMessageDialog(this,"Problems occured when closing the connection");
         }
        dispose();           
      }
      else if(ae.getSource()==butclient_validate)
      {
       try
       {
        Statement st5=con.createStatement();
        ResultSet rs5=st5.executeQuery("select count(*) from Clients_Master where client_idno="+tfclient_idno.getText());
        rs5.next();
        int c1=rs5.getInt(1);
        if(c1>0)
        {
           rs5=st5.executeQuery("select client_name,city from Clients_Master where client_idno="+tfclient_idno.getText());
           rs5.next();
           String xclient_name=rs5.getString(1);
           String xcity=rs5.getString(2);
           tfclient_name.setText(xclient_name);
           tfcity.setText(xcity);
           butclient_validate.setEnabled(false);
        }
       else
       {
         JOptionPane.showMessageDialog(this,"Invalid Client ID Number, please check");        
       }
      }
     catch(SQLException e21)
     {
          JOptionPane.showMessageDialog(this,"Problems occured during validating the Client ID number");
     }
 
   }
   else if(ae.getSource()==butdetails_add)
   {
     tfproduct_idno.setEnabled(true);
     tfproduct_type.setEnabled(true);
     tfbrand_name.setEnabled(true);
     tfgst.setEnabled(true);
     tfcash_sales_qty.setEnabled(true);
     tfcash_sales_cost.setEnabled(true);

     tfproduct_idno.setText("");
     tfproduct_type.setText("");
     tfbrand_name.setText("");
     tfgst.setText("");
     tfcash_sales_qty.setText("");
     tfcash_sales_cost.setText("");

    butproduct_validate.setEnabled(true);
    jcbproducts.setEnabled(true);
    butdetails_save.setEnabled(true);
    tfproduct_idno.requestFocus();
   }
   else if(ae.getSource()==butdetails_save)
   {
        if(tfcash_sales_billno.getText().length()==0)
        {
         JOptionPane.showMessageDialog(this,"Invalid Bill Number is empty, please enter sales bill number");                   
        }
       else if(tfproduct_idno.getText().length()==0)
       {
          tfproduct_idno.requestFocus();
         JOptionPane.showMessageDialog(this,"Sold Product's ID Number is empty, please enter ID No.");        
       }
       else if(tfproduct_type.getText().length()==0 || tfbrand_name.getText().length()==0)
       {
         JOptionPane.showMessageDialog(this,"Product ID No. is not validated, please validate");        
       }
         else if(tfcash_sales_qty.getText().length()==0)
       {
          tfcash_sales_qty.requestFocus();
         JOptionPane.showMessageDialog(this,"Product's Sold Quantity is empty, please enter sold quantity");        
       }
       else if(tfcash_sales_cost.getText().length()==0)
       {
          tfcash_sales_cost.requestFocus();
         JOptionPane.showMessageDialog(this,"Product's Sales Cost per quantity is empty, please enter the sales cost");        
       }
       else
       {
         try
         {
          Statement st12=con.createStatement();
          ResultSet rs12=st12.executeQuery("select count(*) from Products_Cash_Sales_Details where cash_sales_billno="+tfcash_sales_billno.getText()+" and digital_product_idno="+tfproduct_idno.getText());
          rs12.next();
          int c4=rs12.getInt(1);
          if(c4==0)
          { 
            PreparedStatement pst3=con.prepareStatement("insert into Products_Cash_Sales_Details values(?,?,?,?)");
            pst3.setInt(1,Integer.parseInt(tfcash_sales_billno.getText()));
            pst3.setInt(2,Integer.parseInt(tfproduct_idno.getText()));
            pst3.setInt(3,Integer.parseInt(tfcash_sales_qty.getText()));
            pst3.setInt(4,Integer.parseInt(tfcash_sales_cost.getText()));
            pst3.executeUpdate();
            JOptionPane.showMessageDialog(this,"Sold Product's Data is Added, Saved Successfully");

            PreparedStatement pstempty=con.prepareStatement("update Digital_Products_Stock set current_stock=current_stock-? where digital_product_idno=?");
            pstempty.setInt(1,Integer.parseInt(tfcash_sales_qty.getText()));
            pstempty.setInt(2,Integer.parseInt(tfproduct_idno.getText()));
            pstempty.executeUpdate();          

            products_table();
           }
           else
            JOptionPane.showMessageDialog(this,"Entry of this Product is already done, see table, you cannot reenter");
         }
         catch(SQLException e23)
        {
          JOptionPane.showMessageDialog(this,"Problems occured during saving the Sold Product's Data");
        }   
         tfproduct_idno.setText("");        
         tfproduct_type.setText("");        
         tfbrand_name.setText("");        
         tfgst.setText("");        
         tfcash_sales_qty.setText("");        
         tfcash_sales_cost.setText("");        

         tfproduct_idno.setEnabled(false);
         tfproduct_type.setEnabled(false);
         tfbrand_name.setEnabled(false);
         tfgst.setEnabled(false);
         tfcash_sales_qty.setEnabled(false);
         tfcash_sales_cost.setEnabled(false);
         butproduct_validate.setEnabled(false);
         jcbproducts.setEnabled(false);
         butdetails_save.setEnabled(false);
       }
   }
   else if(ae.getSource()==butproduct_validate)
   {
       try
       {
        Statement st8=con.createStatement();
        ResultSet rs8=st8.executeQuery("select count(*) from Digital_Products_Master where digital_product_idno="+tfproduct_idno.getText());
        rs8.next();
        int c2=rs8.getInt(1);
        if(c2>0)
        {
           rs8=st8.executeQuery("select product_type,brand_name,gst_in_per,std_cost from Digital_Products_Master where digital_product_idno="+tfproduct_idno.getText());
           rs8.next();
           String xproduct_type=rs8.getString(1);
           String xbrand_name=rs8.getString(2);
           double xgst=rs8.getDouble(3);
           int xcost=rs8.getInt(4);
           tfproduct_type.setText(xproduct_type);
           tfbrand_name.setText(xbrand_name);
           tfgst.setText(String.valueOf(xgst));
           tfcash_sales_cost.setText(String.valueOf(xcost));
           butproduct_validate.setEnabled(false);
           tfcash_sales_qty.requestFocus();
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
   new Cash_Sold_Products_DEF();   
  }
}