package BenchMark;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class cpu extends JFrame {
	private static double time;
	private static double score;
	private JPanel panel;
	private JLabel label;
	private JLabel timelabel;


	cpu(){
		setTitle("JINnebench - CPU");
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
		
		label.setText("Benchmark CPU Complete");
		timelabel.setText("Score is :" + score);
		
	}
	
	private static double progess() {
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
}
