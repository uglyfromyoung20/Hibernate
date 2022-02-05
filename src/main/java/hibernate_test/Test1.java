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
            Employee employee = new Employee("Kirill", "Krilov", "JavaDeveloper", 7000);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit(); // закрытие сессии
        }
        finally {
            factory.close();         // если выбросится исключение , то фабрика просто закроется
        }
    }
}
