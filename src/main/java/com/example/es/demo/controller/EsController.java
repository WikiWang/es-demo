package com.example.es.demo.controller;

import com.example.es.demo.domain.Message;
import com.example.es.demo.sesrvice.MessageService;
import com.example.es.demo.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: EsController
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-13 17:00
 */
@RestController
public class EsController {

    @Autowired
    MessageService messageService;

    private static final String URL = "/es/api/v1/message";

    private static final Logger LOGGER = LoggerFactory.getLogger(EsController.class);

    /**
     * 新增/修改 索引
     * 当 id 存在的时候, 此方法是修改(当然, 我这里用的 uuid, 不会存在的), 如果 id 不存在, 则是新增
     */
    @RequestMapping(value = URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Message> addMessage(@RequestBody String body) throws Exception {
        LOGGER.info("receive message to create: " + body);
        Message message = JsonUtil.jsonToObject(Message.class, body);
        messageService.addMessage(message);
        LOGGER.info("create message success");
        return new ResponseEntity<Message>(message, HttpStatus.CREATED);
    }

    /**
     * 根据id删除索引
     */
    @RequestMapping(value = URL+"/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Message> delete(@PathVariable String id) throws Exception {
        Message message = messageService.deleteMessage(id);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    /**
     * 删除所有的索引
     * @return
     */
    @RequestMapping(value = URL, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> deleteAll() throws Exception {
        messageService.deleteAll();
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    /**
     * 根据id查询索引
     * @return
     * @throws Exception
     */
    @RequestMapping(value = URL+"/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Message>  getById(@PathVariable String id) throws Exception {
        Message message = messageService.getById(id);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    /**
     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
     * @return
     */
    @RequestMapping(value = URL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List> search(@RequestParam(required = true) String context,
                                       @RequestParam(required = false, defaultValue = "0") Integer page,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws Exception{
        List<Message> resutl = messageService.search(context, page, pageSize);
        return new ResponseEntity<List>(resutl, HttpStatus.OK);
    }
}
