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
	private boolean hasFallen;
	GeneticAlgorithm ga ;

	public Main(String title) {
		super(title);
		triangles = new ArrayList<Triangle>();
		squares = new ArrayList<Rectangle>();
		deadSquares = new ArrayList<Rectangle>();
		hasFallen = false;
		ga = null;
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
<<<<<<< HEAD
			neurons.get(0).setOutput(squares.get(x).getClosestX().getX());
			neurons.get(1).setOutput(squares.get(x).getClosestY().getY());
=======
			neurons.get(0).setOutput(squares.get(x).getClosestX().getX() / 100);
			neurons.get(1).setOutput(squares.get(x).getClosestY().getY() / 100);
			//System.out.println(squares.get(x).getClosestX().getX() / 100 + " " + squares.get(x).getClosestY().getY() / 100);
>>>>>>> fe3ca6f424bf07d1af1fd088fec969394794841f
			//System.out.println(neurons.get(0).calculateOutput() + " " + neurons.get(1).calculateOutput());
			//System.out.println(squares.get(x).getNet().getInputLayer().getNeurons().get(0).calculateOutput() + " " + squares.get(x).getNet().getInputLayer().getNeurons().get(1).calculateOutput());
			List<Neuron> neurons2 = squares.get(x).getNet().getOutputLayer().getNeurons();
			squares.get(x).move(neurons2.get(0).calculateOutput(), neurons2.get(1).calculateOutput());
			//System.out.println(neurons2.get(0).calculateOutput() + " " + neurons2.get(1).calculateOutput());
			if (squares.get(x).collidesWithTriangle(triangles)) {
				deadSquares.add(squares.remove(x));
			}
			if (squares.size() == 0) {
				
				generation++;
				triangles.clear();
		
<<<<<<< HEAD
//				winners.add(deadSquares.get(deadSquares.size()-1));
//				winners.add(deadSquares.get(deadSquares.size()-2));
//				winners.add(deadSquares.get(deadSquares.size()-3));
//				winners.add(deadSquares.get(deadSquares.size()-4));
				for (Rectangle r: deadSquares) {
=======
				winners.add(deadSquares.get(deadSquares.size()-1));
				winners.add(deadSquares.get(deadSquares.size()-2));
				winners.add(deadSquares.get(deadSquares.size()-3));
				winners.add(deadSquares.get(deadSquares.size()-4));
				for (int i = 0; i < winners.size(); i++) {
					System.out.println(winners.get(i).getFitness());
				}
				for (Rectangle r: winners) {
>>>>>>> fe3ca6f424bf07d1af1fd088fec969394794841f
					r.setX(width/2);
					r.setFitness(0);
			}
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
				hasFallen = true;
			}
		}
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		startTime = System.currentTimeMillis();
		hasFallen = false;
		maxTriangles = 100;
		triangles.add(new Triangle(new Point(width / 2, 250)));
		triangles.add(new Triangle(new Point(0, 250)));
		triangles.add(new Triangle(new Point(width - 7, 250)));
		ga = new GeneticAlgorithm(10, 4, squares);
		if (generation == 0) {
			squares = ga.createNewPopulation(width, height, generation);// TODO dont hard code
		} else {
			squares = ga.createMutatedPopulation(deadSquares);
			//System.out.println(squares);
		}
		deadSquares = new ArrayList<Rectangle>();
		
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
		for (Rectangle r: squares) {
			System.out.println(r.getFitness());
	}

	}

	public static void main(String[] args) throws SlickException {
		app = new AppGameContainer(new Main("Making the Leaders of Tomorrow Today"));
		app.setDisplayMode(width, height, false);
		app.setFullscreen(false);
		app.setTargetFrameRate(1000);
		app.setShowFPS(true);
		app.start();

	}

}
