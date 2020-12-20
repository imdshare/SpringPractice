package SpringPractice.util;

import lombok.Data;

@Data
public class PageInfo {
	
	private int block=10;//페이지 표현할 개수
	private int from;//시작번호
	private int to;//끝번호
	private int totalPages;//마지막번호
	public PageInfo(int page, int totalPages) {
		this.totalPages=totalPages;
		int blockNo=page/block;
		if(page%block > 0){
			blockNo++;
		}
		
		//끝번호연산
		to=blockNo*block;
		//시작번호 연산
		from=to-block+1;
		if(to  > totalPages) {
			to=totalPages;
		}
	}


}
