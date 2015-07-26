package finance;

import java.util.List;

public interface CreditDAO {
	
	public List<Credit> findAll() throws Exception;
	public void delete(int SerialNo) throws Exception;
	public void save(Credit c) throws Exception;
	public Credit findBySerialNo(int SerialNo) throws Exception;
	public void update(Credit c) throws Exception;
	
}
