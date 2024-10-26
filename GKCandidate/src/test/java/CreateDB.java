import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;
import vn.edu.iuh.fit.entities.Candidate;

public class CreateDB {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("GKCan").createEntityManager();

    }
}
