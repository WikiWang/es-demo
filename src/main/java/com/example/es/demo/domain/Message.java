package com.example.es.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * ClassName: Message
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-10 14:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "message_info", type = "doc")
public class Message {

    @Id
    private String id;
    private String title;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
