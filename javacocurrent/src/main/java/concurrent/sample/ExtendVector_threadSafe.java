/**
 * 
 */
package java_base.concurrent.sample;

import java.util.Vector;

/**
 * @author Homer
 * THis is to extend the vectory to add a new method for add if not exist. 
 * We need to keep it thread safe. This code is good. 
 *
 */
public class ExtendVector_threadSafe<E> extends Vector<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public synchronized boolean putIfAbsent(E x){
		boolean absent = !contains(x);
		if(absent)
			add(x);
		return absent;
	}
}
