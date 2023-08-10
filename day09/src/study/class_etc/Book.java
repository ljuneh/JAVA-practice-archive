package study.class_etc;

public class Book {
	private String title;
	private String author;
	private String description;
	
	public Book() {}
	public Book(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Book(title=%s, author=%s, description=%s)", title, author, description);
	}
	
	public static BookBuilder builder() {
		return new BookBuilder();
	}
	
	// 내부 클래스(inner class)
	public static class BookBuilder {
		private String title;
		private String author;
		private String description;
		
		public BookBuilder() {}
		
		public BookBuilder title(String title) {
			this.title = title;
			return this;
		}
		public BookBuilder author(String author) {
			this.author = author;
			return this;
		}
		public BookBuilder description(String description) {
			this.description = description;
			return this;
		}
		
		public Book build() {
			return new Book(this.title, this.author, this.description);
		}
	}
}
