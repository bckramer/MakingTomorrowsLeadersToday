package game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import GeneticAlgorithm.GeneticAlgorithm;
import NetworkConstruction.NeuralNet;
import NetworkConstruction.Neuron;
import geom.Point;
import geom.Rectangle;
import geom.Triangle;
import util.SpreadsheetGenerator;

public class Main extends BasicGame {

	private static int width = 800;
	private static int absWidth = 1050;
	private static int height = 800;
	private static AppGameContainer app;
	private ArrayList<Triangle> triangles;
	public ArrayList<Rectangle> squares;
	private ArrayList<Rectangle> deadSquares;
	private ArrayList<Rectangle> winners;
	private int maxTriangles = 100;
	private long startTime;
	private int generation = 0;
	private String fileName = System.getProperty("user.home") + "\\desktop\\recs";

	public Main(String title) {
		super(title);
		triangles = new ArrayList<Triangle>();
		squares = new ArrayList<Rectangle>();
		deadSquares = new ArrayList<Rectangle>();
		winners = new ArrayList<Rectangle>();
		System.out.println(new Color(Color.white));
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

			squares.get(x).updateFitness();

			List<Neuron> neurons = squares.get(x).getNet().getInputLayer().getNeurons();
			neurons.get(0).setOutput(squares.get(x).getClosestX().getX());
			neurons.get(1).setOutput(squares.get(x).getClosestY().getY());

			List<Neuron> neurons2 = squares.get(x).getNet().getOutputLayer().getNeurons();
			squares.get(x).move(neurons2.get(0).calculateOutput(), neurons2.get(1).calculateOutput());
			if (squares.get(x).collidesWithTriangle(triangles)) {
				if (squares.size() <= 3) {
					winners.add(squares.get(x));
					winners.get(x).setIndex(winners.size());
				}
				deadSquares.add(squares.remove(x));
			}
			if (squares.size() == 0) {
				generation++;
				triangles.clear();

				/*
				 * SpreadsheetGenerator gen = new SpreadsheetGenerator(deadSquares, fileName);
				 * try { gen.generate(); } catch (FileNotFoundException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) { //
				 * TODO Auto-generated catch block e.printStackTrace(); }
				 */
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
		if (generation == 0) {
			squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.magenta, "Magenta",
					generation, new NeuralNet(), 0));
			squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.blue, "Blue", generation,
					new NeuralNet(), 1));
			squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.green, "Green", generation,
					new NeuralNet(), 2));
			squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.yellow, "Yellow", generation,
					new NeuralNet(), 3));
			squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.cyan, "Cyan", generation,
					new NeuralNet(), 4));
			squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.orange, "Orange", generation,
					new NeuralNet(), 5));
			squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.lightGray, "Light Grey",
					generation, new NeuralNet(), 6));
			squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.pink, "Pink", generation,
					new NeuralNet(), 7));
			squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.gray, "Grey", generation,
					new NeuralNet(), 8));
			squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height, Color.white, "White", generation,
					new NeuralNet(), 9));
			/*
			 * for (int i = 0; i < 0; i++) { Random rand = new Random(); Color randColor =
			 * new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
			 * squares.add(new Rectangle(width / 2, height - 15, 15, 15, width, height,
			 * randColor, null, generation, new NeuralNet())); }
			 */
		} else {
			GeneticAlgorithm ga = new GeneticAlgorithm(10, 4);
			//ga.createNewPopulation();
			ga.EvolvePop(winners);
		}
		winners.clear();
		/*
		 * for (int i = 0; i < squares.size(); i++) {
		 * System.out.println(squares.get(i).getNet()); }
		 */
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
