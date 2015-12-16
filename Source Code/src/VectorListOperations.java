import java.util.Vector;

public class VectorListOperations {
	public static int searchList(Vector<CharacterFrequency> charList, char character) //given a vector and a character, search the given vector for the given character and return its position in the vector if found
	{
		int characterLocation = -1; //stores the indexed location of the desired character; defaults to -1
		int index = 0; //current position in vector
		if(charList != null) //has the given vector uninitialized?
		{
			while((index != charList.size()) && (characterLocation == -1))//has the search exceeded the size of the vector? has the desired character been found?
			{
				if(charList.get(index).getCharacter() == character) //is the desired character in the current vector position?
					characterLocation = index; //if so, make characterLocation equal to the current value of index
				else
					index++; //otherwise, increment
			}
		}
		return characterLocation;
	}
	
	public static Vector<CharacterFrequency> bubbleSortList(Vector<CharacterFrequency> charList) //given a vector, sort its contents from the lowest ASCII value to the highest ASCII value; method below created by MathBits.com, http://mathbits.com/MathBits/Java/arrays/Bubble.htm; method adapted to work with CharacterFrequency vectors
	{
		charList.trimToSize(); //trim any null pointers from the vector before processing
		int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     CharacterFrequency temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < charList.size() -1;  j++ )
	            {
	                   if ( charList.get(j).getCharacter() > charList.get(j+1).getCharacter() )   // change to > for ascending sort
	                   {
	                           temp = charList.get(j);                //swap elements
	                           charList.set(j, charList.get(j+1));
	                           charList.set(j+1, temp);
	                          flag = true;              //shows a swap occurred  
	                  }
	            } 
	      }
		return charList;
	}
}