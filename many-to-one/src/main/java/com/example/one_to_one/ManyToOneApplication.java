package com.example.one_to_one;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class ManyToOneApplication {

    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    public static void main(String[] args){
        SpringApplication.run(ManyToOneApplication.class);


    }
    @Bean
    public CommandLineRunner commandLineRunner(){
        return  args-> {
          // oneWayBinding();

           //Inverse side
            Teacher newTeacher= Teacher.builder().teacherName("Deepak").build();

            Subject subject1= Subject.builder().subjectName("HTML").teacher(newTeacher).build();
            Subject subject2= Subject.builder().subjectName("CSS").teacher(newTeacher).build();
            Subject subject3= Subject.builder().subjectName("JAVAScript").teacher(newTeacher).build();

newTeacher.setSubjects(List.of(subject1, subject2, subject3));

//          teacherRepository.save(newTeacher);
//update
          Teacher teacherWithId =  teacherRepository.findById(2).orElseThrow();
          teacherWithId.setTeacherName("");
         Subject subjectWithId= teacherWithId.getSubjects(List.of(subject1, subject2, subject3));
         subjectWithId.setSubjects(List.of(""));
            //delete

            //Extract
//            teacherRepository.findById(1)
//                    .orElseThrow()
//                    .getSubjects()
//                    .forEach(sub->{
//                        System.out.println(sub.getTeacher().getTeacherName()+"\t->\t"+sub.getSubjectName());
//                    });




        };
    }
    private void oneWayBinding(){
        //owning side
        //save
         Teacher teacher = Teacher.builder().teacherName("Amit").build();

         Subject subject1= Subject.builder().subjectName("C").teacher(teacher).build();
        Subject subject2= Subject.builder().subjectName("C++").teacher(teacher).build();
        Subject subject3= Subject.builder().subjectName("JAVA").teacher(teacher).build();

        // subjectRepository.saveAll(List.of(subject1, subject2, subject3));

        //update
//       Subject existingSubject= subjectRepository.findById(1).orElseThrow();
//       existingSubject.setSubjectName("Machine Learning");
//     Teacher existingTeacher= existingSubject.getTeacher();
//     existingTeacher.setTeacherName("Deepak");
//     subjectRepository.save(existingSubject);
        //delete
//        subjectRepository.deleteById(3);
        //Extract
//        subjectRepository.findAll().forEach(( sub)->{
//            System.out.println(sub.getSubjectName() + "\t->\t"+ sub.getTeacher().getTeacherName());
//        });

    }
}
