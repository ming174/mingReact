package com.min.apiserver.repository.search;

import com.min.apiserver.domain.Todo;
import com.min.apiserver.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface TodoSearch {

    Page<Todo> search1(PageRequestDTO pageRequestDTO);

}
