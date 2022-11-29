import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class introGUI implements ActionListener{
		 
	JFrame mainmenuframe = new JFrame();
	
	ImageIcon bwdlogo = new ImageIcon(getClass().getResource("BWD.png"));
	
	JTextField username = new JTextField(16);
	JTextField password = new JTextField(16);
	
	JButton submit = new JButton("Submit");
	JButton cancel = new JButton("Cancel");	
	
introGUI() throws FileNotFoundException{ //Creates a Frame
	
//Here is where we create and place the header Logo
JLabel headerlabel = new JLabel();
headerlabel.setBounds(5,5,280,40);

//Here we create the header
JPanel headerPanel = new JPanel();
headerPanel.setVisible(true);
headerPanel.setBackground(new Color(109,31,35));
headerPanel.setPreferredSize(new Dimension(1600,50));
headerPanel.setLayout(null);


//Here we create the center panel of the page
JPanel centerPanel = new JPanel();
centerPanel.setVisible(true);
centerPanel.setBackground(new Color(235, 235, 235));
centerPanel.setPreferredSize(new Dimension(1600,500));
centerPanel.setLayout(null);

//Main heading of the page
JLabel centerlabel1 = new JLabel();
centerlabel1.setForeground(new Color(21, 36, 74));
centerlabel1.setFont(new Font("Proxima Nova", Font.PLAIN, 18));
centerlabel1.setText("<html><font face=\"Arial\" size=\"28\"> Bard Water Order Program</font><br/>"
		+ "Login/Create an Account Below </html>");
centerlabel1.setBounds(500,0,1200,100);


//Add the BWD logo to the page
JLabel centerlabel2 = new JLabel();
centerlabel2.setIcon(bwdlogo);
centerlabel2.setBounds(25,0,400,100);

//username text field
username.setBounds(500, 200, 400, 50);
username.setForeground(Color.black);
username.setText("Enter Username");

//password text field
password.setBounds(500, 300, 400, 50);
password.setForeground(Color.black);
password.setText("Enter Password");

//submit button
submit.setBounds(500, 400, 100, 50);
submit.addActionListener(this);

//cancel button
cancel.setBounds(800, 400, 100, 50);
cancel.addActionListener(this);

//Here we add information in the footer
JLabel footerlabel = new JLabel();
footerlabel.setForeground(Color.white);
footerlabel.setText("");
footerlabel.setVerticalAlignment(JLabel.CENTER);
footerlabel.setHorizontalAlignment(JLabel.CENTER);

//Here we create the footer
JPanel footerPanel = new JPanel();
footerPanel.setBackground(new Color(109,31,35));
footerPanel.setPreferredSize(new Dimension(1600,75));
footerPanel.setLayout(new BorderLayout());


mainmenuframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Exit out of program
mainmenuframe.setExtendedState(JFrame.MAXIMIZED_BOTH); //Set frame to full screen
mainmenuframe.setLayout(new BorderLayout());
mainmenuframe.setResizable(true); //Prevent frame from being resized
mainmenuframe.setVisible(true); // Make the frame visible
mainmenuframe.getContentPane().setBackground(Color.white); //Set background color


mainmenuframe.add(headerPanel,BorderLayout.NORTH); //Add header
headerPanel.add(headerlabel); //Add UA logo to header


mainmenuframe.add(centerPanel,BorderLayout.CENTER);
centerPanel.add(centerlabel1);
centerPanel.add(centerlabel2);
centerPanel.add(username);
centerPanel.add(password);
centerPanel.add(submit);
centerPanel.add(cancel);


mainmenuframe.add(footerPanel,BorderLayout.SOUTH);//Add footer
footerPanel.add(footerlabel);


}

@Override
public void actionPerformed(ActionEvent e) {
if (e.getSource() == submit) {
	username.getText();
	
	//Check that username is valid
//	if (username.getText() = ) {
//	}
//	else
//	{
//		username.setText("Username Invalid");
//	}
	password.getText();
	
	//check that password is valid
//	if (password.getText() = ) {
//	}
//	else
//	{
//		password.setText("Password Invalid");
//	}
	
	submit.setEnabled(false);
	
	//username and password valid, open up the water order page
//	waterorderPage waterorderpage = new waterorderPage();
	
	}
else {
	username.setText("");
	password.setText("");
}
		
if (e.getSource()== cancel) {
	username.setText("");
	password.setText("");
	submit.setEnabled(true);
			
	}
	
}

}



