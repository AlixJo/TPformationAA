package formationAA.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FormationPersist {
	private static FormationPersist instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("formationpersist");

	private FormationPersist() {

	}

	public static FormationPersist getInstance() {
		if (instance == null) {
			instance = new FormationPersist();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}
}
