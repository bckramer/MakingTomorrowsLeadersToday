package game;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import geom.Point;
import geom.Rectangle;
import geom.Triangle;

public class Main extends BasicGame {

	private static int width = 800;
	private static int height = 800;
	private static AppGameContainer app;
	private ArrayList<Triangle> triangles;
	public ArrayList<Rectangle> squares;
	private int maxTriangles = 100;

	public Main(String title) {
		super(title);
		triangles = new ArrayList<Triangle>();
		squares = new ArrayList<Rectangle>();
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.drawString("Triangle Chance: 1/" + maxTriangles + " Number of Triangles: " + triangles.size(), 30, 30);
	
		renderTriangles(gc, g);
		renderSquares(gc, g);
		g.setColor(Color.black);
	}

	public void renderSquares(GameContainer gc, Graphics g) throws SlickException{
		for (int x = 0; x < squares.size(); x++) {
			g.setColor(squares.get(x).getC());
			g.fillRect(squares.get(x).getX(), squares.get(x).getY(), squares.get(x).getWidth(), squares.get(x).getHeight());
		}
	}
	
	public void renderTriangles(GameContainer gc, Graphics g) throws SlickException {
		g.setColor(Color.red);
		for (int x = 0; x < triangles.size(); x++) {
			g.drawLine(triangles.get(x).getTopLeft().getX(), triangles.get(x).getTopLeft().getY(),
					triangles.get(x).getTopRight().getX(), triangles.get(x).getTopRight().getY());

			g.drawLine(triangles.get(x).getBottom().getX(), triangles.get(x).getBottom().getY(),
					triangles.get(x).getTopRight().getX(), triangles.get(x).getTopRight().getY());
			g.drawLine(triangles.get(x).getTopLeft().getX(), triangles.get(x).getTopLeft().getY(),
					triangles.get(x).getBottom().getX(), triangles.get(x).getBottom().getY());
			
			triangles.get(x).fall(2);
			
			if (!triangles.get(x).inBounds(height)) {
				triangles.remove(triangles.get(x));
			}
		}
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		triangles.add(new Triangle(new Point(400, 500)));
		
		squares.add(new Rectangle(500, 500, 15, 15, Color.magenta));
		squares.add(new Rectangle(width/2, height-15, 15, 15, Color.blue));
		squares.add(new Rectangle(width/2, height-15, 15, 15, Color.green));
		squares.add(new Rectangle(width/2, height-15, 15, 15, Color.yellow));
		squares.add(new Rectangle(width/2, height-15, 15, 15, Color.cyan));
		squares.add(new Rectangle(width/2, height-15, 15, 15, Color.orange));
		squares.add(new Rectangle(width/2, height-15, 15, 15, Color.lightGray));
		squares.add(new Rectangle(width/2, height-15, 15, 15, Color.pink));
		squares.add(new Rectangle(width/2, height-15, 15, 15, Color.gray));
		squares.add(new Rectangle(width/2, height-15, 15, 15, Color.white));
		
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		Random rand = new Random();
		if (rand.nextInt(maxTriangles) == 1) {
			triangles.add(new Triangle(new Point(rand.nextInt(800), rand.nextInt(100))));
		}
		if (System.nanoTime() % 50 == 0 && maxTriangles > 2) {
			maxTriangles--;
		}

	}

	public static void main(String[] args) throws SlickException {
		app = new AppGameContainer(new Main("Making the Leaders of Tomorrow Today"));
		app.setDisplayMode(width, height, false);
		app.setFullscreen(false);
		app.setTargetFrameRate(144);
		app.start();

	}

}
