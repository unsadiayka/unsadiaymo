import java.util.ArrayList;
import java.util.List;

interface LibraryItem {
    void borrowItem();
    void returnItem();
    boolean isBorrowed();
}

class Book implements LibraryItem {
    private String title;
    private String author;
    private int publicationYear;
    private boolean isBorrowed;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isBorrowed = false;
    }

    @Override
    public void borrowItem() {
        this.isBorrowed = true;
    }

    @Override
    public void returnItem() {
        this.isBorrowed = false;
    }

    @Override
    public boolean isBorrowed() {
        return this.isBorrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}

class DVD implements LibraryItem {
    private String title;
    private String director;
    private int runningTime;
    private boolean isBorrowed;

    public DVD(String title, String director, int runningTime) {
        this.title = title;
        this.director = director;
        this.runningTime = runningTime;
        this.isBorrowed = false;
    }

    @Override
    public void borrowItem() {
        this.isBorrowed = true;
    }

    @Override
    public void returnItem() {
        this.isBorrowed = false;
    }

    @Override
    public boolean isBorrowed() {
        return this.isBorrowed;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", runningTime=" + runningTime +
                '}';
    }
}

abstract class LibraryUser {
    protected List<LibraryItem> borrowedItems;

    public LibraryUser() {
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowItem(LibraryItem item) {
        item.borrowItem();
        this.borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        item.returnItem();
        this.borrowedItems.remove(item);
    }

    public abstract void printItemsBorrowed();
}

class Student extends LibraryUser {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void printItemsBorrowed() {
        System.out.println("Student " + name + " has borrowed the following items:");
        for (LibraryItem item : this.borrowedItems) {
            System.out.println(item);
        }
    }
}

class Teacher extends LibraryUser {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void printItemsBorrowed() {
        System.out.println("Teacher " + name + " has borrowed the following items:");
        for (LibraryItem item : this.borrowedItems) {
            System.out.println(item);
        }
    }
}

public class App {
    public static void main(String[] args) {
        Book book1 = new Book("Book1", "Author1", 2000);
        Book book2 = new Book("Book2", "Author2", 2005);
        DVD dvd1 = new DVD("DVD1", "Director1", 120);
        DVD dvd2 = new DVD("DVD2", "Director2", 150);

        Student student1 = new Student("Alice");
        student1.borrowItem(book1);
        student1.borrowItem(dvd1);
        System.out.println("Student 1 has borrowed the following items:");
        student1.printItemsBorrowed();

        Student student2 = new Student("Bob");
        student2.borrowItem(book2);
        student2.borrowItem(dvd2);
        System.out.println("Student 2 has borrowed the following items:");
        student2.printItemsBorrowed();

        student1.returnItem(book1);
        System.out.println("After returning Book1:");
        student1.printItemsBorrowed();
    }
}

