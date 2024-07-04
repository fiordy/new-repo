package com.sistemi.informativi.main;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dao.StudentDAO;
import com.sistemi.informativi.dao.StudentDAOImpl;
import com.sistemi.informativi.dto.StudentDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection con = ConnectionManager.GetConnection();

        StudentDTO studentDTO = new StudentDTO("giada", "proto", 30);
        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.addStudent(studentDTO);

        StudentDTO studentToUp = new StudentDTO("carlo", "cracco", 100);

        studentDAO.updateStudent(studentToUp, 4);

        studentDAO.deleteStudent(4);

        studentDAO.getStudent().forEach(s -> System.out.println("ciao bro" + s));




    }
}
