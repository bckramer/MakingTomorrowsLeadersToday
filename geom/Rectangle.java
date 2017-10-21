package geom;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Rectangle {

	private float x, y;
	private float width, height;
	private float winWidth, winHeight;
	private Color c;

	private Point closestX, closestY;

	public Rectangle(float x, float y, float width, float height, float winWidth, float winHeight, Color c) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.width = width;
		this.height = height;
	}

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

	public void move(boolean direction) {
		if (direction && x >= winWidth - width) {
			x += 2;
		}
		if (!direction && x >= 0) {
			x -= 2;
		}
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

}
