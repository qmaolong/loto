package com.loto.vo;

import java.util.List;

import com.github.pagehelper.Page;

/**
 * Description: 对Page<E>结果进行包装
 * @author daiwen
 */
public class PageInfo<T> {
	private int pageNum;
	private int pageSize;
	private int startRow;
	private int endRow;
	private long total;
	private int pages;
	private List<T> rows;

	public PageInfo(List<T> list) {
		if (list instanceof Page) {
			Page<T> page = (Page<T>) list;
			this.pageNum = page.getPageNum();
			this.pageSize = page.getPageSize();
			this.startRow = page.getStartRow();
			this.endRow = page.getEndRow();
			this.total = page.getTotal();
			this.pages = page.getPages();
			this.rows = page;
		}else{
			this.pageNum = 1;
			this.pageSize = list.size();
			this.startRow = 0;
			this.endRow = list.size();
			this.total = list.size();
			this.pages = 1;
			this.rows = list;
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
