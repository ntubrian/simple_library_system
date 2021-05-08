package b06704043;

abstract class Collection {
	
	private String title;
	private String authorString;
	private String publisher;
	private String identifier;
	private String classification;
	private boolean isIssued; //記錄借出狀態與否
	private Reader currentBorrowReader;
	
	
	
	public Collection(String title, String authorString, String publisher, String identifier, String classification,
			boolean isIssued) {
		this.title = title;
		this.authorString = authorString;
		this.publisher = publisher;
		this.identifier = identifier;
		this.classification = classification;
		this.isIssued = isIssued;
	}

	public abstract void listCollectionInformation();
	
	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorString() {
		return authorString;
	}
	public void setAuthorString(String authorString) {
		this.authorString = authorString;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Reader getCurrentBorrowReader() {
		return currentBorrowReader;
	}

	public void setCurrentBorrowReader(Reader currentBorroweReader) {
		this.currentBorrowReader = currentBorroweReader;
	}
	
}
