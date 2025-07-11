package com.min.apiserver.service;

import com.min.apiserver.domain.Todo;
import com.min.apiserver.dto.PageResponseDTO;
import com.min.apiserver.dto.TodoDTO;
import com.min.apiserver.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServieImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoDTO get(Long tno) {

        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();

        return entityToDTO(todo);
    }

    @Override
    public Long register(TodoDTO dto) {

        Todo todo   = dtoToEntity(dto);
        Todo result =todoRepository.save(todo);

        return result.getTno();
    }

    @Override
    public void modify(TodoDTO dto) {

        Optional<Todo> result = todoRepository.findById(dto.getTno());

        Todo todo = result.orElseThrow();

        todo.changeTitle(dto.getTitle());
        todo.changeContent(dto.getContent());
        todo.changeComplete(dto.isComplete());
        todo.changeDueDate(dto.getDueDate());

        todoRepository.save(todo);

    }

    @Override
    public void remove(Long tno) {
        todoRepository.deleteById(tno);
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageResponseDTO pageResponseDTO) {

        //JPA


        return null;
    }

}
