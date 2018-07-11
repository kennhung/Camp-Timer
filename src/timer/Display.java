package timer;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Display extends JFrame {

	private JPanel contentPane;
	public static JLabel lblMin = new JLabel("0");
	public static JLabel lblSec = new JLabel("00");
	
	public static JLabel jlRTeam1 = new JLabel("0000");
	public static JLabel jlRTeam2 = new JLabel("0000");
	public static JLabel jlRTeam3 = new JLabel("0000");
	public static JLabel jlBTeam1 = new JLabel("0000");
	public static JLabel jlBTeam2 = new JLabel("0000");
	public static JLabel jlBTeam3 = new JLabel("0000");
	public static JLabel label = new JLabel(":");
	
	public static JLabel lbMatchID = new JLabel("XX");
	
	public static JPanel jpTimer = new JPanel();
	private static JPanel panel_2 = new JPanel();
	private static JPanel panel_3 = new JPanel();
	public static JLabel lblStatus = new JLabel("No Match");
	

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Display() {
		
		int width = 1280;
		int heigh = 720;
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, width, heigh);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {width, 0, -678, 0};
		gbl_contentPane.rowHeights = new int[] {524, 211, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		

		jpTimer.setBackground(Color.WHITE);
		GridBagConstraints gbc_jpTimer = new GridBagConstraints();
		gbc_jpTimer.insets = new Insets(0, 0, 5, 5);
		gbc_jpTimer.gridx = 0;
		gbc_jpTimer.gridy = 0;
		contentPane.add(jpTimer, gbc_jpTimer);
		jpTimer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		jpTimer.add(lblMin);
		lblMin.setFont(new Font("Ubuntu", Font.BOLD, 250));
		
		
		label.setFont(new Font("Ubuntu", Font.BOLD, 250));
		jpTimer.add(label);
		
		
		lblSec.setFont(new Font("Ubuntu", Font.BOLD, 250));
		jpTimer.add(lblSec);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{769, 0};
		gbl_panel_1.rowHeights = new int[]{125, 51, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_3.setBackground(Color.WHITE);
		panel_1.add(panel_3, gbc_panel_3);
		panel_3.add(lbMatchID);
		
		lbMatchID.setFont(new Font("Ubuntu", Font.BOLD, 99));
		
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2, gbc_panel_2);
		lblStatus.setFont(new Font("Ubuntu", Font.BOLD, 25));
		
		panel_2.add(lblStatus);
		
		JPanel jpRedAlliance = new JPanel();
		jpRedAlliance.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		jpRedAlliance.setBackground(Color.WHITE);
		panel.add(jpRedAlliance, BorderLayout.WEST);
		jpRedAlliance.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblRedAlliance = new JLabel("Red Alliance");
		lblRedAlliance.setForeground(Color.RED);
		lblRedAlliance.setFont(new Font("Ubuntu", Font.BOLD, 40));
		jpRedAlliance.add(lblRedAlliance);
		
		
		jlRTeam1.setFont(new Font("Ubuntu", Font.BOLD, 30));
		jpRedAlliance.add(jlRTeam1);
		

		jlRTeam2.setFont(new Font("Ubuntu", Font.BOLD, 30));
		jpRedAlliance.add(jlRTeam2);
		

		jlRTeam3.setFont(new Font("Ubuntu", Font.BOLD, 30));
		jpRedAlliance.add(jlRTeam3);
		
		JPanel jpBlueAlliance = new JPanel();
		jpBlueAlliance.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		jpBlueAlliance.setBackground(Color.WHITE);
		panel.add(jpBlueAlliance, BorderLayout.EAST);
		jpBlueAlliance.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblBlueAlliance = new JLabel("Blue Alliance");
		lblBlueAlliance.setForeground(Color.BLUE);
		jpBlueAlliance.add(lblBlueAlliance);
		lblBlueAlliance.setFont(new Font("Ubuntu", Font.BOLD, 40));
		

		jlBTeam1.setFont(new Font("Ubuntu", Font.BOLD, 30));
		jpBlueAlliance.add(jlBTeam1);
		

		jlBTeam2.setFont(new Font("Ubuntu", Font.BOLD, 30));
		jpBlueAlliance.add(jlBTeam2);
		

		jlBTeam3.setFont(new Font("Ubuntu", Font.BOLD, 30));
		jpBlueAlliance.add(jlBTeam3);
	}

}
