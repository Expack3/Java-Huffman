import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Vector;


public class CharConversion {
	static String infile = null; //stores the input filename and its extension
	public static CharacterFrequency[] convertChars(String inputFile) throws IOException
	{
		setInput(inputFile);
		Vector<CharacterFrequency> charLink = new Vector<CharacterFrequency>(); //stores all CharacterFrequency objects created by this program
		return printArrayContents(loadArray(charLink, infile)); /* print the array contents of a given CharacterFrequency array, which is assumed to have non-null positions, to a given output file as defined by command line arguments
		The way it's done here can be somewhat complicated for new Java programmers:
		*For the given CharacterFrequency array, the results of the function loadArray, which needs a given CharacterFrequency array and command line-given input file, are used.
		*Once loadArray has run and returned a CharacterFrequency array, this result is used as the given CharacterFrequency array for printArrayContents
		*/
	}
	
	public static Vector<CharacterFrequency> loadArray(Vector<CharacterFrequency> charList, String infile) throws FileNotFoundException, IOException //load the given CharacterFrequency array with the frequency of character occurrences using the provided string as the input file
	{
		FileInputStream fis = new FileInputStream(infile); //load the given input file
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("US-ASCII"))); //in order to allow massive text files to be efficiently read (see: War and Peace), buffer Java's output from the loaded text file; 
		int indexLocation;
		//also, to ensure the text file is interpreted correctly, tell Java the interpret the incoming data as ASCII.
		int character; //used to store the given value of an ASCII character
		while ((character = br.read()) != -1) //check to see if the next character is -1, which indicates End-Of-File (EOF)
		{
			if((indexLocation = VectorListOperations.searchList(charList, (char)character)) == -1) //has the given position in the character array been initialized?
				charList.add(new CharacterFrequency(character)); //if not, initialize it
			else
				charList.get(indexLocation).increment(); //if so, increment the current value by 1.
		}
		//now that the given CharacterFrequency vector is loaded, close out the file buffer and the input file itself; this frees up valuable system memory
		br.close();
		fis.close();
		return charList;
	}
	
	public static CharacterFrequency[] printArrayContents(Vector<CharacterFrequency> charList) throws FileNotFoundException //print out the contents of a given CharacterFrequency array to a given output file, which is provided via command line arguments 
	{
		return charList.toArray(new CharacterFrequency[charList.size()]);
	}
	
	public static void setInput(String inFile)
	{
		infile = inFile;
	}
	
}
