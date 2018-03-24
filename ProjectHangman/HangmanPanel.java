import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class HangmanPanel extends JPanel {

	private Color draw;

	public HangmanPanel(Color background, Color drawColor) {
		setBackground(background);
		this.draw = drawColor;
	}

	public HangmanPanel(Color background) {
		this(background, Color.BLACK);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(draw);
	//	g.fillRect(getSize().width/2 - 25, getSize().height/2 -150, 50, 25);
		g.fillRect(getSize().width/2 - 25, getSize().height/2 -150, 175, 25);
		g.fillRect(getSize().width/2 + 150, getSize().height/2 - 150, 25, 175);
		if(Hangman.game.count >= 1)g.drawOval(getSize().width/2 - 62, getSize().height/2 - 125, 75, 75);
		if(Hangman.game.count >= 2) g.drawLine(getSize().width/2-25 ,getSize().height/2 -50 ,getSize().width/2-25 , getSize().height/2+100);
		if(Hangman.game.count >= 3) g.drawLine(getSize().width/2-25, getSize().height/2+0, getSize().width/2-100, getSize().height/2+50);
		if(Hangman.game.count >= 4) g.drawLine(getSize().width/2-25, getSize().height/2+0, getSize().width/2+50, getSize().height/2+50);
		if(Hangman.game.count >= 5) g.drawLine(getSize().width/2-25,getSize().height/2+100, getSize().width/2-100, getSize().height/2+175);
		if(Hangman.game.count >= 6) g.drawLine(getSize().width/2-25,getSize().height/2+100, getSize().width/2+50, getSize().height/2+175);
		Font font = new Font("ariel", Font.BOLD, 30);
		g.setFont(font);
		for(int i = 0, n = Hangman.game.converted.length(); i < n; i++) {
			g.drawString(String.valueOf(Hangman.game.converted.charAt(i) == '*' ? '_' : Hangman.game.converted.charAt(i)), ((getSize().width/2 - getSize().width/4) + i *35),getSize().height/2 + 200);
			//g.drawString(" ", getSize()/2 - getSize().width + i*200,getSize().height/2+100);
		}
	}
}