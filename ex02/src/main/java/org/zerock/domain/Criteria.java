package org.zerock.domain;

public class Criteria {	//사전적 의미로 '검색 기준, 분류 기준'
	
	private int page;
	private int perPageNum;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		
		if(page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
		
	}
	
	// method for MyBatis SQL Mapper
	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		
		this.perPageNum = perPageNum;
		
	}
	
	// method for MyBatis SQL Mapper
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
}
