package com.ceos18.dangn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTown extends JpaRepository<UserTown, Long> {
}
