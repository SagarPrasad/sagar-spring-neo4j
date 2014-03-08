/**
 * 
 */
package org.sagar.neo4j.social.helper;

import org.sagar.neo4j.social.Add;
import org.sagar.neo4j.social.Redeem;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author spras3
 *
 */
public interface UserService {
	
	@Transactional
	Add addOffers(String userId, String offer, long time);
	
	@Transactional
	Redeem redeemOffers(String userId, String offer, long time);
	
	@Transactional
	Boolean addFriends(String userId, String friendId);
	
}
