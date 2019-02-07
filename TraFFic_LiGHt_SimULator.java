package realTime_Traffic_Simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.Timer;
import javax.swing.JMenuBar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

import java.awt.event.KeyAdapter;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TraFFic_LiGHt_SimULator {

	private final JMenuBar menuBar; 								// Declares an object for the menu bar bar
	private final JMenu controlMenu,commandList,themeMenu,prefMenu;					// Declares menu objects to add to the menu bar
	private final JMenu menuItems[] = new JMenu[10]; 					// Declares menu array objects to add to the menu bar
	private final JMenuItem fileItems[] = new JMenuItem[10]; 		// Declares array menu items objects to add to the menu
	private final JMenuItem[] helpMenuItems = new JMenuItem[10]; 	// Declares menu array items objects to add to the menu
	private final JMenuItem commandItems[] = new JMenuItem[1000];		// Declares array menu items objects to add to the menu
	private final JFrame my_Frame; 									// Declares the frame object
	private JFrame frame;
	private final JMenu controlPopMenu;
	private final Desktop desktop; 									/*Declares an object that's Used to connect to the desktop
																	*applications*/
	private final Icon exitIcons[] = new Icon[20]; 					// Creates an array of icons
	private final Icon menuIcon[] = new Icon[10]; 					// Creates an array of icons
	private final Icon radioIcons[] = new Icon[10];						// Creates an array of icons
	private final ImageIcon frameIcon;								//Declares an image icon
	private final Icon anime;										//Declares an icon

	private final int intArray[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };	//Creates an array of  numbers
	private int redDelay, yellowDelay, greenDelay;							//Declaring integers
	private int warningCount = 0;											//Initializing integers
	private int aInc = 50;													//Initializing integers
	private int threadDetector = 0;											//Initializing integers
	private final int KeyStrokeCombo[] = { KeyEvent.VK_O, KeyEvent.VK_C, KeyEvent.VK_H, KeyEvent.VK_X,	/* Array of integers representing key events*/
			ActionEvent.ALT_MASK };
	private final int keyEventMenu[] = { KeyEvent.VK_F, KeyEvent.VK_E, KeyEvent.VK_V, KeyEvent.VK_C, KeyEvent.VK_H }; /* Array of integers 
																														*representing key events*/
	private String command;													//Declaring String Commands to be used in the terminal emulator
	private final String my_Commands[] = { "Start thread", "Start", "Stop", "Stop thread", "Hide menubar", "Show menubar",	//Creating and initialising array of strings
			"Frankline Sable", "Frankline", "Developer", "Sable", "Date", "Time", "Report Bug", "Bug", "Suggestion",
			"Improvement", "Exit", "Quit", "Play Movie", "Movie", "yes", "yeah", "yah" };
	private final String movingTexts[] = { "T", "R", "A", "F", "F", "I", "C", " ", "C", "O", "N", "T", "R", "O", "L" };		//Creating and initialising array of strings
	private final String movingTexts2[] = { "A", "R", "R", "I", "V", "E", " ", "A", "L", "I", "V", "E" };						//Creating and initialising array of strings
	private final String stringArray[] = { "10", "20", "30", "40", "50", "60", "70", "80", "90", "100" };						//Creating and initialising array of strings
	private final String movingStrings[] = { "OBEY TRAFFIC COMMANDS", "OUR GOAL IS 2 KEEP U SAFE", "ARRIVE ALIVE, NOT DEAD",	//Creating and initialising array of strings
			"DON'T DRINK AND DRIVE", "	DON'T COMMIT SUICIDE" };
	private final String menuItemNames[] = { "File", "Edit", "View", "Controls", "Help" };								//Creating and initialising array of strings
	private final String fileItemNames[] = { "Open", "Quickly Close Window", "Hide Menu Bar", "Exit" }; 				//Creating and initialising array of strings
	private final String radioNames[] = { "Start", "Stop", "Resume", "Interrupt", "Suspend", "Destroy" };				//Creating and initialising array of strings
	private final String helpItems[] = { "Report Bug or Enhancement...", "License Agreement", "About" };				//Creating and initialising array of strings
	
	private final JLabel circleA, circleB, circleC, carLabel, speedLabel,buttomText;						//Declaring label items
	private JLabel Flabel;
	private final JLabel trafficLabel[] = new JLabel[100];									//Creating array of label items
	private final JLabel movingLabel[] = new JLabel[100];										//Creating array of label items
	
	private final Color commandColor[] = { Color.RED, Color.WHITE, Color.BLUE, Color.GREEN, Color.CYAN, Color.LIGHT_GRAY,		//Creating and initialising array of colours
			Color.ORANGE, Color.PINK, Color.YELLOW, Color.MAGENTA, new Color(139, 0, 0), new Color(221, 160, 221),
			new Color(218, 165, 32), new Color(128, 0, 128), new Color(128, 128, 0), new Color(0, 128, 128) };
	private final Color color[] = { Color.RED, Color.DARK_GRAY, Color.ORANGE,  Color.DARK_GRAY, Color.GREEN,  Color.DARK_GRAY,		//Creating and initialising array of colours
			Color.ORANGE };
	private final Color backGround[] = { new Color(204, 204, 204), new Color(153, 153, 153), new Color(102, 102, 102)}; //Creates a colour array for background colors
	
	private final Random randomNumber = new Random(); 					//Class that Generates A random number
	private final JFileChooser fileChooser;								//Declares the file chooser object
	private final JSlider slider;										//Declares the slider object																				// menu
	private final JTextField tf1, tf2, tf3, tf4, commandTf;				//Declares the text field objects
	private final SystemTrayClass ty;									//Declares the object of system class
	private final Border mainPanelBorder;								//Declares a border for the main Panel
																									
	private final JPanel mainPanel, threadPanel, iconPanel,speedPanel, componentPanel,		//Declares the panel object
	terminalPanel, carPanel, timePanel, variablePanel,buttomPanel;
	private final JComboBox list[]=new JComboBox[3];													//Declares the combo box objects
	private final JRadioButtonMenuItem radioItems[] = new JRadioButtonMenuItem[10];			//Declares the radio menu button items
	private final JRadioButtonMenuItem radioItems2[] = new JRadioButtonMenuItem[10];			//Declares the radio menu button items
	private threadClass thread;																//Declares the class having thread
	private final TitledBorder sliderBorder, terminalBorder, listRBorder, listYBorder, listGBorder, titledBorder,		//Declares the border
			variableBorder;
	private final Timer time;																		//Declares the time object
	private final JPopupMenu popMenu;								//Declares  an object for the pop up menu
	
	private buttomTextHandler menuBarThread;							//Class that handles pop up buttons
	private final JCheckBox checkbox[]=new JCheckBox[10];				//Check box pop menu handlers
	private final String[] checkBoxNames={"Show Menubar","Show Timer"};			//String arrays of check box names
	private final Icon popUpicons[]=new ImageIcon[10];								//Image icons array
	private final JMenuItem colorPick,popExit;									//menu items
	private final Color defaultColor[]=new Color[100];							//Array of colours
	private final JPanel pans[]=new JPanel[11];												//array of panels
	private final JRadioButtonMenuItem colorButtons[]=new JRadioButtonMenuItem[100];					//Radio buttons arrays
	private final String themeNames[]={"Default Color","Dark Forces", "Light Forces", "Supreme War" }; //String array theme items
	private paintPanelClass parentPanel;
	private paintPanelClass2 trafficPanel;
	
	public TraFFic_LiGHt_SimULator() {								//My Outer class or Main Class where all the components are contained

		ty = new SystemTrayClass();									//Creating an object of SystemTrayClass

		anime = new ImageIcon(getClass().getResource("Animations/carAnimation.gif"));		//importing image icons into the program
		frameIcon = new ImageIcon(getClass().getResource("FrameIcon/frameIcon.png"));		//importing image icons into the program
		Image img = frameIcon.getImage();													//Converting image icon into an image


		for (int i = 0; i < 9; i++) {

			menuIcon[i] = new ImageIcon(getClass().getResource("images/menuItem" + i + ".gif"));		//For loop used for importing several image icons
		}
		for (int i = 0; i < 17; i++) {

			exitIcons[i] = new ImageIcon(getClass().getResource("ExitIcons/exit" + i + ".png"));		//For loop used for importing several image icons
		}

		for (int i = 0; i < movingTexts.length; i++) {													//Array used to display the vertical moving texts

			trafficLabel[i] = new JLabel();
			trafficLabel[i].setFont(new Font("Serif", Font.BOLD, 30));					//Setting font to the labels
			trafficLabel[i].setForeground(Color.RED);									//setting label colours
			trafficLabel[i].setBounds(965, aInc, 40, 40);
			aInc += 35;
		}

		menuBar = new JMenuBar();														//Creates the menu bar
		menuBar.setBorder(BorderFactory.createLoweredBevelBorder());					//Setting border to the menu bar
		menuBar.setBackground(Color.LIGHT_GRAY);										//Setting colour to the menu bar

		for (int i = 0; i < 5; i++) {

			menuItems[i] = new JMenu(menuItemNames[i]);									//Creates Menu Items(Several)
			menuItems[i].setFont(new Font("Serif", Font.PLAIN, 14));					//Sets font of menu items
			menuItems[i].setIcon(menuIcon[i]);											//Adds icons to the menuItems
			menuBar.add(menuItems[i]);
		}

		menuItems[5] = new JMenu("Traffic References");									//creates JmenuItems
		menuItems[5].setIcon(menuIcon[7]);  											//Create menu icon

		helpMenuItems[3] = new JMenuItem("Histroy of Traffic Signals");					//Create JMenuItems
		helpMenuItems[4] = new JMenuItem("How They Work");
		helpMenuItems[3].setFont(new Font("Serif", Font.PLAIN, 14));
		helpMenuItems[4].setFont(new Font("Serif", Font.PLAIN, 14));

		listRBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Red");		//creates the border items plus sets the font colour
		listYBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE), "Amber");	//creates the border items plus sets the font colour
		listGBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN), "Green");	//creates the border items plus sets the font colour

		listRBorder.setTitleFont(new Font("Serif", Font.BOLD, 13));
		listRBorder.setTitleColor(Color.RED);												//Setting the font colour

		listYBorder.setTitleFont(new Font("Serif", Font.BOLD, 13));							//create the border Colour
		listYBorder.setTitleColor(Color.ORANGE);											//Setting the font colour

		listGBorder.setTitleFont(new Font("Serif", Font.BOLD, 13));							//Setting the border font plus the colour 
		listGBorder.setTitleColor(Color.GREEN);

		int b=5;
		for(int i=0; i<3; i++){
			
			list[i]= new JComboBox(stringArray);									//Creating a combo box, giving it starting  string array values
			list[i].setBounds(b, 5, 60, 45);
			list[i].setFont(new Font("Serif", Font.PLAIN, +13));					//setting the font for the list
			list[i].setSelectedItem("100");
			list[i].addItemListener(new listItemHandler());						//Adding an Action To the list items
	
					b+=65;
		}
		list[0].setBorder(listRBorder);
		list[1].setBorder(listYBorder);
		list[2].setBorder(listGBorder);
		
		commandList = new JMenu("Terminal Commands");						//A JMenu that displays terminal commands
		commandList.setFont(new Font("Serif", Font.PLAIN, 14));

		for (int i = 0; i < my_Commands.length; i++) {

			commandItems[i] = new JMenuItem(my_Commands[i]);							//Initialising the command items in loop
			commandItems[i].addActionListener(new commandHandler());					//Adding action listener to the help menu items
			commandItems[i].setFont(new Font("Serif", Font.PLAIN, 14));					//Setting the font
			commandList.add(commandItems[i]);
		}
		menuItems[2].add(commandList);

		menuItems[5].setFont(new Font("Serif", Font.PLAIN, 14));						//Creates the command list menu items
		menuItems[5].add(helpMenuItems[3]);
		menuItems[5].add(helpMenuItems[4]);
		menuItems[4].add(menuItems[5]);

		helpMenuItems[3].addActionListener(new browseHandler());						//Adding action listener to the help menu 3
		helpMenuItems[4].addActionListener(new browseHandler());						//Adding action listener to the help menu 4

		for (int i = 0; i < 3; i++) {

			helpMenuItems[i] = new JMenuItem(helpItems[i]);								//Adds items to the menu
			helpMenuItems[i].setFont(new Font("Serif", Font.PLAIN, 14));				//setting the font to the help items
			helpMenuItems[i].addActionListener(new helpMenuItemListener());				//Adding action listeners to the help items
			menuItems[4].add(helpMenuItems[i]);

			if (i == 0) {

				menuItems[4].addSeparator();											//Creates a separator that separates the ,menu items
			}
		}
		helpMenuItems[0].setIcon(menuIcon[6]);					//setting icons to the menu items
		helpMenuItems[1].setIcon(menuIcon[8]);					//setting icons to the menu items
		helpMenuItems[2].setIcon(menuIcon[5]);					//setting icons to the menu items

		for (int i = 0; i < 4; i++) {

			fileItems[i] = new JMenuItem(fileItemNames[i]);						//initialising the file items in an array
			fileItems[i].setFont(new Font("Serif", Font.PLAIN, 14));										//Sets the font for fileItems[i]
			fileItems[i].setAccelerator(KeyStroke.getKeyStroke(KeyStrokeCombo[i], KeyStrokeCombo[4]));		//Sets key accelerator
			menuItems[0].add(fileItems[i]);
			fileItems[i].addActionListener(new menuItemHandler());			//Adding action listeners to the file items

			if (i == 2) {										//decision statement

				menuItems[0].addSeparator(); 			/*create a separator  that 
														*separates the menu items plus its components
		*/	}
		}
		prefMenu=new JMenu("Preferences");							//creates menu for preferences and theme customisation
		prefMenu.setFont(menuItems[4].getFont());					//setting the font to the preference menu
		
		themeMenu=new JMenu("Appearance");							//creates menu for preferences and theme customisation
		themeMenu.setFont(prefMenu.getFont());						//setting the font to the  theme menu
		colorPick=new JMenuItem("Open color chooser");				//if clicked the colour chooser is opened
		colorPick.setFont(prefMenu.getFont());							//setting the font
		colorPick.addActionListener(new prefHandler());					//Adding actions to the menus
			
		prefMenu.add(themeMenu);							
		prefMenu.add(colorPick);
		menuItems[1].add(prefMenu);
		
		ButtonGroup group3=new ButtonGroup();						//creating a button group
		
		for(int i=0; i<themeNames.length; i++){							//looping structure 
			
			colorButtons[i]=new JRadioButtonMenuItem(themeNames[i]);				//setting the colour buttons
			colorButtons[i].setFont(new Font("segoe print", Font.ITALIC, 13));		//setting the font
			group3.add(colorButtons[i]);											//adding buttons to the group
			colorButtons[i].addActionListener(new prefHandler());
			themeMenu.add(colorButtons[i]);
		}
		colorButtons[0].setSelected(true);											//setting the colour to the buttons
		
		fileItems[3].setIcon(new ImageIcon(getClass().getResource("images/open.gif")));			//setting icons to the file items
		fileItems[2].setIcon(new ImageIcon(getClass().getResource("images/menubar.png")));		//setting icons to the file items
		fileItems[1].setIcon(new ImageIcon(getClass().getResource("images/cancel.png")));		//setting icons to the file items
		fileItems[0].setIcon(new ImageIcon(getClass().getResource("images/fileopen.png")));		//setting icons to the file items
		controlMenu = new JMenu("Thread Events");												//initialising the controlMenu 
		controlMenu.setFont(new Font("Serif", Font.PLAIN, 14));									//setting the font
		
		for(int i=0; i<4; i++){																//looping structure
			
			popUpicons[i]=new ImageIcon(getClass().getResource("popMenuIcons/item"+i+".png"));		//initialising icons for the pop up menu
		}
		
		popMenu=new JPopupMenu();
		popMenu.setBorder(BorderFactory.createLoweredBevelBorder());				//setting the border
		
		controlPopMenu=new JMenu("Process Control");								//initialising the menu item
		controlPopMenu.setIcon(popUpicons[0]);										//adding icons to the components
		controlPopMenu.setFont(new Font("Serif", Font.PLAIN, 15));						//setting the font
		controlPopMenu.setBorder(BorderFactory.createRaisedBevelBorder());					//setting the border
		
		ButtonGroup group = new ButtonGroup();									//creating the button group object

		for (int i = 0; i < 6; i++) {

			radioIcons[i] = new ImageIcon(getClass().getResource("controlIcons/radio" + i + ".png"));			//defining the image icons
			radioItems[i] = new JRadioButtonMenuItem(radioNames[i], radioIcons[i]);					//defining the radio buttons
			radioItems[i].setFont(new Font("Serif", Font.PLAIN, 14));							//setting the font
			radioItems[i].addActionListener(new radioButtonsHandler());						///adding action  listeners to the radio buttons
			group.add(radioItems[i]);										//adding the buttons to the group

			controlMenu.add(radioItems[i]);										//adding the buttons to the menu
			
			radioItems2[i] = new JRadioButtonMenuItem(radioNames[i], radioIcons[i]);				//defining the radio buttons
			radioItems2[i].setFont(new Font("Serif", Font.PLAIN, 14));									//setting the font
			radioItems2[i].addActionListener(new radioButtonsHandler());							///adding action  listeners to the radio buttons
			group.add(radioItems2[i]);

			controlPopMenu.add(radioItems2[i]);										//adding the buttons to the menu
		}
		menuItems[3].add(controlMenu);												//adding a menu to another menu
		
		popMenu.add(controlPopMenu);
		int f=1;
		for(int i=0; i<checkBoxNames.length;i++){
			
			checkbox[i]=new JCheckBox(checkBoxNames[i],popUpicons[f++]);
			checkbox[i].setFont(controlPopMenu.getFont());												//setting the font
			checkbox[i].setBorder(BorderFactory.createRaisedBevelBorder());
			checkbox[i].addItemListener(new checkBoxHandler());
			popMenu.add(checkbox[i]);
			
		}
		checkbox[0].setSelected(true);
		
		popExit=new JMenuItem("Exit the program",popUpicons[3]);
		popExit.setBorder(BorderFactory.createLoweredBevelBorder());
		popExit.setFont(controlPopMenu.getFont());													//setting the font
		popExit.addActionListener(new  menuItemHandler() );
		
		popMenu.add(popExit);

		desktop = Desktop.getDesktop();
		fileChooser = new JFileChooser();

		titledBorder = BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK),
				"I'll Be Your Guide", TitledBorder.CENTER, TitledBorder.ABOVE_TOP);
		titledBorder.setTitleFont(new Font("Serif", Font.BOLD, 18));

		sliderBorder = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),
				"Drag To Vary The Switch Speed", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
		sliderBorder.setTitleFont(new Font("Comic Sans MS", Font.PLAIN, 18));

		variableBorder = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),
				"Adjust A Specific Light", TitledBorder.CENTER, TitledBorder.ABOVE_BOTTOM);
		variableBorder.setTitleFont(new Font("Serif", Font.PLAIN, 18));

		terminalBorder = BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Real Time Terminal",
				TitledBorder.CENTER, TitledBorder.BELOW_TOP);
		mainPanelBorder = BorderFactory.createMatteBorder(10, 50, 10, 20, Color.black);

		Border loweredBorder = BorderFactory.createLoweredBevelBorder();
		TitledBorder speedPanelBorder = BorderFactory.createTitledBorder(loweredBorder, "Lights Switching Speed",
				TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION);
		speedPanelBorder.setTitleFont(sliderBorder.getTitleFont());

		tf1 = new JTextField();
		tf1.setEditable(false);
		tf1.setBorder(BorderFactory.createLoweredBevelBorder());
		tf1.setBackground(Color.LIGHT_GRAY);
		tf1.setBounds(0, 501, 545, 10);

		tf2 = new JTextField();
		tf2.setEditable(false);
		tf2.setBorder(BorderFactory.createLoweredBevelBorder());
		tf2.setBackground(Color.LIGHT_GRAY);
		tf2.setBounds(0, 340, 545, 10);

		tf3 = new JTextField();
		tf3.setEditable(false);
		tf3.setBorder(BorderFactory.createLoweredBevelBorder());
		tf3.setBackground(Color.LIGHT_GRAY);
		tf3.setBounds(0, 122, 545, 10);

		tf4 = new JTextField();
		tf4.setEditable(false);
		tf4.setBorder(BorderFactory.createLoweredBevelBorder());
		tf4.setBackground(Color.LIGHT_GRAY);
		tf4.setBounds(0, 230, 545, 10);

		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 960, 675);
		mainPanel.setBorder(mainPanelBorder);
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(51,51,51));

		parentPanel = new paintPanelClass();
		parentPanel.setBounds(570, 10, 390, 660);
		parentPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		parentPanel.setLayout(null);
		parentPanel.setBackground(new Color(153, 153, 204));

		threadPanel = new JPanel();
		threadPanel.setBounds(150, 0, 240, 660);
		threadPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		threadPanel.setLayout(null);

		trafficPanel = new paintPanelClass2();
		trafficPanel.setBorder(titledBorder);
		trafficPanel.setBounds(5, 5, threadPanel.getWidth() - 10, threadPanel.getHeight() - 10);
		trafficPanel.setBackground(new Color(153, 153, 153));

		componentPanel = new JPanel();
		componentPanel.setBackground(new Color(153, 102, 102));
		componentPanel.setBounds(5, 0, 550, 670);
		componentPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		componentPanel.setLayout(null);

		for (int i = 0; i < movingStrings.length; i++) {

			movingLabel[i] = new JLabel(movingStrings[i]);
			movingLabel[i].setFont(new Font("Serif", Font.BOLD, 38));
			componentPanel.add(movingLabel[i]);

		}
		
		terminalPanel = new JPanel();
		terminalPanel.setBackground(Color.BLACK);
		terminalPanel.setBounds(5, 510, componentPanel.getWidth() - 10, 155);
		terminalBorder.setTitleColor(new Color(0, 158, 0));
		terminalBorder.setTitleFont(new Font("Serif", Font.BOLD, 20));
		terminalPanel.setBorder(terminalBorder);
		terminalPanel.setLayout(new BorderLayout());

		iconPanel = new JPanel();
		iconPanel.setBackground(Color.darkGray);
		iconPanel.setBounds(5, 350, componentPanel.getWidth() - 230, 151);
		iconPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		iconPanel.addKeyListener(new keyHandler());
		iconPanel.addMouseListener(new popUpHandler());
		iconPanel.add(popMenu);
		
		iconPanel.setLayout(null);

		componentPanel.add(tf1);
		componentPanel.add(tf2);
		componentPanel.add(tf3);
		componentPanel.add(tf4);

		carPanel = new JPanel();
		carPanel.setBackground(Color.DARK_GRAY);
		carPanel.setBounds(325, 350, 220, 151);
		carPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		carPanel.setLayout(new BorderLayout());
		carPanel.addKeyListener(new keyHandler());
		
		carLabel = new JLabel();

		circleA = new JLabel(new ImageIcon(getClass().getResource("trafficCircles/Arrow-icon.png")));
		circleA.setBounds(5, 0, 100, 151);
		circleA.setVisible(false);

		circleB = new JLabel(new ImageIcon(getClass().getResource("trafficCircles/Arrow-icon2.png")));
		circleB.setBounds(105, 0, 100, 151);
		circleB.setVisible(false);

		circleC = new JLabel(new ImageIcon(getClass().getResource("trafficCircles/Arrow-icon3.png")));
		circleC.setBounds(205, 0, 100, 151);
		circleC.setVisible(false);

		iconPanel.add(circleA);
		iconPanel.add(circleB);
		iconPanel.add(circleC);

		slider = new JSlider(SwingConstants.HORIZONTAL, 0, 5000, 1000);
		slider.setMajorTickSpacing(500);
		slider.setBounds(5, 42, componentPanel.getWidth() - 10, 80);
		slider.setOpaque(true);
		slider.setPaintTicks(true);
		slider.addChangeListener(new changeHandler());
		slider.setBorder(sliderBorder);
		slider.addMouseListener(new mouseHandler());
		slider.setBackground(new Color(102, 204, 255));
		slider.addKeyListener(new keyHandler());

		speedPanel = new JPanel();
		speedPanel.setBounds(5, 130, 540, 100);
		speedPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		speedPanel.setBackground(new Color(220, 220, 220));
		speedPanel.addKeyListener(new keyHandler());
		
		speedLabel = new JLabel(("Current: " + slider.getValue() + "ms ,Approx " + slider.getValue() / 1000 + " Sec"));
		speedLabel.setBorder(speedPanelBorder);
		speedLabel.setFont(new Font("Serif", Font.BOLD, 35));
		speedLabel.setBounds(10, 170, 497, 80); // 10,50,340,50
		speedLabel.addKeyListener(new keyHandler());

		timePanel = new JPanel();
		timePanel.setBounds(5, 240, 540, 100);
		timePanel.setBackground(new Color(224, 255, 255));
		timePanel.setBorder(BorderFactory.createLoweredBevelBorder());
		timePanel.setLayout(null);
		timePanel.addKeyListener(new keyHandler());

		variablePanel = new JPanel();
		variablePanel.setBorder(variableBorder);
		variablePanel.setBounds(5, 5, 200, 90);
		variablePanel.setLayout(null);
		variablePanel.setBackground(new Color(230, 230, 250));
		variablePanel.addKeyListener(new keyHandler());
		variablePanel.addMouseListener(new popUpHandler());

		timePanel.add(variablePanel);

		for(int i=0; i<3; i++){
			
			variablePanel.add(list[i]);
		}
		
		commandTf = new JTextField("Currently Awaiting Your Orders");
		commandTf.setFont(new Font("Serif", Font.BOLD, 30));
		commandTf.setForeground(new Color(0, 128, 0));
		commandTf.setBorder(BorderFactory.createEmptyBorder());
		commandTf.setBackground(Color.BLACK);
		commandTf.setBounds(5, 550, 550, 120);
		commandTf.addMouseListener(new mouseHandler());
		commandTf.addKeyListener(new keyHandler());

		speedPanel.add(speedLabel);
		componentPanel.add(slider);
		carPanel.add(carLabel, "Center");
		threadPanel.add(trafficPanel);
		parentPanel.add(threadPanel);
		mainPanel.add(componentPanel);
		mainPanel.add(parentPanel);
		terminalPanel.add(commandTf, "Center");
		componentPanel.add(terminalPanel);
		componentPanel.add(iconPanel);
		componentPanel.add(carPanel);
		componentPanel.add(speedPanel);
		componentPanel.add(timePanel);
		
		 buttomPanel=new JPanel();
		 buttomPanel.setBackground(Color.BLACK);
		 buttomPanel.setBounds(0,675,995,30);
		 buttomPanel.setLayout(null);
		 buttomPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.RED), BorderFactory.createLoweredBevelBorder()));
		
		buttomText=new JLabel(">>>>>>>>>>>>Menu bar is hidden press Alt key to unhide it<<<<<<<<<<<<<<<<");
		buttomText.setHorizontalAlignment(SwingConstants.CENTER);
		buttomText.setFont(new Font("Serif", Font.BOLD, 27));
		buttomText.setBounds(0,2,995,20);
		buttomText.setForeground(Color.RED);
		buttomText.addKeyListener(new keyHandler());
		buttomPanel.add(buttomText);

		my_Frame = new JFrame();
		my_Frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		my_Frame.setSize(1000,735);
		my_Frame.getContentPane().setBackground(Color.BLACK);
		my_Frame.setVisible(false);
		my_Frame.setLocation(5,0);
		my_Frame.setResizable(false);
		my_Frame.setLayout(null);
		my_Frame.addKeyListener(new keyHandler());
		my_Frame.addWindowListener(new windowHandler());

		my_Frame.setIconImage(img);
		my_Frame.setJMenuBar(menuBar);
		my_Frame.add(mainPanel);
		my_Frame.add(buttomPanel);
		
		for (int i = 0; i < movingTexts.length; i++) {

			my_Frame.add(trafficLabel[i]);

		}

		timerClass tm = new timerClass(0);
		time = new Timer(5000, tm);
		time.start();

		movingTextHandler ff = new movingTextHandler();
		ff.start();

		movingStringHandler sh = new movingStringHandler();
		sh.start();

		componentColorThreads cc = new componentColorThreads();
		cc.start();
		
		

		ty.programRunning();
		
		
		
		pans[0]=mainPanel;								//Initialising panel array pan to take a panel
		pans[1]=threadPanel;							//Initialising panel array pan to take a panel
		pans[2]=iconPanel;								//Initialising panel array pan to take a panel
		pans[3]=trafficPanel;							//Initialising panel array pan to take a panel
		pans[4]=parentPanel;							//Initialising panel array pan to take a panel
		pans[5]=speedPanel;								//Initialising panel array pan to take a panel
		pans[6]=componentPanel;							//Initialising panel array pan to take a panel
		pans[7]=terminalPanel;							//Initialising panel array pan to take a panel
		pans[8]=carPanel;								//Initialising panel array pan to take a panel
		pans[9]=timePanel;								//Initialising panel array pan to take a panel
		pans[10]=variablePanel;							//Initialising panel array pan to take a panel
		
			for(int i=0; i<pans.length; i++){
				
				
				defaultColor[i]=pans[i].getBackground();			//for loop that gets the colour of the panels
				
			}
		}
	
	private class keyHandler extends KeyAdapter {			//class that handles the key events 

		@Override
		public void keyReleased(KeyEvent e) {				//method of key listener that has been overridden

			commandTf.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
			commandTf.setForeground(Color.GREEN);
			time.stop();

			if (e.getKeyCode() == KeyEvent.VK_ALT) {

				menuBar.setVisible(true);
				try{
					menuBarThread.stop();
				}
				catch(Exception es){
					
					
				}
				

				for (int i = 0; i < 5; i++) {

					if (menuItems[i].getMnemonic() == 0) {

						menuItems[i].setMnemonic(keyEventMenu[i]);
					} else {

						menuItems[i].setMnemonic(0);
					}

				}
			} else if (e.getSource() == commandTf) {

				commandTf.setForeground(new Color(0, 128, 0));

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					command = commandTf.getText();

					if (command.equalsIgnoreCase("fuck") || command.equalsIgnoreCase("pussy")
							|| command.equalsIgnoreCase("you are a pussy") || command.equalsIgnoreCase("fuck you")
							|| command.equalsIgnoreCase("shut the fuck up") || command.equalsIgnoreCase("shut up")
							|| command.equalsIgnoreCase("fuck")) {

						if (warningCount == 0) {

							commandTf.setText("Offensive words are not allowed");
							commandTf.setForeground(Color.RED);
							Toolkit.getDefaultToolkit().beep();
							warningCount++;
							ty.yuck();

						} else if (warningCount == 1) {

							commandTf.setText("Last Warning, I don't tolerate such words!");
							commandTf.setForeground(Color.RED);
							Toolkit.getDefaultToolkit().beep();
							warningCount++;
							ty.yuck();
						} else if (warningCount == 2) {

							commandTf.setEditable(false);
							Toolkit.getDefaultToolkit().beep();

							try {
								ImageIcon kickOut = new ImageIcon(getClass().getResource("Kick/kick.png"));
                                  
								new AudioClass("A6");
								JOptionPane.showMessageDialog(null,
										"That's it  am kicking you \nout of here! in 3 Seconds:-{", "YOU ARE A MENACE!",
										JOptionPane.ERROR_MESSAGE, kickOut);
								ty.yuck();
								new AudioClass("A7");
								TimeUnit.SECONDS.sleep(3);
								
								System.exit(0);														//terminating the program;
								
							} catch (InterruptedException ex) {

								System.out.println("Ok you win, you have managed to override my commands");
							}
						}

					} else {

						
						for (int i = 0; i < my_Commands.length; i++) {

							if (command.equalsIgnoreCase(my_Commands[i])) {

								if (command.equalsIgnoreCase(my_Commands[0])
										|| command.equalsIgnoreCase(my_Commands[1])) {
									
									if (threadDetector == 0) {

										ty.threadStarted();
										thread = new threadClass(slider.getValue());
										thread.start();
										new AudioClass("A5");

										commandTf.setText("Thread Started");
										commandTf.setForeground(Color.RED);

										radioItems[0].setEnabled(false);
										radioItems[1].setEnabled(true);
										radioItems[2].setEnabled(false);
										radioItems[3].setEnabled(true);
										radioItems[4].setEnabled(true);
										radioItems[5].setEnabled(true);
										
										radioItems2[0].setEnabled(false);
										radioItems2[1].setEnabled(true);
										radioItems2[2].setEnabled(false);
										radioItems2[3].setEnabled(true);
										radioItems2[4].setEnabled(true);
										radioItems2[5].setEnabled(true);

										threadDetector = 1;
										break;

									} else {

										commandTf.setForeground(Color.RED);
										commandTf.setText("Thread, is already running");
										ty.wrongAction();
									}

								} else if (command.equalsIgnoreCase(my_Commands[2])
										|| command.equalsIgnoreCase(my_Commands[3])) {

									try {

										ty.threadStopped();
										thread.stop();
										carLabel.setIcon(null);
										carLabel.setForeground(Color.MAGENTA);
										carLabel.setText("Block");

										radioItems[0].setEnabled(true);
										radioItems[1].setEnabled(false);
										radioItems[2].setEnabled(true);
										radioItems[3].setEnabled(true);
										radioItems[4].setEnabled(true);
										radioItems[5].setEnabled(true);
										
										radioItems2[0].setEnabled(true);
										radioItems2[1].setEnabled(false);
										radioItems2[2].setEnabled(true);
										radioItems2[3].setEnabled(true);
										radioItems2[4].setEnabled(true);
										radioItems2[5].setEnabled(true);

										commandTf.setText("Thread Stopped");
										new AudioClass("A13");
										threadDetector = 0;

									} catch (Exception ex) {

										commandTf.setText("Please Start The Thread First!");
										commandTf.setForeground(Color.RED);
										ty.wrongAction();

									}

								} else if (command.equalsIgnoreCase(my_Commands[4])
										|| command.equalsIgnoreCase(my_Commands[5])) {
									new AudioClass("A5");

									if (command.equalsIgnoreCase("hide menubar")) {

										if (menuBar.isVisible()) {

											menuBar.setVisible(false);

											commandTf.setText("MenuBar hidden");
											commandTf.setForeground(Color.RED);
											
											menuBarThread=new buttomTextHandler();
											menuBarThread.start();
										} else {

											JOptionPane.showMessageDialog(my_Frame, "MenuBar is Already Hidden",
													"MenuBar is Not Visible", JOptionPane.ERROR_MESSAGE);
											ty.wrongAction();
										}
									} else if (!menuBar.isVisible()) {

										menuBar.setVisible(true);

										try{
											menuBarThread.stop();
											
										}catch(Exception es){
											
											Toolkit.getDefaultToolkit().beep();
										}

										commandTf.setText("MenuBar Revealed");
										commandTf.setForeground(Color.RED);
									} else {

										JOptionPane.showMessageDialog(my_Frame, "MenuBar is Already Visible",
												"MenuBar is Visible", JOptionPane.ERROR_MESSAGE);
										ty.wrongAction();
									}
								} else if (command.equalsIgnoreCase(my_Commands[6])
										|| command.equalsIgnoreCase(my_Commands[7])
										|| command.equalsIgnoreCase(my_Commands[8])
										|| command.equalsIgnoreCase(my_Commands[9])) {
									new AudioClass("A5");

									new AboutClass();
									ty.aboutOpened();
									commandTf.setText("He's My Maker i.e,@ Frankline Sable");
									commandTf.setForeground(Color.RED);

								} else if (command.equalsIgnoreCase(my_Commands[10])) {
									new AudioClass("A5");

									Date date = new Date();

									commandTf.setText("Date Today is " + date.getDate() + " /" + date.getMonth() + " /"
											+ date.getYear());
									commandTf.setForeground(Color.RED);
								} else if (command.equalsIgnoreCase(my_Commands[11])) {
									
									new AudioClass("A5");

									Date date = new Date();

									commandTf.setText("Time Now is " + date.getHours() + " :" + date.getMinutes() + " :"
											+ date.getSeconds());
									commandTf.setForeground(Color.RED);
								} else if (command.equalsIgnoreCase(my_Commands[12])
										|| command.equalsIgnoreCase(my_Commands[13])
										|| command.equalsIgnoreCase(my_Commands[14])
										|| command.equalsIgnoreCase(my_Commands[15])) {
									new AudioClass("A5");

									new SupportClass();
								} else if (command.equalsIgnoreCase(my_Commands[16])
										|| command.equalsIgnoreCase(my_Commands[17])) {
									
									commandTf.setFont(new Font("Serif", Font.BOLD, 50));
									commandTf.setText("Please Don't Go....:'-(");
									commandTf.setForeground(Color.RED);
									new AudioClass("A7");
									
									Object[] options = { "Yes, please", "No, thanks" };
									int x = randomNumber.nextInt(16) + 1;

									int n = JOptionPane.showOptionDialog(my_Frame, "Do you really want to exit?",
											"EXIT MY JAVA PROGRAM", JOptionPane.YES_NO_OPTION,
											JOptionPane.QUESTION_MESSAGE, exitIcons[x], options, options[1]);

									if (n == JOptionPane.YES_OPTION) {

										ty.programExiting();

										System.exit(0);														//terminating the program;
									}
									else{
										commandTf.setFont(new Font("Serif", Font.BOLD, 30));
										new AudioClass("A5");
										commandTf.setText("Thanks, i appreciate it. :-^)");
									}
									
									
								} else if (command.equalsIgnoreCase(my_Commands[18])
										|| command.equalsIgnoreCase(my_Commands[19])) {

									
									InitialConvo v = new InitialConvo();
									v.movie();

									commandTf.setText("Did you enjoy it?");
									commandTf.setForeground(Color.RED);
								} else if (command.equalsIgnoreCase(my_Commands[20])
										|| command.equalsIgnoreCase(my_Commands[21])
										|| command.equalsIgnoreCase(my_Commands[22])) {
									
									new AudioClass("A11");
									commandTf.setText("Awwwww!!!");
									commandTf.setForeground(Color.RED);
								} else {

								}
								break;
							}
							if (i == my_Commands.length - 1) {

								commandFailed();
								Toolkit.getDefaultToolkit().beep();

							}
						}

					}

				} else {

				}
			}

		}
	}

	private class browseHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			time.stop();
			commandTf.setForeground(Color.RED);
			commandTf.setText("Browser opened...");
			ty.browserOpened();
			File histroyFile = new File(
					"C:\\Users\\Frankline Sable\\IdeaProjects\\New And Improved Programs Maseno\\Webpages\\Traffic light .htm");
			File knowHowFile = new File(
					"C:\\Users\\Frankline Sable\\IdeaProjects\\New And Improved Programs Maseno\\Webpages\\History of traffic light.htm");

			try {

				if (e.getSource() == helpMenuItems[3]) {

					desktop.open(knowHowFile);
				} else {

					desktop.open(histroyFile);
				}
			} catch (IOException ex) {

				System.err.println(ex);
			}
		}
	}

	private class helpMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			time.stop();
			commandTf.setText(null);
			if (e.getSource() == helpMenuItems[0]) {

				new SupportClass();

			} else if (e.getSource() == helpMenuItems[1]) {

				new LincesenseAgreement();
				ty.lincenceOpened();

			} else if (e.getSource() == helpMenuItems[2]) {

				new AboutClass();
				ty.aboutOpened();
			}
		}
	}

	private class menuItemHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == fileItems[0]) {

				int returnValue = fileChooser.showOpenDialog(fileChooser);

				if (returnValue == JFileChooser.APPROVE_OPTION) {

					try {
						desktop.open(fileChooser.getSelectedFile());
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}

			} else if (e.getSource() == fileItems[1]) {
				
				new AudioClass("A7");
				ty.programExiting();
				System.exit(0);														//terminating the program;

			} else if (e.getSource() == fileItems[2]) {

				menuBar.setVisible(false);
				menuBarThread=new buttomTextHandler();
				menuBarThread.start();

			} else if (e.getSource() == fileItems[3] || e.getSource()==popExit) {

				time.stop();
				commandTf.setFont(new Font("Serif", Font.BOLD, 50));
				commandTf.setForeground(Color.RED);
				commandTf.setText("Please don't exit... :'-(");
				new AudioClass("A7");

				Object[] options = { "Yes, please", "No, thanks" };
				int x = randomNumber.nextInt(16) + 1;
				
				int n = JOptionPane.showOptionDialog(my_Frame, "Do you really want to exit?", "EXIT MY JAVA PROGRAM",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, exitIcons[x], options, options[1]);

				if (n == JOptionPane.YES_OPTION) {

					ty.programExiting();
					System.exit(0);														//terminating the program;
				}
				else{
					commandTf.setFont(new Font("Serif", Font.BOLD, 30));
					commandTf.setForeground(Color.MAGENTA);
					commandTf.setText("Thanks for heeding my plea... :-)");

				}
			}

		}
	}

	private class windowHandler extends WindowAdapter {									//class that listens to window events

		@Override
		public void windowClosing(WindowEvent e) {							///method thats override
			
			new AudioClass("A7");
			time.stop();
			commandTf.setFont(new Font("Serif", Font.BOLD, 50));				//setting the font
			commandTf.setForeground(Color.RED);									//setting the foreground
			commandTf.setText("Please don't exit... :'-(");
			Object[] options = { "Yes, please", "No, thanks" };					//creating button objects with options
			int x = randomNumber.nextInt(16) + 1;								//random class random number expected

			int m = JOptionPane.showOptionDialog(my_Frame, "Do you really want to exit?", "EXIT MY JAVA PROGRAM",		//dialog to ask if they want to exit
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, exitIcons[x], options, options[1]);

			if (m == JOptionPane.YES_OPTION) {										//if affirmative or yes is selected

				int n = randomNumber.nextInt(5) + 1;
				
				if(n==2){
					
					RateMe.call();
					my_Frame.dispose();											//terminating the program
				}
				else{
					
					ty.programExiting();
					System.exit(0);														//terminating the program;
				}
			}
			else{
				commandTf.setFont(new Font("Serif", Font.BOLD, 30));					//setting the font
				commandTf.setForeground(Color.MAGENTA);										//setting the foreground
				commandTf.setText("Woa, Thanks for listening...:-^)");
			}
		}
	}

	private class radioButtonsHandler implements ActionListener {				//class that handlers the radio buttons events

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {							//method that's override that handlers the radio buttons events

			time.stop();															//stopping the timer
			try {

				if (radioItems[0].isSelected()||radioItems2[0].isSelected()) {		//deciding which button is clicked			

					
					if (threadDetector == 0) {
						
						radioItems[0].setEnabled(false);
						radioItems[1].setEnabled(true);
						radioItems[2].setEnabled(false);
						radioItems[3].setEnabled(true);
						radioItems[4].setEnabled(true);
						radioItems[5].setEnabled(true);
						
						radioItems2[0].setEnabled(false);
						radioItems2[1].setEnabled(true);
						radioItems2[2].setEnabled(false);
						radioItems2[3].setEnabled(true);
						radioItems2[4].setEnabled(true);
						radioItems2[5].setEnabled(true);

						ty.threadStarted();
						thread = new threadClass(slider.getValue());
						thread.start();

						threadDetector = 1;

						commandTf.setForeground(Color.RED);
						commandTf.setText("Thread Started");
						new AudioClass("A2");
						
					} else {

						commandTf.setForeground(Color.RED);
						commandTf.setText("Thread, is already running");
						ty.wrongAction();
					}

				} else if (radioItems[1].isSelected()||radioItems2[1].isSelected()) { // stop

					ty.threadStopped();
					thread.stop();
					carLabel.setIcon(null);
					carLabel.setForeground(Color.MAGENTA);
					carLabel.setText("Block");

					radioItems[0].setEnabled(true);
					radioItems[1].setEnabled(false);
					radioItems[2].setEnabled(true);
					radioItems[3].setEnabled(true);
					radioItems[4].setEnabled(true);
					radioItems[5].setEnabled(true);
					
					radioItems2[0].setEnabled(true);
					radioItems2[1].setEnabled(false);
					radioItems2[2].setEnabled(true);
					radioItems2[3].setEnabled(true);
					radioItems2[4].setEnabled(true);
					radioItems2[5].setEnabled(true);

					commandTf.setText("Thread Stopped");
					new AudioClass("A4");
					threadDetector = 0;

				} else if (radioItems[2].isSelected()||radioItems2[2].isSelected()) { // resume

					if (threadDetector == 0) {

						ty.threadResumed();
						thread.stop();

						
						thread = new threadClass(slider.getValue());
						thread.start();
						

						radioItems[0].setEnabled(false);
						radioItems[1].setEnabled(true);
						radioItems[2].setEnabled(false);
						radioItems[3].setEnabled(true);
						radioItems[4].setEnabled(true);
						
						radioItems2[0].setEnabled(false);
						radioItems2[1].setEnabled(true);
						radioItems2[2].setEnabled(false);
						radioItems2[3].setEnabled(true);
						radioItems2[4].setEnabled(true);

						commandTf.setText("Thread Resumed");
						new AudioClass("A2");
						threadDetector = 1;
					} else {

						JOptionPane.showMessageDialog(my_Frame, "Thread Already Running.", "THREAD IS ALIVE!",
								JOptionPane.WARNING_MESSAGE);
						ty.wrongAction();
					}

				} else if (radioItems[3].isSelected() || radioItems2[3].isSelected()) { // interrupt

					thread.interrupt();
					ty.threadInterrupted();

					radioItems[0].setEnabled(true);
					radioItems[1].setEnabled(true);
					radioItems[2].setEnabled(true);
					radioItems[3].setEnabled(false);
					radioItems[4].setEnabled(true);
					radioItems[5].setEnabled(true);
					
					radioItems2[0].setEnabled(true);
					radioItems2[1].setEnabled(true);
					radioItems2[2].setEnabled(true);
					radioItems2[3].setEnabled(false);
					radioItems2[4].setEnabled(true);
					radioItems2[5].setEnabled(true);

					commandTf.setText("Thread Interrupted");
					new AudioClass("A13");
					threadDetector = 0;

				} else if (radioItems[4].isSelected() || radioItems2[4].isSelected()) { // suspend

					thread.suspend();
					ty.threadSuspended();

					radioItems[0].setEnabled(true);
					radioItems[1].setEnabled(true);
					radioItems[2].setEnabled(true);
					radioItems[3].setEnabled(true);
					radioItems[4].setEnabled(false);
					radioItems[5].setEnabled(true);
					
					radioItems2[0].setEnabled(true);
					radioItems2[1].setEnabled(true);
					radioItems2[2].setEnabled(true);
					radioItems2[3].setEnabled(true);
					radioItems2[4].setEnabled(false);
					radioItems2[5].setEnabled(true);

					commandTf.setText("Thread Suspended");
					new AudioClass("A13");
					threadDetector = 0;

				} else {
					
					ty.threadDestroyed();
					radioItems[0].setEnabled(true); // Destroy
					radioItems[1].setEnabled(true);
					radioItems[2].setEnabled(true);
					radioItems[3].setEnabled(true);
					radioItems[4].setEnabled(true);
					radioItems[5].setEnabled(false);
					
					radioItems2[0].setEnabled(true); // Destroy
					radioItems2[1].setEnabled(true);
					radioItems2[2].setEnabled(true);
					radioItems2[3].setEnabled(true);
					radioItems2[4].setEnabled(true);
					radioItems2[5].setEnabled(false);

					thread.stop();
					threadDetector = 0;
					commandTf.setFont(new Font("Serif", Font.BOLD, 30));
					commandTf.setText("Thread Destroyed SuccessFully");
					new AudioClass("A3");

					Graphics g = parentPanel.getGraphics();

					g.setColor(Color.BLACK); // Components Around The Circles
					g.fillRoundRect(180, 45, 180, 385, 150, 150);
					g.fillOval(220, 623, 100, 20);
					g.fillRect(260, 410, 20, 220);
					
					g.fillArc(170, 450, 50, 50, 360, 360);
					g.fillArc(170, 500, 50, 50, 360, 360);
					g.fillArc(170, 550, 50, 50, 360, 360);
					g.fillArc(0, 400, 140, 240, 360, 360);
					
					g.setColor(parentPanel.getBackground());
					g.fillRect(5, 40, 139, 350);
					
					g.setColor(Color.black);
					g.setFont(new Font("snap itc", Font.ITALIC + Font.BOLD, 32)); // #2D
					g.drawString("DEAD!", 5, 120);
					g.drawString("DEAD!", 2, 250);
					g.drawString("DEAD!", 0, 380);
					

					my_Frame.setTitle("Thread is Dead!");
					circleA.setVisible(true);
					circleB.setVisible(true);
					circleC.setVisible(true);
					circleA.setEnabled(false);
					circleB.setEnabled(false);
					circleC.setEnabled(false);

					carLabel.setIcon(null);
					carLabel.setForeground(Color.BLACK);
					carPanel.setBackground(Color.LIGHT_GRAY);
					carLabel.setText("Crash");
				}
			} catch (Exception ex) {

				Object[] option = { "Okay, I'd Just Forgot" };

				JOptionPane.showOptionDialog(my_Frame, "Hey! Thread is not running \nStart the Thread First!",
						"THREAD ISN'T ALIVE!", JOptionPane.ERROR_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(getClass().getResource("dialog/dialog.png")), option, option[0]);
			}
		}
	}

	private class threadClass extends Thread {

		private final int sleepTime;
		private int i = 0;

		public threadClass(int sleepTime) {

			this.sleepTime = sleepTime;

		}

		@Override
		public void run() {

			redDelay = intArray[list[0].getSelectedIndex()];
			yellowDelay = intArray[list[1].getSelectedIndex()];
			greenDelay = intArray[list[2].getSelectedIndex()];

			int redTime = sleepTime * redDelay / 100;
			int yellowTime = sleepTime * yellowDelay / 100;
			int greenTime = sleepTime * greenDelay / 100;

			Graphics g = parentPanel.getGraphics();
			g.setColor(Color.BLACK);
			

			for (;;) {

				try {
					// #Components
					g.setColor(Color.BLACK); // Components Around The Circles
					g.fillRoundRect(180, 45, 180, 385, 150, 150);
					g.fillOval(220, 623, 100, 20);
					g.fillRect(260, 410, 20, 220);

					g.setColor( Color.DARK_GRAY); // Other circles
					g.fillOval(210, 185, 115, 115);
					g.fillOval(210, 300, 115, 115);
					g.fillArc(0, 400, 140, 240, 360, 360);

					// #main circle
					g.setColor(color[i].brighter()); // #1 RED
					g.fillOval(210, 70, 115, 115);
					g.fillArc(0, 400, 140, 240, 120, 120); // arc1

					g.setFont(new Font("snap itc", Font.ITALIC + Font.BOLD, 32)); // #2
					// label
					g.drawString("STOP!", 5, 120);

					g.setColor(Color.RED);

					g.fillArc(170, 450, 50, 50, 120, 120);
					g.fillArc(170, 500, 50, 50, 360, 120);
					g.fillArc(170, 550, 50, 50, 240, 120);

					circleA.setVisible(true);
					circleB.setVisible(false);
					circleC.setVisible(false);

					circleA.setEnabled(true);
					circleB.setEnabled(true);
					circleC.setEnabled(true);

					carLabel.setIcon(null);
					carLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
					carLabel.setForeground(Color.RED);
					carLabel.setText("STOP");

					my_Frame.setTitle("You Can Cross, ----> Its Safe To Walk");

					this.sleep(redTime); // RED sleep
					i++; // white
					// Thread 2

					// #Components
					g.setColor(Color.BLACK); // Components Around The Circles
					g.fillRoundRect(180, 45, 180, 385, 150, 150);
					g.fillOval(220, 623, 100, 20);
					g.fillRect(260, 410, 20, 220);

					g.setColor(color[i].brighter()); // other circles
					g.fillOval(210, 300, 115, 115);
					g.fillOval(210, 70, 115, 115);
					g.fillArc(0, 400, 140, 240, 360, 120);

					g.setColor(parentPanel.getBackground()); // covering strings
					g.fillRect(5, 40, 139, 400);

					i++; // orange

					g.setColor(color[i].brighter()); // #2 ORANGE
					g.fillOval(210, 185, 115, 115);
					g.fillArc(0, 400, 140, 240, 360, 240); // arc2

					g.setFont(new Font("snap itc", Font.ITALIC + Font.BOLD, 28)); // #2
					// label
					g.drawString("READy!", 2, 250);

					g.fillArc(170, 450, 50, 50, 360, 240);
					g.fillArc(170, 500, 50, 50, 240, 240);
					g.fillArc(170, 550, 50, 50, 120, 240);

					circleA.setVisible(false);
					circleB.setVisible(true);
					circleC.setVisible(false);

					circleA.setEnabled(true);
					circleB.setEnabled(true);
					circleC.setEnabled(true);

					carLabel.setIcon(null);
					carLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 45));
					carLabel.setForeground(Color.ORANGE);
					carLabel.setText("WAIT");

					my_Frame.setTitle("Be Patient The Cars Are About To Stop");

					this.sleep(yellowTime);
					i++; // white

					/*
					 * Thread 3 Green Light
					 */
					g.setColor(Color.BLACK);
					g.fillRoundRect(180, 45, 180, 385, 150, 150);
					g.fillOval(220, 623, 100, 20);
					g.fillRect(260, 410, 20, 220);

					g.setColor(color[i].brighter());
					g.fillOval(210, 70, 115, 115);
					g.fillOval(210, 185, 115, 115);
					g.fillArc(0, 400, 140, 240, 360, 240);

					g.setColor(parentPanel.getBackground()); // cover labels
					g.fillRect(5, 40, 139, 400);

					i++;// green

					g.setColor(color[i].brighter()); // #3 Green circle
					g.fillOval(210, 300, 115, 115);
					g.fillArc(0, 400, 140, 240, 360, 360);

					g.setFont(new Font("snap itc", Font.ITALIC + Font.BOLD, 55));
					g.drawString("GO!", 0, 350);
					
					g.fillArc(170, 450, 50, 50, 360, 360);
					g.fillArc(170, 500, 50, 50, 360, 360);
					g.fillArc(170, 550, 50, 50, 360, 360);

					circleA.setVisible(false);
					circleB.setVisible(false);
					circleC.setVisible(true);

					circleA.setEnabled(true);
					circleB.setEnabled(true);
					circleC.setEnabled(true);

					carLabel.setText(null);
					carLabel.setIcon(anime);

					my_Frame.setTitle("Please, don't cross,---> Its Not Safe To Walk");

					this.sleep(greenTime);
					i++;// white
					/*
					 * Thread 4
					 */
					g.setColor(new Color(0, 0, 0));
					g.fillRoundRect(180, 45, 180, 385, 150, 150);
					g.fillOval(220, 623, 100, 20);
					g.fillRect(260, 410, 20, 220);
					g.fillArc(0, 400, 140, 240, 360, 360);

					g.setColor(Color.LIGHT_GRAY);
					g.fillArc(170, 450, 50, 50, 360, 360);
					g.fillArc(170, 500, 50, 50, 360, 360);
					g.fillArc(170, 550, 50, 50, 360, 360);

					g.setColor(color[i].brighter());
					g.fillOval(210, 70, 115, 115);
					g.fillOval(210, 300, 115, 115);

  					g.setColor(parentPanel.getBackground());
					g.fillRect(5, 40, 139, 400);

					i++; // orange

					g.setColor(color[i]); // 						#4 ORANGE
					g.fillOval(210, 185, 115, 115);
					g.fillArc(0, 400, 140, 240, 360, 240); 				// arc2

					g.setFont(new Font("snap itc", Font.ITALIC + Font.BOLD, 28)); // #2
																		// label
					g.drawString("WALK!", 2, 250);

					g.fillArc(170, 450, 50, 50, 360, 240);
					g.fillArc(170, 500, 50, 50, 240, 240);
					g.fillArc(170, 550, 50, 50, 120, 240);

					circleA.setVisible(false);
					circleB.setVisible(true);
					circleC.setVisible(false);

					circleA.setEnabled(true);
					circleB.setEnabled(true);
					circleC.setEnabled(true);

					carLabel.setIcon(null);
					carLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 45));
					carLabel.setForeground(Color.ORANGE);
					carLabel.setText("WAIT");

					my_Frame.setTitle("Walk Fast Road Is About To Be Closed");

					this.sleep(yellowTime);

					g.setColor(parentPanel.getBackground());
					g.fillRect(5, 40, 139, 400);

					i = 0;

				} catch (InterruptedException ex) {

					my_Frame.setTitle("Someone Has Interferred With The Traffic System");

				} catch (ArrayIndexOutOfBoundsException ex) {

					
				}
			}
		}
	}

	private class changeHandler implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {

			time.stop();
			commandTf.setFont(new Font("Serif", Font.BOLD, 30));
			try {

				thread.stop();
				thread = new threadClass(slider.getValue());
				
				thread.start();

			} catch (Exception ex) {

				commandTf.setText("Start the thread  to feel the speed");
			}
			speedLabel.setText("Current: " + slider.getValue() + "ms ,Approx " + slider.getValue() / 1000 + " Sec");
			commandTf.setText("You're Varying the Speed...");

		}
	}

	private class timerClass implements ActionListener {

		private int count;

		private timerClass(int count) {

			this.count = count;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			count++;
			InitialConvo t = new InitialConvo();

			if (count == 2) {

				commandTf.setText(t.talkToMe());
				commandTf.setForeground(t.commandColor());

			} else if (count == 4) {

				commandTf.setText(t.talkToMe());
				commandTf.setForeground(t.commandColor());

			} else {

				commandTf.setText(t.talkToMe());
				commandTf.setForeground(t.commandColor());

				count = -1;
			}

		}
	}

	private class mouseHandler extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {

			if (e.getSource() == commandTf) {

				commandTf.setText(null);
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {

			if (e.getSource() == slider) {
				commandTf.setFont(new Font("Serif", Font.BOLD, 30));
			}
			commandTf.setText("Speed set to " + slider.getValue() + " milliseconds");
		}
	}

	private class commandHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			ty.wrongAction();
			Object[] option = { "Yes, I've Understood, and I'll Keep That i mind" };
			JOptionPane.showOptionDialog(my_Frame,
					"Hey! You aren't supposed click this, \nType any Of the commands you like,\n"
							+ " into the command box below(Labeled :" + terminalBorder.getTitle() + ")",
					"USE THE TERMINAL", JOptionPane.ERROR_MESSAGE, JOptionPane.WARNING_MESSAGE, exitIcons[1], option,
					option[0]);
			
		}
	}

	public void commandFailed() {

		commandTf.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		commandTf.setText("'" + commandTf.getText() + "' is not recognized as a valid command,");
		commandTf.setForeground(Color.RED);

		Toolkit.getDefaultToolkit().beep();
	}

	private class movingTextHandler extends Thread {

		@Override
		public void run() {

			for (;;) {
				try {

					for (int i = 0; i < movingTexts.length; i++) {

						int n = randomNumber.nextInt(commandColor.length);
						trafficLabel[i].setForeground(commandColor[n]);
						trafficLabel[i].setText(movingTexts[i]);
						Thread.sleep(100);
					}
					for (int i = 0; i < movingTexts.length; i++) {

						trafficLabel[i].setForeground(Color.BLACK);

					}
					for (int i = movingTexts.length - 1; i >= 0; i--) {

						int n = randomNumber.nextInt(commandColor.length);
						trafficLabel[i].setForeground(commandColor[n]);
						trafficLabel[i].setText(movingTexts[i]);
						Thread.sleep(100);
					}
					for (int i = 0; i < movingTexts.length; i++) {

						trafficLabel[i].setForeground(Color.BLACK);

					}

					for (int i = 0; i < movingTexts2.length; i++) {

						int n = randomNumber.nextInt(commandColor.length);
						trafficLabel[i].setForeground(commandColor[n]);
						trafficLabel[i].setText(movingTexts2[i]);
						Thread.sleep(100);
					}
					for (int i = 0; i < movingTexts2.length; i++) {

						trafficLabel[i].setForeground(Color.BLACK);

					}
					for (int i = movingTexts2.length - 1; i >= 0; i--) {

						int n = randomNumber.nextInt(commandColor.length);
						trafficLabel[i].setForeground(commandColor[n]);
						trafficLabel[i].setText(movingTexts2[i]);
						Thread.sleep(100);
					}
					for (int i = 0; i < movingTexts2.length; i++) {

						trafficLabel[i].setForeground(Color.BLACK);

					}
				} catch (InterruptedException ex) {

					System.out.println(ex);
				}
			}
		}

	}

	private class listItemHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {

			time.stop();
			commandTf.setFont(new Font("Serif", Font.BOLD, 30));
			try {
				ty.valueChanged();
				thread.stop();
				thread = new threadClass(slider.getValue());
				thread.start();

			} catch (Exception ex) {

				commandTf.setText("Start the thread  to feel the speed");
			}
			commandTf.setText("Value Changed Successfully");

			/*
			 * int a=10; for(int i=0;i<movingStrings.length;i++){
			 * 
			 * movingLabel[i]=new JLabel(movingStrings[i]);
			 * movingLabel[i].setBounds(a,5,30,30); movingLabel[i].setFont(new
			 * Font("Serif", Font.BOLD, 30));
			 * componentPanel.add(movingLabel[i]);
			 * 
			 * a+=22; }
			 */
		}
	}
	public void mainMethod(){
		
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
				TraFFic_LiGHt_SimULator gui = new TraFFic_LiGHt_SimULator();			//Creating and instance of the outer class which calls its constructor
				gui.my_Frame.setTitle("Welcome To The Traffic Light System Hardware Simulator***");		//Setting title onto the frame
				my_Frame.setVisible(true);
			}
			catch(InterruptedException ec){
				
				System.out.print(ec);
			}
			
		}
	}
	public static void main(String[] args) {
		
		TraFFic_LiGHt_SimULator ff=new TraFFic_LiGHt_SimULator();
		ff.mainMethod();
	}
	
