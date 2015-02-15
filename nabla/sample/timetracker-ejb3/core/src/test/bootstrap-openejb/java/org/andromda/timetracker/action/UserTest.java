package org.andromda.timetracker.action;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.Component;
import org.jboss.seam.log.LogProvider;
import org.jboss.seam.log.Logging;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;

@RunWith(Arquillian.class)
public class UserTest extends JUnitSeamTest //SeamOpenEjbTest
{

    //    private static final String  DIRECTOR_JOEL_COEN      = "Joel Coen";
    //    private static final String  THE_BIG_LEBOWSKI_TITLE  = "The Big Lebowski";
    //    private static final Integer THE_BIG_LEBOWSKI_YEAR   = 1992;
    //    private static final String  THE_BIG_LEBOWSKI_PLOT   =
    //            "\"Dude\" Lebowski, mistaken for a millionaire Lebowski, seeks restitution for his " +
    //                    "ruined rug and enlists his bowling buddies to help get it.";
    //
    //    private static final String  THE_WALL_DIRECTOR = "Alan Parker";
    //    private static final String  THE_WALL_TITLE    = "The Wall";
    //    private static final Integer THE_WALL_YEAR     = 1999;
    //    private static final String  THE_WALL_PLOT     =
    //            "A troubled rock star descends into madness " +
    //                    "in the midst of his physical and social isolation from everyone.";
    //
    //    private Long theBigLebowskiId;
    //    private Long reservoirDogsId;
    //    private Long theWallId;

    private static final LogProvider log = Logging.getLogProvider(UserTest.class);

    private boolean mockLogin()
    {
        Credentials credentials = (Credentials) Component.getInstance("org.jboss.seam.security.credentials");
        Identity identity = (Identity) Component.getInstance("org.jboss.seam.security.identity");
        credentials.setUsername("admin");
        identity.addRole("admin");
        return identity.login().equals("loggedIn");
    }

    /*
     * @Override
     * @BeforeSuite
     * public void beforeSuite() throws Exception
     * {
     * //System.out.println("**** UserTest.beforeSuite()");
     * // Change some logging, INFO|DEBUG|WARN|ERROR|FATAL
     * contextProperties.put("log4j.category.org.jboss.seam.Component", "DEBUG");
     * contextProperties.put("log4j.category.org.jboss.seam.transaction", "DEBUG");
     * contextProperties.put("log4j.category.org.jboss.seam.mock", "DEBUG");
     * contextProperties.put("log4j.category.no.knowit.seam.openejb.mock", "DEBUG");
     * contextProperties.put("log4j.category.no.knowit.seam.example", "debug");
     * super.beforeSuite();
     * }
     */

    @Override
    @BeforeClass
    public void setupClass() throws Exception
    {
        super.setupClass();

        // Delete all movies
        //        CrudService crudService = doJndiLookup("crudService");
        //        crudService.removeByExample(new Movie(), true);
        //        assert crudService.findWithType(Movie.class).size() == 0 : "List.size():";
        //
        //        // Persist 3 movies
        //        ArrayList<Movie> movies = new ArrayList<Movie>();
        //        movies.add(new Movie(DIRECTOR_JOEL_COEN, THE_BIG_LEBOWSKI_TITLE, THE_BIG_LEBOWSKI_YEAR, "..."));
        //
        //        movies.add(new Movie("Quentin Tarantino", "Reservoir Dogs", 1992,
        //                "After a simple jewelery heist goes terribly wrong, the surviving criminals begin " +
        //                "to suspect that one of them is a police informant."));
        //
        //        movies.add(new Movie(DIRECTOR_JOEL_COEN, "Fargo", 1996,
        //                "Jerry Lundegaard's inept crime falls apart due to his and his henchmen's bungling " +
        //                "and the persistent police work of pregnant Marge Gunderson."));
        //
        //        movies = (ArrayList<Movie>) crudService.persistCollection(movies);
        //        assert crudService.findWithType(Movie.class).size() == 3 : "List.size():";
        //
        //        theBigLebowskiId = movies.get(0).getId();
        //        reservoirDogsId = movies.get(1).getId();
    }

