/**
 * 
 */
package java_base.concurrent.sample;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Homer
 *
 *  This is to create a threadsafe. Will use thread to lock the entrance. 
 *  Though personSet is hashSet is not threadsafe, but for the two methods to access the set, they use 
 *  synchronzied. 
 */
public class PersonSet {
	
	private final Set<Person> personSet = new HashSet<Person>();
	
	public synchronized void addPerson(Person e){
		personSet.add(e);
	}
	
	public synchronized boolean contain(Person e){
		return personSet.contains(e);
	}
}
