package com.min.apiserver.repository;

import com.min.apiserver.domain.Todo;
import com.min.apiserver.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {


}
