package mypage.domain;

import java.io.Serializable;

public class SearchVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1016449226706401622L;
	private String searchKey;
	private String tagId;
	private int offset;
	private int size = 0;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}