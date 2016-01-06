public class BookReader
{
    // user membership creation and extension
    // searching the data base of books
    // reading the books

    public class Book
    {
        private String bookName;
        private long ID;
        // all the books should also have unique ID
        // private int pages;
        private static Set<Book> books;
        // the book set for one user?

        public Book(long ID, String bookName)
        {
            this.ID = ID;
            this.bookName = bookName;
        }

        public static void addBook(long id, String name)
        {
            books.add(new Book(id, name));
        }

        public void update()
        {
            // online update the book content?
        }

        public static void delete(Book book)
        {
            books.remove(b);
            // need to know more details about Set data structure
        }

        public long getID()
        {
            return ID;
        }

        public static Book find(long id)
        {
            for (Book b : books)
            {
                if (b.getID() == id) 
                    return b;
            }

            return null;
        }
    }

    public class User
    {
        private String userName;
        private long ID;
        private String password;
        private int accountType;    // don't know what is used for...

        private static Set<User> users;

        public User(String name, long id, int accountType)
        {
            userName = name;
            ID = id;
            this.accountType = accountType;
        }
        public Book searchLibrary(long id)
        {
            return Book.find(id);
            // find is a static method so user part no need to have Book object
        }

        public void renewMemberShip()
        {
            // renew the membership using some method
        }

        public long getID()
        {
            return ID;
        }
        public static User find(long id)
        {
            for (User user : users)
            {
                if (user.getID() == id)
                    return user;
            }
            return null;
        }

        public static void addUser(long id, String name, int accountType)
        {
            users.addUser(new User(id, name, accountType));
        }

    }

    private Book book;
    private User user;
    public BookReader(Book b, User u)
    {
        book = b;
        user = u;
    }

    public void listenRequest()
    {
        // don't know what is used for...
        // incoming request to log in
    }

    public Book searchBook(long ID)
    {
        return Book.find(ID);
    }

    public User searchUser(long ID)
    {
        return User.find(ID);
        // end user interacts through this class 
    }

    public void display()
    {
        // don't know what this can do...
    }


}