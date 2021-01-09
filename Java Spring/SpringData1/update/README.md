<div id="module_container">
				<div class="module_content module_content_block">
							
							

								<div class="module_description active_lesson_with_video ">
									
            
<h1>Update and Delete</h1>
<p>In this assignment, you will be implementing the update and delete methods and test the endpoints with Postman. Continue using the same mvc project that we have been using so far. Here is some controller code to get you started.</p>
<h5 id="srcmainjavacomcodingdojobookscontrollersbooks.java-1">src/main/java/com/codingdojo/mvc/controllers/BooksApi.java</h5>
<pre data-language="python" class="rainbow"><span class="comment from-rainbow">// ..</span>
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
        
								</div>

								<div class="appended_module">
									<div class="todo_content">
										<ul class="todo_item_parent">

											<form action="/tracks/submit_todo" method="post" id="form_to_do_items">		

									
												<input type="hidden" name="id" id="task_todo_id" value="5198474">
												<input type="hidden" name="chapter_module_id" value="37523">
												<input type="hidden" name="track_id" value="59">
												<input type="hidden" name="authenticity_token" value="gCz/VXhagBPbvw+J8m4xXTLbZ/FQqkeC+Ul3z+iojlM=">
											</form>
										</ul>
									</div>
										

											<div class="upload_form">
												<h4>Files</h4>
												<table class="upload_item_table table">
													<tbody> 

													

													</tbody>
												</table>

												<div class="how_container"></div>

												<div class="file_upload_container">
													<form action="/tracks/upload_file" class="todo_file_upload_form" method="post" enctype="multipart/form-data">
														<input type="hidden" name="authenticity_token" value="gCz/VXhagBPbvw+J8m4xXTLbZ/FQqkeC+Ul3z+iojlM=">
														<label for="todo_file_upload_37523" class="choose_file"><img src="/assets/add_file.png" alt=""></label>
														<!-- (For online subscription users only?) Add disable if the user is on the other track -->
														<input type="file" name="file" id="todo_file_upload_37523" class="file_name">

														<input type="hidden" name="module_id" value="37523">
														<input type="hidden" name="chapter_id" value="5657">
														<input type="hidden" name="track_content_id" value="1215">
														<span class="upload_name">No file chosen</span>
														<label for="todo_file_upload_37523">
															<!-- <div class="btn btn-primary upload_file_button" data-toggle="modal" data-target=".switch_primary_track_modal">  -->
															<div class="btn btn-primary upload_file_button" current-track-id="59"> 
																<img id="cloud_upload" src="/assets/cloud.png" alt="">
																<span class="upload_file_button_text">Upload</span>
															</div>
														</label>


															<!-- <a href="#" class="btn btn-primary subscription_upload_btn">Upload</a> -->

												</form>
												<div id="for_upload_file" data-target="#upload_file_modal" data-toggle="modal" style="display:none;"><button>click me</button></div>
											</div>

											<span class="or">or</span>
											<div class="github_url_upload_container">
												<form action="/add_todo_url" id="upload_github_url_form">
													<input type="hidden" name="authenticity_token" value="gCz/VXhagBPbvw+J8m4xXTLbZ/FQqkeC+Ul3z+iojlM=">
													<input type="hidden" name="chapter_module_id" value="37523">
													<input type="hidden" name="course_id" value="1820">
													<input type="hidden" name="course_percentage" value="45">
													<input type="hidden" name="track_id" value="59">
													<input type="hidden" name="track_content_id" value="1215">
													<input type="url" name="todo_url" placeholder="Add Github Url"><!-- 
												 --><input type="submit" class="btn btn-primary" value="Save">
												</form>
											</div>

											<!-- Modal for Ask Someone Modal-->
										
											<div class="modal fade ask_someone_modal" tabindex="-1" role="dialog" aria-hidden="true">
												<div class="modal-dialog modal-lg">
													<div class="modal-content" id="pair_programming_content">
													<span class="hide_modal glyphicon glyphicon-remove" data-dismiss="modal" aria-label="Close"></span>
														<div class="modal_header">
															<h4>Ask another student</h4>
														</div>
														<div class="modal_body nano has-scrollbar">
															<div class="nano-content" tabindex="0" style="right: -17px;"> 
																<table class="table remote_student">
																	<tbody></tbody>
																</table>
											                </div>
											            <div class="nano-pane" style="display: none;"><div class="nano-slider" style="height: 20px; transform: translate(0px, 0px);"></div></div></div>   
														<div class="modal_header">
															<h4>Ask a TA</h4>
														</div>
														<div class="modal_body nano has-scrollbar">
															<div class="nano-content" tabindex="0" style="right: -17px;">
																<table class="table remote_ta">
																	<tbody></tbody>
																</table>
											                </div>
											            <div class="nano-pane" style="display: none;"><div class="nano-slider" style="height: 20px; transform: translate(0px, 0px);"></div></div></div>   
													</div>	
												</div>
											</div>
											<!-- End of Ask Someone Modal -->
											
											<!-- Upload File Modal -->
											<div class="modal fade info_modal" id="upload_file_modal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static" data-keyboard="false">
												<div class="modal-dialog" style="margin-top: 237.6px;">
													<div class="modal-content">
														<span class="hide_modal glyphicon glyphicon-remove" data-dismiss="modal" aria-label="Close"></span>
														<div class="modal_header"><h4>Assignment Upload</h4></div>
														<div class="modal_body">
															<p>Great Job! Are you willing to help someone who's struggling with this assignment?</p>
															<a href="#" class="btn btn-default cancel_btn" data-dismiss="modal" target="_blank">MAYBE NEXT TIME.</a>
															<a href="#" class="btn btn-primary submit_btn absolutely_btn" data-dismiss="modal" target="_blank">ABSOLUTELY!</a>
														</div>
													</div>
												</div>
											</div>
											<!-- end of Upload File Modal -->

											<!-- Modal of Pair Program -->
											<div class="modal fade pair_program_modal" tabindex="-1" role="dialog" aria-hidden="true">
												<div class="modal-dialog modal-lg">
													<div class="modal-content" id="pair_programming_content">
														<span class="hide_modal glyphicon glyphicon-remove" data-dismiss="modal" aria-label="Close"></span>
														<div class="modal_header">
															<h4>Pair program with someone else.</h4>
														</div>
														<div class="modal_body nano has-scrollbar">
															<div class="nano-content" tabindex="0" style="right: -17px;">
																<button style="display:none" class="close_pair_program_modal" data-dismiss="modal"></button><table class="table">
																	<tbody class="list_of_pair_programmers">
																	<!-- Loop the pair programmers -->
																	
																	</tbody>
																</table>
											                </div>
											            <div class="nano-pane" style="display: none;"><div class="nano-slider" style="height: 20px; transform: translate(0px, 0px);"></div></div></div>     
													</div>	
												</div>
											</div>
											<!-- end of Pair Programming Modal -->
										</div>
										<!-- start of sample codes for FAQ -->
										<div class="modal fade faq" tabindex="-1" role="dialog" aria-hidden="true">
											<div class="modal-dialog modal-lg">
												<div class="modal-content" id="faq_content">
													<span class="hide_modal glyphicon glyphicon-remove" data-dismiss="modal" aria-label="Close"></span>
													<h4>Discussion : Update and Delete</h4>
													<a href="#" class=" pull-right btn btn-primary" id="create_question" target="_blank">ASK QUESTION</a>
													<div id="faq_scroll" class="nano has-scrollbar">
														<div class="nano-content" tabindex="0" style="right: -17px;">
															<div id="question_container">
																<form id="post_question" class="list-unstyled create_question_container" action="/helps/post_question" method="post">
																	<img src="/assets/profile_pic.png" alt="profile_picture" class="profile_image">
																	<div id="question_form">
																		<input type="hidden" name="authenticity_token" value="gCz/VXhagBPbvw+J8m4xXTLbZ/FQqkeC+Ul3z+iojlM=">
																		<input type="hidden" name="question[module_id]" value="37523">
																		<textarea id="text_question" class="form-control question_value" name="question[text_question]" rows="2" placeholder="Ask Question"></textarea>
																		<div class="post_question_buttons">
																			<button class="btn btn-default cancel_created_question">CANCEL</button>
																			<button class="btn btn-primary post_created_question">POST QUESTION</button>
																		</div>
																	</div> 
																</form>

																<ul class="list-unstyled list_of_question">
																	<!-- Loop questions here -->
																</ul>
																<a href="#" class="show_more_question" target="_blank" style="display: none;">Show more questions (<span class="number_of_question"></span>)</a>
															</div>
														</div>
													<div class="nano-pane" style="display: none;"><div class="nano-slider" style="height: 20px; transform: translate(0px, 0px);"></div></div></div>
												</div>
											</div>	
										</div>
										<!-- end of sample codes for FAQ -->
								</div>

								<!-- Pair Coding Modal -->
								<div class="modal fade info_modal" id="pair_coding_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
									<div class="modal-dialog" style="margin-top: 237.6px;">
										<div class="modal-content">
											<span class="hide_modal glyphicon glyphicon-remove" data-dismiss="modal" aria-label="Close"></span>
											<div class="modal_header">
												<h4>Pair Coding</h4>
											</div>
											<div class="modal_body">
												<p>John is calling you.</p>
												<a href="#" class="btn btn-default cancel_btn" data-dismiss="modal" target="_blank">DECLINE</a>
												<a href="#" class="btn btn-primary submit_btn" data-dismiss="modal" target="_blank">ACCEPT CALL</a>
											</div>
										</div>
									</div>
								</div>
								<!-- end of Pair Coding Modal -->

								<!-- Start Working on This  Modal -->
								<div class="modal fade info_modal" id="start_working_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
									<div class="modal-dialog" style="margin-top: 237.6px;">
										<div class="modal-content">
											<span class="hide_modal glyphicon glyphicon-remove" data-dismiss="modal" aria-label="Close"></span>
											<div class="modal_header">
												<h4>Confirm Action</h4>
											</div>
											<div class="modal_body">
												<p>You have already started working on another assignment. Do you want to discontinue working on previous assignment and start working on this one?</p>
												<a href="#" class="btn btn-default cancel_btn" data-dismiss="modal" target="_blank">No</a>
												<a href="#" class="btn btn-primary submit_btn" id="discontinue_task_btn" data-dismiss="modal" target="_blank">Yes</a>
											</div>
										</div>
									</div>
									<input type="hidden" id="user_pending_task">
									<input id="user_pending_task_token" type="hidden" name="authenticity_token" value="gCz/VXhagBPbvw+J8m4xXTLbZ/FQqkeC+Ul3z+iojlM=">
								</div>
								<!-- end of Start Working on This Modal  -->




						

					
					
					<!-- Modal Inactivity Notice Modal -->
					<div class="modal fade info_modal" id="inactivity_notice_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
						<div class="modal-dialog" style="margin-top: 237.6px;">
							<div class="modal-content">
								<span class="hide_modal glyphicon glyphicon-remove" data-dismiss="modal" aria-label="Close"></span>
								<div class="modal_header">
									<h4>Inactivity Notice</h4>
									<span class="glyphicon glyphicon-question-sign notice_tooltip pull-right" data-toggle="tooltip" data-placement="right" title="" data-original-title="The system keeps track if you are active or not. We are saving the total time you spent on each topic for course improvement and student support purposes."></span>
								</div>
								<div class="modal_body">
									<p>You have been idle for a long time, click the button below if you are you are still there.</p>
									<a href="#" class="btn btn-primary continue_btn" data-dismiss="modal" target="_blank">CLICK TO CONTINUE</a>
								</div>
							</div>
						</div>
					</div>
					<!-- end of Modal Inactivity Notice Modal -->

					<!-- Log out from another device modal --> <!-- end of Log out from another device modal -->
				</div>
			</div>
