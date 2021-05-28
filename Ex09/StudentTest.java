package Ex09;

import java.text.ParseException;

public class StudentTest {
    public static void main(String[] args) throws GroupException, ParseException, BirthDateException {
        Student student = Student.dataInput();
        System.out.println(student);
    }
}