import static org.junit.Assert.*;
import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
String shortInput = "41736982563215894795872431682543716979158643234691275828964357157329168416487529";
String longInput = "4173698256321589479587243168254371697915864323469127582896435715732916841648752931";
String hasChar = "4173698256321589479587243168254371a9791586432346912758289643571573291684164875293";
String hasSpecialChar = "{int a = v.verify(c)}724316825437159791586432346912758289643571573291684164875293";
String hasZero = "417369825632158947958724316825437169790586432346912758289643571573291684164875293";
// I made a valid Sudoku grid and altered it to get both row and column errors
String rowtest = "123456789456789123789123456234567891567891234891234567345912678678345345912678912";
String coltest = "123456789456789123789123456234567891567891234891234567435912678768345912192678345";

SudokuVerifier v = new SudokuVerifier();

	@Test
	public void TC1testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void TC2testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
		
	}
	
	@Test
	public void TC3testShortInput() {
		int a = v.verify(shortInput);
		assertEquals("short string", a, -1);
	}
	
	@Test
	public void TC4testLongInput() {
		int a = v.verify(longInput);
		assertEquals("long string", a, -1);
	}
	
	@Test
	public void TC5testInputHasNonnumericChar() throws NumberFormatException {
		
		int a = v.verify(hasChar);
		assertEquals("non-numeric string", a, 1);    
	}
	
	@Test
	public void TC6testInputHasSpecialChar() throws NumberFormatException {
		int a = v.verify(hasSpecialChar);
		assertEquals("non-numeric special char string", a, 1);
	}
	
	@Test
	public void TC7testInputHasZero() {
		int a = v.verify(hasZero);
		assertEquals("has zero string", a, -1);
	}
	
	@Test
	public void TC8testRowCheckIsCorrect() {
		int a = v.verify(rowtest);
		assertEquals("one row is incorrect", a, -3);
	}
	
	@Test
	public void TC9testColumnCheckIsCorrect() {
		int a = v.verify(coltest);
		assertEquals("one column is incorrect", a, -4);
	}
	
}
