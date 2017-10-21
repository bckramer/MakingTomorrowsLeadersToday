package util;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

	private JFrame mainFrame;
	private int width = 500;
	private int height = 500;
	private JPanel p1, p2, p3, p4, p5;

	public GUI() {
		prepareGUI();
		show();
	}

	public void prepareGUI() {
		mainFrame = new JFrame("Launcher");
		mainFrame.setSize(width, height);
		mainFrame.setLayout(new GridLayout(1, 5));
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		
		mainFrame.add(p1);
		mainFrame.add(p2);
		mainFrame.add(p3);
		mainFrame.add(p4);
		mainFrame.add(p5);
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
	}

	public void show() {
		JLabel labelUp = new JLabel("Additional Squares");
		JTextField upInput = new JTextField();
		JButton launch = new JButton("Launch");

		mainFrame.setVisible(true);
	}

}
