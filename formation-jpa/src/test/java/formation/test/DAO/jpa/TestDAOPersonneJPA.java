package formation.test.DAO.jpa;

import sopra.promo404.formation.model.Adresse;
import sopra.promo404.formation.model.Civilite;
import sopra.promo404.formation.model.Eleve;
import sopra.promo404.formation.model.Personne;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import formationAA.dao.IDaoPersonne;
import formationAA.dao.jpa.DAOPersonneJPA;

public class TestDAOPersonneJPA {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IDaoPersonne daoPersonne = new DAOPersonneJPA();

		Personne jeanBon = null;
		try {
			jeanBon = new Eleve(Civilite.M, "Bon", "Jean", sdf.parse("17/11/1993"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jeanBon.setAdresse(new Adresse("blblb", "666", "bordeaux", "Zimbabwe"));

		daoPersonne.save(jeanBon); 

		Personne s4 = daoPersonne.findById(10L);

		daoPersonne.delete(jeanBon);

	}

}
