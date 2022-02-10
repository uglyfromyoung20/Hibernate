package hibernate_one_to_many_uni;



import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // создание фабрики для получения сессий
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {

//            session = factory.getCurrentSession();//  получаем сессию , через которую получаем подключение к базе (обертка jdbc)
//            Department dep = new Department("HR",1500,234);
//
//            Employee emp = new Employee("Alexey","Alexeyev",4252312);
//
//            Employee emp1 = new Employee("Alexandr","Vasilkov",432412);
//
//            dep.addEmployeeToDepartment(emp);
//            dep.addEmployeeToDepartment(emp1);
//
//
//            session.beginTransaction();
//
//            session.save(dep);
//
//            session.getTransaction().commit(); // закрытие сессии
//
//            System.out.println("Done");





//            session = factory.getCurrentSession();   //  получаем сессию , через которую получаем подключение к базе (обертка jdbc)
//            session.beginTransaction();
//
//            Department department = session.get(Department.class , 1) ;
//
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//
//            session.getTransaction().commit(); // закрытие сессии
//
//            System.out.println("Done");





            session = factory.getCurrentSession();   //  получаем сессию , через которую получаем подключение к базе (обертка jdbc)
            session.beginTransaction();

            Department department = session.get(Department.class , 2);

            session.delete(department);



            session.getTransaction().commit(); // закрытие сессии

            System.out.println("Done");



        }
        finally {
            session.close();
            factory.close();         // если выбросится исключение , то фабрика просто закроется
        }
    }
}