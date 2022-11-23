import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

@RunWith(Parameterized.class)
public class SudokuVerifierParameterizedTest {
	//Voluntary - implement tests as Parameterized tests:
	
	//text tutorial: https://www.tutorialspoint.com/junit/junit_parameterized_test.htm
	//video tutorial: https://www.youtube.com/watch?v=ryBetrexwt4
	
	
	//implement and document tests to test Sudokuverifier with boundary values. Use templates from Task 1 to derive and document test cases.
	
	// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
	// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	
	private SudokuVerifier verifier = new SudokuVerifier();
	private String testString;
	private String testName;
	private int expectedResult;
	
	
	//collection of test data with inputs (testString) and expected results
	@Parameters(name = "{index}: {0}")
	   public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][] {
	         { "valid", "417369825632158947958724316825437169791586432346912758289643571573291684164875293", 0},
	         { "invalid", "123456789912345678891234567789123456678912345567891234456789123345678912234567891", -2},
	         { "short", "41736982563215894795872431682543716979158643234691275828964357157329168416487529", -1},
	         { "long", "4173698256321589479587243168254371697915864323469127582896435715732916841648752931", -1},
	         { "char", "4173698256321589479587243168254371a9791586432346912758289643571573291684164875293", 1},
	         { "sp.char", "{int a = v.verify(c)}724316825437159791586432346912758289643571573291684164875293", 1},
	         { "zero", "417369825632158947958724316825437169790586432346912758289643571573291684164875293", -1},
	         { "rowtest", "123456789456789123789123456234567891567891234891234567345912678678345345912678912", -3},
	         { "coltest", "123456789456789123789123456234567891567891234891234567435912678768345912192678345", -4}
	      });
	   }
	
	//test class constructor
	public SudokuVerifierParameterizedTest(String testName, String testString, int expectedResult) {
	    this.testName = testName;  
		this.testString = testString;
	    this.expectedResult = expectedResult;
	   }
	
	
	@Test
	public void returnCorrect() {
		int returnNumber = verifier.verify(testString);
		assertEquals(returnNumber, expectedResult);
	}

}
