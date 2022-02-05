package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // создание фабрики для получения сессий
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();   //  получаем сессию , через которую получаем подключение к базе (обертка jdbc)
            Employee employee = new Employee("Olev", "Vilov", "Java", 1000000);
            session.beginTransaction();
            session.save(employee);
            List<Employee> emps = session.createQuery("from Employee"+" where name ='Oleg' AND salary>1325").getResultList(); // Получение всех людей из таблицы
            for(Employee e : emps){
                System.out.println(e);
            }
            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();         // если выбросится исключение , то фабрика просто закроется
        }
    }
}
