package com.min.apiserver.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;

    @Column(length = 500, nullable = false)
    private String title;

    private String content;

    private boolean complete;

    private LocalDate dueDate;

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeComplete(boolean complete) {
        this.complete = complete;
    }

    public void changeDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void changeContent(String content) {
        this.content = content;
    }
}
