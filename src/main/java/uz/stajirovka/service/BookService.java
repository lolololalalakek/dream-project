package uz.stajirovka.service;

import uz.stajirovka.cache.BookCache;
import uz.stajirovka.entity.BookEntity;
import uz.stajirovka.repository.BookRepository;

public class BookService {

    private final BookCache cache;
    private final BookRepository database;

    public BookService(BookCache cache, BookRepository database) {
        this.cache = cache;
        this.database = database;
    }

    public BookEntity findByTitle(String title) {

        BookEntity fromCache = cache.get(title);
        if (fromCache != null) {
            System.out.println("Found in cache: " + title);
            return fromCache;
        }

        System.out.println("No in cache found for title: " + title);
        System.out.println("Now searching in database...");
        System.out.println();
        System.out.println();

        BookEntity fromDb = database.findByTitle(title);
        if (fromDb != null) {
            System.out.println("book found in database for title: " + title);
            cache.put(title, fromDb);
        }
        if  (fromDb == null) {
            System.out.println("No book found in database for title: " + title);
        }


        return fromDb;
    }
}
