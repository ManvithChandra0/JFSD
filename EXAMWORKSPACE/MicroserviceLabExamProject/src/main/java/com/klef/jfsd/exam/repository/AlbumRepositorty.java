package com.klef.jfsd.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.exam.model.Album;

public interface AlbumRepositorty extends JpaRepository<Album, Long> {
}