package fi.haagahelia.course.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.Bookstore.domain.Book;
import fi.haagahelia.course.Bookstore.domain.BookRepository;
import fi.haagahelia.course.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryJPAtest {
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByAuthorShouldReturnBook() {
		List<Book> books = repository.findByAuthor("Ernest Hemingway");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Ernest Hemingway");
	}
	
	@Test 
	public void createNewBook() {
		Book testbook = new Book("Test","Test","98765-4", 1843, 12, new Category("Test"));
		repository.save(testbook);
		assertThat(testbook.getId()).isNotNull();
	}
}
