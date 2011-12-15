package com.nabla.database.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nabla.database.person.entites.Activity;
import com.nabla.database.person.entites.Address;
import com.nabla.database.person.entites.Person;
import com.nabla.database.person.service.IService;

public class TestNG extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// log
		log("init");
		// configuration de l'application
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-config.xml");
		// couche service
		service = (IService) ctx.getBean("service");
		/*
		ConfigurableBeanFactory factory = new XmlBeanFactory(...);
        
		// now register any needed BeanPostProcessor instances
		MyBeanPostProcessor postProcessor = new MyBeanPostProcessor();
		factory.addBeanPostProcessor(postProcessor);	
		*/	
		// on vide la base
		clean();
		// on la remplit
		fill();
		// on affiche les tables
		dumpPersons();
		dumpAddresses();
		dumpActivities();
		dumpPersonsActivities();		
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		// affichage tables
		System.out.println("--------------- contenu de la base");
		dumpPersons();
		dumpAddresses();
		dumpActivities();
		dumpPersonsActivities();
		System.out.println("-----------------------------------");		
	}

	// couche service
	private IService service;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestNG( String testName )
    {
        super( testName );
    }	

	// logs
	private void log(String message) {
		System.out.println("----------- " + message);
	}

	// remplissage tables
	public void fill() throws ParseException {
		// création activites
		Activity act1 = new Activity();
		act1.setName("act1");
		Activity act2 = new Activity();
		act2.setName("act2");
		Activity act3 = new Activity();
		act3.setName("act3");
		// création personnes
		Person p1 = new Person("p1", "Paul", new SimpleDateFormat("dd/MM/yy").parse("31/01/2000"), true, 2);
		Person p2 = new Person("p2", "Sylvie", new SimpleDateFormat("dd/MM/yy").parse("05/07/2001"), false, 0);
		Person p3 = new Person("p3", "Sylvie", new SimpleDateFormat("dd/MM/yy").parse("05/07/2001"), false, 0);
		// création adresses
		Address adr1 = new Address("adr1", null, null, "49000", "Angers", null, "France");
		Address adr2 = new Address("adr2", "Les Mimosas", "15 av Foch", "49002", "Angers", "03", "France");
		Address adr3 = new Address("adr3", "x", "x", "x", "x", "x", "x");
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
		// persistance des personnes avec leurs activités
		service.savePersonsWithActivities(new Person[] { p1, p2, p3 });
	}

	// supression éléments des tables
	public void clean() {
		// on supprime ttes les personnes et donc toutes les adresses
		for (Person personne : service.getAllPersons()) {
			service.deletePerson(personne.getId());
		}
		// on supprime ttes les activités
		for (Activity activite : service.getAllActivities()) {
			service.deleteActivity(activite.getId());
		}
	}

	// affichage contenu table personne
	private void dumpPersons() {
		System.out.format("[personnes]%n");
		for (Person c : service.getAllPersons()) {
			System.out.println(c);
		}
	}

	// affichage contenu table Address
	private void dumpAddresses() {
		System.out.format("[adresses]%n");
		for (Address a : service.getAllAddresses()) {
			System.out.println(a);
		}
	}

	// affichage contenu table Activity
	private void dumpActivities() {
		System.out.format("[activites]%n");
		for (Activity a : service.getAllActivities()) {
			System.out.println(a);
		}
	}

	// affichage contenu table Person_Activity
	private void dumpPersonsActivities() {
		System.out.println("[personnes/activites]");
		for (Person p : service.getAllPersons()) {
			for (Activity a : service.getActivitiesOfPerson(p.getId())) {
				System.out.format("[%s,%s]%n", p.getLastname(), a.getName());
			}
		}
	}

	public void test01() {
		log("test01");
		// liste des personnes
		List<Person> personnes = service.getAllPersons();
		assert 3 == personnes.size();
		// liste des adresses
		List<Address> adresses = service.getAllAddresses();
		assert 3 == adresses.size();
		// liste des activites
		List<Activity> activites = service.getAllActivities();
		assert 3 == activites.size();
	}

	public void test02() {
		log("test02");
		// personne p1
		List<Person> personnes = service.getAllPersonsWithNameLike("p1%");
		assert 1 == personnes.size();
		// personne p2
		personnes = service.getAllPersonsWithNameLike("p2%");
		assert 1 == personnes.size();
		// personne p3
		personnes = service.getAllPersonsWithNameLike("p3%");
		assert 1 == personnes.size();
		// personne autre
		personnes = service.getAllPersonsWithNameLike("b%");
		assert 0 == personnes.size();
		// activite act1
		List<Activity> activites = service.getAllActivitiesWithNameLike("act1%");
		assert 1 == activites.size();
		// activite act2
		activites = service.getAllActivitiesWithNameLike("act2%");
		assert 1 == activites.size();
		// activite act3
		activites = service.getAllActivitiesWithNameLike("act3%");
		assert 1 == activites.size();
		// activite autre
		activites = service.getAllActivitiesWithNameLike("b%");
		assert 0 == activites.size();
	}

	public void test03() {
		log("test03");
		// personne p1
		List<Person> personnes = service.getAllPersonsWithNameLike("p1%");
		assert 1 == personnes.size();
		Person p1 = personnes.get(0);
		// activites associés
		List<Activity> activitesP1 = service.getActivitiesOfPerson(p1.getId());
		// vérification
		assert 2 == activitesP1.size();
		// on crée une nouvelle activite
		Activity act4 = new Activity();
		act4.setName("act4");
		// qu'on persiste
		service.saveActivity(act4);
		// vérification
		List<Activity> activites = service.getAllActivitiesWithNameLike("act4%");
		assert 1 == activites.size();
		// on l'ajoute aux activités de la personne p1
		Set<Activity> activitesPersonP1 = new HashSet<Activity>();
		for (Activity a : activitesP1) {
			activitesPersonP1.add(a);
		}
		activitesPersonP1.add(act4);
		p1.setActivities(activitesPersonP1);
		// on persiste la personne
		service.updatePerson(p1);
		// activites associées à la personne p1
		activites = service.getActivitiesOfPerson(p1.getId());
		// vérification - il doit y en avoir 1 de plus
		assert 3 == activites.size();
	}

	public void test04() {
		log("test04");
		// activité act1
		List<Activity> activites = service.getAllActivitiesWithNameLike("act1%");
		assert 1 == activites.size();
		Activity act1 = activites.get(0);
		// personnes faisant l'activité act1
		List<Person> personnesAct1 = service.getPersonsDoingActivity(act1.getId());
		assert 2 == personnesAct1.size();
		// suppression personne P2
		List<Person> personnes = service.getAllPersonsWithNameLike("p2%");
		assert 1 == personnes.size();
		Person p2 = personnes.get(0);
		service.deletePerson(p2.getId());
		// vérification
		personnes = service.getAllPersonsWithNameLike("p2%");
		assert 0 == personnes.size();
		// activités act1 - la personne p2 faisait l'activité act1
		personnesAct1 = service.getPersonsDoingActivity(act1.getId());
		assert 1 == personnesAct1.size();
	}

	public void test05() {
		log("test05");
		// personne p1
		List<Person> personnes = service.getAllPersonsWithNameLike("p1%");
		assert 1 == personnes.size();
		Person p1 = personnes.get(0);
		// on modifie son nom
		p1.setLastname("p1+");
		service.updatePerson(p1);
		// vérification
		personnes = service.getAllPersonsWithNameLike("p1%");
		assert 1 == personnes.size();
		p1 = personnes.get(0);
		assert "p1+".equals(p1.getLastname());
		// activité act2
		List<Activity> activites = service.getAllActivitiesWithNameLike("act2%");
		assert 1 == activites.size();
		Activity act2 = activites.get(0);
		// on modifie son nom
		act2.setName("act2+");
		service.updateActivity(act2);
		// vérification
		activites = service.getAllActivitiesWithNameLike("act2%");
		assert 1 == activites.size();
		act2 = activites.get(0);
		assert "act2+".equals(act2.getName());
	}

	public void test06() throws ParseException {
		log("test06");
		// liste des activités
		List<Activity> activites = service.getAllActivities();
		int nbActivities = activites.size();
		// créer deux nouvelles personnes
		Person p4 = new Person("p4", "p4", new SimpleDateFormat("dd/MM/yy").parse("05/07/2001"), false, 0);
		Person p5 = new Person("p5", "p5", new SimpleDateFormat("dd/MM/yy").parse("05/07/2001"), false, 0);
		// créer 1 nouvelle activité avec un nom existant (violation contrainte d'unicité)
		Activity act4 = new Activity();
		act4.setName("act1");
		// la personne p4 pratique l'activité act4
		p4.getActivities().add(act4);
		// on doit avoir une exception lors de la sauvegarde de l'activité act4 et un rollback général
		boolean erreur = false;
		try {
			// persister les personnes et les activites
			service.savePersonsWithActivities(new Person[] { p4, p5 });
		} catch (RuntimeException e) {
			erreur = true;
		}
		// vérifications : il y a du avoir une exception
		assert erreur;
		// et un rollback
		// personne p4 : elle ne doit pas exister
		List<Person> personnes = service.getAllPersonsWithNameLike("p4%");
		assert 0 == personnes.size();
		// personne p5 : elle ne doit pas exister
		personnes = service.getAllPersonsWithNameLike("p5%");
		assert 0 == personnes.size();
		// le nbre d'activités n'a pas du changer
		activites = service.getAllActivities();
		assert nbActivities == activites.size();
	}

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestNG.class );
    }	
}
