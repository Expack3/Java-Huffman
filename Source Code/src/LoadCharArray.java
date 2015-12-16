import java.io.*;
import java.util.Vector;

public class LoadCharArray {
	public static CharacterFrequency[] load(String charLocation) throws FileNotFoundException, IOException
	{
		FileInputStream readCharStream = new FileInputStream(charLocation);
		BufferedReader readCharBuffer = new BufferedReader(new InputStreamReader(readCharStream));
		Vector<String[]> charVector = new Vector<String[]>();
		String currentLine = null;
		
		while((currentLine = readCharBuffer.readLine()) != null)
			charVector.add(currentLine.split("NBN"));
		readCharBuffer.close();
		int i = 0;
		CharacterFrequency[] charArray = new CharacterFrequency[charVector.size()];
		try
		{
		for(i = 0; i < charVector.size(); i++)
		{
			charArray[i] = new CharacterFrequency((char)Integer.parseInt(charVector.elementAt(i)[0]), Integer.parseInt(charVector.elementAt(i)[1]));
		}
		}
		catch(StringIndexOutOfBoundsException err)
		{
			System.out.println("Position " + i + " is out of bounds.");
		}
		return charArray;
	}
}
