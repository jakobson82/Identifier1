import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IdentifierMainTest {
	
	static private ByteArrayOutputStream baOut;
	static private PrintStream psOut;
	
	@BeforeClass
	public static void beforClassInit() {
		baOut = new ByteArrayOutputStream();
		psOut = new PrintStream(baOut);
		System.setOut(psOut);
	}
	
	@AfterClass
	public static void afterClassFinalize() {
		psOut.close();
	}
	
	@Before
	public void stUp() {
		baOut.reset();
	}
	
	@Test
	public void testevalido01() {
		IdentifierMain.main(new String [] {"a1"});
		String output = baOut.toString();
		
		assertEquals("Valido", output);
	}
	
	@Test
	public void testevalido02() {
		IdentifierMain.main(new String [] {"2b3"});
		String output = baOut.toString();
		assertEquals("Invalido", output);
	}
	
	@Test
	public void testevalido03() {
		IdentifierMain.main(new String [] {"a1b2c3d"});
		String output = baOut.toString();
		
		assertEquals("Invalido", output);
	}
}


