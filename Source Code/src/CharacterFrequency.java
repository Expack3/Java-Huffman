public class CharacterFrequency {
	private char character;
	private int frequency;
	
	public CharacterFrequency(char character) //this constructor initializes the class takes the inputed character, defines the associated value, and sets the frequency variable to 1
	{
		setCharacter(character);
		setFrequency(1);
	}
	
	public CharacterFrequency()
	{
	}
	
	public CharacterFrequency(char character, int frequency)
	{
		setCharacter(character);
		setFrequency(frequency);
	}
	
	public CharacterFrequency(int character) //this constructor initializes the class takes the inputed ASCII value, defines the associated value, and sets the frequency variable to 1
	{
		setCharacter((char)character);
		setFrequency(1);
	}
	
	public static CharacterFrequency add(CharacterFrequency left, CharacterFrequency right)
	{
		CharacterFrequency cf = new CharacterFrequency();
		
		if(left.character == right.character)
		{
			cf.character = left.character;
			cf.frequency = left.character + right.character;
		}
		
		return cf;
	}
	
	public char getCharacter()
	{
		return character;
	}
	
	public void setCharacter(char ch)
	{
		character = ch;
	}
	
	public int getFrequency()
	{
		return frequency;
	}
	
	public void setFrequency(int integer)
	{
		frequency = integer;
	}
	
	public void increment() //increase frequency by 1
	{
		frequency++;
	}
	
    public boolean equals(Object obj) //compare two CharacterFrequency objects to see if their contents are identical
    {
        if (this == obj) //is obj a reference to this class?
            return true;
        if (obj == null) //is obj null?
            return false;
        if (this.getClass() != obj.getClass()) //is obj not the same class?
            return false;

        CharacterFrequency cf = (CharacterFrequency)obj; //passed all pre-checks, now create reference to obj

        if ((this.character == cf.character) && (this.frequency == cf.frequency)) //are the character and frequency variables identical?
            return true;
        else
            return false;
    }
}