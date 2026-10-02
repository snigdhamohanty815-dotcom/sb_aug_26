package com.example.one_to_one;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentRoll;

    private String studentName;

    private String studentEmail;
    //@OneToOne(cascade ={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
   // @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)//here only the student data will be extracted by using lazy type
//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)//here both the student data and adress data will be extracted by using lazy type
    @OneToOne(cascade = CascadeType.ALL)// Bydefault it generates the eager internally
    @JoinColumn(name = "adress_id")
    private Adress adress;
}
