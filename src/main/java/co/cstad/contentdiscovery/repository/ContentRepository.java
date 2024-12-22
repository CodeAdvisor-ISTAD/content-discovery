package co.cstad.contentdiscovery.repository;

import co.cstad.contentdiscovery.domain.Content;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ContentRepository extends MongoRepository<Content, String> {
    List<Content> findTop10ByOrderByTrendingScoreDesc();

    List<Content> findByIsFeaturedTrue();

    List<Content> findByTagsIn(List<String> tags);

    List<Content> findTop10ByOrderByCreatedAtDesc();

    @Query("{ 'tags' : { $in: ?0 } }")
    List<Content> findRecommendedPosts(List<String> userInterests);
}