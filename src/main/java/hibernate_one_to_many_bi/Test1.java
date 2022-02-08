package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
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
//
             session = factory.getCurrentSession();   //  получаем сессию , через которую получаем подключение к базе (обертка jdbc)
       Department dep = new Department("IT",1200,300);

               Employee emp1 =  new Employee("Alexey","Altyshkin ",800);
               Employee emp2 =  new Employee("Alexey", "Maklov", 900);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            session.beginTransaction();
session.save(dep);

            session.getTransaction().commit(); // закрытие сессии

            System.out.println("Done");

        }
        finally {
            session.close();
            factory.close();         // если выбросится исключение , то фабрика просто закроется
        }
    }
}
