package bd;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

public class LibraryDatabase {

    private static final String URL = "jdbc:oracle:thin:@//ora4.ii.pw.edu.pl:1521/pdb1.ii.pw.edu.pl";
    private static final String LOGIN = "z90";
    private static final String PASSWORD = "pxr7is";
    private static Connection CONNECTION;


    public static ArrayList<String> getUsersAsStringAll() throws SQLException {
        ArrayList<String> users_list = new ArrayList<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement query = CONNECTION.createStatement();
        ResultSet result = query.executeQuery(DatabaseConstants.Selects.SELECT_USERS);
        while (result.next()) {
            int id = result.getInt("user_id");
            String name = result.getString("name");
            String surname = result.getString("surname");
            String mail = result.getString("email");
            String phone_nr = result.getString("phone_number");
            String login = result.getString("login");
            String password = result.getString("password");
            String user = id + " " + name + " " + surname + " " + mail + " " + phone_nr + " " + login + " " + password;
            users_list.add(user);
        }
        CONNECTION.close();
        return users_list;

    }

    public static ArrayList<String> getUsersAsString() throws SQLException {
        ArrayList<String> users_list = new ArrayList<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement query = CONNECTION.createStatement();
        ResultSet result = query.executeQuery(DatabaseConstants.Selects.SELECT_USERS);
        while (result.next()) {
            int id = result.getInt("user_id");
            String name = result.getString("name");
            String surname = result.getString("surname");
            String mail = result.getString("email");
            String phone_nr = result.getString("phone_number");
            String user = id + " " + name + " " + surname + " " + mail + " " + phone_nr;
            users_list.add(user);
        }
        CONNECTION.close();
        return users_list;

    }

    public static ArrayList<String> getBooksAsStringAll() throws SQLException {
        ArrayList<String> book_list = new ArrayList<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement query = CONNECTION.createStatement();
        ResultSet result = query.executeQuery(DatabaseConstants.Selects.SELECT_BOOKS);
        while (result.next()) {
            int id = result.getInt("book_id");
            String name = result.getString("name");
            String surname = result.getString("author");
            String cat = result.getString("category");
            int dep_id = result.getInt("department_id");
            String book = id + " " + name + " " + surname + " " + cat + " " + dep_id;
            book_list.add(book);
        }
        CONNECTION.close();
        return book_list;
    }

    public static HashMap<Integer, HashMap<String, String>> getManagersLoginInfo() throws SQLException {
        HashMap<Integer, HashMap<String, String>> login_list = new HashMap<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement query = CONNECTION.createStatement();
        ResultSet result = query.executeQuery(DatabaseConstants.Selects.SELECT_MANAGERS);
        while (result.next()) {
            String login = result.getString("login");
            String password = result.getString("password");
            Integer id = result.getInt("manager_id");
            HashMap<String, String> login_info = new HashMap<>();
            login_info.put("login", login);
            login_info.put("password", password);
            login_list.put(id, login_info);
        }
        CONNECTION.close();
        return login_list;
    }

    public static HashMap<Integer, HashMap<String, String>> getEmployeesLoginInfo() throws SQLException {
        HashMap<Integer, HashMap<String, String>> login_list = new HashMap<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement query = CONNECTION.createStatement();
        ResultSet result = query.executeQuery(DatabaseConstants.Selects.SELECT_EMPLOYEES);
        while (result.next()) {
            String login = result.getString("login");
            String password = result.getString("password");
            Integer id = result.getInt("employee_id");
            HashMap<String, String> login_info = new HashMap<>();
            login_info.put("login", login);
            login_info.put("password", password);
            login_list.put(id, login_info);
        }
        CONNECTION.close();
        return login_list;
    }

    public static HashMap<Integer, HashMap<String, String>> getUsersLoginInfo() throws SQLException {
        HashMap<Integer, HashMap<String, String>> login_list = new HashMap<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement query = CONNECTION.createStatement();
        ResultSet result = query.executeQuery(DatabaseConstants.Selects.SELECT_USERS);
        while (result.next()) {
            String login = result.getString("login");
            String password = result.getString("password");
            Integer id = result.getInt("user_id");
            HashMap<String, String> login_info = new HashMap<>();
            login_info.put("login", login);
            login_info.put("password", password);
            login_list.put(id, login_info);
        }
        CONNECTION.close();
        return login_list;
    }

    public static HashMap<Integer, String> getBooks() throws SQLException {
        HashMap<Integer, String> book_list = new HashMap<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement query = CONNECTION.createStatement();
        ResultSet result = query.executeQuery(DatabaseConstants.Selects.SELECT_BOOKS);
        while (result.next()) {
            int id = result.getInt("book_id");
            String name = result.getString("name");
            String surname = result.getString("author");
            String cat = result.getString("category");
            String dep_id = String.valueOf(result.getInt("department_id"));
            String book_info =  name + " " + surname + " " + cat + " " + dep_id;
            book_list.put(id, book_info);
        }
        CONNECTION.close();
        return book_list;
    }

