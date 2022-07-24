
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusSTUDENT_Test {

	private double[][] dataSet1 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
	private double[][] dataSet2 = { { 5, 4.5, 4, 6.6 }, { 9.9, 4.1, 4, 8 }, { 6, 65.2, 4.9, 7, 7 } };
	private double[][] dataSet3 = { { 4.5, 5.7, 3.8, 7.4 }, { 9.6 }, { 8.4, 2.7, 3.7 }, { 5.6, 6.7, 2.3, 2.3 } };

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test calculateHolidayBonus method with a high of 5000, low of 1000 and 2000
	 * as other
	 */

	@Test
	public void testCalculateHolidayBonusA() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1, 5000, 1000, 2000);
			assertEquals(3000.0, result[0], .001);
			assertEquals(4000.0, result[1], .001);

			result = HolidayBonus.calculateHolidayBonus(dataSet2, 5000, 1000, 2000);
			assertEquals(5000.0, result[0], .001);

			result = HolidayBonus.calculateHolidayBonus(dataSet3, 5000, 1000, 2000);
			assertEquals(13000.0, result[0], .001);

		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	/**
	 * Test calculateHolidayBonus method with a high of 1000, low of 250 and 500 as
	 * other
	 */

	@Test
	public void testCalculateHolidayBonusB() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1, 1000, 250, 500);
			assertEquals(750.0, result[0], .001);
			assertEquals(1000.0, result[1], .001);

			result = HolidayBonus.calculateHolidayBonus(dataSet2, 1000, 250, 500);
			assertEquals(1250.0, result[0], .001);

			result = HolidayBonus.calculateHolidayBonus(dataSet3, 1000, 250, 500);
			assertEquals(2750.0, result[0], .001);
			assertEquals(1000.0, result[1], .001);

		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	/**
	 * Test calculateTotalHolidayBonus method with a high of 5000, low of 1000 and
	 * 2000 as other
	 */
	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1, 5000, 1000, 2000), .001);
		assertEquals(37000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2, 5000, 1000, 2000), .001);
		assertEquals(32000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet3, 5000, 1000, 2000), .001);

	}

	/**
	 * Test calculateTotalHolidayBonus method with a high of 1000, low of 250 and
	 * 500 as other
	 */
	@Test
	public void testCalculateTotalHolidayBonusB() {
		assertEquals(4750.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1, 1000, 250, 500), .001);
		assertEquals(8000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2, 1000, 250, 500), .001);
		assertEquals(7000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet3, 1000, 250, 500), .001);

	}

}
