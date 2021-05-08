package b06704043;

import java.util.ArrayList;

public class Reader {
	
	private String readerName;
	private String readerBirth;
	private String borrowId;
	private ArrayList<Collection> borrowCount;  // 紀錄借閱那些書籍內容
	private int borrowLimit;
	
	
	public Reader(String readerName, String readerBirth, int borrowLimit) {
		this.readerName = readerName;
		this.readerBirth = readerBirth;
		this.borrowLimit = borrowLimit;
		borrowCount = new ArrayList<Collection>();
	}
	
	
	public void listReaderInformation() {
		System.out.println("姓名 / " + getReaderName());
		System.out.println("出生年月日 / " + getReaderBirth());
		
		//印出借閱書籍與否或是已借閱書籍清冊
		if (borrowCount.size() == 0) {
			System.out.println("已借閱館藏 / " + "尚未借出任何館藏！");
		}
		else {
			ArrayList<String> bookTitleArrayList = new ArrayList<String>();
			for (Collection book : borrowCount) {
				bookTitleArrayList.add(book.getTitle());
			}
			String tempBookList = String.join(", ", bookTitleArrayList);
			System.out.println("已借閱館藏 / " + tempBookList);
		}
	}
	
	
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getReaderBirth() {
		return readerBirth;
	}
	public void setReaderBirth(String readerBirth) {
		this.readerBirth = readerBirth;
	}
	public String getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(String borrowId) {
		this.borrowId = borrowId;
	}
	public ArrayList<Collection> getBorrowCount() {
		return borrowCount;
	}
	public void setBorrowCount(ArrayList<Collection> borrowCount) {
		this.borrowCount = borrowCount;
	}
	public int getBorrowLimit() {
		return borrowLimit;
	}
	public void setBorrowLimit(int borrowLimit) {
		this.borrowLimit = borrowLimit;
	}
	
	
	
	
}
