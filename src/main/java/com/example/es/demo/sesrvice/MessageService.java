package com.example.es.demo.sesrvice;


import com.example.es.demo.domain.Message;
import com.example.es.demo.exception.NotFoundException;

import java.util.List;

/**
 * ClassName: MessageService
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-13 17:12
 */
public interface MessageService {

    void addMessage(Message message);

    Message deleteMessage(String id) throws NotFoundException;

    void deleteAll();

    Message getById(String id) throws NotFoundException;

    List<Message> search(String context, Integer pageStart, Integer pageSize);
}
