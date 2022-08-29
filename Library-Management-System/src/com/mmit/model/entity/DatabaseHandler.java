package com.mmit.model.entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mariadb.jdbc.BasePrepareStatement;

import com.mmit.Index;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class DatabaseHandler {
	
public static Connection createConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/librarydb", "root", "");
		return conn;
	}

	public static Librarian login(String email, String pass) {
		Librarian lib = null;
		try(var con = createConnection()) {
			var query = "SELECT * FROM librarians WHERE email = ? AND password = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, pass);
			
			var rs = pstm.executeQuery();
			if(rs.next()) {
				lib = new Librarian();
				lib.setId(rs.getInt("id"));
				lib.setEmail(rs.getString("email"));
				lib.setPassword(rs.getString("password"));
				lib.setEmail(rs.getString("nrc_no"));
				lib.setPhone(rs.getString("phone"));
			}
		}
		catch (Exception e) {
			lib = null;
		}
		return lib;
	}

	public static void saveCategory(String name) throws Exception {
		try(var con = createConnection()) {
			var query = "INSERT INTO categories(name)VALUES(?)";
			
			var pstm = con.prepareStatement(query);
			
			pstm.setString(1, name);
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static List<Category> findAllCategory() {
		List<Category> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = "SELECT * FROM categories ORDER BY id";
			
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				list.add(category);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void deleteCategory(int id) {
		try(var con = createConnection()) {
			var query = "DELETE FROM categories WHERE id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateCategory(Category cate) throws Exception {
		try(var con = createConnection()) {
			var query = "UPDATE categories SET name = ? WHERE id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, cate.getName());
			pstm.setInt(2, cate.getId());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static List<Author> findAllAuthor() {
		List<Author> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = "SELECT * FROM authors";
			
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var auth = new Author();
				auth.setBirthday(LocalDate.parse(rs.getString("birthday")));
				auth.setCity(rs.getString("city"));
				auth.setId(rs.getInt("id"));
				auth.setName(rs.getString("name"));
				
				list.add(auth);
			}
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void addAuthor(Author auth) throws Exception {
		try(var con = createConnection()) {
			var query = "INSERT INTO authors(name,city,birthday)VALUES(?,?,?)";
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, auth.getName());
			pstm.setString(2, auth.getCity());
			pstm.setDate(3, Date.valueOf(auth.getBirthday()));
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static void deleteAuthor(Author auth) throws Exception {
		try(var con = createConnection()) {
			var query = "DELETE FROM authors WHERE id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, auth.getId());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static void updateAuthor(Author auth) throws Exception {
		try(var con = createConnection()) {
			var query = "UPDATE authors SET name = ?, city = ?, birthday = ? WHERE id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, auth.getName());
			pstm.setString(2, auth.getCity());
			pstm.setDate(3, Date.valueOf(auth.getBirthday()));
			pstm.setInt(4, auth.getId());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static List<Librarian> findAllLibrarian() {
		List<Librarian> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = "SELECT * FROM librarians";
			
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var lib = new Librarian();
				lib.setEmail(rs.getString("email"));
				lib.setId(rs.getInt("id"));
				lib.setNrcNo(rs.getString("nrc_no"));
				lib.setPassword(rs.getString("password"));
				lib.setPhone(rs.getString("phone"));
				
				list.add(lib);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void addLibrarian(Librarian lib) throws Exception {
		try(var con = createConnection()) {
			var query = "INSERT INTO librarians(email,password,nrc_no,phone)VALUES(?,?,?,?)";
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, lib.getEmail());
			pstm.setString(2, lib.getPassword());
			pstm.setString(3, lib.getNrcNo());
			pstm.setString(4, lib.getPhone());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static void deleteLibrarian(Librarian lib) throws Exception {
		try(var con = createConnection()) {
			var query = "DELETE FROM librarians WHERE id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, lib.getId());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static void updateLibrarian(Librarian lib) throws Exception {
		try(var con = createConnection()) {
			var query = "UPDATE librarians SET email = ?,password = ?,nrc_no = ?,phone = ? WHERE id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, lib.getEmail());
			pstm.setString(2, lib.getPassword());
			pstm.setString(3, lib.getNrcNo());
			pstm.setString(4, lib.getPhone());
			pstm.setInt(5, lib.getId());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static List<Member> findAllMember() {
		List<Member> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = "SELECT * FROM members";
			
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var member = new Member();
				member.setAcademicYear(rs.getString("academic_year"));
				member.setCardId(rs.getInt("card_id"));
				member.setCreatedDate(LocalDate.parse(rs.getString("created_date")));
				member.setExpiredDate(LocalDate.parse(rs.getString("expired_date")));
				member.setName(rs.getString("name"));
				member.setRollNo(rs.getString("roll_no"));
				member.setYear(rs.getString("year"));
				
				list.add(member);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void addMember(Member member) throws Exception {
		try(var con = createConnection()) {
			var query = """
					INSERT INTO members(name,roll_no,year,academic_year,created_date,expired_date)
					VALUES(?,?,?,?,?,?)
					""";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, member.getName());
			pstm.setString(2, member.getRollNo());
			pstm.setString(3, member.getYear());
			pstm.setString(4, member.getAcademicYear());
			pstm.setDate(5, Date.valueOf(member.getCreatedDate()));
			pstm.setDate(6, Date.valueOf(member.getExpiredDate()));
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static void deleteMember(Member member) throws Exception {
		try(var con = createConnection()) {
			var query = "DELETE FROM members WHERE card_id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, member.getCardId());
			
			pstm.executeUpdate();
			
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static void updateMember(Member member) throws Exception {
		try(var con = createConnection()) {
			var query = "UPDATE members SET name = ?,roll_no = ?,year = ?,academic_year = ? WHERE 	card_id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, member.getName());
			pstm.setString(2, member.getRollNo());
			pstm.setString(3, member.getYear());
			pstm.setString(4, member.getAcademicYear());
			pstm.setInt(5, member.getCardId());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static List<Book> findAllBook() {
		List<Book> list = new ArrayList<>();
		try(var con = createConnection()) {

			var query = """
					SELECT b.code,b.title,b.publish_date,a.name'authorName',c.name'categoryName',b.available,l.email
					FROM books b, categories c, authors a, librarians l
					WHERE b.category_id = c.id AND b.author_id = a.id AND b.lib_id = l.id
					""";		
			
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var book = new Book();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
				book.setAvailable(rs.getBoolean("available"));
				
				var entry_lib = new Librarian();
				entry_lib.setEmail(rs.getString("email"));
				book.setEntryBy(entry_lib);
				
				var category = new Category();
				category.setName(rs.getString("categoryName"));
				book.setCategory(category);
				
				var author = new Author();
				author.setName(rs.getString("authorName"));
				book.setAuthor(author);
				
				list.add(book);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void addBook(Book book) throws Exception {
		try(var con = createConnection()) {
			var query = """
					INSERT INTO books(code,title,publish_date,author_id,category_id,available,lib_id)
					VALUES(?,?,?,?,?,?,?)
					""";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, book.getCode());
			pstm.setString(2, book.getTitle());
			pstm.setDate(3, Date.valueOf(book.getPublishDate()));
			pstm.setInt(4, book.getAuthor().getId());
			pstm.setInt(5, book.getCategory().getId());
			pstm.setBoolean(6, book.getAvailable());
			pstm.setInt(7, book.getLib().getId());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static void deleteBook(Book book) throws Exception {
		try(var con = createConnection()) {
			var query = "DELETE FROM books WHERE code = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, book.getCode());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static void updateBook(Book book) throws Exception {
		try(var con = createConnection()) {
			var query = """
					UPDATE books
					SET title = ?, publish_date = ?, author_id = ?, category_id = ?
					WHERE code = ?
					""";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, book.getTitle());
			pstm.setDate(2, Date.valueOf(book.getPublishDate()));
			pstm.setInt(3, book.getAuthor().getId());
			pstm.setInt(4, book.getCategory().getId());
			pstm.setInt(5, book.getCode());

			//System.out.println(book.getCategoryId());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static List<Book> searchBook(String title, LocalDate publishDate, String cate, String auth,
			 String lib) throws Exception {
		List<Book> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = """
					SELECT b.code,b.title,b.publish_date,c.name 'categoryName',a.name 'authorName',b.available,l.email
					FROM books b, categories c, authors a, librarians l
					WHERE b.category_id = c.id AND b.author_id = a.id AND b.lib_id = l.id
					""";
			// dynamic query
			List<Object> params = new ArrayList<Object>();
			if(title != null && !title.isEmpty()) {
				query += " AND b.title LIKE ?";
				params.add("%" + title + "%");
			}
			if(publishDate != null) {
				query += " AND b.publish_date = ?";
				params.add(publishDate);
			}
			if(cate != null && !cate.isEmpty()) {
				query += " AND c.name LIKE ?";
				params.add("%" + cate + "%");
			}
			if(auth != null && !auth.isEmpty()) {
				query += " AND a.name LIKE ?";
				params.add("%" + auth + "%");
			}
			if(lib != null && !lib.isEmpty()) {
				query += " AND l.email LIKE ?";
				params.add("%" + lib + "%");
			}
			var pstm = con.prepareStatement(query);
						
			for(var i = 0; i < params.size(); i++) {
				pstm.setObject((i + 1), params.get(i));
			}
			var rs = pstm.executeQuery();
			
			while(rs.next()) {
				// create book
				var book = new Book();
				// bin column to field
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
				book.setAvailable(rs.getBoolean("available"));
				
				var entry_lib = new Librarian();
				entry_lib.setEmail(rs.getString("email"));
				book.setEntryBy(entry_lib);
				
				var category = new Category();
				category.setName(rs.getString("categoryName"));
				book.setCategory(category);
				
				var author = new Author();
				author.setName(rs.getString("authorName"));
				book.setAuthor(author);
				
				// add to list
				list.add(book);
			}
		}
		catch (Exception e) {
			throw e;
		}
		return list;
	}

	public static List<Transaction> findAllTransaction() {
		List<Transaction> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = "SELECT * FROM transactions";
			
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var tran = new Transaction();
				
				var book_id = new Book();
				book_id.setCode(rs.getInt("book_id"));
				tran.setBookCode(book_id);
				
				tran.setBorrowDate(LocalDate.parse(rs.getString("borrow_date")));
				
				var card_id = new Member();
				card_id.setCardId(rs.getInt("card_id"));
				tran.setCardId(card_id);
				
				tran.setDueDate(LocalDate.parse(rs.getString("due_date")));
				tran.setFees(rs.getDouble("fees"));
				tran.setId(rs.getInt("id"));
				
				var lib = new Librarian();
				lib.setEmail(rs.getString("lib_id"));
				tran.setEntryBy(lib);;
				
				list.add(tran);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void borrowBook(String bookCode, String cardId) throws Exception {
		try(var con = createConnection()) {
			if(bookCheck(bookCode)) {
				if(cardCheck(cardId)) {
					var query = """
							INSERT INTO transactions(card_id,book_id,borrow_date,due_date,fees,lib_id)
							VALUES(?,?,?,?,?,?)
							""";
					var pstm = con.prepareStatement(query);
					pstm.setInt(1, Integer.parseInt(cardId));
					pstm.setInt(2, Integer.parseInt(bookCode));
					pstm.setDate(3, Date.valueOf(LocalDate.now()));
					pstm.setDate(4, Date.valueOf(LocalDate.now().plusDays(5)));
					pstm.setDouble(5, 0);
					pstm.setInt(6, Index.login_user.getId());
					pstm.executeUpdate();
					
					query = "UPDATE books SET available = false WHERE code = ?";
					pstm = con.prepareStatement(query);
					pstm.setInt(1, Integer.parseInt(bookCode));
					pstm.executeUpdate();
					showAlert(AlertType.INFORMATION, "Success");
				}
				
			}
			else {
				showAlert(AlertType.ERROR, "Can't available. Someone have been borrow this book");
			}
			
		}
		catch (Exception e) {
			throw e;
		}
	}

	private static Boolean cardCheck(String cardId) {
		var status = false;
		try(var con = createConnection()) {
			var query = "SELECT expired_date FROM members WHERE card_id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, Integer.parseInt(cardId));
			
			var rs = pstm.executeQuery();
			if(rs.next()) {
				LocalDate expdate = LocalDate.parse(rs.getString("expired_date"));
				LocalDate today = LocalDate.now();
				if(today.isBefore(expdate)) {
					//System.out.println("Successful");
					query = "SELECT * FROM transactions WHERE card_id = ?";
					pstm = con.prepareStatement(query);
					pstm.setInt(1, Integer.parseInt(cardId));
					rs = pstm.executeQuery();
					List<Transaction> data = new ArrayList<>();
					if(rs.next()) {
						var tran = new Transaction();
						var book_id = new Book();
						book_id.setCode(rs.getInt("book_id"));
						tran.setBookCode(book_id);
						
						tran.setBorrowDate(LocalDate.parse(rs.getString("borrow_date")));
						
						var card_id = new Member();
						card_id.setCardId(rs.getInt("card_id"));
						tran.setCardId(card_id);
						
						tran.setDueDate(LocalDate.parse(rs.getString("due_date")));
						tran.setFees(rs.getDouble("fees"));
						tran.setId(rs.getInt("id"));
						
						var lib = new Librarian();
						lib.setEmail(rs.getString("lib_id"));
						tran.setEntryBy(lib);
						
						data.add(tran);
					}
					Double total_fees = 0.0;
					for(var obj : data) {
						if(obj.getDueDate().isBefore(today)) {
							showAlert(AlertType.ERROR, "Cannot borrow! You don't return another over duedate books");
							var day = today.compareTo(obj.getDueDate());
							var fees = day * 500;
							var query1 = "UPDATE transactions SET fees = ? WHERE id = ?";
							var pstm1 = con.prepareStatement(query1);
							pstm1.setDouble(1, fees);
							pstm1.setInt(2, obj.getId());
							pstm1.executeUpdate();
							total_fees += fees;
						}
						showAlert(AlertType.ERROR, "Your fees is " + total_fees + " ks");
					}
					if(total_fees == 0) {
						status = true;
					}
				}
				else {
					showAlert(AlertType.ERROR, "Your card is expired. Create new member card");
					status = false;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	private static Optional<ButtonType> showAlert(AlertType type, String msg) {
		Alert alert = new Alert(type);
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.setTitle("Message");
		return alert.showAndWait();
	}

	private static Boolean bookCheck(String bookCode) {
		Boolean result = null;
		try(var con = createConnection()) {
			var query = "SELECT available FROM books WHERE code = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, Integer.parseInt(bookCode));
			var rs = pstm.executeQuery();
			if(rs.next()) {
				result = rs.getBoolean("available");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static List<Book> findAvailable() {
		List<Book> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = """
					SELECT b.code,b.title,b.publish_date,c.name 'categoryName',a.name 'authorName',b.available,l.email
					FROM books b, categories c, authors a, librarians l
					WHERE b.category_id = c.id AND b.author_id = a.id AND b.lib_id = l.id AND b.available = true
					""";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				// create book
				var book = new Book();
				// bin column to field
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
				book.setAvailable(rs.getBoolean("available"));
				
				var entry_lib = new Librarian();
				entry_lib.setEmail(rs.getString("email"));
				book.setEntryBy(entry_lib);
				
				var category = new Category();
				category.setName(rs.getString("categoryName"));
				book.setCategory(category);
				
				var author = new Author();
				author.setName(rs.getString("authorName"));
				book.setAuthor(author);
				
				// add to list
				list.add(book);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Transaction> checkCard(int cardId) throws Exception {
		List<Transaction> list = new ArrayList<>();
		try(var con = createConnection()) {
			var query = """
					SELECT t.book_id,b.title,t.borrow_date,t.due_date,t.fees 
					FROM transactions t,books b
					WHERE t.book_id = b.code AND t.card_id = ?
					""";
		
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, cardId);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var tran = new Transaction();
				var book_id = new Book();
				book_id.setCode(rs.getInt("book_id"));
				tran.setBookCode(book_id);
				
				var query1 = "SELECT title FROM books WHERE code = ?";
				var pstm1 = con.prepareStatement(query1);
				pstm1.setInt(1, book_id.getCode());
				var rs1 = pstm1.executeQuery();
				String title = null;
				if(rs1.next()) {
					title = rs1.getString("title");
				}
				
				tran.setBorrowDate(LocalDate.parse(rs.getString("borrow_date")));
				
				var card_id = new Member();
				card_id.setCardId(rs.getInt("card_id"));
				tran.setCardId(card_id);
				
				tran.setDueDate(LocalDate.parse(rs.getString("due_date")));
				tran.setFees(rs.getDouble("fees"));
				tran.setId(rs.getInt("id"));
				
				var lib = new Librarian();
				lib.setEmail(rs.getString("lib_id"));
				tran.setEntryBy(lib);;
				
				list.add(tran);
			}
		}
		catch (Exception e) {
			throw e;
		}
		return list;
	}

	public static void returnBook(int code, int cardId) throws Exception {
		try(var con = createConnection()) {
			List<Integer> codeList = new ArrayList<>();
			var query = "SELECT book_id FROM transactions WHERE card_id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, cardId);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				codeList.add(rs.getInt("book_id"));
			}
			if(codeList.contains(code)) {
				query = "UPDATE books SET available = true WHERE code = ?";
				pstm = con.prepareStatement(query);
				pstm.setInt(1, code);
				pstm.executeUpdate();
				
				query = "DELETE FROM transactions WHERE book_id = ? AND card_id = ?";
				
				pstm = con.prepareStatement(query);
				pstm.setInt(1, code);
				pstm.setInt(2, cardId);
				
				pstm.executeUpdate();
				showAlert(AlertType.INFORMATION, "Returned successfully");
			}
			else {
				showAlert(AlertType.ERROR, "Enter borrow book code");
			}
		}
		catch (Exception e) {
			throw e;
		}
	}

	 
}
