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
 * This is to add new function for current list. 
 * And the function. 
 */
public class ExtendList_threadSafe<E> {
	
	public List<E> list= Collections.synchronizedList(new ArrayList<E>());
	public boolean putIfAbsent(E x){
		synchronized (list){
			boolean absent = !list.contains(x);
			if (absent)
				list.add(x);
			return absent;
		}
	}
}
