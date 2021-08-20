package useful;

import java.awt.Image;
import java.awt.Toolkit;

public class Useful {
    
    public static Image getImage(String string) {
		return Toolkit.getDefaultToolkit().getImage(
				Useful.class.getResource(string));
	}
    
    

}
