/**
 * 
 */
package org.sagar.neo4j.repository;

import org.sagar.neo4j.social.Add;
import org.sagar.neo4j.social.Offer;
import org.sagar.neo4j.social.Redeem;
import org.sagar.neo4j.social.User;
import org.sagar.neo4j.social.helper.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author spras3
 *
 */
public class UserRepositoryImpl implements UserService {

	@Autowired
    private Neo4jOperations template;
	
	
	@Transactional
	public Add addOffers(String userId, String offerId, long time) {
    	User user = findByUserId(userId);
    	Offer offer = findByOfferId(offerId);
    	return user.addOffers(template, offer, 1L);
	}

    @Transactional
	public Redeem redeemOffers(String userId, String offerId, long time) {
    	User user = findByUserId(userId);
    	Offer offer = findByOfferId(offerId);
    	return user.redeemOffers(template, offer, 1L);
	}

    @Transactional
	public Boolean addFriends(String userId, String friendId) {
    	User user = findByUserId(userId);
    	User friend = findByUserId(friendId);
    	if(null != user && null != friend) {
    		user.addFriends(friend);
    		template.save(user);
    		return true;
    	}else{
    		return false;
    	}
	}

    private User findByUserId(String userId) {
        return template.lookup(User.class,"userId",userId).to(User.class).singleOrNull();
    }
    
    private Offer findByOfferId(String offerId) {
        return template.lookup(Offer.class,"offerId",offerId).to(Offer.class).singleOrNull();
    }
}
