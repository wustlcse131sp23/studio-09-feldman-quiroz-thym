package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
	private String FirstName;
	private String LastName;
	private int StudentIDNumber;
	private int AttemptedCredits;
	private int PassingCredits;
	private double TotalGradeQualityPoints;
	private double BearBucksBalance;

	public Student(String FirstName, String LastName, int StudentIDNumber) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.StudentIDNumber = StudentIDNumber;
	}
	/**
	 * This  gets students last name
	 * @return will return students last name
	 */
	public String lastName() {
		return this.LastName;
	}
	/**
	 * Gets Students gull name
	 * @return returns a student's first name and last name and has a space in between
	 */
	public String getFullName() {

		return this.FirstName + " " + this.LastName;
	}
	/**
	 * Gets ID number
	 * @return returns the Students Student ID Number
	 */

	public int getId() {
		return this.StudentIDNumber;
	}

	public Student(int StudentIdNumber, int AttemptedCredits, int PassingCredits) {
		this.AttemptedCredits = AttemptedCredits;
		this.PassingCredits = PassingCredits;
		this.TotalGradeQualityPoints = TotalGradeQualityPoints;
	}
/**
 * Updateds the students GPA by looking at their particle grades by updated the TotalGradeQualityPoints. By updating the program can find out how many passing grades one has.
 * @param grade This takes in a course Grade only o a scale from 0 to 4
 * @param credits This takes in the number of credits each student is taking depending on the number of courses. 
 */
	public void submitGrade(double grade, int credits) {
		this.TotalGradeQualityPoints += (grade * credits);
		if (grade >= 1.7) {
			this.AttemptedCredits += credits;
			this.PassingCredits += credits;
		} else {
			this.AttemptedCredits += credits;
		}

	}
/** This calculates a students grade point average using the new updated values found above
 * @returns returns the students calculated GPA
 * 
 */
	public double calculateGradePointAverage() {
		return this.TotalGradeQualityPoints / this.AttemptedCredits;
	}
/**
 * This gets the students current class standing by looking at the total number of credits taken
 * @return returns depending on a students number of credits what year they are supposed to be in school 
 */
	public String getClassStanding() {
		if (this.PassingCredits < 30) {
			return "First Year";
		} else if ((this.PassingCredits >= 30) && (this.PassingCredits < 60)) {
			return "Sophomore";

		} else if ((this.PassingCredits >= 60) && (this.PassingCredits < 90)) {
			return "Junior";

		} else {
			return "Senior";
		}

	}
	/**
	 * looks if a student is eligible to be part of Phi Beta Kappa depending on the calculated GPA and number of passing credits
	 * @return returns your eligibility status at Phi Beta Kappa
	 */

	public boolean isEligibleForPhiBetaKappa() {
		if (this.PassingCredits >= 98 && calculateGradePointAverage() >= 3.60) {
			return true;
		} else if (this.PassingCredits >= 75 && calculateGradePointAverage() >= 3.80) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * This will look at the amount of Bear Bucks deposited, by changing the amount added in the account
	 * @param amount looks at the new amount of money in your Bear Bucks account
	 */
	
	public void depositBearBucks(double amount) {
		this.BearBucksBalance += amount;
	}
	/**
	 * This will look at the amount of Bear Bucks deducted, by changing the amount added in the account
	 * @param amount looks at the new amount of money in your Bear Bucks account
	 */
	
	public void deductBearBucks(double amount) {
		this.BearBucksBalance -= amount;
	}
/**
 * gets the number of Bear Bucks in an account
 * @return returns your current Bear Bucks Balance
 */
	public double getBearBucksBalance() {
		return this.BearBucksBalance;
	}
	/**
	 * Will get the number of Bear Bucks in your account when cashing out. Will not let you cash our when one has less than 10 Bear Bucks in the account 
	 * @return returns the the amount of Bear Bucks that have been cashed out of the account plus the 10 dollar deduction
	 */

	public double cashOutBearBucks() {
		double amount = this.BearBucksBalance;
		this.BearBucksBalance = 0.0;
		if (amount < 10.0) {
			return 0.0;
		} else {
			return amount - 10.0;
		}
	}
/**
 * will get the students Parents Alum Bear Bucks to transfer 
 * @param firstName finds the firstName of the students parent
 * @param otherParent finds the lastName of the other parent who does not have the current students last name
 * @param isHyphenated will see if the last name is hyphenated or not
 * @param id will get the parents Alum Id
 * @return returns all the information of the legacy student
 */

	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		if (isHyphenated) {
			String legacyLastName = this.LastName + "-" + otherParent.LastName;
			Student child = new Student(firstName, legacyLastName, id);
			child.depositBearBucks(cashOutBearBucks() + otherParent.cashOutBearBucks());
			return child;
		} else {
			Student child = new Student(firstName, this.LastName, id);
			child.depositBearBucks(cashOutBearBucks() + otherParent.cashOutBearBucks());
			return child;
		}
	}
	/**
	 * @return this returns the students full name as well as the Id number found on their Id card
	 */
	public String toString() {
		return getFullName() + getId();
	}

}
