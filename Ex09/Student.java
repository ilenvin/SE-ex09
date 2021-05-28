package Ex09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Student {
    private String name, city, country, group, tel;
    private Date dob;
    private int id;

    private Student() {

    }

    public Student(String name, String city, String country, String group, int id, Date dob, String tel) throws BirthDateException, GroupException {
        setName(name);
        setCity(city);
        setCountry(country);
        setGroup(group);
        setID(id);
        setDob(dob);
        setTel(tel);
    }

    public static Student dataInput() throws GroupException, ParseException, BirthDateException {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.println(">>Getting Student Information<<");
        System.out.print("Enter id: ");
        student.setID(sc.nextInt());
        String empty = sc.nextLine();
        System.out.print("Enter name: ");
        student.setName(sc.nextLine());
        System.out.print("Enter city: ");
        student.setCity(sc.nextLine());
        System.out.print("Enter country: ");
        student.setCountry(sc.nextLine());
        System.out.print("Enter Date(dd/mm/yyyy):");
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
        student.setDob(d);
        System.out.print("Enter tel: +855 ");
        student.setTel(sc.nextLine());
        System.out.print("Enter group: ");
        student.setGroup(sc.nextLine());
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", dob=" + dob +
                ", tel=+855 " + tel +
                ", group=" + group +
                '}';
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) throws GroupException {
        char ch0, ch1;
        ch0 = group.charAt(0);
        ch1 = group.charAt(1);
        if(Character.compare(ch0, 'I') == 0 || Character.compare(ch0, 'T') == 0) {
            if(Character.compare(ch0, 'I') == 0) {
                if(Character.compare(ch1, '1') == 0 || Character.compare(ch1, '2') == 0 || Character.compare(ch1, '3') == 0 || Character.compare(ch1, '4') == 0 || Character.compare(ch1, '5') == 0) {
                    this.group = group;
                } else {
                    throw new GroupException();
                }
            } else if (Character.compare(ch0, 'T') == 0) {
                if(Character.compare(ch1, '1') == 0 || Character.compare(ch1, '2') == 0) {
                    this.group = group;
                } else {
                    throw new GroupException();
                }
            }
        } else {
            throw new GroupException();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        FieldUtil.checkNullOrEmptyOrBlank(name, "Name");
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        FieldUtil.checkNullOrEmptyOrBlank(city, "City");
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        FieldUtil.checkNullOrEmptyOrBlank(country, "Country");
        this.country = country;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) throws BirthDateException {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 15);
        Date fifteenYearsOld = cal.getTime();
        if(dob.compareTo(fifteenYearsOld) <= 0) {
            this.dob = dob;
        } else {
            throw new BirthDateException();
        }
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
}