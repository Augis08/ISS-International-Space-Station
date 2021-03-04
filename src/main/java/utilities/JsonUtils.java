package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    /***
     *
     * JSON utility method class
     * @author Ignas Ivoska
     *
     */

        /**
         * Utility class - constructor is private so no instance of this class is created anywhere - we only need to call the static methods
         */
        private JsonUtils() {
        }

        /**
         * Parses a java object into it's JSON representation
         * @param object the object we desire to convert
         * @return json representation
         * @throws JsonProcessingException if parsing fails
         */
        public static String toJson(Object object) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        }

        /**
         * Parses a JSON representation into a Java object instance
         * @param json json representation
         * @param clazz type which we want the JSON representation to be converted to
         * @param <T> generics
         * @return instance of the Class we pass, e.g. Person.class in second parameter will make this method return an instance of Person
         * @throws JsonProcessingException if parsing from JSON fails
         */
        public static <T> T fromJson(String json, Class<T> clazz) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, clazz);
        }

    }

