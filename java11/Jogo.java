import java.awt.*;


public class Jogo {

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
	f.setVisible(true);
	Thread.sleep(100);
}
}
