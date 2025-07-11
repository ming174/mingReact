package com.min.apiserver.dto;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResponseDTO<E> {

    private List<E> dtoList;
    private List<Integer> pageNumList;
    private PageRequestDTO pageRequestDTO;
    private boolean prev, next;
    private int totalCount, prevPage, nextPage, totalPage, current;


    public PageResponseDTO(List<E> dtoList, PageRequestDTO pageRequestDTO, long total) {

         this.dtoList = dtoList;
         this.pageRequestDTO = pageRequestDTO;
         this.totalPage = (int) total;

         // 끝페이지 end
        int end = (int) (Math.ceil(pageRequestDTO.getPage() / 10.0)) * 10;

        // 시작페이지
        int start = end - 9;

        // 가장 마지막 페이지
        int lastPage = (int)(Math.ceil(totalCount / (double) pageRequestDTO.getSize()));


        end = end > lastPage ? lastPage : end;

        this.prev = start > 1;
        this.next = totalCount > end * pageRequestDTO.getSize();

        //IntStream > Int < Integer로 변환하여 List로 담음
        this.pageNumList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

        //이전페이지 번호
        this.prevPage = prev ? start -1 : 0;
        //다음페이지 번호
        this.nextPage = next ? end +1 : 0;

    }

}
