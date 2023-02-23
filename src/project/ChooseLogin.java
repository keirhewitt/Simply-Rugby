package project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 * This is the first Screen the User will be presented with 
 * 
 * They User can choose either a Coach Login or a Membership Secretary Login
 * 
 * @author Keir
 * @since 29/03/21
 */
public class ChooseLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private ImageIcon background_img = new ImageIcon("");
	private ImageIcon background_img2 = new ImageIcon("");
	
	private JLabel lblRugbyLogo = new JLabel();
	
	private Controller myController;

	public ChooseLogin(Controller cont) {
		
		myController = cont;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCoachLogin = new JButton("Coach");
		btnCoachLogin.setBackground(new Color(205, 92, 92));
		btnCoachLogin.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCoachLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginScreen LS = new LoginScreen(cont);
				LS.setLocationRelativeTo(null);
				LS.setVisible(true);
			}
			
		});
		btnCoachLogin.setBounds(713, 246, 221, 102);
		contentPane.add(btnCoachLogin);
		
		JButton btnMemberLogin = new JButton("Membership Secretary");
		btnMemberLogin.setBackground(new Color(60, 179, 113));
		btnMemberLogin.setFont(new Font("Dialog", Font.BOLD, 16));
		btnMemberLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MemberLoginScreen MLS = new MemberLoginScreen(cont);
				MLS.setLocationRelativeTo(null);
				MLS.setVisible(true);
				
			}
			
		});
		btnMemberLogin.setBounds(127, 246, 221, 102);
		contentPane.add(btnMemberLogin);
		
		JLabel lblNewLabel_1 = new JLabel("For administrative secretary positions");
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(72, 359, 328, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("For squad coaches");
		lblNewLabel_1_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.ITALIC, 18));
		lblNewLabel_1_1.setBounds(698, 359, 254, 32);
		contentPane.add(lblNewLabel_1_1);
		
		/*
		 	Image for the bottom login section
		 */
		background_img = new ImageIcon("loginrugbyball.jpg");
		Image theImage1 = background_img.getImage();
		Image newimg1 = theImage1.getScaledInstance(1084, 511,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background_img = new ImageIcon(newimg1);
		
		/*
		 	Get the Image, cast as 'Image' type then resize it and cast it back to 'ImageIcon'
		 */
		background_img2 = new ImageIcon("rugbylogo.png");
		Image theImage2 = background_img2.getImage();
		Image newimg2 = theImage2.getScaledInstance(210, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background_img2 = new ImageIcon(newimg2);
		
		/*
		 	Set the labels to be the image
		 */
		
		JButton btnExitProgram = new JButton("Exit");
		btnExitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				myController.getModel().serializeCoaches();
				myController.getModel().serializeMembershipSecretary();
				myController.getModel().serializePlayers();
				myController.getModel().serializeSquads();
				myController.getModel().serializeTrainingSessions();
				
				System.exit(0);
			}
		});
		btnExitProgram.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnExitProgram.setBounds(881, 469, 145, 31);
		contentPane.add(btnExitProgram);
		lblRugbyLogo = new JLabel("", background_img2 , JLabel.CENTER);
		lblRugbyLogo.setBounds(427, 203, 210, 180);
		contentPane.add(lblRugbyLogo);
		
		JLabel lblNewLabel = new JLabel("Simply Rugby");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 37));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(356, 67, 347, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblLoginImage = new JLabel("", background_img, JLabel.CENTER);
		lblLoginImage.setBounds(0, 0, 1084, 511);
		contentPane.add(lblLoginImage);
		lblLoginImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblRugbyLogo.setVisible(true);
		
		
	}
}
