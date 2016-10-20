package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class PosterizeFilter implements Filter {

	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		//get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = (c.getRed() / 128) > 0 ? 255 : 0;
	          int g = (c.getGreen() / 128) > 0 ? 255 : 0;
	          int b = (c.getBlue() / 128) > 0 ? 255 : 0;
	          
	          
	          processed.set(i, j, new Color(r, g, b));
	    	  
	      }
	    }
		
		return processed;
	}
}
