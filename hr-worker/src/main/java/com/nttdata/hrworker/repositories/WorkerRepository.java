package com.nttdata.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
