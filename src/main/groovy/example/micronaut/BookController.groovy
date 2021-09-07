package example.micronaut
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.validation.Valid
import groovy.transform.CompileStatic
import io.micronaut.security.annotation.Secured
import static io.micronaut.security.rules.SecurityRule.IS_AUTHENTICATED

@CompileStatic
@Controller
@Secured(IS_AUTHENTICATED)
class BookController {

    @Post
    BookSaved save(@Valid @Body Book book) {
        BookSaved bookSaved = new BookSaved()
        bookSaved.name = book.name
        bookSaved.isbn = UUID.randomUUID().toString()
        bookSaved
    }
}
