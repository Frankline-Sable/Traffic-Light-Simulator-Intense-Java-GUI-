/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realTime_Traffic_Simulator;

import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.AWTException;
import java.awt.Font;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.MenuItem;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.net.URL;
import java.util.Random;
import java.util.Date;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;

/**
 *
 * @author Frankline Sable
 */
public class SystemTrayClass {

	private static URL trayIcon; // url object that enables us to open the
									// browser
	private static Image img; // object that holds the image
	private static ImageIcon imageIcon; // object that holds the image icon
	private final TrayIcon iconTray; // object that holds the tray icon
	private final SystemTray traySystem; // object that holds the tray system
	private final PopupMenu popMenu; // object that holds the pop up menu
	private final MenuItem menu[] = new MenuItem[10]; // array of menu items
	private String menuNames[] = { "Rate us please", "Feedback", "Lincence", "About", "Exit" }; // menu
																								// item
																								// names
	private int count = 0; // initialising the count variable
	private int value = 0; // initialising the value variable
	private final Icon exitIcons[] = new Icon[20]; // Creates an array of icons
	private Random randomNumber = new Random(); // defining the random number
												// class
	private String log_Dir[] = new String[1000000];
	private File scanFile;
	private PrintStream log;
	private SystemThread st;

	public SystemTrayClass() { // Outer class constructor

		try {
			for (int i = 1; i < log_Dir.length; i++) {

				log_Dir[i] = "C:\\Users\\Frankline Sable\\IdeaProjects\\New And Improved Programs Maseno\\src\\Logs_Compilation\\Subclasses\\SystemTrayClassAttempt["
						+ i + "].txt";
				scanFile = new File(log_Dir[i]);

				if (!scanFile.exists()) {

					log = new PrintStream(log_Dir[i]);
					log.println("\t\t\t\t<----- <------------- Starting Log Generator ----------------> ------>");
					log.println("");
					log.println("\t\t\t\t\t>>>>>>>>>>>>@COPYRIGHT FRANKLINE SABLE<<<<<<<<<<<<");
					log.println("\t\t\t\t\t\t\t\t||| ");
					log.println(
							"WARNING -->\t {This Log has been Automatically Generated For The System Tray Class, Please Do Not Edit Anything In Here}");
					log.println("");
					log.println("Log Number " + i + " As  On: " + new Date());
					log.println("");
					log.println("\t\t\t\t<----- Initialising System Tray Class----->\n");
					log.println("");
					break;
				}
			}

		} catch (FileNotFoundException ex) {

			System.out.println("Cannot Find "
					+ "C:\\Users\\Frankline Sable\\IdeaProjects\\New And Improved Programs Maseno\\src\\Logs_Compilation\\Subclasses\\SystemTrayClassAttempt[i]].txt");

		}

		for (int i = 0; i < 17; i++) { // looping structure

			exitIcons[i] = new ImageIcon(getClass().getResource("ExitIcons/exit" + i + ".png")); // For
			log.println(new Date()+": ExitIcons/exit" + i + ".png"+" Loaded Successfully");																					// loop
																									// used
																									// for
																									// importing
																									// several
																									// image
																									// icons

		}
		log.println("");

		iconTray = new TrayIcon(trayImage()); // defining the tray icon
		traySystem = SystemTray.getSystemTray(); // defining the system tray

		popMenu = new PopupMenu(); // creating a pop up menu

		for (int i = 0; i < menuNames.length; i++) { // looping structure

			menu[i] = new MenuItem(menuNames[i]); // defining menu items
			menu[i].addActionListener(new menuTrayHandler()); // adding action
																// listeners to
																// the items
			menu[i].setFont(new Font("Serif", Font.PLAIN, 14));
			popMenu.add(menu[i]);

		}
		iconTray.setPopupMenu(popMenu); // adding pop up menu

		try {

			traySystem.add(iconTray); // adding tray icon to system tray

		} catch (AWTException e) { // catching system tray exceptions

			System.out.println(e);
		}
	}

	protected static Image trayImage() { /// method that returns an image

		trayIcon = SystemTrayClass.class.getResource("TrayIcon/trayIcon.png"); // setting
																				// the
																				// icon
																				// from
																				// the
																				// disk
		imageIcon = new ImageIcon(trayIcon); // setting the icon from the disk
		img = imageIcon.getImage(); // setting the image from the disk

		return img; // returning an image
	}

