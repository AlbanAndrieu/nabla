// license-header java merge-point
// Generated by: hibernate/H2.java.vsl in andromda-spring-cartridge.
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package org.andromda.dbtest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Utility class to start H2 database, run SQL, and stop H2 database.
 * Use this to run Unit Tests inside an IDE, since this same functionality runs
 * as part of the maven project configuration
 */
public class H2
{
    private static Logger LOGGER = LogManager.getLogger(H2.class);
    /**
     *
     */
    public H2()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * Example values when run as a Java class - modify to match your local configuration.
     * @param args
     */
    public static void main(String[] args)
    {
        // Using Embedded H2 database with multiple connections, starting a TCP instance
        initDb("jdbc:h2:~/timetracker-gui;AUTO_SERVER=TRUE;AUTO_RECONNECT=TRUE;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1", null);
            // "C:/Workspaces/A34/andromda342/andromda-documentation/samples/timetracker/core/src/test/scripts/DB drop script.sql;C:/Workspaces/A34/andromda342/andromda-documentation/samples/timetracker/core/src/test/scripts/DB create script.sql");
            // ;C:/Workspaces/A34/andromda342/andromda-documentation/samples/timetracker/core/src/test/scripts/DB insert script.sql");
    }

    /**
     * @param url
     * @param sqlFile
     */
    public static void initDb(String url, String sqlFile) //throws SQLException, ClassNotFoundException
    {
        long now = System.currentTimeMillis();
        try
        {
            Class.forName("org.h2.Driver");
            // IF there are any errors in SQL Files, the connection throws an Exception
            List<String> sqls = new ArrayList<String>();
            if (StringUtils.isNotBlank(sqlFile))
            {
                // List of files separated by ; will be appended to URL and executed
                String[] files = StringUtils.split(sqlFile, ';');
                // Files contain SQL statements separated by ;
                if (files.length > 0)
                {
                    for (int i=0; i<files.length; i++)
                    {
                        LOGGER.info("Parsing SQL file " + files[i]);
                        sqls.addAll(fileToStrings(files[i], ';'));
                        /*if (i==0)
                        {
                            url += ";INIT=";
                        }
                        else
                        {
                            // Separator for multiple files in the same init command
                            url += "\\;";
                        }
                        url += "RUNSCRIPT FROM '" + files[i] + "'";*/
                    }
                }
            }
            // Starts H2, allowing TCP connections also, to jdbc:h2:tcp://localhost/${sql.database}
            // Must use id/password with embedded persisted mode
            Connection conn = DriverManager.getConnection(url, "sa", "sa");
            LOGGER.info("Connected to DB " + url + "\r in " + (System.currentTimeMillis() - now) + " ms");
            long now1 = System.currentTimeMillis();
            Statement stat = conn.createStatement();
            int stmtCount = 0;
            int successfulCount = 0;
            for (String sql : sqls)
            {
                if (StringUtils.isNotBlank(sql))
                {
                    stmtCount++;
                    boolean resultSet = false;
                    try
                    {
                        resultSet = stat.execute(sql);
                        if (resultSet)
                        {
                            ResultSet rset = stat.getResultSet();
                            LOGGER.info(sql + ";\r" + "ResultSet: " + rset + "\r");
                            try
                            {
                                rset.close();
                            }
                            catch (Exception e)
                            {
                                LOGGER.error(e);
                            }
                        }
                        else if (stat.getUpdateCount() > 0)
                        {
                            LOGGER.info(sql + ";\r" + "Updated rows: " + stat.getUpdateCount() + "\r");
                        }
                        else if (StringUtils.containsIgnoreCase(sql, "INSERT INTO ") ||
                                StringUtils.containsIgnoreCase(sql, "UPDATE ") ||
                                StringUtils.containsIgnoreCase(sql, "DELETE "))
                        {
                            LOGGER.info(sql + ";\rExecuted Successfully, no update or result\r");
                        }
                        else
                        {
                            LOGGER.info(sql + ";\rExecuted Successfully\r");
                        }
                        successfulCount++;
                    }
                    catch (SQLException e)
                    {
                        LOGGER.error(e);
                    }
                }
            }
            LOGGER.info("Executed " + successfulCount + " out of " + stmtCount + " sql statements in "
                + (System.currentTimeMillis() - now1) + " ms, total time = "
                 + (System.currentTimeMillis() - now) + " ms");
            // Keep in-memory DB connection open after executing SQL statements
            int i =1;
            while (i>0)
            {
                // There is no Daemon option when starting DB through connection, just have to go into an infinite loop
            }
        }
        catch (IOException e)
        {
            LOGGER.error(e);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.error(e);
        }
        catch (SQLException e)
        {
            LOGGER.error(e);
        }
    }

    /**
     * Load a text file contents with SQL commands as a <code>List of Strings<code>.
     * This method does not perform encoding conversions
     *
     * @param fileName The input file location + name
     * @param delimiter The character delimiter used to separate statements within the file
     * @return The file contents as a <code>String</code>
     * @exception IOException IO Error
     */
    public static List<String> fileToStrings(String fileName, char delimiter) throws IOException
    {
        File file = new File(fileName);
        if (!file.exists())
        {
            LOGGER.error("File " + fileName + " does not exist");
            throw new FileNotFoundException("File " + fileName + " does not exist");
        }
        if (file.isDirectory())
        {
            // TODO FileUtils.listFiles(dir, fileFilter, dirFilter) with wildcards to create the list of files to be loaded
        }
        String contents = FileUtils.readFileToString(file);
        List<String> sqls = new ArrayList<String>();
        String[] contentArray = StringUtils.split(contents, delimiter);
        for (int i=0; i<contentArray.length; i++)
        {
            sqls.add(StringUtils.strip(contentArray[i]));
            //LOGGER.info(contentArray[i]);
        }
        return sqls;
    }
}