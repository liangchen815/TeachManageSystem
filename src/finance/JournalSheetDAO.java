package finance;

import java.util.List;

public interface JournalSheetDAO {
	
	public List<JournalSheet> findAll() throws Exception;
	public void delete(String year , String month) throws Exception;
	public void save(JournalSheet j) throws Exception;
	public JournalSheet findByYM(String year , String month) throws Exception;
	public void update(JournalSheet j) throws Exception;
	
}
