import java.util.BitSet;

public class CharacterBinary {
	private char character;
	private String binaryCode;
	
	public CharacterBinary(char character) //this constructor initializes the class takes the inputed character, defines the associated value, and sets the frequency variable to 1
	{
		setCharacter(character);
		setCode(null);
	}
	
	public CharacterBinary()
	{
	}
	
	public CharacterBinary(char character, String code)
	{
		setCharacter(character);
		setCode(code);
	}
	
	public CharacterBinary(int character) //this constructor initializes the class takes the inputed ASCII value, defines the associated value, and sets the frequency variable to 1
	{
		setCharacter((char)character);
		setCode(null);
	}
	
	public char getCharacter()
	{
		return character;
	}
	
	public void setCharacter(char ch)
	{
		character = ch;
	}
	
	public String getCode()
	{
		return binaryCode;
	}
	
	public void setCode(String bit)
	{
		binaryCode = bit;
	}
	
    public boolean equals(Object obj) //compare two CharacterFrequency objects to see if their contents are identical
    {
        if (this == obj) //is obj a reference to this class?
            return true;
        if (obj == null) //is obj null?
            return false;
        if (this.getClass() != obj.getClass()) //is obj not the same class?
            return false;

        CharacterBinary cf = (CharacterBinary)obj; //passed all pre-checks, now create reference to obj

        if ((this.character == cf.getCharacter()) && (this.binaryCode == cf.getCode())) //are the character and frequency variables identical?
            return true;
        else
            return false;
    }
}