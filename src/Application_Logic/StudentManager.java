package Application_Logic;

import DataLayer.DAOFactory;
import java.util.Date;
import java.util.List;
import person.Student;

public class StudentManager {

    private List<Student> students;
    private DAOFactory daoFactory;

    public StudentManager(DAOFactory daoFactory) {
        this.students = daoFactory.createDAOStudent().findStudent();
        this.daoFactory = daoFactory;
    }

    public boolean deleteSudent(String studentEmail) {
        for (int i = 0; i < this.students.size(); i++) {
            System.out.println(this.students.get(i).getEmail());
            if (this.students.get(i).getEmail().equals(studentEmail)) {
                System.out.println(this.students.get(i));
                return this.daoFactory.removeDAOStudent(this.students.get(i));
            }
        }
        return false;
    }

    public boolean addSudent(String email, String name, Date birthDate, String gender, String address, String residence, String country) {
        return this.daoFactory.addDAOStudent(new Student(email, name, birthDate, gender, address, residence, country));
    }

}
