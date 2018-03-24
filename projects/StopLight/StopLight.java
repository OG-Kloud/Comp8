import javax.swing.*;
import java.awt.*;
//Dont forget to import Timer.class and TimerTask.class
import java.util.Timer;
import java.util.TimerTask;

public class StopLight {
	//The window instance that the program will run in
	static JFrame frame= new JFrame();
	//variables to hold the 6 JPanel instances
	static JPanel one, two, three, content, black, black1;
	//a constant reference to the color black saves 6 charicters per reference
	static Color back = Color.BLACK;
	//used to iterate through the lights forflashing
	static int lightID = 0;
	//the delay between flashing (in milisecconds)
	static int delay =1000;
	
	public static void main(String[] args) {
		//used to take the graphics of the logic thread... a little more complicated but that is the jist
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initialize();
				timer();
			}
		});
		//if the arguments are not null - (if they exist)
		if(args.length !=0) {
			// parse the int from the argument string
			delay = Integer.parseInt(args[0])*60;
		}
	}
	//creates an instance of the java.util.Timer and java.util.TimerTask
	//to schedule the loop to rerun at the given interval
	public static void timer() {
		//the instance of timer
		Timer t = new Timer();
		//scheduleAtFixedRate is a method in Timer to schedule a task 
		t.scheduleAtFixedRate(new TimerTask() {
			//Override the run() method in this instanceof TimerTask
			@Override
			public void run(){
				loop();
			}
		}, 500, delay);
	}
	//code for looping through the differnet light states
	public static void loop() {
		System.out.println("called loop");
		//switch activates specific case based on the paramiter value
		switch(lightID) {
		//if the switch paramiter is 0:
		//remove all panels add the red(one) panel and the black and black1 panels
		//then set the lightID variable to the next integer and return;
		//return ends the call so the other cases cant be activate in this iteration
		case 0:
			content.removeAll();
			content.add(one);
			content.add(black);
			content.add(black1);
			content.revalidate();
			lightID++;
			return;
		//if the switch paramiter is 1:
		//remove all panels add the yellow(two) panel and the black and black1 panels
		//then set the lightID variable to the next integer and return;
		//return ends the call so the other cases cant be activate in this iteration
		case 1:
			content.removeAll();
			content.add(black);
			content.add(two);
			content.add(black1);
			content.revalidate();
			lightID++;
			return;
		//if the switch paramiter is 2:
		//remove all panels add the green(three) panel and the black and black1 panels
		//then set the lightID variable to 0 so case 0 gets activated on next loop() and return;
		//return ends the call so the other cases cant be activate in this iteration
		case 2:
			content.removeAll();
			content.add(black);
			content.add(black1);
			content.add(three);
			content.revalidate();
			lightID = 0;
			return;
		}
	}

	/**
	* initalizes the JPanels and sets the variables for size and layout where necessary
	* sets the variables for the frame for size exitting and visibility
	*/
	public static void initialize() {
		frame.setPreferredSize(new Dimension(125,400));
		frame.setSize(frame.getPreferredSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = new JPanel();
		content.setPreferredSize(new Dimension(125,400));
		content.setLayout(new GridLayout(3,1));
		one =new JPanel() {
			@Override
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.setColor(Color.RED);
				g.fillOval(25, 25, 75, 75);
			}
		};
		one.setBackground(back);
		two =new JPanel() {
			@Override
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.setColor(Color.YELLOW);
				g.fillOval(25, 25, 75, 75);
			}
		};
		two.setBackground(back);
		three=new JPanel() {
			@Override
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.setColor(Color.GREEN);
				g.fillOval(25, 25, 75, 75);
			}
		};
		black = new JPanel();
		black.setBackground(back);
		black1 = new JPanel();
		black1.setBackground(back);
		three.setBackground(back);
		frame.setVisible(true);
		frame.setContentPane(content);
	}

}
		