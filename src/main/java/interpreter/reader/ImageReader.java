package interpreter.reader;

import language.instructions.instructionFactory.InstructionFactory;
import Tools.ListInstructionTools;
import computationalModel.exceptions.*;
import language.Instruction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageReader extends ProgramReader{


	private final int SIZE_OF_INSTRUCTION = 3; //This parameter MUST BE odd
	private BufferedImage imageIn;

	/**
	 * Constructor of ImageReader.
	 * @param filepath of the file we want to read
	 * @param load , the bufferedReader we use to read the IN file
	 * @param saveAs, the BufferedWriter we use to write in the OUT file
	 */
    public ImageReader(String filepath, BufferedReader load, BufferedWriter saveAs)throws IOException{
        super(filepath,load,saveAs);
		imageIn= ImageIO.read(new FileInputStream(filepath));
	}

	/**
	 * Read the .bmp image given and translate it into a list of instruction.
	 * @return the list of instructions
	 */
	public List<Instruction> read() throws CellOverflowException,
            LeftOrRightException, NumberOfLineInputException, IOException, ImageSyntaxException, KeyWordNotFoundException, JumpException {

        List<Instruction> listInstruction = new ArrayList<>();
		int instructionCount = 0;
		int initialCenter = (int) Math.floor(SIZE_OF_INSTRUCTION/2);
		//ImageReader is read line after line
		for (int yPixel = initialCenter; yPixel < imageIn.getHeight(); yPixel+=SIZE_OF_INSTRUCTION){
	        for (int xPixel = initialCenter; xPixel < imageIn.getWidth(); xPixel+=SIZE_OF_INSTRUCTION){
	        	Color color = getColorOfBlockOfPixels(imageIn,xPixel,yPixel);
	            String hexaValue = getHexadecimalValueInString(color);
	            //We get the hexadecimal color code of the pixel
	            if(Instruction.isValuable(hexaValue)){
                    addInstruction(listInstruction,hexaValue,instructionCount);
					instructionCount++;
	            }else if(hexaValue.equals("000000")){ // If it's black, we exit
	            	break;
	            }else{
	            	throw new ImageSyntaxException(SIZE_OF_INSTRUCTION,yPixel,xPixel,"wrong color");
	            }
	        }
	    }
        ListInstructionTools.fillParamsJumpAndBack(listInstruction);
        return listInstruction;
	}

	/**
	 * Method that returns the color of the Instruction.
	 * @param img the image given
	 * @param xPixel the x coordinate of the center of the area
	 * @param yPixel the y coordinate of the center of the area
	 * @return the color founded in the entire area of pixels
	 * @throws ImageSyntaxException If all the area of pixels aren't of the same color, it throws an exception.
	 */
	private Color getColorOfBlockOfPixels(BufferedImage img,int xPixel, int yPixel) throws ImageSyntaxException{
		int colorRGB_ofCenter= imageIn.getRGB(xPixel,yPixel);
		int margin_with_center = (int) Math.floor(SIZE_OF_INSTRUCTION/2);
		for (int x = xPixel-margin_with_center; x <= xPixel+margin_with_center; x++){
			for (int y = yPixel-margin_with_center; y <= yPixel+margin_with_center; y++){
				if(!coordinatesOutsideOfImage(x,y,img)){
					if(colorRGB_ofCenter != img.getRGB(x,y)){
						throw new ImageSyntaxException(SIZE_OF_INSTRUCTION,y,x,"wrong size");
					}
				}
			}
		}
		//if here, means that every rgb value of block was the same
		return new Color(colorRGB_ofCenter);
	}

	/**
	 * Check if coordinates given are outside of the image given.
	 * @param x x coordinate we want to check
	 * @param y y coordinate we want to check
	 * @param img the image
	 * @return true if coordinates are in the image, false otherwise.
	 */
	private boolean coordinatesOutsideOfImage(int x, int y,BufferedImage img) {
		return (x>=0 && x<img.getWidth() && y >=0 && y < img.getHeight());
	}

	/**
	 * Add an instruction to the list of Instruction by giving hexadecimal value in String.
	 * @param listInstruction the list of Instruction we want to modify
	 * @param hexa hexadecimal value converted in String
	 * @param instructionCount the counter of Instruction
	 * @throws KeyWordNotFoundException if color don't match any instruction.
	 */
	private void addInstruction(List<Instruction> listInstruction,String hexa,int instructionCount) throws KeyWordNotFoundException {
        InstructionFactory instructionFactory = InstructionFactory.getWhichInstructionFactory(hexa,load,saveAs,instructionCount);
        listInstruction.add(instructionFactory != null ? instructionFactory.create() : null);
    }

	/**
	 * Convert color into String hexadecimal value.
	 * @param color the color to convert
	 * @return the String Hexadecimal value
	 */
	private String getHexadecimalValueInString(Color color) {
		return String.format("%02x%02x%02x", color.getRed(),color.getGreen(),color.getBlue());
	}

	/**
	 * Close all buffers opened.
	 */
	public void closeBuffers() throws IOException{
		closeInAndOutBuffers();
	}


}