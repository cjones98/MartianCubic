package p5_testing;
import static org.junit.Assert.*;

import org.junit.Test;

import p5_martiancubic.MartianCubic;
import p5_utility.DoubleWithAppx;


public class YourTests {
	//SOME EXAMPLE JUNIT TESTS TO GET YOU STARTED THINKING ABOUT 
	//  WRITING JUNIT TESTS
	

	@Test
	public void testDefaultConstructor() {
		MartianCubic testMartianCubic = new MartianCubic();
		assertTrue(testMartianCubic.getA().isZero()
				&& testMartianCubic.getB().isZero()
				&& testMartianCubic.getC().isZero()
				&& testMartianCubic.getD().isZero());
	}
	
	
	
	@Test
	public void testSingleValConstructor() {
		DoubleWithAppx dVal = new DoubleWithAppx(27.8);
				
		MartianCubic testMartianCubic = new MartianCubic(dVal);
		assertTrue(testMartianCubic.getA().isZero()
				&& testMartianCubic.getB().isZero()
				&& testMartianCubic.getC().isZero()
				&& testMartianCubic.getD().equals(dVal));
	}


	
	@Test
	public void testTwoValConstructor() {
		DoubleWithAppx cVal = new DoubleWithAppx(23.2);
		DoubleWithAppx dVal = new DoubleWithAppx(-4.7);
				
		MartianCubic testMartianCubic = new MartianCubic(cVal, dVal);
		assertTrue(testMartianCubic.getA().isZero()
				&& testMartianCubic.getB().isZero()
				&& testMartianCubic.getC().equals(cVal)
				&& testMartianCubic.getD().equals(dVal));
	}


	
	@Test
	public void testThreeValConstructor() {
		DoubleWithAppx bVal = new DoubleWithAppx(15.7);
		DoubleWithAppx cVal = new DoubleWithAppx(-23.7);
		DoubleWithAppx dVal = new DoubleWithAppx(4.3);
				
		MartianCubic testMartianCubic = new MartianCubic(bVal, cVal, dVal);
		assertTrue(testMartianCubic.getA().isZero()
				&& testMartianCubic.getB().equals(bVal)
				&& testMartianCubic.getC().equals(cVal)
				&& testMartianCubic.getD().equals(dVal));
	}


	
	@Test
	public void testFourValConstructor() {
		DoubleWithAppx aVal = new DoubleWithAppx(43.1);
		DoubleWithAppx bVal = new DoubleWithAppx(15.7);
		DoubleWithAppx cVal = new DoubleWithAppx(-23.7);
		DoubleWithAppx dVal = new DoubleWithAppx(4.3);
				
		MartianCubic testMartianCubic = new MartianCubic(aVal, bVal, cVal, dVal);
		assertTrue(testMartianCubic.getA().equals(aVal)
				&& testMartianCubic.getB().equals(bVal)
				&& testMartianCubic.getC().equals(cVal)
				&& testMartianCubic.getD().equals(dVal));
	}


	
	@Test
	public void testCopyConstructor() {
		DoubleWithAppx aVal = new DoubleWithAppx(-19.2);
		DoubleWithAppx bVal = new DoubleWithAppx(24.2);
		DoubleWithAppx cVal = new DoubleWithAppx(-3.2);
		DoubleWithAppx dVal = new DoubleWithAppx(18.7);
		
		MartianCubic testMartianCubic = new MartianCubic(aVal, bVal, cVal, dVal);
		MartianCubic testCopyCubic = new MartianCubic(testMartianCubic);
		
		// Check to be sure they are not aliased!
		assertTrue(testMartianCubic != testCopyCubic);     
		
		assertTrue(testMartianCubic.getA().equals(testCopyCubic.getA())
				&& testMartianCubic.getB().equals(testCopyCubic.getB())
				&& testMartianCubic.getC().equals(testCopyCubic.getC())
				&& testMartianCubic.getD().equals(testCopyCubic.getD()));
		
		assertEquals(testMartianCubic, testCopyCubic);
	}


	
	@Test
	public void testGetters() {
		DoubleWithAppx one = new DoubleWithAppx(1.1);
		DoubleWithAppx two = new DoubleWithAppx(2.2);
		DoubleWithAppx three = new DoubleWithAppx(3.3);
		DoubleWithAppx four = new DoubleWithAppx(4.4);
		
		MartianCubic p = new MartianCubic(one, two, three, four);

		assertTrue(p.getA().equals(one));
		assertTrue(p.getB().equals(two));
		assertTrue(p.getC().equals(three));
		assertTrue(p.getD().equals(four));
	}


	

	//You need to implement at least three of the JUnit tests below.
	//  We encourage you to implement more as part of your regular
	//  testing of your project.
	
