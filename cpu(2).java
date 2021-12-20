package BenchMark;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import java.lang.*;

@SuppressWarnings("serial")
public class cpu extends JFrame {
	private static final int MILLISEC_TO_HOUR = 3600000;
	private static final int MILLISEC_TO_MIN = 60000;
	private static final int MILLISEC_TO_SEC = 1000;
	private static double time;
	private static double score;
	private static double hour;
	private static double min;
	private static double sec;
//private JPanel panel;
	private static JLabel timelabel;
	private static JLabel scorelabel;
	private static double spentTime;

	public static void main(String args[]) {
		JWindow window = new JWindow();
		window.getContentPane().add(new JLabel("Benchmarking CPU...", SwingConstants.CENTER));
		window.setBounds(500, 150, 300, 200);
		window.setVisible(true);
		try {
			double number = 1000000000;

			double startTimeofSecond = System.currentTimeMillis();
			for (int i = 1; i < number; i++) {
				for (int j = 1; j < i; j++) {
					if (i % j != 0)
						continue;
					else
						i += 1;
				}

			}
			double endTimeofSecond = System.currentTimeMillis();
			spentTime = endTimeofSecond - startTimeofSecond;
		} catch (Exception e) {
		}
		window.setVisible(false);
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(500, 320);
		window.dispose();
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(236, 219, 186));
		timelabel = new JLabel();
		timelabel.setBounds(0, 50, 500, 80);
		timelabel.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		frame.add(timelabel);
		time = spentTime;
		hour = Math.floor(time / MILLISEC_TO_HOUR);
		min = Math.floor(((time - (hour * MILLISEC_TO_HOUR)) / MILLISEC_TO_MIN));
		sec = Math.floor(((time - ((hour * MILLISEC_TO_HOUR) + (min * MILLISEC_TO_MIN))) / MILLISEC_TO_SEC));
		score = 100 - (time * 0.0001);
		
		timelabel.setText("Time : " + hour + " hour(s). " + min + " min(s). " + sec + " sec(s).");
		scorelabel = new JLabel();
		scorelabel.setText("Score is : " + score + " points.");
		scorelabel.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		scorelabel.setBounds(0, 25, 500, 100);
		frame.add(scorelabel);
	}
}
