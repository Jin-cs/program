package BenchMark;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;
//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener, MouseInputListener{
	private static JButton button;
	private static JButton button01;
	private static JButton button02;
	private static JButton button03;
	
	public Window(int x,int y){
	    this.setTitle("JINnebench");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon image = new ImageIcon("logo.png");
			setIconImage(image.getImage());
			setSize(x,y);
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			
			ImageIcon imagePage = new ImageIcon("logo.png");
			JLabel startpic = new JLabel();
			startpic.setIcon(imagePage);
			startpic.setBounds(0,0,x,y);
			startpic.setBackground(new Color(236, 219, 186));
		    startpic.setOpaque(true);
			startpic.setHorizontalAlignment (SwingConstants.CENTER );	
			
			//Icon iconmem = new ImageIcon("mem.png");
			//Icon icondisk = new ImageIcon("disk.png");
			//Icon iconcpu = new ImageIcon("cpu.png");
			
			button = new JButton("START ALL");
			button.setLocation(x/2-80,y/6);
			button.setBounds(x/2-50,y/5, 100, 50);
			startpic.add(button);
			
			button01 = new JButton("CPU");
			button01.setBounds(x/2-50,y/2,100,50);
			button01.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 try
				        {
				            cpu c = new cpu();
				            c.setVisible(true);
				        }
				        catch (Exception ex)
				        {
				            ex.printStackTrace();
				        }
					
				}
			});
			startpic.add(button01);
			
			button02 = new JButton("DISK");
			button02.setBounds(x/2-160,y/2,100,50);
			button02.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 try
				        {
				            Disk disk = new Disk();
				            disk.setVisible(true);
				        }
				        catch (Exception ex)
				        {
				            ex.printStackTrace();
				        }
					
				}
			});
			startpic.add(button02);
			
			button03 = new JButton("MEMORY");
			button03.setBounds(x/2+60,y/2,100,50);
			button03.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 try
				        {
				            Mem mem = new Mem();
				            mem.setVisible(true);
				        }
				        catch (Exception ex)
				        {
				            ex.printStackTrace();
				        }
					
				}
			});
			startpic.add(button03);
			
			add(startpic);
	  }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		
	}
}
