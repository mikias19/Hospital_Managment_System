package hospitalmangment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.*;

public class login extends JFrame {
	private ImageIcon image;
	private JFrame frame;
	private JLabel label3;
	private JButton login;
	private JButton close;
	private JTextField textfield;
	private JPasswordField passwordfield;
	private JLabel label1;
	private JLabel label2;
	private ImageIcon loginicon;
	private ImageIcon closeicon;
	private JButton reset;
	public login()
	{
	
		frame=new JFrame();
		frame.setLayout(null);
		frame.setUndecorated(true);
		
		
		label1=new JLabel();
		label1.setText("UserName");
		label1.setFont(new Font("Tahoma ",Font.BOLD,14));
		label1.setBounds(560, 300, 100, 30);
		label1.setVisible(false);
		label2=new JLabel();
		label2.setText("Password");
		label2.setFont(new Font("Tahoma ",Font.BOLD,14));
		label2.setBounds(560, 330, 100, 30);
		
		
		image=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\login Background final.png");
		label3=new JLabel();
		label3.setIcon(image);
		label3.setBounds(0,0,1400,750);
		
		textfield=new JTextField();
		textfield.setBounds(670, 310, 250, 20);
		textfield.setText("Enter UserName");
		
		
		passwordfield=new JPasswordField();
		passwordfield.setText("passwordd");
		passwordfield.setBounds(670,340, 250, 20);
		
		
		loginicon=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\login.png");
		
		login=new JButton();
		login.setIcon(loginicon);
		login.setText("login");
		login.setFocusable(false);
		login.setFont(new Font("Tahoma",Font.BOLD,14));
		login.setBounds(680, 370, 100, 20);
		login.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e)
			{
				if(textfield.getText().equals("hms")&&passwordfield.getText().equals("mikias1991"))
				{
					new home();
					
					frame.setVisible(false);
				}
		
				else 
					
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
					
			
				
			}
		}
		);
		
		closeicon=new ImageIcon("C:\\Users\\miki\\Desktop\\HMS ICON\\Close.png");
		
		close=new JButton();
		close.setIcon(closeicon);
		close.setText("close");
		close.setFocusable(false);
		close.setFont(new Font("Tahoma",Font.BOLD,14));
		close.setBounds(800, 370, 100, 20);   
		close.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e)
		
			{
				int a=JOptionPane.showConfirmDialog(null,"Do you Really Want To Close This Application","closing",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					System.exit(0);
				}
				
			}
		}
		);
		
		
		reset=new JButton("Reset");
		reset.setFocusable(false);
		reset.setFont(new Font ("Tahoma",Font.BOLD,14));
		reset.setBounds(740,400,100,20);
		reset.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e)
		
			{
				String na="";
				textfield.setText("");
			passwordfield.setText(na);
				
			}
		}
		);
		
		
		frame.setSize(1400,750);
		frame.add(reset);
		frame.add(close);
		frame.add(login);
		frame.add(textfield);
		frame.add(passwordfield);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.setVisible(true);

	}
	

	public static void main(String[] args) {
		
		new login();
		
	}

}
