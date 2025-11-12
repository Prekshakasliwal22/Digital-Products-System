import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Read_Period_Form extends JFrame implements ActionListener
{
  JLabel lbtitle1,lbtitle2,lbstart_date,lbend_date;
  JTextField tfstart_date,tfend_date;
  JButton butreport,butcancel;
  int num;
  Read_Period_Form(int no)
  {
    num=no;
    setSize(1050,400);
    setVisible(true);
    setLayout(null);
    setTitle("Accepting Period from User");
    getContentPane().setBackground(Color.PINK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   Font f1=new Font("ARIAL",Font.BOLD,22);
   Font f2=new Font("ARIAL BLACK",Font.PLAIN,28);
   Font f3=new Font("ARIAL",Font.BOLD,20);
   Font f4=new Font("TIMES NEW ROMAN",Font.BOLD,16);

   lbtitle1=new JLabel("Enter PERIOD (Starting-Date and Ending-Date) for producing");
   if(no==321)
       lbtitle2=new JLabel("Inwarded Digital Products Periodical Report");
   else if(no==351)
       lbtitle2=new JLabel("Digital Products Credit Sales Report (Periodical)");
   else if(no==352)
       lbtitle2=new JLabel("Digital Products Cash Sales Report (Periodical)");
   else if(no==341)
       lbtitle2=new JLabel("Periodical Payments Paid Report(to Company Outlets)");
   else if(no==361)
       lbtitle2=new JLabel("Periodical Payments Received Report(from Retailers)");
   lbstart_date=new JLabel("Period from (Starting Date):");
   lbend_date=new JLabel("Period to (Ending Date):");

  tfstart_date=new JTextField("15/09/2025");
  tfend_date=new JTextField("30/09/2025");

  butreport=new JButton("Produce Report");
  butcancel=new JButton("Cancel");
  butreport.addActionListener(this); 
  butcancel.addActionListener(this); 

  lbtitle1.setFont(f1);
  lbtitle2.setFont(f2);
  lbstart_date.setFont(f3);
  lbend_date.setFont(f3);
  tfstart_date.setFont(f4);
  tfend_date.setFont(f4);
  butreport.setFont(f4);
  butcancel.setFont(f4);

  add(lbtitle1);
  add(lbtitle2);
  add(lbstart_date);
  add(tfstart_date);
  add(lbend_date);
  add(tfend_date);
  add(butreport);
  add(butcancel);

  lbtitle1.setBounds(155,50,640,25);
  lbtitle2.setBounds(50,100,950,35);
  lbstart_date.setBounds(200,200,300,20);
  tfstart_date.setBounds(550,200,200,20);
  lbend_date.setBounds(200,250,300,20);
  tfend_date.setBounds(550,250,200,20);
  butreport.setBounds(250,300,200,30);
  butcancel.setBounds(500,300,200,30);
  
 }

   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==butreport)
      {
         dispose();
         if(num==321)
               new Periodical_Inward_Report(tfstart_date.getText(),tfend_date.getText());         
         else if(num==341)
               new Periodical_Paid_Payments_Report(tfstart_date.getText(),tfend_date.getText());
         else if(num==351)
               new Periodical_Credit_Sales_Report(tfstart_date.getText(),tfend_date.getText());
         else if(num==352)
               new Periodical_Cash_Sales_Report(tfstart_date.getText(),tfend_date.getText());
         else if(num==361)
               new Periodical_Received_Payments_Report(tfstart_date.getText(),tfend_date.getText());
      }
      else if(ae.getSource()==butcancel)
      {
         dispose();
      }          
   }

  public static void main(String args[])
  {
   new Read_Period_Form(321);   
  }
}