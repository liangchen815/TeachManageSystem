package finance;

import java.util.List;

public interface DepartmentalBudgetDAO {
	
	public List<DepartmentalBudget> findAll() throws Exception;
	public void delete(String year , String month) throws Exception;
	public void save(DepartmentalBudget db) throws Exception;
	public List<DepartmentalBudget> findByYM(String year , String month) throws Exception;
	public DepartmentalBudget findByYM(String year , String month , String department , boolean adjustment) throws Exception;
	public void update(DepartmentalBudget db) throws Exception;
	
}
