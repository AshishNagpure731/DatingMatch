package com.mat.now.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mat.now.userentity.Userentity;

@Repository
public interface UserRepository extends MongoRepository <Userentity,String>{
	
}
