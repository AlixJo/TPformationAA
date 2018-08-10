package formationAA.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formationAA.dao.FormationPersist;
import formationAA.dao.IDaoFormateur;
import sopra.promo404.formation.model.Formateur;

public class DAOFormateurJPA implements IDaoFormateur{

	@Override
	public List<Formateur> findAll() {
		List<Formateur> liste = new ArrayList<>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = FormationPersist.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Query query = em.createQuery("from Formateur", Formateur.class);
			liste = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return liste;
	}

	@Override
	public Formateur findById(Long id) {
		Formateur entity = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = FormationPersist.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			entity = em.find(Formateur.class, id);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return entity;
	}

	@Override
	public Formateur save(Formateur entity) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationPersist.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			if(entity.getId() == null) {
				em.persist(entity);
			} else {
				entity = em.merge(entity);
			}
			
			tx.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
		return entity;
	}

	@Override
	public void delete(Formateur entity) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationPersist.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.remove(em.merge(entity));
			
			tx.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}		
	}

	@Override
	public void deleteById(Long id) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationPersist.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.remove(em.find(Formateur.class, id));
			
			tx.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}		
	}		

}
