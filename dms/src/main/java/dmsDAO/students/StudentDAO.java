package dmsDAO.students;

import java.rmi.NoSuchObjectException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dmsDAO.persistentUtil.PersistentFactory;
import dmsEntites.students.StudentEntity;

public class StudentDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(StudentDAO.class);

	public static StudentEntity getStudentObjectById(long id) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		StudentEntity result = null;

		try {

			tx.begin();

			result = getStudentObjectById(pm, id);

			pm.makePersistent(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch StudentEntity by id: {}",
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

	private static StudentEntity getStudentObjectById(PersistenceManager pm,
			long id) throws Throwable {

		Query query = pm.newQuery(StudentEntity.class);

		try {

			query.setFilter("this.studentId == studentId");
			query.declareParameters("long studentId");
			query.setUnique(true);

			StudentEntity result = (StudentEntity) query.execute(id);

			if (result == null)
				throw new NoSuchObjectException("no object for id : " + id);

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get object by id :{} ", id);
			throw e;
		}

	}

	public static List<StudentEntity> getAllStudentObject() {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<StudentEntity> result = null;

		try {

			tx.begin();

			result = getAllStudentObject(pm);

			pm.makePersistentAll(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch All StudentEntity ",
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

	private static List<StudentEntity> getAllStudentObject(PersistenceManager pm)
			throws Throwable {

		Query query = pm.newQuery(StudentEntity.class);

		try {

			@SuppressWarnings("unchecked")
			List<StudentEntity> result = (List<StudentEntity>) query.execute();

			if (result == null)
				throw new NoSuchObjectException("no object ");

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get All object ");
			throw e;
		}

	}

	public static List<StudentEntity> getStudentObjectByStudentName(
			String studentName) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<StudentEntity> result = null;

		try {

			tx.begin();

			result = getStudentObjectByStudentName(pm, studentName);

			pm.makePersistent(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch StudentEntity by id: {}",
					studentName, e);

		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return result;

	}

	private static List<StudentEntity> getStudentObjectByStudentName(
			PersistenceManager pm, String name) throws Throwable {

		Query query = pm.newQuery(StudentEntity.class);

		try {

			query.setFilter("this.studentName == studentName");
			query.declareParameters("String studentName");

			@SuppressWarnings("unchecked")
			List<StudentEntity> result = (List<StudentEntity>) query
					.execute(name);

			if (result == null)
				throw new NoSuchObjectException("no object for name : " + name);

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get object by name :{} ", name);
			throw e;
		}

	}

	public static boolean saveStudentEntity(StudentEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveStudentEntity(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create StudentEntity ",
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

	private static boolean saveStudentEntity(PersistenceManager pm,
			StudentEntity input) {

		return (pm.makePersistent(input) != null ? true : false);
	}

	public static boolean saveMultipleStudentEntity(List<StudentEntity> input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveMultipleStudentEntity(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create StudentEntity ",
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

	private static boolean saveMultipleStudentEntity(PersistenceManager pm,
			List<StudentEntity> input) {

		return (pm.makePersistentAll(input) != null ? true : false);
	}

	public static boolean updateStudentEntity(StudentEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = updateStudentEntity(pm, input);

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

	private static boolean updateStudentEntity(PersistenceManager pm,
			StudentEntity input) throws Throwable {

		StudentEntity dbObject = pm.detachCopy(getStudentObjectById(pm,
				input.getStudentId()));

		dbObject.updateAll(input);

		return (pm.makePersistent(dbObject) != null ? true : false);
	}

	public static boolean removeStudentEntityById(long id) {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeStudentEntityById(pm, id);

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

	private static boolean removeStudentEntityById(PersistenceManager pm,
			long id) throws Throwable {
		boolean success = true;

		StudentEntity dbobject = getStudentObjectById(pm, id);
		pm.deletePersistent(dbobject);

		return success;
	}

	public static boolean removeAllStudentEntity() {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeAllStudentEntity(pm);

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

	private static boolean removeAllStudentEntity(PersistenceManager pm)
			throws Throwable {

		boolean success = true;

		List<StudentEntity> dbobjects = getAllStudentObject(pm);
		pm.deletePersistentAll(dbobjects);

		return success;
	}

	public static List<StudentEntity> getStudentEntityByMultipleStudentIds(
			List<Long> ids) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<StudentEntity> result = null;

		try {
			tx.begin();

			result = getStudentEntityByMultipleStudentIds(pm, ids);

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

	private static List<StudentEntity> getStudentEntityByMultipleStudentIds(
			PersistenceManager pm, List<Long> ids) throws Throwable {

		Query query = pm.newQuery(StudentEntity.class);

		try {

			query.setFilter(getQueryForMultipleId(ids));

			@SuppressWarnings("unchecked")
			List<StudentEntity> subject = (List<StudentEntity>) query.execute();

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
