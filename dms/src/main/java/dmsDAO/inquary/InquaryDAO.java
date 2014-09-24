package dmsDAO.inquary;

import java.rmi.NoSuchObjectException;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dmsDAO.persistentUtil.PersistentFactory;
import dmsEntites.inquary.InquaryEntity;

public class InquaryDAO {


	private static final Logger logger = LoggerFactory
			.getLogger(InquaryDAO.class);

	
	
	public static InquaryEntity getInquaryObjectByInquaryId(
			long id) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		InquaryEntity result = null;

		try {

			tx.begin();

			result = getInquaryObjectByInquaryId(pm, id);

			pm.makeTransient(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch InquaryEntity by id: {}",
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

	private static InquaryEntity getInquaryObjectByInquaryId(
			PersistenceManager pm, long id) throws Throwable {

		Query query = pm.newQuery(InquaryEntity.class);

		try {

			query.setFilter("this.inqaryId == inqaryId");
			query.declareParameters("long inqaryId");
			query.setUnique(true);

			InquaryEntity result = (InquaryEntity) query
					.execute(id);

			if (result == null)
				throw new NoSuchObjectException("no object for id : " + id);

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get object by id :{} ", id);
			throw e;
		}

	}
	

	
	public static List<InquaryEntity> getAllInquaryObject() {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<InquaryEntity> result = null;

		try {

			tx.begin();

			result = getAllInquaryObject(pm);

			pm.makeTransient(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch all InquaryEntity ", e);

		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return result;

	}

	public static List<InquaryEntity> getAllInquaryObject(
			PersistenceManager pm) throws Throwable {

		Query query = pm.newQuery(InquaryEntity.class);

		try {

			@SuppressWarnings("unchecked")
			List<InquaryEntity> result = (List<InquaryEntity>) query
					.execute();

			if (result == null)
				throw new NoSuchObjectException("no object available : " );

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get All object by id ");
			throw e;
		}

	}
	
	
	

	
	public static InquaryEntity getInquaryObjectByInquaryDate(
			Date date) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		InquaryEntity result = null;

		try {

			tx.begin();

			result = getInquaryObjectByInquaryDate(pm, date);

			pm.makeTransient(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch InquaryEntity by date: {}",
					date, e);

		} finally {

			// rollback in case of error
			if (tx.isActive()) {
				tx.rollback();
				logger.error("failed to commit, rolling back tranaction");
			}
		}

		return result;

	}

	public static InquaryEntity getInquaryObjectByInquaryDate(
			PersistenceManager pm, Date date ) throws Throwable {

		Query query = pm.newQuery(InquaryEntity.class);

		try {

			query.setFilter("this.inquaryDate == inquaryDate");
			query.declareParameters("long inquaryDate");
			query.setUnique(true);

			InquaryEntity result = (InquaryEntity) query
					.execute(date);

			if (result == null)
				throw new NoSuchObjectException("no object for date : " + date);

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get object by date :{} ", date);
			throw e;
		}

	}
	
	
	


	public static boolean saveInquaryEntity(
			InquaryEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveInquaryEntity(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create InquaryEntity ",
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

	private static boolean saveInquaryEntity(
			PersistenceManager pm, InquaryEntity input) {

		return (pm.makePersistent(input) != null ? true : false);
	}

	public static boolean saveMultipleInquaryEntity(
			List<InquaryEntity> input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveMultipleInquaryEntity(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create InquaryEntity ",
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

	private static boolean saveMultipleInquaryEntity(
			PersistenceManager pm, List<InquaryEntity> input) {

		return (pm.makePersistentAll(input) != null ? true : false);
	}

	

	public static boolean updateInquaryEntity(
			InquaryEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = updateInquaryEntity(pm, input);

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

	private static boolean updateInquaryEntity(
			PersistenceManager pm, InquaryEntity input)
			throws Throwable {

		InquaryEntity dbObject = pm
				.detachCopy(getInquaryObjectByInquaryId(pm,	input.getInqaryId()));

		dbObject.updateAll(input);

		return (pm.makePersistent(dbObject) != null ? true : false);
	}

	
	

	

	public static boolean removeInquaryEntityById(long id) {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeInquaryEntityById(pm, id);

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

	private static boolean removeInquaryEntityById(PersistenceManager pm, long id)
			throws Throwable {
		boolean success = true;

		InquaryEntity dbobject = getInquaryObjectByInquaryId(pm, id);
		pm.deletePersistent(dbobject);

		return success;
	}
	
	

	public static boolean removeAllInquaryEntity() {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeAllInquaryEntity(pm);

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

	private static boolean removeAllInquaryEntity(PersistenceManager pm)
			throws Throwable {
		
		boolean success = true;

		List<InquaryEntity> dbobjects = getAllInquaryObject(pm);
		pm.deletePersistentAll(dbobjects);

		return success;
	}

	


	public static List<InquaryEntity> getInquaryEntityByMultipleInquaryIds(
			List<Long> ids) {
		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<InquaryEntity> result = null;

		try {
			tx.begin();

			result = getInquaryEntityByMultipleInquaryIds(pm, ids);

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

	private static List<InquaryEntity> getInquaryEntityByMultipleInquaryIds(
			PersistenceManager pm, List<Long> ids) throws Throwable {

		Query query = pm.newQuery(InquaryEntity.class);

		try {

			query.setFilter(getQueryForMultipleId(ids));

			@SuppressWarnings("unchecked")
			List<InquaryEntity> subject = (List<InquaryEntity>) query
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
