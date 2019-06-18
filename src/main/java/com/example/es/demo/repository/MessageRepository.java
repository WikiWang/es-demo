package com.example.es.demo.repository;

import com.example.es.demo.domain.Message;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * ClassName: MessageRepository
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-18 10:55
 */
@Component
public interface MessageRepository extends ElasticsearchRepository<Message, String> {

}
