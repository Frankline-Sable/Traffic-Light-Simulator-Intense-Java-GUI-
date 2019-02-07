/**
 * 
 */
package realTime_Traffic_Simulator;

/**
 * @author Frankline Sable
 *
 */
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class firstFrame {

	private JLabel Flabel;
	private JFrame frame;
	
	public firstFrame(){
		
		Flabel=new JLabel(new ImageIcon(getClass().getResource("background/d.gif")));
		Flabel.setBounds(0,0,600,400);
		
		frame=new JFrame();
		frame.setUndecorated(true);		
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(600,400);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
		frame.add(Flabel);
		
		thisThread tt=new thisThread();
		tt.start();
	}
	private class thisThread extends Thread{
		
		public void run(){
			
			try{
				Thread.sleep(7000);
				frame.setVisible(false);
				}
			catch(InterruptedException ec){
				
				System.out.print(ec);
			}
			
		}
	}
	public static void main(String[] args) {
		
		new firstFrame();
	}

}
