import edu.sabanciuniv.controller.StudentController;
import edu.sabanciuniv.model.*;
import edu.sabanciuniv.utility.EntityManagerUtils;
import jakarta.persistence.EntityManager;


public class TestStudentManagementApp {
    public static void main(String[] args) {
        if (isDataExists()) saveTestData();
        StudentController StudentController = new StudentController();

        System.out.println("============= FIND ALL StudentS ===============");
        for (Student Student : StudentController.findAllStudents()) {
            System.out.println(Student);
        }

        System.out.println("============= FIND Student ===============");
        Student foundStudent = StudentController.findStudent(5);
        System.out.println(foundStudent);

        System.out.println("============= DELETE Student ===============");
        StudentController.deleteStudent(foundStudent);
    }

    private static boolean isDataExists() {
        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.createQuery("SELECT c FROM Student c", Student.class).getResultList().size() == 0;
    }

    private static void saveTestData() {
        Student Student1 = new Student("Koray Guney", 1990, "Istanbul", 'M');
        Student Student2 = new Student("Ali Veli", 1991, "Amerika", 'M');
        Student Student3 = new Student("Ayse Simsek", 1992, "Afrika", 'F');

        Course course1 = new Course("JavaEE",526,6);
        Course course2 = new Course("Beden",525,3);
        Course course3 = new Course("Matematik",527,6);

        Instructor permanentInstructor1 = new PermanentInstructor("Dilge","Kadikoy","5999999999",5000);
        Instructor permanentInstructor2 = new PermanentInstructor("Tarik","Besiktas","5999999998",5000);
        Instructor visitingInstructor1 = new VisitingInstructor("Ali","Kadikoy","5999999998",50);

        course1.getStudentList().add(Student1);
        course1.getStudentList().add(Student3);

        course2.getStudentList().add(Student2);
        course2.getStudentList().add(Student3);

        course3.getStudentList().add(Student1);
        course3.getStudentList().add(Student2);

        Student1.getCourseList().add(course1);
        Student1.getCourseList().add(course3);

        Student2.getCourseList().add(course2);
        Student2.getCourseList().add(course3);

        Student3.getCourseList().add(course1);
        Student3.getCourseList().add(course2);

        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(permanentInstructor2);
        course3.setInstructor(permanentInstructor2);

        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course1);
            entityManager.persist(course2);
            entityManager.persist(course3);

            entityManager.persist(Student1);
            entityManager.persist(Student2);
            entityManager.persist(Student3);

            entityManager.persist(permanentInstructor1);
            entityManager.persist(permanentInstructor2);
            entityManager.persist(visitingInstructor1);
            entityManager.getTransaction().commit();
            System.out.println("All data persisted!...");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }
}
