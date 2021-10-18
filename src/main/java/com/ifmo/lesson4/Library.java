package com.ifmo.lesson4;

/**
 * Библиотека помогает вести учет книг: какие книги и сколько в ней хранятся.
 * Библиотека ограничена по числу типов книг, это ограничение задается аргументом
 * конструктора maxBookKinds. Например, если библиотека ограничена числом 10,
 * то это означает, что она может хранить 10 разных книг, но любое их количество.
 *
 * Если из библиотеки убираются все книги одного типа, то освобождается место,
 * на которое можно добавить книгу другого типа.
 * Например:
 * <pre>
 *     Library library = new Library(2);
 *     library.put(new Book("Stephen King", "Shining"), 2); // return true
 *     library.put(new Book("Stephen King", "Dark Tower"), 3); // return true
 *
 *     // Эту книгу добавить не можем, т.к. лимит 2
 *     library.put(new Book("Tolstoy", "War and peace"), 6); // return false
 *
 *     // Забираем все книги Тёмной башни, чтобы освободить место.
 *     library.take(new Book("Stephen King", "Dark Tower"), 3) // return 3
 *
 *     // Теперь мы можем успешно добавить "Войну и мир".
 *     library.put(new Book("Tolstoy", "War and peace"), 6); // return true
 * </pre>
 *
 * Если попытаться взять из библиотеки больше книг, чем у нее есть, то она
 * должна вернуть только число книг, которые в ней находились и освободить место.
 * Например:
 *
 * <pre>
 *     Library library = new Library(2);
 *     library.put(new Book("Stephen King", "Shining"), 2); // return true
 *
 *     // Все равно вернет 2, т.к. больше нет.
 *     library.take(new Book("Stephen King", "Shining"), 10) // return 2
 * </pre>
 */


public class Library {

    public static Book[] myLibrary;
    public static int[] booksInShelf;

    public Library(int maxBookKinds) {
        myLibrary = new Book[maxBookKinds];
        for (int i = 0; i < maxBookKinds; i++) {
            myLibrary[i] = new Book("default", "default");
        }
        booksInShelf = new int[maxBookKinds];


        // TODO implement
        // Возможно здесь следует сынициализировать массив.
    }

    /**
     * Add books to library.
     *
     * @param book Book to add.
     * @param quantity How many books to add.
     * @return {@code True} if book successfully added, {@code false} otherwise.
     */
    public boolean put(Book book, int quantity) {
        // TODO implement
        for (int i = 0; i < Library.myLibrary.length; i++) {
            if (Library.myLibrary[i].author == "default"){
                Library.myLibrary[i].author = book.author;
                Library.myLibrary[i].title = book.title;
                booksInShelf[i] += quantity;
                return true;
            } else if (Library.myLibrary[i].author == book.author && Library.myLibrary[i].title == book.title ){
                booksInShelf[i] += quantity;
                return true;
            }
        }

        return false;
    }

    /**
     * Take books from library.
     *
     * @param book Book to take.
     * @param quantity How many books to take.
     * @return Actual number of books taken.
     */
    public int take(Book book, int quantity) {
        // TODO implement
        int ret1 = 0;
        int tempVar = 0;
        for (int i = 0; i < myLibrary.length; i++) {
            if (Library.myLibrary[i].author == book.author &&
                    Library.myLibrary[i].title == book.title){
                ret1 = booksInShelf[i] - quantity;
                tempVar = booksInShelf[i];
                if (ret1<=0){
                    Library.myLibrary[i].author = "default";
                    Library.myLibrary[i].title = "default";
                    booksInShelf[i] = 0;
                    return tempVar;
                }
                booksInShelf[i] = ret1;
                return quantity;
            }
        }

        return ret1;
    }

    public static void main(String[] args) {
        Library myLibrary = new Library(3);
        Book myBook1 = new Book("a1", "t1");
        Book myBook2 = new Book("a2", "t2");
        Book myBook3 = new Book("a3", "t3");
        Book myBook4 = new Book("a4", "t4");

        System.out.println(myLibrary.put(myBook1,1));
        System.out.println(myLibrary.put(myBook2,2));
        System.out.println(myLibrary.put(myBook3,3));
        System.out.println(myLibrary.put(myBook4,4));
        System.out.println(booksInShelf[0]);
        System.out.println(booksInShelf[1]);
        System.out.println(booksInShelf[2]);

        System.out.println(myLibrary.take(myBook3,10));
        System.out.println(booksInShelf[2]);

    }
}
