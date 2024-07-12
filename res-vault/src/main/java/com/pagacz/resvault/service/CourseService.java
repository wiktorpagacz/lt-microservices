package com.pagacz.resvault.service;

import com.pagacz.resvault.entity.Course;
import com.pagacz.resvault.entity.enums.Language;
import com.pagacz.resvault.entity.enums.Platform;
import com.pagacz.resvault.exception.ResVaultCustomException;
import com.pagacz.resvault.model.CourseRequest;
import com.pagacz.resvault.model.CourseResponse;
import com.pagacz.resvault.model.mappers.CommonMapper;
import com.pagacz.resvault.repository.CourseRepository;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Log4j2
@Service
public class CourseService implements CourseServ {

    @Autowired
    private CourseRepository courseRepository;

    CommonMapper mapper = Mappers.getMapper(CommonMapper.class);

    public Long saveCourse(CourseRequest courseRequest) {
        log.info("Adding Course...");
        Course course
                = Course.builder()
                .courseName(courseRequest.getCourseName())
                .platform(Platform.valueOf(courseRequest.getPlatform()))
                .rate(courseRequest.getRate())
                .language(Language.valueOf(courseRequest.getLanguage()))
                .link(courseRequest.getLink())
                .build();
        courseRepository.save(course);
        log.info("Course created");
        return course.getId();
    }

    @Override
    public CourseResponse getCourseById(long courseId) {
        log.info("Get the course for courseId: {}", courseId);
        Course course
                =courseRepository.findById(courseId)
                .orElseThrow(() -> new ResVaultCustomException("Course with given id not found", "COURSE_NOT_FOUND"));
        CourseResponse courseResponse = mapper.courseToDto(course);
        return courseResponse;
    }
}
