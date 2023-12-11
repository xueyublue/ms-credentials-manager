package sg.darren.ms.credentials.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.darren.ms.credentials.manager.model.entity.CredentialsEntity;

public interface CredentialsRepository extends JpaRepository<CredentialsEntity, Integer> {

}
