/*This program creates a gradebook AND an attendance system that a teacher can use to view and alter students' grades and attendance*/

package myPackage;

import java.util.Scanner;
//import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//create a student class
class Student {
	// attributes
	String name;
	int numTardies;
	int numAbsenses;
	double grade;
	String letterGrade;
	int ID;
	static int lastAssignedId = 0;

	// create attendance table
	String[][] attendanceT = new String[6][5];
	/*
	 * Key for attendance table P-present A-absent T-tardy
	 */
	// create grade table
	double[][] gradeT = new double[5][2];

	// constructor
	public Student(String studentName) {
		// give each student object a name
		name = studentName;
		// default of grade table is 0.0
		for (int x = 0; x < gradeT.length; x++) {

			for (int y = 0; y < gradeT[x].length; y++) {

				gradeT[x][y] = 0.0;
			}
		}
		// default of attendance table is P(present)
		for (int x = 0; x < attendanceT.length; x++) {

			for (int y = 0; y < attendanceT[x].length; y++) {

				attendanceT[x][y] = "P";
			}
		}
		// gives an ID to each student using a static keyword so it is shared by all
		// objects
		ID = ++lastAssignedId;

	}

	// create a method that calculates averageGrade for the student database
	public void averageGrade() {
		double countGrade = 0.0;
		double average = 0.0;
		double sum = 0.0;
		String letter = "A";
		for (int x = 0; x < gradeT.length; x++) {// row

			for (int y = 0; y < gradeT[x].length; y++) {// column

				sum += gradeT[x][y];
				if (gradeT[x][y] != 0.0) {
					countGrade++;
				}
			}
		} // need a countGrade that is edit something new implement(solves 0)
		average = sum / countGrade;
		if (countGrade == 0.0) {// if there are no assignments then the student has a 100%
			average = 100;
			letter = "A";

		} else {
			if (average >= 90) {
				letter = "A";
			} else if (average >= 80) {
				letter = "B";
			} else if (average >= 70) {
				letter = "C";
			} else if (average >= 60) {
				letter = "D";
			} else {
				letter = "F";
			}
		}

		letterGrade = letter;
		grade = average;

	}

	// create a method that calculates # of absences for the student database
	public void numberOfAbsences() {
		int count = 0;
		for (int x = 0; x < attendanceT.length; x++) {

			for (int y = 0; y < attendanceT[x].length; y++) {

				if (attendanceT[x][y] == "A") {
					count++;
				}
			}
		}
		numAbsenses = count;
	}

	// create a method that calculates number of tardies for the student database
	public void numberOfTardies() {
		int count = 0;
		for (int x = 0; x < attendanceT.length; x++) {

			for (int y = 0; y < attendanceT[x].length; y++) {

				if (attendanceT[x][y] == "T") {
					count++;
				}
			}
		}
		numTardies = count;
	}
}

//create another class to hold the methods(not for the student Database)
class StudentMaintenance {

	// store the student objects in an array list
	static ArrayList<Student> studentList = new ArrayList<Student>();
	// store names in an array
	static String[] names = { "Nivedha", "Ramya", "Laksha", "Sid", "Shreyas", "Madhu", "Arun", "Akshat", "Christy",
			"Anika", "Farhan", "Michael", "Rathul", "Rohit", "Philip", "Ifran", "Sharan", "Thomas" };
	// create a student database
	static String[][] studentDB = new String[18][6];

	// create student objects
	public static void addStudent() {
		// create student object and store it in Arraylist
		for (int i = 0; i < 18; i++) {
			Student student = new Student(names[i]);
			// add to array list
			studentList.add(student);
		}
	}

