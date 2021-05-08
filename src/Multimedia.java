package b06704043;

public class Multimedia extends Collection{
	
	private String mediaType;
	private String timeLength;
	
	
	public Multimedia(String title, String authorString, String publisher, String mediaType, String timeLength, String identifier, String classification,
			boolean isIssued) {
		super(title, authorString, publisher, identifier, classification, isIssued);
		// TODO Auto-generated constructor stub
		setMediaType(mediaType);
		setTimeLength(timeLength);
	}


	public void listCollectionInformation() {
		System.out.println("---------------------------------");
		System.out.println("標題  /  " + getTitle());
		System.out.println("作者  /  " + getAuthorString());
		System.out.println("出版社  /  " + getPublisher());
		System.out.println("識別號  /  " + getIdentifier());
		System.out.println("分類號  /  " + getClassification());
		System.out.println("館藏類型  /  " + "多媒體影音");
		System.out.println("格式  /  " + getMediaType());
		System.out.println("長度  /  " + getTimeLength());
		System.out.println("館藏狀態  /  " + (isIssued() ? "已借出" : "架上"));
	}


	public String getMediaType() {
		return mediaType;
	}


	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}


	public String getTimeLength() {
		return timeLength;
	}


	public void setTimeLength(String timeLength) {
		this.timeLength = timeLength;
	}

}
