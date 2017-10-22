package geom;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import NetworkConstruction.NeuralNet;

public class Rectangle {

	private float x, y;
	private float width, height;
	private float winWidth, winHeight;
	private Color c;
	private Point closestX, closestY;
	private long fitness;
	private long startingTime;
	private String name;
	private int gen;
	private NeuralNet net;
	private boolean winner;
	private int index;

	public Rectangle(float x, float y, float width, float height, float winWidth, float winHeight, Color c, String name, int gen, NeuralNet net, int index) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.width = width;
		this.height = height;
		startingTime = System.currentTimeMillis();
		fitness = 0;
		if (name == null) {
			name = "Untitled";
		}else {
			this.name = name;
		}
		this.gen = gen;
		this.net = net;
		this.winWidth = winWidth;
		this.winHeight = winHeight;
		winner = false;
		
	}
	
	public Rectangle(Rectangle r) {
		this.x = r.getX();
		this.y = r.getY();
		this.c = r.getC();
		this.width = r.getWidth();
		this.height = r.getHeight();
		startingTime = System.currentTimeMillis();
		fitness = 0;
		this.name = r.getName();
		this.gen = r.getGen() + 1;
		this.net = r.getNet();
		this.winWidth = r.getWinWidth();
		this.winHeight = r.getWinHeight();
		winner = r.getWinner();
	}

	public boolean getWinner() {
		return winner;
	}

	//I'm so sorry
	public boolean collidesWithTriangle(ArrayList<Triangle> tris) {
		org.newdawn.slick.geom.Rectangle rec = new org.newdawn.slick.geom.Rectangle(x, y, width, height);
		for (int x = 0; x < tris.size(); x++) {
			org.newdawn.slick.geom.Polygon poly = new org.newdawn.slick.geom.Polygon();
			poly.addPoint(tris.get(x).getBottom().getX(), tris.get(x).getBottom().getY());
			poly.addPoint(tris.get(x).getTopRight().getX(), tris.get(x).getTopRight().getY());
			poly.addPoint(tris.get(x).getTopLeft().getX(), tris.get(x).getTopLeft().getY());
			if (rec.intersects(poly)) {
				return true;
			}
		}
		return false;
	}
	
	public void updateFitness() {
		this.fitness++;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public float getWinWidth() {
		return winWidth;
	}

	public void setWinWidth(float winWidth) {
		this.winWidth = winWidth;
	}

	public float getWinHeight() {
		return winHeight;
	}

	public void setWinHeight(float winHeight) {
		this.winHeight = winHeight;
	}

	public void move(double xOut, double yOut) {
<<<<<<< HEAD
		System.out.print(xOut);
		System.out.println(yOut);
		if(xOut >= .5 && yOut >= .5){
			if(xOut > yOut && x <= winWidth - width){
				x+= 2; 
			}
			else if (x >= 0){
				x -= 2;
			}
		}
		else if (xOut >= .5 && x <= winWidth - width) {
=======
//		System.out.print(xOut);
//		System.out.println(yOut);
		if (xOut >= .6 && x <= winWidth - width) {
>>>>>>> parent of 409e765... More Imporevments (Probably) to the genetic algorith
			x += 2;
		} else if (yOut >= .6 && x >= 0) {
			x -= 2;
		}
//		if(x <= 0){
//			x = winWidth-width - 1;
//		}
//		if(x>= winWidth - width){
//			x = 1;
//		}
		
	}

	public void getClosestXTrianglePosition(ArrayList<Triangle> triangles) {
		if (triangles.size() > 0) {
			Triangle closest = triangles.get(0);
			Point closestTopLeft = closest.getTopLeft();
			Point closestTopRight = closest.getTopRight();
			Point close = closestTopLeft;
			for (int i = 0; i < triangles.size(); i++) {
				float ctl = closestTopLeft.getX();
				float xtl = triangles.get(i).getTopLeft().getX();
				float ctr = closestTopRight.getX();
				float xtr = triangles.get(i).getTopRight().getX();

				if (Math.abs(ctl - (x + (width / 2))) > Math.abs((x + width / 2) - xtl)) {
					closestTopLeft = triangles.get(i).getTopLeft();
				}
				if (Math.abs((x + (width / 2) - ctr)) > Math.abs(xtr - (x + width / 2))) {
					closestTopRight = triangles.get(i).getTopRight();
				}
				if (Math.abs(ctl - (x + (width / 2))) > Math.abs((x + (width / 2) - ctr))) {
					close = closestTopRight;
				} else {
					close = closestTopLeft;
				}
			}
			closestX = close;
		}
	}

	public void getClosestYTrianglePosition(ArrayList<Triangle> triangles) {
		if (triangles.size() > 0) {
			Point closest = triangles.get(0).getBottom();

			for (int x = 0; x < triangles.size(); x++) {
				if (closest.getY() < triangles.get(x).getBottom().getY()) {
					closest = triangles.get(x).getBottom();
				}
			}
			closestY = closest;
		}
	}

	public Point getClosestX() {
		return closestX;
	}

	public Point getClosestY() {
		return closestY;
	}

	public long getFitness() {
		return fitness;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getGen() {
		return gen;
	}

	public NeuralNet getNet() {
		return net;
	}

	public void setNet(NeuralNet net) {
		this.net = net;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Rectangle " + name + " [x=" + x + ", y=" + y + ", fitness=" + fitness + ", gen=" + gen + ", net=" + net + ", winner="
				+ winner + "]";
	}

	public void setFitness(int i) {
		fitness = i;
	}

	public void setStartingTime() {
		startingTime = System.currentTimeMillis();
		
	}

}
