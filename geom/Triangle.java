package geom;

public class Triangle {

	private Point topLeft;
	private Point topRight;
	private Point bottom;
	private Point p;
	
	public Triangle(Point p) {
		this.p = p;
		topLeft = p;
		topRight = new Point(p.getX() + 16, p.getY());
		bottom = new Point(p.getX() + 16/2, p.getY() + 17);
		
	}
	
	public boolean inBounds(float height) {
		return topLeft.getY() <= height;
	}
	
	public void fall(float yIncrement) {
		topLeft.modifyY(yIncrement);
		topRight.modifyY(yIncrement);
		bottom.modifyY(yIncrement);
	}
	
	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
	}

	public Point getTopRight() {
		return topRight;
	}

	public void setTopRight(Point topRight) {
		this.topRight = topRight;
	}

	public Point getBottom() {
		return bottom;
	}

	public void setBottom(Point bottom) {
		this.bottom = bottom;
	}

	
	
}
