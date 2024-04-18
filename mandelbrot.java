import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class mandelbrot extends JPanel{
static int width;
static int height;
static int MAX = 500;

static double scale = 2;
static double xCenter = -0.75 + width/2;
static double yCenter = height/2;


	public mandelbrot(int x, int y) {
		this.setSize(x, y);
		width = x;
		height = y;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int y = 0; y <= height; y++) {
			for(int x = 0; x <= width; x++) {
				double xscale = width / (2*scale);
				double yscale = height / (2*scale);
				Color h = findBrotVal(xCenter + x/xscale - scale, yCenter + scale - y/yscale, xCenter + x/xscale - scale, yCenter + scale -y/yscale, 0);
				g.setColor(h);
				g.drawLine(x, y, x, y);
			}
		}
	}
	
	
	public Color findBrotVal(double Za, double Zb, double Ca, double Cb, int count) {
		if((Za * Za) + (Zb * Zb) >= 4){
			return java.awt.Color.getHSBColor((float)count/MAX, (float)1, (float)1);
			
		}
		double tempZa;
		double tempZb;
		
		if(count <= MAX) {
			tempZa = Za*Za - Zb * Zb + Ca;
			tempZb = 2*Za*Zb + Cb;
			Zb = tempZb;
			Za = tempZa;
			
			return findBrotVal(Za, Zb, Ca, Cb, count + 1);
		}
		

		
		return Color.black;
		
	}
	
}
