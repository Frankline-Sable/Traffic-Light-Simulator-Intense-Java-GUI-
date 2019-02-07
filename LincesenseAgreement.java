package realTime_Traffic_Simulator;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;

public class LincesenseAgreement {

	private final ImageIcon frameIcon, LicenceIcon;	//Creates an object of the image
	private final JLabel lincenseIconLabel;			//creating objects for the gui components
	private JPanel panel;								//creating objects for the gui components
	private final JDialog frame;
	private final JLabel lincenseHeader, instLabel;							//creating objects for the gui components
	private JTextArea textArea;
	private String lincence;									//creating objects for the gui components

	public LincesenseAgreement() {
		
		lincence="------------------------------------------------------------------------------"
				+ "\n|->DISCLAIMER:\n----------------------------------------\n"
				+ " Neither My Collegues nor Frankline Sable,	*/\n"
				+ " nor anyone else even remotely connected with the 		*\n* "
				+ " creation of this program, assumes any responsibility 	*\n*"
				+ " for any damage of any kind due to the use of this code,	 * \n*"
				+ " or the use of any work derived from this code, including	 *\n*"
				+ " any work created partially or in full by the me, the Programmer.* \n"
				+ "_______________________________________________\n*/-=>YOU HAVE NO "
				+ " RIGHTS TO DISTRIBUTE THIS SOFTWARE	<=--*\n 	WITHOUT INFORMING THE "
				+ " OWNER: FRANKLINE SABLE\n	_______________________________________________"
				+ "\n */-=>YOU'VE RIGHTS TO MODIFY THE CONTENTS OF THIS CODE<=-*\n	"
				+ "*_______________________________________________*\n";

		TitledBorder panelBorder = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "End",TitledBorder.RIGHT, TitledBorder.BELOW_BOTTOM);
		panelBorder.setTitleFont(new Font("Serif", Font.PLAIN, 20));					//creating objects for the gui components
		panelBorder.setTitleColor(Color.red);
		
		instLabel = new JLabel("Please Read the Terms Below Carefully:");								//definition of several objects that we are using
		instLabel.setBounds(0, 70, 400, 25);
		instLabel.setFont(new Font("Serif", Font.PLAIN, 18));						//creating objects for the gui components

		frameIcon = new ImageIcon(getClass().getResource("FrameIcon/frameIcon3.png"));					//definition of several objects that we are using
		Image img = frameIcon.getImage();
		//creating objects for the gui components
		LicenceIcon = new ImageIcon(getClass().getResource("LincenceImages/lincenseHeader.png"));					//definition of several objects that we are using

		lincenseIconLabel = new JLabel(LicenceIcon);
		lincenseIconLabel.setBounds(490, 0, 100, 100);					//definition of several objects that we are using

		lincenseHeader = new JLabel("Lincense Agreement ");
		lincenseHeader.setForeground(new Color(30, 144, 255));
		lincenseHeader.setFont(new Font("SErif", Font.BOLD, 45));							//definition of several objects that we are using
		lincenseHeader.setBounds(0, 0, 450, 55);
		
		panel = new JPanel();
		panel.setBorder(panelBorder);
		panel.setBounds(5, 100, 575, 260);					//creating objects for the gui components
		panel.setLayout(new GridLayout());
		
		textArea = new JTextArea(lincence);
		textArea.setBackground(panel.getBackground());									//definition of several objects that we are using
		textArea.setBounds(5,5,460,250);
		textArea.setFont(new Font("Modern No. 20", Font.PLAIN, 20))	;						//creating objects for the gui components
		textArea.setForeground(Color.black);

		
		panel.add(new JScrollPane(textArea));															//creating objects for the gui components
		
		frame = new JDialog();
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setTitle("LICENCE AGREEMENT AS WITH FRANKLINE SABLE");									//creating objects for the gui components
		frame.setSize(600, 400);
		frame.setLocation(400, 200);
		frame.setVisible(true);
		frame.setLayout(null);								//creating objects for the gui components
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(new Color(255, 69, 0));								//definition of several objects that we are using
		frame.setResizable(false);
                frame.addWindowListener(new WindowAdapter(){
                    
                    @Override
                    public void windowClosing(WindowEvent e){
                        
                        new AudioClass("A10");                    }
                });

		//frame.getContentPane().setBackground(new Color(230, 230, 250));

		frame.add(instLabel);									//creating objects for the gui components
		frame.add(lincenseHeader);
		frame.setIconImage(img);
		frame.add(lincenseIconLabel);										//definition of several objects that we are using
		frame.add(panel);
		new AudioClass("A15");
		
		}

	
}
