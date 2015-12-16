import java.io.IOException;
import java.util.*;


public class mainApp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		int huffmanType = 1;
		double maxCharsInDecode = 0; //only used if decoding
		String infile = "wap.txt";
		String outfile = "default.txt";
		String charArrayOutput = "characterFreqs.freq";
		
		if(args.length == 3)
		{
			huffmanType = Integer.parseInt(args[0]);
			infile = args[1];
			outfile = args[2];
		}
		else if(args.length == 4)
		{
				huffmanType = Integer.parseInt(args[0]);
				infile = args[1];
				outfile = args[2];
				charArrayOutput = args[3];
		}
		else
		{
			System.out.println("Invalid syntax. Try again using the following syntax: ");
			System.out.println("[operation number] [location of input file] [desired location of output file]");
			System.out.println("");
			System.out.println("An example would be: 1 c:\\users\\mackBridge2543\\textfiles\\wap.txt d:\\textfiles\\wapEncoded.txt");
			System.exit(0);
		}
		
		//load array with CharacterFrequency classes
		CharacterFrequency[] charLink = null;
		if(huffmanType == 1)
		{
			charLink = CharConversion.convertChars(infile);	
			
			charLink = sortOperations.sortArray(charLink);
			PrintCharArray.print(charLink, charArrayOutput);
		}
		else if(huffmanType == 2)
		{
			charLink = LoadCharArray.load(charArrayOutput);
			maxCharsInDecode = MaximumCharCount.find(charLink);
		}
		else
		{
			System.out.println("Invalid operation number. Try again using one of the following numbers:");
			System.out.println("");
			System.out.println("1\tEncodes the input file and places the result in the output file.");
			System.out.println("2\tDecodes the input file and places the result in the output file.");
			System.exit(0);
		}
		
		LinkedList<BinaryTree<CharacterFrequency>> treeList = new LinkedList<BinaryTree<CharacterFrequency>>();
		
		//load linked list with binary trees
		if(huffmanType == 1)
		{
			for(int i = 0; i != charLink.length; i++)
			{
				treeList.add(new BinaryTree<CharacterFrequency>());
				treeList.getLast().insert(charLink[i], BinaryTree.Relative.root);
			}
		}
		else
		{
			for(int i = 0; i != charLink.length; i++)
			{
				treeList.add(new BinaryTree<CharacterFrequency>());
				treeList.getLast().insert(charLink[i], BinaryTree.Relative.root);
			}
		}
		
		//preemptively create two temporary binary trees for the upcoming while loop
		
		BinaryTree<CharacterFrequency> tempTree1, tempTree2, mergedTree;
		Vector<BinaryTree<CharacterFrequency>> tempTreeVector = null;
		tempTree1 = null; tempTree2 = null; mergedTree = null;
		
		while(treeList.size() != 1)
		{
			tempTree1 = treeList.removeLast();
			tempTree2 = treeList.removeLast();
			
			//Merge character nodes into new binary tree
			if(huffmanType == 1)
				mergedTree = new BinaryTree<CharacterFrequency>();
			else
				mergedTree = new BinaryTree<CharacterFrequency>();
				
			mergedTree.insert(new CharacterFrequency(' ', tempTree1.getCurrent().getFrequency() + tempTree2.getCurrent().getFrequency()), BinaryTree.Relative.root);
			mergedTree.insert(tempTree1, BinaryTree.Relative.leftChild);
			mergedTree.insert(tempTree2, BinaryTree.Relative.rightChild);
			
			//Add new tree back into list
			treeList.add(mergedTree);
			
			//Sort again
			tempTreeVector = new Vector<BinaryTree<CharacterFrequency>>();
			tempTreeVector = sortOperations.sortArray(loadVectorFromList(treeList));
			treeList = loadListFromVector(tempTreeVector);
			tempTreeVector = null;
		}
		
		if(huffmanType == 1)
		{
			Vector<String[]> vectorString = new Vector<String[]>();
			treeList.getLast().createEncodingTable(treeList.getLast().getRoot(),vectorString);
			Encoder.encode(infile,outfile,vectorString, charArrayOutput);
		}
		else if(huffmanType == 2)
		{
			Vector<String[]> vectorString = new Vector<String[]>();
			treeList.getLast().createEncodingTable(treeList.getLast().getRoot(),vectorString);
			System.out.println("Huffman tree reconstructed. Decoding " + infile);
			Decoder.decode(treeList, infile, outfile, maxCharsInDecode);
		}
	}
	
	private static LinkedList<BinaryTree<CharacterFrequency>> loadListFromVector(Vector<BinaryTree<CharacterFrequency>> treeVector)
	{
		LinkedList<BinaryTree<CharacterFrequency>> newList = new LinkedList<BinaryTree<CharacterFrequency>>();
		for(int i = 0; i != treeVector.size(); i++)
		{
			newList.add(treeVector.get(i));
		}
		return newList;
	}
	
	private static Vector<BinaryTree<CharacterFrequency>> loadVectorFromList (LinkedList<BinaryTree<CharacterFrequency>> treeList)
	{
		Vector<BinaryTree<CharacterFrequency>> newVector = new Vector<BinaryTree<CharacterFrequency>>();
		BinaryTree<CharacterFrequency> BTree;
		while(treeList.size() != 0)
		{
			BTree = treeList.removeLast();
			newVector.add(BTree);
		}
		return newVector;
	}
}