    public static HashMap<Integer, String> getUsers() throws SQLException {
        HashMap<Integer, String> user_list = new HashMap<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement query = CONNECTION.createStatement();
        ResultSet result = query.executeQuery(DatabaseConstants.Selects.SELECT_USERS);
        while (result.next()) {
            int id = result.getInt("user_id");
            String name = result.getString("name");
            String surname = result.getString("surname");
            String email = result.getString("email");
            String user_info =  name + " " + surname + " " + email;
            user_list.put(id, user_info);
        }
        CONNECTION.close();
        return user_list;
    }

    public static HashMap<Integer, ArrayList<Integer>> getOrdered() throws SQLException {
        HashMap<Integer, ArrayList<Integer>> order_list = new HashMap<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement query = CONNECTION.createStatement();
        ResultSet result = query.executeQuery(DatabaseConstants.Selects.SELECT_ORDERED);
        while (result.next()) {
            ArrayList<Integer> info = new ArrayList<>();
            Integer order_id = result.getInt("order_id");
            info.add(result.getInt("books_book_id"));
            info.add(result.getInt("users_user_id"));
            info.add(result.getInt("time"));
            order_list.put(order_id, info);
        }
        CONNECTION.close();
        return order_list;
    }

    public static HashMap<Integer, ArrayList<Integer>> getBorrowed() throws SQLException {
        HashMap<Integer, ArrayList<Integer>> borrow_list = new HashMap<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement query = CONNECTION.createStatement();
        ResultSet result = query.executeQuery(DatabaseConstants.Selects.SELECT_BORROWED);
        while (result.next()) {
            ArrayList<Integer> info = new ArrayList<>();
            Integer order_id = result.getInt("borrow_id");
            info.add(result.getInt("user_id"));
            info.add(result.getInt("book_id"));
            borrow_list.put(order_id, info);
        }
        CONNECTION.close();
        return borrow_list;
    }

    public static void returnBook(int userId, int bookId) throws SQLException {

        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        CallableStatement stmt = CONNECTION.prepareCall("{call return_book(?, ?)}");
        stmt.setInt(1, userId);
        stmt.setInt(2, bookId);
        stmt.executeQuery();

        CONNECTION.close();

    }

    public static boolean borrowBook(int userId, int bookId) throws SQLException {

        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        CallableStatement stmt = CONNECTION.prepareCall("{call borrow_book(?, ?)}");
        stmt.setInt(1, userId);
        stmt.setInt(2, bookId);
        stmt.executeQuery();

        CONNECTION.close();

        var borrowed = LibraryDatabase.getBorrowed();
        for (var borrow : borrowed.values()){
            if ((borrow.get(0) == userId) && (borrow.get(1) == bookId)){return true;}
        }
        return false;
    }

    public static void orderBook(int userId, int bookId, int months) throws SQLException {

        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        CallableStatement stmt = CONNECTION.prepareCall("{call order_book(?, ?, ?)}");
        stmt.setInt(1, userId);
        stmt.setInt(2, bookId);
        stmt.setInt(3, months);
        stmt.executeQuery();

        CONNECTION.close();

    }