	public void threadStarted() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B1");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B1");
			st.start();
		}
	}

	public void threadDestroyed() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B2");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B2");
			st.start();
		}
	}

	public void threadInterrupted() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B3");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B3");
			st.start();
		}
	}

	public void threadSuspended() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B4");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B4");
			st.start();
		}
	}

	public void threadResumed() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B5");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B5");
			st.start();
		}
	}

	public void programRunning() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B6");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B6");
			st.start();
		}
	}

	public void programExiting() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B7");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B7");
			st.start();
		}
		
	}

	public void threadStopped() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B8");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B8");
			st.start();
		}
	}

	public void aboutOpened() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B9");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B9");
			st.start();
		}
			
	}

	public void lincenceOpened() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B10");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B10");
			st.start();
		}
		
	}

	public void browserOpened() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B11");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B11");
			st.start();
		}
		
	}

	public void bugReport() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B12");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B12");
			st.start();
		}
		
	}

	public void crashLogs() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B13");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B13");
			st.start();
		}
		
	}

	public void yuck() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B14");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B14");
			st.start();
		}
		
	}

	public void wrongAction() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B15");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B15");
			st.start();
		}
		
	}

	public void valueChanged() { // method for the system tray class

		try{
			st.stop();
			st=new SystemThread("B16");
			st.start();
		}
		catch(Exception e){
			
			st=new SystemThread("B16");
			st.start();
		}
		
	}

	private class menuTrayHandler implements ActionListener { // class that
																// handles the
																// action

		@Override
		public void actionPerformed(ActionEvent e) { // method that handles the
														// action

			if (e.getSource() == menu[0]) {

				RateMe.call();
				log.println(new Date()+": Rating class Opened");
			}

			else if (e.getSource() == menu[1]) {

				new SupportClass(); // calling another class
				log.println(new Date()+": Support class Opened");
			} else if (e.getSource() == menu[2]) {

				new LincesenseAgreement(); // calling another class
				log.println(new Date()+": Lincenxe class Opened");
			} else if (e.getSource() == menu[3]) {

				new AboutClass(); // calling another class
				log.println(new Date()+": About class Opened");
			} else {

				Object[] options = { "Yes, please", "No, thanks" }; // two
																	// buttons
																	// in the
																	// dialog
				int x = randomNumber.nextInt(16) + 1;

				int n = JOptionPane.showOptionDialog(null, "Do you really want to exit?", "EXIT MY JAVA PROGRAM", // dialog
																													// is
																													// created
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, exitIcons[x], options, options[1]);

				if (n == JOptionPane.YES_OPTION) {

					programExiting();
					traySystem.remove(iconTray); // removing icon from the
													// system tray
					log.println("");
					log.println(new Date()+": Program exited");
					log.println(new Date()+"\t\t ~~~~~~LOG TERMINATED~~~~~~");
					
					System.exit(0); // terminating the program
				} else {

				}

			}
		}
	}
	private class SystemThread extends Thread{
		
		private final String whichNotification;
		
		public SystemThread(String notifyMe){
			
			whichNotification=notifyMe;
			
		}
		@Override
		public void run(){
			
			switch(whichNotification){
			
			case "B1":
				
				iconTray.displayMessage("Thread Started Successfully!", "Now let the show begin!!!",TrayIcon.MessageType.NONE);
				log.println(new Date()+": Thread is started");
				
				break;
				
			case "B2":
				
				iconTray.displayMessage("Thread Destroyed", "You're a dead man!", TrayIcon.MessageType.ERROR);
				log.println(new Date()+": Thread is destroyed");
				
				break;
				
			case "B3":
				
				iconTray.displayMessage("Thread interrupted", "Hey stop bugging me!", TrayIcon.MessageType.WARNING);
				log.println(new Date()+": Thread is interrupted");	
				
				break;
				
			case "B4":
				
				iconTray.displayMessage("Thread Suspended", "Hey, bring the beat back! :-(", TrayIcon.MessageType.INFO);
				log.println(new Date()+": Thread is suspended");
				
				break;
				
			case "B5":
				
				iconTray.displayMessage("Thread resumed", "Let the party continue, even harder than before",
						TrayIcon.MessageType.NONE);
				log.println(new Date()+": Thread is resumed");	
				
				break;
				
			case "B6":
				
				iconTray.displayMessage("Welcome To The Program!", "@Copyright Frankline Sable, the author.",
						TrayIcon.MessageType.INFO);
				log.println(new Date()+": Program is running ");
				
				break;
				
			case "B7":
				
				iconTray.displayMessage("You Exited The Program!", "Was it that boring?, blame Frankline",
						TrayIcon.MessageType.ERROR);
				log.println(new Date()+": Program exited, ~~~~~~~~~~LOG TERMINANTED~~~~~~~~~~");	
				
				break;
				
			case "B8":
				
				iconTray.displayMessage("Thread Stopped Successfully", "Hey you are causing traffic jams!",
						TrayIcon.MessageType.WARNING);
				log.println(new Date()+": Thread is stopped");	
				break;
				
			case "B9":
				
				iconTray.displayMessage("About Section ", "Isn't he handsome?", TrayIcon.MessageType.INFO);
				log.println(new Date()+": About class has been initialised");
				
				break;
				
			case "B10":
				
				iconTray.displayMessage("Lincense Agreement", "Bla bla bla no one follows this these days",
						TrayIcon.MessageType.WARNING);
				log.println(new Date()+": Lincence class has been initialised");	
				
				break;
				
			case "B11":
				
				iconTray.displayMessage("Browser is opening", "Don't forget to like my Facebook Page",
						TrayIcon.MessageType.WARNING);
				log.println(new Date()+": Browser opened");	
				
				break;
				
			case "B12":
			
				iconTray.displayMessage("Report Sent", "Its actually saved somewhere in this Computer",
						TrayIcon.MessageType.WARNING);
				log.println(new Date()+": Bug report entered  and has been saved");	
				
				break;
				
			case "B13":
				
				iconTray.displayMessage("Crash Logs Generated", "Program is just fine, don't worry about it",
						TrayIcon.MessageType.WARNING);
				log.println(new Date()+": Crash Logs generated");	
				
				break;
				
			case "B14":
				
				if (count == 0) {

					iconTray.displayMessage("Dirty Word Caught", "Yuck, you are a dirty Fellow", TrayIcon.MessageType.WARNING);
					count++;
					log.println(new Date()+": Disorderly Conduct, First Attempt");	
				} else if (count == 1) {

					iconTray.displayMessage("Dirty Thing Mentioned", "Nasty guy, really nasty", TrayIcon.MessageType.WARNING);
					count++;
					log.println(new Date()+": Disorderly Conduct, Second Attempt");	
				} else {
					iconTray.displayMessage("Heads up", "Guess you didn't saw that coming huh?", TrayIcon.MessageType.ERROR);
					count = 0;
					log.println(new Date()+": Disorderly Conduct, Last Attempt");	
				}
			case "B15":
				
				iconTray.displayMessage("Wrong Action", "Hahaha  you are absolutely crazy, how could you think of doing that?",
						TrayIcon.MessageType.WARNING);
				log.println(new Date()+": Wrong action Occurred");;	
				
				break;
				
			case "B16":
				
				if (value == 1) {

					iconTray.displayMessage("Value Changed Successfully", "Pump the beat! Pump the beat!?",
							TrayIcon.MessageType.INFO);
					value++;
					log.println(new Date()+": Thread time changed");	
				} else if (value == 2) {

					iconTray.displayMessage("Value Changed yet Again", "The beat is getting louder and louder.",
							TrayIcon.MessageType.INFO);
					value++;
					log.println(new Date()+": Thread time changed");
				} else {
					iconTray.displayMessage("Value Changed :-/",
							"Huh, am getting sick of this, \nhey Frankline i didn't sign up for this shit.",
							TrayIcon.MessageType.INFO);

					value = 0;
					log.println(new Date()+": Thread time changed");

				}
				break;
				
				default:
					
					System.out.println("Wrong Argument in System Tray class");
					break;
					
			
			}
		}
	}
}
