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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class waterorderGUI implements ActionListener{
		 
	JFrame mainmenuframe = new JFrame();
	
	ImageIcon bwdlogo = new ImageIcon(getClass().getResource("BWD.png"));
	
	JTextField growername = new JTextField(12);
	JTextField landacreage = new JTextField(12);
	JTextField waterrequest = new JTextField(12);
	JTextField waterhours = new JTextField(12);
	
	String[] croptypes = {"Lettuce", "Broccoli", "Cantaloupe", "Cabbage", "Dates"};
	JComboBox croptype = new JComboBox(croptypes);
	
	String[] lifecycles = {"Seed", "Sprout", "Adolescence", "Adult"};
	JComboBox lifecycle = new JComboBox(lifecycles);
	
	String[] soiltypes = {"Sandy", "Peaty", "Silty", "Chalky", "Clay", "Loamy"};
	JComboBox soiltype = new JComboBox(soiltypes);
	
	JButton submit = new JButton("Submit");
	JButton cancel = new JButton("Cancel");	
	
waterorderGUI() throws FileNotFoundException{ //Creates a Frame
	
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
		+ "Fill out water card information below. </html>");
centerlabel1.setBounds(500,0,1200,100);


//Add the BWD logo to the page
JLabel centerlabel2 = new JLabel();
centerlabel2.setIcon(bwdlogo);
centerlabel2.setBounds(25,0,300,100);

//growername text field
growername.setBounds(200, 200, 200, 50);
growername.setForeground(Color.black);

JLabel growerlabel = new JLabel();
growerlabel.setBounds(200,150,200,50);
growerlabel.setForeground(new Color(21, 36, 74));
growerlabel.setFont(new Font("Arial", Font.PLAIN, 14));
growerlabel.setText("<html> Enter grower name:</html>");

//land acreage text field
landacreage.setBounds(450, 200, 200, 50);
landacreage.setForeground(Color.black);

JLabel acrelabel = new JLabel();
acrelabel.setBounds(450,150,200,50);
acrelabel.setForeground(new Color(21, 36, 74));
acrelabel.setFont(new Font("Arial", Font.PLAIN, 14));
acrelabel.setText("<html> Enter acreage to be irrigated:</html>");

//crop type drop down menu
croptype.setBounds(700, 200, 200, 50);
croptype.setForeground(Color.black);
croptype.setEditable(true);
croptype.setSelectedIndex(0);

JLabel croplabel = new JLabel();
croplabel.setBounds(700,150,200,50);
croplabel.setForeground(new Color(21, 36, 74));
croplabel.setFont(new Font("Arial", Font.PLAIN, 14));
croplabel.setText("<html> Select crop type:</html>");

//crop type drop down menu
lifecycle.setBounds(950, 200, 200, 50);
lifecycle.setForeground(Color.black);
lifecycle.setEditable(true);

JLabel lifelabel = new JLabel();
lifelabel.setBounds(950,150,200,50);
lifelabel.setForeground(new Color(21, 36, 74));
lifelabel.setFont(new Font("Arial", Font.PLAIN, 14));
lifelabel.setText("<html> Select lifecycle of crop:</html>");

//waterrequest text field
waterrequest.setBounds(300, 350, 200, 50);
waterrequest.setForeground(Color.black);

JLabel waterreqlabel = new JLabel();
waterreqlabel.setBounds(300,300,200,50);
waterreqlabel.setForeground(new Color(21, 36, 74));
waterreqlabel.setFont(new Font("Arial", Font.PLAIN, 14));
waterreqlabel.setText("<html> Enter CFS:</html>");

//water hours text field
waterhours.setBounds(550, 350, 200, 50);
waterhours.setForeground(Color.black);

JLabel hourslabel = new JLabel();
hourslabel.setBounds(550,300,200,50);
hourslabel.setForeground(new Color(21, 36, 74));
hourslabel.setFont(new Font("Arial", Font.PLAIN, 14));
hourslabel.setText("<html> Enter water hours:</html>");

//crop type drop down menu
soiltype.setBounds(800, 350, 200, 50);
soiltype.setForeground(Color.black);
soiltype.setEditable(true);

JLabel soillabel = new JLabel();
soillabel.setBounds(800,300,200,50);
soillabel.setForeground(new Color(21, 36, 74));
soillabel.setFont(new Font("Arial", Font.PLAIN, 14));
soillabel.setText("<html> Enter Soil Type:</html>");

//submit button
submit.setBounds(450, 500, 100, 50);
submit.addActionListener(this);

//cancel button
cancel.setBounds(750, 500, 100, 50);
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
centerPanel.add(growername);
centerPanel.add(growerlabel);
centerPanel.add(landacreage);
centerPanel.add(acrelabel);
centerPanel.add(waterrequest);
centerPanel.add(waterreqlabel);
centerPanel.add(waterhours);
centerPanel.add(hourslabel);
centerPanel.add(submit);
centerPanel.add(croptype);
centerPanel.add(croplabel);
centerPanel.add(lifecycle);
centerPanel.add(lifelabel);
centerPanel.add(soiltype);
centerPanel.add(soillabel);
centerPanel.add(cancel);


mainmenuframe.add(footerPanel,BorderLayout.SOUTH);//Add footer
footerPanel.add(footerlabel);


}

@Override
public void actionPerformed(ActionEvent e) {
if (e.getSource() == submit) {
	growername.getText();
	
	//Check that username is valid
//	if (growername.getText() = ) {
//	}
//	else
//	{
//		growername.setText("Username Invalid");
//	}
	landacreage.getText();
	
	//check that password is valid
//	if (landacreage.getText() = ) {
//	}
//	else
//	{
//		password.setText("Password Invalid");
//	}
	waterrequest.getText();
		
		//check that password is valid
	//	if (waterrequest.getText() = ) {
	//	}
	//	else
	//	{
	//		password.setText("Password Invalid");
	//	}
	waterhours.getText();
	
	//check that password is valid
	//if (waterhours.getText() = ) {
	//}
	//else
	//{
	//	password.setText("Password Invalid");
	//}
	croptype.getSelectedItem();
	
	lifecycle.getSelectedItem();
	
	soiltype.getSelectedItem();
	
	submit.setEnabled(false);
	
	//username and password valid, open up the water order page
//	waterorderPage waterorderpage = new waterorderPage();
	
	}
else {
	growername.setText("");
	landacreage.setText("");
	waterrequest.setText("");
	waterhours.setText("");
}
		
if (e.getSource()== cancel) {
	growername.setText("");
	landacreage.setText("");
	waterrequest.setText("");
	waterhours.setText("");
	submit.setEnabled(true);
			
	}
	
}

}



