package com.example.javaspringdemo.services.interfaces;

import com.example.javaspringdemo.entities.Education;

import java.util.List;
import java.util.Optional;

public interface IEducationService {

    // Hàm create/update education
    public void save(Education education);

    // Hàm xóa education
    public void deleteEducation(int id);

    // Lấy ra danh sách education
    public List<Education> getAllEducation(int userId);

    // Lấy ra 1 education
    public Optional<Education> getOneEducation(int id);
}