	@Test
	public void testAdd() {//Basic addition of the coefficients of a MartianCubic
		DoubleWithAppx one = new DoubleWithAppx(1.1);
		DoubleWithAppx two = new DoubleWithAppx(2.2);
		DoubleWithAppx three = new DoubleWithAppx(3.3);
		DoubleWithAppx four = new DoubleWithAppx(4.4);
		
		MartianCubic w= new MartianCubic(one, two, three, four);
		MartianCubic x = new MartianCubic(one,two, three, four);
		MartianCubic y= w.add(x);
		MartianCubic z= new MartianCubic(new DoubleWithAppx(2.2),new DoubleWithAppx(4.4), new DoubleWithAppx(6.6), new DoubleWithAppx(8.8));
		assertTrue(y.equals(z));
	}

	@Test
	public void testSubtract() {// Basic subtraction of the coefficients of a MartianCubic
		DoubleWithAppx one = new DoubleWithAppx(1.1);
		DoubleWithAppx two = new DoubleWithAppx(2.2);
		DoubleWithAppx three = new DoubleWithAppx(3.3);
		DoubleWithAppx four = new DoubleWithAppx(4.4);
		
		MartianCubic w= new MartianCubic(one, two, three, four);
		MartianCubic x = new MartianCubic(one,two, three, four);
		MartianCubic y= w.subtract(x);
		MartianCubic z= new MartianCubic(new DoubleWithAppx(0),new DoubleWithAppx(0), new DoubleWithAppx(0), new DoubleWithAppx(0));
		assertTrue(y.equals(z));
	}

	@Test
	public void testGlorp() {// This tests the Glorp of the MartianCubic in the form  
							//(af + be)x^4 + (ae)x^3 + (cf + be + ad)x^2 + (ce + bd)x + cdgh
		DoubleWithAppx one = new DoubleWithAppx(1.1);
		DoubleWithAppx two = new DoubleWithAppx(2.2);
		DoubleWithAppx three = new DoubleWithAppx(3.3);
		DoubleWithAppx four = new DoubleWithAppx(4.4);
		MartianCubic w= new MartianCubic(one, two, three, four);
		MartianCubic x = new MartianCubic(one,two, three, four);
		MartianCubic y= w.glorp(x);
		assertTrue(y==null);
		
		MartianCubic a = new MartianCubic(new DoubleWithAppx(1), new DoubleWithAppx(0), new DoubleWithAppx(2), new DoubleWithAppx(3)); 
		MartianCubic b = new MartianCubic(new DoubleWithAppx(1), new DoubleWithAppx(0), new DoubleWithAppx(2), new DoubleWithAppx(3));
		y=a.glorp(b);
		assertTrue(y!=null);
		 one = new DoubleWithAppx(1);
		 two = new DoubleWithAppx(3);
		 three = new DoubleWithAppx(2);
		 four = new DoubleWithAppx(36);
		assertTrue(y.equals(new MartianCubic(one, two,three, four)));
	}

	@Test
	public void testSplee() { //This returns the splee of the object, which is given by the equations "18abcdx^3 - 4b^3dx". 
								//If not, the J unit will fail q
		MartianCubic test = new MartianCubic(new DoubleWithAppx(1), new DoubleWithAppx(1), new DoubleWithAppx(1), new DoubleWithAppx(2));
		MartianCubic result = new MartianCubic(new DoubleWithAppx(36), DoubleWithAppx.ZERO, new DoubleWithAppx(-8), DoubleWithAppx.ZERO);
		assertTrue(test.splee().equals(result));
	}

	@Test
	public void testCliff() { // This asserts that if you take two MartianCubics and cliff them, if the 4th root is negative, 
							// You will get a value of 42. If not, you should ge5t whatever the value of the cliff is
		MartianCubic Positive= new MartianCubic(new DoubleWithAppx(1), new DoubleWithAppx(1), new DoubleWithAppx(1), new DoubleWithAppx(2));
		MartianCubic Negative= new MartianCubic(new DoubleWithAppx(-1), new DoubleWithAppx(-3), new DoubleWithAppx(-7), new DoubleWithAppx(-9));
		assertTrue (!(Positive.cliff().equals(new DoubleWithAppx(42))));
		assertTrue(Negative.cliff().equals(new DoubleWithAppx (42)));
	}

	@Test
	public void testCompareTo() { // takes the two MartianCubics and compares them to get a value
								// of either -1, 0, or 1. If not, the J unit fails
		MartianCubic cliffer= new MartianCubic(new DoubleWithAppx(1), new DoubleWithAppx(1), new DoubleWithAppx(1), new DoubleWithAppx(2));
		MartianCubic Polyer= new MartianCubic(new DoubleWithAppx(1), new DoubleWithAppx(1), new DoubleWithAppx(1), new DoubleWithAppx(2));
		assertTrue(cliffer.compareTo(Polyer) == 0);
		MartianCubic CliffTwo= new MartianCubic(new DoubleWithAppx(2), new DoubleWithAppx(3), new DoubleWithAppx(4), new DoubleWithAppx(5));
		MartianCubic PolyerTwo= new MartianCubic(new DoubleWithAppx(1), new DoubleWithAppx(1), new DoubleWithAppx(1), new DoubleWithAppx(2));
		assertTrue(CliffTwo.compareTo(PolyerTwo) == 1);
		assertTrue(PolyerTwo.compareTo(CliffTwo) == -1);
	}

	
}
