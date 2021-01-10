<div class="module_description active_lesson_with_video ">
									
            
<h1>Update and Delete</h1>  
<p>In this assignment, you will be implementing the update and delete methods and test the endpoints with Postman. Continue using the same mvc project that we have been using so far. Here is some controller code to get you started.</p>
<h5 id="srcmainjavacomcodingdojobookscontrollersbooks.java-1">src/main/java/com/axsos/update/controllers/BooksApi.java</h5>

// ..
<p>import com.axsos.update.models.Book;</p>
<p>import com.axsos.update.services.BookService;</p>
<p>@RestController</p>
<p>public class BooksApi {</p>
<p>    private final BookService bookService;</p>
<p>    public BooksApi(BookService bookService){</p>
<p>        this.bookService = bookService;</p>
<p>    }</p>
<p>    // other methods removed for brevity</p>
<p>    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)</p>
<p>    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language")</p> <p>String lang, @RequestParam(value="pages") Integer numOfPages) {</p>
<p>        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);</p>
<p>        return book;</p>
<p>    }</p>
<p>    </p>
<p>    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)</p>
<p>    public void destroy(@PathVariable("id") Long id) {</p>
<p>        bookService.deleteBook(id);</p>
<p>    }</p>
<p>}</p>

<p>Your task is to write the service methods that will correctly update and delete a book. To update a book, you will have to use the setter methods from the domain model and then call the <span>save</span> method. As you can see, <span>save</span> is used for both creating and updating. To delete a book, you will have to use the <span>deleteById</span> method. Below, I have linked to the <span>CrudRepository</span> documentation.
</p>
<div>
    <h3 id="useful-links">Useful Links</h3>
	<ul>
        <li><a href="https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html" target="_blank">CrudRepository Methods</a></li>
    </ul>
</div>

<div class="module_description active_lesson active_lesson_with_video ">
									
            
            
            
<h1>Index</h1>
<p>In the next few updates, we will be implementing our views for our mvc application and change our controller code from an API to a full web application.</p>
<h2>All Books</h2>
<p>First, we will create another controller named <code>BooksController</code>. We will also create a view folder named <code>books</code> with a jsp file named <code>index.jsp</code>. When a user visits "/books", we want to show them all the books that we have in our database.</p>
<h5>src/main/java/com/axsos/update/controllers/BooksController.java</h5>
<p>// ... imports removed for brevity</p>
<p>@Controller</p>
<p>public class BooksController {</p>
<p>    private final BookService bookService;</p>
<p>    </p>
<p>    public BooksController(BookService bookService) {</p>
<p>        this.bookService = bookService;</p>
<p>    }</p>
<p>    </p>
<p>    @RequestMapping("/books")</p>
<p>    public String index(Model model) {</p>
<p>        List<Book> books = bookService.allBooks();</p>
<p>        model.addAttribute("books", books);</p>
<p>        return "/books/index.jsp";</p>
<p>    }</p>
<p>}</p>
<h5>src/main/webapp/WEB-INF/books/index.jsp</h5>
<pre class="">&lt;%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%&gt;    
&lt;h1&gt;All Books&lt;/h1&gt;
&lt;table&gt;
    &lt;thead&gt;
        &lt;tr&gt;
            &lt;th&gt;Title&lt;/th&gt;
            &lt;th&gt;Description&lt;/th&gt;
            &lt;th&gt;Language&lt;/th&gt;
            &lt;th&gt;Number of Pages&lt;/th&gt;
        &lt;/tr&gt;
    &lt;/thead&gt;
    &lt;tbody&gt;
        &lt;c:forEach items="${books}" var="book"&gt;
        &lt;tr&gt;
            &lt;td&gt;&lt;c:out value="${book.title}"/&gt;&lt;/td&gt;
            &lt;td&gt;&lt;c:out value="${book.description}"/&gt;&lt;/td&gt;
            &lt;td&gt;&lt;c:out value="${book.language}"/&gt;&lt;/td&gt;
            &lt;td&gt;&lt;c:out value="${book.numberOfPages}"/&gt;&lt;/td&gt;
        &lt;/tr&gt;
        &lt;/c:forEach&gt;
    &lt;/tbody&gt;
&lt;/table&gt;
&lt;a href="/books/new"&gt;New Book&lt;/a&gt;
</pre>
<p> <br> <br> </p>
<div class="module_content module_content_block">
							
							<input type="hidden" id="current_module_id" name="authenticity_token" value="gCz/VXhagBPbvw+J8m4xXTLbZ/FQqkeC+Ul3z+iojlM=" current-module="37525" course-percentage="46" track-content-id="1215"> 
							

								<div class="module_description active_lesson active_lesson_with_video ">
									
<h1>New and Create</h1>
<h2>New Book</h2>
<p>When the user visits "/books/new", we want to show them the form to create the book.</p>
<h5>src/main/java/com/axsos/update/controllers/BooksController.java</h5>
<p>// ... imports removed for brevity</p>
<p>@Controller</p>
<p>public class BooksController {</p>
<p>    // other methods removed for brevity</p>
<p>    </p>
<p>    @RequestMapping("/books/new")</p>
<p>    public String newBook(@ModelAttribute("book") Book book) {</p>
<p>        return "/books/new.jsp";</p>
<p>    }</p>
<p>    @RequestMapping(value="/books", method=RequestMethod.POST)</p>
<p>    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {</p>
<p>        if (result.hasErrors()) {</p>
<p>            return "/books/new.jsp";</p>
<p>        } else {</p>
<p>            bookService.createBook(book);</p>
<p>            return "redirect:/books";</p>
<p>        }</p>
<p>    }</p>
<p>}</p>

<h5>src/main/webapp/WEB-INF/books/new.jsp</h5>
<pre class="">&lt;%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%&gt;    
&lt;h1&gt;New Book&lt;/h1&gt;
&lt;form:form action="/books" method="post" modelAttribute="book"&gt;
    &lt;p&gt;
        &lt;form:label path="title"&gt;Title&lt;/form:label&gt;
        &lt;form:errors path="title"/&gt;
        &lt;form:input path="title"/&gt;
    &lt;/p&gt;
    &lt;p&gt;
        &lt;form:label path="description"&gt;Description&lt;/form:label&gt;
        &lt;form:errors path="description"/&gt;
        &lt;form:textarea path="description"/&gt;
    &lt;/p&gt;
    &lt;p&gt;
        &lt;form:label path="language"&gt;Language&lt;/form:label&gt;
        &lt;form:errors path="language"/&gt;
        &lt;form:input path="language"/&gt;
    &lt;/p&gt;
    &lt;p&gt;
        &lt;form:label path="numberOfPages"&gt;Pages&lt;/form:label&gt;
        &lt;form:errors path="numberOfPages"/&gt;     
        &lt;form:input type="number" path="numberOfPages"/&gt;
    &lt;/p&gt;    
    &lt;input type="submit" value="Submit"/&gt;
&lt;/form:form&gt;    
</pre>
									
