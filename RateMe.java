/**
 * 
 */
package realTime_Traffic_Simulator;

/**
 * @author Frankline Sable
 *
 */
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class RateMe {

	/**
	 * @param args
	 */
	Boolean a1=true,a2=true,a3=true,a4=true,a5=true;
	private static JDialog frame;
	private JPanel panel;
	private JButton rateButtons[]=new JButton[10];
	private JLabel label,label2;
	private Icon stars0[]=new ImageIcon[10];
	private Icon stars1[]=new ImageIcon[10];
	private Icon stars2[]=new ImageIcon[10];
	private Icon stars3[]=new ImageIcon[10];
	private Icon stars4[]=new ImageIcon[10];
	private JButton finish;
	
	public RateMe(){
		int a=50;
		
		finish=new JButton("Finish");
		finish.setBounds(375,220,100,35);
		finish.setBackground(Color.GRAY);
		finish.setBorder(BorderFactory.createRaisedBevelBorder());
		finish.setFont(new Font("Serif", Font.PLAIN, 22));
		finish.setEnabled(false);
		finish.setForeground(Color.BLUE.brighter());
		finish.addActionListener(new rateHandler());
		
		label=new JLabel("*>How would you rate this program?");
		label.setFont(new Font("Serif", Font.PLAIN, 27));
		label.setForeground(Color.WHITE.darker());
		label.setBounds(5,30,450,32);
		
		label2=new JLabel("NONE");
		label2.setFont(new Font("Serif", Font.BOLD, 35));
		label2.setBounds(130,170,400,50);
	
		panel=new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(BorderFactory.createLoweredBevelBorder());
		panel.setLayout(null);
		panel.setBounds(0,0,480,260);
		
		panel.add(label);
		panel.add(finish);
		panel.add(label2);
		 
		for(int i=0; i<5; i++){
			
			stars0[i]=new ImageIcon(getClass().getResource("ratingImages/rate1.png"));
			stars1[i]=new ImageIcon(getClass().getResource("ratingImages/star1.png"));
			stars2[i]=new ImageIcon(getClass().getResource("ratingImages/star2.png"));
			stars3[i]=new ImageIcon(getClass().getResource("ratingImages/star3.png"));
			stars4[i]=new ImageIcon(getClass().getResource("ratingImages/star4.png"));
			
		}
		
		for(int i=0; i<5; i++){
			
			rateButtons[i]=new JButton(stars0[i]);
			rateButtons[i].setBackground(panel.getBackground());
			rateButtons[i].setBounds(a,80,72,72);
			rateButtons[i].setBorder(BorderFactory.createEmptyBorder());
			rateButtons[i].addActionListener(new rateHandler());
			
			a+=75;
			panel.add(rateButtons[i]);
			
		}
		new AudioClass("A9");
		frame.add(panel);
	}
	
	
	public static void call() {
		// TODO Auto-generated method stub
		
		JDialog.setDefaultLookAndFeelDecorated(true);
		
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override 
			public void run(){
				
				frame=new JDialog();
				frame.setOpacity(0.70f);
				frame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
				frame.setSize(500, 300);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.setLayout(null);
				frame.setAlwaysOnTop(true);
				frame.setTitle("Rate us please, we'd like to here from you...");
                                frame.addWindowListener(new WindowAdapter(){
                    
                    @Override
                    public void windowClosing(WindowEvent e){
                        
                        new AudioClass("A10");                    }
                });
				new RateMe();
				
				
			}
		});

	}
	
	private class rateHandler implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e){
			
			finish.setEnabled(true);
			
			if(e.getSource()==rateButtons[4]){
				
				if(a1){								//First condition
				
					for(int i=0; i<5; i++){
						
						rateButtons[i].setIcon(stars4[i]);
					}
					a1=false;
					label2.setText("EXCELLENT!");
					label2.setForeground(Color.MAGENTA);
					frame.setOpacity(1f);
					new AudioClass("A9");
				}
				else{
					
					for(int i=0; i<4; i++){
						
						rateButtons[i].setIcon(stars3[i]);
					}
					rateButtons[4].setIcon(stars0[0]);
					a1=true;
					label2.setText("BEST");
					label2.setForeground(Color.WHITE);
					}
			}
			else if(e.getSource()==rateButtons[3]){		//second condition
				
				if(a2){
					
					for(int i=0; i<4; i++){
						
						rateButtons[i].setIcon(stars3[i]);
					}
					
					rateButtons[4].setIcon(stars0[0]);
					a2=false;
					label2.setText("BEST");
					label2.setForeground(Color.WHITE);
					frame.setOpacity(0.9f);
					new AudioClass("A15");
				}
				else{
					for(int i=0; i<3; i++){
						
						rateButtons[i].setIcon(stars2[i]);
					}
					rateButtons[4].setIcon(stars0[0]);
					rateButtons[3].setIcon(stars0[0]);
					a2=true;
					
				label2.setText("VERY GOOD");
				label2.setForeground(Color.WHITE);
				}
			}
			else if(e.getSource()==rateButtons[2]){			//third condition
				
				if(a3){
					
					for(int i=0; i<3; i++){
						
						rateButtons[i].setIcon(stars2[i]);
					}
					rateButtons[3].setIcon(stars0[0]);
					rateButtons[4].setIcon(stars0[0]);
					a3=false;
					label2.setText("VERY GOOD");
					label2.setForeground(Color.WHITE);
					frame.setOpacity(0.85f);
					new AudioClass("A15");
				}
				else{
					
					for(int i=0; i<2; i++){
						
						rateButtons[i].setIcon(stars1[i]);
					}
					
					rateButtons[4].setIcon(stars0[0]);
					rateButtons[3].setIcon(stars0[0]);
					rateButtons[2].setIcon(stars0[0]);
					a3=true;
					label2.setText("GOOD");
					label2.setForeground(Color.WHITE);
					}
			}
			else if(e.getSource()==rateButtons[1]){
				
				if(a4){
					
					for(int i=0; i<2; i++){
						
						rateButtons[i].setIcon(stars1[i]);
					}
					rateButtons[2].setIcon(stars0[0]);
					rateButtons[3].setIcon(stars0[0]);
					rateButtons[4].setIcon(stars0[0]);
					a4=false;
					label2.setText("GOOD");
					label2.setForeground(Color.WHITE);
					frame.setOpacity(0.80f);
					new AudioClass("A15");
				}
				else{
					
					
					rateButtons[4].setIcon(stars0[0]);
					rateButtons[3].setIcon(stars0[0]);
					rateButtons[2].setIcon(stars0[0]);
					rateButtons[1].setIcon(stars0[0]);
					rateButtons[0].setIcon(stars1[0]);
					a4=true;
					label2.setText("OKAY");
					label2.setForeground(Color.WHITE);
					}
			}
			else if(e.getSource()==rateButtons[0]){
				

				if(a5){
					
					for(int i=0; i<1; i++){
						
						rateButtons[i].setIcon(stars1[0]);
					}
					rateButtons[1].setIcon(stars0[0]);
					rateButtons[2].setIcon(stars0[0]);
					rateButtons[3].setIcon(stars0[0]);
					rateButtons[4].setIcon(stars0[0]);
					a5=false;
					label2.setText("OKAY");
					label2.setForeground(Color.WHITE);
					frame.setOpacity(0.75f);
					new AudioClass("A15");
				}
				else{
					
					rateButtons[4].setIcon(stars0[0]);
					rateButtons[3].setIcon(stars0[0]);
					rateButtons[2].setIcon(stars0[0]);
					rateButtons[1].setIcon(stars0[0]);
					rateButtons[0].setIcon(stars0[0]);
					a5=true;
					label2.setText("NONE");
					label2.setForeground(Color.WHITE);
					finish.setEnabled(false);
					frame.setOpacity(0.70f);
					}}
			else{
				
				 
				JOptionPane.showMessageDialog(frame, "Thank you For your FeedBack!\nWe are proud to serve you!", "RATE PROCESSED",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("ratingImages/FEEDBACK.png")));
				frame.setVisible(false);
				new AudioClass("A10"); 
			}
		}
	}

}
