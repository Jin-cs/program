package BenchMark;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

public class All extends JFrame{
	private static final int MILLISEC_TO_MIN = 60000;
	private static final int SEC_TO_MIN = 60;
	private static final int HUNDRED_MB = 104857600; // Test for 100 MB
	private static double diskTime;
	private static double diskScore;
	private static double cpuTime;
	private static double cpuScore;
	private static double memTime;
	private static double memScore;
	private static double totalScore;
	private JPanel panel;
	private JLabel label;
	private JLabel line;
	private JLabel diskTimelabel;
	private JLabel diskScorelabel;
	private JLabel cpuTimelabel;
	private JLabel cpuScorelabel;
	private JLabel memTimelabel;
	private JLabel memScorelabel;
	private JLabel totalScorelabel;

	All(){
		setTitle("JINnebench - All");
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
		
		//disk-part
		diskTimelabel = new JLabel();
		diskTimelabel.setLocation(50,50);
		diskTimelabel.setFont(new Font("Comic Sans", Font.PLAIN,30));
		diskTimelabel.setBackground(new Color(236, 219, 186));
		
		panel.add(label);
		panel.add(diskTimelabel);
		add(panel);
		
		//all process
		diskTime = diskProgess();
		diskScore = diskTime *  0.001 ;
		cpuTime = cpuProgess();
		cpuScore = cpuTime *  0.001 ;
		memTime = memProgess();
		memScore = memTime *  0.001 ;
		
		label.setText("Benchmark Disk Complete");
		diskTimelabel.setText("Time :" + (diskTime / MILLISEC_TO_MIN) + " min.");
		
		diskScorelabel = new JLabel();
		diskScorelabel.setText("Score is : " + diskScore + " points.");
		diskScorelabel.setFont(new Font("Comic Sans", Font.PLAIN,30));
		panel.add(diskScorelabel);
		
		line = new JLabel();
		line.setText("___________________________________________________");
		
		//cpu-part
		cpuTimelabel = new JLabel();
		cpuTimelabel.setLocation(50,50);
		cpuTimelabel.setFont(new Font("Comic Sans", Font.PLAIN,30));
		cpuTimelabel.setBackground(new Color(236, 219, 186));
		
		cpuTimelabel.setText("Time :" + (cpuTime / SEC_TO_MIN) + " min.");
		
		cpuScorelabel = new JLabel();
		cpuScorelabel.setText("Score is : " + cpuScore + " points.");
		cpuScorelabel.setFont(new Font("Comic Sans", Font.PLAIN,30));
		
		panel.add(cpuTimelabel);		
		panel.add(cpuScorelabel);
		add(panel);
		
		line = new JLabel();
		line.setText("___________________________________________________");
		
		//mem-part
		memTimelabel = new JLabel();
		memTimelabel.setLocation(50,50);
		memTimelabel.setFont(new Font("Comic Sans", Font.PLAIN,30));
		memTimelabel.setBackground(new Color(236, 219, 186));
				
		memTimelabel.setText("Time :" + (memTime / SEC_TO_MIN) + " min.");
				
		memScorelabel = new JLabel();
		memScorelabel.setText("Score is : " + memScore + " points.");
		memScorelabel.setFont(new Font("Comic Sans", Font.PLAIN,30));
				
		panel.add(memTimelabel);		
		panel.add(memScorelabel);
		add(panel);
				
		line = new JLabel();
		line.setText("___________________________________________________");
		
		//total-score
		totalScore = diskScore + cpuScore + memScore;
		
		totalScorelabel = new JLabel();
		totalScorelabel.setLocation(50,50);
		totalScorelabel.setFont(new Font("Comic Sans", Font.PLAIN,50));
		totalScorelabel.setText("Total score : " + totalScore + " points.");
	}
	
	private static double diskProgess() {
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
	
	private static double cpuProgess() {
		double number = 1000000000;

        double startTimeofSecond = System.currentTimeMillis();
        for(int i = 1; i < number;i++) {
            for (int j = 1; j < i; j++) {
                if(i % j != 0)
                    break;
                else
                    i += 1;
            }

        }
        double endTimeofSecond = System.currentTimeMillis();
        double spentTime = endTimeofSecond - startTimeofSecond ;
        return spentTime;
       
	}
	
	private static double memProgess() {
    	Random rand = new Random();
    	
		double startTime = System.currentTimeMillis();
        int[] Test = new int[HUNDRED_MB];
        for(int i :Test) {
        	int randomNum = rand.nextInt( );
            Test[i] = randomNum;
        }
        
        double finishTime = System.currentTimeMillis();
        double totalTime = finishTime - startTime;
        
		return totalTime;    	
    }
}
