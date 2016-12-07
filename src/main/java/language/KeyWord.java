package language;

import computationalModel.exceptions.KeyWordNotFoundException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The enum that help us to know the different representation of an instruction.
 */
public enum KeyWord{

	INCR("+","ffffff"),DECR("-","4b0082"),LEFT("<","9400d3"),
	RIGHT(">","0000ff"), IN(",","ffff00"),OUT(".","00ff00"),
	JUMP("[","ff7f00"),BACK("]","ff0000");
    /**
     * A map that contains the differents representations of an instruction.
     */
	static final public Map<KeyWord,String[]> KEYWORDS = new HashMap<>();
    /**
     * The differents representation.
     */
	private String[] possibleValues;

	static{
		initializationOfTheMap();
	}

	/**
	* Initialize the Map of KeyWords
	 */
	private static void initializationOfTheMap() {
		KeyWord[] arrayOfKeyWord = KeyWord.values();
		List<KeyWord> listOfKeyWord = Arrays.asList(arrayOfKeyWord);
		listOfKeyWord.forEach(KeyWord::addKeyWordInMap);
	}

	/**
	* Add a couple for a KeyWord in the Map.
	* The couple is represented like this (KeyWord, string array of possibles representations for this KeyWord)
	 * @param keyWord the keyWord to add to the Map
	 */
	private static void addKeyWordInMap(KeyWord keyWord) {
		KEYWORDS.put(keyWord,keyWord.getPossibleValues());
	}

	/**
     * Constructor of the class KeyWord.
     * @param shortValue The shortened syntax of the instruction.
     * @param hexValue The hexa value of the instruction for the image.
     */
	KeyWord (String shortValue, String hexValue) {
		this.possibleValues = new String[]{shortValue, hexValue};
	}

    /**
     * Return the keyWord associated to the potential keyword.
     * @param potentialKeyWord The potential keyword we want to get the keyword.
     * @return The keyword associated to the keyword.
     */
	public static KeyWord getKeyWord(String potentialKeyWord) throws KeyWordNotFoundException {
		try{
			for(KeyWord keyWord : KeyWord.values()){ // for each enum value
				if(isRepresentationOfThisKeyWord(potentialKeyWord,keyWord)){
					return keyWord;
				}
			}
			return KeyWord.valueOf(potentialKeyWord); //Else try to convert the potential KeyWord
		}catch(Exception e){ //If not, HashMap or valueOf return an exception.
			throw new KeyWordNotFoundException(potentialKeyWord+" isn't an existent keyWord.");
		}
	}

	/**
	 * Test if the given String KeyWord is a representation of the KeyWord given
	 * @param potentialKeyWord the String KeyWord to test
	 * @param keyWord the KeyWord value
	 * @return true if potentialKeyWord is a representation of the keyWord. False otherwise.
	 */
	private static boolean isRepresentationOfThisKeyWord(String potentialKeyWord, KeyWord keyWord) {
		List<String> representationsOfTheKeyWord = Arrays.asList(KEYWORDS.get(keyWord));
		return representationsOfTheKeyWord.contains(potentialKeyWord.toLowerCase());
	}

	/**
     * To know if the potential keyword is the shortened version of a keyword.
     * @param potentialKeyWord the word you wants to test if it is a keyword.
     * @return if the word is a keyword or not.
     */
	static boolean isKeyWord(String potentialKeyWord){
		try {
			return KeyWord.getKeyWord(potentialKeyWord) != null;
		} catch (KeyWordNotFoundException e) {
			return false;
		}
	}

    /**
     * Return the different representations of a keyword.
     * @return The different representations.
     */
	public String[] getPossibleValues(){
		return this.possibleValues;
	}

    /**
     * Return the keyword in a short syntax.
     * @return The short syntax of the keyword.
     */
	public String toShortSyntax(){
		return this.possibleValues[0];
	}

    /**
     * Return the hexa value of the keyword.
     * @return The hexa value.
     */
	public String toHexaValue() {return this.possibleValues[1];}


}