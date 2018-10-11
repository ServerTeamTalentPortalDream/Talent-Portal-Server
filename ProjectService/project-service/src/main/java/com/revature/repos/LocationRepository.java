package com.revature.repos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.model.Location;
import com.revature.model.Project;



@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}