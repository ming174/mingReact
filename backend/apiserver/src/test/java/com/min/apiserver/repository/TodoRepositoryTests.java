package com.min.apiserver.repository;

import com.min.apiserver.domain.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void test1() {

        Assertions.assertNotNull(todoRepository);
        log.info(todoRepository.getClass().getName());

    }

    @Test
    public void testInsert() {

        Todo todo = Todo.builder()
                .title("Title")
                .content("Content..")
                .dueDate(LocalDate.of(2025,12,30))
                .build();

        Todo result = todoRepository.save(todo);
        log.info(result);
    }

    @Test
    public void testRead() {

        Long tno = 1L;

        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();

        log.info(todo);

    }

    @Test
    public void testUpdate() {

        // 1. 로딩 2. 엔티티 객체 변경 (setter사용)
        Long tno = 1L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        todo.changeTitle("Update Title");
        todo.changeContent("Updated content");
        todo.changeComplete(true);

        todoRepository.save(todo);

    }

    @Test
    public void testPaging() {

        //페이징 시작번호 0, tno번호 기준으로 내림차순
        Pageable pageable = PageRequest.of(0, 5, Sort.by("dueDate").descending());

        Page<Todo> result = todoRepository.findAll(pageable);

        log.info(result.getTotalElements());
        log.info(result.getContent()); // 전체 내용 List타입으로 나옴

    }



}
