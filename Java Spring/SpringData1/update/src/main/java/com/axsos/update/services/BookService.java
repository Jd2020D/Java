package com.axsos.update.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;
import com.axsos.update.models.Book;
import com.axsos.update.repositories.BookRepository;
@Service
public class BookService {
 // adding the book repository as a dependency
 private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();	
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 public Book updateBook(Long id ,String title, String desc, String lang, int pages) {
	 Book book=this.findBook(id);
	 if (book!= null) {
		 book.setTitle(title);
		 book.setDescription(desc);
		 book.setLanguage(lang);
		 book.setNumberOfPages(pages);
		 bookRepository.save(book);
	     return book;
	 }
	 return null;
		 
 }
 public Book updateBook(Book b) {
	 Book book=this.findBook(b.getId());
	 if (book!= null) {
		 return bookRepository.save(b);
	 }
	 return null;

 }
 
 public void deleteBook(Long id) {
	 try {
		 bookRepository.deleteById(id);
	 }catch(Exception e) {
	 }
 }
}
