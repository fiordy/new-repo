package com.sistemi.informativi.dao;

import com.sistemi.informativi.dto.StudentDTO;
import com.sistemi.informativi.vo.StudentVO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO {

    public void addStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException;

    public void updateStudent(StudentDTO studentDTO, int id) throws SQLException, ClassNotFoundException;

    public void deleteStudent( int id) throws SQLException, ClassNotFoundException;

    public ArrayList<StudentVO> getStudent() throws SQLException, ClassNotFoundException;
}
