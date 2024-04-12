package com.example.Jinus.service;

import com.example.Jinus.controller.NoticeController;
import com.example.Jinus.entity.DepartmentEntity;
import com.example.Jinus.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        logger.info("DepartmentService 실행");
    }

    public int getCollegeId(int departmentId) {
        logger.info("getCollegeId 실행");
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).orElse(null);
        logger.info("departmentEntity: {}", departmentEntity);
        // 학과 찾기
        if (departmentEntity != null) {
            return departmentEntity.getCollegeId(); // 단과대학 id 리턴
        } else {
            logger.error("DepartmentService: college를 찾을 수 없습니다.");
            return -1;
        }
    }

    public String getDepartmentEng(int departmentId) {
        logger.info("getDepartmentEng 실행");
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).orElse(null);
        logger.info("departmentEntity: {}", departmentEntity);
        // 학과 영문명 찾기
        if (departmentEntity != null) {
            return departmentEntity.getDepartmentEn();
        } else {
            logger.error("DepartmentService: departmentEn을 찾을 수 없습니다.");
            return "none";
        }
    }

}
