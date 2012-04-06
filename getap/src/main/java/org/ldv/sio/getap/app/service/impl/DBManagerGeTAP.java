package org.ldv.sio.getap.app.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.ldv.sio.getap.app.AccPersonalise;
import org.ldv.sio.getap.app.Classe;
import org.ldv.sio.getap.app.DemandeConsoTempsAccPers;
import org.ldv.sio.getap.app.User;
import org.ldv.sio.getap.app.service.IFManagerGeTAP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service("DBServiceMangager")
public class DBManagerGeTAP implements IFManagerGeTAP {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<DemandeConsoTempsAccPers> getAllDCTAPByEleve(User eleve) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DemandeConsoTempsAccPers> getAllDCTAPByProfInterv(User profi) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DemandeConsoTempsAccPers> getAllDCTAPByProfPrinc(User profp) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DemandeConsoTempsAccPers> getAllDCTAPByClasse(String nomClasse) {
		// TODO Auto-generated method stub
		return null;
	}

	public DemandeConsoTempsAccPers getDCTAPById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addDCTAP(DemandeConsoTempsAccPers dctap) {
		// TODO Auto-generated method stub

	}

	public void updateDCTAP(DemandeConsoTempsAccPers dctap) {
		// TODO Auto-generated method stub

	}

	public void deleteDCTAP(DemandeConsoTempsAccPers dctap) {
		// TODO Auto-generated method stub

	}

	public boolean deleteDCTAPById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> getAllProf() {
		return this.jdbcTemplate.query(
		    "select * from user where role like 'prof%'", new UserMapper());

	}

	public List<User> getAllProfInter() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllProfPrinc() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllEleve() {
		return this.jdbcTemplate.query("select * from user where role = 'eleve'",
		    new UserMapper());
	}

	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	public List<AccPersonalise> getAllAP() {
		// TODO Auto-generated method stub
		return null;
	}

	public AccPersonalise getAPById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAP(AccPersonalise ap) {
		// TODO Auto-generated method stub

	}

	public void upDateAP(AccPersonalise ap) {
		// TODO Auto-generated method stub

	}

	public void deleteAP(AccPersonalise ap) {
		// TODO Auto-generated method stub

	}

	public List<Classe> getAllClasse() {
		// TODO Auto-generated method stub
		return null;
	}

	public Classe getClasseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addClasse(Classe classe) {
		// TODO Auto-generated method stub

	}

	public void upDateClasse(Classe classe) {
		// TODO Auto-generated method stub

	}

	public void deleteClasse(Classe classe) {
		// TODO Auto-generated method stub

	}

	public String getCurrentAnneeScolaire() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAllAnneeScolaire() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByLogin(String login, String pw) {
		User user;
		try {
			user = this.jdbcTemplate.queryForObject(
			    "select * from user where nom = ?", new Object[] { login },
			    new UserMapper());

		} catch (EmptyResultDataAccessException e) {
			user = null;
		}
		return user;
	}

	// classe pour passage d'une ligne d'une table à un objet
	private static final class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setPrenom(rs.getString("prenom"));
			user.setNom(rs.getString("nom"));
			user.setRole(rs.getString("role"));
			// TODO relation avec Classe
			Classe classe = new Classe();
			// if rs.getString("idClasse")
			// classe.setId(Integer.parseInt(rs.getString("idClasse")));
			// classe.setNom("bidon");
			user.setClasse(classe);
			return user;
		}
	}

}
