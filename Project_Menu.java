import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Project_Menu extends JFrame implements ActionListener
{
 JMenuBar jmb;
 JMenu jmn1,jmn2,jmn3,jmn4;
 JMenuItem jmi11,jmi12,jmi13,jmi14;
 JMenuItem jmi21,jmi22,jmi23,jmi24,jmi25;
 JMenu jmn31,jmn32,jmn34,jmn35,jmn36;
 JMenuItem jmi33;
 JMenuItem jmi311,jmi312,jmi313,jmi314;
 JMenuItem jmi321,jmi322,jmi323,jmi324,jmi325;
 JMenuItem jmi341,jmi342,jmi343;
 JMenuItem jmi351,jmi352,jmi353,jmi354,jmi355;
 JMenuItem jmi361,jmi362,jmi363;
 JMenuItem jmi41;
 public Project_Menu()
 {
     super("DIGITAL PRODUCTS SYSTEM");
  setSize(1390,720);
  setVisible(true);
  setLayout(null);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  getContentPane().setBackground(Color.PINK);

  ImageIcon ii=new ImageIcon("Reliance-Mall.png");
  JLabel lbimage=new JLabel(ii);
  add(lbimage); 
  lbimage.setBounds(50,50,1250,590);
 
  jmb=new JMenuBar();
  jmn1=new JMenu("Primary Data Manipulation Module");
  jmn2=new JMenu("Transactional Data Entry Module");
  jmn3=new JMenu("Online/Web Reports Module");
  jmn4=new JMenu("Close the Project");

  jmi11=new JMenuItem("Digital Products Master Data Manipulation");
  jmi12=new JMenuItem("Company Outlets Master Data Manipulation");
  jmi13=new JMenuItem("Credit Holder Retailers Master Data Manipulation");
  jmi14=new JMenuItem("Ordinary Clients Master Data Manipulation");
  
  jmi21=new JMenuItem("Inwarded Digital Products(From Company Outlet) Data Entry");
  jmi22=new JMenuItem("Paid Payment (to Company Outlet) Data Entry");
  jmi23=new JMenuItem("Digital Products Credit Sales(to Retailer) Data Entry");
  jmi24=new JMenuItem("Received Payment (from Retailer) Data Entry");
  jmi25=new JMenuItem("Digital Products Cash Sales(to Client) Data Entry");
  
  jmn31=new JMenu("Primary Information Reports");
  jmn32=new JMenu("Inwarded Digital Products Reports");
  jmi33=new JMenuItem("Digital Products Current Stock Report");
  jmn34=new JMenu("Paid Payments Summary Reports");
  jmn35=new JMenu("Sold Digital Products Reports");
  jmn36=new JMenu("Received Payments Summary Reports");
  jmi41=new JMenuItem("Exit from the Project");

  jmi311=new JMenuItem("Digital Products Primary Information Report");
  jmi312=new JMenuItem("Company Outlets Primary Information Report");
  jmi313=new JMenuItem("Credit Holder Retailers Primary Information Report");
  jmi314=new JMenuItem("Clients Primary Information Report");
  
  jmi321=new JMenuItem("Inwarded Digital Products Periodical Report");
  jmi322=new JMenuItem("Company Outletwise Products Inward Report");
  jmi323=new JMenuItem("Digital Productwise Inward Report");
  
  jmi341=new JMenuItem("Paid Payments(to Company Outlets) Periodical Report");
  jmi342=new JMenuItem("Company Outletwise Paid Payments Summary Report");
  jmi343=new JMenuItem("Company Outlets Outstanding Payments Report");

  jmi351=new JMenuItem("Digital Products Credit Sales(to Retailers) Periodical Report");
  jmi352=new JMenuItem("Digital Products Cash Sales(to Clients) Periodical Report");
  jmi353=new JMenuItem("Retailerwise Digital Products Sales Report");
  jmi354=new JMenuItem("Digital Productwise Credit Sales Report");
  jmi355=new JMenuItem("Digital Productwise Cash Sales Report");

  jmi361=new JMenuItem("Received Payments(from Retailers) Periodical Report");
  jmi362=new JMenuItem("Retailerwise received Payment Summary Report");
  jmi363=new JMenuItem("Retailers Outstanding Payments Report");

  jmi11.addActionListener(this);
  jmi12.addActionListener(this);
  jmi13.addActionListener(this);
  jmi14.addActionListener(this);
  jmi21.addActionListener(this);
  jmi22.addActionListener(this);
  jmi23.addActionListener(this);
  jmi24.addActionListener(this);
  jmi25.addActionListener(this);
  jmi33.addActionListener(this);
  jmi311.addActionListener(this);
  jmi312.addActionListener(this);
  jmi313.addActionListener(this);
  jmi314.addActionListener(this);
  jmi321.addActionListener(this);
  jmi322.addActionListener(this);
  jmi323.addActionListener(this);
  jmi341.addActionListener(this);
  jmi342.addActionListener(this);
  jmi343.addActionListener(this);
  jmi351.addActionListener(this);
  jmi352.addActionListener(this);
  jmi353.addActionListener(this);
  jmi354.addActionListener(this);
  jmi355.addActionListener(this);
  jmi361.addActionListener(this);
  jmi362.addActionListener(this);
  jmi363.addActionListener(this);
  jmi41.addActionListener(this);

  jmn1.add(jmi11);
  jmn1.add(jmi12);
  jmn1.add(jmi13);
  jmn1.add(jmi14);
  jmn2.add(jmi21);
  jmn2.add(jmi22);
  jmn2.add(jmi23);
  jmn2.add(jmi24);
  jmn2.add(jmi25);
  jmn3.add(jmn31);
  jmn3.add(jmn32);
  jmn3.add(jmi33);
  jmn3.add(jmn34);
  jmn3.add(jmn35);
  jmn3.add(jmn36);
  jmn4.add(jmi41);

  jmn31.add(jmi311);
  jmn31.add(jmi312);
  jmn31.add(jmi313);
  jmn31.add(jmi314);
  jmn32.add(jmi321);
  jmn32.add(jmi322);
  jmn32.add(jmi323);
  jmn34.add(jmi341);
  jmn34.add(jmi342);
  jmn34.add(jmi343);
  jmn35.add(jmi351);
  jmn35.add(jmi352);
  jmn35.add(jmi353);
  jmn35.add(jmi354);
  jmn35.add(jmi355);
  jmn36.add(jmi361);
  jmn36.add(jmi362);
  jmn36.add(jmi363);

  jmb.add(jmn1);
  jmb.add(jmn2);
  jmb.add(jmn3);
  jmb.add(jmn4);
  setJMenuBar(jmb);

}

public void actionPerformed(ActionEvent ae)
{
  if(ae.getSource()==jmi11)
    new Digital_Products_Master_Form();
  else if(ae.getSource()==jmi12)
    new Company_Outlets_Master_Form();
  else if(ae.getSource()==jmi13)
    new Retailers_Master_Form();
  else if(ae.getSource()==jmi14)
    new Clients_Master_Form();
  else if(ae.getSource()==jmi21)
    new Inwarded_Products_DEF();
  else if(ae.getSource()==jmi22)
    new Outlet_Payments_DEF();
  else if(ae.getSource()==jmi23)
    new Credit_Sold_Products_DEF();
  else if(ae.getSource()==jmi24)
    new Retailer_Payments_DEF();
  else if(ae.getSource()==jmi25)
    new Cash_Sold_Products_DEF();
  else if(ae.getSource()==jmi33)
    new Current_Stock_Report();
  else if(ae.getSource()==jmi311)
     new Products_Info_Report();
  else if(ae.getSource()==jmi312)
     new Outlets_Info_Report();
  else if(ae.getSource()==jmi313)
     new Retailers_Info_Report();
  else if(ae.getSource()==jmi314)
     new Clients_Info_Report();
  else if(ae.getSource()==jmi321)
     new Read_Period_Form(321);
  else if(ae.getSource()==jmi322)
     new Read_Outlet_Form(322);
  else if(ae.getSource()==jmi323)
     new Read_Product_Form(323);
  else if(ae.getSource()==jmi341)
    new Read_Period_Form(341);
  else if(ae.getSource()==jmi342)
    new Read_Outlet_Form(342);
  else if(ae.getSource()==jmi343)
    new Outlets_Outstanding_Payment_Report();
  else if(ae.getSource()==jmi351)
    new Read_Period_Form(351);
  else if(ae.getSource()==jmi352)
    new Read_Period_Form(352);
  else if(ae.getSource()==jmi353)
    new Read_Retailer_Form(353); 
  else if(ae.getSource()==jmi354)
    new Read_Product_Form(354);
  else if(ae.getSource()==jmi355)
    new Read_Product_Form(355);
  else if(ae.getSource()==jmi361)
    new Read_Period_Form(361);
  else if(ae.getSource()==jmi362)
    new Read_Retailer_Form(362);
  else if(ae.getSource()==jmi363)
   new Retailers_Outstanding_Payment_Report();
  else if(ae.getSource()==jmi41)
      dispose();

}
  public static void main(String args[])
 {
  new Project_Menu(); 
 }
}