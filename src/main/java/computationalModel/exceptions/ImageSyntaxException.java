package computationalModel.exceptions;

/**
 * Exception that precise a Synthax image problem
 * @author Antoine Dezarnaud
 */

public class ImageSyntaxException extends Exception {
	/**
    *The error message
	*
    **/
	private String msg;


    /**
    ImageSyntaxException constructor

    *Store the current pixel's coordinates
    * and the the type of issue
    *
    *@param y : the Y coordinate
    *@param x : the X coordinate
    *@param type : the type of issue
    *
     **/

	public ImageSyntaxException(int size,int y, int x,String type){
		switch(type){
			case "wrong color" : this.msg = "Color on pixel ("+x+","+y+") is wrong.";
			break;
			case "wrong size" : this.msg = "Color on pixel ("+x+","+y+") is wrong\n Please make image with "
				+size+"*"+size+" pixel blocs.";break;

			default: this.msg = "Error on ImageSyntaxException.";
			break;
		}
	}

    /**
     *Get the error message for the corresponding issue.
     *
     *@return String : the error message.
     */

	@Override
	public String getMessage(){
		return this.msg;
	}
}
