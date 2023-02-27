package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Coffee extends SuperObject {
	
	public OBJ_Coffee() {
		name = "Coffee";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/coffee2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
