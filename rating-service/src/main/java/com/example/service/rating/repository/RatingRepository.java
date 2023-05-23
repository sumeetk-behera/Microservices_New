package com.example.service.rating.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.service.rating.entity.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

	 
//	@Query(value = "{ '_id' : { '$exists' : true }}", sort = "{ '_id' : -1 }")
//	@Query(value = "Criteria.where(\"_id\").exists(true)).limit(1)")  2nd option of @query
//	Rating findTopByOrderByIdDesc();
//	default Integer getNextId() {
//		Rating lastUser = findTopByOrderByIdDesc();
//		if (lastUser == null) {
//			return 1;
//		}
//		return lastUser.getId() + 1;
//	}

//	@Query("{ '_id' : { $exists: true }}")
	List<Rating> findByUser(Integer userId);

//	@Query("{ '_id' : { $exists: true }}")
	List<Rating> findByHotel(Integer hotelId);

}
