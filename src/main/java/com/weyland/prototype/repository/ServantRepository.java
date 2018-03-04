package com.weyland.prototype.repository;

import com.weyland.prototype.domain.Servant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServantRepository extends JpaRepository<Servant,String>{
}
