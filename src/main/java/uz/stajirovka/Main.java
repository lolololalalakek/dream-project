package uz.stajirovka;

import uz.stajirovka.cache.BookCache;
import uz.stajirovka.entity.BookEntity;
import uz.stajirovka.repository.BookRepository;
import uz.stajirovka.service.BookService;

public class Main {
    public static void main(String[] args) {


        BookService service = new BookService(new BookCache(), new BookRepository());

        BookEntity firstCall = service.findByTitle("Khtulkus call");
        System.out.println("First call result: " + firstCall);

        BookEntity secondCall = service.findByTitle("Khtulkus call");
        System.out.println("Second call result: " + secondCall);

        BookEntity missing = service.findByTitle("Khtulkus call");
        System.out.println("Missing book result: " + missing);
    }
}