    public static void addBook(String name, String author, String category, int dep) throws SQLException{
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        String sql = DatabaseConstants.Inserts.INSERT_BOOK;
        PreparedStatement pstmt = CONNECTION.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, author);
        if(category.isEmpty()){
            pstmt.setNull(3,Types.NVARCHAR);
        }
        else {
            pstmt.setString(3, category);
        }
        pstmt.setInt(4, dep);
        pstmt.executeUpdate();
        CONNECTION.close();
    }

    public static void removeBook(int book_id) throws SQLException{
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        String sql = DatabaseConstants.Deletes.DELETE_BOOK;
        PreparedStatement pstmt = CONNECTION.prepareStatement(sql);
        pstmt.setInt(1, book_id);
        pstmt.executeUpdate();
        CONNECTION.close();
    }

    public static void addUser(String name, String surname, String email, String phone_n, String login, String password) throws SQLException{
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        if (login.isEmpty()){
            String sql1 = DatabaseConstants.Inserts.INSERT_USER_NO_ID;
            PreparedStatement pstmt = CONNECTION.prepareStatement(sql1);
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, email);
            if(phone_n.isEmpty()){
                pstmt.setNull(4,Types.NVARCHAR);
            }
            else {
                pstmt.setString(4, phone_n);
            }
            pstmt.executeUpdate();
        }
        else{
            Statement query = CONNECTION.createStatement();
            ResultSet result = query.executeQuery(DatabaseConstants.Selects.SELECT_MAX_USER_ID);
            result.next();
            int user_id = result.getInt("max_id") + 1;
            String sql1 = DatabaseConstants.Inserts.INSERT_USER;
            String sql2 = DatabaseConstants.Inserts.INSERT_USER_LOGIN;
            String sql3 = DatabaseConstants.Inserts.INSERT_USER_ID_TO_L;

            PreparedStatement pstmt = CONNECTION.prepareStatement(sql1);
            pstmt.setInt(1, user_id);
            pstmt.setString(2, name);
            pstmt.setString(3, surname);
            pstmt.setString(4, email);
            if(phone_n.isEmpty()){
                pstmt.setNull(5,Types.NVARCHAR);
            }
            else {
                pstmt.setString(5, phone_n);
            }
            pstmt.executeUpdate();

            pstmt = CONNECTION.prepareStatement(sql2);
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.executeUpdate();

            pstmt = CONNECTION.prepareStatement(sql3);
            pstmt.setInt(1, user_id);
            pstmt.setString(2, login);
            pstmt.executeUpdate();
        }
        CONNECTION.close();
    }

    public static void removeUser(int user_id) throws SQLException{
        var info = LibraryDatabase.getUsersLoginInfo().get(user_id);
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        if (info.get("login") == null){
            String sql = DatabaseConstants.Deletes.REMOVE_USER;
            PreparedStatement pstmt = CONNECTION.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();
        }
        else{
            var login = info.get("login");
            String sql1 = DatabaseConstants.Deletes.REMOVE_USER_ID_TO_L;
            PreparedStatement pstmt = CONNECTION.prepareStatement(sql1);
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();

            String sql2 = DatabaseConstants.Deletes.REMOVE_USER;
            pstmt = CONNECTION.prepareStatement(sql2);
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();

            String sql3 = DatabaseConstants.Deletes.REMOVE_USER_LOGIN;
            pstmt = CONNECTION.prepareStatement(sql3);
            pstmt.setString(1, login);
            pstmt.executeUpdate();
        }
        CONNECTION.close();
    }
    public static ArrayList<String> getUsersBorrowedOrdered(int user_id) throws SQLException {
        ArrayList<String> books = new ArrayList<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        String sql = DatabaseConstants.Selects.SELECT_USERS_BOOKS;
        PreparedStatement pstmt = CONNECTION.prepareStatement(sql);
        pstmt.setInt(1, user_id);
        var result = pstmt.executeQuery();
        while (result.next()) {
            var book_id = result.getInt('"' + "book"+ '"');
            var bor_or_ord = result.getString('"' + "borrowed_or_ordered" + '"');
            books.add(book_id + "\t" + bor_or_ord);
        }
        CONNECTION.close();
        return books;
    }

    public static HashMap<Integer, Integer> getUsersPenalties(int user_id) throws SQLException {
        HashMap<Integer, Integer> penalties = new HashMap<>();
        CONNECTION = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        PreparedStatement pstmt = CONNECTION.prepareStatement(DatabaseConstants.Selects.SELECT_PENALTIES_WHERE);
        pstmt.setInt(1, user_id);
        var results = pstmt.executeQuery();
        while (results.next()){
            var book_id = results.getInt("book_id");
            var pen = results.getInt("pen");
            if (pen!=0){
            penalties.put(book_id, pen);}

        }
        CONNECTION.close();
        return penalties;
        }

}



class DatabaseConstants {
    static class Selects {
        public static final String SELECT_USERS = "SELECT u.*, ul.* FROM users u left join user_id_to_login uil on(u.user_id = uil.user_id) left join users_login ul on(ul.login=uil.login)";
        public static final String SELECT_MANAGERS = "SELECT m.*, ml.* FROM managers m join manager_id_to_login mil on(m.manager_id = mil.manager_id) join managers_login ml on(ml.login=mil.login)";
        public static final String SELECT_EMPLOYEES = "SELECT e.*, el.* FROM employees e join employee_id_to_login eil on(e.employee_id = eil.employee_id)\n join employee_login el on(el.login=eil.login)";
        public static final String SELECT_BOOKS = "SELECT * FROM books";
        public static final String SELECT_ORDERED = "SELECT * FROM ordered";
        public static final String SELECT_BORROWED = "SELECT * FROM borrowed";
        public static final String SELECT_MAX_USER_ID = "SELECT max(user_id) as max_id from users where user_id < 2000";
        public static final String SELECT_USERS_BOOKS = "select * from borrowed_ordered_together where" + '"' + "user" + '"' + "=?";
        public static final String SELECT_PENALTIES_WHERE = "SELECT book_id, calculate_penalty(borrow_id) as pen from borrowed where user_id = ?";

    }
    static class Inserts{
        public static final String INSERT_BOOK = "INSERT INTO books (name, author, category, department_id) VALUES (?, ?, ?, ?)";
        public static final String INSERT_USER = "INSERT INTO users VALUES (?, ?, ?, ?, ?)";
        public static final String INSERT_USER_ID_TO_L = "INSERT INTO user_id_to_login VALUES (?, ?)";
        public static final String INSERT_USER_LOGIN = "INSERT INTO users_login VALUES (?, ?)";
        public static final String INSERT_USER_NO_ID = "INSERT INTO users (name, surname, email, phone_number) VALUES (?, ?, ?, ?)";
    }
    static class Deletes{
        public static final String DELETE_BOOK = "DELETE FROM books WHERE book_id = ?";

        public static final String REMOVE_USER = "DELETE FROM users WHERE user_id = ?";
        public static final String REMOVE_USER_ID_TO_L = "DELETE FROM user_id_to_login WHERE user_id = ?";
        public static final String REMOVE_USER_LOGIN = "DELETE FROM users_login WHERE login = ?";
    }

}


