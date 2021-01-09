<pre data-language="python" class="rainbow active_pre"><span class="comment from-rainbow">// ..</span>
<span class="keyword from-rainbow">import</span> com.axsos.update.models.Book;
<span class="keyword from-rainbow">import</span> com.axsos.update.services.BookService;
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
}<div id="copy-toolbar-container" style="cursor: pointer; position: absolute; top: 5px; right: 5px; padding: 0px 3px; background: rgba(224, 224, 224, 0.2); box-shadow: rgba(0, 0, 0, 0.2) 0px 2px 0px 0px; color: rgb(187, 187, 187); border-radius: 0.5em; font-size: 0.8em;"><span id="copy-toolbar">copy</span></div></pre>
