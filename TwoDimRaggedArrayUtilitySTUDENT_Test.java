
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	// STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSet1 = { { 5, 3, 4 }, { 9, 8 }, { 3, 5, 4 } };
	private double[][] dataSet2 = { { -3, -4, 6 }, { 4, 5 }, { -2, 5, 8 } };
	private double[][] dataSet3 = { { 14.2, 23.4, -9.0 }, { 8.8, 49.8, 33.5 }, { -33.3, 56.4 }, { 67.3 } };

	private File inputFile, outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSet1 = dataSet2 = dataSet3 = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method Return the total of all the elements in the two
	 * dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(41, TwoDimRaggedArrayUtility.getTotal(dataSet1), .001);
		assertEquals(19, TwoDimRaggedArrayUtility.getTotal(dataSet2), .001);
		assertEquals(211.1, TwoDimRaggedArrayUtility.getTotal(dataSet3), .001);
		// fail("Student testGetTotal not implemented");
	}

	/**
	 * Student Test getAverage method Return the average of all the elements in the
	 * two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(5.125, TwoDimRaggedArrayUtility.getAverage(dataSet1), .001);
		assertEquals(2.375, TwoDimRaggedArrayUtility.getAverage(dataSet2), .001);
		assertEquals(23.456, TwoDimRaggedArrayUtility.getAverage(dataSet3), .001);
		// fail("Student testGetAverage not implemented");
	}

	/**
	 * Student Test getRowTotal method Return the total of all the elements of the
	 * row. Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(17, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), .001);
		assertEquals(12, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 2), .001);
		assertEquals(-1, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 0), .001);
		assertEquals(11, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 2), .001);
		assertEquals(92.1, TwoDimRaggedArrayUtility.getRowTotal(dataSet3, 1), .001);
		assertEquals(67.3, TwoDimRaggedArrayUtility.getRowTotal(dataSet3, 3), .001);
		// fail("Student testGetRowTotal not implemented");
	}

	/**
	 * Student Test getColumnTotal method Return the total of all the elements in
	 * the column. If a row in the two dimensional array doesn't have this column
	 * index, it is not an error, it doesn't participate in this method. Column 0
	 * refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(17, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), .001);
		assertEquals(16, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1), .001);
		assertEquals(14, TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 2), .001);
		assertEquals(-1, TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 0), .001);
		assertEquals(129.6, TwoDimRaggedArrayUtility.getColumnTotal(dataSet3, 1), .001);
		assertEquals(0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet3, 3), .001);

		// fail("Student testGetColumnTotal not implemented");
	}

	/**
	 * Student Test getHighestInArray method Return the largest of all the elements
	 * in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), .001);
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet2), .001);
		assertEquals(67.3, TwoDimRaggedArrayUtility.getHighestInArray(dataSet3), .001);
		// fail("Student testGetHighestInArray not implemented");
	}

	/**
	 * Test the writeToFile method write the array to the outputFile File then read
	 * it back to make sure formatted correctly to read
	 * 
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array = null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSet3, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(14.2, array[0][0], .001);
		assertEquals(23.4, array[0][1], .001);
		assertEquals(-9.0, array[0][2], .001);
		assertEquals(8.8, array[1][0], .001);
		assertEquals(49.8, array[1][1], .001);
		assertEquals(-33.3, array[2][0], .001);
		assertEquals(56.4, array[2][1], .001);
		// fail("Student testWriteToFile not implemented");
	}

	/**
	 * Test getHighestInRow method Returns the largest of all the elements in the
	 * row. Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRow() {
		assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), .001);
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 2), .001);
		assertEquals(49.8, TwoDimRaggedArrayUtility.getHighestInRow(dataSet3, 1), .001);
		// fail("Not yet implemented");
	}

	/**
	 * Test getHighestInRowIndex method Returns the index of the largest of all the
	 * elements in the row. Row 0 refers to the first row in the two dimensional
	 * array
	 */
	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 2));
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet3, 1));
	}

	/**
	 * Test getLowestInRowIndex method Returns the index of the smallest of all the
	 * elements in the row. Row 0 refers to the first row in the two dimensional
	 * array
	 */
	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2, 2));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet3, 1));
	}

	/**
	 * Test getLowestInRow method Returns the smallest of all the elements in the
	 * row. Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetLowestInRow() {
		assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2), .001);
		assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 1), .001);
		assertEquals(-9.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet3, 0), .001);
		// fail("Not yet implemented");
	}

	/**
	 * Test getHighestInColumn method Returns the largest of all the elements in the
	 * column. If a row in the two dimensional array doesn't have this column index,
	 * it is not an error, it doesn't participate in this method. Column 0 refers to
	 * the first column in the two dimensional array
	 */
	@Test
	public void testGetHighestInColumn() {
		assertEquals(4.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2), .001);
		assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 1), .001);
		assertEquals(67.3, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet3, 0), .001);
		// fail("Not yet implemented");
	}

	/**
	 * Test getHighestInColumn method Returns the index of the largest of all the
	 * elements in the column. If a row in the two dimensional array doesn't have
	 * this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2));
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 1));
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet3, 0));
		// fail("Not yet implemented");
	}

	/**
	 * Test getLowestInColumn method Returns the smallest of all the elements in the
	 * column. If a row in the two dimensional array doesn't have this column index,
	 * it is not an error, it doesn't participate in this method. Column 0 refers to
	 * the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumn() {
		assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1), .001);
		assertEquals(6.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 2), .001);
		assertEquals(-33.3, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet3, 0), .001);
		// fail("Not yet implemented");
	}

	/**
	 * Test getLowestInColumnIndex method Returns the index of the smallest of all
	 * the elements in the column. If a row in the two dimensional array doesn't
	 * have this column index, it is not an error, it doesn't participate in this
	 * method. Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 2));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet3, 0));
		// fail("Not yet implemented");
	}

}
