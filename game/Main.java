package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame{

	private static AppGameContainer app;
	
	public Main(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException{
		
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		
		
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		
	}
	
	public static void main(String[] args) throws SlickException {
		app = new AppGameContainer(new Main("Making the Leaders of Tomorrow Today"));
		app.setDisplayMode(800, 990, false);
		app.setFullscreen(false);
		app.setTargetFrameRate(144);
		app.start();
		
	}
	
}
