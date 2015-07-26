package finance;

import java.util.List;

public interface ExpenseDAO {
	
	public List<Expense> findAll() throws Exception;
	public void delete(String year , String month) throws Exception;
	public void save(Expense e) throws Exception;
	public Expense findByYM(String year , String month) throws Exception;
	public void update(Expense e) throws Exception;
	
}
