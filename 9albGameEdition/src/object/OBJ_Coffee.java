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
		
		collision = true;
		
		//you can change the solid area for each object or keep the default values from superobject
		//solidArea.x=80;
		//solidArea.y=80;
	}
}
