package com.pagacz.resvault.entity;

import com.pagacz.resvault.entity.enums.Language;
import com.pagacz.resvault.entity.enums.Platform;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "COURSE_NAME")
    private String courseName;
    @Column(name = "LINK")
    private String link;
    @Column(name = "RATE")
    private Integer rate;
    @Column(name = "LANGUAGE")
    @Enumerated(EnumType.STRING)
    private Language language;
    @Column(name = "PLATFORM")
    @Enumerated(EnumType.STRING)
    private Platform platform;
}
