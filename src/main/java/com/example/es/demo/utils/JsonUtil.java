package com.example.es.demo.utils;

import com.example.es.demo.exception.SerializeRuntimeException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.Collection;

/**
 * ClassName: JsonUtil
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-18 11:00
 */
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    static{
        mapper.registerModule(new JavaTimeModule());
        //use iso-8601 date format
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        //ignore unknown properties
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JsonUtil() {
    }
    /**
     *  description: Serialize a object to json string.
     *  @param: [object]
     *  @return: java.lang.String
     *
     *  @author wk
     *  @date 2019-04-29 16:50
     */
    public static String objectToJson(Object object) {
        String result;
        try {
            result = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new SerializeRuntimeException(e);
        }
        return result;
    }

    /**
     *  description: Deserialize a string to a object.
     *  @param: [cls, serializedStr]
     *  @return: T
     *
     *  @author wk
     *  @date 2019-04-29 16:51
     */
    public static <T> T jsonToObject(Class<T> cls, String serializedStr){
        try {
            return mapper.readValue(serializedStr, cls);
        } catch (JsonParseException e) {
            throw new SerializeRuntimeException(e);
        } catch (JsonMappingException e) {
            throw new SerializeRuntimeException(e);
        } catch (IOException e) {
            throw new SerializeRuntimeException(e);
        }
    }

    /**
     *  description: deserialize a json string to a object list
     *  @param: [clsCollection, cls, serializedStr]
     *  @return: C
     *
     *  @author wk
     *  @date 2019-04-29 16:52
     */
    public static <T,C extends Collection> C jsonToList(Class<C> clsCollection, Class<T> cls, String serializedStr){
        try {
            return(C) mapper.readValue(serializedStr, mapper.getTypeFactory().constructCollectionType(clsCollection, cls));
        } catch (JsonParseException e) {
            throw new SerializeRuntimeException(e);
        } catch (JsonMappingException e) {
            throw new SerializeRuntimeException(e);
        } catch (IOException e) {
            throw new SerializeRuntimeException(e);
        }
    }

}
