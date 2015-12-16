import java.io.*;
import java.nio.charset.Charset;
import java.util.*;


public class Decoder {
	public static void decode(LinkedList<BinaryTree<CharacterFrequency>> tree, String fileLocation, String outputLocation, double maxCharCount) throws FileNotFoundException, IOException
	{
		BTreeNode<CharacterFrequency> node;
		FileInputStream fis = new FileInputStream(fileLocation); //load the given input file
		FileWriter fw = new FileWriter(outputLocation);
		byte ele;
		boolean gatekeeper = false;
		String line, bitCode;
		ele = (byte)fis.read();
		line = ("00000000" + Integer.toBinaryString(ele)).substring(Integer.toBinaryString(ele).length());
		//line = Integer.toBinaryString(ele);
		node = tree.getLast().getRoot();
		int i = 0; int j = 0; 
		double currCharCount = 0;
		while(gatekeeper == false)
		{
			
			bitCode = "";
			while(node.isLeaf() != true && gatekeeper == false)
			{
				if(line.charAt(i) == '0')
				{
					bitCode = bitCode + "0";
					node = node.getLeft();
				}
				else if(line.charAt(i) == '1')
				{
					bitCode = bitCode + "1";
					node = node.getRight();
				}
				i++; j++;
				if(i > 7 && gatekeeper == false)
				{
					i = 0;
					if(j >= line.length())
					{
						ele = (byte)fis.read();
						j = 0;
						line = ("00000000" + Integer.toBinaryString(ele)).substring(Integer.toBinaryString(ele).length());
					}
						//line = Integer.toBinaryString(String.valueOf(ele).charAt(0));
				}
				else if(j > line.length() && gatekeeper == false)
				{
					ele = (byte)fis.read();
					j = 0;
					line = ("00000000" + Integer.toBinaryString(ele)).substring(Integer.toBinaryString(ele).length());
				}
			}
			fw.write(node.getElement().getCharacter());
			node = tree.getLast().getRoot();
			currCharCount++;
			if(currCharCount >= maxCharCount)
				gatekeeper = true;
		}
		fw.close();
		fis.close();
		System.out.println(fileLocation + " has been decoded to " + outputLocation);
	}
}
