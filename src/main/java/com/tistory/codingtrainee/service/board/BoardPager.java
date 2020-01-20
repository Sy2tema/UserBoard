package com.tistory.codingtrainee.service.board;

//페이지를 나누는 메소드들을 정의하는 인터페이스
public class BoardPager {
	// 기본적인 페이지당 게시글 수
	public static final int PAGE_SCALE = 10;
	// 기본적인 화면당 페이지 수
	public static final int BLOCK_SCALE = 10;
	
	// 페이지 변수
	private int currentPage;
	private int previousPage;
	private int nextPage;
	private int totalPage;
	
	// 페이지 블록 변수
	private int currentBlock;
	private int previousBlock;
	private int nextBlock;
	private int totalBlock; // 전체 페이지의 블록 수를 저장한다

	// 페이지를 나눌 때 사용할 변수
	private int pageBegin;
	private int pageEnd;
	
	// [prev] 11 12 13 14 15 16 17 18 19 20 [next]
	private int blockBegin;
	private int blockEnd;
	
	// 레코드 개수와 현재 페이지 번호를 받아온다
	public BoardPager(int count, int currentPage) {
		currentBlock = 1;
		this.currentPage = currentPage;
		
		setTotalPage(count); // 전체 페이지의 수를 계산해주는 메소드
		setTotalBlock();
		
		setPageRange(); // 쿼리문 중 between부분에 들어갈 시작값과 끝값을 계산하는 메소드
		setBlockRange();
	}
	
	public void setPageRange() {
		// (현재페이지 - 1) * 페이지당 게시글 수 + 1을 하게 되면 시작 페이지의 번호를 구할 수 있다
		pageBegin = (currentPage - 1) * PAGE_SCALE + 1;
		
		// 시작번호 + 페이지당 게시글 수 - 1을 하게 되면 끝페이지의 번호를 구할 수 있다
		pageEnd = pageBegin + PAGE_SCALE - 1;
	}
	
	// 아래 페이지 이동에 관련된 숫자들을 눌렀을 경우들의 동작을 명시해둔 메소드
	public void setBlockRange() {
		// 현재 페이지가 몇 번째 페이지 블록에 속하는지 확인한다
		currentBlock = (int) Math.ceil((currentPage - 1) / BLOCK_SCALE) + 1;
		
		blockBegin = (currentBlock - 1) * BLOCK_SCALE + 1;
		blockEnd = blockBegin + BLOCK_SCALE - 1;
		
		// 끝 페이지 번호가 전체 페이지 번호를 넘어갈 수 없도록 조치해두었다
		if (blockEnd > totalPage) blockEnd = totalPage;
		
		// [prev]와 [next]을 누르면 이동할 페이지의 번호를 지정한다
		previousPage = currentBlock == 1 ? 1 : (currentBlock - 1) * BLOCK_SCALE;
		nextPage = currentBlock > totalBlock
				? (currentBlock * BLOCK_SCALE) 
				: (currentBlock * BLOCK_SCALE) + 1;
		
		// 마지막 페이지 또한 범위를 넘을 수 없도록 조치한다
		if (nextPage >= totalPage) nextPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int count) {
		// 올림처리를 해두어야 마지막에 소수점 결과가 나오더라도 해당 결과를 버리지 않을 수 있게 된다
		totalPage = (int) Math.ceil(count * 1.0 / PAGE_SCALE);
	}

	public int getCurrentBlock() {
		return currentBlock;
	}
	public void setCurrentBlock(int currentBlock) {
		this.currentBlock = currentBlock;
	}

	public int getPreviousBlock() {
		return previousBlock;
	}
	public void setPreviousBlock(int previousBlock) {
		this.previousBlock = previousBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getTotalBlock() {
		return totalBlock;
	}
	// 페이지 블록의 총 개수를 구한다 (100페이지라면 10개의 블록)
	public void setTotalBlock() {
		totalBlock = (int) Math.ceil(totalPage / BLOCK_SCALE);
	}

	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockBegin() {
		return blockBegin;
	}
	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}

	public int getBlockEnd() {
		return blockEnd;
	}
	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}

	public static int getPageScale() {
		return PAGE_SCALE;
	}
	public static int getBlockScale() {
		return BLOCK_SCALE;
	}
}
