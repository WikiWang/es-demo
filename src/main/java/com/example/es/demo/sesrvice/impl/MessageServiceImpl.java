package com.example.es.demo.sesrvice.impl;

import com.example.es.demo.domain.Message;
import com.example.es.demo.exception.error.ErrorDefine;
import com.example.es.demo.exception.NotFoundException;
import com.example.es.demo.repository.MessageRepository;
import com.example.es.demo.sesrvice.MessageService;
import com.google.common.collect.Lists;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * ClassName: MessageServiceImpl
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-13 17:15
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public void addMessage(Message message) {
        if(message.getId() == null || message.getId().equals("")){
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            message.setId(uuid);
        }
        messageRepository.save(message);
    }

    @Override
    public Message deleteMessage(String id) throws NotFoundException {
        Optional<Message> message = messageRepository.findById(id);
        if(message == null){
            throw new NotFoundException(ErrorDefine.MESSAGE_NOT_FOUND_ERROR);
        }else{
            messageRepository.deleteById(id);
        }
        return message.get();
    }

    @Override
    public void deleteAll() {
        messageRepository.deleteAll();
    }

    @Override
    public Message getById(String id) throws NotFoundException {
        Optional<Message> message = messageRepository.findById(id);
        if(message == null){
            throw new NotFoundException(ErrorDefine.MESSAGE_NOT_FOUND_ERROR);
        }
        return message.get();
    }

    @Override
    public List<Message> search(String context, Integer page, Integer pageSize) {

        //按标题进行搜索
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", context);

        //如果实体和数据的名称对应就会自动封装. 分页查询
        Iterable<Message> listIt =  messageRepository.search(queryBuilder, PageRequest.of(page, pageSize));

        //Iterable转list
        List<Message> messageList= Lists.newArrayList(listIt);

        return messageList;
    }
}
