package formation.test.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpaAdrien {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formationpersist");
		EntityManager em = emf.createEntityManager();
		
//		List<Matiere> matieres = em.createQuery("select m from Matiere m", Matiere.class).getResultList();
		
		em.close();
		emf.close();
	}

}