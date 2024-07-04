package com.sistemi.informativi.sql;

public interface SqlScript {
    public static String sqlStudentInsert = "INSERT into STUDENT(first_name, last_name, age) VALUES(?, ?, ?)";

    public static String sqlStudentUpdate = "UPDATE student SET first_name = ?, last_name = ?, age = ? WHERE id = ?";
    public static String sqlStudentDelete = "DELETE FROM student WHERE id = ?";

    public static String sqlReadAll = "SELECT * FROM student";
}
