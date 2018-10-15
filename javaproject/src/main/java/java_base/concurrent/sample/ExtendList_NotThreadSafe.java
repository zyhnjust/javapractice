/**
 * 
 */
package java_base.concurrent.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Homer
 *
 * This is to extends from threadsafe list to add a new method. 
 * 
 * But the code is wrong. 
 * The reason is the lock in syncrhrozed is not the lock on this class. So it is not thread safe. 
 *   TODO need to be more clear. 
 * 
 */
public class ExtendList_NotThreadSafe<E> {
	
	public List<E> list = Collections.synchronizedList(new ArrayList<E>());
	
	public synchronized boolean putIfAbsent(E x){
		boolean isExist = list.contains(x);
		if(!isExist)
			list.add(x);
		return isExist;
	}
	
}
