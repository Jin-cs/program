package BenchMark;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Disk extends JFrame{
	private static final int MILLISEC_TO_MIN = 60000;
	private static double time;
	private static double score;
	private JPanel panel;
	private JLabel label;
	private JLabel timelabel;
	private JLabel scorelabel;

	Disk(){
		setTitle("JINnebench - Disk");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		ImageIcon image = new ImageIcon("logo.png");
		setIconImage(image.getImage());
		setSize(400,320);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		panel = new JPanel();
		panel.setBackground(new Color(236, 219, 186));
		
		label = new JLabel();
		label.setText("Benchmarking...");
		label.setFont(new Font("Comic Sans", Font.PLAIN,30));
		
		timelabel = new JLabel();
		timelabel.setLocation(50,50);
		timelabel.setFont(new Font("Comic Sans", Font.PLAIN,30));
		timelabel.setBackground(new Color(236, 219, 186));
		
		
		panel.add(label);
		panel.add(timelabel);
		add(panel);
		
		time = progess();
		score = time *  0.001 ;
		
		label.setText("Benchmark Disk Complete");
		timelabel.setText("Time :" + (time / MILLISEC_TO_MIN) + " min.");
		
		scorelabel = new JLabel();
		scorelabel.setText("Score is : " + score + " points.");
		scorelabel.setFont(new Font("Comic Sans", Font.PLAIN,30));
		panel.add(scorelabel);
	}
	
	private static double progess() {
		double elapsedTime = 0;
		ArrayList<String> wordsList = new ArrayList<String>();
		//long tenGB = 10737418240L;
		//long fiveGB = 5120000000L;
		int oneGB = 1073741824;
		//long threeGB = 3072000000L;
		long twoGB = 2048000000L;
		try {
			Scanner file = new Scanner(new File("words.txt"));
			while (file.hasNext()) {
				String word = file.next();
				wordsList.add(word);
			}
			wordsList.trimToSize();
			file.close();
		}catch (FileNotFoundException e) {  
			System.out.println("File not found.");
		  }
		
		try {
			Random random = new Random();
			double startTime = System.currentTimeMillis();
			FileWriter targetFile = new FileWriter("diskTest.txt");
			for(int i = 0; i < oneGB + 1; i++) {
				int randomWord = random.nextInt(wordsList.size());
				targetFile.write(wordsList.get(randomWord));
			    }
			
			double endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			targetFile.close();
			
		}catch (IOException e) {  
			e.printStackTrace();
		  }
		return elapsedTime ;
		
	}
	}
