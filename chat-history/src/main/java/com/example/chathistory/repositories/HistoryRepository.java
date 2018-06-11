package com.example.chathistory.models;

import com.example.chathistory.models.History;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

public interface HistoryRepository extends CrudRepository<History, Long> {

}