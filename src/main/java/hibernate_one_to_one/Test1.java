package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // создание фабрики для получения сессий
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            Session session = factory.getCurrentSession();   //  получаем сессию , через которую получаем подключение к базе (обертка jdbc)
//
//            Employee employee = new Employee("Alexey","Altyshkin","IT",1000);
//
//            Detail detail  = new Detail("Samara","83728442","kfnsl@mail.ru");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit(); // закрытие сессии
//
//            System.out.println("Done");

//            Session session = factory.getCurrentSession();   //  получаем сессию , через которую получаем подключение к базе (обертка jdbc)
//
//            Employee employee = new Employee("Kirill","Krilov","JavaDeveloper",1046);
//
//            Detail detail  = new Detail("Syzran","8372342432422","kmaster@mail.ru");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit(); // закрытие сессии
//
//            System.out.println("Done");
             session = factory.getCurrentSession();   //  получаем сессию , через которую получаем подключение к базе (обертка jdbc)



            session.beginTransaction();
            Employee emp = session.get(Employee.class,2);
            session.delete(emp);
            session.getTransaction().commit(); // закрытие сессии

            System.out.println("Done");

        }
        finally {
            session.close();
            factory.close();         // если выбросится исключение , то фабрика просто закроется
        }
    }
}
