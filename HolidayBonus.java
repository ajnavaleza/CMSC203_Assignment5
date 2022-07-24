
public class HolidayBonus {

	/**
	 * Calculates the holiday bonus for each store
	 * 
	 * @param data  the two dimensional array of store sales
	 * @param high  bonus for the highest store in a category
	 * @param low   bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double bonus[] = new double[data.length];

		// find the max # of categories
		int maxCat = 0;
		for (int i = 0; i < data.length; i++) {
			if (maxCat < data[i].length) {
				maxCat = data[i].length;
			}
		}

		for (int j = 0; j < maxCat; j++) {
			// add bonus for high or low in each category
			int highBonusIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
			int lowBonusIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);

			// sales must be positive to get high bonus
			if (TwoDimRaggedArrayUtility.getHighestInColumn(data, j) > 0) {
				bonus[highBonusIndex] += high;
			}

			// sales have to be positive and have to be different from high to get low bonus
			if (TwoDimRaggedArrayUtility.getLowestInColumn(data, j) > 0 && highBonusIndex != lowBonusIndex) {
				bonus[lowBonusIndex] += low;
			}

			// add OTHER bonus to the other stores unless not category available if sales
			// are positive
			// add the other bonues to other stores unless category available
			for (int i = 0; i < data.length; i++) {
				if (j >= data[i].length || i == highBonusIndex || i == lowBonusIndex || data[i][j] <= 0) {
					continue;
				} else {
					bonus[i] += other;
				}
				System.out.println();
			}

		}
		return bonus;
	}

	/**
	 * Calculates the total holiday bonuses
	 * 
	 * @param data  the two dimensional array of store sales
	 * @param high  bonus for the highest store in a category
	 * @param low   bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double total = 0;
		double[] bonusArray = calculateHolidayBonus(data, high, low, other);

		for (int i = 0; i < bonusArray.length; i++) {
			total += bonusArray[i];
		}
		return total;
	}
}
