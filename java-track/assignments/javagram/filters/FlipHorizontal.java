package javagram.filters;

import java.awt.Color;
import javagram.Picture;

public class FlipHorizontal implements Filter{

public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		//get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, original.height()-1 - j);
	          
	          
	          processed.set(i, j, c);
	    	  
	      }
	    }
		
		return processed;
	}
}
