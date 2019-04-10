package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {

	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");
		boolean hasDriver = false;
		
		hasDriver = checkDriver();
		if(hasDriver) {
			System.out.println("Driver instalado y funcionando");
		}else {
			System.out.println("No encuentro el driver en el Classpath");
			return;
		}
//		exercise1();
//		exercise2();
//		exercise3();
//		exercise4();
//		exercise5();
//		exercise6();
//		exercise7();
//		exercise8();
	}

	private static void exercise1() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(DB_URL_CONNECTION, DB_USER, DB_PASSWD); // Abriendo la conexión
			statement = connection.createStatement(); // Preparando la consulta
			String sql = "SELECT * FROM vets"; // Definición de la consulta
			ResultSet rs = statement.executeQuery(sql); // Ejecutando la consulta
			System.out.println("Resultados:");
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				System.out.println("Veterinario: " + firstName + " " + lastName + " (" + id + ")");
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}
	
	private static void exercise2() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(DB_URL_CONNECTION, DB_USER, DB_PASSWD); // Abriendo la conexión
			String sql = "SELECT * FROM vets WHERE id=?;"; // Definición de la consulta
			preparedStatement = connection.prepareStatement(sql); // Preparando la consulta
			preparedStatement.setInt(1, 2);
			
			ResultSet rs = preparedStatement.executeQuery(); // Ejecutando la consulta
			System.out.println("Resultado:");
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				System.out.println("Veterinario: " + firstName + " " + lastName + " (" + id + ")");
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(preparedStatement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}
	
	private static void exercise3() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(DB_URL_CONNECTION, DB_USER, DB_PASSWD); // Abriendo la conexión
			statement = connection.createStatement(); // Preparando la consulta
			String sql = "SELECT * FROM owners"; // Definición de la consulta
			ResultSet rs = statement.executeQuery(sql); // Ejecutando la consulta
			System.out.println("Resultados:");
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String telephone = rs.getString("telephone");
				System.out.println("Veterinario: " + firstName + " " + lastName + " (" + id + ") - " + address + ", " + city + " (" + telephone + ")");
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}
	
	private static void exercise4() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(DB_URL_CONNECTION, DB_USER, DB_PASSWD); // Abriendo la conexión
			statement = connection.createStatement(); // Preparando la consulta
			String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) "
					+ "VALUES ('Nombre', 'Apellido', 'Direccion', 'Ciudad', '000000000')"; // Definición de la consulta
			int updatedRowsNum = statement.executeUpdate(sql); // Ejecutando la consulta
			System.out.println("Número de filas añadidas: " + updatedRowsNum);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}
	
	private static void exercise5() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(DB_URL_CONNECTION, DB_USER, DB_PASSWD); // Abriendo la conexión
			statement = connection.createStatement(); // Preparando la consulta
			String sql = "UPDATE owners "
					+ "SET city = 'Sevilla' "
					+ "WHERE city like 'Ciudad'"; // Definición de la consulta
			int updatedRowsNum = statement.executeUpdate(sql); // Ejecutando la consulta
			System.out.println("Número de filas actualizadas: " + updatedRowsNum);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}
	
	private static void exercise6() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(DB_URL_CONNECTION, DB_USER, DB_PASSWD); // Abriendo la conexión
			String sql = "SELECT * FROM owners WHERE first_name LIKE ? OR last_name LIKE ?"; // Definición de la consulta
			String input = "Da";
			String term = "%" + input + "%";
			
			preparedStatement = connection.prepareStatement(sql); // Preparando la consulta
			preparedStatement.setString(1, term);
			preparedStatement.setString(2, term);
			
			ResultSet rs = preparedStatement.executeQuery(); // Ejecutando la consulta
			System.out.println("Resultados:");
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				System.out.println("Veterinario: " + firstName + " " + lastName + " (" + id + ")");
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(preparedStatement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}
	
	
	private static void exercise7() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(DB_URL_CONNECTION, DB_USER, DB_PASSWD); // Abriendo la conexión
			String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?,?,?,?,?)"; // Definición de la consulta
			String[] values = new String[] {"Ignacio", "Roncero", "Mi casa", "Sevilla", "666666666"};
			
			preparedStatement = connection.prepareStatement(sql); // Preparando la consulta
			for(int i = 0; i < values.length; i++){
				preparedStatement.setString(i + 1, values[i]);
			}
			
			int updatedRowsNum = preparedStatement.executeUpdate(); // Ejecutando la consulta
			System.out.println("Número de filas añadidas: " + updatedRowsNum);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(preparedStatement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}
	
	private static void exercise8() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(DB_URL_CONNECTION, DB_USER, DB_PASSWD); // Abriendo la conexión
			String[] ownerValues = new String[] {"Ignacio", "Roncero", "Mi casa", "Sevilla", "666666666"};
			String ownerSQL = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?,?,?,?,?)"; // Definición de la consulta
			preparedStatement = connection.prepareStatement(ownerSQL, Statement.RETURN_GENERATED_KEYS); // Preparando la consulta
			for(int i = 0; i < ownerValues.length; i++){
				preparedStatement.setString(i + 1, ownerValues[i]);
			}
			
			int ownerUpdatedRowsNum = preparedStatement.executeUpdate(); // Ejecutando la consulta
			System.out.println("Número de filas añadidas: " + ownerUpdatedRowsNum);
			ResultSet ownerKeysRS =  preparedStatement.getGeneratedKeys();
			int ownerId = 0;
			if(ownerKeysRS.next()) {
				ownerId = ownerKeysRS.getInt(1);
			}
			System.out.println("Id del propietario añadido: " + ownerId);
			
			
			String petName = "Gato";
			Date petBirthDate = Date.valueOf("2014-01-20");
			int petType = 2; // Perro
			
			String petSQL = "INSERT INTO pets (name, birth_date, type_id, owner_id) VALUE (?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(petSQL, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, petName);
			preparedStatement.setDate(2, petBirthDate);
			preparedStatement.setInt(3, petType);
			preparedStatement.setInt(4, ownerId);
			
			int petUpdatedRowsNum = preparedStatement.executeUpdate();
			System.out.println("Número de filas añadidas: " + petUpdatedRowsNum);
			ResultSet petKeysRS =  preparedStatement.getGeneratedKeys();
			int petId = 0;
			if(petKeysRS.next()) {
				petId = petKeysRS.getInt(1);
			}
			System.out.println("Id del mascota añadido: " + petId);
			
			
			String petRemoveSQL = "DELETE FROM pets WHERE id = ?";
			preparedStatement = connection.prepareStatement(petRemoveSQL);
			preparedStatement.setInt(1, petId);
			int petRemovedRowsNum = preparedStatement.executeUpdate();
			System.out.println("Número de filas eliminadas: " + petRemovedRowsNum);
			
			String ownersRemoveSQL = "DELETE FROM owners WHERE id = ?";
			preparedStatement = connection.prepareStatement(ownersRemoveSQL);
			preparedStatement.setInt(1, ownerId);
			int ownerRemovedRowsNum = preparedStatement.executeUpdate();
			System.out.println("Número de filas eliminadas: " + ownerRemovedRowsNum);
			
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(preparedStatement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}

	private static boolean checkDriver() {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			result = true;
		} catch (ClassNotFoundException e) {
			// Do nothing
		}
		return result;
	}
	
	private static final String DB_URL_CONNECTION = "jdbc:mysql://localhost:3306/petclinic";
	private static final String DB_USER = "root";
	private static final String DB_PASSWD = "root";
}
