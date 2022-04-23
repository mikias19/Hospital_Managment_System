package hospitalmangment;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class updatepatientrecord {

	private JFrame frame;

	
	private JLabel label;
	private ImageIcon labelimage;
	private JLabel patientid;
	private JLabel name;
	private JLabel contactnum;
	private JLabel age;
	private JLabel gender;
	private JLabel bloodgroup;
	private JLabel anymajordisease;
	private JTextField patID;
	private JTextField namet;
	private JTextField connum;
	private JTextField aget;
	private JTextField bloodgro;
	private JTextField anymajordis;
	private JTextField gendercom;
	private JButton updatebutton;
	private JButton  buttonclose;
	private ImageIcon save;
	private ImageIcon close;
	private JButton search;
private ImageIcon searchicon;
	public updatepatientrecord()
	{
		

		
		
			
			frame=new JFrame();
			frame.setLayout(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(750,500);
			frame.setUndecorated(true);
			frame.setLocation(350, 50);
			
			
			labelimage=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\add new patient background.jpg ");
			
			label=new JLabel();
			label.setBounds(0,0,750,500);
			label.setIcon(labelimage);
			
			
			patientid=new JLabel("PatientId");
			patientid.setFont(new Font("MV BOli",Font.BOLD,14));
			patientid.setBounds(100, 60, 100, 14);
			
			patID=new JTextField();
			patID.setBounds(210, 60, 250, 20);
			
			searchicon=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\search.png");
			search = new JButton("Search");
			search.setIcon(searchicon);
			search.setFont(new Font("MV BOli",Font.BOLD,14));
			search.setBounds(500, 60, 120, 30);
			search.setFocusable(false);
			search.addActionListener(new ActionListener() {

			
				public void actionPerformed(ActionEvent e) {
					
					try
					{
						String patiendid=patID.getText();
					Connection con = connectionprovider.getcon();
					Statement st = con.createStatement();
					ResultSet rs=st.executeQuery("select * from patientco where patientID ='"+patiendid+"'");
					
					if(rs.next())
					{
						namet.setText(rs.getString(2));
						connum.setText(rs.getString(3));
						gendercom.setText((rs.getString(5)));
						aget.setText(rs.getString(4));
						
						bloodgro.setText(rs.getString(6));
						anymajordis.setText(rs.getString(7));
						patID.setEditable(false);
						
					}
					else
						JOptionPane.showMessageDialog(null, "UNREIGSTERED ID !!!");
					
				}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Connection Error Has Been Occured ID !!!");
					}
				
				
				}});
			
			
			name =new JLabel("Name");
			name.setFont(new Font("MV BOli",Font.BOLD,14));
			name.setBounds(100, 100, 100, 14);
			
			namet=new JTextField();
			namet.setBounds(210, 100, 250, 20);
			
			
			contactnum = new JLabel("ContactNum");
			contactnum.setFont(new Font("MV BOli",Font.BOLD,14));
			contactnum.setBounds(100, 140, 100, 14);
			
			connum=new JTextField();
			connum.setBounds(210, 140, 250, 20);
			
			
			
			gender=new JLabel("Gender");
			gender.setFont(new Font("MV BOli",Font.BOLD,14));
			gender.setBounds(100, 210, 100, 14);
			
			gendercom=new JTextField();
			gendercom.setBounds(210, 210, 250, 20);
			
			
			age =new JLabel("Age");
			age.setFont(new Font("MV BOli",Font.BOLD,14));
			age.setBounds(100, 180, 100, 14);
			
			aget=new JTextField();
			aget.setBounds(210, 180, 250, 20);
			
			
			bloodgroup =new JLabel("BloodGroup");
			bloodgroup.setFont(new Font("MV BOli",Font.BOLD,14));
			bloodgroup.setBounds(100, 260, 100, 14);
			
			bloodgro=new JTextField();
			bloodgro.setBounds(210, 260, 250, 20);
			
			anymajordisease =new JLabel("Any Major Disease Earlier Suffered ");
			anymajordisease.setFont(new Font("MV BOli",Font.BOLD,14));
			anymajordisease.setBounds(10, 300, 260, 14);
			
			anymajordis=new JTextField();
			anymajordis.setBounds(270, 300, 350, 20);
			
			save=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\save.png");
			updatebutton=new JButton("Update");
			updatebutton.setIcon(save);
			updatebutton.setFocusable(false);
			updatebutton.setFont(new Font("MV BOli",Font.BOLD,14));
			updatebutton.setBounds(210, 350, 110, 30);
			updatebutton.addActionListener(new ActionListener() {

			
				public void actionPerformed(ActionEvent e) {
					
					String patientID=patID.getText();
					String name=namet.getText();
					String contactNumber=connum.getText();
					String age =aget.getText();
					String gender=gendercom.getText();
				   String bloodGroup=bloodgro.getText();
				   String anyMajorDiseaseSufferedEarlier=anymajordis.getText();
				   
				  try {
					  Connection con=connectionprovider.getcon();
					Statement st = con.createStatement();
					 st.executeUpdate("update  patientco set name='"+name+"',contactNumber='"+contactNumber+"',age='"+age+"',gender='"+gender+"',bloodGroup='"+bloodGroup+"',anyMajorDiseaseSufferedEarlier='"+anyMajorDiseaseSufferedEarlier +"' where patientID='"+patientID+"'");
					 JOptionPane.showMessageDialog(null, "Successfully Updated");
					 frame.setVisible(false);
					  new updatepatientrecord();
					 
				} 
				  catch (SQLException e1) 
				  {
					  JOptionPane.showMessageDialog(null, "Please Insert In Correct Formate ");
					e1.printStackTrace();
				}
				 
					
					
					
				}
				
			});
			
			close=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\Close.png");
			buttonclose=new JButton("Close");
			buttonclose.setIcon(close);
			buttonclose.setFocusable(false);
			buttonclose.setFont(new Font("MV BOli",Font.BOLD,14));
			buttonclose.setBounds(400, 350, 110, 30);
			buttonclose.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e)
				{
					
						frame.setVisible(false);
						new home();
				
				}
			});
			
			frame.add(search);
			frame.add(buttonclose);
			frame.add(updatebutton);
			frame.add(anymajordis);
			frame.add(anymajordisease);
			frame.add(bloodgro);
			frame.add(bloodgroup);
			frame.add(gender);
			frame.add(gendercom);
			frame.add(age);
			frame.add(aget);
			frame.add(contactnum);
			frame.add(connum);
			frame.add(namet);
			frame.add(name);
			frame.add(patID);
			frame.add(patientid);
			frame.add(label);
			frame.setVisible(true);
		}
		
	
	public static void main(String[] args) {
		new updatepatientrecord();

	}

}
