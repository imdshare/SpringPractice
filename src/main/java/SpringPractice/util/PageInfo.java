package SpringPractice.util;

import lombok.Data;

@Data
public class PageInfo {
	
	private int block=10;//������ ǥ���� ����
	private int from;//���۹�ȣ
	private int to;//����ȣ
	private int totalPages;//��������ȣ
	public PageInfo(int page, int totalPages) {
		this.totalPages=totalPages;
		int blockNo=page/block;
		if(page%block > 0){
			blockNo++;
		}
		
		//����ȣ����
		to=blockNo*block;
		//���۹�ȣ ����
		from=to-block+1;
		if(to  > totalPages) {
			to=totalPages;
		}
	}


}
