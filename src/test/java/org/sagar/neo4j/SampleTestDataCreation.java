/**
 * 
 */
package org.sagar.neo4j;

import org.junit.Test;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.sagar.neo4j.repository.OfferRepository;
import org.sagar.neo4j.repository.UserRepository;
import org.sagar.neo4j.social.Add;
import org.sagar.neo4j.social.Offer;
import org.sagar.neo4j.social.Redeem;
import org.sagar.neo4j.social.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.neo4j.template.Neo4jOperations;

/**
 * @author A039883
 *
 */
public class SampleTestDataCreation extends ApplicationConfig{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        /*ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-data-context.xml");*/
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		UserRepository userRepository = (UserRepository)ctx.getBean(UserRepository.class);
		OfferRepository offerRepository = (OfferRepository)ctx.getBean(OfferRepository.class);
		GraphDatabaseService graphDBService = (GraphDatabaseService)ctx.getBean(GraphDatabaseService.class);
		Neo4jTemplate template = new Neo4jTemplate(graphDBService);
		testUserOfferRelation(userRepository, offerRepository,template);
		testXDBexists(userRepository, offerRepository);
		graphDBService.shutdown();
	}
	
	
	public static void testUserOfferRelation(UserRepository userRepository, OfferRepository offerRepository, Neo4jTemplate template){
		
		User user = userRepository.save(new User("U1","User 1"));
		//template.getNode(user.getId()).addLabel(DynamicLabel.label("User"));
		user = userRepository.save(new User("U2","User 2"));
		//template.getNode(user.getId()).addLabel(DynamicLabel.label("User"));
		user = userRepository.save(new User("U3","User 3"));
		//template.getNode(user.getId()).addLabel(DynamicLabel.label("User"));
		user = userRepository.save(new User("U4","User 4"));
		//template.getNode(user.getId()).addLabel(DynamicLabel.label("User"));
		user = userRepository.save(new User("U5","User 5"));
		//template.getNode(user.getId()).addLabel(DynamicLabel.label("User"));
		user = userRepository.save(new User("U6","User 6"));
		//template.getNode(user.getId()).addLabel(DynamicLabel.label("User"));
		user = userRepository.save(new User("U7","User 7"));
		//template.getNode(user.getId()).addLabel(DynamicLabel.label("User"));
		
	
		Offer offer = offerRepository.save(new Offer("O1","Offer 1"));
		//template.getNode(offer.getId()).addLabel(DynamicLabel.label("Offer"));
		offer = offerRepository.save(new Offer("O2","Offer 2"));
		//template.getNode(offer.getId()).addLabel(DynamicLabel.label("Offer"));
		offer = offerRepository.save(new Offer("O3","Offer 3"));
		//template.getNode(offer.getId()).addLabel(DynamicLabel.label("Offer"));
		offer = offerRepository.save(new Offer("O4","Offer 4"));
		//template.getNode(offer.getId()).addLabel(DynamicLabel.label("Offer"));
		offer = offerRepository.save(new Offer("O5","Offer 5"));
		//template.getNode(offer.getId()).addLabel(DynamicLabel.label("Offer"));
		offer = offerRepository.save(new Offer("O6","Offer 6"));
		//template.getNode(offer.getId()).addLabel(DynamicLabel.label("Offer"));
		offer = offerRepository.save(new Offer("O7","Offer 7"));
		//template.getNode(offer.getId()).addLabel(DynamicLabel.label("Offer"));
		offer = offerRepository.save(new Offer("O8","Offer 8"));
		//template.getNode(offer.getId()).addLabel(DynamicLabel.label("Offer"));
		
		System.out.println(userRepository.findByUserId("U1"));
		System.out.println(offerRepository.findByOfferId("O1"));
		
		userRepository.addFriends("U1", "U3");
		userRepository.addFriends("U1", "U4");
		userRepository.addFriends("U1", "U5");
		
		userRepository.addFriends("U2", "U3");
		userRepository.addFriends("U2", "U7");
		
		userRepository.addFriends("U4", "U1");
		userRepository.addFriends("U4", "U3");
		userRepository.addFriends("U4", "U5");
		
		userRepository.addFriends("U6", "U7");
		userRepository.addFriends("U6", "U5");
		
		
		userRepository.addOffers("U1", "O1", 1L);
		userRepository.addOffers("U1", "O2", 1L);
		userRepository.addOffers("U1", "O5", 1L);
		userRepository.addOffers("U1", "O7", 1L);
		
		userRepository.addOffers("U2", "O1", 1L);
		userRepository.addOffers("U2", "O2", 1L);
		userRepository.addOffers("U2", "O4", 1L);
		
		
		userRepository.addOffers("U3", "O5", 1L);
		userRepository.addOffers("U3", "O6", 1L);
		
		userRepository.addOffers("U4", "O4", 1L);
		userRepository.addOffers("U4", "O6", 1L);
		
		
		userRepository.redeemOffers("U1", "O3", 1L);
		userRepository.redeemOffers("U1", "O4", 1L);
		userRepository.redeemOffers("U1", "O5", 1L);
		
		userRepository.redeemOffers("U2", "O1", 1L);
		userRepository.redeemOffers("U2", "O5", 1L);
		
		userRepository.redeemOffers("U3", "O3", 1L);
		userRepository.redeemOffers("U3", "O4", 1L);
		userRepository.redeemOffers("U3", "O5", 1L);
		
		userRepository.redeemOffers("U4", "O1", 1L);
		userRepository.redeemOffers("U4", "O3", 1L);
		userRepository.redeemOffers("U4", "O4", 1L);
		userRepository.redeemOffers("U4", "O7", 1L);
		//printAddOffers(userRepository.findByUserId("U1"));
		
		
	}
	
	public static void testXDBexists(UserRepository userRepository, OfferRepository offerRepository){
		printAddOffers(userRepository.findByUserId("U1"));
		printRedeemOffers(userRepository.findByUserId("U1"));
		printFriends(userRepository.findByUserId("U1"));
		
		printOffersDetails(offerRepository.findByOfferId("O1"));
		printOffersDetails(offerRepository.findByOfferId("O3"));
	}
	
	
	private static void printAddOffers(User user) {
		System.out.println("User (Add Offer) --" + user.getUserName());
		for(Add addoffer : user.getAddOffers()) {
			System.out.println("-- Add Offer --" + addoffer.getOffer().getOfferTitle() + ":" + addoffer.getUser().getUserName());
		}
	}

	private static void printRedeemOffers(User user) {
		System.out.println("User (Redeem Offer) --" + user.getUserName());
		for(Redeem redemOffer : user.getRdmOffers()) {
			System.out.println("-- Redeem Offers --" + redemOffer.getOffer().getOfferTitle()+ ":" + redemOffer.getUser().getUserName());
		}
	}

	private static void printFriends(User user) {
		System.out.println("User (Friends) --" + user.getUserName());
		for(User friends : user.getFriends()) {
			System.out.println("-- Friends --" + friends.getUserName());
		}
	}
	
	private static void printOffersDetails(Offer offer) {
		System.out.println("Offer (Details) --" + offer.getOfferTitle());
		for(Add add : offer.getAdd()) {
			System.out.println("-- Add User --" + add.getUser().getUserName());
		}
		
		for(Redeem redeem : offer.getRedeem()) {
			System.out.println("-- Redeem User --" + redeem.getUser().getUserName());
		}
	}

}
