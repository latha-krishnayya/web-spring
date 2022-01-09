package se.lexicon.webspring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.webspring.domain.Author;
import se.lexicon.webspring.domain.Book;
import se.lexicon.webspring.domain.Publisher;
import se.lexicon.webspring.repositories.AuthorRepository;
import se.lexicon.webspring.repositories.BookRepository;
import se.lexicon.webspring.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG publishing");
        publisher.setCity("Gothenburg");
        publisher.setState("Vastra");

        publisherRepository.save(publisher);


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("book1", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Json");
        Book noEJB=new Book("book2","123125");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("publisher count : "+publisherRepository.count());
        System.out.println("no of books: "+bookRepository.count());
        System.out.println("publisher no of books : "+publisher.getBooks().size());

    }
}
