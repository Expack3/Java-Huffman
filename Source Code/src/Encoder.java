import java.io.*;
import java.nio.charset.Charset;
import java.util.*;


public class Encoder {
	public static void encode(String sourceFile, String encodeOutput, Vector<String[]> vectorString, String charArrayOutput) throws IOException
	{
		//declare variables
		String encodeFile = encodeOutput;
		
		FileInputStream fis = new FileInputStream(sourceFile); //load the given input file
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("US-ASCII"))); //in order to allow massive text files to be efficiently read (see: War and Peace), buffer Java's output from the loaded text file;
		FileOutputStream bitWriter = new FileOutputStream(encodeFile);

		int character;
		byte byter = 0;
		int k = 0;
		int j = 0;
		
		while((character = br.read()) != -1) //while the result of storing the next char in character is not equal to null...
		{
			for(int i = 0; i < vectorString.size(); i++) //traverse the entire encode list
			{
				if(character == vectorString.elementAt(i)[0].charAt(0)) //if a ASCII char in the encode list matches character
				{
					while(j < vectorString.elementAt(i)[1].length()) //read each character in the bit sequence in position 1 of element i in encodeList
					{
						if(k != 8) //is the size of the byte not equal to 8?
						{
							if(vectorString.elementAt(i)[1].charAt(j) == '1')
							{
								//byter = (byte)Math.pow(2, 7 - k);
								byter = (byte) (byter | (1 << 7-k));
							}
							k++;j++;
						}
						else
						{
							int s = byter & 0xFF;
							bitWriter.write(s); //write the appropriate (Unicode-16?) character to encodedFile.txt
							byter = 0; //reset byter
							k = 0; //reset bit count
							
						}
					}
					i = vectorString.size(); //force the initial for loop to exit next iteration
					j = 0;
					
					
				}
			}
		}
		if(k > 0)
		{
			byte[] temp = {(byte)byter};
			bitWriter.write(temp); //write the appropriate (Unicode-16?) character to encodedFile.txt
		}
		//close the reader and writer files
		bitWriter.close();
		br.close();
		fis.close();
		
		//inform the user of successful encoding.
		System.out.println(sourceFile + " encoded successfully to " + encodeFile);
		System.out.println("");
		System.out.println("Please note that the information needed to decode " + encodeFile + " has been placed in " + charArrayOutput);
		System.out.println("If you want to decode the file, be sure to either place it in your current working directory or reference the file when calling the application again.");
	}
}
