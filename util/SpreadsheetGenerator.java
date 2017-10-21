package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import geom.Rectangle;

public class SpreadsheetGenerator {

	private ArrayList<Rectangle> recs;
	private File f;
	
	public SpreadsheetGenerator(ArrayList<Rectangle> recs, String fileName) {
		this.recs = recs;
		f = new File(fileName + ".csv");
	}
	
	public void generate() throws IOException {
		PrintWriter writer = new PrintWriter(f);
		
		for (int x = 0; x < recs.size(); x++) {
			Rectangle r = recs.get(x);
			String line = r.getName() + "," + r.getFitness() + "," + r.getGen();
			writer.println(line);
		}
		writer.close();
		f.createNewFile();
	}
	
}
