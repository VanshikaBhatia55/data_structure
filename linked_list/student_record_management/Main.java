package data_structure.linked_list.student_record_management;

public class Main {
    public static void main(String[] args) {
        // Create a StudentList object
        StudentList studentList = new StudentList();

        // Adding students
        studentList.addStudent(0, new Student(1178, "Netan", 20 ,'A')); // Add at index 0
        studentList.addStudent(1, new Student(1167, "Rishav", 22,'O')); // Add at index 1
        studentList.addStudent(2, new Student(1228, "Sahil", 21,'A')); // Add at index 2
        studentList.addStudent(0, new Student(155, "AMAN", 19, 'B')); // Add at index 0

        // Displaying the list
        System.out.println("Student Records:");
        studentList.display();

        // Printing the size
        System.out.println("Total Students: " + studentList.size());

        // Searching for a student
        int searchRoll = 1167;
        System.out.println("Is student with Roll No " + searchRoll + " present? " + (studentList.searchStudent(searchRoll) ? "Yes" : "No"));

        // Deleting a student
        int deleteRoll = 155;
        System.out.println("Deleting student with Roll No " + deleteRoll);
        studentList.deleteStudent(deleteRoll);

        // Displaying the list after deletion
        System.out.println("Updated Student Records:");
        studentList.display();
        System.out.println("Total Students after deletion: " + studentList.size());


        //To display info of particular student
        studentList.display(1167);

        //To update student grade info
        studentList.updateGradeInfo(155, 'C');
        studentList.display(155);

    }
}
