package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Handles the login for Coach users
 * 
 * @author Keir
 * @since 12/04/21
 */
public class LoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Controller myController;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField textLoginID;
	private JPasswordField textPass;
	private JButton btnLogin;
	private JButton btnBack;
	private JLabel lblNewLabel;
	private JLabel lblCoachLoginImage;
	
	private ImageIcon background_img = new ImageIcon();
	private JLabel lblLoginID;
	private JLabel lblEnterPassword;


	public LoginScreen(Controller control) {
		
		myController = control;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(10, 11, 532, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textLoginID = new JTextField();
		textLoginID.setFont(new Font("Dialog", Font.PLAIN, 16));
		textLoginID.setBounds(42, 221, 282, 31);
		panel.add(textLoginID);
		textLoginID.setColumns(10);
		
		textPass = new JPasswordField();
		textPass.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPass.setBounds(42, 277, 282, 31);
		panel.add(textPass);
		textPass.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 	If the validateInput() function returned true, send values to be checked with coach records
				 */
				if (validateInput() == true) {
					boolean login = myController.validateCoachLogin(Integer.parseInt(textLoginID.getText()), String.valueOf(textPass.getPassword()));
					
					/*
					 	If check against coach records came back positive, dispose this screen
					 */
					if (login) {
						dispose();
					}
					else {
						/*
						 	If not, display message and set both boxes to empty
						 */
						displayMessage("Login failed, try again");
						textLoginID.setText("");
						textPass.setText("");
					}
				} else {
					displayMessage("Please enter an ID and password and try again. Ensure ID is a number");
				}
				
			}
			
		});
		btnLogin.setBounds(42, 319, 114, 31);
		panel.add(btnLogin);
		
		/**
		 * Takes the user back to the ChooseLogin Screen
		 */
		btnBack = new JButton("Back");
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
		btnBack.setBounds(10, 447, 108, 31);
		panel.add(btnBack);
		
		lblNewLabel = new JLabel("Enter your login details..");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(42, 34, 382, 39);
		panel.add(lblNewLabel);
		
		lblLoginID = new JLabel("Enter Login ID");
		lblLoginID.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblLoginID.setBounds(42, 204, 97, 14);
		panel.add(lblLoginID);
		
		lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblEnterPassword.setBounds(42, 263, 97, 14);
		panel.add(lblEnterPassword);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 128, 128));
		panel_1.setBounds(542, 11, 532, 489);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		background_img = new ImageIcon("rugbyballreal.jpg");
		Image theImage = background_img.getImage();
		Image newimg = theImage.getScaledInstance(532, 489,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background_img = new ImageIcon(newimg);
		
		lblCoachLoginImage = new JLabel("", background_img, JLabel.CENTER);
		lblCoachLoginImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoachLoginImage.setBounds(0, 0, 532, 489);
		panel_1.add(lblCoachLoginImage);
		
	}
	
	/**
	 * Quick input validation to ensure the right value types are being entered
	 * @return boolean 
	 */
	private boolean validateInput()
	{
		boolean retval = true;
		char[] password = textPass.getPassword();
		
		/*
		 	Check if loginID text box is empty
		 */
		if(textLoginID.getText().equals("")) {
			retval = false;
		}
		else {
			try {
				/*
					Parse loginID text box as integer, if exception is caught, set retval to false
				 */
				Integer.parseInt(textLoginID.getText());
			} catch (Exception e) {
				// just set retval to false 
				retval = false;
			}
		}
		
		/*
		 	Check is password text box is empty
		 */
		if(String.valueOf(password).isEmpty()){
			retval = false;
		}
		return retval;
	
	}
	
	// Making messages to user for accessible
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	


}
