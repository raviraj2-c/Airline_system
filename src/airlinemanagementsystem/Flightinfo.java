
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Flightinfo extends JFrame {
    public Flightinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table=new JTable();
        
        try{
            connection conn = new connection();
            ResultSet rs = conn.s.executeQuery("select * from flightdetails");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table); 
        jsp.setBounds(0,0,800,500);
        add(jsp);
        
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args){
        new Flightinfo();
    }
}