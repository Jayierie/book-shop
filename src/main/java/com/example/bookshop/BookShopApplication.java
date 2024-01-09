package com.example.bookshop;

import com.example.bookshop.dao.*;
import com.example.bookshop.entity.Author;
import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Genre;
import com.example.bookshop.entity.Publisher;
import com.example.bookshop.util.IsbnGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class BookShopApplication {
    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final GenreDao genreDao;
    private final PublisherDao publisherDao;

    @Bean
    @Transactional
    @Profile("data")
    public ApplicationRunner runner() {
        return r -> {
            Author author1 = new Author("Charles Dickens", "charles@gmail.com");
            Author author2 = new Author("Thomas Hardy", "thomas@gmail.com");

            Publisher publisher1 = new Publisher("New Era","new@gmail.com");
            Publisher publisher2 = new Publisher("Sun", "sun@gmail.com");

            Genre genre1 = new Genre();
            genre1.setGenreName("Tragedy");
            Genre genre2 = new Genre();
            genre2.setGenreName("Adventure");

            Book book1 = new Book(
                    1,
                    IsbnGenerator.generate(),
                    "Oliver Twist",
                    "Love Story",
                    50.3,
                    20,
                    "https://source.unsplash.com/random/400×300/?fruit");
            Book book2 = new Book(
                    2,
                    IsbnGenerator.generate(),
                    "Bleak House",
                    "Adventure",
                    30.9,
                    20,
                    "https://source.unsplash.com/random/400×300/?ocean");
            Book book3 = new Book(
                    3,
                    IsbnGenerator.generate(),
                    "Great Expectations",
                    "Good Choice",
                    40.5,
                    20,
                    "https://source.unsplash.com/random/400×300/?nature");
            Book book4 = new Book(
                    4,
                    IsbnGenerator.generate(),
                    "Under The Greenwood Tree",
                    "Excellent",
                    50.3,
                    20,
                    "https://source.unsplash.com/random/400×300/?flower");
            Book book5 = new Book(
                    5,
                    IsbnGenerator.generate(),
                    "Return of the Native",
                    "Good Choice",
                    35.5,
                    20,
                    "https://source.unsplash.com/random/400×300/?home");
            Book book6 = new Book(
                    6,
                    IsbnGenerator.generate(),
                    "Far From the Maddening Crowd",
                    "Excellent",
                    44.9,
                    20,
                    "https://source.unsplash.com/random/400×300/?crowd");

            //mapping
            author1.addBook(book1);
            author1.addBook(book2);
            author1.addBook(book3);

            author2.addBook(book4);
            author2.addBook(book5);
            author2.addBook(book6);

            Publisher pub1 = publisherDao.save(publisher1);
            pub1.addBook(book1);
            pub1.addBook(book2);
            pub1.addBook(book3);

            Publisher pub2 = publisherDao.save(publisher2);
            pub2.addBook(book4);
            pub2.addBook(book5);
            pub2.addBook(book6);

            Genre gen1 = genreDao.save(genre1);
            book1.addGenre(gen1);
            book2.addGenre(gen1);
            book3.addGenre(gen1);

            Genre gen2 = genreDao.save(genre2);
            book4.addGenre(gen2);
            book5.addGenre(gen2);
            book6.addGenre(gen2);

            authorDao.save(author1);
            authorDao.save(author2);


//            bookDao.save(book1);
//            bookDao.save(book2);
//            bookDao.save(book3);
//            bookDao.save(book4);
//            bookDao.save(book5);
//            bookDao.save(book6);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }

}
