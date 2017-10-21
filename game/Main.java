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
	private long startTime;
	private int generation = 0;

	public Main(String title) {
		super(title);
		triangles = new ArrayList<Triangle>();
		squares = new ArrayList<Rectangle>();
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.drawString("Triangle Chance: 1/" + maxTriangles + " # Triangles: " + triangles.size() + " # Squares: "
				+ squares.size() + " FPS: " + app.getFPS() + " Time(s): "
				+ (System.currentTimeMillis() - startTime) / 1000 + " gen: " + generation, 10, 30);
		renderTriangles(gc, g);
		renderSquares(gc, g);
		g.setColor(Color.black);
	}

	public void renderSquares(GameContainer gc, Graphics g) throws SlickException {
		for (int x = 0; x < squares.size(); x++) {
			g.setColor(squares.get(x).getC());
			g.fillRect(squares.get(x).getX(), squares.get(x).getY(), squares.get(x).getWidth(),
					squares.get(x).getHeight());
			squares.get(x).getClosestXTrianglePosition(triangles);
			Point px = squares.get(x).getClosestX();
			g.drawLine(squares.get(x).getX() + squares.get(x).getWidth() / 2, squares.get(x).getY(), px.getX(),
					px.getY());

			ArrayList<Triangle> editedTriangles = new ArrayList<Triangle>();

			for (int i = 0; i < triangles.size(); i++) {
				if (triangles.get(i).getBottom().getY() < height - 16) {
					editedTriangles.add(triangles.get(i));
				}
			}

			squares.get(x).getClosestYTrianglePosition(editedTriangles);
			Point py = squares.get(x).getClosestY();
			g.drawLine(squares.get(x).getX() + squares.get(x).getWidth() / 2, squares.get(x).getY(), py.getX(),
					py.getY());
			Random rand = new Random();
			rand.setSeed(System.nanoTime());

			squares.get(x).move(rand.nextBoolean());
			if (squares.get(x).collidesWithTriangle(triangles)) {
				squares.remove(x);
			}
			if (squares.size() == 0) {
				generation++;
				triangles.clear();
				init(gc);
			}
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

			if (!triangles.get(x).inBounds(height - 17)) {
				triangles.remove(triangles.get(x));
			}
		}
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		startTime = System.currentTimeMillis();
		maxTriangles = 100;
		triangles.add(new Triangle(new Point(width / 2, 250)));

		squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.magenta));
		squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.blue));
		squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.green));
		squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.yellow));
		squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.cyan));
		squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.orange));
		squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.lightGray));
		squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.pink));
		squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.gray));
		squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.white));
		for (int i = 0; i < 990; i++) {
			Random rand = new Random();
			Color randColor = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
			squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, randColor));
		}

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
		app.setShowFPS(true);
		app.start();

	}

}
