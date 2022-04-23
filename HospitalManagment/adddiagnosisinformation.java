package hospitalmangment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
import java.sql.Statement;


import net.proteanit.sql.DbUtils;
//import hospitalmangment.connectionprovider;

public class adddiagnosis {
	private int flag=0;
	private JButton cancel;
	private JLabel idnot;
	private JLabel label;
	private JFrame frame;
    private JTable table;
	private ImageIcon image;
	private Object colomns[]= {"PatientId","Name","ContactNumber","Age","Gender","BloodGroup","Any Major Diseases"};
	private DefaultTableModel model;
	private JButton search;
	private JLabel labelp;
	private JTextField textfieldm;
	private ImageIcon saveimage;
	private JLabel symptems;
	private JLabel diagnosis;
	private   JLabel  medicines;
	private JTextField symptemstext;
	private JTextField  diagnositext;
	private  JTextField medicinestext;
	private JButton savebutton;
	private ImageIcon saveicon;
	private ImageIcon exiticon;
	public adddiagnosis()
	{
	frame=new JFrame();
	frame.setLayout(null);
	frame.setSize(750,500);
	frame.setLocation(350,50);
	frame.setUndecorated(true);
	
	table=new JTable();
	 frame.add(table);
	image=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\add new patient background.jpg");
	label=new JLabel();
	label.setBounds(0, 0,750,500);
	label.setIcon(image);
	
	idnot=new JLabel("ID DOES NOT EXIST !!!!!");
	idnot.setFont(new Font("MV Boli",Font.BOLD,14));
	idnot.setForeground(Color.RED);
	idnot.setBounds(150, 90, 200, 20);
	idnot.setVisible(false);
	
	symptems=new JLabel("Symtom's");
	symptems.setFont(new Font("MV Boli",Font.BOLD,14));
	symptems.setBounds(0, 200, 80, 20);
	
	diagnosis=new JLabel("Diagnosis");
	diagnosis.setFont(new Font("MV Boli",Font.BOLD,14));
	diagnosis.setBounds(0, 250, 80, 20);
	
	medicines=new JLabel("Medicines");
	medicines.setFont(new Font("MV Boli",Font.BOLD,14));
	medicines.setBounds(0, 300, 80, 20);
	
	symptemstext=new JTextField();
	symptemstext.setBounds(100, 200, 250, 25);
	
	diagnositext=new JTextField();
	diagnositext.setBounds(100, 250, 250, 25);
	
	medicinestext=new JTextField();
	medicinestext.setBounds(100, 300, 250, 25);
	
	saveicon=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\save.png");
	
	savebutton=new JButton("Save");
	savebutton.setFont(new Font("MV Boli",Font.BOLD,14));
	savebutton.setFocusable(false);
	savebutton.setIcon(saveicon);
	savebutton.setBounds(100, 450, 100, 25);
	
	
	 table=new JTable();
	   model=new DefaultTableModel();
       model.setColumnIdentifiers(colomns);
 
     table.setModel(model);
      table.setBackground(Color.WHITE);
      table.setForeground(Color.BLACK);
      table.setGridColor(Color.RED);
      table.setFont(new Font ("Tahoma",Font.BOLD,14));
      table.setRowHeight(40);
    
    table.setAutoCreateRowSorter(false);
    JScrollPane pane =new JScrollPane(table); 
     pane.setForeground(Color.RED);
     pane.setBackground(Color.WHITE);
     pane.setBounds(50,130,650,50);
    
      
      saveimage=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\search.png");
      
        labelp= new JLabel("PatientId");
      labelp.setFont(new Font("Tahoma",Font.BOLD,14));
      labelp.setBounds(50, 50, 100, 20);
      
      textfieldm=new JTextField();
      textfieldm.setBounds(160, 50, 250, 25);
      
	search=new JButton("Search");
	search.setBounds(430,50,100,30);
	search.setIcon(saveimage);
	search.setFocusable(false);
	
    
     
      exiticon=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\Close.png");
     cancel=new JButton("Close") ;
     cancel.setFocusable(false);
     cancel.setIcon(exiticon);
     cancel.setBounds(570, 450, 100, 25);
     
      cancel.addActionListener(new ActionListener() {
    	  
    	  
    
		public void actionPerformed(ActionEvent e) {
			
			frame.setVisible(false);
			
		}
      });
      
      search.addActionListener(new ActionListener() {

    		
		  
    		public void actionPerformed(ActionEvent e) {
    			
    			try
    			{
    				String patientId=textfieldm.getText();
    				Connection con=connectionprovider.getcon();
    			java.sql.Statement st=con.createStatement();
    				ResultSet rs=st.executeQuery("select * from patientco where patientID='"+patientId+"'");
    				
    				   
    			while(rs.next()) {
    				idnot.setVisible(false);
			    	
			    	textfieldm.setEditable(false);
			    	flag=1;
			    	
			    	model=(DefaultTableModel)table.getModel();
			    	
			    	model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
    				
    			}
    				//int x=  table.getRowCount();
    			      
    			  //  if(x==0)
    			    	
    			   // idnot.setVisible(true);
    			    //  else
    			     // {
    			    	
    			    	
    			    	
    			    	
    			      //}
    			}
    			catch(SQLException e1)
    			{
    				JOptionPane.showMessageDialog(null,"connection error");
    			}
    			
    		}
        	  
        	  
        	  
          });
      savebutton.addActionListener(new ActionListener() {

    		
  		public void actionPerformed(ActionEvent e) {
  			if(flag==1)
  			{
  				String patientID=textfieldm.getText();
  				String symptom=symptemstext.getText();
  				String diagnosis=diagnositext.getText();
  				String medcine=medicinestext.getText();
  				 try {
  					  Connection con=connectionprovider.getcon();
  					Statement st = con.createStatement();
  					 st.executeUpdate("insert into patientreport values('"+patientID+"','"+symptom+"','"+diagnosis+"','"+medcine+"')");
  					 JOptionPane.showMessageDialog(null, "Successfully Updated");
  					 frame.setVisible(false);
  					  new adddiagnosis();
  					 
  				} 
  				  catch (SQLException e1) 
  				  {
  					  JOptionPane.showMessageDialog(null, "Please Insert In Correct Formate ");
  					e1.printStackTrace();
  				}
  				
  			}
  			 else
  			 {
					 JOptionPane.showMessageDialog(null, "THE PATIENTID FIELD IS EMPTY !!!!");
  			     frame.setVisible(false);
				  new adddiagnosis();}
  			
  		}
  		
  	});
  	
  	
     
      frame.add(savebutton);
      frame.add(symptemstext);
      frame.add(diagnositext);
      frame.add(medicinestext);
      frame.add(medicines);
      frame.add(diagnosis);
      frame.add(symptems);
      frame.add(cancel);
	frame.add(textfieldm);
      frame.add(search);
	frame.add(labelp);
      
    frame.add(idnot);
     frame.getContentPane().add(pane);
	frame.add(label);
	frame.setVisible(true);
	}

	public static void main(String[] args) {
		new adddiagnosis();
		
		

	}

}
