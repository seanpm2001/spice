/*
 * Copyright (C) The Spice Group. All rights reserved.
 *
 * This software is published under the terms of the Spice
 * Software License version 1.1, a copy of which has been included
 * with this distribution in the LICENSE.txt file.
 */
package org.realityforge.loggerstore;

import java.util.Properties;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.avalon.framework.logger.NullLogger;
import org.apache.avalon.framework.context.DefaultContext;

/**
 *  Test case for LoggerStore 
 *
 * @author <a href="mailto:mauro.talevi at aquilonia.org">Mauro Talevi</a>
 * @author <a href="mailto:peter at apache.org">Peter Donald</a>
 */
public class LoggerStoreTestCase
    extends AbstractTestCase
{

    public LoggerStoreTestCase( final String name )
    {
        super( name );
    }

    public void testNullRootLogger()
        throws Exception
    {
        final LoggerStore store = new MalformedLoggerStore();
        try
        {
            store.getLogger();
            fail( "Expected to get an exception as no root logger is defined." );
        }
        catch( final Exception e )
        {
        }
    }

    public void testConsoleLoggerStore()
        throws Exception
    {
        final LoggerStore store =
            new ConsoleLoggerStore( ConsoleLogger.LEVEL_DEBUG );
        performConsoleTest( store, ConsoleLogger.LEVEL_DEBUG );
    }

    public void testConsoleLoggerStoreNoDebug()
        throws Exception
    {
        final LoggerStore store =
            new ConsoleLoggerStore( ConsoleLogger.LEVEL_DEBUG );
        performConsoleTest( store, ConsoleLogger.LEVEL_DISABLED );
    }

 
    public void testJDK14Configuration()
        throws Exception
    {
        final LoggerStore store =
            new Jdk14LoggerStore( getResource( "logging.properties" ) );
        runLoggerTest( "jdk14", store, ConsoleLogger.LEVEL_DEBUG );
    }

    public void testJDK14ConfigurationNoDebug()
        throws Exception
    {
        final LoggerStore store =
            new Jdk14LoggerStore( getResource( "logging.properties" ) );
        runLoggerTest( "jdk14", store, ConsoleLogger.LEVEL_DISABLED );
    }

    public void testJDK14ConfigurationNoLog()
        throws Exception
    {
        final LoggerStore store =
            new Jdk14LoggerStore( getResource( "logging.properties" ) );
        runLoggerTest( "jdk14", store );
    }

    public void testLogKitConfiguration()
        throws Exception
    {
        final DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder();
        final LoggerStore store =
            new LogKitLoggerStore( null, null, builder.build( getResource( "logkit.xml" ) ) );
        runLoggerTest( "logkit", store, ConsoleLogger.LEVEL_DEBUG );
    }

    public void testLogKitConfigurationWithLogger()
        throws Exception
    {
        final DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder();
        final LoggerStore store =
            new LogKitLoggerStore( new NullLogger(), null, builder.build( getResource( "logkit.xml" ) ) );
        runLoggerTest( "logkit", store, ConsoleLogger.LEVEL_DEBUG );
    }

    public void testLogKitConfigurationWithContext()
        throws Exception
    {
        final DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder();
        final LoggerStore store =
            new LogKitLoggerStore( null, new DefaultContext(), builder.build( getResource( "logkit.xml" ) ) );
        runLoggerTest( "logkit", store, ConsoleLogger.LEVEL_DEBUG );
    }

    public void testLogKitConfigurationNoDebug()
        throws Exception
    {
        final DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder();
        final LoggerStore store =
            new LogKitLoggerStore( null, null, builder.build( getResource( "logkit.xml" ) ) );
        runLoggerTest( "logkit", store, ConsoleLogger.LEVEL_DISABLED );
    }

    public void testLogKitConfigurationNoLog()
        throws Exception
    {
        final DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder();
        final LoggerStore store =
            new LogKitLoggerStore( null, null, builder.build( getResource( "logkit.xml" ) ) );
        runLoggerTest( "logkit", store );
    }

  
    public void testLog4JElementConfiguration()
        throws Exception
    {
        final LoggerStore store =
            new Log4JLoggerStore( buildElement( getResource( "log4j.xml" ),
                                                new org.apache.log4j.xml.Log4jEntityResolver(), null ) );
        runLoggerTest( "log4j-xml", store, ConsoleLogger.LEVEL_DEBUG );
    }

    public void testLog4JElementConfigurationNoDebug()
        throws Exception
    {
        final LoggerStore store =
            new Log4JLoggerStore( buildElement( getResource( "log4j.xml" ),
                                                new org.apache.log4j.xml.Log4jEntityResolver(), null ) );
        runLoggerTest( "log4j-xml", store, ConsoleLogger.LEVEL_DISABLED );
    }

    public void testLog4JElementConfigurationNoLog()
        throws Exception
    {
        final LoggerStore store =
            new Log4JLoggerStore( buildElement( getResource( "log4j.xml" ),
                                                new org.apache.log4j.xml.Log4jEntityResolver(), null ) );
        runLoggerTest( "log4j-xml", store );
    }

    public void testLog4JInputStreamConfiguration()
        throws Exception
    {
        final LoggerStore store =
            new Log4JLoggerStore( getResource( "log4j.xml" ) );
        runLoggerTest( "log4j-xml", store, ConsoleLogger.LEVEL_DEBUG );
    }

    public void testLog4JInputStreamConfigurationNoDebug()
        throws Exception
    {
        final LoggerStore store =
            new Log4JLoggerStore( getResource( "log4j.xml" ) );
        runLoggerTest( "log4j-xml", store, ConsoleLogger.LEVEL_DISABLED );
    }

    public void testLog4JInputStreamConfigurationNoLog()
        throws Exception
    {
        final LoggerStore store =
            new Log4JLoggerStore( getResource( "log4j.xml" ) );
        runLoggerTest( "log4j-xml", store );
    }

    public void testLog4JPropertiesConfiguration()
        throws Exception
    {
        final Properties properties = new Properties();
        properties.load( getResource( "log4j.properties" ) );
        final LoggerStore store =
            new Log4JLoggerStore( properties );
        runLoggerTest( "log4j-properties", store, ConsoleLogger.LEVEL_DEBUG );
    }

    public void testLog4JPropertiesConfigurationNoDebug()
        throws Exception
    {
        final Properties properties = new Properties();
        properties.load( getResource( "log4j.properties" ) );
        final LoggerStore store =
            new Log4JLoggerStore( properties );
        runLoggerTest( "log4j-properties", store, ConsoleLogger.LEVEL_DISABLED );
    }

    public void testLog4JPropertiesConfigurationNoLog()
        throws Exception
    {
        final Properties properties = new Properties();
        properties.load( getResource( "log4j.properties" ) );
        final LoggerStore store =
            new Log4JLoggerStore( properties );
        runLoggerTest( "log4j-properties", store );
    }


}
