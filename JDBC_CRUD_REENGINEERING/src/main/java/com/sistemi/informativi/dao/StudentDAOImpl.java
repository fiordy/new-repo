package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.StudentDTO;
import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.vo.StudentVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

    //method that prepare the following anonymous statement, "INSERT into STUDENT(first_name, last_name, age) VALUES(?, ?, ?)
    //name, surname and age have to be taken from the main application

    /**
     * @param studentDTO
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void addStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = ConnectionManager.GetPrepareStatement(SqlScript.sqlStudentInsert);
        ps.setString(1, studentDTO.getFirst_name());
        ps.setString(2, studentDTO.getLast_name());
        ps.setInt(3, studentDTO.getAge());

        ps.executeUpdate();
    }

    /**
     * @param studentDTO, for the parameter of the sql script
     * @param id,         for the correct user to update
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void updateStudent(StudentDTO studentDTO, int id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = ConnectionManager.GetPrepareStatement(SqlScript.sqlStudentUpdate);
        ps.setString(1, studentDTO.getFirst_name());
        ps.setString(2, studentDTO.getLast_name());
        ps.setInt(3, studentDTO.getAge());
        ps.setInt(4, id);

        ps.executeUpdate();
    }

    /**
     * @param studentDTO, for the parameter of the sql script
     * @param id,         for the correct user to update
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void deleteStudent( int id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = ConnectionManager.GetPrepareStatement(SqlScript.sqlStudentDelete);
        ps.setInt(1, id);

        ps.executeUpdate();
    }

    /**
     * Getting back all the students from the DB,
     * and putting them inside the ArrayList of studentVO
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ArrayList<StudentVO> getStudent() throws SQLException, ClassNotFoundException {
        //initialization of the studentVO reference for less memory usage
        StudentVO studentVO = null;
        //ArrayList to contain all the reference of the students inside
        ArrayList<StudentVO> students = new ArrayList<>();
        ResultSet rs = ConnectionManager.GetStatement(SqlScript.sqlReadAll);
        //we use the rs to get the students via query and put them inside the ArrayList
        while (rs.next()) {
            studentVO = new StudentVO(rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getInt("age"));
            students.add(studentVO);
        }
        return students;
    }
}
