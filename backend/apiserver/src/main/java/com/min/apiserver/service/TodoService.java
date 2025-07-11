package com.min.apiserver.service;

import com.min.apiserver.domain.Todo;
import com.min.apiserver.dto.PageResponseDTO;
import com.min.apiserver.dto.TodoDTO;

public interface TodoService {

    TodoDTO get(Long tno);
    Long register(TodoDTO dto);
    void modify(TodoDTO dto);
    void remove(Long tno);

    PageResponseDTO<TodoDTO> getList(PageResponseDTO pageResponseDTO);

    //entity > DTO
    default TodoDTO entityToDTO(Todo todo) {

        return TodoDTO.builder()
                        .tno(todo.getTno())
                        .title(todo.getTitle())
                        .content(todo.getContent())
                        .complete(todo.isComplete())
                        .dueDate(todo.getDueDate())
                        .build();

    }

    // DTO > entitiy
    default Todo dtoToEntity(TodoDTO todoDTO) {

        return Todo.builder()
                        .tno(todoDTO.getTno())
                        .title(todoDTO.getTitle())
                        .content(todoDTO.getContent())
                        .complete(todoDTO.isComplete())
                        .dueDate(todoDTO.getDueDate())
                        .build();

    }

}
