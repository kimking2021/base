package priv.kimking.base.spring.bean.entity;

import java.io.Serializable;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/27
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 8385108608138140608L;
    private int id;
    private String bookName;
    private String desc;
    private String author;

    public Book() {
        System.out.println("Book constructor invoke...");
    }

    public Book(int id, String bookName, String desc, String author) {
        this.id = id;
        this.bookName = bookName;
        this.desc = desc;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", desc='" + desc + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
