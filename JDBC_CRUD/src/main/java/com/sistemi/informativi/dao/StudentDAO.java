package com.sistemi.informativi.dao;

import com.sistemi.informativi.dto.StudentDTO;
import com.sistemi.informativi.vo.StudentVO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO {

    void addStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException;

    void updateStudent(String sql, StudentDTO studentDTO) throws SQLException, ClassNotFoundException;


    public void removeStudent(int id) throws SQLException, ClassNotFoundException;

    public ArrayList<StudentVO> getStudents() throws SQLException, ClassNotFoundException;;ssssssssssssssssaaaa
}
