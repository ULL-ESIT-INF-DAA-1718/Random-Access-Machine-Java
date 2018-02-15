/** File ProgramRegister. */
package daa.practice1.randomaccessmachine.memory.register;

import daa.practice1.randomaccessmachine.memory.instruction.InstructionType;

/**
 * The class ProgramRegister contains the instruction in a register.
 * @author Ángel Igareta
 * @version 2.0
 * @since 12-2-2018
 */
public class ProgramRegister extends Register<String> {

	/**
	 * Enum that represent the Type of instruction the line contains.
	 */
	private InstructionType instructionType;
	
	/**
	 * The constructor analyze the raw instruction passed by argument and 
	 * classifies it thanks to the method analyzeInstructionType.
	 * @param data Raw instruction.
	 */
	public ProgramRegister(String data) {
		super(data);
		
		analyzeInstructionType(data.split("[\t ]+")[0]);
		
		if (instructionType != InstructionType.halt) {
			instructionType.analyzeOperatorType(data.split("[\t ]+")[1]);
		}
	}

	/**
	 * Method to classify the instruction depending on it's name.
	 * @param Represents the instruction Name.
	 */
	private void analyzeInstructionType(String instructionName) {
		
		for (Enum instructionRealName : InstructionType.values()) {
			if (instructionName.toLowerCase().equals(instructionRealName.name()) || 
					instructionName.toUpperCase().equals(instructionRealName.name())) {
				instructionType = InstructionType.valueOf(instructionRealName.name());
			}
		}
	}	
	
	/**
	 * Getter of the instructionType.
	 * @return The instruction Type.
	 */
	public InstructionType getInstructionType() {
		return instructionType;
	}
}
