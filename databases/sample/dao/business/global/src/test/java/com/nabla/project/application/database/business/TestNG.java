package com.nabla.project.application.database.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nabla.project.application.database.business.global.model.Activity;
import com.nabla.project.application.database.business.global.model.Address;
import com.nabla.project.application.database.business.global.model.Person;
import com.nabla.project.application.database.business.global.service.IService;

public class TestNG extends TestCase /* BaseDaoTestCase */
{

    @Autowired
    private IService service;

    @Override
    @Before
    public void setUp() throws Exception
    {
        // log
        TestNG.log("init");

        final ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-config.xml");
        this.service = (IService) ctx.getBean("service");

        // on vide la base
        this.clean();
        // on la remplit
        this.fill();
        // on affiche les tables
        this.dumpPersons();
        this.dumpAddresses();
        this.dumpActivities();
        this.dumpPersonsActivities();
    }

    @Override
    @After
    public void tearDown() throws Exception
    {
        System.out.println("--------------- contenu de la base");
        this.dumpPersons();
        this.dumpAddresses();
        this.dumpActivities();
        this.dumpPersonsActivities();
        System.out.println("-----------------------------------");
    }

    // logs
    private static void log(final String message)
    {
        System.out.println("----------- " + message);
    }

    // remplissage tables
    public void fill() throws ParseException
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
        final Address adr1 = new Address("adr1", null, null, "49000", "Angers", null, null, null, "France");
        final Address adr2 = new Address("adr2", "Les Mimosas", "15 av Foch", "49002", "Angers", null, null, "03", "France");
        final Address adr3 = new Address("adr3", "x", "x", "x", "x", "x", "x", "x", "x");
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
        this.service.savePersonsWithActivities(new Person[]
        { p1, p2, p3 });
    }

    // supression elements des tables
    public void clean()
    {
        // on supprime toutes les adresses
        // for (final Address address : this.service.getAllAddresses()) {
        // this.service.deleteAddress(address.getId());
        // }
        // on supprime ttes les personnes et donc toutes les adresses
        for (final Person personne : this.service.getAllPersons())
        {
            this.service.deletePerson(personne.getId());
        }
        // on supprime ttes les activites
        for (final Activity activite : this.service.getAllActivities())
        {
            this.service.deleteActivity(activite.getId());
        }
    }

    // affichage contenu table personne
    private void dumpPersons()
    {
        System.out.format("[personnes]%n");
        for (final Person c : this.service.getAllPersons())
        {
            System.out.println(c);
        }
    }

    // affichage contenu table Address
    private void dumpAddresses()
    {
        System.out.format("[adresses]%n");
        for (final Address a : this.service.getAllAddresses())
        {
            System.out.println(a);
        }
    }

    // affichage contenu table Activity
    private void dumpActivities()
    {
        System.out.format("[activites]%n");
        for (final Activity a : this.service.getAllActivities())
        {
            System.out.println(a);
        }
    }

    // affichage contenu table Person_Activity
    private void dumpPersonsActivities()
    {
        System.out.println("[personnes/activites]");
        for (final Person p : this.service.getAllPersons())
        {
            for (final Activity a : this.service.getActivitiesOfPerson(p.getId()))
            {
                System.out.format("[%s,%s]%n", p.getLastName(), a.getName());
            }
        }
    }

    @Test
    public void test01() throws Exception
    {
        TestNG.log("test01");
        // liste des personnes
        final List<Person> personnes = this.service.getAllPersons();
        assert 3 == personnes.size();
        // liste des adresses
        final List<Address> adresses = this.service.getAllAddresses();
        assert 3 == adresses.size();
        // liste des activites
        final List<Activity> activites = this.service.getAllActivities();
        assert 3 == activites.size();
    }

    @Test
    public void test02()
    {
        TestNG.log("test02");
        // personne p1
        List<Person> personnes = this.service.getAllPersonsWithNameLike("p1%");
        assert 1 == personnes.size();
        // personne p2
        personnes = this.service.getAllPersonsWithNameLike("p2%");
        assert 1 == personnes.size();
        // personne p3
        personnes = this.service.getAllPersonsWithNameLike("p3%");
        assert 1 == personnes.size();
        // personne autre
        personnes = this.service.getAllPersonsWithNameLike("b%");
        assert 0 == personnes.size();
        // activite act1
        List<Activity> activites = this.service.getAllActivitiesWithNameLike("act1%");
        assert 1 == activites.size();
        // activite act2
        activites = this.service.getAllActivitiesWithNameLike("act2%");
        assert 1 == activites.size();
        // activite act3
        activites = this.service.getAllActivitiesWithNameLike("act3%");
        assert 1 == activites.size();
        // activite autre
        activites = this.service.getAllActivitiesWithNameLike("b%");
        assert 0 == activites.size();
    }

    @Test
    public void test03()
    {
        TestNG.log("test03");
        // personne p1
        final List<Person> personnes = this.service.getAllPersonsWithNameLike("p1%");
        assert 1 == personnes.size();
        final Person p1 = personnes.get(0);
        // activites associes
        final List<Activity> activitesP1 = this.service.getActivitiesOfPerson(p1.getId());
        // verification
        assert 2 == activitesP1.size();
        // on cree une nouvelle activite
        final Activity act4 = new Activity();
        act4.setName("act4");
        // qu'on persiste
        this.service.saveActivity(act4);
        // verification
        List<Activity> activites = this.service.getAllActivitiesWithNameLike("act4%");
        assert 1 == activites.size();
        // on l'ajoute aux activites de la personne p1
        final Set<Activity> activitesPersonP1 = new HashSet<Activity>();
        for (final Activity a : activitesP1)
        {
            activitesPersonP1.add(a);
        }
        activitesPersonP1.add(act4);
        p1.setActivities(activitesPersonP1);
        // on persiste la personne
        this.service.updatePerson(p1);
        // activites associees a la personne p1
        activites = this.service.getActivitiesOfPerson(p1.getId());
        // verification - il doit y en avoir 1 de plus
        assert 3 == activites.size();
    }

    @Test
    public void test04()
    {
        TestNG.log("test04");
        // activite act1
        final List<Activity> activites = this.service.getAllActivitiesWithNameLike("act1%");
        assert 1 == activites.size();
        final Activity act1 = activites.get(0);
        // personnes faisant l'activite act1
        List<Person> personnesAct1 = this.service.getPersonsDoingActivity(act1.getId());
        assert 2 == personnesAct1.size();
        // suppression personne P2
        List<Person> personnes = this.service.getAllPersonsWithNameLike("p2%");
        assert 1 == personnes.size();
        final Person p2 = personnes.get(0);
        this.service.deletePerson(p2.getId());
        // verification
        personnes = this.service.getAllPersonsWithNameLike("p2%");
        assert 0 == personnes.size();
        // activites act1 - la personne p2 faisait l'activite act1
        personnesAct1 = this.service.getPersonsDoingActivity(act1.getId());
        assert 1 == personnesAct1.size();
    }

    @Test
    public void test05()
    {
        TestNG.log("test05");
        // personne p1
        List<Person> personnes = this.service.getAllPersonsWithNameLike("p1%");
        assert 1 == personnes.size();
        Person p1 = personnes.get(0);
        // on modifie son nom
        p1.setLastName("p1+");
        this.service.updatePerson(p1);
        // verification
        personnes = this.service.getAllPersonsWithNameLike("p1%");
        assert 1 == personnes.size();
        p1 = personnes.get(0);
        assert "p1+".equals(p1.getLastName());
        // activite act2
        List<Activity> activites = this.service.getAllActivitiesWithNameLike("act2%");
        assert 1 == activites.size();
        Activity act2 = activites.get(0);
        // on modifie son nom
        act2.setName("act2+");
        this.service.updateActivity(act2);
        // verification
        activites = this.service.getAllActivitiesWithNameLike("act2%");
        assert 1 == activites.size();
        act2 = activites.get(0);
        assert "act2+".equals(act2.getName());
    }

    @Test
    public void test06() throws ParseException
    {
        TestNG.log("test06");
        // liste des activites
        List<Activity> activites = this.service.getAllActivities();
        final int nbActivities = activites.size();
        // creer deux nouvelles personnes
        final Person p4 = new Person("p4", "p4", new SimpleDateFormat("dd/MM/yy").parse("05/07/2001"), false, 0);
        final Person p5 = new Person("p5", "p5", new SimpleDateFormat("dd/MM/yy").parse("05/07/2001"), false, 0);
        // creer 1 nouvelle activite avec un nom existant (violation contrainte d'unicite)
        final Activity act4 = new Activity();
        act4.setName("act1");
        // la personne p4 pratique l'activite act4
        p4.getActivities().add(act4);
        // on doit avoir une exception lors de la sauvegarde de l'activite act4 et un rollback general
        boolean erreur = false;
        try
        {
            // persister les personnes et les activites
            this.service.savePersonsWithActivities(new Person[]
            { p4, p5 });
        } catch (final RuntimeException e)
        {
            erreur = true;
        }
        // verifications : il y a du avoir une exception
        assert erreur;
        // et un rollback
        // personne p4 : elle ne doit pas exister
        List<Person> personnes = this.service.getAllPersonsWithNameLike("p4%");
        assert 0 == personnes.size();
        // personne p5 : elle ne doit pas exister
        personnes = this.service.getAllPersonsWithNameLike("p5%");
        assert 0 == personnes.size();
        // le nbre d'activites n'a pas du changer
        activites = this.service.getAllActivities();
        assert nbActivities == activites.size();
    }

}
