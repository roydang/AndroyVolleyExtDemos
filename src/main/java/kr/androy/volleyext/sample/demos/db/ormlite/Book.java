package kr.androy.volleyext.sample.demos.db.ormlite;

import com.j256.ormlite.field.DatabaseField;

public class Book {
	
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
    private String title;
	@DatabaseField
    private String author;
    
    public Book(){}
    
    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
    
}
