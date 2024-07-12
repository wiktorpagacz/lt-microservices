package com.pagacz.resvault.service;

import com.pagacz.resvault.model.CourseResponse;

public interface CourseServ {
    CourseResponse getCourseById(long courseId);
}
