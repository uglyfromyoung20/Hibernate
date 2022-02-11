package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            session = factory.getCurrentSession();
//
//            Section section1 =new Section("Basketball");
//            Child child1 = new Child("Alexey",12);
//            Child child2 = new Child("Akmal",10);
//            Child child3 = new Child("Kirill",7);
//            section1.addChildrenToSection(child1);
//            section1.addChildrenToSection(child2);
//            section1.addChildrenToSection(child3);
//            session.beginTransaction();
//            session.save(section1);
//
//            session.getTransaction().commit();
//            System.out.println("done");
            //**********************************************************************************************************
//            session = factory.getCurrentSession();
//
//            Section section1 =new Section("Football");
//            Section section2 =new Section("Voleyball");
//            Section section3 =new Section("Chess");
//
//
//            Child child1 = new Child("Ilya",12);
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//            session.save(child1);
//
//            session.getTransaction().commit();
//            System.out.println("done");
//*********************************************************************************************************


//            session = factory.getCurrentSession();
//
//
//
//            session.beginTransaction();
//            Section section = session.get(Section.class , 1);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();
//            System.out.println("done");
            //******************************************************************************************


            session = factory.getCurrentSession();



            session.beginTransaction();
            Child child = session.get(Child.class , 4);
            System.out.println(child);
            System.out.println(child.getSections());

            session.getTransaction().commit();
            System.out.println("done");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
