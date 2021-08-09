


package predictive;

import static org.junit.Assert.assertEquals;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class WorksheetTest {

	@Test
	public void ex1Test1() {
		

		assertEquals(PredictivePrototype.wordToSignature("home"), "4663");
		assertEquals(PredictivePrototype.wordToSignature(" "), " ");
		

	}

	@Test
	public void ex1Test2() {

		Set<String> exp = new TreeSet<>();
		exp.add("dream");
		exp.add("fream");
		
		Set<String> tex = new TreeSet<>();
		tex.add("flower");

		assertEquals(PredictivePrototype.signatureToWords("37326"), exp);
		assertEquals(PredictivePrototype.signatureToWords("356937"), tex);
	}

	@Test
	public void ex1Test3() {

		assertEquals(PredictivePrototype.isValidWord("apple"), true);
		assertEquals(PredictivePrototype.isValidWord("12dw"), false);
	}

	@Test
	public void ex1Test4() {

		ListDictionary dict = new ListDictionary("/usr/share/dict/words");

		Set<String> exp = new HashSet<String>();
		exp.add("dream");
		exp.add("fream");
		
		Set<String> tex = new HashSet<String>();
		tex.add("flower");
		
		Set<String> pas = new HashSet<String>();
		pas.add("zest");
		pas.add("yest");
		pas.add("west");
		pas.add("wert");
		pas.add("wept");
		
		assertEquals(dict.signatureToWords("37326"), exp);
		assertEquals(dict.signatureToWords("356937"), tex);
		assertEquals(dict.signatureToWords("9378"), pas);
	}


@Test
public void ex1Test5() {

	MapDictionary dict = new MapDictionary("/usr/share/dict/words");

	Set<String> a = new HashSet<String>();
	a.add("dream");
	a.add("fream");
	
	Set<String> b = new HashSet<String>();
	b.add("flower");
	
	Set<String> c = new HashSet<String>();
	c.add("zest");
	c.add("yest");
	c.add("west");
	c.add("wert");
	c.add("wept");
	
	assertEquals(dict.signatureToWords("37326"), a);
	assertEquals(dict.signatureToWords("356937"), b);
	assertEquals(dict.signatureToWords("9378"), c);
}
@Test
public void ex1Test6() {

	TreeDictionary dict = new TreeDictionary("/usr/share/dict/words");

	Set<String> a = new HashSet<String>();
	a.add("dream");
	a.add("fream");
	
	Set<String> b = new HashSet<String>();
	b.add("flower");
	
	Set<String> c = new HashSet<String>();
	c.add("zest");
	c.add("yest");
	c.add("wept");
	c.add("werv");
	c.add("yert");
	c.add("zeru");
	c.add("zequ");
	c.add("wert");
	c.add("west");
	c.add("xeru");
	
	assertEquals(dict.signatureToWords("37326"), a);
	assertEquals(dict.signatureToWords("356937"), b);
	assertEquals(dict.signatureToWords("9378"), c);
}

}
	