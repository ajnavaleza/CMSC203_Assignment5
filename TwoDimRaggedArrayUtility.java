import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * default constructor
 * 
 * @author angelonavaleza
 * 
 */
public class TwoDimRaggedArrayUtility {

	/**
	 * Returns the average of the elements in the two dimensional array
	 * 
	 * @param data the array that is being averaged
	 * @return the average of the array
	 */
	public static double getAverage(double[][] data) {
		int elements = 0;
		double sum = 0;

		for (int i = 0; i < data.length; i++) {
			elements += data[i].length;

			for (int j = 0; j < data[i].length; j++) {
				sum += data[i][j];
			}
		}
		return sum / elements;
	}

	/**
	 * Returns the total of the selected column in the two dimensional array index 0
	 * refers to the first column. If a row in the two dimensional array doesn't
	 * have this column index, it is not an error, it doesn't participate in this
	 * method.
	 * 
	 * @param data the data of the two dimensional array
	 * @param col  the columns in the array
	 * @return
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double columnTotal = 0;

		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length) {
				continue;
			}
			columnTotal += data[i][col];
		}
		return columnTotal;
	}

	/**
	 * Returns the largest element in the two dimensional array
	 * 
	 * @param data the two dimensional array
	 * @return the highest element in the array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = 0;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				double value = data[i][j];

				if (value > highest) {
					highest = value;
				}
			}
		}
		return highest;
	}

	/**
	 * Returns the largest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 * 
	 * @param data the two dimensional array
	 * @param col  the index of the column that is used to find the highest element
	 *             (0 refers to the first column) of
	 * @return the highest element in that column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = 0;

		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length) {
				continue;
			}

			if (data[i][col] >= highest) {
				highest = data[i][col];
			}
		}
		return highest;
	}

	/**
	 * Returns index of the largest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 * 
	 * @param data the two dimensional array
	 * @param col  the column index to find the largest element of (0 refers to the
	 *             first column)
	 * @return the index of the largest element of the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = 0;
		int index = -1;

		for (int i = 0; i < data.length; i++) {
			if (data[i].length <= col || col < 0) {
				continue;
			}

			if (data[i][col] > highest) {
				highest = data[i][col];
				index = i;
			}
		}
		return index;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data the two dimensional array
	 * @param row  the row index to find the largest element of (0 refers to the
	 *             first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = 0;

		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > highest) {
				highest = data[row][i];
			}
		}
		return highest;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = 0;
		int index = -1;

		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > highest) {
				highest = data[row][i];
				index = i;
			}
		}
		return index;
	}

	/**
	 * Returns the smallest element in the two dimensional array
	 * 
	 * @param data the two dimensional array
	 * @return the smallest element in the two dimensional array
	 * 
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = 999999;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {

				if (data[i][j] < lowest) {
					lowest = data[i][j];
				}
			}
		}
		return lowest;
	}

	/**
	 * Returns the smallest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 * 
	 * @param data the two dimensional array
	 * @param col  the column index to find the smallest element of (0 refers to the
	 *             first column)
	 * @return the smallest element of the column
	 * 
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = 999999;

		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length) {
				continue;
			}

			if (data[i][col] < lowest) {
				lowest = data[i][col];
			}
		}
		return lowest;
	}

	/**
	 * Returns the index of the smallest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 * 
	 * @param data the two dimensional array
	 * @param col  the column index to find the smallest element of (0 refers to the
	 *             first column)
	 * @return the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = 999999;
		int index = 0;

		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length) {
				continue;
			}

			if (data[i][col] < lowest) {
				lowest = data[i][col];
				index = i;
			}
		}
		return index;
	}

	/**
	 * Returns the smallest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data the two dimensional array
	 * @param row  the row index to find the smallest element of (0 refers to the
	 *             first row)
	 * @return the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = 999999;

		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}
		return lowest;
	}

	/**
	 * Returns the index of the smallest element of the selected row in the two
	 * dimensional array index 0 refers to the first row.
	 * 
	 * @param data the two dimensional array
	 * @param row  the row index to find the smallest element of (0 refers to the
	 *             first row)
	 * @return the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = 999999;
		int index = 0;

		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
				index = i;
			}
		}
		return index;
	}

	/**
	 * Returns the total of the selected row in the two dimensional array index 0
	 * refers to the first row.
	 * 
	 * @param data the two dimensional array
	 * @param row  the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0;

		for (int i = 0; i < data[row].length; i++) {
			rowTotal += data[row][i];
		}
		return rowTotal;
	}

	/**
	 * Returns the total of all the elements of the two dimensional array
	 * 
	 * @param data the two dimensional array getting total of
	 * @return the sum of all the elements in the two dimensional array
	 */
	public static double getTotal(double[][] data) {
		double total = 0;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
			}
		}
		return total;
	}

	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is
	 * 10 and the maximum columns for each row is 10 Each row in the file is
	 * separated by a new line Each element in the row is separated by a space
	 * Suggestion: You need to know how many rows and how many columns there are for
	 * each row to create a ragged array. 1. Read the doubles from the file into an
	 * a temporary array [10][10] of Strings which was initialized to nulls. 2. Find
	 * out how many rows there are (any row that has the first element != null is a
	 * valid row) 3. Create the array based on the num of rows, i.e. double[][]array
	 * = new double[#rows][] 4. Determine the number of columns for the first row
	 * (any element != null is a valid element) 5. Create the first row, i.e.
	 * array[0] = new double[#columns] 6. Put the values from the temporary array
	 * into in the row (don't forget to convert from strings to doubles) 7. Repeat
	 * for all rows
	 * 
	 * @param file the file to read from
	 * @return a two dimensional ragged (depending on data) array of doubles if the
	 *         file is not empty, returns a null if file is empty
	 * @throws java.io.FileNotFoundException if file is not valid
	 */
	public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException {
		Scanner sc = new Scanner(file);
		int rowIndex = 0;
		String[][] tempArray = new String[10][10];

		// Check how many rows
		while (sc.hasNextLine()) {
			String[] row = sc.nextLine().split(" ");
			tempArray[rowIndex] = new String[row.length];
			for (int i = 0; i < row.length; i++) {
				tempArray[rowIndex][i] = row[i];
			}
			rowIndex++;
		}
		// Create double data array and parse numbers as doubles
		double[][] data = new double[rowIndex][];
		for (int i = 0; i < rowIndex; i++) {
			data[i] = new double[tempArray[i].length];
			for (int j = 0; j < tempArray[i].length; j++) {
				System.out.print(tempArray[i][j] + " ");
				data[i][j] = Double.parseDouble(tempArray[i][j]);
			}
			System.out.println();
		}

		sc.close();
		return data;
	}

	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate
	 * line within the file and each double is separated by a space.
	 * 
	 * @param data       two dimensional ragged array of doubles
	 * @param outputFile the file to write to
	 * @throws FileNotFoundException if outputFile is not valid
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		PrintWriter output = new PrintWriter(outputFile);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sb.append(data[i][j] + " ");
			}
			sb.append("\n");
		}
		output.print(sb.toString());
		output.close();
	}
}
