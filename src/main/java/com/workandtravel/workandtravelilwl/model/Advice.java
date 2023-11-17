package com.workandtravel.workandtravelilwl.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private String Email;

    @ManyToOne
    @JoinColumn(name = "type_question_id")
    private TypeQuestion typeQuestion;
    private String message;
}
