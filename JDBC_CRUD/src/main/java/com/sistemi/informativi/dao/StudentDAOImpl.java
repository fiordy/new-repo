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

    @Override
    public void addStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException {

        //inizializzazione di un PreparedStatement tramite invocazione alla classe ConnectionManager

        PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlStudentInsert);
        ps.setString(1, studentDTO.getFirst_name());
        ps.setString(2, studentDTO.getLast_name());
        ps.setInt(3, studentDTO.getAge());

        ps.executeUpdate();
    }


    @Override
    public void addStudent() {

    }

    @Override
    public void updateStudent( StudentDAO studentDAO,int id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlStudentUpdate);
        ps.setString(1,studentDAO.getFirstName);
        ps.setString(1,studentDAO.getLastName);
        ps.setString(1,studentDAO.getAge);
        ps.

    }

    /**
     * @ param id
     * @throws SQLException
     * throws ClassNotFound
     */
    @Override
    public void removeStudent(int id) {

        PreparedStatement ps = ConnectionManager.getPreparedStatement(sqlScript.sqlStudentDelete);
        ps.setInt(1, id);

        ps.executeUpdate();


    }

    @Override
    public void getStudents() throws SQLException, ClassNotFoundException {

        ArrayList<StudentVO> students = new ArrayList<StudentVO>();

        ResultSet rs = ConnectionManager.getResultSet(sqlScript.sqlRead);

        while (rs.next());

        studentVO = new StudentVO(

            rs.getInt("id"),
                    rs.getString("first_name"),
            rs.getString("last_name"),
        rs.getInt("age"));


        students.add(studentVO);


    }



    }

}
