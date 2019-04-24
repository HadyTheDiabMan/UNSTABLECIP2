import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CipherPart2 
{

	public static void main(String[] args) throws IOException 
	{
		
		Scanner scan= new Scanner(System.in);
		String fileName;
		boolean encrypt; //(true=encrypt, false=decrypt)
		int shiftAmount;
		
		System.out.println("Would you like to encrypt or decrypt a file?: ");
		String encordec= scan.nextLine();
		
		while((!encordec.equals("encrypt"))&&(!encordec.equals("Encrypt"))
				&& (!encordec.equals("decrypt")) && (!encordec.equals("Decrypt")))
		{
			System.out.println("Invalid.  Please re-enter if you want to"
					+ " encrypt or decrypt: ");
			
		}
		if (encordec.equals("encrypt") || encordec.equals("Encrypt")) 
			encrypt=true;
		else
			encrypt=false;
		
		System.out.println("How many places should the alphabet be shifted?");
		
		shiftAmount= scan.nextInt();
		while(shiftAmount < -26 || shiftAmount >26)
		{
			System.out.println("INVALID NUMBER. Please enter a valid number(0-26): ");
			shiftAmount= scan.nextInt();
		}
		
		scan.next();
		
		if(encrypt=true)
		{
		System.out.println("Please enter in a filename to encrypt: ");
		
		fileName= scan.nextLine();
		caesar_cipher(fileName,encrypt, shiftAmount);
		}
		
		else
		{
		System.out.println("Please enter in a filename to decrypt: ");
		fileName= scan.nextLine();
		}
		
		
		
		
		
		
		

		
		

	}

	
	
	
	public static String caesar_cipher(String fileName, boolean encrypt,
						int shiftAmount)  throws IOException
	{
		String TheEncryptedFile = "";
		if(encrypt=true)
		{
			Scanner inputFile= new Scanner(new File(fileName)); 
			
			String partOfFile= fileName.substring(0, fileName.length()-4);
			PrintWriter outputfile= new PrintWriter(partOfFile+"_ENC.txt");
			
			
			while (inputFile.hasNext())

				
					{ 

					String line = inputFile.nextLine(); 
					char[] linechars= new char[line.length()];
					
					for(int h=0; h<line.length();h++)
					{
						linechars[h]= line.charAt(h);
					}
					
					for(int i=0; i<line.length();i++)
					{
						
						char regularchar=linechars[i];
						char encryptchar= (char) (regularchar+((shiftAmount%regularchar)));
						if(regularchar==97)
						{
							encryptchar='x';
						}
						if(regularchar==98)
						{
							encryptchar='y';
						}
						if(regularchar==99)
						{
							encryptchar='z';
						}
						if(regularchar==65)
						{
							encryptchar='X';
						}
						if(regularchar==66)
						{
							encryptchar='Y';
						}
						if(regularchar==67)
						{
							encryptchar='Z';
						}
						if(encryptchar<65)
						{
							encryptchar=regularchar;
						}
						if(encryptchar>122 && encryptchar<97&&encryptchar>90)
						{
							encryptchar=regularchar;
						}
						
						outputfile.print(encryptchar);
					}
					outputfile.println("");
					 
					
					
				}
				
				
			String theEncryptedFilemethod= "Result written to "+partOfFile+"_ENC.txt";
			TheEncryptedFile=theEncryptedFilemethod;
			outputfile.close();
			inputFile.close();
			return TheEncryptedFile;

		}
		
		
		
		
	}
}
