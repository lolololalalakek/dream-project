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

        System.out.println("Not in cache, reading from database: " + title);
        BookEntity fromDb = database.findByTitle(title);
        if (fromDb != null) {
            cache.put(title, fromDb);
        }
        return fromDb;
    }
}
