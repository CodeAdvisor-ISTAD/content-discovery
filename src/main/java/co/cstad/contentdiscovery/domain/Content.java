package co.cstad.contentdiscovery.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "contents")
public class Content {
    @Id
    private String id;
    private String title;
    private String content;
    private String author;
    private List<String> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long viewCount;
    private long likeCount;
    private long commentCount;
    private boolean isFeatured;
    private double trendingScore;

}
