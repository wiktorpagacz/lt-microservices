package com.pagacz.progtrack.service;

import com.pagacz.progtrack.entity.ProgressEntry;
import com.pagacz.progtrack.entity.ProgressType;
import com.pagacz.progtrack.exception.ProgTrackCustomException;
import com.pagacz.progtrack.model.ProgressRequest;
import com.pagacz.progtrack.model.ProgressResponse;
import com.pagacz.progtrack.repository.ProgressRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Log4j2
@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    public Long saveProgress(ProgressRequest progressRequest) {
        log.info("Adding Course...");
        ProgressEntry progressEntry
                = ProgressEntry.builder()
                .userId(progressRequest.getUserId())
                .resourceId(progressRequest.getResourceId())
                .progressType(ProgressType.valueOf(progressRequest.getProgressType()))
                .progressData(progressRequest.getProgressData())
                .build();
        progressRepository.save(progressEntry);
        log.info("Course created");
        return progressEntry.getId();
    }

    public ProgressResponse updateProgress(long progressId, ProgressRequest progressRequest) throws ProgTrackCustomException {
        ProgressEntry progressEntry = progressRepository.findById(progressId)
                .orElseThrow(() -> new ProgTrackCustomException("Progress with given id not found", "PROGRESS_NOT_FOUND"));
        progressEntry.setProgressData(progressRequest.getProgressData());
        progressRepository.save(progressEntry);
        return ProgressResponse.builder()
                .id(progressId)
                .progressData(progressEntry.getProgressData())
                .progressType(progressEntry.getProgressType().toString())
                .userId(progressEntry.getUserId())
                .resourceId(progressEntry.getResourceId())
                .build();
    }

    public ProgressResponse getProgressById(long progressId) {
        ProgressEntry progressEntry = progressRepository.findById(progressId)
                .orElseThrow(() -> new ProgTrackCustomException("Progress with given id not found", "PROGRESS_NOT_FOUND"));
        return ProgressResponse.builder()
                .id(progressId)
                .progressData(progressEntry.getProgressData())
                .progressType(progressEntry.getProgressType().toString())
                .userId(progressEntry.getUserId())
                .resourceId(progressEntry.getResourceId())
                .build();
    }
}
