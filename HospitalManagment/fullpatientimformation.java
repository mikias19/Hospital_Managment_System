package hospitalmangment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class hospitalinfo {
	private JLabel label1;
	private ImageIcon label1image;
	private JLabel label;
   private ImageIcon image;
	private JFrame frame;
	private JTextArea textarea;
	private String text="A hospital Mangement System (HMS) is element of health informatics \nthat focus mainly "
	+" on the adminstration lead of hospital. and also \nthese systems enhance the ability of health  "
	+"care professionals to \ncoordinate care by providing apatient health information and visit \nhistory at palce and time that is needed.  ";
	private ImageIcon closeicon;
	private JButton closebutton;
	public hospitalinfo()
	{

		frame=new JFrame();
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,480);
		frame.setUndecorated(true);
		frame.setLocation(350, 50);
		
		label1image=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\add new patient background.jpg");
		label1=new JLabel();
		label1.setIcon(label1image);
		label1.setBounds(0, 0, 750, 500);
		
		
		
		image=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\info.jpeg");
		
		label=new JLabel();
		label.setIcon(image);
		label.setBounds(0, 0, 400, 200);
		label.setLocation(150,50);
		
		textarea=new JTextArea();
		textarea.setBounds(30, 280, 700, 110);
		
		textarea.setBackground(new Color(204,204,235));
		textarea.setFont(new Font("Monospaced",Font.BOLD,16));
		
		textarea.setText(text);
		
		closeicon=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\Close.png");
		closebutton=new JButton("Close");
		closebutton.setIcon(closeicon);
		closebutton.setBounds(560, 430, 90, 20);
		closebutton.setFocusable(false);
		closebutton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event)
			{
				frame.setVisible(false);
				new home();
			}
			
		});
			
		
		frame.add(closebutton);
		frame.add(textarea);
	frame.add(label);
	frame.add(label1);
	frame.setVisible(true);	
		
	}
	
	
	
	public static void main(String[] args) {
		new hospitalinfo();

	}

}
