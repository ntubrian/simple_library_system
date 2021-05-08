package b06704043;


import java.util.Arrays;
import java.util.Scanner;


public class B06704043 {

	public static void main(String[] args) {
		
		
		Librarian adamAdmin = new Librarian("Adam", "FarAwayLIB", "SoFar1111");  //創建館員1
		Librarian evaAdmin = new Librarian("Eva", "FarFarAwayLIB", "SoFar2222");  //創建館員2
		Librarian helenAdmin = new Librarian("Helen", "FarFarFarAwayLIB", "SoFar3333");  //創建館員3
		//為加速測試自記創一個帳密短一點的管理員ABin
		Librarian abin = new Librarian("Abin", "abin", "abin");
		LibrarySystem backendSystem = new LibrarySystem(false); //創建一個圖書系統，初始為尚未登入狀態(false)
		
		// 將館員完整資訊登錄到後台系統
		backendSystem.getAdminFullInfo().add(adamAdmin);
		backendSystem.getAdminFullInfo().add(evaAdmin);
		backendSystem.getAdminFullInfo().add(helenAdmin);
		backendSystem.getAdminFullInfo().add(abin);
		
		// 將館員帳號、密碼資訊 分開登錄到後台系統 ( 以2個ArrayList型態存取)
		backendSystem.getAdminAccount().add(adamAdmin.getSystemAccount());
		backendSystem.getAdminAccount().add(evaAdmin.getSystemAccount());
		backendSystem.getAdminAccount().add(helenAdmin.getSystemAccount());
		backendSystem.getAdminPassword().add(adamAdmin.getSystemPassword());
		backendSystem.getAdminPassword().add(evaAdmin.getSystemPassword());
		backendSystem.getAdminPassword().add(helenAdmin.getSystemPassword());
		// 也把測試的帳號加入
		backendSystem.getAdminAccount().add(abin.getSystemAccount());
		backendSystem.getAdminPassword().add(abin.getSystemPassword());
		
		Scanner scanFrontEnd = new Scanner(System.in);
		String userChoice = "";
		Librarian onJobLibrarian = null;
		do {
			// 若在登入狀態
			if (backendSystem.isLoginStatus()) {
				mainMenuType2();
				userChoice = scanFrontEnd.next();
				if (!(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "exit").contains(userChoice))) {
					System.out.println("不合法的輸入！請再輸入一次");
					continue;
				}
			}
			// 還沒登入
			else {
				mainMenuType1();  //功能主選單(尚未登入前)
				userChoice = scanFrontEnd.next();
				if (!(Arrays.asList("1", "2", "3", "4", "5", "6", "exit").contains(userChoice))) {
					if(!userChoice.contains("exit")) {
						System.out.println("不合法的輸入！請再輸入一次");
						continue;
					}
				}
			}
			
			// 選擇選單
			// 如果尚未登入且選擇1~5的選項，則顯示要先登入的訊息和介面
			if ( backendSystem.isLoginStatus() == false &&
				!(Arrays.asList("6", "7", "exit").contains(userChoice)) ) {
				
				onJobLibrarian = yetLoginMessage(backendSystem, scanFrontEnd);
				//沒有登入成功就返回首頁
				if (backendSystem.isLoginStatus() == false)
					continue;
			}
				
				
			if (userChoice.equals("1")) {
				//ArrayList<String> snewCollection = new ArrayList<String>();
				//newCollection = 
				backendSystem.addCollection(scanFrontEnd);
			}
			else if (userChoice.equals("2")) {
				backendSystem.addReaderRegist(scanFrontEnd);
			}
			else if (userChoice.equals("3")) {
				backendSystem.readerBorrow(scanFrontEnd);
			}
			else if (userChoice.equals("4")) {
				backendSystem.readerReturn(scanFrontEnd);
			
			}
			else if (userChoice.equals("5")) {
				backendSystem.checkReaderInfo(scanFrontEnd);
			}
			else if (userChoice.equals("6")) {
				backendSystem.checkLibStorage(scanFrontEnd);
			}
			else if (userChoice.equals("7")) {
				backendSystem.libLogout(onJobLibrarian);
			}
			else if (userChoice.equals("exit")) {
				System.out.println("系統執行結束，再見！");
				break;
			}
			

		} while(true);
		
	}
	
	
	public static Librarian yetLoginMessage(LibrarySystem backSys, Scanner scanFrontEnd) {
	
		System.out.println("館員請先登入，才可以使用此功能");
		String accountInput, passwordInput;
		String keepTry;
		String whichAdminName;
		Librarian whichAdmin = null;
		
		do {
			System.out.print("請輸入帳號： ");
			accountInput = scanFrontEnd.next();
			System.out.print("請輸入密碼： ");
			passwordInput = scanFrontEnd.next();
			
			if ( (backSys.getAdminAccount().contains(accountInput)) == false ||
					(backSys.getAdminPassword().contains(passwordInput)) == false ) {
				System.out.println("帳號密碼錯誤！是否重新輸入？Y(y)/N(n)");
				
				while (true) {
					keepTry = scanFrontEnd.next();
					if (keepTry.equals("Y") || keepTry.equals("y"))
						break;
					else if (keepTry.equals("N") || keepTry.equals("n"))
						break;
					else {
						System.out.println("不合法的輸入！再試一次！");
						System.out.println("是否重新輸入？Y(y)/N(n)");
						continue;
					}
				}
			}
			else {
				whichAdminName = backSys.getAdminFullInfo().get(backSys.getAdminAccount().indexOf(accountInput)).getName();
				whichAdmin = backSys.getAdminFullInfo().get(backSys.getAdminAccount().indexOf(accountInput));
				System.out.println("嗨 " + whichAdminName + "，歡迎登入");
				backSys.loginStatus = true;
				break;
			}
		} while(keepTry.equals("Y") || keepTry.equals("y"));
		return whichAdmin;
	}
	
	
	public static void mainMenuType1() {
		
		System.out.println("================================================");
		System.out.println("歡迎使用圖書資訊系統");
		System.out.println("輸入 1 進行館藏登錄");
		System.out.println("輸入 2 進行借閱證註冊");
		System.out.println("輸入 3 進行館藏借閱");
		System.out.println("輸入 4 進行館藏歸還");
		System.out.println("輸入 5 查詢讀者狀態");
		System.out.println("輸入 6 查詢館藏狀態");
		System.out.println("輸入 exit 以離開");
		System.out.println("================================================");	
	}
	
	public static void mainMenuType2() {
			
		System.out.println("================================================");
		System.out.println("歡迎使用圖書資訊系統");
		System.out.println("輸入 1 進行館藏登錄");
		System.out.println("輸入 2 進行借閱證註冊");
		System.out.println("輸入 3 進行館藏借閱");
		System.out.println("輸入 4 進行館藏歸還");
		System.out.println("輸入 5 查詢讀者狀態");
		System.out.println("輸入 6 查詢館藏狀態");
		System.out.println("輸入 7 以登出");
		System.out.println("輸入 exit 以離開");
		System.out.println("================================================");	
	}
	
}
