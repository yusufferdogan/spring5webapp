package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepositories;
import guru.springframework.spring5webapp.repositories.BookRepositories;
import guru.springframework.spring5webapp.repositories.PublisherRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepositories authorRepository;
    private final BookRepositories bookRepository;
    private final PublisherRepositories publisherRepository;

    public BootStrapData(AuthorRepositories authorRepository, BookRepositories bookRepository, PublisherRepositories publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author yusuf = new Author("yusuf", "erdo");
        Book fire = new Book("yangın sondurme", "123456");
        Publisher publisher1 = new Publisher("111", "filyos","zonguldak","karadeniz","67660");
        yusuf.getBooks().add(fire);
        fire.getAuthors().add(yusuf);

        authorRepository.save(yusuf);
        bookRepository.save(fire);
        publisherRepository.save(publisher1);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        Publisher publisher2 = new Publisher("222", "kartal","istanbul","marmara","34862");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());

    }
}