	// print important info in a table before going into grades or attendance
	public static void printDatabase() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("c:/Users/toniv/Desktop/yay.txt"));
		System.out.println("");
		String fileFormat2 = String.format("%-11s%-17s%-15s%-15s%-15s%-10s", "NAME", "STUDENT ID", "GRADE",
				"PERCENTAGE", "ABSENCES", "TARDIES");
		writer.write(fileFormat2);
		writer.newLine();
		System.out.format("%-11s%-17s%-15s%-15s%-15s%-10s", "NAME", "STUDENT ID", "GRADE", "PERCENTAGE", "ABSENCES",
				"TARDIES");
		System.out.println("\n");
		for (int i = 0; i < 18; i++) {

			Student tempStudent = studentList.get(i);
			tempStudent.averageGrade();
			tempStudent.numberOfAbsences();
			tempStudent.numberOfTardies();
			studentDB[i][0] = tempStudent.name;
			studentDB[i][1] = Integer.toString(tempStudent.ID);
			studentDB[i][2] = tempStudent.letterGrade;
			studentDB[i][3] = Double.toString(tempStudent.grade);
			studentDB[i][4] = Integer.toString(tempStudent.numAbsenses);
			studentDB[i][5] = Integer.toString(tempStudent.numTardies);
		}

		for (int x = 0; x < studentDB.length; x++) {

			for (int y = 0; y < studentDB[x].length; y++) {

				System.out.format("%-15s", studentDB[x][y]);
				String fileFormat = String.format("%-15s", studentDB[x][y]);
				writer.write(fileFormat);

			}
			// String fileFormat2 = "\n";
			writer.newLine();
			System.out.print("\n");
		}
		System.out.println("");
		writer.close();

	}

	// changes an index of the attendance array
	public static void editAttendance(String attendance, int studentID, int week, int day) {
		for (int i = 0; i < 18; i++) {
			Student tempStudent = studentList.get(i);
			if (tempStudent.ID == studentID) {
				tempStudent.attendanceT[week][day] = attendance;
				studentList.set(i, tempStudent);
				break;
			}
			// viewAttendance(studentID);
		}

	}

	// displays attendance table
	public static void viewAttendance(int studentID) {
		int temp = 0;
		for (int i = 0; i < 18; i++) {
			Student tempStudent = studentList.get(i);
			if (tempStudent.ID == studentID) {
				System.out.println(tempStudent.name + ":");
				StudentMaintenance.numA(studentID);
				StudentMaintenance.numT(studentID);
				System.out.println("ID: " + tempStudent.ID + "\n");
				System.out.println("\t      Monday         Tuesday        Wednesday        Thursday        Friday");
				for (int x = 0; x < tempStudent.attendanceT.length; x++) {// row

					temp = x + 1;
					System.out.print("Week " + temp + ":" + "\t \t");

					for (int y = 0; y < tempStudent.attendanceT[x].length; y++) {// column
						System.out.print(tempStudent.attendanceT[x][y] + "\t\t");
					}
					System.out.println();
				}
				System.out.println("\nKey: \n P-present \n A-absent \n T-tardy");
				System.out.println("");
				break;
			}

		}

	}

	// displays grades table
	public static void viewGrade(int studentID) {
		int temp = 0;
		for (int i = 0; i < 18; i++) {
			Student tempStudent = studentList.get(i);
			if (tempStudent.ID == studentID) {
				System.out.println(tempStudent.name + ":");
				avgGrade(studentID);
				System.out.println("ID: " + tempStudent.ID + "\n");
				System.out.println("\t   Assignment #1   Assignment #2");
				for (int x = 0; x < tempStudent.gradeT.length; x++) {// row

					temp = x + 1;
					System.out.print("Day " + temp + ":" + "\t \t");

					for (int y = 0; y < tempStudent.gradeT[x].length; y++) {// column

						System.out.print(tempStudent.gradeT[x][y] + "\t\t");
					}
					System.out.println("");
				}
				System.out.println("");
				break;
			}

		}

	}

	// calculate percent for edit grade method
	public static double percentCalculated(double pointsRewarded, double pointsTotal) {
		double percentage = pointsRewarded / pointsTotal * 100;
		return percentage;
	}

	// edit an index of grade array
	public static void editGrade(int studentID, int day, int assignmentNum, double percent) {
		for (int i = 0; i < 18; i++) {
			Student tempStudent = studentList.get(i);
			if (tempStudent.ID == studentID) {
				tempStudent.gradeT[day][assignmentNum] = percent;
				studentList.set(i, tempStudent);
				break;
			}
		}
	}

	// calculates and displays grade as a letter and percent
	public static void avgGrade(int studentID) {
		double countGrade = 0.0;
		double average = 0.0;
		double sum = 0.0;
		String letter = "A";
		for (int i = 0; i < 18; i++) {
			Student tempStudent = studentList.get(i);
			if (tempStudent.ID == studentID) {
				for (int x = 0; x < tempStudent.gradeT.length; x++) {// row

					for (int y = 0; y < tempStudent.gradeT[x].length; y++) {// column

						sum += tempStudent.gradeT[x][y];
						if (tempStudent.gradeT[x][y] != 0.0) {
							countGrade++;
						}
					}
				} // need a countrGrade that is edit something new implement(solves 0)
				average = sum / countGrade;
				if (countGrade == 0.0) {
					average = 100;
					letter = "A";
					System.out.println("Grade: 100%  A");

				} else {
					if (average >= 90) {
						letter = "A";
					} else if (average >= 80) {
						letter = "B";
					} else if (average >= 70) {
						letter = "C";
					} else if (average >= 60) {
						letter = "D";
					} else {
						letter = "F";
					}
					System.out.println("Grade: " + average + "%  " + letter);
				}
				tempStudent.letterGrade = letter;
				tempStudent.grade = average;
				studentList.set(i, tempStudent);
				break;
			}
		}
	}

	// calculates and displays number of absences
	public static void numA(int studentID) {
		int count = 0;
		for (int i = 0; i < 18; i++) {
			Student tempStudent = studentList.get(i);
			if (tempStudent.ID == studentID) {
				for (int x = 0; x < tempStudent.attendanceT.length; x++) {

					for (int y = 0; y < tempStudent.attendanceT[x].length; y++) {

						if (tempStudent.attendanceT[x][y] == "A") {
							count++;
						}
					}
				}
				System.out.println("Number of absenses: " + count);
				tempStudent.numAbsenses = count;
				studentList.set(i, tempStudent);
				break;
			}
		}
	}

	// calculates and displays number of tardies
	public static void numT(int studentID) {
		int count = 0;
		for (int i = 0; i < 18; i++) {
			Student tempStudent = studentList.get(i);
			if (tempStudent.ID == studentID) {
				for (int x = 0; x < tempStudent.attendanceT.length; x++) {

					for (int y = 0; y < tempStudent.attendanceT[x].length; y++) {

						if (tempStudent.attendanceT[x][y] == "T") {
							count++;
						}
					}
				}
				System.out.println("Number of tardies: " + count);
				tempStudent.numTardies = count;
				studentList.set(i, tempStudent);
				break;
			}
		}
	}

}

