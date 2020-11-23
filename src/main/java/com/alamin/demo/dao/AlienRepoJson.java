package com.alamin.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alamin.demo.model.Alien;

public interface AlienRepoJson extends JpaRepository<Alien,Integer> {

}
