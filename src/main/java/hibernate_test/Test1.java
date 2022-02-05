package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // создание фабрики для получения сессий
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();   //  получаем сессию , через которую получаем подключение к базе (обертка jdbc)
            Employee employee = new Employee("Akmal", "Dusmuratov", "Js", 100000);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit(); // закрытие сессии
            System.out.println("Done");
        }
        finally {
            factory.close();         // если выбросится исключение , то фабрика просто закроется
        }
    }
}
