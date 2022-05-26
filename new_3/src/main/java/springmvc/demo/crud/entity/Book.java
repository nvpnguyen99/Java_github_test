package springmvc.demo.crud.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	@NotBlank(message = "Name is required")
	private String name;
	@Column(name = "Author")
	@NotBlank(message = "Author is required")
	private String author;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	@OneToOne(cascade = { CascadeType.ALL })
	@PrimaryKeyJoinColumn
	@Valid
	private BookDetails bookDetails;

	public Book() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BookDetails getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(BookDetails bookDetails) {
		this.bookDetails = bookDetails;
	}

	// getters & setters
	@Override
	public String toString() {
		return "Book{" + "id=" + id + ", name='" + name + '\'' + ", author='" + author + '\'' + ", category name="
				+ category.getName() + ", ISBN=" + bookDetails.getIsbn() + ", Total page="
				+ bookDetails.getNumberOfPage() + ", Price=" + bookDetails.getPrice() + ", Publish date="
				+ bookDetails.getPublishDate() + '}';
	}

}
