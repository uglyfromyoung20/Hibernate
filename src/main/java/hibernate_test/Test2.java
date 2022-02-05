package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // создание фабрики для получения сессий
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();   //  получаем сессию , через которую получаем подключение к базе (обертка jdbc)
            Employee employee = new Employee("Oleg", "Malov", "HTML", 1323);
            session.beginTransaction();
            session.save(employee);
           // session.getTransaction().commit(); // закрытие сессии

            int myId = employee.getId(); //Id не будет пустым , так как база данных сама назначит его и передаст нам

            //session = factory.getCurrentSession();
            //session.beginTransaction();
            Employee employee1 = session.get(Employee.class , myId) ; // запрос у базы работника по его ID
            session.getTransaction().commit();
            System.out.println(employee1);
            System.out.println("Done");
        }
        finally {
            factory.close();         // если выбросится исключение , то фабрика просто закроется
        }
    }
}
