<div class="module_description active_lesson_with_video ">
									
            
<h1>Update and Delete</h1>
<p>In this assignment, you will be implementing the update and delete methods and test the endpoints with Postman. Continue using the same mvc project that we have been using so far. Here is some controller code to get you started.</p>
<h5 id="srcmainjavacomcodingdojobookscontrollersbooks.java-1">src/main/java/com/codingdojo/mvc/controllers/BooksApi.java</h5>
<pre data-language="python" class="rainbow active_pre"><span class="comment from-rainbow">// ..</span>
<span class="keyword from-rainbow">import</span> com.codingdojo.mvc.models.Book;
<span class="keyword from-rainbow">import</span> com.codingdojo.mvc.services.BookService;
<span class="entity name function decorator from-rainbow">@RestController</span>
<span class="keyword from-rainbow">public</span> <span class="keyword from-rainbow">class</span> BooksApi {
    <span class="keyword from-rainbow">private</span> final BookService bookService;
    <span class="keyword from-rainbow">public</span> <span class="function call from-rainbow">BooksApi</span>(BookService bookService){
        <span class="keyword from-rainbow">this</span>.bookService <span class="keyword operator from-rainbow">=</span> bookService;
    }
    <span class="comment from-rainbow">// other methods removed for brevity</span>
    <span class="entity name function decorator from-rainbow">@RequestMapping</span>(value<span class="keyword operator from-rainbow">=</span><span class="string from-rainbow">"/api/books/{id}"</span>, method<span class="keyword operator from-rainbow">=</span>RequestMethod.PUT)
    <span class="keyword from-rainbow">public</span> Book <span class="function call from-rainbow">update</span>(<span class="entity name function decorator from-rainbow">@PathVariable</span>(<span class="string from-rainbow">"id"</span>) <span class="keyword from-rainbow">Long</span> id, <span class="entity name function decorator from-rainbow">@RequestParam</span>(value<span class="keyword operator from-rainbow">=</span><span class="string from-rainbow">"title"</span>) <span class="keyword from-rainbow">String</span> title, <span class="entity name function decorator from-rainbow">@RequestParam</span>(value<span class="keyword operator from-rainbow">=</span><span class="string from-rainbow">"description"</span>) <span class="keyword from-rainbow">String</span> desc, <span class="entity name function decorator from-rainbow">@RequestParam</span>(value<span class="keyword operator from-rainbow">=</span><span class="string from-rainbow">"language"</span>) <span class="keyword from-rainbow">String</span> lang, <span class="entity name function decorator from-rainbow">@RequestParam</span>(value<span class="keyword operator from-rainbow">=</span><span class="string from-rainbow">"pages"</span>) <span class="keyword from-rainbow">Integer</span> numOfPages) {
        Book book <span class="keyword operator from-rainbow">=</span> bookService.<span class="function call from-rainbow">updateBook</span>(id, title, desc, lang, numOfPages);
        <span class="keyword from-rainbow">return</span> book;
    }
    
    <span class="entity name function decorator from-rainbow">@RequestMapping</span>(value<span class="keyword operator from-rainbow">=</span><span class="string from-rainbow">"/api/books/{id}"</span>, method<span class="keyword operator from-rainbow">=</span>RequestMethod.<span class="keyword from-rainbow">DELETE</span>)
    <span class="keyword from-rainbow">public</span> <span class="keyword from-rainbow">void</span> <span class="function call from-rainbow">destroy</span>(<span class="entity name function decorator from-rainbow">@PathVariable</span>(<span class="string from-rainbow">"id"</span>) <span class="keyword from-rainbow">Long</span> id) {
        bookService.<span class="function call from-rainbow">deleteBook</span>(id);
    }
}</pre>
<p>Your task is to write the service methods that will correctly update and delete a book. To update a book, you will have to use the setter methods from the domain model and then call the <code>save</code> method. As you can see, <code>save</code> is used for both creating and updating. To delete a book, you will have to use the <code>deleteById</code> method. Below, I have linked to the <code>CrudRepository</code> documentation.
</p>
<div>
    <h3 id="useful-links">Useful Links</h3>
	<ul>
        <li><a href="https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html" target="_blank">CrudRepository Methods</a></li>
    </ul>
</div>
        
