package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {
    
    public Home(){
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icone/front.jpg"));
       JLabel image = new JLabel(il);
       image.setBounds(0,0,1600,800);
       add(image);
       
        JLabel heading = new JLabel("AIR INDIA WELCOM YOU");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN,36));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightdetails = new JMenuItem("Flight Details");
        flightdetails.addActionListener(this);
        details.add(flightdetails);
        
        JMenuItem addcustomerdetails = new JMenuItem("Add Customer Details");
        addcustomerdetails.addActionListener(this);
        details.add(addcustomerdetails);
        
        JMenuItem bookflight = new JMenuItem("Book Flight");
         bookflight.addActionListener(this);
        details.add(bookflight);
        
        JMenuItem journerydetails = new JMenuItem("Journery Details");
        journerydetails.addActionListener(this);
        details.add(journerydetails);
        
        JMenuItem cancelticket = new JMenuItem("Cancel Ticket");
        cancelticket.addActionListener(this);
        details.add(cancelticket);
        
        JMenu ticket = new JMenu("Details");
        menubar.add(ticket);
        
        JMenuItem bodingpass = new JMenuItem("Boding Pass");
        bodingpass.addActionListener(this);
        ticket.add(bodingpass);
        
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLocation(600, 250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
       String text = ae.getActionCommand();
       
       if(text.equals("Flight Details")){
           new Flightinfo();
           
       }else if (text.equals("Add Customer Details")){
           new Addcustamer(); 
       }else if (text.equals("Book Flight")){
           new Bookflight(); 
       }else if (text.equals("Journery Details")){
           new Jurneydetails(); 
       }else if (text.equals("Cancel Ticket")){
           new Cancel(); 
       }else if (text.equals("Boding Pass")){
           new Bodingpass(); 
       }
    }
    public static void main(String[] args){
        new Home();
    }
}