package my;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Json {

    public Json(){

    }
    public void writeToFileJson(File file, List<Patient> patients){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file,patients);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Patient> readFromFileJson(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Patient> patients = objectMapper.readValue(file, new TypeReference<>(){});
            return patients;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
