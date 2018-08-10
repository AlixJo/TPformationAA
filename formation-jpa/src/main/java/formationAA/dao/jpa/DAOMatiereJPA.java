package formationAA.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import eshop.dao.Eshop;
import eshop.dao.jpa.EntityManager;
import eshop.dao.jpa.EntityTransaction;
import eshop.dao.jpa.Produit;
import eshop.dao.jpa.Query;
import formationAA.dao.IDaoMatiere;
import sopra.promo404.formation.model.Matiere;

public class DAOMatiereJPA implements IDaoMatiere {

	@Override
	public List<Matiere> findAll() {
		List<Matiere> liste = new ArrayList<>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Eshop.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Query query = em.createQuery("from Produit", Produit.class);
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
	public Matiere findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matiere save(Matiere entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Matiere entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
