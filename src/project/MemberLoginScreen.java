package project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Login screen for MembershipSecretary users
 * 
 * @author Keir
 * @since 19/04/21
 */

public class MemberLoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLoginID;
	private JPasswordField txtPassword;
	private ImageIcon background_img = new ImageIcon();
	
	private Controller myController;

	public MemberLoginScreen(Controller cont) {
		
		myController = cont;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(10, 11, 530, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/**
		 * Takes user back to ChooseLogin
		 */
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChooseLogin CL = new ChooseLogin(myController);
				CL.setLocationRelativeTo(null);
				CL.setVisible(true);
			}
			
		});
		btnBack.setBounds(10, 443, 116, 35);
		panel.add(btnBack);
		
		/*
		 	Get the Image, cast as 'Image' type then resize it and cast it back to 'ImageIcon'
		 */
		background_img = new ImageIcon("adminlogo.jpg");
		Image theImage = background_img.getImage();
		Image newimg = theImage.getScaledInstance(530, 489,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background_img = new ImageIcon(newimg);
		
		/*
		 	Set the JLabel as the ImageIcon
		 */
		JLabel lblAdminLogo = new JLabel("", background_img, JLabel.CENTER);
		lblAdminLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogo.setBounds(0, 0, 530, 489);
		panel.add(lblAdminLogo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 128, 128));
		panel_1.setBounds(538, 11, 536, 489);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter your login details..");
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setFont(new Font("Lato Light", Font.BOLD, 30));
		lblNewLabel.setBounds(31, 37, 368, 37);
		panel_1.add(lblNewLabel);
		
		txtLoginID = new JTextField();
		txtLoginID.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtLoginID.setBounds(31, 204, 301, 31);
		panel_1.add(txtLoginID);
		txtLoginID.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBounds(31, 260, 301, 31);
		panel_1.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			/*
			 	If the validateInput() function returned true, send values to be checked with membership secretary records
			 */
			if (validateInput() == true) {
				boolean login = myController.validateMemberLogin(Integer.parseInt(txtLoginID.getText()), String.valueOf(txtPassword.getPassword()));
				
				/*
				 	If check against membership secretary records came back positive, dispose this screen
				 */
				if (login) {
					dispose();
				}
				else {
					/*
					 	If not, display message and set both boxes to empty
					 */
					displayMessage("Login failed, try again");
					txtLoginID.setText("");
					txtPassword.setText("");
				}
			} else {
				displayMessage("Please enter an ID and password and try again. Ensure ID is a number");
			}
			
				
			}
			
		});
		btnLogin.setBounds(31, 352, 133, 37);
		panel_1.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("Login ID");
		lblNewLabel_2.setForeground(new Color(211, 211, 211));
		lblNewLabel_2.setFont(new Font("Lato Light", Font.ITALIC, 16));
		lblNewLabel_2.setBounds(31, 187, 75, 20);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setForeground(new Color(211, 211, 211));
		lblNewLabel_2_1.setFont(new Font("Lato Light", Font.ITALIC, 16));
		lblNewLabel_2_1.setBounds(31, 246, 75, 20);
		panel_1.add(lblNewLabel_2_1);
	}
	
	/**
	 * Quick input validation to ensure the right value types are being entered
	 * 
	 * @return boolean 
	 */
	private boolean validateInput()
	{
		boolean retval = true;
		
		/*
		 	Check if loginID text box is empty
		 */
		if(txtLoginID.getText().equals("")) {
			retval = false;
		}
		else {
			try {
				/*
					Parse loginID text box as integer, if exception is caught, set retval to false
				 */
				Integer.parseInt(txtLoginID.getText());
			} catch (Exception e) {
				// just set retval to false 
				retval = false;
			}
		}
		
		/*
		 	Check is password text box is empty
		 */
		if(String.valueOf(txtPassword.getPassword()).isEmpty()){
			retval = false;
		}
		return retval;
	
	}
	
	// Making messages to user for accessible
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
