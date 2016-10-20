package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {
	
	static final int MAX_SELECTIONS = 7;

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath = "path not set";
		String imagePath = "path not set";
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		do {
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				/*
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				*/
				
				imagePath = (dir + "\\" + relPath);
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		
		int selection = displayFilterMenu(in);
		
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
		
		Filter filter = getFilter(selection);
		
		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else if (fileName.equals(relPath)){
			System.out.println("Are you sure you want to overwrite the original?");
			String answer = in.next();
			if (answer.equals("yes")) {
				processed.save(imagePath);
				System.out.println("Image saved to " + imagePath);
			}
			else {
				System.out.println("Enter a new path");
				fileName = in.next();
				String absFileName = dir + File.separator + fileName;
				processed.save(absFileName);
				System.out.println("Image saved to " + absFileName);
			}
		} else {
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	
		
		// close input scanner
		in.close();
		System.exit(0);
	}
	
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int f) {
		if (f < 1 || f > MAX_SELECTIONS)
			throw new IllegalArgumentException("not a valid choice");
		// TODO - create some more filters, and add logic to return the appropriate one
		if (f == 1)
			return new BlueFilter();
		else if (f == 2)
			return new NegativeFilter();
		else if (f == 3)
			return new PosterizeFilter();
		else if (f == 4)
			return new GrayScaleFilter();
		else if (f == 5)
			return new BlackWhiteFilter();
		else if (f == 6)
			return new FlipVertical();
		else if (f == 7)
			return new FlipHorizontal();
		return null;
		
	}
	
	private static int displayFilterMenu(Scanner in) {
		int selection;
		
		System.out.println("\nSelect a filter.");
		System.out.println("1) Blue Filter");
		System.out.println("2) Negative Filter");
		System.out.println("3) Posterize");
		System.out.println("4) Gray Scale");
		System.out.println("5) Black and White");
		System.out.println("6) Flip Vertical");
		System.out.println("7) Flip Horizontal");
		
		do {
			if (in.hasNextInt()) {
				selection = in.nextInt();
				if (selection < 1 || selection > MAX_SELECTIONS) {
					System.out.println("That is not a valid choice");
					selection = 0;
				}
			} else {
				System.out.println("That is not a number");
				String trash = in.next();
				selection = 0;
			}
		} while (selection == 0);
		
		return selection;
	}

}


