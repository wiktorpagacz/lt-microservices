package com.pagacz.progtrack.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class ProgressEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "RESOURCE_ID")
    private Long resourceId;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "PROGRESS_TYPE")
    private ProgressType progressType;
    @ElementCollection
    @CollectionTable(name = "progress_data", joinColumns = @JoinColumn(name = "progress_entry_id"))
    @MapKeyColumn(name = "attribute_name")
    @Column(name = "attribute_value")
    private Map<String, String> progressData;
}


