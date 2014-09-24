package dmsDAO.faculty;

import java.rmi.NoSuchObjectException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dmsDAO.persistentUtil.PersistentFactory;
import dmsEntites.faculty.FacultyEntity;

public class FacultyDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(FacultyDAO.class);
	

	public static FacultyEntity getFacultyObjectById(long id) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		FacultyEntity result = null;

		try {

			tx.begin();

			result = getFacultyObjectById(pm, id);

			pm.makeTransient(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch FacultyEntity by id: {}",
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

	private static FacultyEntity getFacultyObjectById(PersistenceManager pm,
			long id) throws Throwable {

		Query query = pm.newQuery(FacultyEntity.class);

		try {

			query.setFilter("this.facultyId == facultyId");
			query.declareParameters("long facultyId");
			query.setUnique(true);

			FacultyEntity result = (FacultyEntity) query.execute(id);

			if (result == null)
				throw new NoSuchObjectException("no object for id : " + id);

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get object by id :{} ", id);
			throw e;
		}

	}

	public static List<FacultyEntity> getAllFacultyObject() {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<FacultyEntity> result = null;

		try {

			tx.begin();

			result = getAllFacultyObject(pm);

			pm.makeTransientAll(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch All FacultyEntity ",
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

	private static List<FacultyEntity> getAllFacultyObject(PersistenceManager pm)
			throws Throwable {

		Query query = pm.newQuery(FacultyEntity.class);

		try {

			@SuppressWarnings("unchecked")
			List<FacultyEntity> result = (List<FacultyEntity>) query.execute();

			if (result == null)
				throw new NoSuchObjectException("no object ");

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get All object ");
			throw e;
		}

	}

	public static List<FacultyEntity> getFacultyObjectByFacultyName(
			String facultyName) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<FacultyEntity> result = null;

		try {

			tx.begin();

			result = getFacultyObjectByFacultyName(pm, facultyName);

			pm.makeTransientAll(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch FacultyEntity by id: {}",
					facultyName, e);

		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return result;

	}

	private static List<FacultyEntity> getFacultyObjectByFacultyName(
			PersistenceManager pm, String name) throws Throwable {

		Query query = pm.newQuery(FacultyEntity.class);

		try {

			query.setFilter("this.facultyName == facultyName");
			query.declareParameters("String facultyName");

			@SuppressWarnings("unchecked")
			List<FacultyEntity> result = (List<FacultyEntity>) query
					.execute(name);

			if (result == null)
				throw new NoSuchObjectException("no object for name : " + name);

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get object by name :{} ", name);
			throw e;
		}

	}

	public static boolean saveFacultyEntity(FacultyEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveFacultyEntity(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create FacultyEntity ",
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

	private static boolean saveFacultyEntity(PersistenceManager pm,
			FacultyEntity input) {

		return (pm.makePersistent(input) != null ? true : false);
	}

	public static boolean saveMultipleFacultyEntity(List<FacultyEntity> input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveMultipleFacultyEntity(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create FacultyEntity ",
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

	private static boolean saveMultipleFacultyEntity(PersistenceManager pm,
			List<FacultyEntity> input) {

		return (pm.makePersistentAll(input) != null ? true : false);
	}

	public static boolean updateFacultyEntity(FacultyEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = updateFacultyEntity(pm, input);

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

	private static boolean updateFacultyEntity(PersistenceManager pm,
			FacultyEntity input) throws Throwable {

		FacultyEntity dbObject = pm.detachCopy(getFacultyObjectById(pm,
				input.getFacultyId()));

		dbObject.updateAll(input);

		return (pm.makePersistent(dbObject) != null ? true : false);
	}

	public static boolean removeFacultyEntityById(long id) {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeFacultyEntityById(pm, id);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to delete faculty by id: {}",
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

	private static boolean removeFacultyEntityById(PersistenceManager pm,
			long id) throws Throwable {
		boolean success = true;

		FacultyEntity dbobject = getFacultyObjectById(pm, id);
		pm.deletePersistent(dbobject);

		return success;
	}

	public static boolean removeAllFacultyEntity() {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeAllFacultyEntity(pm);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to delete All subject ",
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

	private static boolean removeAllFacultyEntity(PersistenceManager pm)
			throws Throwable {

		boolean success = true;

		List<FacultyEntity> dbobjects = getAllFacultyObject(pm);
		pm.deletePersistentAll(dbobjects);

		return success;
	}

	public static List<FacultyEntity> getFacultyEntityByMultipleStudentIds(
			List<Long> ids) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<FacultyEntity> result = null;

		try {
			tx.begin();

			result = getFacultyEntityByMultipleStudentIds(pm, ids);

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

	private static List<FacultyEntity> getFacultyEntityByMultipleStudentIds(
			PersistenceManager pm, List<Long> ids) throws Throwable {

		Query query = pm.newQuery(FacultyEntity.class);

		try {

			query.setFilter(getQueryForMultipleId(ids));

			@SuppressWarnings("unchecked")
			List<FacultyEntity> subject = (List<FacultyEntity>) query.execute();

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
		String baseString = "this.studentId==";

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
