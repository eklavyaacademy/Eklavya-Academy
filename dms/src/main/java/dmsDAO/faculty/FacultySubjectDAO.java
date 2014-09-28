package dmsDAO.faculty;

import java.rmi.NoSuchObjectException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dmsDAO.persistentUtil.PersistentFactory;
import dmsEntites.faculty.FacultySubjectsEntity;

public class FacultySubjectDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(FacultySubjectDAO.class);
	

	public static FacultySubjectsEntity getFacultySubjectBySubjectId(long id) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		FacultySubjectsEntity result = null;

		try {

			tx.begin();

			result = getFacultySubjectBySubjectId(pm, id);

			pm.makeTransient(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch FacultySubjectsEntity by id: {}",
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

	private static FacultySubjectsEntity getFacultySubjectBySubjectId(PersistenceManager pm,
			long id) throws Throwable {

		Query query = pm.newQuery(FacultySubjectsEntity.class);

		try {

			query.setFilter("this.subjectId == subjectId");
			query.declareParameters("long subjectId");
			query.setUnique(true);

			FacultySubjectsEntity result = (FacultySubjectsEntity) query.execute(id);

			if (result == null)
				throw new NoSuchObjectException("no object for id : " + id);

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get object by id :{} ", id);
			throw e;
		}

	}

	public static List<FacultySubjectsEntity> getAllFacultySubject() {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<FacultySubjectsEntity> result = null;

		try {

			tx.begin();

			result = getAllFacultySubject(pm);

			pm.makeTransientAll(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch All FacultySubjectsEntity ",
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

	private static List<FacultySubjectsEntity> getAllFacultySubject(PersistenceManager pm)
			throws Throwable {

		Query query = pm.newQuery(FacultySubjectsEntity.class);

		try {

			@SuppressWarnings("unchecked")
			List<FacultySubjectsEntity> result = (List<FacultySubjectsEntity>) query.execute();

			if (result == null)
				throw new NoSuchObjectException("no object ");

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get All object ");
			throw e;
		}

	}

	public static boolean saveFacultySubject(FacultySubjectsEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveFacultySubject(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create FacultySubjectsEntity ",
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

	private static boolean saveFacultySubject(PersistenceManager pm,
			FacultySubjectsEntity input) {

		return (pm.makePersistent(input) != null ? true : false);
	}

	public static boolean saveMultipleFacultySubject(List<FacultySubjectsEntity> input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveMultipleFacultySubject(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create FacultySubjectsEntity ",
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

	private static boolean saveMultipleFacultySubject(PersistenceManager pm,
			List<FacultySubjectsEntity> input) {

		return (pm.makePersistentAll(input) != null ? true : false);
	}

	public static boolean updateFacultySubject(FacultySubjectsEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = updateFacultySubject(pm, input);

			tx.commit();
		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to update FacultySubjectsEntity ",
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

	private static boolean updateFacultySubject(PersistenceManager pm,
			FacultySubjectsEntity input) throws Throwable {

		FacultySubjectsEntity dbObject = pm.detachCopy(getFacultySubjectBySubjectId(pm,
				input.getSubjectId()));

		dbObject.updateAll(input);

		return (pm.makePersistent(dbObject) != null ? true : false);
	}

	public static boolean removeFacultySubjectBySubjectId(long id) {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeFacultySubjectBySubjectId(pm, id);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to delete Faculty Subject by id: {}",
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

	private static boolean removeFacultySubjectBySubjectId(PersistenceManager pm,
			long id) throws Throwable {
		boolean success = true;

		FacultySubjectsEntity dbobject = getFacultySubjectBySubjectId(pm, id);
		pm.deletePersistent(dbobject);

		return success;
	}

	public static boolean removeAllFacultySubject() {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeAllFacultySubject(pm);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to delete All facultySubject ",
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

	private static boolean removeAllFacultySubject(PersistenceManager pm)
			throws Throwable {

		boolean success = true;

		List<FacultySubjectsEntity> dbobjects = getAllFacultySubject(pm);
		pm.deletePersistentAll(dbobjects);

		return success;
	}

	public static List<FacultySubjectsEntity> getFacultySubjectByMultipleSubjectIds(
			List<Long> ids) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<FacultySubjectsEntity> result = null;

		try {
			tx.begin();

			result = getFacultySubjectByMultipleSubjectIds(pm, ids);

			pm.makeTransientAll(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch  FacultySubject by ids: {}"+ids.toString(),
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

	private static List<FacultySubjectsEntity> getFacultySubjectByMultipleSubjectIds(
			PersistenceManager pm, List<Long> ids) throws Throwable {

		Query query = pm.newQuery(FacultySubjectsEntity.class);

		try {

			query.setFilter(getQueryForMultipleId(ids));

			@SuppressWarnings("unchecked")
			List<FacultySubjectsEntity> batchs = (List<FacultySubjectsEntity>) query.execute();

			if (batchs == null)
				throw new NoSuchObjectException("no object for id : " + ids);

			return batchs;
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
