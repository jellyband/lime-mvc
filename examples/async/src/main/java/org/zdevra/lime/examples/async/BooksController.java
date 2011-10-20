package org.zdevra.lime.examples.async;

import org.zdevra.guice.mvc.Controller;
import org.zdevra.guice.mvc.ModelName;
import org.zdevra.guice.mvc.Path;
import org.zdevra.guice.mvc.views.ToView;

import java.util.LinkedList;
import java.util.List;

@Controller
@ToView("main")
public class BooksController {

	/**
	 * Method is simulating the long term operation with some delay and returns books
	 * @return
	 */
	@Path("/get") @ModelName("books")
	public List<Book> getBooks()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			//do nothing (I know, it's ugly but the try-catch block is only imaginary delay)
		}

		List<Book> books = new LinkedList<Book>();
		Book b = null;

		b = new Book(
				"Design Patterns: Elements of Reusable Object-Oriented Software",
				"Gamma,Helm,Johnson,Vlissides"
	    );
	    books.add(b);

		b = new Book(
				"Enterprise Integration Patterns: Designing, Building, and Deploying Messaging Solutions",
				"Hohpe,Woolf"
	    );

	    books.add(b);

	    return books;
	}


}