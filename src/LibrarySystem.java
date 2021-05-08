package b06704043;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibrarySystem {
	
	protected boolean loginStatus;  //true:館員已登入, false:館員以已登出
	private ArrayList<Collection> bookStorage;  //紀錄已註冊之書籍
	private ArrayList<Librarian> adminFullInfo;
	private ArrayList<String> adminAccount;
	private ArrayList<String> adminPassword;
	private ArrayList<Reader> readerFullInfo;
	private ArrayList<String> readerIDArray;
	


	public LibrarySystem(boolean loginStatus) {
		this.loginStatus = loginStatus;
		bookStorage = new ArrayList<Collection>();
		adminFullInfo = new ArrayList<Librarian>();
		adminAccount =  new ArrayList<String>();
		adminPassword = new ArrayList<String>();
		readerFullInfo = new ArrayList<Reader>();
		readerIDArray = new ArrayList<String>();
	}


	public boolean isLoginStatus() {
		return loginStatus;
	}
	
	
	public ArrayList<Librarian> getAdminFullInfo() {
		return adminFullInfo;
	}


	public void setAdminFullInfo(ArrayList<Librarian> adminFullInfo) {
		this.adminFullInfo = adminFullInfo;
	}


	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}


	public ArrayList<Collection> getBookStorage() {
		return bookStorage;
	}


	public void setBookStorage(ArrayList<Collection> bookStorage) {
		this.bookStorage = bookStorage;
	}


	public ArrayList<String> getAdminAccount() {
		return adminAccount;
	}


	public void setAdminAccount(ArrayList<String> adminAccount) {
		this.adminAccount = adminAccount;
	}


	public ArrayList<String> getAdminPassword() {
		return adminPassword;
	}


	public void setAdminPassword(ArrayList<String> adminPassword) {
		this.adminPassword = adminPassword;
	}


	public ArrayList<Reader> getReaderFullInfo() {
		return readerFullInfo;
	}


	public void setReaderFullInfo(ArrayList<Reader> readerFullInfo) {
		this.readerFullInfo = readerFullInfo;
	}

	
	
	public ArrayList<String> getReaderIDArray() {
		return readerIDArray;
	}


	public void setReaderIDArray(ArrayList<String> readerIDArray) {
		this.readerIDArray = readerIDArray;
	}

	
	//Func1
	public void addCollection(Scanner scn) {  
		String keepTry = "";
		System.out.println("***開始進行館藏登錄***");
		do {
			scn.nextLine();
			do {
				
				System.out.println("館藏類型： 輸入 1 為書籍 / 輸入 2 為雜誌 / 輸入 3 為多媒體");
				String addType = scn.nextLine();
				if (addType.equals("1")){
					ArrayList<String> tempBookInfo = addBook(scn);
					Collection aBook = new Book(tempBookInfo.get(0), tempBookInfo.get(1), tempBookInfo.get(2), tempBookInfo.get(3), tempBookInfo.get(4), false);
					getBookStorage().add(aBook);	
				}
				else if (addType.equals("2")) {
					ArrayList<String> tempMagazineInfo = addMagazine(scn);
					Collection aMagazine = new Magazine(tempMagazineInfo.get(0), tempMagazineInfo.get(1), tempMagazineInfo.get(2), tempMagazineInfo.get(3), tempMagazineInfo.get(4), tempMagazineInfo.get(5), tempMagazineInfo.get(6), false);
					getBookStorage().add(aMagazine);
				}
				else if (addType.equals("3")) {
					ArrayList<String> tempMediaInfo = addMedia(scn);
					Collection aMedia = new Multimedia(tempMediaInfo.get(0), tempMediaInfo.get(1), tempMediaInfo.get(2), tempMediaInfo.get(3), tempMediaInfo.get(4), tempMediaInfo.get(5), tempMediaInfo.get(6), false);
					getBookStorage().add(aMedia);
				}
				else {	
					System.out.println("不合法的輸入！再試一次");
					continue;
				}
				break;
			} while (true);

			
			
			while (true) {
				System.out.println("是否繼續新增？Y(y)/N(n)");
				//tempChoice = scn.nextLine();
				keepTry = scn.next();
				if (keepTry.equals("Y") || keepTry.equals("y"))
					break;
				else if (keepTry.equals("N") || keepTry.equals("n"))
					break;
				else {
					System.out.println("不合法的輸入！再試一次！");
					continue;
				}
			}

		} while(keepTry.equals("Y") || keepTry.equals("y"));
		
	}
	
	
	//Func1(1)
	public ArrayList<String> addBook(Scanner scn){
		ArrayList<String> tempBookInfo = new ArrayList<String>();
		String tempBookInfoScan = "";
		
		System.out.print("題名：");
		tempBookInfoScan = scn.nextLine(); 
		tempBookInfo.add(tempBookInfoScan);
		System.out.print("作者：");
		tempBookInfoScan = scn.next(); 
		tempBookInfo.add(tempBookInfoScan);
		System.out.print("出版社：");
		tempBookInfoScan = scn.next(); 
		tempBookInfo.add(tempBookInfoScan);
		System.out.print("識別號：");
		tempBookInfoScan = scn.next(); 
		tempBookInfo.add(tempBookInfoScan);
		System.out.print("分類號：");
		tempBookInfoScan = scn.nextLine();
		tempBookInfoScan = scn.nextLine();
		tempBookInfo.add(tempBookInfoScan);
		System.out.println("館藏新增完成！");
		
		return tempBookInfo;
	}
	
	
	//Func1(2)
	public ArrayList<String> addMagazine(Scanner scn){
		ArrayList<String> tempMagazineInfo = new ArrayList<String>();
		String tempMagazineInfoScan = "";
		
		System.out.print("題名：");
		tempMagazineInfoScan = scn.nextLine(); 
		tempMagazineInfo.add(tempMagazineInfoScan);
		System.out.print("作者：");
		tempMagazineInfoScan = scn.next(); 
		tempMagazineInfo.add(tempMagazineInfoScan);
		System.out.print("出版社：");
		tempMagazineInfoScan = scn.next(); 
		tempMagazineInfo.add(tempMagazineInfoScan);
		System.out.print("年分：");
		tempMagazineInfoScan = scn.next(); 
		tempMagazineInfo.add(tempMagazineInfoScan);
		System.out.print("期數：");
		tempMagazineInfoScan = scn.next(); 
		tempMagazineInfo.add(tempMagazineInfoScan);
		System.out.print("識別號：");
		tempMagazineInfoScan = scn.next(); 
		tempMagazineInfo.add(tempMagazineInfoScan);
		System.out.print("分類號：");
		tempMagazineInfoScan = scn.nextLine();
		tempMagazineInfoScan = scn.nextLine();
		tempMagazineInfo.add(tempMagazineInfoScan);
		System.out.println("館藏新增完成！");
		
		return tempMagazineInfo;
	}
	
	
	//Func1(3)
	public ArrayList<String> addMedia(Scanner scn){
		ArrayList<String> tempMediaInfo = new ArrayList<String>();
		String tempMediaInfoScan = "";
		
		System.out.print("題名：");
		tempMediaInfoScan = scn.nextLine(); 
		tempMediaInfo.add(tempMediaInfoScan);
		System.out.print("作者：");
		tempMediaInfoScan = scn.nextLine(); 
		tempMediaInfo.add(tempMediaInfoScan);
		System.out.print("出版社：");
		tempMediaInfoScan = scn.next(); 
		tempMediaInfo.add(tempMediaInfoScan);
		System.out.print("多媒體類型：");
		tempMediaInfoScan = scn.next(); 
		tempMediaInfo.add(tempMediaInfoScan);
		System.out.print("長度（分鐘）：");
		tempMediaInfoScan = scn.next(); 
		tempMediaInfo.add(tempMediaInfoScan);
		System.out.print("識別號：");
		tempMediaInfoScan = scn.next(); 
		tempMediaInfo.add(tempMediaInfoScan);
		System.out.print("分類號：");
		tempMediaInfoScan = scn.nextLine();
		tempMediaInfoScan = scn.nextLine();
		tempMediaInfo.add(tempMediaInfoScan);
		System.out.println("館藏新增完成！");
		
		return tempMediaInfo;
	}
	
	
	//Func2
	public void addReaderRegist(Scanner scn){
		ArrayList<String> readerRegistInfo = new ArrayList<String>();
		String readerRegistInfoScan = "";
		
		System.out.print("\n***開始進行借閱證註冊***\n");
		System.out.print("輸入申請人姓名：");
		readerRegistInfoScan = scn.nextLine();
		readerRegistInfoScan = scn.nextLine();
		readerRegistInfo.add(readerRegistInfoScan);
		System.out.print("輸入申請人出生年月日（YYYY/MM/DD）：");
		readerRegistInfoScan = scn.nextLine();
		
		//用正則表達式規範使用者始能輸入1900/01/01~2099/12/12
		if (readerRegistInfoScan.matches("((?:19|20)[0-9][0-9])/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])") ) {
			readerRegistInfo.add(readerRegistInfoScan);
			System.out.println("借閱證申請完成！");
			//先創造出讀者實例(姓名, 出生年月日, 借書額度5本)，再發給他一個ID
			System.out.print("借閱證號碼為：");
			String tempID = ( readerRegistInfo.get(1).split("/")[1] + 
					readerRegistInfo.get(1).split("/")[2] +
					Integer.toString(getReaderFullInfo().size()+1) );
			Reader newReader = new Reader(readerRegistInfo.get(0), readerRegistInfo.get(1), 5);
			System.out.print(tempID);
			System.out.println("\n");
			//發放ID
			newReader.setBorrowId(tempID);
			//新增讀者資訊到後端系統
			getReaderFullInfo().add(newReader);
			//錄入讀者ID到系統
			getReaderIDArray().add(tempID);
		}
		else {
			System.out.println("格式有誤！輸入必須符合（YYYY/MM/DD）格式");
			System.out.println("系統只接受 1900/01/01 ~ 2099/12/12");
		}
		
	}
	
	
	//Func3
	public void readerBorrow(Scanner scn){
		String keepTry = "";
		String tempCheckId = "";
		String tempClassification;
		System.out.println("***開始進行館藏借閱***");
		
		do {
			System.out.print("輸入借閱證編號：");
			tempCheckId = scn.next();
			
			if (getReaderIDArray().contains(tempCheckId)) {
				int whichReader = getReaderIDArray().indexOf(tempCheckId);
				Reader theReader = getReaderFullInfo().get(whichReader);
				
				//已達借閱冊數上限
				do {
					if (theReader.getBorrowCount().size() >= theReader.getBorrowLimit()) {
						System.out.println("已超出借閱本數限制！請歸還後再行借閱");
						keepTry = "N";
					}
					else {
						ArrayList<String> bookClasssifications = new ArrayList<String>(); 
						for (Collection aBook : getBookStorage()) {
							bookClasssifications.add(aBook.getClassification());
						}
					
					
						System.out.print("請輸入欲借閱館藏的分類號：");
						
						tempClassification = scn.nextLine();
						tempClassification = scn.nextLine();
						
						Collection theBook;
						int theBookIndex;
						//這裡需要一堆分類號
						if (bookClasssifications.contains(tempClassification)){
							
							theBookIndex = bookClasssifications.indexOf(tempClassification);
							theBook = getBookStorage().get(theBookIndex);
							// 被借出
							if (theBook.isIssued()) {
								System.out.println("此館藏已借出！繼續借閱？Y(y)/N(n)");
							}
							else {
								String tempBorrowAmount = "";
								tempBorrowAmount = String.valueOf(theReader.getBorrowCount().size() + 1);
								System.out.println("借閱成功！" + theReader.getReaderName() + " (" + tempCheckId + ") " + "已借了 " + tempBorrowAmount + " 本書籍");
								
								//把書加入到Reader的收藏裡 
								theReader.getBorrowCount().add(theBook);
								//把書的借閱狀態改為已借出
								theBook.setIssued(true);
								theBook.setCurrentBorrowReader(theReader);
								
								//列出讀者已借出書籍清單
								ArrayList<String> bookList = new ArrayList<String>();
								for (Collection readerBorrowed : theReader.getBorrowCount()) {
									bookList.add(readerBorrowed.getTitle());
								}
								String tempList = String.join(",   ", bookList);
								System.out.println("已借出書籍：" + tempList );
								System.out.println("繼續借閱？Y(y)/N(n)");
							}
						
						}
						else {
							System.out.println("分類號輸入錯誤！繼續借閱？Y(y)/N(n)");
						}
						
						while(true) {
							keepTry = scn.next();
							if (Arrays.asList("Y", "y", "N", "n").contains(keepTry))
								break;
							else {
								System.out.println("不合法的輸入！ 繼續借閱？Y(y)/N(n)");
							}
						}
					} 
				} while (keepTry.equals("Y") || keepTry.equals("y"));
			}
			else {
				System.out.println("借閱證編號錯誤！重新輸入？Y(y)/N(n)");
				keepTry = scn.nextLine();
				keepTry = scn.next();
			}
			
		} while (keepTry.equals("Y") || keepTry.equals("y"));
	}
	
	
	//Func4
	public void readerReturn(Scanner scn){
		String keepReturn;
		Collection theBookToReturn = null;
		String tempClassification = new String();
		int timeCount = 0;
		do {
			theBookToReturn = null;
			System.out.print("請輸入館藏分類號：");
			if (timeCount > 0 )
				tempClassification = scn.nextLine();
			if (timeCount == 0)
				tempClassification = scn.nextLine();
			if (timeCount == 0) {
				timeCount += 1;
				tempClassification = scn.nextLine();
			}
			for (Collection aBook : getBookStorage()) {
				if (aBook.getClassification().equals(tempClassification)) {
					theBookToReturn = aBook;
				}
			}
			
			//確認分類號無誤後
			if (bookStorage.contains(theBookToReturn) && theBookToReturn.isIssued()) {
				//秀出歸還成功訊息
				System.out.println(theBookToReturn.getCurrentBorrowReader().getReaderName() + "，" + theBookToReturn.getTitle() + " 歸還成功！");
				
				int indexOfReaderCollection =  theBookToReturn.getCurrentBorrowReader().getBorrowCount().indexOf(theBookToReturn);
				theBookToReturn.getCurrentBorrowReader().getBorrowCount().remove(indexOfReaderCollection);
				//館藏之借閱人屬性設為null、借出狀態改為在架上
				theBookToReturn.setCurrentBorrowReader(null);
				theBookToReturn.setIssued(false);
			}
			else if ((bookStorage.contains(theBookToReturn)) && (theBookToReturn.isIssued() == false)){
				System.out.println("此館尚未被借出");
			}
			else {
				System.out.println("分類號輸入錯誤");
			}
			
			
			while(true) {
				System.out.println("繼續歸還？Y(y)/N(n)");
				
				keepReturn = scn.nextLine();
				if (Arrays.asList("Y", "y", "N", "n").contains(keepReturn))
					break;
				else {
					System.out.println("不合法的輸入！再試一次");
					continue;
				}

			}
		} while(keepReturn.equals("Y") || keepReturn.equals("y"));
	}
	
	
	//Func5
	public void checkReaderInfo(Scanner scn){
		String tempCheckId = "";
		String keepTry = "";
		
		do {
			System.out.print("請輸入借閱證號：");
			tempCheckId = scn.next();
			
			if (getReaderIDArray().contains(tempCheckId)) {
				int whichReader = getReaderIDArray().indexOf(tempCheckId);
				Reader theReader = getReaderFullInfo().get(whichReader);
				theReader.listReaderInformation();
				System.out.println("繼續查詢？Y(y)/N(n)");
				keepTry = scn.next();

			}
			else {
				System.out.println("查無此讀者！繼續查詢Y(y)/N(n)");
				keepTry = scn.next();
			}
		} while (keepTry.equals("Y") || keepTry.equals("y"));
	}
		
	//Func6
	public void checkLibStorage(Scanner scn){
		
		String tempChoice;
		String keepTry = "";

		String tempFinder = "";
		//int theCollectionIndex = 0;
		Collection theCollection = null;
		
		ArrayList<String> bookTitles = new ArrayList<String>();
		ArrayList<String> bookAuthors = new ArrayList<String>();
		ArrayList<String> bookIdentifiers = new ArrayList<String>();
		for (Collection aBook : getBookStorage()) {
			bookTitles.add(aBook.getTitle());
			bookAuthors.add(aBook.getAuthorString());
			bookIdentifiers.add(aBook.getIdentifier());
		}
		
		do {
			System.out.println("***開始進行館藏查詢***\n輸入 1 以館藏標題查詢\n輸入 2 以作者查詢\n輸入 3 以識別號查詢");
			tempChoice = scn.next();
			
			if (Arrays.asList("1", "2", "3").contains(tempChoice)) {
				if (tempChoice.equals("1")) {
					System.out.print("請輸入館藏標題：");
				}	
				else if (tempChoice.equals("2")) {
					System.out.print("請輸入作者姓名：");
				}
				else if (tempChoice.equals("3")) {
					System.out.print("請輸入館藏識別號：");
				}
				
				// 開始查找書籍
				
				tempFinder = scn.nextLine();
				tempFinder = scn.nextLine();
				boolean successToFind = false;
				
				for (int i = 0; i < bookStorage.size(); i++) {
					if (bookTitles.get(i).equals(tempFinder)) {
						//theCollectionIndex = bookTitles.indexOf(tempFinder);
						//theCollection = getBookStorage().get(theCollectionIndex);
						theCollection = getBookStorage().get(i);
						theCollection.listCollectionInformation();
						successToFind = true;
					}
					else if (bookAuthors.get(i).equals(tempFinder)) {
						//theCollectionIndex = bookAuthors.indexOf(tempFinder);
						//theCollection = getBookStorage().get(theCollectionIndex);
						theCollection = getBookStorage().get(i);
						theCollection.listCollectionInformation();
						successToFind = true;
					}
					else if (bookIdentifiers.get(i).equals(tempFinder)) {
						//theCollectionIndex = bookIdentifiers.indexOf(tempFinder);
						//theCollection = getBookStorage().get(theCollectionIndex);
						theCollection = getBookStorage().get(i);
						theCollection.listCollectionInformation();
						successToFind = true;
					}
				}
				
				
				if (successToFind == false) {
					System.out.print("查無此館藏！");
					System.out.println("繼續查詢 ？Y(y)/N(n)");
				}
					
				if (bookTitles.contains(tempFinder) || bookAuthors.contains(tempFinder) || bookIdentifiers.contains(tempFinder)) {
					// 若在登入狀態且書籍被借走，印出該讀者借書證號
					if (theCollection.isIssued() && isLoginStatus()) {
						System.out.println("借出借書證號  /  " + theCollection.getCurrentBorrowReader().getBorrowId());
						//System.out.println("---------------------------------");
					}
					//else
					//	System.out.println("---------------------------------");
				}	
				
				if (successToFind) {
					System.out.println("---------------------------------");
					System.out.println("繼續查詢 ？Y(y)/N(n)");
				}
				
			}
			else {
				System.out.println("不合法的輸入！再試一次");
				keepTry = "Y";
				continue;
			}
			
			keepTry = scn.next();
			
			if (!keepTry.matches("[YyNn]")) {
				do {
					System.out.println("不合法的輸入！繼續查詢 ？Y(y)/N(n)");
					keepTry = scn.next();
				} while(!keepTry.matches("[YyNn]"));
			}
		} while(keepTry.equals("Y") || keepTry.equals("y"));
		
	}
	
	
	//Func7
	public void libLogout(Librarian offJobLibrarian){
		setLoginStatus(false);
		offJobLibrarian.setOnLine(false);
		System.out.println(offJobLibrarian.getName() + "已登出\n");
	}

}
