package org.sagar.neo4j;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Sagar
 */
@Configuration
@EnableTransactionManagement
//@EnableNeo4jRepositories(basePackages = "org.sagar.neo4j")
@ImportResource("classpath:META-INF/spring/test-data-context.xml")
public class TestApplicationConfig {
  
   @Bean(destroyMethod = "shutdown")
   @Scope(SCOPE_SINGLETON)
   public GraphDatabaseService graphDatabaseService() {
	    System.out.println("**************************CREATING DB**************************"); 
    	GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( "target/test-db" );
    	registerShutdownHook( graphDb );
    	System.out.println("**************************REGISTED SHUT HOOK**************************");
    	return graphDb;
    }
   
   private static void registerShutdownHook( final GraphDatabaseService graphDb )
   {
       Runtime.getRuntime().addShutdownHook( new Thread()
       {
           @Override
           public void run()
           {
        	   System.out.println("**************************SHUTTING DOWN DB**************************");
               graphDb.shutdown();
           }
       } );
   }
}
