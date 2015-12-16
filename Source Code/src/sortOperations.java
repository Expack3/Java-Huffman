import java.util.*;

public class sortOperations {
	public static CharacterFrequency[] sortArray(CharacterFrequency[] list)
	{
		int n = list.length;
		boolean swapped = true;
		while(swapped == true)
		{
			swapped = false;
			for(int i = 1; i != n; i++)
			{
				if(list[i-1].getFrequency() < list[i].getFrequency())
				{
					CharacterFrequency tmp = list[i-1];
					list[i-1] = list[i];
					list[i] = tmp;
					swapped = true;
				}
			}
			n = n - 1;
		}
		return list;
	}
	
	public static BinaryTree<CharacterFrequency>[] sortArray(BinaryTree<CharacterFrequency>[] list)
	{
		int n = list.length;
		boolean swapped = true;
		while(swapped == true)
		{
			swapped = false;
			for(int i = 1; i != n; i++)
			{
				if(list[i-1].getCurrent().getFrequency() < list[i].getCurrent().getFrequency())
				{
					BinaryTree<CharacterFrequency> tmp = list[i-1];
					list[i-1] = list[i];
					list[i] = tmp;
					swapped = true;
				}
			}
			n = n - 1;
		}
		return list;
	}
	
	public static Vector<BinaryTree<CharacterFrequency>> sortArray(Vector<BinaryTree<CharacterFrequency>> list)
	{
		int n = list.size();
		boolean swapped = true;
		while(swapped == true)
		{
			swapped = false;
			for(int i = 1; i != n; i++)
			{
				if(list.elementAt(i-1).getCurrent().getFrequency() < list.elementAt(i).getCurrent().getFrequency())
				{
					BinaryTree<CharacterFrequency> tmp = list.elementAt(i-1);
					//list[i-1] = list[i]
					list.set(i-1, list.elementAt(i));
					//list[i] = tmp
					list.set(i, tmp);
					swapped = true;
				}
			}
			n = n - 1;
		}
		return list;
	}
}
