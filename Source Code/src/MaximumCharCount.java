
public class MaximumCharCount {
	public static double find (CharacterFrequency[] charFreq)
	{
		double maxChars = 0;
		for(int i = 0; i != charFreq.length; i++)
		{
			maxChars = maxChars + charFreq[i].getFrequency();
		}
		return maxChars;
	}
}
