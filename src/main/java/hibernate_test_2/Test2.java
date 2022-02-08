package hibernate_test_2;

import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // создание фабрики для получения сессий
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
//
             session = factory.getCurrentSession();   //  получаем сессию , через которую получаем подключение к базе (обертка jdbc)
Employee employee = new Employee("Akmal","Dusmuratov","Js",213423);
Detail detail = new Detail("Samara","324342123","fgdw@mail.ru");
     employee.setEmpDetail(detail); // важно так же и работнику добавить детали
     detail.setEmployee(employee);

            session.beginTransaction();
            session.save(detail);
            session.getTransaction().commit(); // закрытие сессии

            System.out.println("Done");

        }
        finally {
            session.close();
            factory.close();         // если выбросится исключение , то фабрика просто закроется
        }
    }
}
