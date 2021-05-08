package b06704043;

public class Book extends Collection{
	
	
	public Book(String title, String authorString, String publisher, String identifier, String classification,
			boolean isIssued) {
		super(title, authorString, publisher, identifier, classification, isIssued);
	}
		
	public void listCollectionInformation() {
		System.out.println("---------------------------------");
		System.out.println("標題  /  " + getTitle());
		System.out.println("作者  /  " + getAuthorString());
		System.out.println("出版社  /  " + getPublisher());
		System.out.println("識別號  /  " + getIdentifier());
		System.out.println("分類號  /  " + getClassification());
		System.out.println("館藏類型  /  " + "書籍");
		System.out.println("館藏狀態  /  " + (isIssued() ? "已借出" : "架上"));
			
	}

}
