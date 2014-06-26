package com.nabla.database.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nabla.database.person.entites.Activity;
import com.nabla.database.person.entites.Address;
import com.nabla.database.person.entites.Person;
import com.nabla.database.person.service.IService;

public class InitDB
{
    // couche service
    private static IService service;

    // constructeur
    public static void main(final String[] args) throws ParseException
    {
        // configuration de l'application
        final ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        // couche service
        InitDB.service = (IService) ctx.getBean("service");
        // on vide la base
        InitDB.clean();
        // on la remplit
        InitDB.fill();
        // on verifie visuellement
        InitDB.dumpPersons();
        InitDB.dumpAddresses();
        InitDB.dumpActivities();
        InitDB.dumpPersonsActivities();
    }

    // affichage contenu table personne
    private static void dumpPersons()
    {
        System.out.format("[personnes]%n");

        for (final Person p : InitDB.service.getAllPersons())
        {
            System.out.println(p);
        }
    }

    // affichage contenu table Address
    private static void dumpAddresses()
    {
        System.out.format("[adresses]%n");

        for (final Address a : InitDB.service.getAllAddresses())
        {
            System.out.println(a);
        }
    }

    // affichage contenu table Activity
    private static void dumpActivities()
    {
        System.out.format("[activites]%n");

        for (final Activity a : InitDB.service.getAllActivities())
        {
            System.out.println(a);
        }
    }

    // affichage contenu table Personne_Activite
    private static void dumpPersonsActivities()
    {
        System.out.println("[personnes/activites]");

        for (final Person p : InitDB.service.getAllPersons())
        {
            for (final Activity a : InitDB.service.getActivitiesOfPerson(p.getId()))
            {
                System.out.format("[%s,%s]%n", p.getLastname(), a.getName());
            }
        }
    }

    // remplissage tables
    public static void fill() throws ParseException
    {
        // creation activites
        final Activity act1 = new Activity();
        act1.setName("act1");

        final Activity act2 = new Activity();
        act2.setName("act2");

        final Activity act3 = new Activity();
        act3.setName("act3");

        // creation personnes
        final Person p1 = new Person("p1", "Paul", new SimpleDateFormat("dd/MM/yy").parse("31/01/2000"), true, 2);
        final Person p2 = new Person("p2", "Sylvie", new SimpleDateFormat("dd/MM/yy").parse("05/07/2001"), false, 0);
        final Person p3 = new Person("p3", "Sylvie", new SimpleDateFormat("dd/MM/yy").parse("05/07/2001"), false, 0);

        // creation adresses
        final Address adr1 = new Address("adr1", null, null, "49000", "Angers", null, "France");
        final Address adr2 = new Address("adr2", "Les Mimosas", "15 av Foch", "49002", "Angers", "03", "France");
        final Address adr3 = new Address("adr3", "x", "x", "x", "x", "x", "x");
        // associations personne <--> adresse
        p1.setAddress(adr1);
        adr1.setPerson(p1);
        p2.setAddress(adr2);
        adr2.setPerson(p2);
        p3.setAddress(adr3);
        adr3.setPerson(p3);
        // associations personnes <--> activites
        p1.getActivities().add(act1);
        p1.getActivities().add(act2);
        p2.getActivities().add(act1);
        p2.getActivities().add(act3);
        // persistance des personnes avec leurs activites
        InitDB.service.savePersonsWithActivities(new Person[]
        { p1, p2, p3 });
    }

    // supression elements des tables
    public static void clean()
    {
        // on supprime ttes les personnes et donc toutes les adresses
        for (final Person person : InitDB.service.getAllPersons())
        {
            InitDB.service.deletePerson(person.getId());
        }

        // on supprime ttes les activites
        for (final Activity activity : InitDB.service.getAllActivities())
        {
            InitDB.service.deleteActivity(activity.getId());
        }
    }
}
