package geom;

public class Point {

	private float x, y;
	
	public float getX() {
		return x;
	}
	
	public float distance(Point p) {
		return (float) Math.sqrt(Math.pow(x - p.getX(), 2) + Math.pow(y - p.getY(), 2));
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

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void modifyY(float yDiff) {
		y+=yDiff;
	}
	
	public void modifyX(float xDiff) {
		x+=xDiff;
	}
	
}
