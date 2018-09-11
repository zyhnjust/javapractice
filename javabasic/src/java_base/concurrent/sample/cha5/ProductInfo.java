/**
 * 
 */
package java_base.concurrent.sample.cha5;

/**
 * @author Homer
 *
 */
public class ProductInfo {

	String name;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param string
	 */
	public ProductInfo(String string) {
		// TODO Auto-generated constructor stub
		this.setName(string);
	}

}