private class movingStringHandler extends Thread {

		@Override
		public void run() {

			int a = -470;
			int b = -470;
			int c = -470;
			int d = -470;
			int e = -470;

			try {
				for (;;) {

					thread.sleep(50);
					movingLabel[0].setBounds(a, 0, 570, 50);
					movingLabel[0].setForeground(commandColor[randomNumber.nextInt(commandColor.length)]);
					a += 5;

					if (a > 350) {
						movingLabel[1].setBounds(b, 0, 570, 50);
						movingLabel[1].setForeground(commandColor[randomNumber.nextInt(commandColor.length)]);
						b += 5;
					}

					if (b > 350) {
						movingLabel[2].setBounds(c, 0, 570, 50);
						movingLabel[2].setForeground(commandColor[randomNumber.nextInt(commandColor.length)]);
						c += 5;
					}
					if (c > 350) {
						movingLabel[3].setBounds(d, 0, 570, 50);
						movingLabel[3].setForeground(commandColor[randomNumber.nextInt(commandColor.length)]);
						d += 5;
					}
					if (d > 350) {
						movingLabel[4].setBounds(e, 0, 570, 50);
						movingLabel[4].setForeground(commandColor[randomNumber.nextInt(commandColor.length)]);
						e += 5;
					}
					if (e > 550) {

						a = -470;
						b = -470;
						c = -470;
						d = -470;
						e = -470;
					}
				}
			} catch (InterruptedException ex) {

				System.out.println(ex);
			}

		}

	}

	private class componentColorThreads extends Thread {

		@Override
		public void run() {

			int i = 0;

			try {
				for (;;) {

					thread.sleep(5000);
					variablePanel.setBackground(backGround[i]);
					i++;
					if (i == backGround.length) {

						i = 0;
					}
				}
			} catch (InterruptedException ex) {

				System.out.println(ex);
			}

		}

	}private class popUpHandler extends MouseAdapter{
		
		@Override
		public void mouseReleased(MouseEvent e) {

			popUpMenu(e);
		}

		@Override
		public void mousePressed(MouseEvent e) {

			popUpMenu(e);
		}

		public void popUpMenu(MouseEvent e) {
			

			if (e.isPopupTrigger()) {

				new AudioClass("A15");
				popMenu.show(e.getComponent(), e.getX(), e.getY());
					
			}
		
		}
		
	}private class buttomTextHandler extends Thread {

		@Override
		public void run() {
int j=27;
int x=2;
Boolean done=false;
Boolean complete=false;
int a=805;

			for (;;) {
				try {

					for (int i = 0; i < commandColor.length; i++) {

						if(j>10){
							
							if(complete==false){
								
								buttomText.setForeground(Color.RED);
								buttomText.setBounds(0,2,995,20);
								buttomText.setText(">>>>>>>>>>>>Menu bar is hidden press Alt key to unhide it<<<<<<<<<<<<<<<<");
								
								Thread.sleep(3000);
								complete=true;
							}
													else{
								int n = randomNumber.nextInt(commandColor.length);
								buttomText.setForeground(commandColor[n]);
								buttomText.setFont(new Font(buttomText.getFont().getName(),buttomText.getFont().getStyle(),j));
								Thread.sleep(150);
								j-=1;
							}
							
						}
						
						else if(j==10){
							
							if(done==false){
								buttomText.setText(">>>>>You can alternatively enter a command in the command box above <<<<<<<");
								buttomText.setFont(new Font(buttomText.getFont().getName(),buttomText.getFont().getStyle(),27));
								buttomText.setForeground(Color.YELLOW);
								
								Thread.sleep(3000);
								done=true;;
							}
							else{
								
								if(x>=2 && x<30){
									int n = randomNumber.nextInt(commandColor.length);
									buttomText.setForeground(commandColor[n]);
									buttomText.setBounds(0,x,995,20);
									Thread.sleep(70);
									x+=1;
									
									
								}
							
								else if(x==30){
								
								int n = randomNumber.nextInt(commandColor.length);
								buttomText.setForeground(commandColor[n]);
								buttomText.setText("Don't drink and drive, Always adhere to the traffic rules.");
								buttomText.setBounds(a,2,995,20);
								Thread.sleep(2);
								a--;
								
								if(a==40){
									
									Thread.sleep(3000);
								
								}
								else if(a==-870){
									
									j=27;
									x=2;
									done=false;
									complete=false;
									a=805;
									
									
								}
							}
							
							}
							
						}
						
					}
					
				} catch (InterruptedException ex) {

					System.out.println(ex);
				}
			}
		}

	}private class checkBoxHandler implements ItemListener{		//class that handles the check box events 
		
		@Override
		public void itemStateChanged(ItemEvent e){				//Overriding methods
			
			if(e.getItem()==checkbox[0]){
				
				if(checkbox[0].isSelected()){					//Decision statement
				
				checkbox[0].setIcon(new ImageIcon(getClass().getResource("popMenuIcons/showMenubar.png")));
				
				menuBar.setVisible(true);
				try{
					menuBarThread.stop();
				}
				catch(Exception es){					//Catchimg exceptions
				}
				
				}
				else{
					
					checkbox[0].setIcon(popUpicons[1]);	
					menuBar.setVisible(false);
					menuBarThread=new buttomTextHandler();
					menuBarThread.start();
					
				
				}
			}
			else if(e.getItem()==checkbox[1]){
				
				if(checkbox[1].isSelected()){
					
					checkbox[1].setIcon(new ImageIcon(getClass().getResource("popMenuIcons/showTimer.png")));
					}
					else{
						checkbox[1].setIcon(popUpicons[2]);	
					}
			}
			}
	}
	private class prefHandler implements ActionListener{				//Handles events for the preferences menu
		
		private Color my_Color=Color.CYAN;								//Setting the background colour for panel, to the selected
		
		@Override
		public void actionPerformed(ActionEvent e){						//Overriding method
			
			if(e.getSource()==colorPick){
				
				my_Color=JColorChooser.showDialog(my_Frame, "Pick a Color To Use As The Appearance", my_Color);
																//Opening colour chooser
				if(my_Color==null){
					
					time.stop();
					for(int i=0; i<pans.length; i++){					//looping statement
						
						pans[i].setBackground(defaultColor[i]);				//Setting the background colour for panel, to the selected
						commandTf.setFont(new Font(commandTf.getFont().getName(),commandTf.getFont().getStyle(),30 ));
						commandTf.setForeground(Color.CYAN);				//Setting the background colour for panel, to the selected
						commandTf.setText("Default Color applied");
						slider.setBackground(Color.CYAN);					//Setting the background colour for panel, to the selected
						
					}
				}
				else{
						
					for(int i=0; i<pans.length; i++){
						
						pans[i].setBackground(my_Color);					//Setting the background colour for panel, to the selected
						
						time.stop();
						commandTf.setFont(new Font(commandTf.getFont().getName(),commandTf.getFont().getStyle(),20 ));
						commandTf.setForeground(my_Color);						//Setting the background colour for panel, to the selected
						commandTf.setText("Theme Color has been Changed to "+my_Color);
						slider.setBackground(Color.CYAN);						//Setting the background colour for panel, to the selected
						}
					}
				}
			else if(e.getSource()==colorButtons[0]){

				time.stop();											//stopping timer
				
				for(int i=0; i<pans.length; i++){
					
					pans[i].setBackground(defaultColor[i]);			//Setting the background colour for panel, to the selected
					commandTf.setFont(new Font(commandTf.getFont().getName(),commandTf.getFont().getStyle(),30 ));
					commandTf.setForeground(Color.CYAN);			//Setting the background colour for panel, to the selected
					commandTf.setText("Default Color applied");
					slider.setBackground(Color.CYAN);
					
				}}
			else if(e.getSource()==colorButtons[1]){
				
				mainPanel.setBackground(new Color(51,51,51));				//Setting the background colour for panel, to the selected
				threadPanel.setBackground(new Color(51,51,51));;			//Setting the background colour for panel, to the selected
				iconPanel.setBackground(new Color(51,51,51));;
				trafficPanel.setBackground(new Color(51,51,51));;			//Setting the background colour for panel, to the selected
				speedPanel.setBackground(new Color(102,0,102));;			//Setting the background colour for panel, to the selected
				componentPanel.setBackground(new Color(51,51,51));;
				terminalPanel.setBackground(new Color(51,51,51));;			//Setting the background colour for panel, to the selected
				carPanel.setBackground(new Color(51,51,51));;
				timePanel.setBackground(new Color(51,51,51));;
				variablePanel.setBackground(new Color(51,51,51));;			//Setting the background colour for panel, to the selected
				slider.setBackground(new Color(153,153,153));;
				speedLabel.setForeground(Color.WHITE);						//Setting the background colour for panel, to the selected
				parentPanel.setBackground(speedPanel.getBackground());		//Setting the background colour for panel, to the selected
				
			}
			else if(e.getSource()==colorButtons[2]){
				
				mainPanel.setBackground(new Color(204, 204, 204));				//Setting the background colour for panel, to the selected
				threadPanel.setBackground(new Color(204, 204, 204));;
				iconPanel.setBackground(new Color(204, 204, 204));;				//Setting the background colour for panel, to the selected
				trafficPanel.setBackground(new Color(204, 204, 204));;
				speedPanel.setBackground(new Color(204, 255, 255));;			//Setting the background colour for panel, to the selected
				componentPanel.setBackground(new Color(204, 204, 204));;		//Setting the background colour for panel, to the selected
				terminalPanel.setBackground(new Color(204, 204, 204));;
				carPanel.setBackground(new Color(204, 204, 204));;				//Setting the background colour for panel, to the selected
				timePanel.setBackground(new Color(204, 204, 204));;
				variablePanel.setBackground(new Color(204, 204, 204));;			//Setting the background colour for panel, to the selected
				slider.setBackground(new Color(255,255,255));;					//Setting the background colour for panel, to the selected
				speedLabel.setForeground(Color.BLACK);
				parentPanel.setBackground(speedPanel.getBackground());			//Setting the background colour for panel, to the selected
				
			}
			else if(e.getSource()==colorButtons[3]){
				
				mainPanel.setBackground(new Color(204, 51, 255));			//Setting the background colour for panel, to the selected
				threadPanel.setBackground(new Color(204, 51, 255));			//Setting the background colour for panel, to the selected
				iconPanel.setBackground(new Color(153,51,0));;				//Setting the background colour for panel, to the selected
				trafficPanel.setBackground(new Color(204, 0, 51));			//Setting the background colour for panel, to the selected
				speedPanel.setBackground(new Color(204, 102, 153));			//Setting the background colour for panel, to the selected
				componentPanel.setBackground(new Color(0,51,102));			//Setting the background colour for panel, to the selected
				terminalPanel.setBackground(new Color(0,51,102));			//Setting the background colour for panel, to the selected
				carPanel.setBackground(new Color(255, 51, 0));				//Setting the background colour for panel, to the selected
				timePanel.setBackground(new Color(204, 51, 255));			//Setting the background colour for panel, to the selected
				variablePanel.setBackground(new Color(204, 51, 255));		//Setting the background colour for panel, to the selected
				slider.setBackground(new Color(255,255,255));				//Setting the background colour for panel, to the selected
				speedLabel.setForeground(Color.BLACK);						//Setting the background colour for panel, to the selected
				parentPanel.setBackground(new Color(102, 0, 102));			//Setting the background colour for panel, to the selected
				
			}
				
				
			}
		}
	private class paintPanelClass extends JPanel{
		
		@Override
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			
		}
	}
	private class paintPanelClass2 extends JPanel{
		
		@Override
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			
			g.setColor(new Color(160, 160, 160)); // Components Around The Circles
			g.fillRoundRect(25, 40, 180, 385, 150, 150);
			g.fillOval(65, 623, 100, 20);
			g.fillRect(105, 410, 20, 220);

			g.setColor(new Color(170, 170, 170)); // Other circles
			g.fillOval(55, 70, 115, 115);
			g.fillOval(55, 185, 115, 115);
			g.fillOval(55, 300, 115, 115);
			
			
		}
	}
	}										//END OF PROGRAM, OUTER CLASS TERMINATED


