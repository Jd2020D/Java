<div class="module_description active_lesson_with_video ">
									
            
<h1>Update and Delete</h1>  
<p>In this assignment, you will be implementing the update and delete methods and test the endpoints with Postman. Continue using the same mvc project that we have been using so far. Here is some controller code to get you started.</p>
<h5 id="srcmainjavacomcodingdojobookscontrollersbooks.java-1">src/main/java/com/axsos/update/controllers/BooksApi.java</h5>

// ..
import com.axsos.update.models.Book;
import com.axsos.update.services.BookService;
@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    // other methods removed for brevity
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}

<p>Your task is to write the service methods that will correctly update and delete a book. To update a book, you will have to use the setter methods from the domain model and then call the <span>save</span> method. As you can see, <span>save</span> is used for both creating and updating. To delete a book, you will have to use the <span>deleteById</span> method. Below, I have linked to the <span>CrudRepository</span> documentation.
</p>
<div>
    <h3 id="useful-links">Useful Links</h3>
	<ul>
        <li><a href="https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html" target="_blank">CrudRepository Methods</a></li>
    </ul>
</div>
        
