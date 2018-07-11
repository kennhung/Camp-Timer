package timer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class timer_main {
	
	private JFrame frmSimpleMatch;
	
	static Thread display;
	public static Timer timer;
	public static Thread timerThread;
	
	static JLabel lblSec = new JLabel("00");
	static JLabel lblMin = new JLabel("0");
	public static JButton btnReset;
	public static JButton btnStart;
	public static JLabel lblStatus = new JLabel("Status");
	
	private static Display audienceDisp;
	private static final int countDownTime = 180;
	private JTextField textFieldB1;
	private JTextField textFieldB2;
	private JTextField textFieldB3;
	private JTextField textFieldR3;
	private JTextField textFieldR2;
	private JTextField textFieldR1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private static JTextField textFieldMatchID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		btnStart  = new JButton("Start");
		btnReset  = new JButton("Reset");
		btnReset.setEnabled(false);
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(timer.started && timer.pause) {
					timer.stop();
					timer = new Timer(countDownTime);
					timerThread = new Thread(timer);
					btnStart.setText("Start");
					btnStart.setEnabled(true);
					setDisplay();
					resetNumber();
				}
				else if(timer.started && !timer.finished) {
					sound.Match_Pause_normalized();
					timer.pause();
					timer.stop();
					timer = new Timer(countDownTime);
					timerThread = new Thread(timer);
//					btnReset.setEnabled(false);
					btnStart.setText("Start");
					btnStart.setEnabled(true);
					setDisplay();
					resetNumber();
				}
				else if(timer.finished) {
					timer.stop();
					timer = new Timer(countDownTime);
					timerThread = new Thread(timer);
					btnReset.setEnabled(false);
					btnStart.setText("Start");
					btnStart.setEnabled(true);
					setDisplay();
					resetNumber();
				}
				else{
					timer = new Timer(countDownTime);
					timerThread = new Thread(timer);
					btnReset.setEnabled(false);
					btnStart.setText("Start");
					btnStart.setEnabled(true);
					setDisplay();
					resetNumber();
				}
				
			}
		});
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					timer_main window = new timer_main();
					window.frmSimpleMatch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public timer_main() {
		initialize();
		timer = new Timer(countDownTime);
		timerThread = new Thread(timer);
		setDisplay();
		resetNumber();
	}
	
	public static void resetNumber() {
		lblSec.setText(String.valueOf(countDownTime%60));
		lblMin.setText(String.valueOf(countDownTime/60));
		
		Display.lblSec.setText(String.valueOf(countDownTime%60));
		Display.lblMin.setText(String.valueOf(countDownTime/60));
	}
	
	public static void setDisplay() {
		Display.label.setForeground(new Color(51,51,51));
		Display.lblMin.setForeground(new Color(51,51,51));
		Display.lblSec.setForeground(new Color(51,51,51));
		Display.jpTimer.setBackground(Color.WHITE);

		display = new Thread(new Runnable(){
			
			@Override
			public void run() {
				
				boolean endSound = true;
				
				while(true) {
					if(timer.getSec()<10) lblSec.setText("0"+String.valueOf(timer.getSec()));
					else lblSec.setText(String.valueOf(timer.getSec()));
					lblMin.setText(String.valueOf(timer.getMin()));					
					
					if(timer.getSec()<10) Display.lblSec.setText("0"+String.valueOf(timer.getSec()));
					else Display.lblSec.setText(String.valueOf(timer.getSec()));
					Display.lblMin.setText(String.valueOf(timer.getMin()));		
					
					if(timer.getMin()*60+timer.getSec()<30&&!timer.pause) {
						Display.jpTimer.setBackground(Color.yellow);
						if(endSound&&timer.started) {
							sound.Start_of_End_Game_normalized();
							endSound = false;
						}
					}
					else if (timer.finished) Display.jpTimer.setBackground(Color.red);
					else if (timer.pause) Display.jpTimer.setBackground(Color.ORANGE);
					else Display.jpTimer.setBackground(Color.WHITE);
					
					if(textFieldMatchID.getText().isEmpty()) Display.lblStatus.setText("No Match");
					else Display.lblStatus.setText("");
					
					if(timer.pause) Display.lblStatus.setText("Match Paused");
					else Display.lblStatus.setText("");
					
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(timer.finished) {
						sound.Match_End_normalized();
						btnStart.setText("Start");
						btnStart.setEnabled(false);
						break;
					}
				}
				
			}
			
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimpleMatch = new JFrame();
		frmSimpleMatch.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			    int result=JOptionPane.showConfirmDialog(null,
			               "確定要結束程式嗎?",
			               "確認訊息",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.WARNING_MESSAGE);
			    if (result==JOptionPane.YES_OPTION) {
			    	System.exit(0);
			    }
			}
		});
		frmSimpleMatch.setTitle("Simple Match Timer  Control");
		frmSimpleMatch.setBounds(100, 100, 504, 721);
		frmSimpleMatch.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		frmSimpleMatch.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		
		textFieldMatchID = new JTextField();
		panel_4.add(textFieldMatchID);
		textFieldMatchID.setColumns(10);
		
		JButton btnUpdateData = new JButton("Update Data");
		panel_4.add(btnUpdateData);
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblRed = new JLabel("Red");
		panel_2.add(lblRed);
		
		textFieldR1 = new JTextField();
		panel_2.add(textFieldR1);
		textFieldR1.setColumns(7);
		
		textFieldR2 = new JTextField();
		panel_2.add(textFieldR2);
		textFieldR2.setColumns(7);
		
		textFieldR3 = new JTextField();
		panel_2.add(textFieldR3);
		textFieldR3.setColumns(7);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		
		JLabel lblBlue = new JLabel("Blue");
		panel_3.add(lblBlue);
		
		textFieldB1 = new JTextField();
		panel_3.add(textFieldB1);
		textFieldB1.setColumns(7);
		
		textFieldB2 = new JTextField();
		panel_3.add(textFieldB2);
		textFieldB2.setColumns(7);
		
		textFieldB3 = new JTextField();
		panel_3.add(textFieldB3);
		textFieldB3.setColumns(7);
		
		JPanel panel = new JPanel();
		frmSimpleMatch.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnDisplayTimer = new JButton("Display Timer");
		btnDisplayTimer.setBounds(131, 396, 186, 27);
		panel.add(btnDisplayTimer);
		
		JPanel timer_display = new JPanel();
		timer_display.setBounds(39, 226, 416, 77);
		panel.add(timer_display);
		timer_display.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblMin.setFont(new Font("Ubuntu", Font.BOLD, 60));
		timer_display.add(lblMin);
		
		JLabel lblcolon = new JLabel(":");
		lblcolon.setFont(new Font("Ubuntu", Font.BOLD, 60));
		timer_display.add(lblcolon);
		
		lblSec.setFont(new Font("Ubuntu", Font.BOLD, 60));
		timer_display.add(lblSec);
		
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(timer.started && !timer.pause) {
					System.out.println(Thread.currentThread().getName()+":"+"Timer paused");
					timer.pause();
					sound.Match_Pause_normalized();
					btnStart.setText("Resume");
				}
				else if(timer.pause && timer.started) {
					System.out.println(Thread.currentThread().getName()+":"+"Timer resumed");
					timer.resume();
					sound.Start_Teleop_normalized();
					btnStart.setText("Pause");
				}
				else {
					System.out.println("Timer started");
					timerThread.start();
					display.start();
					btnStart.setText("Pause");
					btnReset.setEnabled(true);
				}
			}
		});
		btnStart.setBounds(92, 131, 99, 50);
		panel.add(btnStart);
		
		btnReset.setBounds(284, 131, 99, 50);
		panel.add(btnReset);
		
		JButton btnOpenTimerWindow = new JButton("Open Timer window");
		btnOpenTimerWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							audienceDisp = new Display();
							audienceDisp.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				btnOpenTimerWindow.setEnabled(false);
			}
		});
		btnOpenTimerWindow.setBounds(131, 357, 186, 27);
		panel.add(btnOpenTimerWindow);
		
		lblStatus.setBounds(191, 69, 105, 33);
		panel.add(lblStatus);
		
		
		btnUpdateData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Display.jlBTeam1.setText(textFieldB1.getText());
				Display.jlBTeam2.setText(textFieldB2.getText());
				Display.jlBTeam3.setText(textFieldB3.getText());
				Display.jlRTeam1.setText(textFieldR1.getText());
				Display.jlRTeam2.setText(textFieldR2.getText());
				Display.jlRTeam3.setText(textFieldR3.getText());
				Display.lbMatchID.setText(textFieldMatchID.getText());
				if(textFieldMatchID.getText().isEmpty()) Display.lblStatus.setText("No Match");
				else Display.lblStatus.setText("");
			}
		});
	}
}
