package study.class_etc.main;
import study.class_etc.Book;
import study.class_etc.Book.BookBuilder;
public interface Main {
	public static void main(String[] args) {
//		Book book = new Book("�ܹ��� ���� 1", "����������������", "�η��� �̷��� �ѷ��ΰ� �������� �����");
//		
//		System.out.println(book.toString());
		Book book;
		BookBuilder builder = Book.builder();
		book = builder.title("�ܹ��� ���� 1").build();
		System.out.println(book.toString());
		

		builder.author("����������������");
		builder.description("�η��� �̷��� �ѷ��ΰ� �������� �����");
		
//		Book book = builder.build();
		book = builder.build();
		System.out.println(book.toString());
		
		Book book1;
		
		book1= Book.builder()
				.title("�̷�������")
				.author("ü�̴׸޼ҵ带")
				.description("����� �� �ִ�")
				.build();
		System.out.println(book1);
		System.out.println(book);
	}
}
