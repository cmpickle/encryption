package encryption;
/**
 * A program that encodes and decodes a message.
 * 
 * @author Cameron Pickle
 * @author Nathan Pickle
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Encode {

    static FileReader reader = null;
    static FileWriter writer = null;

    public static void main(String[] Args)
    {
	GUI.main(null);
    }

    /**
     * Encodes a string.
     * 
     * @param input
     *            --The string to be encoded
     * @return --Encoded version of the string
     */
    public static String encode(String input)
    {
	Random rand = new Random(42);
	char[] letters = new char[input.length()];
	String result = "";

	// Copies over the characters of the string input to the char[] letters

	for (int i = 0; i < input.length(); i++)
	    letters[i] = input.charAt(i);

	// modifies the Char[]

	for (int j = 0; j < input.length(); j++)
	{
	    // modifies the ASCII value of each char by adding 47 then
	    // multiplies it by two

	    letters[j] = (char) ((letters[j] + 47) * 2);
	    if (j % 3 == 0 || j % 3 == 2)
	    {
		letters[j] += 1;
		letters[j] *= 2;
	    }
	    letters[j] += rand.nextInt(100);
	}

	// Appends the chars from letters to the end of the blank string result
	// to achieve the encoded string

	for (int k = 0; k < input.length(); k++)
	    result += letters[k];

	// returns the encoded string

	return result;
    }

    /**
     * Decodes a string encoded by @encode
     * 
     * @param input
     *            --The string to be decoded
     * @return --The decoded string
     */
    public static String decode(String input)
    {
	Random rand = new Random(42);
	char[] letters = new char[input.length()];
	String result = "";

	for (int i = 0; i < input.length(); i++)
	    letters[i] = input.charAt(i);

	// modifies the Char[]

	for (int j = 0; j < input.length(); j++)
	{
	    letters[j] -= rand.nextInt(100);
	    // Appends the chars from letters to the end of the blank string result
	    // to achieve the encoded string
	    if (j % 3 == 0 || j % 3 == 2)
	    {
		letters[j] /= 2;
		letters[j] -= 1;
	    }
	    // modifies the ASCII value of each char by adding 47 then
	    // multiplies it by two
	    letters[j] = (char) ((letters[j] / 2) - 47);
	}

	for (int k = 0; k < input.length(); k++)
	    result += letters[k];

	// returns the encoded string

	return result;
    }

    /**
     * Converts a string to encoded form and saves it to message.txt in the directory above.
     * @param toConvert
     * 		--The string to be encoded and written to messate.txt
     */
    public static void encodeText(String toConvert)
    {
	toConvert = encode(toConvert);
	try
	{
	    File file = new File("../message.txt");

	    // if file doesn't exists, then create it
	    if (!file.exists())
	    {
		file.createNewFile();
	    }

	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(toConvert);
	    bw.close();

	} catch (IOException e)
	{
	    e.printStackTrace();
	}
    }

    /**
     * Converts a string to encoded form and saves it to message.txt in the directory above.
     * @param toConvert
     * 		--The string to be encoded and written to messate.txt
     * @return
     * 		--A String of the converted text file
     */
    public static String decodeText()
    {
	File file = new File("../message.txt");
	Scanner s = null;
	String result = "";

	try
	{
	    s = new Scanner(file);

	    while (s.hasNextLine())
	    {
		result += s.nextLine();
	    }

	    result = decode(result);
	    s.close();
	} catch (IOException e)
	{
	    e.printStackTrace();
	}
	return result;
    }
}

/****************************************************
 * The old console controls for Encode              *
 ****************************************************/
//while (true)
//{
//    Scanner in = new Scanner(System.in);
//    System.out.println("Do you want to encode or decode?");
//    String encodeDecode = in.nextLine();
//    if (encodeDecode.toLowerCase().equals("encode"))
//    {
//	System.out.println("Do you want a string or text file?");
//	encodeDecode = in.nextLine();
//	if (encodeDecode.toLowerCase().equals("string"))
//	{
//	    System.out.println("What do you want to encode? ");
//	    String toConvert = in.nextLine();
//	    System.out.println(encode(toConvert));
//	} else if (encodeDecode.toLowerCase().equals("text file"))
//	{
//	    System.out.println("What do you want to encode? ");
//	    String toConvert = in.nextLine();
//	    toConvert = encode(toConvert);
//	    try
//	    {
//		File file = new File("../message.txt");
//
//		// if file doesn't exists, then create it
//		if (!file.exists())
//		{
//		    file.createNewFile();
//		}
//
//		FileWriter fw = new FileWriter(file.getAbsoluteFile());
//		BufferedWriter bw = new BufferedWriter(fw);
//		bw.write(toConvert);
//		bw.close();
//
//		System.out.println("Done");
//
//	    } catch (IOException e)
//	    {
//		e.printStackTrace();
//	    }
//	}
//
//    } else if (encodeDecode.toLowerCase().equals("decode"))
//    {
//	System.out.println("Do you want to decode a string or text file?");
//	encodeDecode = in.nextLine();
//	if (encodeDecode.toLowerCase().equals("string"))
//	{
//	    System.out.println("What do you want to decode? ");
//	    String toConvert = in.next();
//	    System.out.println(decode(toConvert));
//	} else if (encodeDecode.toLowerCase().equals("text file"))
//	{
//	    File file = new File("../message.txt");
//	    Scanner s = null;
//
//	    try
//	    {
//		s = new Scanner(file);
//		String result = "";
//
//		while (s.hasNextLine())
//		{
//		    result += s.nextLine();
//		}
//
//		result = decode(result);
//
//		System.out.println(result);
//
//	    } catch (IOException e)
//	    {
//		e.printStackTrace();
//	    }
//	}
//
//    } else
//    {
//	System.out.println("You are a fool! I said do you want to encode or decode?");
//    }
//}
