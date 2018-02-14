/** File ProgramMemory. */
package daa.practice1.randomaccessmachine.memory;

/** Import the necessary classes for FileReader and BufferedReader.*/
import java.io.*;
import java.util.Hashtable;

import daa.practice1.randomaccessmachine.memory.register.ProgramRegister;


/**
 * Class that contains an array of the Program Register that the Random Access Machine
 * will use.
 * @author Ángel Igareta
 * @version 1.0
 * @since 12-2-2018
 */
public class ProgramMemory extends InfiniteMemory<ProgramRegister> {
	
	private Hashtable<String, Integer> tagHash;

	/**
	 * Constructor of the Program Memory. It reads all the lines in the program file and
	 * charges them in the Array List of ProgramRegister.
	 * @param programFilename String that contains the name of the program file.
	 * @throws IOException
	 */
	public ProgramMemory(String programFilename) throws IOException {
		super();
		
		BufferedReader reader = new BufferedReader(new FileReader(programFilename));
		tagHash = new Hashtable<String, Integer>();
		int i = 1;
		
		while (reader.ready()) {
			String newLine = reader.readLine().replaceFirst("\\s*", "");
			
			if (!newLine.startsWith("#") && !newLine.isEmpty()) { // Omit comments or blank lines
				
				String possibleTag = newLine.split("[\t ]+")[0];
				if (possibleTag.endsWith(":")) { // Check for tags
					tagHash.put(possibleTag, i);
					newLine = newLine.replaceFirst(possibleTag, "").replaceFirst("[\t ]+", "");
				}
				
				//System.out.println(newLine.split("[\t ]+")[1]);
				setRegisterAt(i, new ProgramRegister(newLine));
//				System.out.println(i + ": " + getRegisterAt(i).getInstructionType().name() + " " +
//						getRegisterAt(i).getInstructionType().getOperatorType().name() + " " +
//						getRegisterAt(i).getInstructionType().getOperatorType().getTag() + " " +
//						getRegisterAt(i).getInstructionType().getOperatorType().getRegisterNumber());
			}			
			i++;
		}
		
		reader.close();
	}

	/* (non-Javadoc)
	 * @see daa.practice1.randomaccessmachine.memory.InfiniteMemory#setRegisterAt(int, java.lang.Object)
	 */
	@Override
	public void setRegisterAt(int index, ProgramRegister data) {
		memory.put(getPosition(index), data);
	}

	/* (non-Javadoc)
	 * @see daa.practice1.randomaccessmachine.memory.InfiniteMemory#getRegisterAt(int)
	 */
	@Override
	public ProgramRegister getRegisterAt(int index) {
		//if (index < 0 || index >= memory.size()) {
		//	setRegisterAt(index, new ProgramRegister(""));
		//}
		return memory.get(getPosition(index));
	}
}
