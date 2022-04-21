package hospitalmangment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class home extends JFrame {
	 int dir=0;
	private JLabel label;
	private JFrame frame;
	private JButton dire;
	private JButton addpatient;
	private JButton adddiagnosis;
	private JButton fullhistorypatient;
	private JButton updatepatientrecord;
	private JButton hospitalinfo;
	private JButton logout;
	private ImageIcon direimage;
	private ImageIcon addimage;
	private ImageIcon diagnosisimage;
	private ImageIcon historyimage;
	private ImageIcon updateimage;
	private ImageIcon infoimage;
	private ImageIcon logoutimage;
	private ImageIcon labelimage;
	public home()
	{
		frame=new JFrame();
		frame.setLayout(null);
		
		label=new JLabel();
		label.setBounds(0, 0, 1400, 700);
		labelimage=new ImageIcon("C:\\\\Users\\\\miki\\\\Desktop\\\\HMS ICON\\home.jpg");
		label.setIcon(labelimage);
	
		
	frame.setSize(1400,700);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setUndecorated(true);
	
	direimage=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\two arrow.png");

	
	dire=new JButton();
	dire.setBounds(0, 10, 80, 50);
	dire.setIcon(direimage);
	
	dire.setFocusable(false);
	
	dire.addActionListener( new ActionListener () {
	public void actionPerformed(ActionEvent e)
	{
	 
	  
	  if(dir==0)
	  {
		  dire.setLocation(10, 10);
		  addpatient.setLocation(120,10);
		  adddiagnosis.setLocation(350,10);
		  fullhistorypatient.setLocation(580,10);
		  updatepatientrecord.setLocation(810,10);
		  hospitalinfo.setLocation(1040,10);
		  logout.setLocation(1040,70);
		  
		   dir=1;
	  }
	  
	  else
	  {
		  dire.setLocation(0, 10);
		  addpatient.setLocation(0,70);
		  adddiagnosis.setLocation(0,130);
		  fullhistorypatient.setLocation(0,190);
		  updatepatientrecord.setLocation(0,250);
		  hospitalinfo.setLocation(0,310);
		  logout.setLocation(0,370);
		  
		   dir=0;
	  }
	}
	});
	
	addimage=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\add new patient.png");
	addpatient=new JButton("AddPatient");
	addpatient.setBounds(0, 80, 220, 50);
	addpatient.setIcon(addimage);
	addpatient.setFocusable(false);
	
	addpatient.addActionListener( new ActionListener () {
		public void actionPerformed(ActionEvent e)
		{
		      new patientrecord();
		}
		});
		
	diagnosisimage=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\add diag.png");
	adddiagnosis=new JButton("DiagnosisInfo");
	adddiagnosis.setBounds(0, 140, 220, 50);
	adddiagnosis.setIcon(diagnosisimage);
	adddiagnosis.setFocusable(false);
	
	adddiagnosis.addActionListener( new ActionListener () {
		public void actionPerformed(ActionEvent e)
		{
		  new adddiagnosis();
		}
		});
	
	historyimage=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\rsz_history1.png");
	fullhistorypatient=new JButton("Full History Of Patient");
	fullhistorypatient.setBounds(0, 200, 220, 50);
	fullhistorypatient.setIcon(historyimage);
	fullhistorypatient.setFocusable(false);
	
	fullhistorypatient.addActionListener( new ActionListener () {
		public void actionPerformed(ActionEvent e)
		{
			new fullpatienthistory();
		}
		});
	
	updateimage=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\rsz_update_details.png");
	updatepatientrecord=new JButton("Update Patient Record");
	updatepatientrecord.setBounds(0, 260, 220, 50);
	updatepatientrecord.setIcon(updateimage);
	updatepatientrecord.setFocusable(false);
	
	updatepatientrecord.addActionListener( new ActionListener () {
		public void actionPerformed(ActionEvent e)
		{
		  new updatepatientrecord();
		}
		});
	
	infoimage=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\rsz_hospital_information.png");
	hospitalinfo=new JButton("Hospital Info");
	hospitalinfo.setBounds(0, 320, 220, 50);
	hospitalinfo.setIcon(infoimage);
	hospitalinfo.setFocusable(false);
	
	hospitalinfo.addActionListener( new ActionListener () {
		public void actionPerformed(ActionEvent e)
		{
			new hospitalinfo();
		}
		});
	
	logoutimage=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\exit.png");
	logout=new JButton("Logout");
	logout.setBounds(0, 380, 220, 50);
	logout.setIcon(logoutimage);
	logout.setFocusable(false);
	
	logout.addActionListener( new ActionListener () {
		public void actionPerformed(ActionEvent e)
		{
		  int log =JOptionPane.showConfirmDialog(null,"DO You Want To Close This Application","selection",JOptionPane.YES_NO_OPTION);
		  if(log==0)
		  {
			  new login();
			  frame.setVisible(false);
		  }
		}
		});
	
	
	
	frame.add(logout);
	frame.add(hospitalinfo);
	frame.add(updatepatientrecord);
	frame.add(fullhistorypatient);
	frame.add(adddiagnosis);
	frame.add(addpatient);
	frame.add(dire);
	frame.add(label);
	
	frame.setVisible(true);
	}
	public static void main(String[] args) {
		home Home=new home();
		

	}

}
