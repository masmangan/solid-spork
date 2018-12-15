import java.awt.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import javax.swing.Timer;

class Star {
	int x;
	int y;
	int size;
	int speed;

	Star() {
		Random r = new Random();
		recycle(r.nextInt(800));
	}
	void recycle(int x) {
		Random r = new Random();
		this.x = x;
		y = r.nextInt(600);
		size = r.nextInt(3) + 1; 
		speed = r.nextInt(3) + 1; 
	}
	void move() {
		if (x <= 0) recycle(800);
		x-= speed;
	}
}

public class Jogo extends Panel {

	final java.util.List<Star> field;
	Jogo() {
		field = Stream.generate(()-> new Star())
			.limit(300)
			.collect(Collectors.toList());

		Timer t = new Timer(100, e -> {field.forEach(s -> s.move());repaint();});
		t.start();
	}
	public static void main(String args[]) throws Exception {
		Frame f = new Frame();
		Jogo jogo = new Jogo();
      		f.setLocation(10, 10);
		f.setTitle("Oh, hello!");
		f.setSize(800,600);
		f.add(new Jogo());
		f.setVisible(true);
	}
	public void paint(final Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		field.forEach(s -> g2.fillRect(s.x, s.y, s.size, s.size));
	}
}
