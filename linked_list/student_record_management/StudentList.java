package data_structure.linked_list.student_record_management;

class StudentList {
    private Student head; // Head of the linked list

    // Constructor
    public StudentList() {
        this.head = null;
    }

    // Method to add a student at a given index
    public void addStudent(int idx, Student newStudent) {
        if (idx < 0) {
            System.out.println("Invalid index");
            return;
        }
        if(idx>this.size()){
            System.out.println("Invalid index");
            return;
        }
        // Insert at the beginning (head)
        if (idx == 0) {
            newStudent.next = head;
            head = newStudent;
            return;
        }

        Student temp = head;
        int count = 0;

        // Traverse to the node just before the desired index
        while (temp != null && count < idx - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Index out of bounds");
            return;
        }

        // Insert the new student node
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Method to delete a student by roll number
    public void deleteStudent(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If head needs to be deleted
        if (head.rollNumber == rollNumber) {
            head = head.next; // Move head to the next node
            return;
        }

        Student temp = head;
        Student prev = null;

        while (temp != null && temp.rollNumber != rollNumber) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Student with Roll No: " + rollNumber + " not found.");
            return;
        }

        // Remove the node
        prev.next = temp.next;
    }

    // Method to search for a student by roll number
    public boolean searchStudent(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Method to display all students
    public void display() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.studentName + ", Age: " + temp.studentAge + " , Grade: " + temp.studentGrade);
            temp = temp.next;
        }
    }

    // Method to get the size of the linked list
    public int size() {
        int count = 0;
        Student temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public void display(int rollNo){
        Student temp=head;
        while(temp.rollNumber!=rollNo){
            temp=temp.next;
        }
        System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.studentName + ", Age: " + temp.studentAge + " , Grade: " + temp.studentGrade);

    }
    public void updateGradeInfo(int roll ,char grade ){
        Student temp=head;
        while(temp.rollNumber!=roll){
            temp=temp.next;
        }
        temp.studentGrade=grade;
        System.out.println("Grade updated");
    }
}
// In here we have made a separate class for making Linked List because we were having trouble with maintaining the head