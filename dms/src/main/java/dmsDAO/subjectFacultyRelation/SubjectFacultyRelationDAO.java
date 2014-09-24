package dmsDAO.subjectFacultyRelation;

import java.rmi.NoSuchObjectException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dmsDAO.persistentUtil.PersistentFactory;
import dmsEntites.subjectFacultyRelation.SubjectFacultyRelationEntity;

public class SubjectFacultyRelationDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(SubjectFacultyRelationDAO.class);

	public static SubjectFacultyRelationEntity getSubjectFacultyRelationEntityBySubjectId(
			long id) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		SubjectFacultyRelationEntity result = null;

		try {

			tx.begin();

			result = getSubjectFacultyRelationEntityBySubjectId(pm, id);

			pm.makeTransient(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch SubjectFacultyRelationEntity by id: {}",
					id, e);

		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return result;

	}

	public static SubjectFacultyRelationEntity getSubjectFacultyRelationEntityBySubjectId(
			PersistenceManager pm, long id) throws Throwable {

		Query query = pm.newQuery(SubjectFacultyRelationEntity.class);

		try {

			query.setFilter("this.subjectId == subjectId");
			query.declareParameters("long subjectId");
			query.setUnique(true);

			SubjectFacultyRelationEntity result = (SubjectFacultyRelationEntity) query
					.execute(id);

			if (result == null)
				throw new NoSuchObjectException("no object for id : " + id);

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get object by id :{} ", id);
			throw e;
		}

	}
	
	
	
	public static List<SubjectFacultyRelationEntity> getAllSubjectFacultyRelationEntity() {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<SubjectFacultyRelationEntity> result = null;

		try {

			tx.begin();

			result = getAllSubjectFacultyRelationEntity(pm);

			pm.makeTransient(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch all SubjectFacultyRelationEntity ", e);

		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return result;

	}

	public static List<SubjectFacultyRelationEntity> getAllSubjectFacultyRelationEntity(
			PersistenceManager pm) throws Throwable {

		Query query = pm.newQuery(SubjectFacultyRelationEntity.class);

		try {

			@SuppressWarnings("unchecked")
			List<SubjectFacultyRelationEntity> result = (List<SubjectFacultyRelationEntity>) query
					.execute();

			if (result == null)
				throw new NoSuchObjectException("no object available : " );

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get All object by id ");
			throw e;
		}

	}
	
	

	public static SubjectFacultyRelationEntity getSubjectFacultyRelationEntityById(
			long id) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		SubjectFacultyRelationEntity result = null;

		try {

			tx.begin();

			result = getSubjectFacultyRelationEntityById(pm, id);

			pm.makeTransient(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch SubjectFacultyRelationEntity by id: {}",
					id, e);

		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return result;

	}

	public static SubjectFacultyRelationEntity getSubjectFacultyRelationEntityById(
			PersistenceManager pm, long id) throws Throwable {

		Query query = pm.newQuery(SubjectFacultyRelationEntity.class);

		try {

			query.setFilter("this.id == id");
			query.declareParameters("long id");
			query.setUnique(true);

			SubjectFacultyRelationEntity result = (SubjectFacultyRelationEntity) query
					.execute(id);

			if (result == null)
				throw new NoSuchObjectException("no object for id : " + id);

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get object by id :{} ", id);
			throw e;
		}

	}

	public static boolean saveSubjectFacultyRelationEntity(
			SubjectFacultyRelationEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveSubjectFacultyRelationEntity(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create SubjectFacultyRelationEntity ",
					e);
		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return success;

	}

	private static boolean saveSubjectFacultyRelationEntity(
			PersistenceManager pm, SubjectFacultyRelationEntity input) {

		return (pm.makePersistent(input) != null ? true : false);
	}

	public static boolean saveMultipleSubjectFacultyRelationEntity(
			List<SubjectFacultyRelationEntity> input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveMultipleSubjectFacultyRelationEntity(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create SubjectFacultyRelationEntity ",
					e);
		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return success;

	}

	private static boolean saveMultipleSubjectFacultyRelationEntity(
			PersistenceManager pm, List<SubjectFacultyRelationEntity> input) {

		return (pm.makePersistentAll(input) != null ? true : false);
	}

	public static boolean updateSubjectFacultyRelationEntity(
			SubjectFacultyRelationEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = updateSubjectFacultyRelationEntity(pm, input);

			tx.commit();
		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to update subject ",
					e);
		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return success;
	}

	private static boolean updateSubjectFacultyRelationEntity(
			PersistenceManager pm, SubjectFacultyRelationEntity input)
			throws Throwable {

		SubjectFacultyRelationEntity dbObject = pm
				.detachCopy(getSubjectFacultyRelationEntityById(pm,
						input.getId()));

		dbObject.updateAll(input);

		return (pm.makePersistent(dbObject) != null ? true : false);
	}

	
	public static boolean updateSubjectFacultyRelationEntityFaculties(
			SubjectFacultyRelationEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = updateSubjectFacultyRelationEntityFaculties(pm, input);

			tx.commit();
		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to update subject ",
					e);
		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return success;
	}

	private static boolean updateSubjectFacultyRelationEntityFaculties(
			PersistenceManager pm, SubjectFacultyRelationEntity input)
			throws Throwable {

		SubjectFacultyRelationEntity dbObject = pm
				.detachCopy(getSubjectFacultyRelationEntityById(pm,
						input.getId()));

		dbObject.updateFaculties(input);

		return (pm.makePersistent(dbObject) != null ? true : false);
	}
	
	
	
	

	public static boolean removeSubjectFacultyRelationEntity(long id) {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeSubjectFacultyRelationEntity(pm, id);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to delete subject by id: {}",
					id, e);

		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return success;
	}

	private static boolean removeSubjectFacultyRelationEntity(PersistenceManager pm, long id)
			throws Throwable {
		boolean success = true;

		SubjectFacultyRelationEntity dbobject = getSubjectFacultyRelationEntityBySubjectId(pm, id);
		pm.deletePersistent(dbobject);

		return success;
	}
	
	

	public static boolean removeAllSubjectFacultyRelationEntity() {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeAllSubjectFacultyRelationEntity(pm);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to delete All subject ", e);

		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return success;
	}

	private static boolean removeAllSubjectFacultyRelationEntity(PersistenceManager pm)
			throws Throwable {
		
		boolean success = true;

		List<SubjectFacultyRelationEntity> dbobjects = getAllSubjectFacultyRelationEntity(pm);
		pm.deletePersistentAll(dbobjects);

		return success;
	}

	

	public static List<SubjectFacultyRelationEntity> getSubjectFacultyRelationEntityByMultipleSubjectIds(
			List<Long> ids) {
		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<SubjectFacultyRelationEntity> result = null;

		try {
			tx.begin();

			result = getSubjectFacultyRelationEntityByMultipleSubjectIds(pm, ids);

			pm.makeTransientAll(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch All subject",
					e);

		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}
		return result;

	}

	private static List<SubjectFacultyRelationEntity> getSubjectFacultyRelationEntityByMultipleSubjectIds(
			PersistenceManager pm, List<Long> ids) throws Throwable {

		Query query = pm.newQuery(SubjectFacultyRelationEntity.class);

		try {

			query.setFilter(getQueryForMultipleId(ids));

			@SuppressWarnings("unchecked")
			List<SubjectFacultyRelationEntity> subject = (List<SubjectFacultyRelationEntity>) query
					.execute();

			if (subject == null)
				throw new NoSuchObjectException("no object for id : " + ids);

			return subject;
		} catch (Throwable e) {
			logger.error(" failed to get object by id :{} ", ids);
			throw e;
		}
	}
	

	private static String getQueryForMultipleId(List<Long> ids) {
		StringBuilder qstring = new StringBuilder();
		String baseString = "this.subjectId==";

		int i = 0;
		for (long id : ids) {
			qstring.append(baseString + id);
			i++;
			if (i != ids.size()) {
				qstring.append("||");
			}
		}
		return qstring.toString();
	}

}

