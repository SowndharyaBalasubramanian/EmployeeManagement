package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Employee;
import com.util.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<>();
		String sql = "SELECT id, name, email, department, salary FROM employees ORDER BY id";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setDepartment(rs.getString("department"));
				e.setSalary(rs.getDouble("salary"));
				list.add(e);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "SELECT id, name, email, department, salary FROM employees WHERE id = ?";
		try (Connection con = DBConnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
							rs.getString("department"), rs.getDouble("salary"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		String sql = "INSERT INTO employees (name, email, department, salary) VALUES (?, ?, ?, ?)";
		try (Connection con = DBConnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, emp.getName());
			pst.setString(2, emp.getEmail());
			pst.setString(3, emp.getDepartment());
			pst.setDouble(4, emp.getSalary());
			return pst.executeUpdate() > 0;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		String sql = "UPDATE employees SET name=?, email=?, department=?, salary=? WHERE id=?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, emp.getName());
			pst.setString(2, emp.getEmail());
			pst.setString(3, emp.getDepartment());
			pst.setDouble(4, emp.getSalary());
			pst.setInt(5, emp.getId());
			return pst.executeUpdate() > 0;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(int id) {
		String sql = "DELETE FROM employees WHERE id=?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, id);
			return pst.executeUpdate() > 0;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}