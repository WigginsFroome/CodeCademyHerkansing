
package DataLayer;

import person.Registration;
import person.Student;
import products.Course;

public class SQLDAOFactory implements DAOFactory{
    private String connectionUrl;

    public SQLDAOFactory(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    @Override
    public DAOStudent createDAOStudent() {
        return new SQLDAOStudent(this.connectionUrl);
    }

    @Override
    public DAOCourse createDAOCourse() {
        return new SQLDAOCourse(this.connectionUrl);
    }

    @Override
    public DAORegistration createDAORegistration() {
        return new SQLDAORegistration(this.connectionUrl);
    }

    @Override
    public DAOWebcast createDAOWebcast() {
        return new SQLDAOWebcast(this.connectionUrl);
    }

    @Override
    public DAOModule createDAOModule() {
        return new SQLDAOModule(this.connectionUrl);
    }
    
    @Override
    public boolean removeDAOStudent(Student student) {
         return new SQLDAOStudent(this.connectionUrl).deleteStudent(student);
    }

    @Override
    public boolean removeDAOCourse(Course course) {
        return new SQLDAOCourse(this.connectionUrl).deleteCourse(course);
    }

    @Override
    public boolean removeDAORegistration(Registration registration) {
        return new SQLDAORegistration(this.connectionUrl).deleteRegistration(registration);
    }

    @Override
    public boolean addDAOStudent(Student student) {
        return new SQLDAOStudent(this.connectionUrl).addStudent(student);
    }
    
}
