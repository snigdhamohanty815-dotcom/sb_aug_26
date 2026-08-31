package com.jt.intro_to_rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@RestController
// @Controller
// @ResponseBody
public class StudentController {
    private ObjectMapper mapper;

public StudentController(ObjectMapper mapper){
    this.mapper= mapper;

}

   @RequestMapping(value ="/student", method = RequestMethod.GET  ) 
   //@ResponseBody // it tells springBoot to return a json object instead of a view file
   public Student getStudent(){
    //    return new Student(101,"Snigdha",new String[]{"java","python"});
        Student student = new Student(101,"Snigdha",new String[]{"java","python"});
         System.out.println("////"+student);
         return student;
      
   }
   @RequestMapping("/student1")
   public void convertjavaObjectToJSON() throws JacksonException{
    Student student = new Student(101,"Snigdha",new String[]{"java","python"});

    String json = mapper.writeValueAsString(student);
    System.out.println("json value is"+json);
   }

   @RequestMapping("/student2")
   public void convertjavaObjToJSON() throws JacksonException{
    String json ="""
            {
    "id": 102,
    "name": "Snigdha",
    "courses": ["c", "c++"]
    }
            """;
            Student student= mapper.readValue(json, Student.class);
            System.out.println("After converting from json to java Object"+ student);
   }


   @RequestMapping("/fruits")
   
   public List<String> getStrings(){
    return List.of("Apple","Mango","Grapes");
   }
}
