package realTime_Traffic_Simulator;

import java.awt.Desktop;
import java.io.File;
import java.util.Random;
import java.awt.Color;
import javax.swing.JOptionPane;

public class InitialConvo {
	
	 private Color commandColor[] = {Color.RED, Color.WHITE,Color.BLUE, Color.GREEN,Color.CYAN,Color.LIGHT_GRAY,Color.ORANGE, Color.PINK, Color.YELLOW,Color.MAGENTA};
	   private Random randomText=new Random();
	
	public String talkToMe() {
		
		String sillyTalk[]={"Traffic can be boring sometimes", "After all Accidents still happen", "These days, drivers are reckless!"
				,"Why aren't you clicking anything?", "people don't follow rules these days", "What if traffic lights had brains..."
				, "I hate school, dont know why	"," Click here at anytime to begin...","I'm just a Program, I've no say","I'm so social, not like others!",
				"Do I talk much? Maybe or maybe not." ," Are you impressed by the design?","Obey traffic rules & u'll survive"};
		
		String picked=sillyTalk[randomText.nextInt(sillyTalk.length)];
		return(picked );
		
		
	}
	
	
	public void movie(){
		
		new AudioClass("A12");
		File movieFile=new File("C:\\Users\\Frankline Sable\\IdeaProjects\\New And Improved Programs Maseno\\src\\Movie\\CLASH-A-RAMA!.mp4");
		Desktop desktop=Desktop.getDesktop();
		
		try{
			
			desktop.open(movieFile);
			
		}catch(Exception ex){
			
			JOptionPane.showMessageDialog(null,"I can't Play The Movie Right NOW.\n\nTry Again Later");
		}
		
	}
	public Color  commandColor(){
		
		Color myColor=commandColor[ randomText.nextInt(9) + 1];
		
		return myColor;
	}

}
