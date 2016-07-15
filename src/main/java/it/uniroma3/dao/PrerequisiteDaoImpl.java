package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.uniroma3.model.ExamType;
import it.uniroma3.model.Prerequisite;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PrerequisiteDaoImpl implements PrerequisiteDao {
	
	private static final Logger logger = LoggerFactory.getLogger(PrerequisiteDaoImpl.class);
	
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	@Transactional
	public List<Prerequisite> listPrerequisite() {
		Query query = em.createQuery("SELECT p FROM Prerequisite p");
		@SuppressWarnings("unchecked")
		List<Prerequisite> preList = query.getResultList();
		logger.info("Prerequisite List::" + preList);
		return preList;
	}

	@Override
	@Transactional
	public List<Prerequisite> listPrerequisiteForType(Integer examTypeId) {
		ExamType examType = em.find(ExamType.class, examTypeId);
		Query query = em.createQuery("SELECT p FROM Prerequisite p WHERE p.examType = ?1");
		@SuppressWarnings("unchecked")
		List<Prerequisite> preList = query.setParameter(1, examType).getResultList();
		logger.info("Prerequisite List::" + preList);
		return preList;
	}

	@Override
	@Transactional
	public void insertPrerequisite(Prerequisite prerequisite) {
		em.persist(prerequisite);
	}

	@Override
	@Transactional
	public void deletePrerequisite(Integer preId) {
		Prerequisite p = em.find(Prerequisite.class, preId);
		em.remove(em.merge(p));
	}

	@Override
	@Transactional
	public void insertPreToType(Integer examTypeId, Prerequisite prerequisite) {
		ExamType et = em.find(ExamType.class, examTypeId);
		et.getPrerequisites().add(prerequisite);
		em.persist(et);
	}

}
