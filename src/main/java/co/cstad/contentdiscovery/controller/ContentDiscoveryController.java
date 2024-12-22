package co.cstad.contentdiscovery.controller;

import co.cstad.contentdiscovery.domain.Content;
import co.cstad.contentdiscovery.service.ContentDiscoveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/content")
public class ContentDiscoveryController {

    private final ContentDiscoveryService contentDiscoveryService;

    @PostMapping
    public Content createContent(@RequestBody Content content) {
        return contentDiscoveryService.createContent(content);
    }
    @GetMapping("/trending")
    public List<Content> getTrendingPosts() {
        return contentDiscoveryService.getTrendingPosts();
    }


    @GetMapping("/featured")
    public List<Content> getFeaturedArticles() {
        return contentDiscoveryService.getFeaturedArticles();
    }

    @GetMapping("/by-tags")
    public List<Content> getPostsByTags(@RequestParam List<String> tags) {
        return contentDiscoveryService.getPostsByTags(tags);
    }

    @GetMapping("/latest")
    public List<Content> getLatestPosts() {
        return contentDiscoveryService.getLatestPosts();
    }

    @GetMapping("/recommended")
    public List<Content> getRecommendedPosts(@RequestParam List<String> userInterests) {
        return contentDiscoveryService.getRecommendedPosts(userInterests);
    }
}

