
import javax.swing.*;
import java.awt.*;

public class Lab2PT3 {
	

	public static void main(String[] args) {
		//create an instance of JFrame
		JFrame frame = new JFrame();
		frame.setTitle("Checkers");
		frame.setSize(300, 300);
		//dont forget to set the default close operation of the program will continue to run after the window 			//is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Obtain container instance from the frame
		//make sureand set the frame size prior to getting the container or set the container
		//size independantly - otherwise the frame will not show correctly untill the frame has been resized
		//and the container snaps to it
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		//for loop is used to add panels to the Container
		//make sure that the loop end number is correct otherwise it will break the LayoutManager instance
		for(int i = 0; i <= 8; i++) {
		//Modules is used to determine if the panels is an even numbered panel in the display
		//If it is an even numbered panel create a new JPanel instance and set background to yellow
			if(i%2 == 0) {
				JPanel var = new JPanel();
				var.setBackground(Color.yellow);
				pane.add(var);
		//if it is not and even numbered panel create a new JPanel instance and set the background to green
			} else {
				JPanel var = new JPanel();
				var.setBackground(Color.green);
				pane.add(var);
			}
		}
		frame.setVisible(true);
		
	}
}