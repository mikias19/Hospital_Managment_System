package hospitalmangment;

import java.awt.Font;
import hospitalmangment.connectionprovider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class patientrecord  {
	
	
	private JFrame patientframe;
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
	private JComboBox gendercom;
	String name_gender[]= {"Female","Male","None"};
	private JButton buttonsave;
	private JButton  buttonclose;
	private ImageIcon save;
	private ImageIcon close;
	public patientrecord()
	{
		
		patientframe=new JFrame();
		patientframe.setLayout(null);
       patientframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		patientframe.setSize(750,500);
		patientframe.setUndecorated(true);
		patientframe.setLocation(350, 50);
		
		
		labelimage=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\add new patient background.jpg ");
		
		label=new JLabel();
		label.setBounds(0,0,750,500);
		label.setIcon(labelimage);
		
		
		patientid=new JLabel("PatientId");
		patientid.setFont(new Font("MV BOli",Font.BOLD,14));
		patientid.setBounds(100, 60, 100, 14);
		
		patID=new JTextField();
		patID.setBounds(210, 60, 250, 20);
		
		name =new JLabel("Name");
		name.setFont(new Font("MV BOli",Font.BOLD,14));
		name.setBounds(100, 100, 100, 14);
		
		namet=new JTextField();
		namet.setBounds(210, 100, 250, 20);
		
		
		contactnum =new JLabel("ContactNum");
		contactnum.setFont(new Font("MV BOli",Font.BOLD,14));
		contactnum.setBounds(100, 140, 100, 14);
		
		connum=new JTextField();
		connum.setBounds(210, 140, 250, 20);
		
		gender =new JLabel("Gender");
		gender.setFont(new Font("MV BOli",Font.BOLD,14));
		gender.setBounds(100, 210, 100, 14);
		
		gendercom=new JComboBox(name_gender);
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
		buttonsave=new JButton("save");
		buttonsave.setIcon(save);
		buttonsave.setFocusable(false);
		buttonsave.setFont(new Font("MV BOli",Font.BOLD,14));
		buttonsave.setBounds(210, 350, 110, 30);
		buttonsave.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent e) {
				
				String patientID=patID.getText();
				String name=namet.getText();
				String contactNumber=connum.getText();
				String age =aget.getText();
				String gender=(String)gendercom.getSelectedItem();
			   String bloodGroup=bloodgro.getText();
			   String anyMajorDiseaseSufferedEarlier=anymajordis.getText();
			   
			  try {
				  Connection con=connectionprovider.getcon();
				Statement st = con.createStatement();
				 st.executeUpdate("insert into patientco values('"+patientID+"','"+name+"','"+contactNumber+"','"+age+"','"+gender+"','"+bloodGroup+"','"+anyMajorDiseaseSufferedEarlier +"')");
				 JOptionPane.showMessageDialog(null, "Successfully Updated");
				 patientframe.setVisible(false);
				  new patientrecord();
				 
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
				
					patientframe.setVisible(false);
					new home();
			
			}
		});
		
		
		patientframe.add(buttonclose);
		patientframe.add(buttonsave);
		patientframe.add(anymajordis);
		patientframe.add(anymajordisease);
		patientframe.add(bloodgro);
		patientframe.add(bloodgroup);
		patientframe.add(gender);
		patientframe.add(gendercom);
		patientframe.add(age);
		patientframe.add(aget);
		patientframe.add(contactnum);
		patientframe.add(connum);
		patientframe.add(namet);
		patientframe.add(name);
		patientframe.add(patID);
		patientframe.add(patientid);
		patientframe.add(label);
		patientframe.setVisible(true);
	}
	
	
	
	

	public static void main(String[] args) {
		
		
	    new patientrecord();

	}

}
