import java.io.*;
public class PrintCharArray {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void print(CharacterFrequency[] charArray, String charLocation) throws FileNotFoundException
	{
		PrintWriter write = new PrintWriter(charLocation);
		for(int i = 0; i != charArray.length; i++)
		{
			write.println((int)charArray[i].getCharacter() + "NBN" + charArray[i].getFrequency());
		}
		write.close();
	}

}
