package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
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




//            session.beginTransaction();
//           Detail detail = session.get(Detail.class , 4);
//            System.out.println(detail.getEmployee());
//            session.getTransaction().commit(); // закрытие сессии



            session.beginTransaction();
          Detail detail = session.get(Detail.class , 1);
          detail.getEmployee().setEmpDetail(null); // Разраыв связи между работником и его деталями
            session.delete(detail);
          session.getTransaction().commit(); // закрытие сессии

            System.out.println("Done");

        }
        finally {
            session.close();
            factory.close();         // если выбросится исключение , то фабрика просто закроется
        }
    }
}
