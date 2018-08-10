package formation.test.DAO.jpa;

import formationAA.dao.IDaoMatiere;
import formationAA.dao.jpa.DAOMatiereJPA;
import sopra.promo404.formation.model.Matiere;

public class TestDAOMatierejpa {

	public static void main(String[] args) {
		IDaoMatiere daoMatiere = new DAOMatiereJPA();
		
		Matiere histoire = new Matiere("Histoire", 120, "MOYEN");
		
		daoMatiere.save(histoire);
		
		
		Matiere s4 = daoMatiere.findById(1L);
		
		daoMatiere.delete(histoire);
	}

}
