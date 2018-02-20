/** File InfiniteMemory. */
package daa.practice1.randomaccessmachine.memory;

/** Import TreeMap due the class InfiniteMemory uses it. */
import java.util.TreeMap;

/**
 * InfiniteMemory is an abstract class that simulates an infinite TreeMap. The
 * subclasses of InfiniteMemory must implement a getter and a setter of that
 * TreeMap.
 * 
 * @author Ángel Igareta
 * @version 1.0
 * @since 12-2-2018
 */
public abstract class InfiniteMemory<T> {

	/** Generic TreeMap. */
	protected TreeMap<Integer, T> memory;
	/**
	 * Constant that defines the minimum value of the memory to simulate the
	 * infinity.
	 */
	private final int MAX_CAPACITY = new Double(Math.pow(10, 7)).intValue();

	/**
	 * Constructor of the InfiniteMemory class. It creates the instance of the
	 * generic TreeMap.
	 */
	protected InfiniteMemory() {
		memory = new TreeMap<Integer, T>();
	}

	/**
	 * Method that uses a hashCode to assign an index to an position in the memory.
	 * It uses the module type.
	 * 
	 * @param index
	 *          The cyclic index.
	 * @return The hash position that matches the index passed by argument.
	 */
	protected int getMemoryPosition(int index) {
		return index % MAX_CAPACITY;
	}

	/**
	 * Abstract Method that subclasses must implement to specify how a data in the
	 * register can be accessed.
	 * 
	 * @param index
	 *          Index of the register.
	 * @return Data at the memory index passed by argument.
	 */
	protected abstract T getRegisterAt(int index) throws Exception;

	/**
	 * Abstract Method that subclasses must implement to specify how a data in the
	 * register can be accessed and changed.
	 * 
	 * @param index
	 *          Index of the register.
	 * @param data
	 *          Data that has to be at the memory index passed by argument.
	 */
	protected abstract void setRegisterAt(int index, T data) throws Exception;
}
