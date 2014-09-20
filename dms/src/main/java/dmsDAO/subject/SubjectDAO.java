package dmsDAO.subject;

import java.rmi.NoSuchObjectException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dmsDAO.persistentUtil.PersistentFactory;
import dmsEntites.subject.SubjectEntity;

public class SubjectDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(SubjectDAO.class);

	public static boolean saveSubject(SubjectEntity subject) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveSubject(pm, subject);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create subject ",
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

	private static boolean saveSubject(PersistenceManager pm,
			SubjectEntity subject) {

		return (pm.makePersistent(subject) != null ? true : false);
	}

	public static boolean saveMultipleSubject(List<SubjectEntity> subject) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveMultipleSubject(pm, subject);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create multiple subject ",
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

	private static boolean saveMultipleSubject(PersistenceManager pm,
			List<SubjectEntity> subject) {

		return (pm.makePersistentAll(subject) != null ? true : false);
	}

	public static boolean updateSubject(SubjectEntity subject) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = updateSubject(pm, subject);

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

	private static boolean updateSubject(PersistenceManager pm,
			SubjectEntity subject) throws Throwable {
		SubjectEntity dbSubject = pm.detachCopy(getSubjectBySubjectId(pm,
				subject.getSubjectId()));

		dbSubject.updateAll(subject);

		return (pm.makePersistent(dbSubject) != null ? true : false);
	}

	public static SubjectEntity getSubjectBySubjectId(long id) {
		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		SubjectEntity subject = null;

		try {
			tx.begin();

			subject = getSubjectBySubjectId(pm, id);

			pm.makeTransient(subject);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch subject by id: {}",
					id, e);

		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}
		return subject;

	}

	private static SubjectEntity getSubjectBySubjectId(PersistenceManager pm,
			long id) throws Throwable {

		Query query = pm.newQuery(SubjectEntity.class);

		try {
			query.setFilter("this.subjectId == subjectId");
			query.declareParameters("long subjectId");
			query.setUnique(true);

			SubjectEntity subject = (SubjectEntity) query.execute(id);

			if (subject == null)
				throw new NoSuchObjectException("no object for id : " + id);

			return subject;
		} catch (Throwable e) {
			logger.error(" failed to get object by id :{} ", id);
			throw e;
		}
	}

	public static List<SubjectEntity> getAllSubject() {
		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<SubjectEntity> subject = null;

		try {
			tx.begin();

			subject = getAllSubject();

			pm.makeTransientAll(subject);

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
		return subject;

	}

	private static List<SubjectEntity> getAllSubject(PersistenceManager pm)
			throws Throwable {

		Query query = pm.newQuery(SubjectEntity.class);

		try {

			@SuppressWarnings("unchecked")
			List<SubjectEntity> subject = (List<SubjectEntity>) query.execute();

			if (subject == null)
				throw new NoSuchObjectException("no object ");

			return subject;
		} catch (Throwable e) {
			logger.error(" failed to get objects ");
			throw e;
		}
	}

	public static List<SubjectEntity> getSubjectByMultipleSubjectIds(
			List<Long> ids) {
		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<SubjectEntity> subject = null;

		try {
			tx.begin();

			subject = getSubjectByMultipleSubjectIds(pm, ids);

			pm.makeTransientAll(subject);

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
		return subject;

	}

	private static List<SubjectEntity> getSubjectByMultipleSubjectIds(
			PersistenceManager pm, List<Long> ids) throws Throwable {

		Query query = pm.newQuery(SubjectEntity.class);

		try {

			query.setFilter(getQueryForMultipleId(ids));

			@SuppressWarnings("unchecked")
			List<SubjectEntity> subject = (List<SubjectEntity>) query
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

	public static boolean removeSubject(long id) {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeSubject(pm, id);

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

	private static boolean removeSubject(PersistenceManager pm, long id)
			throws Throwable {
		boolean success = true;

		SubjectEntity dbSubject = getSubjectBySubjectId(pm, id);
		pm.deletePersistent(dbSubject);

		return success;
	}

	public static boolean removeAllSubject() {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeAllSubject(pm);

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

	private static boolean removeAllSubject(PersistenceManager pm)
			throws Throwable {
		boolean success = true;

		List<SubjectEntity> dbSubject = getAllSubject(pm);
		pm.deletePersistentAll(dbSubject);

		return success;
	}

	public static boolean removeMultipleSubjectByIds(List<Long> id) {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeMultipleSubjectByIds(pm, id);

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

	private static boolean removeMultipleSubjectByIds(PersistenceManager pm,
			List<Long> id) throws Throwable {
		boolean success = true;

		List<SubjectEntity> dbSubject = getSubjectByMultipleSubjectIds(pm, id);
		pm.deletePersistentAll(dbSubject);

		return success;
	}

}
