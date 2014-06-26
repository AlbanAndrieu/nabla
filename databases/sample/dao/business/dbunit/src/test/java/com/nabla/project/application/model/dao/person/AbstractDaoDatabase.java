package com.nabla.project.application.model.dao.person;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class AbstractDaoDatabase extends AbstractTransactionalDataSourceSpringContextTests
{
    public static Logger  logger         = Logger.getLogger(AbstractDaoDatabase.class);

    private static String TEST_DATA_FILE = "dbunit-test-data.xml";

    @Override
    protected String[] getConfigLocations()
    {
        return new String[]
        { "/spring-test-config.xml" };
    }

    private static ConfigurableApplicationContext factory;
    private final String[]                        TABLES =
                                                         { "PERSONACTIVITY", "ACTIVITY", "PERSON", "ADDRESS" };

    // This method is used to perform any setup operations, such as
    // populating a database table, within the transaction.
    @Override
    protected void onSetUpInTransaction() throws Exception
    {
        // super.onSetUpInTransaction();

        if (AbstractDaoDatabase.factory == null)
        {
            AbstractDaoDatabase.factory = new ClassPathXmlApplicationContext(this.getConfigLocations());
        }

        // Use spring to get the datasource
        final DataSource ds = this.jdbcTemplate.getDataSource();
        final Connection con = DataSourceUtils.getConnection(ds);
        final IDatabaseConnection dbUnitCon = new DatabaseConnection(con);
        final IDataSet dataSet = new FlatXmlDataSet(Thread.currentThread().getContextClassLoader().getResourceAsStream(AbstractDaoDatabase.TEST_DATA_FILE));

        // delete table entries
        // For previous dataset in NGTest
        this.deleteFromTables(this.TABLES);

        try
        {
            AbstractDaoDatabase.logger.info("*** Inserting test data ***");
            // DatabaseOperation.CLEAN_INSERT.execute(dbUnitCon, dataSet);
            DatabaseOperation.INSERT.execute(dbUnitCon, dataSet);
        } finally
        {
            DataSourceUtils.releaseConnection(con, ds);
            AbstractDaoDatabase.logger.info("*** Finished inserting test data ***");
        }

    }

    @Override
    protected void onTearDownAfterTransaction() throws Exception
    {

        // Delete the data
        final DataSource ds = this.jdbcTemplate.getDataSource();
        final Connection con = DataSourceUtils.getConnection(ds);

        final IDatabaseConnection dbUnitCon = new DatabaseConnection(con);
        final IDataSet dataSet = new FlatXmlDataSet(Thread.currentThread().getContextClassLoader().getResourceAsStream(AbstractDaoDatabase.TEST_DATA_FILE));

        try
        {
            DatabaseOperation.DELETE.execute(dbUnitCon, dataSet);

        } finally
        {
            DataSourceUtils.releaseConnection(con, ds);
            AbstractDaoDatabase.logger.info("*** Finished removing test data ***");
        }

        // Commit or rollback the transaction
        this.endTransaction();

    }
}
