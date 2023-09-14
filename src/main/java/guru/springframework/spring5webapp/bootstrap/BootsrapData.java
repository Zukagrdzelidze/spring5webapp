package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Domain.Author;
import guru.springframework.spring5webapp.Domain.Book;
import guru.springframework.spring5webapp.Domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootsrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap started");

        Publisher sulakauri = new Publisher("sulakauris gamomcemloba", "0171", "Chavchavadze 25", "Georgia", "Tbilisi");
        publisherRepository.save(sulakauri);

        Author hemigway = new Author("Ernest", "Hemigway");
        Book farewellToArms = new Book("A Farewell To Arms", "0151515");
        hemigway.getBooks().add(farewellToArms);
        farewellToArms.getAuthors().add(hemigway);


        farewellToArms.setPublisher(sulakauri);
        sulakauri.getBooks().add(farewellToArms);

        authorRepository.save(hemigway);
        bookRepository.save(farewellToArms);
        publisherRepository.save(sulakauri);

        Author vazhaPshavela = new Author("Vazha", "Pshavela");
        Book aluda = new Book("Aluda Ketelauri", "0105145");
        vazhaPshavela.getBooks().add(aluda);
        aluda.getAuthors().add(vazhaPshavela);

        aluda.setPublisher(sulakauri);
        sulakauri.getBooks().add(aluda);


        authorRepository.save(vazhaPshavela);
        bookRepository.save(aluda);
        publisherRepository.save(sulakauri);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of books in sulakauri: " + sulakauri.getBooks().size());
    }
}
