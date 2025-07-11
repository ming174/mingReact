package com.min.apiserver.service;

import com.min.apiserver.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoServiceTests {

    @Autowired
    TodoService todoService;

    @Test
    public void testGet() {

        Long tno = 50L;
        log.info(todoService.get(tno));

    }

    @Test
    public void testRegister() {

        TodoDTO todoDTO = TodoDTO.builder()
                .title("title....")
                .content("content...")
//                .dueDate(LocalDate.of())
                .build();


    }

}
