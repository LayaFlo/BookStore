package fi.haagahelia.course.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import fi.haagahelia.course.Bookstore.domain.Book;
import fi.haagahelia.course.Bookstore.domain.BookRepository;
import fi.haagahelia.course.Bookstore.domain.Category;
import fi.haagahelia.course.Bookstore.domain.CategoryRepository;
import fi.haagahelia.course.Bookstore.domain.User;
import fi.haagahelia.course.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("Novel"));
			crepository.save(new Category("Allegorical novel"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Sci-fi"));
			
			Book b1 = new Book("A Farewell to Arms", "Ernest Hemingway", "1232323-21", 1929, 7, crepository.findByName("Novel").get(0));
			repository.save(b1);
			Book b2 = new Book("Animal Farm", "George Orwell", "2212343-5", 1945, 8, crepository.findByName("Allegorical novel").get(0));
			repository.save(b2);
			
			// Create users: admin, user 
			//login: usernadia password:usernadia
			//login: adminnadia password:adminnadia
			User user1 = new User("usernadia", "$2a$10$6f4.utIKk4ztbJALQWtvh.G4Tju4R9Us0y1UjJCcK6BgvLA8t/JAG", "USER");
			User user2 = new User("adminnadia", "$2a$10$Vq0OpTqDZIVFHOd97L.nBevIuJL56jBiIwiGjrpXwdVU7Wc0C8Rua", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};
	}
}
