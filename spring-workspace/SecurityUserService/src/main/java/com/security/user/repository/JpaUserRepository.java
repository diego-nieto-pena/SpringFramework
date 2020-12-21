package com.security.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.security.commons.entity.User;

@RepositoryRestResource(path="user-repo")
public interface JpaUserRepository extends PagingAndSortingRepository<User, Long> {

	@RestResource(path="get-by-username")
	public User findByUserName(@Param("username") String userName);
	
	
	/*@Query("select u from User u where u.userName = ?1 and u.email = ?2")
	public User getUserByUserNameAndEmail(String userName, String email);
	
	
	@Query(value="select * from user where user_name = ?1", nativeQuery = true)
	public User getUserByUserNameNative(String userName);*/
}
