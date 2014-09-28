package dmsDAO.faculty;

import java.rmi.NoSuchObjectException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dmsDAO.persistentUtil.PersistentFactory;
import dmsEntites.faculty.BatchEntity;

public class BatchDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(BatchDAO.class);
	

	public static BatchEntity getBatchByBatchId(long id) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		BatchEntity result = null;

		try {

			tx.begin();

			result = getBatchByBatchId(pm, id);

			pm.makeTransient(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch BatchEntity by id: {}",
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

	private static BatchEntity getBatchByBatchId(PersistenceManager pm,
			long id) throws Throwable {

		Query query = pm.newQuery(BatchEntity.class);

		try {

			query.setFilter("this.batchId == batchId");
			query.declareParameters("long batchId");
			query.setUnique(true);

			BatchEntity result = (BatchEntity) query.execute(id);

			if (result == null)
				throw new NoSuchObjectException("no object for id : " + id);

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get object by id :{} ", id);
			throw e;
		}

	}

	public static List<BatchEntity> getAllBatch() {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<BatchEntity> result = null;

		try {

			tx.begin();

			result = getAllBatch(pm);

			pm.makeTransientAll(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch All BatchEntity ",
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

	private static List<BatchEntity> getAllBatch(PersistenceManager pm)
			throws Throwable {

		Query query = pm.newQuery(BatchEntity.class);

		try {

			@SuppressWarnings("unchecked")
			List<BatchEntity> result = (List<BatchEntity>) query.execute();

			if (result == null)
				throw new NoSuchObjectException("no object ");

			return result;

		} catch (Throwable e) {

			logger.error(" failed to get All object ");
			throw e;
		}

	}

	public static boolean saveBatch(BatchEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveBatch(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create BatchEntity ",
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

	private static boolean saveBatch(PersistenceManager pm,
			BatchEntity input) {

		return (pm.makePersistent(input) != null ? true : false);
	}

	public static boolean saveMultipleBatch(List<BatchEntity> input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			success = saveMultipleBatch(pm, input);

			tx.commit();

		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to create BatchEntity ",
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

	private static boolean saveMultipleBatch(PersistenceManager pm,
			List<BatchEntity> input) {

		return (pm.makePersistentAll(input) != null ? true : false);
	}

	public static boolean updateBatch(BatchEntity input) {

		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = updateBatch(pm, input);

			tx.commit();
		} catch (Throwable e) {
			logger.error(
					"Unknown exception occurred while trying to update BatchEntity ",
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

	private static boolean updateBatch(PersistenceManager pm,
			BatchEntity input) throws Throwable {

		BatchEntity dbObject = pm.detachCopy(getBatchByBatchId(pm,
				input.getBatchId()));

		dbObject.updateAll(input);

		return (pm.makePersistent(dbObject) != null ? true : false);
	}

	public static boolean removeBatchByBatchId(long id) {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeBatchByBatchId(pm, id);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to delete Batch by id: {}",
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

	private static boolean removeBatchByBatchId(PersistenceManager pm,
			long id) throws Throwable {
		boolean success = true;

		BatchEntity dbobject = getBatchByBatchId(pm, id);
		pm.deletePersistent(dbobject);

		return success;
	}

	public static boolean removeAllBatch() {
		boolean success = false;

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			success = removeAllBatch(pm);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to delete All batch ",
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

	private static boolean removeAllBatch(PersistenceManager pm)
			throws Throwable {

		boolean success = true;

		List<BatchEntity> dbobjects = getAllBatch(pm);
		pm.deletePersistentAll(dbobjects);

		return success;
	}

	public static List<BatchEntity> getBatchByMultipleBatchIds(
			List<Long> ids) {

		// get persistent manager
		PersistenceManager pm = PersistentFactory.getPersistentManager();

		// get transaction
		Transaction tx = pm.currentTransaction();

		List<BatchEntity> result = null;

		try {
			tx.begin();

			result = getBatchByMultipleBatchIds(pm, ids);

			pm.makeTransientAll(result);

			tx.commit();

		} catch (Throwable e) {

			logger.error(
					"Unknown exception occurred while trying to fetch All batch",
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

	private static List<BatchEntity> getBatchByMultipleBatchIds(
			PersistenceManager pm, List<Long> ids) throws Throwable {

		Query query = pm.newQuery(BatchEntity.class);

		try {

			query.setFilter(getQueryForMultipleId(ids));

			@SuppressWarnings("unchecked")
			List<BatchEntity> batchs = (List<BatchEntity>) query.execute();

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
		String baseString = "this.batchId==";

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
