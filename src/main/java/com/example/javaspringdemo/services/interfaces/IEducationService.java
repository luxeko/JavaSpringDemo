package com.example.javaspringdemo.services.interfaces;

import com.example.javaspringdemo.entities.Education;

import java.util.List;
import java.util.Optional;

public interface IEducationService {

    // Hàm thêm education
    public Education addEducation(Education education);

    // Hàm chỉnh sửa thông tin education
    public Optional<Education> updateEducation(int id, Education education);

    // Hàm xóa education
    public boolean deleteEducation(int id);

    // Lấy ra danh sách education
    public List<Education> getAllEducation();

    // Lấy ra 1 education
    public Education getOneEducation(int id);
}
