package interpreter.options;

//Imports

import computationalModel.Memory;
import computationalModel.exceptions.CellOverflowException;
import computationalModel.exceptions.ImageSyntaxException;
import computationalModel.exceptions.LeftOrRightException;
import computationalModel.exceptions.NumberOfLineInputException;
import interpreter.ProgramInterpreter;
import language.Instruction;
import language.KeyWord;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Class that is an exemple of interpretation of the program.
 * It's use to translate an image to a text program.
 */
public class Translate implements ProgramInterpreter {
    /**
     * interpret the list of Instruction to translate it into an image.
     * @param m The memory
     * @param listInstruction The list of instruction
     */
	public void interpret(Memory m,List<Instruction> listInstruction) throws ImageSyntaxException, CellOverflowException,
	 LeftOrRightException, NumberOfLineInputException, IOException{
		translate("out.bmp",listInstruction);
	 }

    /**
     * Apply the translation, create the image and save it.
     * @param path The location to save the file.
     * @param listInstruction The list of instruction we'll save in the image.
     */
	private void translate(String path,List<Instruction> listInstruction){
		int size = (int) (Math.sqrt(listInstruction.size())+1) *3;
		saveImage(createImage(size,size,listInstruction),path);
	}

    /**
     * Method that create an instance of BufferedImage, thanks to the list of instruction in parameters.
     * @param sizeX The size in x of the future image.
     * @param sizeY The size in y of the future image.
     * @param listInstruction The list of instruction that will be used to create the image.
     * @return The bufferedImage we create.
     */
	private BufferedImage createImage(int sizeX, int sizeY, List<Instruction> listInstruction){
		final BufferedImage res = new BufferedImage(sizeX,sizeY,BufferedImage.TYPE_INT_RGB);

		int size_of_pixels = 3;
//		int instructionIndex = 0;
		Iterator instructionIterator = listInstruction.iterator();
		for (int y = 1; y < sizeY; y+=size_of_pixels){
			for (int x = 1; x < sizeX; x+=size_of_pixels){
				Color color = getColorOfNextInstruction(instructionIterator);
				setPixels(res,x,y,color);
			}
		}
		return res;
	}

	private Color getColorOfNextInstruction(Iterator listOfInstruction) {
		Color color;
		if(listOfInstruction.hasNext()){
			Instruction instruction = (Instruction) listOfInstruction.next();
			KeyWord keyword = instruction.getKeyWordAssociated();
			color = Color.decode("#"+keyword.toHexaValue());
		}else{
			color = Color.decode("#000000");
		}
		return color;
		/*if(instructionIndex<listInstruction.size()){
			Instruction ins = listInstruction.get(instructionIndex++);
			color = Color.decode("#"+ins.getHexaValue());
		}else{
			color = Color.decode("#000000");
		}*/
	}

    /**
     * Change the value of rgb of a pixel.
     * @param img The image you want to set a pixel.
     * @param xPixel The coordinate in x of the pixel you want to change.
     * @param yPixel The coordinate in y of the pixel you want to change.
     * @param c The new color of the pixel you want to change.
     */
	private void setPixels(BufferedImage img,int xPixel, int yPixel, Color c){
		for (int x = xPixel-1; x <= xPixel+1; x++){
			for (int y = yPixel-1; y <= yPixel+1; y++){
				if(x>=0 && x<img.getWidth() && y >=0 && y < img.getHeight()){
					img.setRGB(x, y, c.getRGB());
				}
			}
		}
	}

    /**
     * Save literally the image in the following path.*
     * @param bi The image you want to save.*
     * @param path The path you will use to save the image.
     */
	private void saveImage( final BufferedImage bi, final String path ){
		try {
			//RenderedImage rendImage = bi;
			ImageIO.write(bi, "bmp", new File(path));
		} catch ( IOException e) {
			e.printStackTrace();
		}
	}


}