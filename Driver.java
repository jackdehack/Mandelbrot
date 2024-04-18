import java.awt.Color;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Driver {
	
	//Jack explanation
	
	/*
	 * The Mandelbrot set is a set of complex numbers for which the infinite series Z(i+1) = Z(i)^2 + C does not Diverge
	 * 
	 * ex:
	 *  Z(0) = C
	 *  Z(1) = Z(0)^2 + C
	 *  Z(2) = Z(1)^2 + C
	 * 	Z(3) = Z(2)^2 + C
	 * 	Z(4) = Z(3)^2 + C
	 * 	etc...
	 * 
	 * We are looking to see if Z(n) diverges or not...
	 * 
	 * - remember, C is a complex number written in the standard form: a + bi
	 * thus Z^2 = (a + bi) * (a + bi) = a^2 - b^2 + 2abi
	 * 
	 * 
	 * the mandelbrot set is graphed on a plane where the x axis is the real part, and the y axis is the imaginary part
	 * thus, a complex number of a + bi would b e read at the coordinates (a, b)
	 * 
	 * 
	 * a useful fact about the mandelbrot set is if you draw a circle with radius 2, any number that gets outside of the circle will eventually diverge
	 *  - I will not be providing a mathmatical derrivation for this fact, but i'm sure there's one online
	 * 
	 * basically were looking to see if for a given number, if sqrt(a^2 + b^2) is EVER > 2
	 * 
	 * 
	 * 
	 * 
	 */
			
			


	public static void main(String[] args) {
		JFrame frame = new JFrame("The Mandelbrot set"); 
		frame.setSize(400, 400);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setResizable(false);
		
		mandelbrot m = new mandelbrot(frame.getHeight(), frame.getWidth());
		frame.getContentPane().add(m);
		JSlider slider = new JSlider();
		slider.setValue(500);
		slider.setPaintTicks(true);
		slider.setMinimum(500);
		slider.setMaximum(2000);
		slider.setMajorTickSpacing(100);
		slider.setFocusable(false);
		m.add(slider);
		m.setFocusable(false);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.setAlwaysOnTop(true);
		frame.setAutoRequestFocus(true);
		
		m.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					mandelbrot.scale = mandelbrot.scale / 1.5;
				}else {
					mandelbrot.scale = mandelbrot.scale * 1.5;
				}
				frame.repaint();
			}
		});
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
                   mandelbrot.yCenter += 0.1 * mandelbrot.scale;
                   frame.repaint();
                }
				
				if (e.getKeyCode() == KeyEvent.VK_D) {
					mandelbrot.xCenter += 0.1 * mandelbrot.scale;
					frame.repaint();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_A) {
					mandelbrot.xCenter -= 0.1 * mandelbrot.scale;
					frame.repaint();
                }
				if (e.getKeyCode() == KeyEvent.VK_S) {
					mandelbrot.yCenter -= 0.1 * mandelbrot.scale;
					frame.repaint();
                }
			}
			
			
		});
		
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				mandelbrot.MAX = slider.getValue();
				frame.repaint();
			}
		});
		
	
	}

}
