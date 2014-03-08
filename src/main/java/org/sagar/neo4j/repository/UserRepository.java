package org.sagar.neo4j.repository;

import org.sagar.neo4j.social.User;
import org.sagar.neo4j.social.helper.UserService;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface UserRepository extends GraphRepository<User>,UserService {
	User findByUserId(String userId);
	Iterable<User> findByFriendsUserId(String userId);
}