    /*
    @Test
    public void newMovie() throws Exception {

        new NonFacesRequest("/view/example/MovieList.xhtml") {
            @Override
            protected void renderResponse() throws Exception {
                int actual = (Integer)getValue("#{movieList.resultList.size}");
                Assert.assertTrue(actual > 0, "movieList.size should be gt. 0");
            }
        }.run();

        new FacesRequest("/login.xhtml") {
            @Override
            protected void updateModelValues() throws Exception {
                assert !isSessionInvalid() : "Invalid session";
                setValue("#{credentials.username}", "admin");
            }

            @Override
            protected void invokeApplication() throws Exception {
                assert invokeMethod("#{authenticator.authenticate}").equals(true) : "Authentication failed";
                assert invokeMethod("#{identity.login}").equals("loggedIn") : "Login failed";
                setOutcome("/view/example/MovieEdit.xhtml");
            }
        }.run();

        new FacesRequest("/view/example/MovieEdit.xhtml") {
            @Override
            protected void updateModelValues() throws Exception {
                invokeMethod( "#{movieHome.clearInstance}" );
                setValue("#{movieHome.instance.director}", THE_WALL_DIRECTOR);
                setValue("#{movieHome.instance.title}",    THE_WALL_TITLE);
                setValue("#{movieHome.instance.year}",     THE_WALL_YEAR);
                setValue("#{movieHome.instance.plot}",     THE_WALL_PLOT);
            }

            @Override
            protected void invokeApplication() {
                assert invokeMethod("#{movieHome.persist}").equals("persisted");
                theWallId = (Long)getValue("#{movieHome.movieId}");
                setOutcome("/view/example/Movie.xhtml");
            }

            @Override
            protected void afterRequest() {
                assert isInvokeApplicationComplete();
                assert !isRenderResponseBegun();
            }
        }.run();

        new NonFacesRequest("/view/example/Movie.xhtml") {
            @Override
            protected void renderResponse() {
                setValue("#{movieHome.movieId}", theWallId);
                invokeMethod("#{movieHome.wire}");
                assert getValue("#{movieHome.instance.director}").equals(THE_WALL_DIRECTOR);
                assert getValue("#{movieHome.instance.title}").equals(THE_WALL_TITLE);
                assert getValue("#{movieHome.instance.year}").equals(THE_WALL_YEAR);
                assert getValue("#{movieHome.instance.plot}").equals(THE_WALL_PLOT);
            }
        }.run();

        new FacesRequest() {
            @Override
            protected void invokeApplication() throws Exception {
                assert getValue("#{identity.loggedIn}").equals(true) : "Not logged in";
                assert invokeAction("#{identity.logout}") == null;
                assert getValue("#{identity.loggedIn}").equals(false) : "Logout failed";
            }
        }.run();
    }

    @Test
    public void editMovie() throws Exception {
        new FacesRequest("/view/example/MovieEdit.xhtml") {
            @Override
            protected void invokeApplication() throws Exception {
                Conversation.instance().begin();
                assert !isSessionInvalid() : "Invalid session";
                assert mockLogin() : "Login failed";
                setValue("#{movieHome.movieId}", theBigLebowskiId);
                invokeMethod( "#{movieHome.wire}" );
                setValue("#{movieHome.instance.plot}", THE_BIG_LEBOWSKI_PLOT);
                Object result = invokeMethod( "#{movieHome.update}" );
                Assert.assertEquals(result, "updated", "#{movieHome.update}");
                Conversation.instance().end();
            }
        }.run();
    }

    @Test
    public void unauthorizedAccess() throws Exception {
        new FacesRequest("/view/example/MovieEdit.xhtml") {
            @Override
            protected void invokeApplication() throws Exception {
                Conversation.instance().begin();
                assert !isSessionInvalid() : "Invalid session";
                setValue("#{movieHome.movieId}", theBigLebowskiId);
                invokeMethod( "#{movieHome.wire}" );
                setValue("#{movieHome.instance.plot}", "Not allowed to edit");

                try {
                    invokeMethod( "#{movieHome.update}" );
                    assert false : "Expected authentication failed!";
                }
                catch (javax.el.ELException e) {
                    assert e.getCause() instanceof org.jboss.seam.security.NotLoggedInException :
                        "Expected to fail with: 'org.jboss.seam.security.NotLoggedInException'";

                    log.debug("Passed expected unauthorized access failure: " + e.getMessage());
                }
                finally {
                    Conversation.instance().end();
                }
            }
        }.run();
    }

    @Test
    public void persistWithMissingRequiredFieldValue() throws Exception {
        new FacesRequest("/view/example/MovieEdit.xhtml") {
            @Override
            protected void invokeApplication() throws Exception {
                Conversation.instance().begin();
                assert !isSessionInvalid() : "Invalid session";
                assert mockLogin() : "Login failed";
                invokeMethod("#{movieHome.clearInstance}");
                setValue("#{movieHome.instance.director}", DIRECTOR_JOEL_COEN);
                setValue("#{movieHome.instance.year}",     THE_BIG_LEBOWSKI_YEAR);
                // The title field value is missing

                try {
                    invokeMethod( "#{movieHome.persist}" );
                    assert false : "Movie with missing field value persisted!";
                }
                catch (javax.el.ELException e) {
                    assert e.getCause() instanceof javax.persistence.PersistenceException :
                        "Expected to fail with: 'javax.persistence.PersistenceException'";

                    log.debug("Passed expected missing required field value failure: " + e.getMessage());
                }
                finally {
                    Conversation.instance().end();
                }
            }
        }.run();
    }

    @Test
    public void duplicateUniqueSecondaryIndex() throws Exception {
        new FacesRequest("/view/example/MovieEdit.xhtml") {
            @Override
            protected void invokeApplication() throws Exception {
                Conversation.instance().begin();
                assert !isSessionInvalid() : "Invalid session";
                assert mockLogin() : "Login failed";
                invokeMethod("#{movieHome.clearInstance}");
                setValue("#{movieHome.instance.director}", DIRECTOR_JOEL_COEN);
                setValue("#{movieHome.instance.title}",    THE_BIG_LEBOWSKI_TITLE);
                setValue("#{movieHome.instance.year}",     THE_BIG_LEBOWSKI_YEAR);
                // The title field value must be unique

                try {
                    invokeMethod( "#{movieHome.persist}" );
                    assert false : "Expected to persist a movie with a duplicate unique secondary index!";
                }
                catch (javax.el.ELException e) {
                    assert e.getCause() instanceof javax.persistence.PersistenceException :
                        "Expected to fail with: 'javax.persistence.PersistenceException'";

                    log.debug("Passed expected duplicate unique secondary index failure: " + e.getMessage());
                }
                finally {
                    Conversation.instance().end();
                }
            }
        }.run();
    }

    @Test
    public void deleteMovie() throws Exception {
        new FacesRequest("/view/example/MovieEdit.xhtml") {
            @Override
            protected void invokeApplication() throws Exception {
                Conversation.instance().begin();
                assert !isSessionInvalid() : "Invalid session";
                assert mockLogin() : "Login failed";
                setValue("#{movieHome.movieId}", reservoirDogsId);
                invokeMethod( "#{movieHome.wire}" );
                Assert.assertEquals(invokeMethod( "#{movieHome.remove}" ), "removed", "#{movieHome.remove}");
                Conversation.instance().end();
            }
        }.run();
    }

    @Test
    public void findMoviesDirectedByJoelCoen() throws Exception {

        new FacesRequest("/view/example/MovieList.xhtml") {
            @Override
            protected void updateModelValues() throws Exception {
                setValue("#{movieList.movie.director}", DIRECTOR_JOEL_COEN);
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void renderResponse() throws Exception {
                List<Movie> list= (List<Movie>) invokeMethod( "#{movieList.getResultList()}" );
                Assert.assertEquals(list.size(), 2, "#{movieList.getResultList()}");
                Movie movie = list.get(0);
                Assert.assertEquals(movie.getDirector(), DIRECTOR_JOEL_COEN, "movie.getDirector()");
            }
        }.run();
    }
     */
}
