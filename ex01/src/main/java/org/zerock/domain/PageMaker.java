package org.zerock.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.sound.sampled.AudioFormat.Encoding;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.controller.SearchCriteria;

public class PageMaker {
	
	private int totalCount;	//전체 게시물의 수
	private int startPage;	//시작 페이지 번호
	private int endPage;	//끝 페이지 번호
	private boolean prev;	//이전 페이지 링크
	private boolean next;	//이후 페이지 링크
	
	private int displayPageNum = 10;	//한번에 보여줄 페이지의 수
	
	private Criteria cri;	//현재 페이지 및 페이지 당 보여줄 게시물 수에 대한 정보를 가진 객체의 참조
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	private void calcData() {
		
		//끝 페이지 번호 = (반올림(현재페이지 / 한번에 보여줄 페이지의 수)) * 한번에 보여줄 페이지의 수
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		//시작 페이지 번호 = (끝 페이지 번호 - 한번에 보여줄 페이지의 수) + 1 
		startPage = (endPage - displayPageNum) + 1;
		//가장 끝 페이지 번호 = (반올림(전체 게시물 수 / 한 페이지 당 보여줄 게시물 수))  
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		//끝 페이지 번호가 가장 끝 페이지 번호보다 클 경우
		if(endPage > tempEndPage) {
			//끝 페이지 번호를 가장 끝 페이지 번호로 설정
			endPage = tempEndPage;
		}
		
		//시작 페이지가 1이면 이전 페이지 링크 무효화
		prev = startPage == 1 ? false : true;
		//(끝 페이지 * 한 페이지 당 보여줄 게시물 수) >= 전체 게시물수 이변 이후 페이지 링크 무효화
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}
	
	public String makeQuery(int page) {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		
		return uriComponents.toUriString();
	}
	
	public String makeSearch(int page) {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", ((SearchCriteria) cri).getSearchType())
				.queryParam("keyword", encoding(((SearchCriteria) cri).getKeyword()))
				.build();
		
		return uriComponents.toUriString();
	}

	private Object encoding(String keyword) {
		
		if(keyword == null || keyword.trim().length() == 0) {
			return "";
		}
		
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public Criteria getCri() {
		return cri;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
}
