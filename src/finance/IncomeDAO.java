package finance;

import java.util.List;

public interface IncomeDAO {
	
	public List<Income> findAll() throws Exception;
	public void delete(String year , String month) throws Exception;
	public void save(Income i) throws Exception;
	public Income findByYM(String year , String month) throws Exception;
	public void update(Income i) throws Exception;
	
}
