package realTime_Traffic_Simulator;
/*
 * Class has been Written by Frank Sable, As on 28th /November /2015
 * You have no write to modify anything written here, unless you've
 * consulted me.
 */

/**
 *
 * @author Frankline Sable
 */
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SupportClass {

	private File file;
	private final JDialog frame;
	private JTextArea textArea;
	private JProgressBar progressBar;
	private Timer timer;
	private JPanel panel, panel2, textPanel;
	private final JButton nextButton,cancelButton;
	private JButton cancelButton2;
	private JButton nextButton2;
	private JLabel label, label1, label2, picLabel, picLabel2, labelFinal,exportIconLabel1, exportIconLabel2, exportIconLabel3,nameField,feedbackField;
	private final JList<Object> list;
	private final Icon exportIcon1, exportIcon2, exportIcon3,commentBig,sendingIcon,headIcon, iconx, icony,nextButtonIcon,cancelButtonIcon;
	private final String listItems[] = { "->Comment On Your  Experience", "->Send Crash Logs To The Developer" };
	private PrintStream write;
	private final  Border loweredBorder;
	private final TitledBorder borderTextArea;
	private JTextField textField,textField2,textField3;
	private PrintStream print;
    private final SystemTrayClass ty;
	
	
	public SupportClass() {

        ty=new SystemTrayClass();
            
		exportIcon1 = new ImageIcon(getClass().getResource("supportImages/export1.png"));
		exportIcon2 = new ImageIcon(getClass().getResource("supportImages/export2.png"));
		exportIcon3 = new ImageIcon(getClass().getResource("supportImages/export3.png"));
		
		iconx = new ImageIcon(getClass().getResource("supportImages/comment.png"));
		icony = new ImageIcon(getClass().getResource("supportImages/crashlogs.png"));
		
		headIcon = new ImageIcon(getClass().getResource("supportImages/bug.jpg"));
		sendingIcon = new ImageIcon(getClass().getResource("supportImages/telegram.png"));
		nextButtonIcon = new ImageIcon(getClass().getResource("supportImages/next.png"));
		cancelButtonIcon = new ImageIcon(getClass().getResource("supportImages/cancel.png"));
		commentBig = new ImageIcon(getClass().getResource("supportImages/commentBig.png"));

		exportIconLabel1 = new JLabel(exportIcon1);
		exportIconLabel2 = new JLabel(exportIcon2);
		exportIconLabel3 = new JLabel(exportIcon3);

		loweredBorder = BorderFactory.createLoweredBevelBorder();
		borderTextArea = BorderFactory.createTitledBorder(loweredBorder, "Sending Logs Files...", TitledBorder.ABOVE_TOP, TitledBorder.LEFT);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 585, 100);
		panel.setLayout(null);

		label = new JLabel();
		label.setIcon(headIcon);
		label.setBounds(435, 0, 150, 100);
		panel.add(label);

		label1 = new JLabel("Support Provider");
		label1.setFont(new Font("Serif", Font.BOLD, 30));
		label1.setBounds(0, 2, 250, 40);
		panel.add(label1);

		label2 = new JLabel("Select a support provider from the list:");
		label2.setFont(new Font("Serif", Font.PLAIN, 20));
		label2.setBounds(0, 60, 400, 40);
		panel.add(label2);

		nextButton = new JButton("Next",nextButtonIcon);
		nextButton.setHorizontalTextPosition(AbstractButton.LEFT);
		nextButton.setBounds(360, 210, 90, 30);
		nextButton.setBackground(SystemColor.activeCaptionBorder);
		nextButton.setFont(new Font("Serif", Font.PLAIN, 20));
		nextButton.setBorder(BorderFactory.createEmptyBorder());
		nextButton.addActionListener(new buttonHandler());
		nextButton.setEnabled(false);
		
		cancelButton = new JButton("Cancel",cancelButtonIcon);
		cancelButton.setHorizontalTextPosition(AbstractButton.LEFT);
		cancelButton.setBounds(480, 210, 90, 30);
		cancelButton.setBackground(nextButton.getBackground());
		cancelButton.setFont(nextButton.getFont());
		cancelButton.setBorder(nextButton.getBorder());
		cancelButton.addActionListener(new buttonHandler());

		panel2 = new JPanel();
		panel2.setBackground(new Color(250, 250, 210));
		panel2.setBorder(BorderFactory.createCompoundBorder(loweredBorder,BorderFactory.createLoweredBevelBorder()));
		panel2.setBounds(5, 100, 575, 100);
		panel2.setLayout(null);

		list = new JList<Object>(listItems);
		list.setFont(new Font("Serif", Font.PLAIN, 20));
		list.setBorder(BorderFactory.createEmptyBorder());
		list.setBounds(30,10, 350, 90);
		list.setBackground(panel2.getBackground());
		panel2.add(list);

		picLabel = new JLabel(iconx);
		picLabel.setBounds(2, 11, 24, 24);
		panel2.add(picLabel);
		picLabel2 = new JLabel(icony);
		picLabel2.setBounds(2, 40, 24, 24);
		panel2.add(picLabel2);

		frame = new JDialog();
		frame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		frame.setLocation(400, 200);
		frame.setSize(600, 280);
		frame.setTitle("Dont Hesistate to Inform Our Team If You Spot A Bug");
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
                frame.addWindowListener(new WindowAdapter(){
                    
                    @Override
                    public void windowClosing(WindowEvent e){
                        
                        new AudioClass("A10");                    }
                });
		
		 ImageIcon frameIcon=new ImageIcon(getClass().getResource("frameIcon/frameIcon1.png"));
	     Image img= frameIcon.getImage();
	     frame.setIconImage(img);

		frame.add(panel);
		frame.add(panel2);
		frame.add(nextButton);
		frame.add(cancelButton);
		
		try {
			write = new PrintStream("C:\\Users\\Frankline Sable\\IdeaProjects\\New And Improved Programs Maseno\\src\\Logs_Compilation\\Log_Compilation.txt");

		} catch (FileNotFoundException ex) {
			
			JOptionPane.showMessageDialog(frame,"There's a problem writting the log compilation file", "LOG COMPILATION CANNOT BE PRINTED", JOptionPane.ERROR_MESSAGE);
		}

		list.addListSelectionListener(new listHandler());
	}

	private class listHandler implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {

			if (list.isSelectedIndex(0) || list.isSelectedIndex(1)) {

				nextButton.setForeground(Color.BLUE);
				nextButton.setEnabled(true);
			}

		}
	}

	private class buttonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==nextButton){
			if (list.getSelectedIndex() == 1) {

				frame.setSize(400, 250);
				frame.remove(panel);
				frame.remove(panel2);
				frame.remove(nextButton);
				frame.setTitle("CRASH LOGS CAN BE SENT MORE EASILY AND QUICKLY");
				
				labelFinal = new JLabel(sendingIcon);
				labelFinal.setFont(new Font("Serif", Font.BOLD, 50));
				frame.getContentPane().setBackground(new Color(100, 149, 237));
				labelFinal.setBounds(280, 5, 100, 64);
				frame.add(labelFinal);

				textPanel = new JPanel();
				textPanel.setBounds(2, 80, 380, 130);
				textPanel.setBorder(borderTextArea);

				progressBar = new JProgressBar();
				progressBar.setBounds(2, 190, 350, 10);
				progressBar.setMinimum(0);
				progressBar.setMaximum(3);

				exportIconLabel1.setBounds(20, 25, 50, 50);
				frame.add(exportIconLabel1);
				exportIconLabel1.setVisible(false);
				exportIconLabel2.setBounds(90, 25, 50, 50);
				frame.add(exportIconLabel2);

				exportIconLabel3.setBounds(160, 25, 50, 50);
				frame.add(exportIconLabel3);

				exportIconLabel1.setVisible(false);
				exportIconLabel2.setVisible(false);
				exportIconLabel3.setVisible(false);
				textPanel.add(progressBar);
				frame.add(textPanel);
				timeHandler th = new timeHandler(0);
				timer = new Timer(1000, th);
				timer.start();
				

				for (int i = 0; i < 1000; i++) {
					file = new File("C:\\Users\\Frankline Sable\\IdeaProjects\\New And Improved Programs Maseno\\src\\Crash_Logs\\Traffic_Light_Simulation log[" + i + "].txt");

					if (file.exists()) {

						write.println("Sent Log " + file);
					}
				}
				write.close();

				try {
					Scanner read = new Scanner(new File("C:\\Users\\Frankline Sable\\IdeaProjects\\New And Improved Programs Maseno\\src\\Logs_Compilation\\Log_Compilation.txt"));

					while (read.hasNextLine()) {

						String contents = read.nextLine();

						textArea = new JTextArea();
						textArea.setFont(new Font("Modern No. 20", Font.PLAIN, 14));
						textArea.setText(contents);

						textPanel.add(textArea);
					}
					read.close();
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}else{
				
				
				frame.setSize(500, 390);
				frame.remove(panel);
				frame.remove(panel2);
				
				frame.remove(nextButton);
				frame.remove(cancelButton);
				frame.getContentPane().setBackground(new Color(100, 149, 237));
				frame.setTitle("MY PROGRAM IS READY TO CARTER TO YOUR NEEDS");
				
				
				nextButton2 = new JButton("Finish",nextButtonIcon);
				nextButton2.setHorizontalTextPosition(AbstractButton.LEFT);
				nextButton2.setBounds(260,325,100,30);
				nextButton2.setBackground(SystemColor.activeCaptionBorder);
				nextButton2.setFont(new Font("Serif", Font.PLAIN, 20));
				nextButton2.setBorder(BorderFactory.createEmptyBorder());
				nextButton2.addActionListener(new buttonHandler2());
				nextButton2.setEnabled(false);
				
				cancelButton2 = new JButton("Cancel",cancelButtonIcon);
				cancelButton2.setHorizontalTextPosition(AbstractButton.LEFT);
				cancelButton2.setBounds(380,325,100,30);
				cancelButton2.setBackground(nextButton.getBackground());
				cancelButton2.setFont(nextButton.getFont());
				cancelButton2.setBorder(nextButton.getBorder());
				cancelButton2.addActionListener(new buttonHandler2());
				
				frame.add(nextButton2);
				frame.add(cancelButton2);
				
				label.removeAll();
				label.setIcon(commentBig);
				label.setBounds(390,0,100,100);
				
				label2.removeAll();
				label2.setFont(new Font("snap itc", Font.BOLD, 40));
				label2.setForeground(Color.GREEN);
				label2.setBounds(0,0,390,50);
				label2.setText("Hey There!");
				
				label1.removeAll();
				label1.setFont(new Font("Serif", Font.PLAIN, 21));
				label1.setForeground(Color.GREEN);
				label1.setBounds(0,75,390,50);
				label1.setText("Dear ???, We do adore your feedback!");
				
				
				panel.removeAll();
				panel.setBounds(5,120,480,200);
				panel.setBackground(new Color(192,192,192));
				TitledBorder titleBorder3=BorderFactory.createTitledBorder(loweredBorder,"Please Fill in your details, plus feedback above",TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM);
				titleBorder3.setTitleFont(new Font("Serif", Font.BOLD, 16));
				panel.setBorder(titleBorder3);
				panel.setLayout(null);
				
				nameField=new JLabel("Name:");
				nameField.setFont(new Font("Serif", Font.BOLD, 20));
				nameField.setBounds(5,10,60,20);
				
				textField=new JTextField("Enter First name here");
				textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				textField.setBackground(new Color(204, 204, 204));
		        textField.setForeground(new Color(169, 169, 169));
				textField.setBounds(65,10,200,30);
				textField.addKeyListener(new keyHandler());
				textField.addMouseListener(new mouseHandler());
				
				textField2=new JTextField("Enter Last name here");
				textField2.setBackground(textField.getBackground());
		        textField2.setForeground(textField.getForeground());
		        textField2.setFont(textField.getFont());
				textField2.setBounds(285,10,170,30);
				textField2.addMouseListener(new mouseHandler());
				
				feedbackField=new JLabel("FEEDBACK:");
				feedbackField.setBounds(5,50,130,30);
				feedbackField.setFont(new Font("Serif", Font.BOLD, 16));
				
				textField3=new JTextField("COMMENT");
				textField3.setBackground(textField.getBackground());
		        textField3.setForeground(textField.getForeground());
		        textField3.setBorder(loweredBorder);
		        textField3.setFont(new Font("Stencil",Font.BOLD, 70 ));
				textField3.setBounds(5,85,470,80);
				textField3.addMouseListener(new mouseHandler());
				
				textField2.setEnabled(false);
				textField3.setEnabled(false);
				
				panel.add(nameField);
				panel.add(textField);
				panel.add(textField2);
				panel.add(textField3);
				panel.add(feedbackField);
				
				frame.add(label);
				frame.add(label1);
				frame.add(label2);
				frame.add(panel);
				
				}
			}else {
				
				frame.setVisible(false);
			}

		}
	}

	private class timeHandler implements ActionListener {

		private int count;

		public timeHandler(int count) {

			this.count = count;
		}

		@Override
		public void actionPerformed(ActionEvent e) {


			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException ex){
				
			}
			count++;
			progressBar.setValue(count);

			if (count == 1) {

				exportIconLabel1.setVisible(true);
			} else if (count == 2) {
				exportIconLabel2.setVisible(true);

			} else if (count == 3){

				exportIconLabel3.setVisible(true);
				
				textPanel.setBorder(BorderFactory.createTitledBorder(loweredBorder, "Sending Complete",
						TitledBorder.RIGHT, TitledBorder.ABOVE_TOP));
                                ty.crashLogs();
			}else if(count==5){
				new AudioClass("A8");
				timer.stop();
				frame.setVisible(false);
			}
		}
	}private class keyHandler extends KeyAdapter{
		
		@Override
		public void keyReleased(KeyEvent e){
			
			String typedText=textField.getText();
			label1.setText("Dear "+typedText+", We do adore your feedback!");
			
		}
	}
	private class mouseHandler extends MouseAdapter{
		
		@Override
        public void mouseClicked(MouseEvent ev3){
            
			
		 if(ev3.getSource()==textField){
        	   
        	   textField2.setEnabled(true);
        	   textField.setText("");
               textField.setBackground(UIManager.getColor("Button.background"));
               textField.setForeground(UIManager.getColor("CheckBox.darkShadow"));
               
           }
           else if(ev3.getSource()==textField2){
        	   
        	   if(textField2.isEnabled()){
        	   
        	   textField3.setEnabled(true);
        	   textField2.setText("");
               textField2.setBackground(UIManager.getColor("Button.background"));
               textField2.setForeground(UIManager.getColor("CheckBox.darkShadow"));
        	   }
           }
           else{
        	   if(textField3.isEnabled()){
        		   
        	   textField3.setText("");
               textField3.setBackground(UIManager.getColor("Button.background"));
               textField3.setForeground(UIManager.getColor("CheckBox.darkShadow"));
               textField3.setFont(new Font("Segoe Print", Font.PLAIN, 20));
               TitledBorder titlebd=BorderFactory.createTitledBorder(loweredBorder, "Thank you "+textField.getText()+" for your FeedBack",TitledBorder.RIGHT,TitledBorder.BELOW_TOP);
               titlebd.setTitleFont(new Font("Serif", Font.BOLD, 16));
               titlebd.setTitleColor(Color.MAGENTA);
               textField3.setBorder( titlebd);
               
               
               nextButton2.setEnabled(true);
        	   }
           }
        }
        }public class buttonHandler2 implements ActionListener{
        	
        	@Override
        	public void actionPerformed(ActionEvent e){
        		
        		if(e.getSource()==nextButton2){
        			
        			int i;
        			
        			try {
        				for(i=0; i<1000; i++){
        					
						File file=new File("C:\\Users\\Frankline Sable\\IdeaProjects\\New And Improved Programs Maseno\\src\\Feeedback\\FeedBack["+i+"].txt");
						if(!file.exists()){
							
							break;
						}
						}
        				print=new PrintStream("C:\\Users\\Frankline Sable\\IdeaProjects\\New And Improved Programs Maseno\\src\\Feeedback\\FeedBack["+i+"].txt");
						Object[] options={"Cool"};
						print.println("First Name: "+textField.getText());
						print.println("Last Name: "+textField2.getText());
						print.println("Details:");
						print.println("	"+textField3.getText());
						
						new AudioClass("A8");
	        			JOptionPane.showOptionDialog(frame,"Details Sent Successfully, Thank You for Your FEEDBACK!","OKAY, COMMENT RECEIVED", JOptionPane.ERROR_MESSAGE,JOptionPane.INFORMATION_MESSAGE,sendingIcon, options, options[0]);
	        			
	        			try{
	        				Thread.sleep(2000);
	        				frame.setVisible(false);
                                                ty.bugReport();
	        				
	        			}catch(InterruptedException ex){
	        				
	        				System.err.println(ex);
	        			}
	        		} catch (FileNotFoundException e1) {
						
						JOptionPane.showMessageDialog(frame, "Error Printing FeedBack","Please Recheck The location", JOptionPane.ERROR_MESSAGE);
					}
      			}
        		else{
        			
        			frame.setVisible(false);
        			
        		}
        	}
        }
	
	}

