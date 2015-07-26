package finance;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitExpenseAccountServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String ApplicationNo=request.getParameter("ApplicationNo");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String Date = df.format(new Date());
		
		String Tno=request.getParameter("Tno");
		String Transaction=request.getParameter("Transaction");
		Double Cost=Double.parseDouble(request.getParameter("Cost"));
		String Comment=request.getParameter("Comment");
		String ExpenseAccount=request.getParameter("ExpenseAccount");
		Double OfficeSupplies=Double.parseDouble(request.getParameter("OfficeSupplies"));
		Double MaterialExpense=Double.parseDouble(request.getParameter("MaterialExpense"));
		Double EquipmentExpense=Double.parseDouble(request.getParameter("EquipmentExpense"));
		Double InformationExpense=Double.parseDouble(request.getParameter("InformationExpense"));
		Double TravellingExpense=Double.parseDouble(request.getParameter("TravellingExpense"));
		Double EntertainmentExpense=Double.parseDouble(request.getParameter("EntertainmentExpense"));
		Double PostExpense=Double.parseDouble(request.getParameter("PostExpense"));
		Double PrintingExpense=Double.parseDouble(request.getParameter("PrintingExpense"));
		Double PageExpense=Double.parseDouble(request.getParameter("PageExpense"));
		Double CommunicationExpense=Double.parseDouble(request.getParameter("CommunicationExpense"));
		Double ConferenceExpense=Double.parseDouble(request.getParameter("ConferenceExpense"));
		Double TrainingExpense=Double.parseDouble(request.getParameter("TrainingExpense"));
		Double PorkingExpense=Double.parseDouble(request.getParameter("PorkingExpense"));
		Double FuelExpense=Double.parseDouble(request.getParameter("FuelExpense"));
		Double UpkeepExpense=Double.parseDouble(request.getParameter("UpkeepExpense"));
		Integer Number=Integer.parseInt(request.getParameter("Number"));
		try
		{
			ReimburseDao dao=new ReimburseDao();
			Application a=new Application();
		//	a.setApplicationNo(ApplicationNo);
			a.setDate(Date);
			a.setTno(Tno);
			a.setTransaction(Transaction);
			a.setCost(Cost);
			a.setExpenseAccount(ExpenseAccount);
			a.setComment(Comment);
			a.setOfficeSupplies(OfficeSupplies);
			a.setMaterialExpense(MaterialExpense);
			a.setEquipmentExpense(EquipmentExpense);
			a.setInformationExpense(InformationExpense);
			a.setTravellingExpense(TravellingExpense);
			a.setEntertainmentExpense(EntertainmentExpense);
			a.setPostExpense(PostExpense);
			a.setPrintingExpense(PrintingExpense);
			a.setPageExpense(PageExpense);
			a.setCommunicationExpense(CommunicationExpense);
			a.setConferenceExpense(ConferenceExpense);
			a.setTrainingExpense(TrainingExpense);
			a.setPorkingExpense(PorkingExpense);
			a.setFuelExpense(FuelExpense);
			a.setUpkeepExpense(UpkeepExpense);
			a.setNumber(Number);
			a.setExamine("未审核");
			dao.save(a);
			response.sendRedirect("/TeachManageSystem/finance/SubmitSuccess.jsp");
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
