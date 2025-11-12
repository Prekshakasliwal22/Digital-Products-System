import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Project_Login extends JFrame implements ActionListener
{
  JLabel lb1,lb2,lb3,lb4,lbtitle,lbusername,lbpassword;
  JTextField tfusername;
  JPasswordField tfpassword;
  JButton butlogin,butcancel;
  Project_Login()
  {
    setSize(1380,750);
    setVisible(true);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setBackground(new Color(242,172,185));
    Font f1=new Font("Arial Black",Font.PLAIN,30);
    Font f2=new Font("Arial",Font.BOLD,24);
    Font f3=new Font("Arial",Font.BOLD,20);
    lb1=new JLabel("A Software Project");
    lb2=new JLabel("Digital Products Invoicing and Outsourcing");
    lb3=new JLabel("developed for");
    lb4=new JLabel("Reliance Digital Mall, MG Road, Shivajinagar 5, Pune");
    lbtitle=new JLabel("Enter your Username and Password...");
    lbusername=new JLabel("Username");
    lbpassword=new JLabel("Password");
    tfusername=new JTextField();
    tfpassword=new JPasswordField();
    butlogin=new JButton("Login");
    butcancel=new JButton("Cancel");
    butlogin.addActionListener(this);
    butcancel.addActionListener(this);
    
    lb1.setFont(f3);
    lb2.setFont(f1);
    lb3.setFont(f3);
    lb4.setFont(f2);
    lbtitle.setFont(f2);
    lbusername.setFont(f3);
    lbpassword.setFont(f3);
    tfusername.setFont(f3);
    tfpassword.setFont(f3);
    butlogin.setFont(f3);
    butcancel.setFont(f3);

    add(lb1);
    add(lb2);
    add(lb3);
    add(lb4);
    add(lbtitle);
    add(lbusername);
    add(tfusername);
    add(lbpassword);
    add(tfpassword);
    add(butlogin);
    add(butcancel);
    
    lb1.setBounds(500,50,200,25);
    lb2.setBounds(255,95,760,35);
    lb3.setBounds(500,150,200,25);
    lb4.setBounds(290,195,700,30);
    lbtitle.setBounds(800,475,450,30);
    lbusername.setBounds(850,535,125,20);
    tfusername.setBounds(1000,535,200,20);
    lbpassword.setBounds(850,575,125,20);
    tfpassword.setBounds(1000,575,200,20);
    butlogin.setBounds(900,625,150,25);
    butcancel.setBounds(1075,625,150,25);
    
    tfpassword.setEchoChar('*');
    ImageIcon ii=new ImageIcon("Image_Login.jpeg");
    JLabel lbimage=new JLabel(ii);
    add(lbimage);
    lbimage.setBounds(50,250,750,450);

}
  
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==butlogin)
    {
    try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital_Products","root","Preksha22@");
//JOptionPane.showMessageDialog(this,"Connection Eshtablished Successfully");
      PreparedStatement pst=con.prepareStatement("select count(*) from company_users_login_password where user_name=? AND user_password=?");
      pst.setString(1,tfusername.getText());
      String x=new String(tfpassword.getPassword());
      pst.setString(2,x);
      ResultSet rs=pst.executeQuery();
      rs.next();
      int cnt=rs.getInt(1);
      if(cnt>0)
       {
         JOptionPane.showMessageDialog(this,"You are authorized user, please continue the project");
         new Project_Menu();
         dispose();
       }
      else
            JOptionPane.showMessageDialog(this,"Sorry you are unauthorized user");
      con.close();
    }
    catch(ClassNotFoundException e1)
    {
        JOptionPane.showMessageDialog(this,"Problems occured during drivers registration");
    }
    catch(SQLException e2)
    {
        JOptionPane.showMessageDialog(this,"Problems occured during Java-MySql Connection");
    }

    }
    else if(ae.getSource()==butcancel)
    {
       dispose();
    }   
  }
  public static void main(String args[])
  {
    Project_Login obj=new Project_Login();    
  }
}