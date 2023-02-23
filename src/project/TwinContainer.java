package project;

import java.io.Serializable;

/**
 * Two objects used for storing login info
 * 
 * Generic class which will be leveraged by the login pages and controller/model
 * 
 * @author Keir
 * @since 29/03/21
 *
 * @param <T>
 * @param <T2>
 */
public class TwinContainer<T, T2> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private T firstObject;
	private T2 secondObject;
	
	/**
	 * Constructor takes 2 objects (Used for LoginID and Password)
	 * 
	 * @param T obj
	 * @param T obj2
	 */
	public TwinContainer(T obj, T2 obj2) {
		firstObject = obj;
		secondObject = obj2;
	}
	
	
	// setters and getters
	public void setFirstObject(T obj) {
		firstObject = obj;
	}
	
	public void setSecondObject(T2 obj) {
		secondObject = obj;
	}
	
	public T getFirstObject() {
		return firstObject;
	}
	
	public T2 getSecondObject() {
		return secondObject;
	}
}