package com.hhit.community.community.dto;

import java.util.ArrayList;
import java.util.List;

public class PaginationDTO {
    private List<QuestionDTO> questionDTOs;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();

    public List<QuestionDTO> getQuestionDTOs() {
        return questionDTOs;
    }

    public void setQuestionDTOs(List<QuestionDTO> questionDTOs) {
        this.questionDTOs = questionDTOs;
    }

    public boolean isShowPrevious() {
        return showPrevious;
    }

    public void setShowPrevious(boolean showPrevious) {
        this.showPrevious = showPrevious;
    }

    public boolean isShowFirstPage() {
        return showFirstPage;
    }

    public void setShowFirstPage(boolean showFirstPage) {
        this.showFirstPage = showFirstPage;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowEndPage() {
        return showEndPage;
    }

    public void setShowEndPage(boolean showEndPage) {
        this.showEndPage = showEndPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        Integer totalPage = 0;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = (totalCount / size) + 1;
        }
        for (int i =1; i<=3;i++){
            if (page-i>0){
                pages.add(page-i,0);
            }
            if (page+i<=totalCount){
                pages.add(page+1);
            }
        }

        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        if (pages.contains(totalCount)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
