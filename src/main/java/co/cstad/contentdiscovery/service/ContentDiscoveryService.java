package co.cstad.contentdiscovery.service;

import co.cstad.contentdiscovery.domain.Content;
import co.cstad.contentdiscovery.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ContentDiscoveryService {
    @Autowired
    private ContentRepository contentRepository;

    public List<Content> getTrendingPosts() {
        return contentRepository.findTop10ByOrderByTrendingScoreDesc();
    }
    public Content createContent(Content content) {
        return contentRepository.save(content);
    }

    public List<Content> getFeaturedArticles() {
        return contentRepository.findByIsFeaturedTrue();
    }

    public List<Content> getPostsByTags(List<String> tags) {
        return contentRepository.findByTagsIn(tags);
    }

    public List<Content> getLatestPosts() {
        return contentRepository.findTop10ByOrderByCreatedAtDesc();
    }

    public List<Content> getRecommendedPosts(List<String> userInterests) {
        return contentRepository.findRecommendedPosts(userInterests);
    }
}
