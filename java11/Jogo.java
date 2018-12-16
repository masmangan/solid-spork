import java.awt.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import javax.swing.Timer;
import static java.lang.System.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

class Star {
	static Random r = new Random();
	int x;
	int y;
	int size;
	int speed;
	Color color;

	Star() {
		setAt(r.nextInt(800));
	}
	void setAt(int x) {
		this.x = x;
		y = r.nextInt(600);
		size = r.nextInt(3) + 1; 
		speed = r.nextInt(3) + 1; 
		color = Color.black;
		if (r.nextInt(100) > 30) color = Color.gray;
		if (r.nextInt(100) > 30) color = Color.lightGray;
	}
	void move() {
		if (x <= 0) setAt(800);
		x-= speed;
	}
}

class Sprite {
	int x;
	int y;
	int speed;
	int dx;
	int dy;
	BufferedImage image;
	
	Sprite(String file, int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		dx = 0;
		dy = 0;
		try {
    			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			out.println("No image here!");
		}	
	}
}

public class Jogo extends Panel {
	public static final long serialVersionUID = 0;
	final java.util.List<Star> field;
	Sprite hero;
	
	Jogo() {
		field = Stream.generate(()-> new Star())
			.limit(300)
			.collect(Collectors.toList());

		var t = new Timer(100, e -> {field.forEach(s -> s.move()); repaint();});
		t.start();

		hero = new Sprite("../media/images/f18.png", 30, 30, 0);
	}
	public static void main(String args[]) throws Exception {
		var f = new Frame();
      		f.setLocation(10, 10);
		f.setTitle("Oh, hello!");
		f.setSize(800,600);
		f.add(new Jogo());
		f.setVisible(true);
	}
	public void paint(final Graphics g) {
		var g2 = (Graphics2D)g;
		
		field.forEach(s -> { g2.setColor(s.color); g2.fillRect(s.x, s.y, s.size, s.size); g2.drawImage(hero.image, hero.y, hero.y, null);} );
	}
}
