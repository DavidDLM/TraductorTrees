import static org.junit.Assert.*;
import java.util.TreeMap;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Usuario Dell
 *
 */
public class TreeTest {

	TreeMap<String, String> tree = new TreeMap<String, String>();
	
	@Test
	public void addTreeTest() {
		tree.put("dog", "perro");
		assertEquals("perro", tree.get("dog"));
	}
	@Test
	public void insertTreeTest() {
		tree.put("woman","mujer");
			assertEquals(true, tree.containsKey("woman"));		
	}
	@Test
	public void containsValueTest() {
		tree.put("town","pueblo");
			assertEquals(true, tree.containsValue("pueblo"));		
	}
	

}
