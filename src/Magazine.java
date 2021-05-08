package b06704043;

public class Magazine extends Collection{
	
	private String year;
	private String period;
	
	
	public Magazine(String title, String authorString, String publisher, String year, String period, String identifier, String classification,
			boolean isIssued) {
		super(title, authorString, publisher, identifier, classification, isIssued);
		setYear(year);
		setPeriod(period);
	}

	public void listCollectionInformation() {
		System.out.println("---------------------------------");
		System.out.println("標題  /  " + getTitle());
		System.out.println("作者  /  " + getAuthorString());
		System.out.println("出版社  /  " + getPublisher());
		System.out.println("期數  /  " + getYear() + "  年第  " + getPeriod() + "  期");
		System.out.println("識別號  /  " + getIdentifier());
		System.out.println("分類號  /  " + getClassification());
		System.out.println("館藏類型  /  " + "雜誌");
		System.out.println("館藏狀態  /  " + (isIssued() ? "已借出" : "架上"));
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

}