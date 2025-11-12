import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Inwarded_Products_DEF extends JFrame implements ActionListener,ItemListener
{
  JLabel lbtitle1, lbtitle2, lbtitle3;
  JLabel lbinward_billno, lbinward_date, lboutlet_idno, lboutlet_firmname, lbcity;
  JLabel lbproduct_idno,lbproduct_type, lbbrand_name, lbgst, lbinward_qty, lbinward_cost;
  JTextField tfinward_billno, tfinward_date, tfoutlet_idno,tfoutlet_firmname, tfcity;
  JTextField tfproduct_idno, tfproduct_type, tfbrand_name, tfgst, tfinward_qty, tfinward_cost;
  JButton butmaster_add, butmaster_save, butsearch_view, butdetails_add, butdetails_save, butoutlet_validate, butproduct_validate, butclose;
  JComboBox jcboutlets,jcbproducts;
  Connection con=null;
  int view_count;
  JTable jtproduct;
  JScrollPane jspproduct;

  Inwarded_Products_DEF()
  {
    setSize(1380,730);
    setVisible(true);
    setLayout(null);
    setTitle("Inwarded Products Application");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL BLACK",Font.PLAIN,30);
   Font f2=new Font("ARIAL",Font.BOLD,24);
   Font f3=new Font("ARIAL",Font.BOLD,20);
   Font f4=new Font("TIMES NEW ROMAN",Font.BOLD,14);

   lbtitle1 = new JLabel("Inwarded Digital Products data entry form");
   lbtitle2 = new JLabel("Data Entry of Purchased, Inwarded Products from Company Outlet");
   lbtitle3 = new JLabel("Entry of Inwarded Products");
   lbinward_billno = new JLabel("Inward Bill No.");
   lbinward_date = new JLabel("Inward Date");
   lboutlet_idno = new JLabel("Inwarded from: Outlet ID No.");
   lboutlet_firmname = new JLabel("Company Outlet Firmname");
   lbcity = new JLabel("City");
   
   lbproduct_idno = new JLabel("Product ID No.");
   lbproduct_type = new JLabel("Product Type");
   lbbrand_name = new JLabel("Brand Name");
   lbgst = new JLabel("GST in %");
   lbinward_qty = new JLabel("Inwarded Qty");
   lbinward_cost = new JLabel("Cost Per Qty");

   tfinward_billno = new JTextField();
   tfinward_date = new JTextField();
   tfoutlet_idno = new JTextField();
   tfoutlet_firmname = new JTextField();
   tfcity = new JTextField();
   
   tfproduct_idno = new JTextField();
   tfproduct_type = new JTextField();
   tfbrand_name = new JTextField();
   tfgst = new JTextField();
   tfinward_qty = new JTextField();
   tfinward_cost = new JTextField();

  butmaster_add = new JButton("Add New Inward-Bill");
  butmaster_save = new JButton("Save Master-Data");
  butsearch_view = new JButton("Search, View Inward Bill");
  butdetails_add = new JButton("Add Inwarded Product");
  butdetails_save = new JButton("Save Product Data");
  butoutlet_validate = new JButton("Validate");
  butproduct_validate = new JButton("Validate");
  butclose = new JButton("Close the Form");
  jcboutlets=new JComboBox();
  jcboutlets.addItemListener(this);
  jcbproducts=new JComboBox();
  jcbproducts.addItemListener(this);
  butmaster_add.addActionListener(this);
  butmaster_save.addActionListener(this);
  butsearch_view.addActionListener(this);
  butdetails_add.addActionListener(this);
  butdetails_save.addActionListener(this);
  butoutlet_validate.addActionListener(this);
  butproduct_validate.addActionListener(this);
  butclose.addActionListener(this);
  
  lbtitle1.setFont(f1);
  lbtitle2.setFont(f2);
  lbtitle3.setFont(f2);
  lbinward_billno.setFont(f3);
  lbinward_date.setFont(f3);
  lboutlet_idno.setFont(f3);
  lboutlet_firmname.setFont(f3);
  lbcity.setFont(f3);
  
  lbproduct_idno.setFont(f3);
  lbproduct_type.setFont(f3);
  lbbrand_name.setFont(f3);
  lbgst.setFont(f3);
  lbinward_qty.setFont(f3);
  lbinward_cost.setFont(f3);
  
  tfinward_billno.setFont(f4);
  tfinward_date.setFont(f4);
  tfoutlet_idno.setFont(f4);
  tfoutlet_firmname.setFont(f4);
  tfcity.setFont(f4);
  
  tfproduct_idno.setFont(f4);
  tfproduct_type.setFont(f4);
  tfbrand_name.setFont(f4);
  tfgst.setFont(f4);
  tfinward_qty.setFont(f4);
  tfinward_cost.setFont(f4);

  butmaster_add.setFont(f3);
  butmaster_save.setFont(f3);
  butsearch_view.setFont(f3);
  butdetails_add.setFont(f3);
  butdetails_save.setFont(f3);
  butoutlet_validate.setFont(f3);
  butproduct_validate.setFont(f3);
  jcboutlets.setFont(f3);
  jcbproducts.setFont(f3);
  butclose.setFont(f3);

  add(lbtitle1);
  add(lbtitle2);
  add(lbtitle3);
  add(lbinward_billno);
  add(tfinward_billno);
  add(lbinward_date);
  add(tfinward_date);
  add(lboutlet_idno);
  add(tfoutlet_idno);
  add(lboutlet_firmname);
  add(tfoutlet_firmname);
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
  add(lbinward_qty);
  add(tfinward_qty);
  add(lbinward_cost);
  add(tfinward_cost);
  add(butmaster_add);
  add(butmaster_save);
  add(butsearch_view);
  add(butdetails_add);
  add(butdetails_save);
  add(butoutlet_validate);
  add(butproduct_validate);
  add(jcboutlets);
  add(jcbproducts);
  add(butclose);

  lbtitle1.setBounds(275,30,700,30);
  lbtitle2.setBounds(225,70,800,25);
  lbinward_billno.setBounds(150,130,200,20);
  tfinward_billno.setBounds(375,130,150,20);
  lbinward_date.setBounds(675,130,150,20);
  tfinward_date.setBounds(850,130,200,20);
  lboutlet_idno.setBounds(50,160,300,20);
  tfoutlet_idno.setBounds(375,160,150,20);
  butoutlet_validate.setBounds(550,160,150,20);
  jcboutlets.setBounds(750,160,250,25);
  lboutlet_firmname.setBounds(50,190,300,20);
  tfoutlet_firmname.setBounds(375,190,300,20);
  lbcity.setBounds(700,190,125,20);
  tfcity.setBounds(850,190,350,20);
  butmaster_add.setBounds(100,235,225,25);
  butmaster_save.setBounds(350,235,225,25);
  butsearch_view.setBounds(600,235,300,25);
  butclose.setBounds(925,235,225,25);
  
  lbtitle3.setBounds(400,295,370,25);
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
  lbinward_qty.setBounds(30,440,150,20);
  tfinward_qty.setBounds(200,440,150,20);
  lbinward_cost.setBounds(800,440,150,20);
  tfinward_cost.setBounds(975,440,150,20);
  butdetails_add.setBounds(100,475,250,25);
  butdetails_save.setBounds(400,475,250,25);

   try
   {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
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
    ResultSet rs5=st5.executeQuery("select count(*) from Products_Inward_Master");
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
  catch(SQLException e2)
  {
  JOptionPane.showMessageDialog(this,"Problems occured during eshtablishing the connection between Java and MySQL");
  }
  
  tfoutlet_idno.setText("");
  tfoutlet_firmname.setText("");
  tfcity.setText(""); 
  tfproduct_idno.setText("");
  tfproduct_type.setText("");
  tfbrand_name.setText("");
  tfgst.setText("");

   tfinward_billno.setEnabled(false);
   tfinward_date.setEnabled(false);
   tfoutlet_idno.setEnabled(false);
   tfoutlet_firmname.setEnabled(false);
   tfcity.setEnabled(false);
   tfproduct_idno.setEnabled(false);
   tfproduct_type.setEnabled(false);
   tfbrand_name.setEnabled(false);
   tfgst.setEnabled(false);
   tfinward_qty.setEnabled(false);
   tfinward_cost.setEnabled(false);
   jcboutlets.setEnabled(false);
   jcbproducts.setEnabled(false);

  butmaster_save.setEnabled(false);
  butdetails_add.setEnabled(false);
  butdetails_save.setEnabled(false);
  butoutlet_validate.setEnabled(false);
  butproduct_validate.setEnabled(false);
  products_table();
 
}
  void products_table()
{
    try
    {
        // Remove old table if it exists
        if (jspproduct != null)
            remove(jspproduct);

        int c3 = 0;
        Statement st11 = con.createStatement();
        ResultSet rs11;

        if (tfinward_billno.getText().length() == 0)
            c3 = 0;
        else {
            rs11 = st11.executeQuery("SELECT COUNT(*) FROM Products_Inward_Details WHERE inward_billno=" + tfinward_billno.getText());
            if (rs11.next())
                c3 = rs11.getInt(1);
        }

        String[] heading = {"Product ID", "Product Type", "Brand Name", "Inward Qty", "Cost Per Qty", "Product Amount", "GST", "GST Amount", "Net Amount"};
        String[][] data;

        if (c3 == 0) {
            data = new String[1][9];
            for (int i = 0; i < 9; i++) data[0][i] = "";
        } else {
            data = new String[c3][9];
            rs11 = st11.executeQuery(
                "SELECT a.digital_product_idno, b.product_type, b.brand_name, b.gst_in_per, a.inward_qty, a.inward_cost " +
                "FROM Products_Inward_Details a " +
                "LEFT JOIN Digital_Products_Master b ON a.digital_product_idno = b.digital_product_idno " +
                "WHERE a.inward_billno = " + tfinward_billno.getText() +
                " ORDER BY a.digital_product_idno"
            );

            int i = 0;
            while (rs11.next()) {
                int pid = rs11.getInt(1);
                String ptype = rs11.getString(2);
                String pbrand_name = rs11.getString(3);
                double pgst = rs11.getDouble(4);
                int pqty = rs11.getInt(5);
                int pcost = rs11.getInt(6);

                int pamount = pqty * pcost;
                double pgst_amount = (pgst * pamount) / 100.0;
                double pnet_amount = pamount + pgst_amount;

                data[i][0] = String.valueOf(pid);
                data[i][1] = ptype;
                data[i][2] = pbrand_name;
                data[i][3] = String.valueOf(pqty);
                data[i][4] = String.valueOf(pcost);
                data[i][5] = String.valueOf(pamount);
                data[i][6] = String.valueOf(pgst);
                data[i][7] = String.format("%.2f", pgst_amount);
                data[i][8] = String.format("%.2f", pnet_amount);
                i++;
            }
        }

        jtproduct = new JTable(data, heading);
        jspproduct = new JScrollPane(jtproduct);

        add(jspproduct);
        jspproduct.setBounds(100, 515, 1050, 175);

        revalidate();
        repaint();
    }
    catch (SQLException e23)
    {
        JOptionPane.showMessageDialog(this, "Error while showing inwarded product records:\n" + e23.getMessage());
    }
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
      else if(ie.getSource()==jcbproducts)
      {
         String item2="";
         item2=(String)jcbproducts.getSelectedItem();
         String products[]=item2.split("\\$");
         tfproduct_idno.setText(products[0]);
         tfproduct_type.setText(products[1]);
         tfbrand_name.setText(products[2]);                
         tfgst.setText(products[3]);                
         tfinward_cost.setText(products[4]); 
         tfinward_qty.requestFocus();               
      }  
   }
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==butmaster_add)
      {
        tfinward_billno.setEnabled(true);
        tfinward_date.setEnabled(true);
        tfoutlet_idno.setEnabled(true);
        tfoutlet_firmname.setEnabled(true);
        tfcity.setEnabled(true);
        tfoutlet_firmname.setEditable(false);
        tfcity.setEditable(false);
        tfinward_date.setText("");
        tfoutlet_idno.setText("");
        tfoutlet_firmname.setText("");
        tfcity.setText("");
        butoutlet_validate.setEnabled(true);
        jcboutlets.setEnabled(true);
        
       try
       {
        Statement st6=con.createStatement();
        ResultSet rs6=st6.executeQuery("select max(inward_billno) from Products_Inward_Master");
        rs6.next();
        int x=rs6.getInt(1)+1;
        tfinward_billno.setText(String.valueOf(x));
        tfinward_billno.setEditable(false);        
       }
       catch(SQLException e4)
       {
        JOptionPane.showMessageDialog(this,"Problems occured during generating next Inward Bill Number");     
       }
     
       Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
       String current_date=sdf.format(dt);
       tfinward_date.setText(current_date);
       tfinward_date.requestFocus();
       butmaster_save.setEnabled(true);
      }
      else if(ae.getSource()==butmaster_save)
      {
       if(tfinward_date.getText().length()==0)
       {
         tfinward_date.requestFocus();
         JOptionPane.showMessageDialog(this,"Inward Date is empty, please enter proper Inward Date");            
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
       else
       {
         try
         {
          PreparedStatement ps2=con.prepareStatement("insert into Products_Inward_Master values(?,?,?)");
          ps2.setInt(1,Integer.parseInt(tfinward_billno.getText()));
          SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
          Date indate=sdf2.parse(tfinward_date.getText());
          java.sql.Date mydate2=new java.sql.Date(indate.getTime());
          ps2.setDate(2,mydate2);
          ps2.setInt(3,Integer.parseInt(tfoutlet_idno.getText()));
          ps2.executeUpdate();
         JOptionPane.showMessageDialog(this,"Master Data of Inward Bill is Added, Saved Successfully in the table");

          tfinward_date.setEditable(false);
          tfoutlet_idno.setEditable(false);
          butoutlet_validate.setEnabled(false);
          jcboutlets.setEnabled(false);
          butdetails_add.setEnabled(true);
         }
         catch(SQLException e5)
        {
         JOptionPane.showMessageDialog(this,"Problems occured during saving the Master Data of Inward Bill");     
        }
         catch(ParseException e6)
        {
         JOptionPane.showMessageDialog(this,"Problems occured during setting the Inward Date");     
        }
          butmaster_save.setEnabled(false);
          if(butsearch_view.isEnabled()==false)
            butsearch_view.setEnabled(false);         
     }   
    }
      else if(ae.getSource()==butsearch_view)
      {
         int billno;
         billno=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Inward Bill Number, whose record you want to search"));
         try
        {
          int chk=0;
          Statement st7=con.createStatement();
          ResultSet rs7=st7.executeQuery("select a.inward_billno, a.inward_date, a.outlet_idno, b.outlet_firmname, b.city from Products_Inward_Master a, Company_Outlets_Master b where a.outlet_idno=b.outlet_idno order by a.inward_billno");
         while(rs7.next())
         {
           if(rs7.getInt(1)==billno)
           {
             tfinward_billno.setEnabled(true);
             tfinward_billno.setEditable(true);
             tfinward_billno.setText(String.valueOf(rs7.getInt(1)));
             tfinward_billno.setEditable(false);
             tfinward_date.setEnabled(true);
             tfinward_date.setEditable(true);
             SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
             String billdate=sdf.format(rs7.getDate(2));
             tfinward_date.setText(billdate);
             tfinward_date.setEditable(false);
             tfoutlet_idno.setEnabled(true);
             tfoutlet_idno.setEditable(true);
             tfoutlet_idno.setText(String.valueOf(rs7.getInt(3)));
             tfoutlet_idno.setEditable(false);
             tfoutlet_firmname.setEnabled(true);
             tfoutlet_firmname.setEditable(true);
             tfoutlet_firmname.setText(rs7.getString(4));
             tfoutlet_firmname.setEditable(false);
             tfcity.setEnabled(true);
             tfcity.setEditable(true);
             tfcity.setText(rs7.getString(5));
             tfcity.setEditable(false);
            JOptionPane.showMessageDialog(this,"Inward Bill Number is found and viewed on the screen");    
            butdetails_add.setEnabled(true);
            chk=1;
            break;
          }       
        }
        if(chk==0)
         JOptionPane.showMessageDialog(this,"Invalid Bill Number, such inward bill number does not exist");
       else
            tfinward_billno.setText(String.valueOf(billno));  // ensure correct bill number
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
      else if(ae.getSource()==butoutlet_validate)
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
           butoutlet_validate.setEnabled(false);
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
   else if(ae.getSource()==butdetails_add)
   {
     tfproduct_idno.setEnabled(true);
     tfproduct_type.setEnabled(true);
     tfbrand_name.setEnabled(true);
     tfgst.setEnabled(true);
     tfinward_qty.setEnabled(true);
     tfinward_cost.setEnabled(true);

     tfproduct_idno.setText("");
     tfproduct_type.setText("");
     tfbrand_name.setText("");
     tfgst.setText("");
     tfinward_qty.setText("");
     tfinward_cost.setText("");

    butproduct_validate.setEnabled(true);
    jcbproducts.setEnabled(true);
    butdetails_save.setEnabled(true);
    tfproduct_idno.requestFocus();
   }
   else if(ae.getSource()==butdetails_save)
   {
        if(tfinward_billno.getText().length()==0)
        {
         JOptionPane.showMessageDialog(this,"Inward Bill Number is empty, please enter inward bill number");                   
        }
       else if(tfproduct_idno.getText().length()==0)
       {
          tfproduct_idno.requestFocus();
         JOptionPane.showMessageDialog(this,"Inwarded Product's ID Number is empty, please enter ID No.");        
       }
       else if(tfproduct_type.getText().length()==0 || tfbrand_name.getText().length()==0)
       {
         JOptionPane.showMessageDialog(this,"Product ID No. is not validated, please validate");        
       }
       else if(tfinward_qty.getText().length()==0)
       {
          tfinward_qty.requestFocus();
         JOptionPane.showMessageDialog(this,"Product's Inward Quantity is empty, please enter inward quantity");        
       }
       else if(tfinward_cost.getText().length()==0)
       {
          tfinward_cost.requestFocus();
         JOptionPane.showMessageDialog(this,"Product's Inward Cost per quantity is empty, please enter the inward cost");        
       }
       else
       {
         try
         {
          Statement st12=con.createStatement();
          ResultSet rs12=st12.executeQuery("select count(*) from Products_Inward_Details where inward_billno="+tfinward_billno.getText()+" and digital_product_idno="+tfproduct_idno.getText());
          rs12.next();
          int c4=rs12.getInt(1);
          if(c4==0)
          { 
            PreparedStatement pst3=con.prepareStatement("insert into Products_Inward_Details values(?,?,?,?)");
            pst3.setInt(1,Integer.parseInt(tfinward_billno.getText()));
            pst3.setInt(2,Integer.parseInt(tfproduct_idno.getText()));
            pst3.setInt(3,Integer.parseInt(tfinward_qty.getText()));
            pst3.setInt(4,Integer.parseInt(tfinward_cost.getText()));
            pst3.executeUpdate();
            JOptionPane.showMessageDialog(this,"Inwarded Product's Data is Added, Saved Successfully");

            PreparedStatement pstempty=con.prepareStatement("update Digital_Products_Stock set current_stock=current_stock+? where digital_product_idno=?");
            pstempty.setInt(1,Integer.parseInt(tfinward_qty.getText()));
            pstempty.setInt(2,Integer.parseInt(tfproduct_idno.getText()));
            pstempty.executeUpdate();          

            int prodamt=Integer.parseInt(tfinward_qty.getText())*Integer.parseInt(tfinward_cost.getText());
            double prodgst_amount=Double.parseDouble(tfgst.getText())*(double)prodamt/100;
            double prodnet_amount=prodamt+prodgst_amount;
            PreparedStatement pstempty2=con.prepareStatement("update Company_Outlets_Ledger set balance_amount=balance_amount+? where outlet_idno=?");
            pstempty2.setDouble(1,prodnet_amount);
            pstempty2.setInt(2,Integer.parseInt(tfoutlet_idno.getText()));
            pstempty2.executeUpdate();          

            products_table();
           }
           else
            JOptionPane.showMessageDialog(this,"Entry of this Product is already done, see table, you cannot reenter");
         }
         catch(SQLException e23)
        {
          JOptionPane.showMessageDialog(this,"Problems occured during saving the Inwarded Product's Data");
        }   
         tfproduct_idno.setText("");        
         tfproduct_type.setText("");        
         tfbrand_name.setText("");        
         tfgst.setText("");        
         tfinward_qty.setText("");        
         tfinward_cost.setText("");        

         tfproduct_idno.setEnabled(false);
         tfproduct_type.setEnabled(false);
         tfbrand_name.setEnabled(false);
         tfgst.setEnabled(false);
         tfinward_qty.setEnabled(false);
         tfinward_cost.setEnabled(false);
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
           tfinward_cost.setText(String.valueOf(xcost));
           butproduct_validate.setEnabled(false);
           tfinward_qty.requestFocus();
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
   new Inwarded_Products_DEF();   
  }
}