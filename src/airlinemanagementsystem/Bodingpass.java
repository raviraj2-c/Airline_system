package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;



public class Bodingpass extends JFrame implements ActionListener {
    JTextField tfpnr;
    JLabel labdate,tfname,lblsrc,tfnationality,lbldest,labelfname,labelfcode;
    JButton fetchbutton;


    public Bodingpass () {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("AIR INDIN");
        heading.setBounds(420, 10, 500 , 35);
        heading.setFont(new Font("Thahoma", Font.PLAIN, 32));
        add(heading);
        
        JLabel subheading = new JLabel("BOADING PASS");
        subheading.setBounds(360,50,300,30);
        subheading.setFont(new Font("Thahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        JLabel lblaadher = new JLabel("PNR DETAILS");
        lblaadher.setBounds(60,100,150,25);
        lblaadher.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblaadher);
        
       tfpnr = new JTextField();
        tfpnr.setBounds(220,100,150,25);
        add(tfpnr);
        
        
         fetchbutton = new JButton("Enter");
        fetchbutton.setBackground(Color.BLACK);
        fetchbutton.setForeground(Color.WHITE);
        
        fetchbutton.setBounds(380,100,120,25);
        fetchbutton.addActionListener(this);
        add(fetchbutton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,140,150,25);
        lblname.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220,140,150,25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        
        
        
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,210,150,25);
        lblfname.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220,210,150,25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60,250,150,25);
        lblfcode.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220,250,150,25);
        add(labelfcode);
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60,290,150,25);
        lbladdress.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220,290,150,25);
        add(lblsrc);
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380,290,150,25);
        lblgender.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblgender);
        
         lbldest = new JLabel();
        lbldest.setBounds(540,290,150,25);
        add(lbldest);
        
        JLabel labeldate = new JLabel("Dates");
        labeldate.setBounds(60,320,150,25);
        labeldate.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(labeldate);
        
         labdate = new JLabel();
        labdate.setBounds(220,320,150,25);
        add(labdate);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icone/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600,0,300,300);
        add(lblimage);
        
        
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
        
        String pnr = tfpnr.getText();
        try{
            connection conn = new connection();
            String query = "select * from reservation where PNR = '"+pnr+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
             if(rs.next()){
                tfname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("flightname"));
                labdate.setText(rs.getString("datevarchar")); 
                lblsrc.setText(rs.getString("src")); 
                tfnationality .setText(rs.getString("nationality")); 
               lbldest.setText(rs.getString("des")); 
               labelfcode.setText(rs.getString("flightcode"));
               
            }else{
             JOptionPane.showMessageDialog(null,"Please enter correct PNR");   
            }

    } catch (Exception e){
        e.printStackTrace();
    }
       
       
    }
    public static void main(String[] args){
        new Bodingpass();
    }
}
