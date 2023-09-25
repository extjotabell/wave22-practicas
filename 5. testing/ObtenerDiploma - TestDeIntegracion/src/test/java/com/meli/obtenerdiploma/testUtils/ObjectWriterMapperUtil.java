package com.meli.obtenerdiploma.testUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;

public class ObjectWriterMapperUtil {

    public static String convertJsonPayload(Object object) throws Exception
    {
        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,
                        false).
                writer();
        return mapper.writeValueAsString(object);
    }

}
