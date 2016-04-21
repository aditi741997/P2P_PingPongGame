import java.awt.*;
import Model.*;
import View.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Player
{
	/** This class acts as view model, linking model and view. **/
	private static Board Board_backend;
	private static GameBoard Board_UI;
	private static int timerDelay;
	private static Timer gameTimer;
	private static int M;

	public Player()
	{
		// a Board object
		Board_backend = new Board();
		Ball b = new Ball(0.0, 0.0, 200.0, 250.0, 25);
		// a GameBoard object
		// add a player to board!
		Board_backend.addBall(b);
		Board_UI = new GameBoard();
		timerDelay = 1000;
		gameTimer = new Timer(timerDelay, timerAction);
		gameTimer.start();
		M =0;

	}

	public static void main(String[] args)
	{
		Player p1 = new Player();
	}

	static ActionListener timerAction = new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Timer working!");
			// call Board_UI ka update function.
			ArrayList<Ball> updatedBalls = Board_backend.getBalls();
			ArrayList<Paddle> updatedPaddles = Board_backend.getPaddles();
			Board_UI.reDraw(updatedBalls, updatedPaddles);
			M += 1;
			if (M == 5)
			{
				// add a new ball
				Board_backend.removeBall(0);
				Ball b1 = new Ball(0.0, 0.0, 50.0, 450.0, 25);
				Board_backend.addBall(b1);
			}
		};
	};

}