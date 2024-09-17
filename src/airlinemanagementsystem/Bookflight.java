package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;



public class Bookflight extends JFrame implements ActionListener {
    JTextField tfaadher;
    JLabel tfname,tfaddress,tfnationality,labelgender,labelfname,labelfcode,labeldate;
    JButton bookflight,flight,fetchbutton;
    Choice source,destination;
    JDateChooser dcdate;
    public Bookflight () {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500 , 35);
        heading.setFont(new Font("Thahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        
        JLabel lblaadher = new JLabel("Aadher ");
        lblaadher.setBounds(60,80,150,25);
        lblaadher.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblaadher);
        
       tfaadher = new JTextField();
        tfaadher.setBounds(220,80,150,25);
        add(tfaadher);
         fetchbutton = new JButton("Fetch");
        fetchbutton.setBackground(Color.BLACK);
        fetchbutton.setForeground(Color.WHITE);
        
        fetchbutton.setBounds(380,80,120,25);
        fetchbutton.addActionListener(this);
        add(fetchbutton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,130,150,25);
        lblname.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        JLabel lbladdress = new JLabel("address");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblgender);
        
         labelgender = new JLabel("Gender");
        labelgender.setBounds(220,280,150,25);
        add(labelgender);
        
        JLabel lblsource = new JLabel("source");
        lblsource.setBounds(60,330,150,25);
        lblsource.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblsource);
        
         source = new Choice();
        source.setBounds(220,330,150,25);
        add(source);
        
        JLabel lbldest = new JLabel("destination");
        lbldest.setBounds(60,380,150,25);
        lbldest.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lbldest);
        
         destination = new Choice();
        destination.setBounds(220,380,150,25);
        add(destination);
        
        try{
            connection c = new connection();
            String query ="select * from flightdetails";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
            source.add(rs.getString("flight_from"));
            destination.add(rs.getString("flight_to"));
            }
            
        }catch(Exception e){
        e.printStackTrace();
        }
        
        
         flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,430,150,25);
        lblfname.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220,430,150,25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60,480,150,25);
        lblfcode.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220,480,150,25);
        add(labelfcode);
        
        labeldate = new JLabel("Date of Flight");
        labeldate.setBounds(60,530,150,25);
        labeldate.setFont(new Font("Thahoma", Font.PLAIN, 16));
        add(labeldate);
        
         dcdate = new JDateChooser();
        dcdate.setBounds(220,530,150,25);
        add(dcdate);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icone/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550,80,500,410);
        add(lblimage);
        
         bookflight = new JButton("Book Flights");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 580, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==fetchbutton){
        String aadher = tfaadher.getText();
        try{
            connection conn = new connection();
            String query = "select * from passenger where aadher = '"+aadher+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfnationality.setText(rs.getString("nationality"));
                labelgender.setText(rs.getString("gender"));
            }else{
             JOptionPane.showMessageDialog(null,"Please enter correct aadhar");   
            }

    } catch (Exception e){
        e.printStackTrace();
    }
        } else if (ae.getSource()==flight){
        String sec = source.getSelectedItem();
        String dest = destination.getSelectedItem();
        try{
            connection conn = new connection();
            String query = "select * from flightdetails where flight_from = '"+sec+"' and flight_to = '"+dest+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                labelfname.setText(rs.getString("flight_name")); 
                labelfcode.setText(rs.getString("flight_id"));
            }else{
             JOptionPane.showMessageDialog(null,"No Flights Found");   
            }

    } catch (Exception e){
        e.printStackTrace();
    }
        }else{
            Random random = new Random();
            String aadher = tfaadher.getText();
            String name=tfname.getText();
            String nationality= tfnationality.getText();
            String gender =labelgender.getText();
            String flightname =labelfname.getText();
            String flightcode =labelfcode.getText();
    
            String src = source.getSelectedItem();
            String des = destination.getSelectedItem();
            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            
            
            try{
            connection conn = new connection();
            String query = "insert into reservation values ('PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(1000000)+"','"+name+"','"+aadher+"','"+nationality+"','"+gender+"','"+flightname+"','"+flightcode+"','"+src+"','"+des+"','"+date+"')";
             conn.s.executeUpdate(query);

             JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");   
            
            setVisible(false);
    } catch (Exception e){
        e.printStackTrace();
    }
        }
    }
    public static void main(String[] args){
        new Bookflight();
    }
}

