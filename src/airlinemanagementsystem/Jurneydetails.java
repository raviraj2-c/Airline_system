
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class Jurneydetails extends JFrame implements ActionListener {
    JTable table;
    JTextField pnr; 
    JButton show;
    public Jurneydetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpnr.setBounds(50,50,100,25);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160,50,100,25);
        add(pnr);
        
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290,50,120,25);
        show.addActionListener(this);
        add(show);
        
        
         table=new JTable();
        
        JScrollPane jsp = new JScrollPane(table); 
        jsp.setBounds(0,100,840,100);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        setSize(850,500);
        setLocation(400,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            connection conn = new connection();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"' ");
            
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "NO Information Found");
                  return; 
            }
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Jurneydetails();
    }
}

