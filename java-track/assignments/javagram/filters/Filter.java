package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public interface Filter {

	public Picture process(Picture original);
}
