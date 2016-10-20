package javagram.filters;

import java.awt.Color;
import javagram.Picture;

public class BlackWhiteFilter implements Filter{

public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	    	  int avg = ((c.getRed() + c.getGreen() + c.getBlue()) / 3);
	          if (avg < 128)
	        	  processed.set(i, j, Color.BLACK);
	          else
	        	  processed.set(i, j, Color.WHITE);
	    	  
	      }
	    }
		
		return processed;
	}
}
