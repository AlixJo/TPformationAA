package formationAA.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formationAA.dao.FormationPersist;
import formationAA.dao.IDaoOrdinateur;
import sopra.promo404.formation.model.Ordinateur;

public class DAOOrdinateurJPA implements IDaoOrdinateur{

	@Override
	public List<Ordinateur> findAll() {
		List<Ordinateur> liste = new ArrayList<>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = FormationPersist.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Query query = em.createQuery("from Ordinateur", Ordinateur.class);
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
	public Ordinateur findById(String code) {
		Ordinateur entity = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = FormationPersist.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			entity = em.find(Ordinateur.class, code);

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
	public Ordinateur save(Ordinateur entity) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationPersist.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			if(entity.getCode() == null) {
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
	public void delete(Ordinateur entity) {
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
	public void deleteById(String code) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationPersist.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.remove(em.find(Ordinateur.class, code));
			
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