public class Grade_AttendanceSystem {
	public static void main(String args[]) throws IOException {
		// displays image below at start of program

		System.out.println("                                              ___________________            ");
		System.out.println("                                             |_______     _______|      ");
		System.out.println("                                                     |   |          ");
		System.out.println("                                                 QL  |   | eacher         ");
		System.out.println("                                           --------------------------");
		System.out.println("                                           Quarry Lane Teacher Portal");
		System.out.println("                                           --------------------------");
		System.out.println("                                                     |___|         ");

		// create students
		StudentMaintenance.addStudent();

		// welcome teacher user
		Scanner name = new Scanner(System.in);
		System.out.println("What is your name?");
		String teacherName = name.nextLine();

		System.out.println("Hi " + teacherName + "!");
		System.out.println(
				"Welcome to the Quarry Lane Teacher Portal! This portal allows you to access the GradeBook and Attendance System!");

		StudentMaintenance.printDatabase();

		boolean moreTime = true;
		while (moreTime) {

			boolean loop = true;
			String type = "";
			while (loop) {

				Scanner decision = new Scanner(System.in);
				System.out.println("Which database do you want to access: grades or attendance?");
				type = decision.nextLine();
				// decision.close();

				if (!(type.equalsIgnoreCase("attendance")) && !(type.equalsIgnoreCase("grades"))) {
					System.out.println("Invalid answer. Try again.");
					loop = true;
				} else {
					loop = false;
				}
			}

			String categoryA = "";
			String categoryG = "";

			boolean loopback = true;
			while (loopback) {

				if (type.equalsIgnoreCase("attendance")) {

					Scanner choice1 = new Scanner(System.in);
					System.out.println("Do you want to view or edit the attendance system? Enter view or edit.");
					categoryA = choice1.nextLine();

				} else {// grades
					Scanner choice2 = new Scanner(System.in);
					System.out.println("Do you want to view or edit grades? Enter view or edit.");
					categoryG = choice2.nextLine();
				}

				// ***EDIT ATTENDANCE***//

				if (categoryA.equalsIgnoreCase("edit")) {
					loopback = false;
					try {
						boolean loopBack = true;
						while (loopBack) {
							Scanner schoolRelative = new Scanner(System.in);
							System.out.println("Is the student present, absent, or tardy?");
							System.out.println(
									"Note: The system defaults every student to be present. Thus, you only have to change to present if they were accidently marked absent or tardy.");
							String att = schoolRelative.nextLine();

							String attendance = "";
							if (att.equalsIgnoreCase("absent")) {
								attendance = "A";
								loopBack = false;
							} else if (att.equalsIgnoreCase("tardy")) {
								attendance = "T";
								loopBack = false;
							} else if (att.equalsIgnoreCase("present")) {
								attendance = "P";
								loopBack = false;
							} else {
								System.out.println("Invalid answer. Try again.");
								continue;
							}
							boolean turnBack = true;
							while (turnBack) {
								Scanner question = new Scanner(System.in);
								System.out.println(
										"Enter the student ID(1-18), week#(1-6), and day(Monday-Friday). Enter a space bewteen the inputs.");
								System.out.println("Ex. 18  6  Friday");

								int studentID = question.nextInt();
								int week = question.nextInt();
								String dayString = question.next();
								
								if (studentID <= 18 && studentID > 0) {
									if(week <= 6 && week > 0) {
										if(dayString.equalsIgnoreCase("monday") || dayString.equalsIgnoreCase("tuesday")
										|| dayString.equalsIgnoreCase("wednesday") || dayString.equalsIgnoreCase("thursday")
										|| dayString.equalsIgnoreCase("friday")) {
											turnBack = false;
										}
									}
								}
								if (turnBack) {
									System.out.println("Invalid entry. Try again.");
									continue;
								}

								week -= 1;

								int day = 0;
								if (dayString.equalsIgnoreCase("Monday")) {
									day = 0;
								} else if (dayString.equalsIgnoreCase("Tuesday")) {
									day = 1;
								} else if (dayString.equalsIgnoreCase("Wednesday")) {
									day = 2;
								} else if (dayString.equalsIgnoreCase("Thursday")) {
									day = 3;
								} else if (dayString.equalsIgnoreCase("Friday")) {
									day = 4;
								} else {
									System.out.println("Invalid day. Try again.");
								}

								// fix code
								StudentMaintenance.editAttendance(attendance, studentID, week, day);
								System.out.println(" ");
								System.out.println("Edit made!");
								System.out.println(" ");
								StudentMaintenance.viewAttendance(studentID);
								// StudentMaintenance.printDatabase();
							} // while turnBack
						} // while loopBack
						boolean goBack2 = true;
						while (goBack2) {

							Scanner continueProgram = new Scanner(System.in);
							System.out.println("Do you want to stay in the portal? Enter yes or no.");
							String continueProg = continueProgram.nextLine();

							if (continueProg.equalsIgnoreCase("yes")) {
								moreTime = true;
								goBack2 = false;
							} else if (continueProg.equalsIgnoreCase("no")) {
								System.out.println("You are logged out of the portal.");
								moreTime = false;
								goBack2 = false;
							} else {
								System.out.println("Invalid entry. Try again.");
								goBack2 = true;
							}
						}
					} catch (Exception e) {
						System.out.println("You entered invalid data.");
						System.out.println("Starting program again...");
					}

					// ***EDIT GRADE***//

				} else if (categoryG.equalsIgnoreCase("edit")) {
					loopback = false;
					try {
						boolean goBack = true;
						while (goBack) {
							Scanner questionG = new Scanner(System.in);
							System.out.println(
									"Enter student ID, day(Monday-Friday), assignment#(1-2), points earned by student, total points.");
							System.out.println("Enter a space between each input.");
							System.out.println("Ex. 18  Friday  2  99  100");

							int studentID = questionG.nextInt();
							String dayG = questionG.next();
							int assignment = questionG.nextInt();
							double pointsGiven = questionG.nextInt();
							double pointsTotal = questionG.nextInt();

							if (studentID <= 18 && studentID > 0) {
								if (dayG.equalsIgnoreCase("monday") || dayG.equalsIgnoreCase("tuesday")
										|| dayG.equalsIgnoreCase("wednesday") || dayG.equalsIgnoreCase("thursday")
										|| dayG.equalsIgnoreCase("friday")) {
									if (assignment == 1 || assignment == 2) {
										if (pointsGiven >= 0.0 && pointsTotal > 0.0) {
											goBack = false;
										}
									}
								}
							}
							if (goBack) {
								System.out.println("Invalid entry. Try again.");
								continue;
							}

							int dayNum = 0;

							if (dayG.equalsIgnoreCase("Monday")) {
								dayNum = 0;
							} else if (dayG.equalsIgnoreCase("Tuesday")) {
								dayNum = 1;
							} else if (dayG.equalsIgnoreCase("Wednesday")) {
								dayNum = 2;
							} else if (dayG.equalsIgnoreCase("Thursday")) {
								dayNum = 3;
							} else if (dayG.equalsIgnoreCase("Friday")) {
								dayNum = 4;
							} else {
								// System.out.println("Invalid day. Try again.");
							}

							assignment -= 1;

							double percent;
							percent = StudentMaintenance.percentCalculated(pointsGiven, pointsTotal);
							StudentMaintenance.editGrade(studentID, dayNum, assignment, percent);
							System.out.println("");
							System.out.println("Edit made!");
							System.out.println("");
							StudentMaintenance.viewGrade(studentID);
							// StudentMaintenance.printDatabase();

						}

						boolean goBack2 = true;
						while (goBack2) {

							Scanner continueProgram = new Scanner(System.in);
							System.out.println("Do you want to stay in the portal? Enter yes or no.");
							String continueProg = continueProgram.nextLine();

							if (continueProg.equalsIgnoreCase("yes")) {
								moreTime = true;
								goBack2 = false;
							} else if (continueProg.equalsIgnoreCase("no")) {
								System.out.println("You are logged out of the portal.");
								moreTime = false;
								goBack2 = false;
							} else {
								System.out.println("Invalid entry. Try again.");
								goBack2 = true;
							}
						}

					} catch (Exception e) {
						System.out.println("You entered invalid data.");
						// e.printStackTrace();
						System.out.println("Starting program again...");
					}

					// ***VIEW ATTENDANCE***//

				} else if (categoryA.equalsIgnoreCase("view")) {
					loopback = false;
					try {
						boolean loopBack = true;
						while (loopBack) {
							Scanner studentNumber = new Scanner(System.in);
							System.out.println("What is the ID of the student of which you want to view attendance?");
							int studentNum = studentNumber.nextInt();
							if (studentNum <= 18 && studentNum > 0) {
								loopBack = false;
							} else {
								System.out.println("Invalid answer. Try again.");
							}

							System.out.println("");
							StudentMaintenance.viewAttendance(studentNum);
						}
						boolean goBack2 = true;
						while (goBack2) {

							Scanner continueProgram = new Scanner(System.in);
							System.out.println("Do you want to stay in the portal? Enter yes or no.");
							String continueProg = continueProgram.nextLine();

							if (continueProg.equalsIgnoreCase("yes")) {
								moreTime = true;
								goBack2 = false;
							} else if (continueProg.equalsIgnoreCase("no")) {
								System.out.println("You are logged out of the portal.");
								moreTime = false;
								goBack2 = false;
							} else {
								System.out.println("Invalid entry. Try again.");
								goBack2 = true;
							}
						}
					} catch (Exception e) {
						System.out.println("You entered invalid data.");
						System.out.println("Starting program again...");
					}
					// ***VIEW GRADE***//

				} else if (categoryG.equalsIgnoreCase("view")) {
					loopback = false;
					try {
						boolean loopBack = true;
						while (loopBack) {
							Scanner studentNumber = new Scanner(System.in);
							System.out.println("What is the ID of the student of which you want to view grades of?");
							int studentNum = studentNumber.nextInt();
							if (studentNum <= 18 && studentNum > 0) {
								loopBack = false;
							} else {
								System.out.println("Invalid answer. Try again.");
							}

							System.out.println("");

							StudentMaintenance.viewGrade(studentNum);
						}
						boolean goBack2 = true;
						while (goBack2) {

							Scanner continueProgram = new Scanner(System.in);
							System.out.println("Do you want to stay in the portal? Enter yes or no.");
							String continueProg = continueProgram.nextLine();

							if (continueProg.equalsIgnoreCase("yes")) {
								moreTime = true;
								goBack2 = false;
							} else if (continueProg.equalsIgnoreCase("no")) {
								System.out.println("You are logged out of the portal.");
								moreTime = false;
								goBack2 = false;
							} else {
								System.out.println("Invalid entry. Try again.");
								goBack2 = true;
							}
						}
					} catch (Exception e) {
						System.out.println("You entered invalid data.");
						System.out.println("Starting program again...");
					}
				} else {
					System.out.println("Invalid entry. Try again.");
					loopback = true;
				}
			}
		}
	}
}
