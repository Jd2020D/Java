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
<p>In the next few lessons, we will be implementing our views for our mvc application and change our controller code from an API to a full web application.</p>
<h2>All Books</h2>
<p>First, we will create another controller named <code>BooksController</code>. We will also create a view folder named <code>books</code> with a jsp file named <code>index.jsp</code>. When a user visits "/books", we want to show them all the books that we have in our database.</p>
<h5>src/main/java/com/codingdojo/mvc/controllers/BooksController.java</h5>
<pre class="rainbow" data-language="java"><span class="comment from-rainbow active_pre">// ... imports removed for brevity</span>
<span class="support annotation from-rainbow">@Controller</span>
<span class="keyword from-rainbow">public</span> <span class="keyword from-rainbow">class</span> <span class="entity class from-rainbow">BooksController</span> {
    <span class="keyword from-rainbow">private</span> <span class="keyword from-rainbow">final</span> <span class="entity class from-rainbow">BookService</span> bookService;
    
    <span class="keyword from-rainbow">public</span> BooksController(<span class="entity class from-rainbow">BookService</span> bookService) {
        <span class="keyword from-rainbow">this</span>.bookService <span class="operator from-rainbow">=</span> bookService;
    }
    
    <span class="support annotation from-rainbow">@RequestMapping</span>(<span class="string from-rainbow">"/books"</span>)
    <span class="keyword from-rainbow">public</span> <span class="entity class from-rainbow">String</span> index(<span class="entity class from-rainbow">Model</span> model) {
        <span class="entity class from-rainbow">List</span><span class="operator from-rainbow">&lt;</span><span class="entity class from-rainbow">Book</span><span class="operator from-rainbow">&gt;</span> books <span class="operator from-rainbow">=</span> bookService.allBooks();
        model.addAttribute(<span class="string from-rainbow">"books"</span>, books);
        <span class="keyword from-rainbow">return</span> <span class="string from-rainbow">"/books/index.jsp"</span>;
    }
}</pre>
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
        
        
        									
								</div>
