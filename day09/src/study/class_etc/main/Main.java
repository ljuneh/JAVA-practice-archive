package study.class_etc.main;
import study.class_etc.Book;
import study.class_etc.Book.BookBuilder;
public interface Main {
	public static void main(String[] args) {
//		Book book = new Book("꿀벌의 예언 1", "베르나르베르베르", "인류의 미래를 둘러싸고 펼쳐지는 대모험");
//		
//		System.out.println(book.toString());
		Book book;
		BookBuilder builder = Book.builder();
		book = builder.title("꿀벌의 예언 1").build();
		System.out.println(book.toString());
		

		builder.author("베르나르베르베르");
		builder.description("인류의 미래를 둘러싸고 펼쳐지는 대모험");
		
//		Book book = builder.build();
		book = builder.build();
		System.out.println(book.toString());
		
		Book book1;
		
		book1= Book.builder()
				.title("이런식으로")
				.author("체이닝메소드를")
				.description("사용할 수 있다")
				.build();
		System.out.println(book1);
		System.out.println(book);
	}
}
