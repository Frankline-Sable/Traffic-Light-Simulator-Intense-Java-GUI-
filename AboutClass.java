package realTime_Traffic_Simulator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AboutClass {

	private final JDialog frame;									//creating the frame object that holds JFRame
	private final JPanel panel;									//creating the panel object that holds JPanel
	private final JLabel aboutHeader, authorLabel, nameLabel;	//creating the label objects that holds JLabel
	private final ImageIcon authorIcon, aboutIcon;				//creating the icon object that holds ImageIcon
	private final Image img;									//creating the image object that holds image
	private final TitledBorder panelBorder;						//creating the titleBorder object that holds border
	private final JTextArea textArea;							//creating the text area object that holds JTextArea
	private final String info;									

	public AboutClass() {

		info = "-->A Computer Technology student in maseno university.\n-->A computer enthusiast, loves coding in his free time"
				+ ". \n-->Has been born and raised up from a good family,\n and he looks forward to success!\n-->He's a partial"
				+ " believer, doesn't take religion seriously.\n-->Follows Traffic signs and appreciates the fact of being alive to \nsimulate one himself via this program!"
				+ "\n-->Takes life far too seriouly sometimes...";

		aboutHeader = new JLabel("Program Author:");							//defining the JLabel
		aboutHeader.setForeground(new Color(255, 0, 255));						//setting the foreground
		aboutHeader.setFont(new Font("Serif", Font.BOLD, 50));					//setting the font
		aboutHeader.setBounds(0, 0, 400, 60);									//setting the bounds

		authorIcon = new ImageIcon(getClass().getResource("author/author.jpg"));			//adding an image icon
		authorLabel = new JLabel(authorIcon);
		authorLabel.setBounds(440, 2, 150, 150);
		
		aboutIcon = new ImageIcon(getClass().getResource("aboutFrameIcon/about.png"));		//definition of several objects that we are using
		img=aboutIcon.getImage();													//definition of several objects that we are using

		nameLabel = new JLabel("Frankline Sable");										//definition of several objects that we are using
		nameLabel.setBounds(60, 80, 400, 60);
		nameLabel.setFont(new Font("Vivaldi", Font.PLAIN, 50));							//definition of several objects that we are using

		textArea = new JTextArea(info);
		textArea.setFont(new Font("Monotype Corsiva", Font.PLAIN, 22));			//definition of several objects that we are using
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(5, 5, 570, 170);	//definition of several objects that we are using
		
		panelBorder = BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),	//dealing with the frame
				"My Details Plus Description", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);					//dealing with the frame
		panelBorder.setTitleFont(new Font("Serif", Font.PLAIN, 18));
		panelBorder.setTitleColor(new Color(178, 34, 34));

		panel = new JPanel();
		panel.setBackground(Color.GRAY);							//dealing with the frame
		panel.setBounds(5, 160, 585, 200);								//dealing with the frame
		panel.setBorder(panelBorder);
		panel.setLayout(new GridLayout());				//dealing with the frame
		panel.add(new JScrollPane(textArea));									//dealing with the frame

		frame = new JDialog();										//frame object is created
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	//determines how the frame would close
		frame.setTitle("About The Program AKA Premiam_Alt");		//setting the frame title
		frame.setSize(600, 400);							//setting the frame size
		frame.setLocation(400, 100);		///setting the location
		frame.setVisible(true);					//setting  visibility
		frame.setLayout(null);   										//dealing with the frame
		frame.setAlwaysOnTop(true);		//dealing with the frame
		frame.setResizable(false);																//dealing with the frame
		frame.setIconImage(img);							//dealing with the frame
		frame.addWindowListener(new WindowAdapter(){
                    
                    @Override
                    public void windowClosing(WindowEvent e){
                        
                        new AudioClass("A10");                    }
                });

		frame.add(aboutHeader);				//dealing with the frame
		frame.add(nameLabel);										//dealing with the frame
		frame.add(panel);							//dealing with the frame
		frame.add(authorLabel);										//dealing with the frame
		new AudioClass("A15");
	}
	

}
