package org.ldv.sio.getap.app.service;

import java.util.List;

import org.ldv.sio.getap.app.AccPersonalise;
import org.ldv.sio.getap.app.Classe;
import org.ldv.sio.getap.app.DemandeConsoTempsAccPers;
import org.ldv.sio.getap.app.User;

/**
 * Contrat de services pour les cas d'utilisation
 * 
 * @author VINSII - projet GeTAP - SIO MELUN
 * 
 */
public interface IFManagerGeTAP {

	// CRUD DCTAP
	/**
	 * obtenir la liste des toutes les dctaps déclarées par un eleve
	 * 
	 * @param eleve
	 * @return la liste des dctaps de l'élève
	 */
	public List<DemandeConsoTempsAccPers> getAllDCTAPByEleve(User eleve);

	/**
	 * obtenir la liste des dctaps sous la responsabilité d'un professeur
	 * (intervenant)
	 * 
	 * @param profi
	 *          le professeur désigné par les dctaps
	 * @return liste de dctaps associés au professeur (vide si aucune dctap)
	 */
	public List<DemandeConsoTempsAccPers> getAllDCTAPByProfInterv(User profi);

	/**
	 * obtenir la liste des dctaps des eleves dont la classe adment un même prof
	 * principal
	 * 
	 * @param profp
	 *          le professeur principal en question
	 * @return la liste des dctaps d'eleves dont la classe admet profp comme prof
	 *         principal
	 */
	public List<DemandeConsoTempsAccPers> getAllDCTAPByProfPrinc(User profp);

	/**
	 * obtenir la liste des dctaps de tous les eleves d'une classe
	 * 
	 * @param nomClasse
	 *          le libelle de la classe en question
	 * @return la liste des dctaps de tous les eleves d'une classe
	 */
	public List<DemandeConsoTempsAccPers> getAllDCTAPByClasse(String nomClasse);

	/**
	 * obtenir une dctap à partir de son id
	 * 
	 * @param id
	 *          valeur identifiant une dctap
	 * @return la dctap ayant même valeur d'id, ou null sinon
	 */
	public DemandeConsoTempsAccPers getDCTAPById(Long id);

	/**
	 * demande la création d'une dctap dans le système de persistance
	 * 
	 * @param dctap
	 *          l'objet à enregistrer
	 */
	public void addDCTAP(DemandeConsoTempsAccPers dctap);

	/**
	 * demande la mise à jour d'une dctap dans le système de persistance
	 * 
	 * @param dctap
	 *          l'objet à mettre à jour (à partir de son id)
	 */
	public void updateDCTAP(DemandeConsoTempsAccPers dctap);

	/**
	 * demande la suppression d'une dctap dans le système de persistance
	 * 
	 * @param dctap
	 *          l'objet à supprimer (d'après son id)
	 */
	public void deleteDCTAP(DemandeConsoTempsAccPers dctap);

	/**
	 * demande la suppression d'une dctap dans le système de persistance
	 * 
	 * @param id
	 *          l'identifiant de l'objet à supprimer
	 * 
	 * @return true si l'opération a réussi, faux sinon
	 */
	public boolean deleteDCTAPById(Long id);

	// CRUD User
	/**
	 * obtenir la liste de tous les professeurs
	 * 
	 * @return la liste de tous les professeurs
	 */
	public List<User> getAllProf();

	/**
	 * obtenir la liste de tous les professeurs intervenants
	 * 
	 * @return la liste de tous les professeurs intervenants
	 */
	public List<User> getAllProfInter();

	/**
	 * obtenir la liste de tous les professeurs principaux
	 * 
	 * @return la liste de tous les professeurs principaux
	 */
	public List<User> getAllProfPrinc();

	/**
	 * obtenir la liste de tous les élèves
	 * 
	 * @return la liste de tous les élèves
	 */
	public List<User> getAllEleve();

	/**
	 * obtenir l'utilisateur
	 * 
	 * @param id
	 *          l'id de l'utilisateur recherché
	 * @return l'utilisateur ayant l'id recherché, ou null si non trouvé
	 */
	public User getUserById(Long id);

	/**
	 * ajouter l'utilisateur dans le système de persistance
	 * 
	 * @param user
	 *          l'utilisateur à ajouter
	 */
	public void addUser(User user);

	/**
	 * mettre à jour l'utilisateur dans le système de persistance
	 * 
	 * @param user
	 *          l'utilisateur à mettre à jour dans le système de persistance à
	 *          partir de son id
	 */
	public void updateUser(User user);

	/**
	 * supprimer l'utilisateur présent dans le système de persistance
	 * 
	 * @param user
	 *          l'utilisateur à supprimer dans le système de persistance à partir
	 *          de son id
	 */
	public void deleteUser(User user);

	// CRUD de AP
	/**
	 * obtenir la liste des AP (type d'accompagnement personnalisé)
	 * 
	 * @return la liste d'objets de type AccPersonalise
	 */
	public List<AccPersonalise> getAllAP();

	/**
	 * obtenir une AP d'après son id
	 * 
	 * @param id
	 *          identifiant de l'AP à rechercher
	 * @return l'AP à rechercher, ou null sinon
	 */
	public AccPersonalise getAPById(int id);

	/**
	 * ajouter une AP au système de persistance
	 * 
	 * @param ap
	 *          l'objet à persister
	 */
	public void addAP(AccPersonalise ap);

	/**
	 * mettre à jour une AP dans le système de persistance
	 * 
	 * @param ap
	 *          l'objet à modifier dans le système de persistance (à partir de son
	 *          id)
	 */
	public void upDateAP(AccPersonalise ap);

	/**
	 * supprimer une AP dans le système de persistance
	 * 
	 * @param ap
	 *          l'objet à supprimer (à partir de son id)
	 */
	public void deleteAP(AccPersonalise ap);

	// CRUD de classe
	/**
	 * obetnir la liste de toutes les classes
	 * 
	 * @return la liste de toutes les classes
	 */
	public List<Classe> getAllClasse();

	/**
	 * obtenir une classe à partir du système de persistance
	 * 
	 * @param id
	 *          identifiant de la classe
	 * @return une instance de Classe ou null si non trouvé
	 */
	public Classe getClasseById(int id);

	/**
	 * ajouter une classe au système de persistance
	 * 
	 * @param classe
	 *          la classe à ajouter
	 */
	public void addClasse(Classe classe);

	/**
	 * mettre à jour une classe dans le système de persistance
	 * 
	 * @param classe
	 *          l'objet à modifier dans le système de persistance (à partir de son
	 *          id)
	 */
	public void upDateClasse(Classe classe);

	/**
	 * supprimer une classe du système de persistance
	 * 
	 * @param classe
	 *          l'objet à supprimer
	 */
	public void deleteClasse(Classe classe);

	// Opération sur annee scolaire (mise à jour lors d'une importation)
	/**
	 * obtenir l'année scolaire en cours (normalement défini par la dernière
	 * opération d'import)
	 * 
	 * @return une chaine au format "AAAA-AAAA"
	 */
	public String getCurrentAnneeScolaire();

	/**
	 * obtenir la liste des années scolaires (année courante et celles
	 * antérieurement traitées)
	 * 
	 * @return une liste d'années scolaires
	 */
	public List<String> getAllAnneeScolaire();
}
