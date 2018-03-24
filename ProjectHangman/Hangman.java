import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Hangman {

	public static final Hangman game = new Hangman();
	private final String[] words = {"water", "baseball", "california", "game", "america"};
	private String word;
	public int count = 0;
	private final Scanner sc = new Scanner(System.in);
	private final Random random = new Random();
	public String converted;
	private boolean gameover = false;
	private HangmanPanel window = new HangmanPanel(Color.CYAN);
	private JFrame frame = new JFrame("Hangman");

	public void getGameString() {
		System.out.print("Enter a word, or random:> ");
		String s = sc.nextLine().toLowerCase();
		if(s.equalsIgnoreCase("random")) s = words[random.nextInt(words.length)];
		word = s;
		convert();
	}
	
	public void printRules() {
		System.out.println("*--------------------*");
		System.out.println("1.     Choose a word to play or enter random to use a random word.\n2.     Only guess one letter at a time\n3.    A duplicate guess"
			+ " counts as a wrong guess\n4.     Have Fun!!!!!");
		System.out.println("*--------------------*");
	}
	
	public void convert() {
		converted = new String(new char[word.length()]).replace('\0', '*');
	}
	public void gameloop() {
		count = 0;
		while(!gameover) {
			System.out.print("guess a letter:> ");
			char guess = sc.nextLine().toLowerCase().charAt(0);
			System.out.println("Your guess:> " + guess);
			processGuess(guess);
			System.out.println(converted);
		}
		if(count >= 7) {
			System.out.println("Sorry you were to late, the Hangman wins");
		}
	}

	public void processGuess(char g) {
		String temp = "";
		for(int i = 0, n = word.length(); i < n; i++) {
			if(word.charAt(i) == g) {
				temp += g;
			} else if(converted.charAt(i) != '*') temp += word.charAt(i);
			else temp += '*';
		}
		if(converted.equals(temp)){
			count++;
			game.window.repaint();	
		} else {
			converted = temp;
			System.out.println("Correct");
		}
		if(converted.equals(word)) {
			System.out.println("Correct, you win");
			gameover = true;
		}
		game.window.repaint();
		if(count >= 7) gameover = true;
		
		
	}

	public static void main(String[] args) {
		game.printRules();
		while(!game.gameover) {
			game.getGameString();
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					game.frame.setSize(400,600);
					game.frame.setVisible(true);
					Container container = game.frame.getContentPane();
					container.add(game.window);
				}
			});
			game.window.repaint();
			System.out.println(game.word);
			System.out.println(game.converted);
			game.gameloop();
			while(game.gameover) {
				System.out.print("Play again (Y\\n):> ");
				char c = game.sc.nextLine().charAt(0);
				if(c == 'n') System.exit(1);
				else if(c == 'y') game.gameover = false;
				else continue;
			}
		}
	}

}




