package bd;

import java.io.Console;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Integer managerId = null;
    private static Integer employeeId = null;
    private static Integer userId = null;


    public static void main(String[] args){

        Main.loginProcess();

        if (managerId!=null){
            Main.Manager();
        }
        else if (employeeId!=null){
            Main.Employee();
        }
        if (userId!=null){
            Main.User();
        }
    }

    private static void loginProcess(){
        boolean result;
        Console console = System.console();
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("Login as:\n1.Manager\n2.Employee\n3.User");
        choice = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        char[] password_char = console.readPassword("Password: ");
        String password = String.valueOf(password_char);
            switch (choice) {
                case "1" -> {
                    result = checkLoggingManagers(login, password);
                    if (result) {
                        System.out.println("Logged in as Manager");
                    } else {
                        System.out.println(("Invalid login and/or password"));
                    }
                }
                case "2" -> {
                    result = checkLoggingEmployees(login, password);
                    if (result) {
                        System.out.println("Logged in as Employee");
                    } else {
                        System.out.println(("Invalid login and/or password"));
                    }
                }
                case "3" -> {
                    result = checkLoggingUsers(login, password);
                    if (result) {
                        System.out.println("Logged in as User");
                    } else {
                        System.out.println(("Invalid login and/or password"));
                    }
                }
                default -> System.out.println("Invalid choice");
            }
    }

    private static boolean checkLoggingManagers(String login, String password){
        try {
            var login_map = LibraryDatabase.getManagersLoginInfo();
            for (var id : login_map.keySet()) {
                if (login_map.get(id).get("login").equals(login) && login_map.get(id).get("password").equals(password)) {
                    managerId = id;
                    return true;
                }
            }
        }
        catch (SQLException e){
            System.out.println("Cannot initialize logging process " + e.getMessage());
            System.exit(1);
        }
        return false;
    }

    private static boolean checkLoggingUsers(String login, String password){
        try {
            var login_map = LibraryDatabase.getUsersLoginInfo();
            for (var id : login_map.keySet()) {
                if (login_map.get(id).get("login").equals(login) && login_map.get(id).get("password").equals(password)) {
                    userId = id;
                    return true;
                }
            }
        }
        catch (SQLException e){
            System.out.println("Cannot initialize logging process " + e.getMessage());
            System.exit(1);
        }
        return false;
    }

    private static boolean checkLoggingEmployees(String login, String password){
        try {
            var login_map = LibraryDatabase.getEmployeesLoginInfo();
            for (var id : login_map.keySet()) {
                if (login_map.get(id).get("login").equals(login) && login_map.get(id).get("password").equals(password)) {
                    employeeId = id;
                    return true;
                }
            }
        }
        catch (SQLException e){
            System.out.println("Cannot initialize logging process " + e.getMessage());
            System.exit(1);
        }
        return false;
    }

    private static void Manager(){
        boolean exit = false;
        String choice;
        Scanner scanner = new Scanner(System.in);
        while (!exit){
            System.out.println("Choose:\n0.Exit\n1.Show all users\n2.Show all books\n3.Modify books\n4.Modify Users");
            choice = scanner.nextLine();
            switch (choice) {
                case "0" -> exit = true;
                case "1" -> {
                    try {
                        var users = LibraryDatabase.getUsersAsStringAll();
                        for (var user : users) {
                            System.out.println(user);
                        }
                    } catch (SQLException e) {
                        System.out.println("Couldn't get users " + e.getMessage());
                        exit = true;
                    }
                }
                case "2" -> {
                    try {
                        var books = LibraryDatabase.getBooksAsStringAll();
                        for (var book : books) {
                            System.out.println(book);
                        }
                    } catch (SQLException e) {
                        System.out.println("Couldn't get books " + e.getMessage());
                        exit =  true;
                    }
                }
                case "3" ->{
                    try{
                        System.out.println("Choose:\n1.Add\n2.Remove");
                        String mode = scanner.nextLine();
                        switch (mode){
                            case "1"->{
                                System.out.println("Name: ");
                                String name = scanner.nextLine();
                                System.out.println("Author: ");
                                String author = scanner.nextLine();
                                System.out.println("Category: ");
                                String cat = scanner.nextLine();
                                System.out.println("Dep_id: ");
                                int dep = Integer.parseInt(scanner.nextLine());
                                LibraryDatabase.addBook(name, author, cat, dep);
                            }
                            case "2"->{
                                var books = LibraryDatabase.getBooks();
                                for (var book : books.keySet()) {
                                    System.out.println(book+ " " + books.get(book));
                                }
                                System.out.println("Choose book_id: ");
                                int book_id = Integer.parseInt(scanner.nextLine());
                                if (!books.containsKey(book_id)){
                                    System.out.println("Invalid book_id");
                                }
                                else{
                                    LibraryDatabase.removeBook(book_id);
                                }
                            }
                            default -> System.out.println("Invalid choice");
                        }
                    }
                    catch (SQLException e) {
                        System.out.println(e.getMessage());
                        exit =  true;
                    }
                    catch (java.lang.NumberFormatException e) {
                        System.out.println("Invalid format of input");
                    }
                }
                case "4" ->{
                    try{
                        System.out.println("Choose:\n1.Add\n2.Remove");
                        String mode = scanner.nextLine();
                        switch (mode){
                            case "1"->{
                                System.out.println("Name: ");
                                String name = scanner.nextLine();
                                System.out.println("Surname: ");
                                String surname = scanner.nextLine();
                                System.out.println("Email: ");
                                String email = scanner.nextLine();
                                System.out.println("Phone number: ");
                                String phone_n = scanner.nextLine();
                                System.out.println("Login (leave empty if no account must be created): ");
                                String login = scanner.nextLine();
                                System.out.println("Pasword (as above): ");
                                String password = scanner.nextLine();
                                LibraryDatabase.addUser(name, surname, email, phone_n, login, password);
                            }
                            case "2"->{
                                var users = LibraryDatabase.getUsers();
                                for (var usr : users.keySet()) {
                                    System.out.println(usr+ " " + users.get(usr));
                                }
                                System.out.println("Choose user_id: ");
                                int user_id = Integer.parseInt(scanner.nextLine());
                                if (!users.containsKey(user_id)){
                                    System.out.println("Invalid user_id");
                                }
                                else{
                                    LibraryDatabase.removeUser(user_id);
                                }
                            }
                            default -> System.out.println("Invalid choice");
                        }
                    }
                    catch (SQLException e) {
                        System.out.println(e.getMessage());
                        exit =  true;
                    }
                    catch (java.lang.NumberFormatException e) {
                        System.out.println("Invalid format of input - must be integer");
                    }
                }

                default -> System.out.println("Invalid choice");
            }
        }
        System.exit(0);
    }

    private static void User(){
        boolean exit = false;
        String choice;
        Scanner scanner = new Scanner(System.in);
        while (!exit){
            System.out.println("Choose:\n0.Exit\n1.Show all books\n2.Order book\n3.Show ordered and borrowed\n4.Show penalties\n");
            choice = scanner.nextLine();
            switch (choice) {
                case "0" -> exit = true;
                case "1" -> {
                    try {
                        var books = LibraryDatabase.getBooksAsStringAll();
                        System.out.println("ID name\t\t\t\tcategory\tdepartment");
                        for (var book : books) {
                            System.out.println(book);
                        }
                    } catch (SQLException e) {
                        System.out.println("Couldn't get books " + e.getMessage());
                        exit =  true;
                    }
                }
                case "2" ->{
                    try {
                        System.out.println(userId);
                        var books = LibraryDatabase.getBooks();
                        System.out.println("ID name\t\t\t\tcategory\tdepartment");
                        for (var book : books.keySet()) {
                            System.out.println(book+ " " + books.get(book));
                        }
                        System.out.println("Choose book_id: ");
                        int book_id = Integer.parseInt(scanner.nextLine());
                        if (!books.containsKey(book_id)){
                            System.out.println("Invalid book_id");
                        }
                        else{
                            System.out.println("Choose months: ");
                            int months = Integer.parseInt(scanner.nextLine());
                            LibraryDatabase.orderBook(userId, book_id, months);
                        }

                    } catch (SQLException e) {
                        if (e.getErrorCode() == 20001) {
                            System.out.println("Invalid rental period");
                        }
                        else if (e.getErrorCode() == 20003) {
                            System.out.println("Invalid book ID");
                        }
                        else if(e.getErrorCode() == 20002) {
                            System.out.println("Invalid user ID");
                        }
                        else {
                            System.out.println(e.getMessage());
                            exit = true;
                        }
                    }
                    catch (java.lang.NumberFormatException e) {
                        System.out.println("Invalid format of order_id - must be integer");
                    }

                }
                case "3"->{
                    try {
                        System.out.println("book id\tborrowed or ordered");
                        var results = LibraryDatabase.getUsersBorrowedOrdered(Main.userId);
                        for(var result: results){
                            System.out.println(result);
                        }
                    }
                    catch (SQLException e){
                        System.out.println(e.getMessage());
                        exit =  true;
                    }

                }
                case "4"->{
                    try {
                        System.out.println("book id\tpenalty");
                        var results = LibraryDatabase.getUsersPenalties(Main.userId);
                        if (results.isEmpty()){
                            System.out.println("No penalties");
                        }
                        else{
                        for(var result: results.keySet()){
                            System.out.println(result + "\t" + results.get(result));
                        }}
                    }
                    catch (SQLException e){
                        System.out.println(e.getMessage());
                        exit =  true;
                    }
                }
               default -> System.out.println("Invalid choice");
            }
        }
        System.exit(0);
    }

    private static void Employee(){
        boolean exit = false;
        String choice;
        Scanner scanner = new Scanner(System.in);
        while (!exit){
            System.out.println("Choose:\n0.Exit\n1.Show all users\n2.Show all books\n3.Borrow book\n4.Return book");
            choice = scanner.nextLine();
            switch (choice) {
                case "0" -> exit = true;
                case "1" -> {
                    try {
                        var users = LibraryDatabase.getUsersAsString();
                        System.out.println("ID name\tsurname\temail\tphone number\tlogin\tpassword");
                        for (var user : users) {
                            System.out.println(user);
                        }
                    } catch (SQLException e) {
                        System.out.println("Couldn't get users " + e.getMessage());
                        exit = true;
                    }
                }
                case "2" -> {
                    try {
                        var books = LibraryDatabase.getBooksAsStringAll();
                        System.out.println("ID name\t\t\t\tcategory\tdepartment");
                        for (var book : books) {
                            System.out.println(book);
                        }
                    } catch (SQLException e) {
                        System.out.println("Couldn't get books " + e.getMessage());
                        exit =  true;
                    }
                }
                case "3" -> {
                    try{
                        var orders = LibraryDatabase.getOrdered();
                        System.out.println("Order id\tbook id\tuser id\ttime");
                        for (var order:orders.keySet()){
                            System.out.println(order + "\t\t" + orders.get(order).get(0) + "\t" + orders.get(order).get(1) + "\t" + orders.get(order).get(2));
                        }
                        System.out.println("Choose order id: ");
                        int order_id = Integer.parseInt(scanner.nextLine());
                        if (!orders.containsKey(order_id)){
                            System.out.println("Invalid order_id");
                        }
                        else{
                            int book_id = orders.get(order_id).get(0);
                            int user_id = orders.get(order_id).get(1);
                            var result = LibraryDatabase.borrowBook(user_id, book_id);
                            if(!result){
                                System.out.println("Already borrowed");
                            }
                        }
                    } catch (SQLException e) {
                        if (e.getErrorCode() == 20005){
                            System.out.println("Already borrowed");
                        } else if (e.getErrorCode() == 20003) {
                            System.out.println("Invalid book ID");
                        }
                        else if(e.getErrorCode() == 20002){
                            System.out.println("Invalid user ID");
                        }
                        else if(e.getErrorCode() == 20004){
                            System.out.println("No order found");
                        }
                        else {
                            System.out.println("Couldn't borrow " + e.getMessage());
                        }
                    }
                    catch (java.lang.NumberFormatException e) {
                        System.out.println("Invalid format of order_id - must be integer");
                    }
                }
                case "4" ->{
                    try{
                        var borrows = LibraryDatabase.getBorrowed();
                        System.out.println("Borrow id\tuser id\tbook id");
                        for (var borrow:borrows.keySet()){
                            System.out.println(borrow + "\t\t" + borrows.get(borrow).get(0) + "\t"+ borrows.get(borrow).get(1));
                        }
                        System.out.println("Choose borrowed id: ");
                        int borrow_id = Integer.parseInt(scanner.nextLine());
                        if (!borrows.containsKey(borrow_id)){
                            System.out.println("Invalid borrowed_id");
                        }
                        else{
                            int user_id = borrows.get(borrow_id).get(0);
                            int book_id = borrows.get(borrow_id).get(1);
                            LibraryDatabase.returnBook(user_id, book_id);
                        }
                    } catch (SQLException e) {
                        if (e.getErrorCode() == 20003) {
                            System.out.println("Invalid book ID");
                        }
                        else if(e.getErrorCode() == 20002){
                            System.out.println("Invalid user ID");
                        }
                        else{
                            System.out.println("Couldn't return " + e.getMessage());}
                    }
                    catch (java.lang.NumberFormatException e) {
                        System.out.println("Invalid format of borrowed_id - must be integer");
                    }
                }

                default -> System.out.println("Invalid choice");
            }
        }
        System.exit(0);
    }
}
