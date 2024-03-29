package BenchMark;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Mem extends JFrame{
	private static final int SEC_TO_MIN = 60;
	
	//private static final int ONE_GB = 1073741824;// Test for 1 GB
	private static final int POINTFIVE_GB = 536870512; // Test for 0.5 GB
	private static final int HUNDRED_MB = 104857600; // Test for 100 MB
	//private static final int ONE_MB = 1048576;// Test for 1 MB
		
	private static double time;
	private static double score;
	private JPanel panel;
	private JLabel label;
	private JLabel timelabel;
	private JLabel scorelabel;
	
	Mem(){
		setTitle("JINnebench - Memory");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon image = new ImageIcon("logo.png");
		setIconImage(image.getImage());
		setSize(500,320);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		panel = new JPanel();
		panel.setBackground(new Color(236, 219, 186));
		
		label = new JLabel();
		label.setText("Benchmarking...");
		label.setFont(new Font("Comic Sans", Font.PLAIN,30));
		
		Random rand = new Random();
    	
		double startTime = System.currentTimeMillis();
        int[] Test = new int[HUNDRED_MB];
        for(int i :Test) {
        	int randomNum = rand.nextInt( );
            Test[i] = randomNum;
        }
        
        double finishTime = System.currentTimeMillis();
        double totalTime = finishTime - startTime;
        
		timelabel = new JLabel();
		timelabel.setLocation(50,50);
		timelabel.setFont(new Font("Comic Sans", Font.PLAIN,30));
		timelabel.setBackground(new Color(236, 219, 186));
		
		panel.add(label);
		panel.add(timelabel);
		add(panel);
		
		time = totalTime;
		score = time *  0.001 ;
		
		label.setText("Benchmark Memory Complete");
		timelabel.setText("Time :" + (time / SEC_TO_MIN) + " min.");
		
		scorelabel = new JLabel();
		scorelabel.setText("Score is : " + score + " points.");
		scorelabel.setFont(new Font("Comic Sans", Font.PLAIN,30));
		panel.add(scorelabel);
	}

}
