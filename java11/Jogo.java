import java.awt.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Star {
	public int x;
	public int y;
	public int size;
	public int color;

	public Star() {
		Random r = new Random();
		this.x = r.nextInt(100);
		this.y = r.nextInt(100);
		this.size = r.nextInt(3) + 1; 
		this.color = r.nextInt(3);
	}
	

}

class Starfield {

	public Stream<Star> stars;

	public Starfield() {
		stars = Stream.generate(()-> new Star())
			.limit(10);
	}
}

public class Jogo extends Panel {

public static void main(String args[]) throws Exception {
GraphicsEnvironment ge = GraphicsEnvironment.
   getLocalGraphicsEnvironment();
GraphicsDevice[] gs = ge.getScreenDevices();
GraphicsConfiguration gc = gs[0].getDefaultConfiguration();

Frame f = new Frame(gc);
      Rectangle bounds = gc.getBounds();
      f.setLocation(10 + bounds.x, 10 + bounds.y);
	f.setTitle("Oh, hello!");
	f.setSize(800,600);
	f.add(new Jogo());
	f.setVisible(true);
	Thread.sleep(100);
}
	public Starfield field = new Starfield();

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		field.stars.forEach(s -> g2.fillRect(s.x, s.y, s.size, s.size));
	}
}
