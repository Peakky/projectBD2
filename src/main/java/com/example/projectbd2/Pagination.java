package com.example.projectbd2;

public class Pagination {
    public int page;
    public int limit;
    public int offset;
    public Pagination(int page, int limit){
        this.page = page;
        this.limit = limit;
        this.offset = (page - 1) * limit;
    }
}
