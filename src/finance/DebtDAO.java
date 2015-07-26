package finance;

import java.util.List;

public interface DebtDAO {
	
	public List<Debt> findAll() throws Exception;
	public void delete(int SerialNo) throws Exception;
	public void save(Debt d) throws Exception;
	public Debt findBySerialNo(int SerialNo) throws Exception;
	public void update(Debt d) throws Exception;
	
}
